package siga;

public class HistoricoEscolar extends DocumentoAcademico {
    
    @Override 
    protected String corpo(Aluno aluno){
        StringBuilder documento = new StringBuilder();
        documento.append("HISTORICO ESCOLAR\n")
         .append(aluno.getNome())
         .append("\nCarga horaria cumprida: ")
         .append(aluno.getCargaCumprida())
         .append("h");
        return documento.toString();
    }

    @Override 
    protected String tipoDocumento(){
        return "HISTORICO";
    }
}
