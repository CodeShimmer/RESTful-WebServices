package org.mahe.webserve.messenger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to the
	 * client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getHTMLUniversityInfo() {
		return "<html> " + "<title>" + "University Information" + "</title>" + "<body><h1>" + "Name - Gannon University" + "</h1></body>"
				+ "</html> ";
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getPlain() {
		return "Electrical Engineering";
	}
	
	@PUT
	@Path("{StudentRollNo}")
	@Produces(MediaType.TEXT_PLAIN)
	public String update(@PathParam("StudentRollNo") String StudentRollNo) {
		return "Done Successfully!";
	}
}
