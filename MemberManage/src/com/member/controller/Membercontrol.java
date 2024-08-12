package com.member.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.member.domain.Loginmanage;

public class Membercontrol implements ManageLogin {
	Loginmanage lo = new Loginmanage();
	
	private List<Member> memberList = new ArrayList<>();

	public void choiceM() {
		Scanner input = new Scanner(System.in);
		boolean running = true;

		while (running) {
			System.out.println("*******************************************************");
			System.out.println("\t\t   " + "아이디" + "님 안녕하세요?");
			System.out.println("*******************************************************");
			System.out.println("\t1. 회원 정보 확인하기" + "\t" + "2. 회원 정보 수정하기");
			System.out.println("\t2. 회원 탈퇴" + "\t\t" + "4. 종료");
			System.out.println("*******************************************************");
			System.out.println("메뉴 번호를 선택해주세요.");
			int menu = input.nextInt();

			switch (menu) {
			case 1:
				readMember();
				break;

			case 2:
				updateMember();
				break;

			case 3:
				deleteMember();
				break;

			case 4:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;

			default:

				break;
			}
		}
	}

	@Override
	// 회원 정보 확인하기
	public void readMember() {

		System.out.println("아이디" + "고객 정보: ");

		for (Member member : memberList) {
			if (member.getName().equals(name)) {

				System.out.println("회원번호 " + member.getNum());
				System.out.println("\t이름 " + member.getName());
				System.out.println("\t연락처 " + member.getPhone());
				System.out.println("\t주소 " + member.getAddr());
				break;
			}
		}
	}

	@Override
	// 회원 정보 수정하기
	public void updateMember() {
		// TODO Auto-generated method stub

	}

	@Override
	// 회원 탈퇴
	public void deleteMember() {
		// TODO Auto-generated method stub

	}

	@Override
	// 로그인과 파일 수정하기 위해 파일 읽어옴
	public void readFileMember() {

		try {
			File file = new File("createmember.txt");
			if (!file.exists()) {
				file.createNewFile();
		       }

			FileReader fis = new FileReader(file);

			BufferedReader br = new BufferedReader(fis);
			String str;
			 while((str = br.readLine()) != null) {
				 String[] memberData = str.split(",");
				 int num = Integer.parseInt(memberData[0].trim());
				 String name = memberData[1].trim();
				 String phone = memberData[2].trim();
				 String addr = memberData[3].trim();
				 String pwd = memberData[4].trim();		 
				 
				 memberList.add(new Member(num, name, phone, addr, pwd));
			 }
			 br.close();
			 fis.close();
			 System.out.println("회원 정보 파일을 성공적으로 불러왔습니다.");
		} catch (Exception e) {
			System.out.println("파일을 읽는 동안 오류가 발생했습니다: "+ e.getMessage());
		}
	}

			
//			while ((str = br.readLine()) != null) {
//				 System.out.println(str);
//			}
//			fis.close();
//			// System.out.println("파일 읽기 성공");
//		} catch (Exception e) {
//			System.out.print(e);
//		}
//	}

	@Override
	public void writeFileMember() {
		// TODO Auto-generated method stub

	}

}
