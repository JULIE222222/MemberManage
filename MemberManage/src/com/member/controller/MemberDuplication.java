package com.member.controller;

import java.util.List;

public class MemberDuplication {
	
	public static boolean isDuplicateName(String name, List<Member> memberList) {

		for (Member member : memberList) {
			if (member.getName().equals(name)) {
				
				System.out.println("이미 존재하는 이름입니다. 다른 이름으로 등록해주세요.");
				return true; // 중복된 이름이 존재하면 true 반환
			}
		}
		return false; // 중복된 이름이 없으면 false 반환
	}

}
