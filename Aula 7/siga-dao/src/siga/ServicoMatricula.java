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

    public void matricular(Aluno aluno) {
        // --- regra de negócio (é o que esta classe deveria fazer) ---
        if (aluno.getMedia() < 0 || aluno.getMedia() > 10) {
            throw new IllegalArgumentException("Média inválida: " + aluno.getMedia());
        }

        // --- ...e, no meio dela, acesso a dados (não deveria estar aqui) ---
        String sql = "INSERT INTO aluno (nome, matricula, media) VALUES ('"
                + aluno.getNome() + "', '"
                + aluno.getMatricula() + "', "
                + aluno.getMedia() + ")";
        BancoSimulado.executar(sql, aluno.toString());
    }

    public void gerarRelatorio() {
        // Duplicação: o mesmo acesso a dados aparece aqui de novo.
        String sql = "SELECT nome, matricula, media FROM aluno";
        List<String> linhas = BancoSimulado.consultar(sql);

        System.out.println("=== Relatório de Alunos ===");
        for (String linha : linhas) {
            System.out.println(linha);
        }
    }
}
