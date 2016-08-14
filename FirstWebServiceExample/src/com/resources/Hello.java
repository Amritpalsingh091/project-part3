package com.resources;




import java.io.IOException;
import java.util.Calendar;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Path("Part2")
public class Hello
{
	
	
	@GET
	@Path("extract&{GPA}")
	@Produces("text/json")
	public String getJSONFile(@PathParam("GPA")Double grade1)throws Exception, IOException{
		

		String json = FileReader.loadFileIntoString("Json/August.json","utf-8");
		JSONArray Firstparse = JSONArray.fromObject(json);
		String hey="";
		
		for(int i = 0;i<Firstparse.size();i++){
			JSONObject GPA1 = Firstparse.getJSONObject(i);
			
			 double grade = GPA1.getDouble("GPA");
			//System.out.println(grade);
			 if(grade>grade1){
				 double finalgrades = grade;
				 //System.out.println(finalgrades);	
				 JSONObject info =new JSONObject();
				 hey = Firstparse.toString();
				 //info.accumulate("id", GPA1.getString("Id"));
				 // info.accumulate("firstname", GPA1.getString("First_Name"));
				 //info.accumulate("lastname", GPA1.getString("Last_Name"));
				 //info.accumulate("dob", GPA1.getString("DOB"));
				 System.out.println(hey);
				 
				 
				
			 }
			
		}
		 return hey;

	}

	@GET
	@Path("years&{firstName}&{lastName}&{year}&{month}&{day}")
	@Produces("text/json")
	public String getAgeInYears(@PathParam("firstName")String firstName,@PathParam("lastName")String lastName,@PathParam("year") int year,@PathParam("month") int month,@PathParam("day") int day) {
		Calendar now = Calendar.getInstance();
		 int y = now.get(Calendar.YEAR);
		 int ageInYears = y-year;
		

		  
		 

		 

		 

		  return age(firstName,lastName,ageInYears,"ageIn").toString();


		
		
		
	}
	@GET
	@Path("months&{firstName}&{lastName}&{year}&{month}&{day}")
	 @Produces("text/json")
	public String getAgeInMonths(@PathParam("firstName")String firstName,@PathParam("lastName")String lastName,@PathParam("year") int year,@PathParam("month") int month,@PathParam("day") int day) {
		Calendar now = Calendar.getInstance();
		 int y = now.get(Calendar.YEAR);
		 
		 int ageInYears = y-year;
		
	int ageInMonths = 12*ageInYears - month;
	return age(firstName,lastName,ageInMonths,"ageIn").toString();

		
		
		
	}
	@GET
	@Path("days&{firstName}&{lastName}&{year}&{month}&{day}")
	 @Produces("text/json")
	public String getAgeInDays(@PathParam("firstName")String firstName,@PathParam("lastName")String lastName,@PathParam("year") int year,@PathParam("month") int month,@PathParam("day") int day) {
		Calendar now = Calendar.getInstance();
		 int y = now.get(Calendar.YEAR);
		 
		 int ageInYears = y-year;

	int ageInDays = (ageInYears*365)-(month*30)+(30-day);
	return age(firstName,lastName,ageInDays,"ageIn").toString();
		 

		 

		 

		  

		
		
		
	}

	public JSONObject age(String firstName,String lastName,int age,String ageIn){
		JSONObject DOB = new JSONObject();

		  DOB.accumulate("FirstName", firstName);

		  DOB.accumulate("LastName", lastName);

		  DOB.accumulate(ageIn,age);
	return DOB;
	}

}






  


