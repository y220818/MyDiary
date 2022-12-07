package com.ace.blue.diary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ace.blue.diary.dao.DiaryDao;
import com.ace.blue.diary.dto.Diary;
import com.ace.blue.diary.dto.DiaryWriteRequest;
import com.ace.blue.diary.dto.Weather;

@Service
@Transactional
public class DiaryServiceImpl implements DiaryService{
		
	@Autowired(required=false)
	DiaryDao diaryDao;
	
	@Override
	public List<Diary> viewAll() {
		return diaryDao.selectAll();
	}


	@Override
	public List<Weather> getWeatherList() {
		return diaryDao.selectAllWeather();
	}


	@Override
	public void writeDiary(DiaryWriteRequest diaryRequest) {
		diaryDao.insertDiary(diaryRequest);
	}
	
	
}
