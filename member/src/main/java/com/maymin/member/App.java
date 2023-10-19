package com.maymin.member;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 명령어를 통한 회원가입, 정보 수정 프로그램
 * Spring 안 쓴 버전
 * DB연동 X */

public class App {
    public static void main( String[] args ) throws IOException{
    	BufferedReader br =
    			new BufferedReader(new InputStreamReader(System.in)); 
    	
//    	계속 실행될 수 있게 반복문
    	while(true) {
    	System.out.println("명령어를 입력하세요 : ");
    	String command = br.readLine();
//    			 대소문자 구분 없이 
	    	if(command.equalsIgnoreCase("exit")) {
	    		System.out.println("프로그램을 종료합니다.");
	    		break;
    		}
//	    	문자열의 시작값이 new 라면
	    	if(command.startsWith("new ")) {
	    		String[] cmd = command.split(" ");
//	    		원래 5개를 받아야하니까
	    		if(cmd.length != 5) {
	    			printHelp();
	    			return;
	    		}
	    		
	    		RegisterRequest req = new RegisterRequest();
		    	req.setEmail(cmd[1]);
		    	req.setName(cmd[2]);
		    	req.setConfirmPassword(cmd[3]);
		    	req.setConfirmPassword(cmd[4]);
		    	
		    	MemberRegisterService regSvc = new MemberRegisterService();
		    	
		    	// 비밀번호가 맞지 않을 때 !req
		    	if(!req.isPasswordEqualToconfirmPassword()) {
		    		System.out.println("암호와 확인이 맞지 않습니다.\n");
		    		return;
		    	}
		    	else {
		    	regSvc.regist(req);
		    	System.out.println("잘 등록되었습니다.\n");
		    	}
		    	
	    		continue;
	    	}
	    	else if(command.startsWith("change ")) {
	    		continue;
	    	}
    	}
    }
//   1개만 만들어져있어서 재사용할 수 있게
    private static void printHelp() {
    	System.out.println();
    	System.out.println("잘못된 명령어 입니다.");
    	System.out.println("new 이메일 이름 암호 암호확인");
    	System.out.println("change 이메일 현재암호 바꿀암호");
    	System.out.println();
    }
}
