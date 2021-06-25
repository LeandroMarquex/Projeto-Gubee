package br.com.gubee.service;





import javax.ws.rs.GET;
import javax.ws.rs.Path;

// http://localhost:8080/Gubee/rest/gubee
@Path("gubee")
public class GubeeService {
	@GET
	public String exibir(){
		return "Cursos de Hugo Vasconcelos";
	}
}