package com.ace.blue.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ace.blue.member.dto.MemberDto;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class MemberDao {
	
	JdbcTemplate jdbcTemplate;
	
	public MemberDao(HikariDataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private RowMapper<MemberDto> memRowMapper = new RowMapper<MemberDto>() {
		@Override
		public MemberDto mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			MemberDto member = new MemberDto(rs.getString("memberId"),
					rs.getString("PASSWORD"),
					rs.getString("NAME"),
					rs.getString("EMAIL"));
			return member;
		}
	};
	
	public void insert(MemberDto member) {
		String sql = "insert into member(memberID, password, name, email) values(?,?,?,?)";
		jdbcTemplate.update(sql, member.getMemberID(), member.getPassword(), 
				member.getName(), member.getEmail());
		
	}

	public MemberDto selectOne(String memberId) {
		String sql = "select * from member where memberId = ?";
		List<MemberDto> memberList = jdbcTemplate.query(sql, memRowMapper, memberId);
		log.info("member >>>>>>>> " + memberList.get(0));
		return memberList.isEmpty() ? null : memberList.get(0);
	}

}
