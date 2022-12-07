package com.ace.blue.member.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthInfo {
	
	private String memberId;
	private String name;
	private String email;
}
