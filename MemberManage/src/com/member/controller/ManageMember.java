package com.member.controller;

public abstract class ManageMember {

	abstract boolean createMember(String name, String phone);

	abstract boolean readMember(String name);

	public abstract boolean updateMember(String updateName, String newname, String newphone, String addr, String pwd);

	abstract boolean deleteMember(int num, String pwd);

	abstract boolean fileMember();

	abstract void listMember();


}
