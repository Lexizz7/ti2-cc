package exercicio2;

import java.util.*;

public class Principal {
    public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		DAO dao = new DAO();
		
		dao.conectar();

		//Menu

        int opcao = 0;

        System.out.println("Escolha uma opção: ");
        System.out.println("1 - Listar");
        System.out.println("2 - Inserir");
        System.out.println("3 - Atualizar");
        System.out.println("4 - Excluir");
        System.out.println("5 - Sair");

        opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                Aluno[] alunos = dao.getAlunos();
                for (Aluno aluno : alunos) {
                    System.out.println(aluno.imprimir());
                }
                break;
            case 2:
                System.out.println("Digite a matricula: ");
                int matricula = sc.nextInt();
                if(!dao.alunoExiste(matricula))
                {
                System.out.println("Digite o nome: ");
                String nome = sc.next();
                System.out.println("Digite a idade: ");
                int idade = sc.nextInt();
                System.out.println("Digite o sexo: ");
                char sexo = sc.next().charAt(0);
                System.out.println("Digite o curso: ");
                String curso = sc.next();
                System.out.println("Digite o periodo: ");
                int periodo = sc.nextInt();

                Aluno aluno = new Aluno(matricula, nome, idade, sexo, curso, periodo);
                dao.inserirAluno(aluno);

                System.out.println("Aluno inserido com sucesso!");
                }
                else
                {
                    System.out.println("Aluno já existe!");
                }
                break;
            case 3:
                System.out.println("Digite a matricula: ");
                int matricula2 = sc.nextInt();
                if(dao.alunoExiste(matricula2))
                {
                    System.out.println("Digite o nome: ");
                    String nome2 = sc.next();
                    System.out.println("Digite a idade: ");
                    int idade2 = sc.nextInt();
                    System.out.println("Digite o sexo: ");
                    char sexo2 = sc.next().charAt(0);
                    System.out.println("Digite o curso: ");
                    String curso2 = sc.next();
                    System.out.println("Digite o periodo: ");
                    int periodo2 = sc.nextInt();

                    Aluno aluno2 = new Aluno(matricula2, nome2, idade2, sexo2, curso2, periodo2);
                    dao.atualizarAluno(aluno2, matricula2);

                    System.out.println("Aluno atualizado com sucesso!");
                }
                else
                {
                    System.out.println("Aluno não encontrado");
                }
                break;
            case 4:
                System.out.println("Digite a matricula: ");
                int matricula3 = sc.nextInt();
                if(dao.alunoExiste(matricula3))
                {
                    dao.excluirAluno(matricula3);

                    System.out.println("Aluno excluido com sucesso");
                }
                else
                {
                    System.out.println("Aluno não encontrado");
                }
                break;
            case 5:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
		
		dao.close();

        System.out.println("Fim");
	}
}