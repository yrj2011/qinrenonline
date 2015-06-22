package com.qinrenzaixianweb.web.data;

public class CreateData {
   public static void main(String[] args) {
	   createAddr();
   }
   
   public static void createAddr(){
	  
	   String sql1="insert into addresses(`user_id`,"+
	   "`country_id`,"+
	   "`province_id`,"+
	   "`city_id`,"+
	   "`district_id`,"+
	   "`address`,"+
	   "`zip_code`,"+
	   "`contact`,"+
	   "`mobile_phone`,"+
	   "`zone`,"+
	   "`phone_number`,"+
	   "`ext_number`,"+
	   "`createtime`,"+
	   "`creater`)values(";
	   for(int i=2;i<100;i++){
		 String  sql =sql1+0+
				   ","+i+
				   ","+i+
				   ","+i+
				   ","+i+
				   ","+i+
				   ","+i+
				   ","+i+
				   ","+i+
				   ","+i+
				   ","+i+
				   ","+i+
				   ",sysdate()"+
				   ","+0+");";
		   System.out.println(sql);
				   
	   }
   }
}
