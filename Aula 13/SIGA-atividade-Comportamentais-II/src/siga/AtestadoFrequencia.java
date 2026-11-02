package siga;

public class AtestadoFrequencia extends DocumentoAcademico {
    
    @Override 
    protected String corpo(Aluno aluno){
        StringBuilder documento = new StringBuilder();
        documento.append("ATESTADO DE FREQUENCIA\n")
         .append(aluno.getNome());
        return documento.toString();
    }
    
    @Override 
    protected String tipoDocumento(){
        return "ATESTADO";
    }

    @Override 
    protected boolean exigeAssinatura(){
        return false;
    }
}
