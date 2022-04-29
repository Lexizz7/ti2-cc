package exercicio03;

import static spark.Spark.*;

import spark.Spark;
import spark.Filter;
import spark.Request;
import spark.Response;

public class Principal {
	
	public static void main(String[] args) {
		
		DAO dao = new DAO();
		
		dao.conectar();

		port(3001);
		
		after((Filter) (request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Methods", "GET");
        });
		
		get("/getAlunos", (request, response) -> Service.getAluno());
		
		get("/searchAluno/:matricula", (request, response) -> Service.searchAluno(request));
		
		get("/removeAluno/:matricula", (request, response) -> Service.removeAluno(request));
		
		get("/insertAluno/:matricula/:nome/:idade/:sexo/:curso/:periodo", (request,response) -> Service.insertAluno(request));
		
		dao.close();
	}
}