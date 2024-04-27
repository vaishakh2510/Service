package com.example.CustomerService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {

	@Autowired
	private RestTemplate restTemplate;
	
	public String getCust(String custname) throws SQLException {
		
try {
			
            Class.forName("com.mysql.cj.jdbc.Driver");

			
			String url =  "jdbc:mysql://localhost:3306/bankingapp";
			
			Connection con = DriverManager.getConnection(url, "root", "");
			
			Statement stmt = con.createStatement();
			
			
			
			ResultSet rs = stmt.executeQuery("select `customer`.`id`,`custname`,`account_name`,`account_desc` from `account`,`customer` where `customer`.`accid`=`account`.`account_id` and `custname`=\""+custname+"\"");
			
			int id = 0;
			String custName = "";
			String acname = "";
			String acdes = "";
			
			            while(rs.next()) {
			            	custName = rs.getString(2);
			            	id = rs.getInt(1);
			            	acname = rs.getString(3);
			            	acdes = rs.getString(4);
			            	
			            	System.out.println(acname);
			        
			            	return "Customer deatiles \n <br>" + id + "    "+ custName+ "    " + acname+ "    " + acdes + "    " ;
			            }
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

  
  public String addCust(int cid, String custname, int acid) throws SQLException {
		
try {
			
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url =  "jdbc:mysql://localhost:3306/bankingapp";
			Connection con = DriverManager.getConnection(url, "root", "");
			Statement stmt = con.createStatement();
			
			
			int rs = stmt.executeUpdate("INSERT INTO `customer` VALUES("+cid+",\""+custname+"\","+acid+")");
			
			return "Customer added successfully!";
			
			
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				return null;
	}


public String deleteCustomer(int cid) throws SQLException {
	
try {
		
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url =  "jdbc:mysql://localhost:3306/bankingapp";
		Connection con = DriverManager.getConnection(url, "root", "");
		Statement stmt = con.createStatement();
		
		
		int rs = stmt.executeUpdate("DELETE FROM `customer` WHERE `id`="+cid);
		
		return "Customer deleted!";
		
		
		

	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	return null;
}


public String updateCustomer(int cid, String cname) throws SQLException {
	
try {
		
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url =  "jdbc:mysql://localhost:3306/bankingapp";
		Connection con = DriverManager.getConnection(url, "root", "");
		Statement stmt = con.createStatement();
		
		
		int rs = stmt.executeUpdate("UPDATE `customer` SET `custname`=\""+cname+"\" WHERE `id`="+cid);
		
		return "Customer Updated";
		
		
		

	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}


public String getDeaForAcc() {
	String response = restTemplate.getForObject("http://localhost:8080/getAccount",String.class);
	return response;
}

}
