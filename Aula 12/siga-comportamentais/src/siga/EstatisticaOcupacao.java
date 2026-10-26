package siga;

import java.util.Map;
import java.util.HashMap;

public class EstatisticaOcupacao implements OuvinteMatricula {

    private final Map<String, Integer> ocupacao = new HashMap<>();

    @Override 
    public void aoMatricular(Matricula matricula) {
        String codigoTurma = matricula.getCodigoTurma();
        int quantidade = ocupacao.getOrDefault(codigoTurma, 0);
        quantidade++;
        ocupacao.put(codigoTurma, quantidade);

        System.out.printf("   >> EstatisticaOcupacao: turma %s agora com %d matriculas%n",
                codigoTurma, quantidade);
    }
}
