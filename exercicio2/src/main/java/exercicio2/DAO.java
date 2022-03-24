package exercicio2;

import java.sql.*;

public class DAO {
	private Connection conexao;
	
	public DAO() {
		conexao = null;
	}
	
	public boolean conectar() {
		String driverName = "org.postgresql.Driver";                    
		String serverName = "localhost";
		String mydatabase = "Exercicio 2";
		int porta = 5432;
		String url = "jdbc:postgresql://" + serverName + ":" + porta +"/" + mydatabase;
		String username = "ti2cc";
		String password = "ti@cc";
		boolean status = false;

		try {
			Class.forName(driverName);
			conexao = DriverManager.getConnection(url, username, password);
			status = (conexao == null);
			System.out.println("Conexao efetuada com o postgres!");
		} catch (ClassNotFoundException e) { 
			System.err.println("Conexao nao efetuada com o postgres -- Driver nao encontrado -- " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("Conexao nao efetuada com o postgres -- " + e.getMessage());
		}

		return status;
	}
	
	public boolean close() {
		boolean status = false;
		
		try {
			conexao.close();
			status = true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return status;
	}
	
	public boolean inserirAluno(Aluno aluno) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO aluno (matricula, nome, idade, sexo, curso, periodo) "
					       + "VALUES (" + aluno.getMatricula() + ", '" + aluno.getNome() + "', " + aluno.getIdade() + ", '" + aluno.getSexo() + "', '" + aluno.getCurso() + "', " + aluno.getPeriodo() + ")");
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean atualizarAluno(Aluno aluno, int matricula) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE aluno SET nome = '" + aluno.getNome() + "', idade = " + aluno.getIdade() + ", sexo = '" + aluno.getSexo() + "', curso = '" + aluno.getCurso() + "', periodo = " + aluno.getPeriodo() + " WHERE matricula = " + matricula;
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean excluirAluno(int matricula) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM aluno WHERE matricula = " + matricula);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
    public boolean alunoExiste(int matricula) {
    	boolean status = false;
    	try {
    		Statement st = conexao.createStatement();
    		ResultSet rs = st.executeQuery("SELECT * FROM aluno WHERE matricula = " + matricula);
    		status = rs.next();
    		st.close();
    	} catch (SQLException u) {
    		throw new RuntimeException(u);
    	}
    	return status;
    }
	
	public Aluno[] getAlunos() {
		Aluno[] alunos = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM aluno");		
	         if(rs.next()){
	             rs.last();
	             alunos = new Aluno[rs.getRow()];
	             rs.beforeFirst();

	             for(int i = 0; rs.next(); i++) {
	                alunos[i] = new Aluno(
                        rs.getInt("matricula"),
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getString("sexo").charAt(0),
                        rs.getString("curso"),
                        rs.getInt("periodo")
                    );
	             }
	          }
	          st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return alunos;
	}
}