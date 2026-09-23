package siga;

import java.util.List;

/*
1º SRP: A classe ServicoMatricula viola o princípio da responsabilidade única
(SRP), ela mistura a regra de negócio da matrícula com a lógica de acesso
a dados.

2º DIP: A classe ServicoMatricula também viola o princípio da inversão de
dependência (DIP), porque depende diretamente de uma implementação concreta,
BancoSimulado, para acessar os dados. O objetivo é criar AlunoDAO
para que a regra de negócio dependa de uma a abstração, e não de uma
implementação concreta.

3º Duplicação: Os métodos matricular e gerarRelatorio possuem lógica de acesso
a dados espalhada e repetida, violando o princípio DRY.
*/
public class ServicoMatricula {

    private final AlunoDAO alunoDAO;

    public ServicoMatricula(AlunoDAO alunoDAO) {
        this.alunoDAO = alunoDAO;
    }

    public void matricular(Aluno aluno) {

        if (aluno.getMedia() < 0 || aluno.getMedia() > 10) {
            throw new IllegalArgumentException("Média inválida: " + aluno.getMedia());
        }

        alunoDAO.inserir(aluno);

    }

    public void gerarRelatorio() {

        List<Aluno> alunos = alunoDAO.listarTodos();

        System.out.println("=== Relatório de Alunos ===");
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }
}
