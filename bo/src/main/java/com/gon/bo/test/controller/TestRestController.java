package com.gon.bo.test.controller;

//import com.gon.bo.test.service.TestService;

//Spring 4.0이상은 @Controller와 @ResponseBody 어노테이션을 추가하는 것 대신
//@RestController를 제공한다.
//이를 사용하면 @ResponseBody를 추가할 필요가 없고,
//@ResponseBody 어노테이션은 기본적으로 활성화되어 있더라.
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController { 
	//@Autowired
	//TestService testService; 
	
	@RequestMapping(value="/testValue", method = RequestMethod.GET) 
	public String getTestValue(){ 
		String TestValue = "레스트컨트롤러 테스트"; 
		return TestValue; 
	} 
}

