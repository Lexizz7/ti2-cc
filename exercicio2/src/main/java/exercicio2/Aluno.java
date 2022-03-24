package exercicio2;

public class Aluno {
	private int matricula;
	private String nome;
	private int idade;
	private char sexo;
	private String curso;
	private int periodo;

    public Aluno() {
        this.matricula = 0;
        this.nome = "";
        this.idade = 0;
        this.sexo = ' ';
        this.curso = "";
        this.periodo = 0;
    }

    public Aluno(int matricula, String nome, int idade, char sexo, String curso, int periodo) {
        this.matricula = matricula;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.curso = curso;
        this.periodo = periodo;
    }

    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return sexo;
    }
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getPeriodo() {
        return periodo;
    }
    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public String imprimir() {
		return "Aluno: " + this.matricula + " - " + this.nome + ", " + this.idade + " anos, " + this.sexo + ", " + this.curso + ", " + this.periodo + "periodo";
	}		
}
