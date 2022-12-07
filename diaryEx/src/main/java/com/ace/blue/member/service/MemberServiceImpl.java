package com.ace.blue.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ace.blue.member.dao.MemberDao;
import com.ace.blue.member.dto.MemberDto;

@Service
@Transactional
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberDao memberDao;
	
	@Override
	public void registMember(MemberDto member) {
		memberDao.insert(member);
	}

	@Override
	public MemberDto getMember(String memberId) {
		
		return memberDao.selectOne(memberId);
	}

}
