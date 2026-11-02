package siga;

public class DeclaracaoVinculo extends DocumentoAcademico {

    @Override
    protected String corpo(Aluno aluno) {
        StringBuilder documento = new StringBuilder();
        documento.append("DECLARACAO DE VINCULO\n")
                 .append("Declaramos que ")
                 .append(aluno.getNome())
                 .append(" possui vinculo ativo com esta instituicao.");
        return documento.toString();
    }

    @Override
    protected String tipoDocumento() {
        return "DECLARACAO";
    }
}
