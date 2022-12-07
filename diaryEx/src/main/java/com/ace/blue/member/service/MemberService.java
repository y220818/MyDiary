package com.ace.blue.member.service;

import com.ace.blue.member.dto.MemberDto;

public interface MemberService {

	void registMember(MemberDto member);

	MemberDto getMember(String string);

}
