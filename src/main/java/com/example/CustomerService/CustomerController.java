package com.example.CustomerService;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService custservice;

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping(path="/getCust")
	public String getCustDeatiles(@RequestParam String custname) {
		
		try {
			return custservice.getCust(custname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "No such customer";
		}
	}
		
	  
	
	@GetMapping("/addCust")
	public String addCustDeatiles(@RequestParam int cid,@RequestParam String custname,@RequestParam int acid) {
		
		try {
			return custservice.addCust(cid,custname,acid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Duplicate entry check values!";
		}
		
	}

	@GetMapping("/delCust")
	public String deleteCust(@RequestParam int cid) {
		try {
			return custservice.deleteCustomer(cid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "No such customer!";
		}
		
	}
	
	@GetMapping("/updateCust")
	public String updateCusto(@RequestParam int cid,String cname) {
		try {
			return custservice.updateCustomer(cid,cname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Customer not exist";
		}
		
		
	}
	
	@GetMapping("/getAccc")
	public String getAccdea()
	{
	//return custservice.getDeaForAcc();
		return "account deatiles";
	}
	
}
