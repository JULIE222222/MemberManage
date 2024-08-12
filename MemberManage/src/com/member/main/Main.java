package com.member.main;

import com.member.controller.Membercontrol;
import com.member.domain.Loginmanage;
import com.member.domain.MenuChoice;


public class Main {

	public static void main(String[] args) {
		
		
		Membercontrol control = new Membercontrol();
		control.readFileMember();

		Loginmanage lo = new Loginmanage();
		lo.login("admin", "admin");
		
		
		MenuChoice ch = new MenuChoice();
		ch.choice();

	
		
	}

}



