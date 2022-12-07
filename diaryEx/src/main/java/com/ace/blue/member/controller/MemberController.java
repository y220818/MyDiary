package com.ace.blue.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ace.blue.member.dto.AuthInfo;
import com.ace.blue.member.dto.MemberDto;
import com.ace.blue.member.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member")
@Slf4j
public class MemberController {
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	MemberService memberService;
	
	@GetMapping("/loginForm")
	public void loginForm() {
		
	}
	
	@PostMapping("/login")
	public String login(MemberDto member, Model model, HttpSession session) {
		
		MemberDto _member = memberService.getMember(member.getMemberID());
		if(_member == null) {
			//throw NoSuchIdException("해당 ID를 사용하는 회원이 없습니다. 회원가입 하셈 ㅋㅋㅋ");
			model.addAttribute("result", "noSuchIdorWrongPassword");
		}else {
			if(bCryptPasswordEncoder.matches(member.getPassword(), _member.getPassword())) {
				AuthInfo authInfo = 
						new AuthInfo(_member.getMemberID(), _member.getName(), _member.getEmail());
				log.info("authInfo >>>>>>>>>>>> " + authInfo);
				session.setAttribute("authInfo", authInfo);
			}else {
				model.addAttribute("result", "noSuchIdorWrongPassword");
			}
		}
		
		return "home";
	}
	
	//회원가입 폼
	@GetMapping("/registForm")
	public void registForm() {
		
	}
	
	//회원가입 - 암호화 처리
	@PostMapping("/regist")
	public String regist(MemberDto member, Model model) {
		log.info("member >>>>>>>>>>> " + member);
		String encodedPassword = bCryptPasswordEncoder.encode(member.getPassword());
		log.info("encodedPassword >>>>>>>>>>> " + encodedPassword);
		member.setPassword(encodedPassword);
		memberService.registMember(member);
		model.addAttribute("result", "true");
		return "home";
	}
}
