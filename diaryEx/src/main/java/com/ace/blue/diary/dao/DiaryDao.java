package com.ace.blue.diary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ace.blue.diary.dto.Diary;
import com.ace.blue.diary.dto.DiaryWriteRequest;
import com.ace.blue.diary.dto.Weather;
import com.zaxxer.hikari.HikariDataSource;

@Repository
public class DiaryDao {
	
	//@Autowired
	private JdbcTemplate jdbcTemplate;

	public DiaryDao(HikariDataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Diary> selectAll() {
		String sql = "select d.diary_id, d.date, w.weather, d.title, d.content, d.photo_path " + 
				"from diary d, weather w  " + 
				"where d.weather_id = w.weather_id  " + 
				"order by date desc";
		List<Diary> results = jdbcTemplate.query(sql,
				(ResultSet rs, int rowNum) -> {
					Diary diary = new Diary(
							rs.getInt("diary_id"),
							rs.getString("title"),
							rs.getString("content"),
							rs.getDate("date"),
							rs.getString("weather"),
							rs.getString("photo_path"));
					
					return diary;
				});
		return results;
	}

	public List<Weather> selectAllWeather() {
		String sql = "select * from weather order by weather_id";
		List<Weather> results = jdbcTemplate.query(sql,
				(ResultSet rs, int rowNum) -> {
					Weather weather = new Weather(
							rs.getInt("weather_id"),
							rs.getString("weather"));
					
					return weather;
				});
		return results;
	}

	public void insertDiary(DiaryWriteRequest diaryRequest) {
		String sql = "insert into diary(date, title, content, weather_id, photo_path) values(curdate(), ?, ?, ?, 'upload/0.jpg')";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				// 파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
				PreparedStatement pstmt = con.prepareStatement(sql, new String[] { "ID" });
				// 인덱스 파라미터 값 설정
				pstmt.setString(1, diaryRequest.getTitle());
				pstmt.setString(2, diaryRequest.getContent());
				pstmt.setInt(3, diaryRequest.getWeather_id());
				// 생성한 PreparedStatement 객체 리턴
				return pstmt;
			}
		}
		, keyHolder);
		Number keyValue = keyHolder.getKey();
		System.out.println("keyValue >>>> " + keyValue);
	}
}
