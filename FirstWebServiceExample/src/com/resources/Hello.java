package com.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("zied")
public class Hello {

	@GET
	@Path("Amrit&{Firstname}&{Lastname}")
	@Produces("text/plain")
	public String getHello(@PathParam("Firstname") String a, @PathParam("Lastname") String b){
		return "Hello" + ""+ a+ "" +b;
	}
	
	
	@GET
	@Path("sum&{a}&{b}")
	@Produces("text/plain")
	public String getSum(@PathParam("a") int a,@PathParam("b") int b){
		return String.valueOf(a+b);
	}
	
	@GET
	@Path("multiply&{a}&{b}")
	@Produces("text/plain")
	public String getMul(@PathParam("a") int a,@PathParam("b") int b){
		return String.valueOf(a*b);
	}
	
	@GET
	@Path("sub&{a}&{b}")
	@Produces("text/plain")
	public String getSub(@PathParam("a") int a,@PathParam("b") int b){
		return String.valueOf(a-b);
	}

	
}
