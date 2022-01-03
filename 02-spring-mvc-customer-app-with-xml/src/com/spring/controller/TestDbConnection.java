package com.spring.controller;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestDbConnection {
	
	@RequestMapping("/testdb")
	@ResponseBody
	public String testDb() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_customer_tracker", "root", "1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(connection);
		return "hello";
	}
}
