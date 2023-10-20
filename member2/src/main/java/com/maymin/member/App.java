package com.maymin.member;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.maymin.member.model.RegisterRequest;
import com.maymin.member.service.ChangePasswordService;
import com.maymin.member.service.MemberInfoPrinter;
import com.maymin.member.service.MemberListPrinter;
import com.maymin.member.service.MemberRegisterService;

/* 명령어를 통한 회원가입, 정보 수정 프로그램
 * Spring 버전
 * DB연동 map */

public class App {
	// 여러개 생성되면 안되니까 static으로
	private static ApplicationContext ctx;
	
    public static void main( String[] args ) throws IOException{
    	ctx = new ClassPathXmlApplicationContext("config/applicationContext_config.xml");
    	
    	BufferedReader br =
    			new BufferedReader(new InputStreamReader(System.in)); 
    	
    	//계속 실행될 수 있게 반복문
    	while(true) {
	    	System.out.println("명령어를 입력하세요 : ");
	    	String command = br.readLine();
	    			 //대소문자 구분 없이 
		    	if(command.equalsIgnoreCase("exit")) {
		    		System.out.println("프로그램을 종료합니다.");
		    		break;
	    		}
		    	
		    	//문자열의 시작값이 new 라면. split 으로 나눠서 정보 받기
		    	if(command.startsWith("new ")) {
		    		newCommand(command.split(" "));
		    		continue;
	    		}
		    	else if(command.startsWith("change ")) {
		    		changeCommand(command.split(" "));
		    		continue;
		    	}
		    	// list 만 뒤에 공백 없음 받을 인자값이 없으니까
		    	else if(command.equals("list")) {
		    		listCommand();
		    		continue;
		    	}
		    	else if(command.startsWith("info ")) {
		    		infoCommand(command.split(" "));
		    		continue;
		    	}
		    	printHelp();
	    	}
	    }
    
    	// 새로운 명령어로 새로 가입시키는
    	private static void newCommand(String cmd[]) {
    		//원래 5개를 받아야하니까
    		if(cmd.length != 5) {
    			printHelp();
    			return;
    		}
    		RegisterRequest req = new RegisterRequest();
    		// id 는 cmd[0] 인데 자동으로 증가해줄거라서 생략
	    	req.setEmail(cmd[1]);
	    	req.setName(cmd[2]);
	    	req.setPassword(cmd[3]);
	    	req.setConfirmPassword(cmd[4]);
	    	
	    	MemberRegisterService regSvc =
	    			ctx.getBean("memberRegSvc", MemberRegisterService.class);
	    	
	    	// 비밀번호가 맞지 않을 때 !req
	    	if(!req.isPasswordEqualToconfirmPassword()) {
	    		System.out.println("암호와 확인이 맞지 않습니다.\n");
	    		return;
	    	}
	    	else {
		    	regSvc.regist(req);
		    	System.out.println("잘 등록되었습니다.\n");
	    	}
    	}
    	
    	private static void changeCommand(String cmd[]) {
    		// 총 4 덩어리
    		if(cmd.length != 4) {
    			printHelp();
    			return;
    		}
    		
    		ChangePasswordService changePwdSvc =
    				ctx.getBean("memberPwdSvc",ChangePasswordService.class);
    				
    		// service를 통해 요청이 들어감. [0]번 값은 명령어니까 제외
    		changePwdSvc.changePassword(cmd[1], cmd[2], cmd[3]);
    		System.out.println("암호를 변경했습니다.");
    	}

    	//   1개만 만들어져있어서 재사용할 수 있게
	    private static void printHelp() {
	    	System.out.println();
	    	System.out.println("잘못된 명령어 입니다.");
	    	System.out.println("new 이메일 이름 암호 암호확인");
	    	System.out.println("change 이메일 현재암호 바꿀암호");
	    	System.out.println("info 이메일");
	    	System.out.println();
	    }
	    
	    private static void infoCommand(String cmd[]) {
	    	if(cmd.length != 2) {
    			printHelp();
    			return;
    		}
	    	
	    	MemberInfoPrinter infoPrinter = 
	    			ctx.getBean("infoPrinter", MemberInfoPrinter.class);
	    	
	    	infoPrinter.printMemberInfo(cmd[1]);
	    }
	    
	    // 매개변수가 필요없다
	    private static void listCommand() {
	    	MemberListPrinter listPrinter =
	    			ctx.getBean("listPrinter", MemberListPrinter.class);
	    	
	    	listPrinter.printAll();
	    	}
	}	
