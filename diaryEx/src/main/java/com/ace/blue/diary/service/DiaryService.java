package com.ace.blue.diary.service;

import java.util.List;

import com.ace.blue.diary.dto.Diary;
import com.ace.blue.diary.dto.DiaryWriteRequest;
import com.ace.blue.diary.dto.Weather;

public interface DiaryService {
	
	public List<Diary> viewAll();

	public List<Weather> getWeatherList();

	public void writeDiary(DiaryWriteRequest diaryRequest);
}
