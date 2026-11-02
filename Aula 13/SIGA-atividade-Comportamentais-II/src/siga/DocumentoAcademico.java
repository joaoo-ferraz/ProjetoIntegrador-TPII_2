package siga;

import java.time.LocalDate;

public abstract class DocumentoAcademico {
    public final String emitir(Aluno aluno){
        validar(aluno);
        StringBuilder documento = new StringBuilder();
        documento.append(cabecalho());
        documento.append(corpo(aluno));
        documento.append(rodape());
        if (exigeAssinatura()) {
            documento.append("\nAssinado digitalmente pela secretaria academica.");
        }
        registrarEmissao(aluno);
        return documento.toString();
    }

    private void validar(Aluno aluno){
        if (!aluno.isRegular()) {
            throw new IllegalStateException(
                    "Aluno irregular: " + aluno.getMatricula());
        }
    }

    private String cabecalho(){
        StringBuilder documento = new StringBuilder();
        documento.append("FATEC DE PORTO FERREIRA\n");
        documento.append("Sistema de Gestao Academica\n---\n");
        return documento.toString();
    }

    protected abstract String corpo(Aluno aluno);

    private String rodape(){
        StringBuilder documento = new StringBuilder();
        documento.append("\n---\nEmitido em ").append(LocalDate.now());
        return documento.toString();
    }

    private void registrarEmissao(Aluno aluno){
        LogAcademico.registrar(tipoDocumento(), aluno);
    }

    protected abstract String tipoDocumento();

    protected boolean exigeAssinatura(){
        return true;
    }

}
