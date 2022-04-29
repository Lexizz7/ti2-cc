# Exercícios de TI (Integração Eclipse IDE, Git e PostgreSQL)
Todas as alterações no repositório feitas pelo Eclipse IDE (com excessão do README)

## 📖 Organização
### Exercício 1
Caminho: `exercicio01/src`

Apresenta uma classe para somar dois números, feita apenas para testar a integração entre Eclipse e Git

### Exercício 2
Caminho: `exercicio2/src/main/java/exercicio2`

Apresenta classe Aluno, com os atributos matrícula, nome, idade, sexo, curso e período.

Conecta a um banco de dados PostgreSQL

Apresenta um menu para acessar as funções CRUD

### Exercício 3
Caminho: `exercicio03/src/main/java/exercicio03`
HTML: `exercicio03/src/main/resources/formulario.html`

Produto: Alunos matriculados

Tabela: Aluno; Colunas: Matrícula, Nome, Idade, Sexo, Curso, Periodo

Formulario com funções CRUD

Backend em Java usando Spark Framework (retorna respostas em JSON)

Frontend (formulario.html) usa fetch para receber o JSON do backend

## ⭐ Auto-avaliação
Nota: 5.0/5.0

## ⚙️ Método
### Integração Git
1. Criar repositório
2. Clonar pelo Eclipse
3. Conectar o projeto java ao repositório local
4. Commit e pull

### Integração PostgreSQL
1. Criar tabela aluno, com seus respectivos atributos
2. Criar classe Aluno em java, com os mesmos atributos, métodos get e set e imprimir
3. Criar classe para fazer conexão entre o PostgreSQL
4. Criar a classe principal para mostrar o menu e interligar Aluno e PostgreSQL
