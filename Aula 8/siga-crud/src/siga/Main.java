package siga;

public class Main {

    public static void main(String[] args) {

        AlunoDAO dao = new AlunoDAOMemoria();
        ServicoAluno servico = new ServicoAluno(dao);

        // --- CREATE ---
        cadastrar(servico, new Aluno("Maria Silva", "2026001", 8.5));
        cadastrar(servico, new Aluno("João Souza",  "2026002", 6.0));
        System.out.println();

        // --- READ ---
        System.out.println("Alunos cadastrados:");
        for (Aluno aluno : servico.listar()) {
            System.out.println("  " + aluno);
        }

        // --- UPDATE ---
        System.out.println();
        try {
            servico.alterar(new Aluno("Maria Silva", "2026001", 9.0));
            System.out.println("Alterado: " + servico.consultar("2026001"));
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Não foi possível alterar: " + e.getMessage());
        }

        // --- DELETE ---
        System.out.println();
        try {
            servico.excluir("2026002");
            System.out.println("Excluído: 2026002");
        } catch (IllegalStateException e) {
            System.out.println("Não foi possível excluir: " + e.getMessage());
        }
    }

    /** Apresentação: traduz as exceções do serviço em mensagens ao usuário. */
    private static void cadastrar(ServicoAluno servico, Aluno aluno) {
        try {
            servico.cadastrar(aluno);
            System.out.println("Cadastrado: " + aluno);
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Não foi possível cadastrar: " + e.getMessage());
        }
    }
}

