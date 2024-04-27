package com.example.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
	
	@Autowired
	AccountService accService;
	
	@GetMapping(path="/getAccount")
	public String getAccountDetails() {
		return accService.getAccounts();
	}
	
	@PostMapping(path="/saveAccount")
	public String saveAccount(@RequestBody Account acctObj) {
		return "saved"+acctObj.getAcctdesc();
	
}
}