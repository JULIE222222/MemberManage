package com.member.controller;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manage extends ManageMember {

	private List<Member> memberList = new ArrayList<>();// 회원정보 저장할 리스트
	Scanner input = new Scanner(System.in);
	private int num = 1; // 회원 번호를 자동으로 증가시키기 위한 변수

	public boolean createMember(String name, String phone) {
		try {

			boolean continueLoop = false; // 반복 여부를 결정하는 변수

			do {
				System.out.print("등록하실 회원의 이름을 입력하세요: ");
				name = input.next();
				
				if (MemberDuplication.isDuplicateName(name, memberList)) {
	                continue; // 중복된 이름이 있으면 다시 입력 받음
	            }

				System.out.print("등록하실 회원의 연락처를 입력하세요: ");
				phone = input.next();

				System.out.print("등록하실 회원의 주소를 입력하세요: ");
				String addr = input.next();

				System.out.print("등록하실 회원의 비밀번호를 입력하세요: ");
				String pwd = input.next();

				Member members = new Member(num++, name, phone, addr, pwd);
				memberList.add(members);

				System.out.println("등록이 완료되었습니다 " + "---" + " 총 회원수: " + memberList.size());

				// 회원이 추가된 후에 리스트의 크기를 출력하여 확인
				System.out.println();

				// 사용자에게 추가 등록 여부를 물어보기
				System.out.print("계속해서 회원을 등록하시겠습니까? (Y/N): ");
				String choice = input.next();
				System.out.println();

				// 사용자가 Y를 입력하면 반복을 계속하고, 그 외의 경우에는 종료
				continueLoop = choice.equalsIgnoreCase("Y");
			} while (continueLoop);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean readMember(String name) {

		boolean found = false; // 조회한 멤버를 찾았는지 여부를 나타내는 변수
		// 회원 리스트를 순회하며 입력받은 이름에 해당하는 회원을 찾음
		for (Member member : memberList) {
			if (member.getName().equals(name)) { // 입력받은 이름과 저장된 이름이 일치할 경우
				found = true;
				// 해당 회원의 번호 출력
				System.out.print("번호: " + member.getNum());
				System.out.print("\t이름: " + member.getName());
				System.out.print("\t전화번호: " + member.getPhone());
				System.out.print("\t주소: " + member.getAddr());
				System.out.println();
				break;
			}
		}
		if (!found) {
			System.out.println("해당 회원을 찾을 수 없습니다.");
			System.out.println();
		}
		return found;
	}

	@Override
	public boolean updateMember(String updateName, String newname, String newphone, String addr, String pwd) {
		boolean found = false;

		for (Member member : memberList) {
			if (member.getName().equals(updateName)) {
				if (!member.getPwd().equals(pwd)) {
					System.out.println("해당 회원을 찾을 수 없습니다.");
					System.out.println();
					return false;
				}
				found = true;

				member.setName(newname);
				member.setPhone(newphone);
				member.setAddr(addr);
				member.setPwd(pwd);
				System.out.println("회원 정보가 성공적으로 수정되었습니다.");
				break;
			}
		}
		return found;
	}

	@Override
	public boolean deleteMember(int num, String pwd) {
		boolean found = false;

		for (Member member : memberList) {
			if (member.getNum() == num) {
				if (!member.getPwd().equals(pwd)) {
					System.out.println("비밀번호가 맞지 않습니다.");
					System.out.println();
					return false;
				}
				memberList.remove(member);
				System.out.println("회원 정보가 성공적으로 삭제되었습니다." + " --- " + " 총 회원수: " + memberList.size());
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("해당 번호의 회원을 찾을 수 없습니다.");
			System.out.println();
		}
		return found;
	}

	@Override
	public boolean fileMember() {

		File file = new File("createmember.txt");
		try {

			if (!file.exists())
				file.createNewFile();

			FileWriter fw = new FileWriter(file, true);

			for (Member member : memberList) {
				fw.write("번호: " + member.getNum() + "\t");
				fw.write("이름: " + member.getName() + "\t");
				fw.write("전화번호: " + member.getPhone() + "\t");
				fw.write("주소: " + member.getAddr() + "\t");
				fw.write("\n");
			}

//		    fw.write("번호: " + num + "\t");
//			fw.write("이름: " + name + " ");
//			fw.write("전화번호: " + phone + " ");
//			fw.write("주소: " + addr + " ");

			fw.close();
			System.out.println("회원 정보가 파일에 성공적으로 저장되었습니다.");
			return true;

		} catch (Exception e) {
			System.out.println("파일 저장 중 오류가 발생했습니다: " + e.getMessage());
		}

		return false;
	}

	@Override
	public void listMember() {
		if (memberList.isEmpty()) { // memberList가 비어있는지 확인하는 용도
			System.out.println("등록된 회원이 없습니다.");
		} else {
			// 리스트에 회원 정보가 있으면 각 회원의 정보를 출력
			for (Member member : memberList) {
				System.out.print("번호: " + member.getNum());
				System.out.print("  이름: " + member.getName());
				System.out.print("  전화번호: " + member.getPhone());
				System.out.println();
			}
		}
	}
}
