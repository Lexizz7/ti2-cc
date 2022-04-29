package exercicio03;

import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import spark.*;
import exercicio03.Aluno;
@SuppressWarnings("unchecked")
public class Service {
	public static String getAluno() {
		DAO dao = new DAO();
		dao.conectar();
		
		Aluno[] alunos = dao.getAlunos();
		JSONArray alunosListJSON = new JSONArray();
		
        for (Aluno aluno : alunos) {
        	JSONObject alunoDetails = new JSONObject();
        	alunoDetails.put("matricula", aluno.getMatricula());
        	alunoDetails.put("nome", aluno.getNome());
        	alunoDetails.put("idade", aluno.getIdade());
        	alunoDetails.put("sexo", "" + aluno.getSexo() + "");
        	alunoDetails.put("curso", aluno.getCurso());
        	alunoDetails.put("periodo", aluno.getPeriodo());
        	
        	alunosListJSON.add(alunoDetails);
        }
		
		dao.close();
		
		return alunosListJSON.toJSONString();
	}
	
	public static String searchAluno(Request request) {
		DAO dao = new DAO();
		dao.conectar();
		int matricula = Integer.parseInt(request.params(":matricula"));
		
		Aluno aluno = dao.procurarAluno(matricula);
		
		JSONArray alunosListJSON = new JSONArray();
		if(aluno.getMatricula() != 0) {
        JSONObject alunoDetails = new JSONObject();
        alunoDetails.put("matricula", aluno.getMatricula());
        alunoDetails.put("nome", aluno.getNome());
        alunoDetails.put("idade", aluno.getIdade());
        alunoDetails.put("sexo", "" + aluno.getSexo() + "");
        alunoDetails.put("curso", aluno.getCurso());
        alunoDetails.put("periodo", aluno.getPeriodo());
        	
        alunosListJSON.add(alunoDetails);
	}
		dao.close();
		
		return alunosListJSON.toJSONString();
	}
	
	public static boolean removeAluno(Request request) {
		DAO dao = new DAO();
		dao.conectar();
		int matricula = Integer.parseInt(request.params(":matricula"));
		
		boolean resposta = dao.excluirAluno(matricula);
		
		dao.close();
		
		return resposta;
	}
	
	public static boolean insertAluno(Request request) {
		DAO dao = new DAO();
		dao.conectar();
		int matricula = Integer.parseInt(request.params(":matricula"));
		String nome = request.params(":nome");
		int idade = Integer.parseInt(request.params(":idade"));
		char sexo=request.params(":sexo").charAt(0);
		String curso = request.params(":curso");
		int periodo = Integer.parseInt(request.params(":periodo"));
		
		Aluno aluno = new Aluno(matricula, nome, idade, sexo, curso, periodo);
		boolean resposta = dao.inserirAluno(aluno);
		
		dao.close();
		
		return resposta;
	}
}