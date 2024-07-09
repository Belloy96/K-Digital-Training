package com.belloy.jul082.fruit;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FruitDAO {
	
	@Autowired
	private SqlSession ss;
	
	// getAllFruit // 강사님 답안(메서드 명)
	public void printFruit(HttpServletRequest req) {
		try {
			ss.getMapper(FruitMapper.class).printFruit();
			req.setAttribute("fruits", ss.getMapper(FruitMapper.class).printFruit());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// Spring에서 XML 끌어오는 시스템 : XML AJAX Server (Asynchronous JavaScript And XML)
	//	원래 : 웹페이지 전체를 새로 고쳤음
	//	페이지의 일부분만 서버에서 가지고와서 화면을 변경하는 방식
	
	//		현재] DB에 있는 과일데이터 하나를 표현할 JavaBean(Fruit.java)를 가지고 있는 상태
	//		1. DB에 있는 '과일테이블'을 표현할 또 하나의 JavaBean이 필요!!
	//		2. Spring이 XML로 바꿀 수 있도록
	//		각각의 JavaBean에(Class명 위에) @XmlRootElement Annotation 달기
	//		3. Setter 위에(각각의) @XmlElement Annotation 달기
	//		특정 데이터 => XML형태로 바꾸는 것 : 마샬링(Mashalling)
	
	public Fruits getXML(HttpServletRequest req) {
		List<Fruit> fruits = ss.getMapper(FruitMapper.class).printFruit();
		Fruits fruitss = new Fruits(fruits);
		return fruitss;
	}
	
	public Fruits searchXML(Fruit f, HttpServletRequest req) {
		return new Fruits(ss.getMapper(FruitMapper.class).searchFruit(f)); 
	}
	
}
