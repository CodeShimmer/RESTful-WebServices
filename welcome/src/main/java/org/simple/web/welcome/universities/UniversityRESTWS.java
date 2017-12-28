package org.simple.web.welcome.universities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;





@Path("/university")
public class UniversityRESTWS {

	@GET
	@Path("{studentRollNo1}/{studentRollNo2}")
	@Produces(MediaType.TEXT_PLAIN)

	public String getStudentInfo(@PathParam("studentRollNo1") String studentRollNo1,
			@PathParam("studentRollNo2") String studentRollNo2) {
		return "You sent me two roll numbers using pathParam annotation ------->" + studentRollNo1 + " and "
				+ studentRollNo2;
	}

	/*
	 * http://localhost:8083/welcome/webapi/university/23/57
	 */
	/*
	 * @GET
	 * 
	 * @Produces(MediaType.TEXT_PLAIN) public String
	 * getStudentparamInfo(@QueryParam("studentRollNo1") String studentRollNo1,
	 * 
	 * @QueryParam("studentRollNo2") String studentRollNo2) { return
	 * "You sent me two roll numbers using pathParam annotation ------->" +
	 * studentRollNo1 + " and " + studentRollNo2; }
	 */
	/*
	 * http://localhost:8083/welcome/webapi/university?studentRollNo1=23&
	 * studentRollNo2=57
	 */

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getStudentparamInfo1(@MatrixParam("studentRollNo1") String studentRollNo1,
			@MatrixParam("studentRollNo2") String studentRollNo2) {
		return "You sent me two roll numbers using pathParam annotation ------->" + studentRollNo1 + " and "
				+ studentRollNo2;
	}
	/*
	 * http://localhost:8083/welcome/webapi/university;studentRollNo1=23;
	 * studentRollNo2=57
	 */

	@POST
	@Path("/add")
	public String addStudentparamInfo(@FormParam("name") String name, @FormParam("age") String age) {
		return "You sent me two Parameters using pathParam annotation ------->" + name + " and age " + age;
	}

	@GET
	@Path("/get")
	@Produces("text/plain")

	public Response getStudentFile() {
		File file = new File("d:\\DemoFile.txt");
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition", "attachment; filename=DisplayName-DemoFile.txt");
		return response.build();

	}

	
}
