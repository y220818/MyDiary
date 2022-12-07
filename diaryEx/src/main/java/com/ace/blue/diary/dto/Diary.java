package com.ace.blue.diary.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Diary {
	
	private int id;
	private String title;
	private String content;
	private Date date;
	private String weather;
	private String photo_path;
	
	
}
