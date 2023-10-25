package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import model.User;

@Controller
public class SecondController {
	@RequestMapping("/first") /* first란 요청이들어오면 아래 메서드를 실행시켜라 */
	public String firstPage() {
		return "/WEB-INF/views/first.jsp";
	}
	
	@RequestMapping("/second") /* 그냥 페이지 이동이 아니라 param도 같이 전달 */
	public ModelAndView secondPage(HttpServletRequest req) {
		/* request 없으면 만들어주기 */
		String p1 = req.getParameter("p1");
		String p2 = req.getParameter("p2");
		
		//// return "/WEB-INF/views/first.jsp"; 페이지 이동은 하지만 데이터를 가지고 못 간다 
		
		ModelAndView mv = new ModelAndView("/WEB-INF/views/second.jsp");
		/* request.setAttribute() 랑 똑같은 코드 */
		mv.addObject("param1", p1);
		mv.addObject("param2", p2);
		
		return mv;
	}
	
	//// @RequestMapping(value="/third", method=RequestMethod.POST)
	@PostMapping("/third") 		/* 타입을 지정해주면 넘어오면서 자동 형변환 */
	public String thirdPage(
			@RequestParam String name, 
			@RequestParam("age") int nai,	/* 넘어오는 이름과 변수 이름이 다를 때 */
			@RequestParam double point) {
		System.out.println(name + ", " + nai + ", " + point);
		return "/WEB-INF/views/third.jsp";
	}
	
	/*
	@GetMapping("/fourth")
	public String fourthPage(String name, int age, double point, 
			Model model) {
		//// 원초적 방법
		User dto = new User();
		dto.setName(name);
		dto.setAge(age);
		dto.setPoint(point);
		
		model.addAttribute("user", dto);
		
		return "/WEB-INF/views/fourth.jsp";
	*/
	
	@GetMapping("/fourth")		/* ModelAttribute는 가급적 생략하지 않기. 헷갈릴 수 있음 */
	public ModelAndView fourthPage(@ModelAttribute User dto, 
			@RequestParam String chk) {
		
		/* 모델에 값 넣고 view 지정해주는것을 합져준 코드 */
		ModelAndView mv = new ModelAndView("/WEB-INF/views/fourth.jsp");
		mv.addObject("user", dto);
		System.out.println("check : " + chk);
		
		return mv;
	}
	@GetMapping("/fifth")
	public ModelAndView fifthPage() {
		List list = new ArrayList();
		list.add("삼계탕");
		list.add("반계탕");
		list.add("추어탕");
		list.add("갈비탕");
		
		/* 키도 문자열 값도 문자열 */
		Map map = new HashMap<String, String>();
		map.put("f1", "사과"); /* 키 값(f1,f2,f3)으로 출력 */
		map.put("f2", "포도");
		map.put("f3", "수박");
		
		/* map + list 더 복잡한 데이터 */
		List listDay = new ArrayList<String>();
		listDay.add("월요일");
		listDay.add("화요일");
		listDay.add("수요일");
		listDay.add("목요일");
		
		/* {day : [월,화,수,목]} 키 하나에 값 여러개 */
		Map mapDay = new HashMap<String, List>();
		mapDay.put("day", listDay);
		
		ModelAndView mv = new ModelAndView("/WEB-INF/views/fifth.jsp");
		mv.addObject("tang", list);
		mv.addAllObjects(map); 	/* 모든것을 저장해주자 */
		mv.addAllObjects(mapDay);
				
		return mv;
	}
}
