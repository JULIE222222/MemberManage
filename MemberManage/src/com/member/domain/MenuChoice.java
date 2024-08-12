package com.member.domain;

import java.util.Scanner;

import com.member.controller.Manage;

public class MenuChoice {

	Manage man = new Manage();

	public void choice() {
		Scanner input = new Scanner(System.in);
		boolean running = true; // 반복을 제어하기 위한 변수

		while (running) {// 사용자가 원할 때까지 반복
			System.out.println("*******************************************************");
			System.out.println("\t\t     회원 관리 프로그램");
			System.out.println("*******************************************************");
			System.out.println("  1. 고객 정보 등록하기" + "\t" + " 2. 고객 정보 조회하기");
			System.out.println("  3. 고객 정보 수정하기" + "\t" + " 4. 고객 정보 삭제하기");
			System.out.println("  5. 고객 정보 목록보기" + "\t" + " 6. 고객 정보 파일출력");
			System.out.println("  7. 종료");
			System.out.println("*******************************************************");
			System.out.print("메뉴 번호를 선택해주세요: ");
			int menu = input.nextInt();
			System.out.println();

			switch (menu) {
			case 1:
				System.out.println("<고객 정보 등록하기>");
				man.createMember(null, null);
				break;
				
			case 2:
				System.out.println("<고객 정보 조회하기>");
				System.out.print("조회할 회원의 이름을 입력하세요: ");
				String inname = input.next();
				man.readMember(inname);
				System.out.println();
				break;
				
			case 3:
				System.out.println("<고객 정보 수정하기>");
				System.out.println("수정할 회원의 이름을 입력하세요: ");
				String updateName = input.next();

				System.out.println(updateName + "회원의 이름을 수정하세요: ");
				String newname = input.next();

				System.out.println(updateName + "회원의 연락처를 수정하세요: ");
				String newphone = input.next();

				System.out.println(updateName + "회원의 주소를 입력하세요: ");
				String addr = input.next();

				System.out.println(updateName + "회원의 비밀번호를 입력하세요: ");
				String pwd = input.next();

				man.updateMember(updateName, newname, newphone, addr, pwd);

				System.out.println();
				break;

			case 4:
				System.out.println("<고객 정보 삭제하기>");
				
				System.out.print("삭제할 회원의 번호를 입력하세요: ");
				int delNum = input.nextInt();
				System.out.print("비밀번호를 입력하세요: ");
				String delPwd = input.next();
				man.deleteMember(delNum, delPwd);
				System.out.println();
				break;

			case 5:
				System.out.println("<고객 정보 목록보기>");
				
				man.listMember();
				System.out.println();
				break;

			case 6:
				System.out.println("<고객 정보 파일출력>");
				
				man.fileMember();
				System.out.println();
				break;

			case 7:
				System.out.println("프로그램을 종료합니다.");
				
				System.exit(0);
				break;

			default:
				System.out.println("잘못된 메뉴 번호입니다.");
				break;

			}
		}
		input.close();
	}

}
