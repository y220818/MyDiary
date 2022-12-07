package com.ace.blue.diary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ace.blue.diary.dto.Diary;
import com.ace.blue.diary.dto.Weather;
import com.ace.blue.diary.service.DiaryService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/diary")
@Slf4j
public class DiaryController {
	
	@Autowired
	DiaryService diaryService;
	
	@GetMapping("/viewAll")
	public String viewMembers(Model model) {
		List<Diary> list = diaryService.viewAll();
		System.out.println(list);
		model.addAttribute("list", list);
		return "diary/viewAllDiary";
	}
	
	@GetMapping("/write")
	public String write(Model model) {
		List<Weather> list = diaryService.getWeatherList();
		log.info("list>>>> " + list);
		model.addAttribute("list", list);
		return "diary/writeForm";
	}
	
	@PostMapping("/write")
	//public String write(DiaryWriteRequest diaryRequest) {
		public String write(@RequestParam String title) {
//		log.info("diaryRequest>>>> " + diaryRequest);
		log.info("title>>>> " + title);
//		diaryService.writeDiary(diaryRequest);
		
		return "redirect:/diary/viewAll";
	}
	
}
