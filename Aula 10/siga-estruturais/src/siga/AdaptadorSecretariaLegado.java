package siga;

import java.util.List;
import java.util.ArrayList;

public class AdaptadorSecretariaLegado implements FonteDeAlunos {
    private SecretariaLegadoWS secretariaLegado;

    public AdaptadorSecretariaLegado(SecretariaLegadoWS secretariaLegado) {
        this.secretariaLegado = secretariaLegado;
    }

    @Override
    public List<Aluno> listar() {
        String[][] dados = secretariaLegado.consultarTabelaAlunos();
        List<Aluno> alunos = new ArrayList<>();
        for (String[] linha : dados) {
            String matricula = linha[0];
            String nomeCompleto = linha[1];
            String situacao = linha[2];

            Aluno aluno = new Aluno(matricula, nomeCompleto);

            aluno.setAtivo(situacao.equalsIgnoreCase("A"));

            alunos.add(aluno);
        }
        return alunos;
    }
}

