package com.ace.blue.diary.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiaryWriteRequest {
	
	private String title;
	private String content;
	private int weather_id;
}
