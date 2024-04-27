package com.example.CustomerService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Service;

@Service
public class ReportSevice {

	public String getReport() throws SQLException  {
		
try {
			
            Class.forName("com.mysql.cj.jdbc.Driver");

			
			String url =  "jdbc:mysql://localhost:3306/bankingapp";
			
			Connection con = DriverManager.getConnection(url, "root", "");
			
			Statement stmt = con.createStatement();
			
			
			ResultSet rs = stmt.executeQuery("SELECT `cust_name`,`trn_id`,`operation`,`date`,`Amount` FROM `customer`,`reports` WHERE `customer`.`cust_id`=`reports`.`cust_id`;");
			int trid = 0;
			String custName = "";
			String opr = "";
			String date = "";
			String amt = "";
			            while(rs.next()) {
			            	custName = rs.getString(1);
			            	trid = rs.getInt(2);
			            	opr = rs.getString(3);
			            	date = rs.getString(4);
			            	amt = rs.getString(5);
			           System.out.println("values coming from database \n"+"\n"+custName+trid+opr+date+amt);
			            	return "Customer deatiles \n <br>" + trid + "    "+ custName+ "    " + opr+ "    " + date + "    "+ amt ;
			            }
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       return null;
		
	}

}