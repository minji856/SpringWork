package io.acorn;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
/*
@Getter
@Setter
// Lombok 실행 테스트 
public class LombokTest {
	private String hello;
	private int count;
	
	public static void main(String[] args) {
		LombokTest test = new LombokTest();
		test.setHello("안녕하세요");
		test.setCount(10);
		
		System.out.println(test.getHello());
		System.out.println(test.getCount());
	}
}
*/

// 생성자를 통해서 자동 주입 받을 때
@Getter
@RequiredArgsConstructor
public class LombokTest {
//	상수로 지정해줘야한다
	private final String hello;
	private final int count;
	
	public static void main(String[] args) {
		LombokTest test = new LombokTest("안녕하세요", 100);
		
		System.out.println(test.getHello());
		System.out.println(test.getCount());
	}
}