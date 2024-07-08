package com.belloy.jul082.fruit;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FruitDAO {
	
	@Autowired
	private SqlSession ss;
	
	public void printFruit(HttpServletRequest req) {
		try {
			ss.getMapper(FruitMapper.class).printFruit();
			req.setAttribute("fruits", ss.getMapper(FruitMapper.class).printFruit());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
