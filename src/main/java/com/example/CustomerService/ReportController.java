package com.example.CustomerService;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {
	
	@Autowired
	ReportSevice repService;
	
	@GetMapping(path="/getReport")
	public String getAccountDetails() {
		try {
			return repService.getReport();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "rccontrl";
	}
	
	
}
