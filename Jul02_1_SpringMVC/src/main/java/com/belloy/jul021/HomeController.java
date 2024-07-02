package com.belloy.jul021;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "home";
		
		// home.jsp가 불러와지는 이유는
		// servlet-context.xml의 beans에서
		// prefix인 "/WEB-INF/views/" 와
		// 중간 경로인 "home"과
		// suffix인 ".jsp"가 합쳐져서
		// /WEB-INF/views/home.jsp 라는 views 파일 경로로 이동해서
		// 클라이언트에게 응답을 해주는 형태
		
		// @ : Annotation
		// 사전적 의미 : '주석'
		// 		코드 사이에 주석처럼 쓰이면서 기능을 수행하도록 하는 기술
		//		- 코드 작성 문법 에러를 체크하도록 정보를 제공
		//		- 개발 툴이 코드를 자동으로 생성할 수 있도록 도와줌
		// 		- 실행 시에 특정한 기능을 수행하도록 도와줌
		
		// 종류
		//	1. @Bean : 개발자가 직업 제어가 불가능한 외부 라이브러리 등을
		//		Bean으로 만들 때 사용
		//	2. @Autowired : 속성, setter, 생성자에서 사용하며, 
		//		타입에 따라서 Bean을 주입해준다. (-> 별표)
		//	3. @Controller : Spring의 Controller
		//		View(화면, .jsp)를 return해주는게 목적! (-> 별표)
		//	4. @RestController : Controller 중에서 View쪽으로 응답하지 않는 Controller
		//		data(xml, json)들을 return해주는게 목적!
		//		Spring 4.x.x에서부터 제공(따라서 현재 3.9.0버전을 쓰고 있어서 만들어지지는 않을 것. 참고)
		//	5. @ResponseBody : 
		//		자바 객체를 HTTP 요청의 body 내용으로 매핑을 하는 역할
		//		RestController : Controller + ResponseBody (-> 별표)
		//	6. @Service : 비지니스 로직을 수행하는 Class를 나타낼 때
		//		비지니스 로직(Business Logic) :
		//			사용자 눈에는 안보이지만, 사용자가 원하는 결과물을
		//			올바르게 도출할 수 있도록 짜여진 코드(ex. M에서 만든 기능) (-> 별표)
		//	7. @XmlRootElement / @XmlElement
		//		OXM(Object XML Mapping)을 하기 위해 사용
		//		특정 데이터를 XML 형태로 만들어 주는 것
		//			: 마샬링 (Mashalling)
		//		cf) XML 데이터를 특정 데이터로 만들어 주는 것
		//			: 언마샬링 (Unmashalling)
		//		XmlRootElement : Javabean 객체의 Class명 위에 명시 O	
		//		XmlElement : Javabean 객체의 setter에 명시 O
		//	8. @RequestMapping
		//		: 요청에 따라 어떤 Controller, 어떤 Method가 처리될 지 (-> 별표)
		//			매핑하기 위해서 사용
		//			value : 요청받을 주소(url)을 설정
		//			method : 어떤 요청으로 받을지 설정
		//				(GET, POST, PUT, DELETE, FETCH)
		//			W3C(표준 개발 기구, World Wide Web Consortium)에서
		//				PUT, DELETE, FETCH ... => 과연 유용한가 ? (잘 안쓰임)
		//	9. @RequestParam : 요청 파라미터 설정
		
		
		
	}
	
}



