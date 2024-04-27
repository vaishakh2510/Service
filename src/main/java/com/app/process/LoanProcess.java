package com.app.process;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanProcess {

	
	@GetMapping(path="/getLoan")
	public String loan() {
		return "Loan";
}
}