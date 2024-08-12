package com.member.controller;

import java.util.ArrayList;
import java.util.List;

public class Admin {

	// 클래스는 관리자 정보를 생성하는 클래스
	public Member createAdmin() { // 메서드는 관리자 정보를 생성하고 반환
		List<Member> mem = new ArrayList<>();// Member 객체를 담을 ArrayList를 생성
		mem.add(new Member(1, "admin", "01011112222", "관리자주소", "admin"));
		// Member 객체를 생성하고 리스트에 추가합니다. 이 때, 생성자를 이용하여 관리자의 정보를 전달합니다. 관리자의 정보에는 아이디,
		// 전화번호, 주소, 비밀번호가 있습니다.
		return mem.get(0);// 추가된 관리자 정보를 반환합니다. 리스트의 첫 번째 요소가 관리자 정보이므로 인덱스 0을 사용하여 반환
	}
}
// 코드는 관리자 정보를 생성하고 관리자 정보를 담은 Member 객체를 반환

//	private List<Member> members;
//	public void createAdmin(int num) {
//		
//		List<Member> members = new ArrayList<>();
//		members.add(new Member(num, "admin", 01011112222, "관리자주소", "admin"));
//
//		// mem.add(new Member(1, name1,phone1,addr,pwd));
//		// Member m2 = new Member(num, "admin", 01011112222 , "경기도 용인", "admin"); //자료형을
//		// Member클래스 내부의 생성자와 맞춰줘야함!!!
//
//	}
//
//	public void add(Member member) {
//		this.members.add(member);
//	}
//
//}
