package com.member.domain;

import java.util.Scanner;

public class Loginmanage {

	public String login(String name, String pwd) {
		Scanner input = new Scanner(System.in);
		int attemptCount = 0;

		while (attemptCount < 3) {

			System.out.println("*******************************************************");
			System.out.println("\t\t\t 로그인 \t\t\t");
			System.out.println("*******************************************************");

			System.out.print("아이디를 입력하세요: ");
			String id = input.nextLine();

			if (!name.equals(id)) {
				System.out.println("일치하는 아이디가 없습니다.");
				continue; // 다음 반복으로 넘어감
			}

			System.out.print("비밀번호를 입력하세요: ");
			String inpwd = input.nextLine();

			if(name.equals("admin")&&inpwd.equals("admin")) {
				System.out.println("관리자 로그인 성공!");
				System.out.println();
				return "admin";
			}
			else if (name.equals(name)&& inpwd.equals(pwd)) {
				System.out.println("회원 로그인 성공!");
				return "member";
			}
			
			
//			if(name.equals(name) && inpwd.equals(pwd)) {
//				System.out.println("회원 로그인 성공!");}
//			
//			else if (name.equals("admin") && inpwd.equals("admin")) {
//				System.out.println("로그인 성공!");
//				System.out.println();
//
//				return false; // 로그인 성공 시 루프 종료
//
//			}
			else {
				System.out.println("비밀번호가 틀렸습니다.");
				attemptCount++; // 로그인 시도 횟수 증가
				System.out.println("남은 시도 횟수: " + (3 - attemptCount));
			}
		}
			
		System.out.println("로그인 시도 횟수 초과. 프로그램을 종료합니다.");
		input.close();

		return "0";
	}

}
