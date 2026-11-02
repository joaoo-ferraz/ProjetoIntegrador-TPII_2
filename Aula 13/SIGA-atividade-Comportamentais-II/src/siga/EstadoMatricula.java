package siga;

public interface EstadoMatricula {
    
    void confirmar(Matricula matricula);

    void trancar(Matricula matricula);

    void cancelar(Matricula matricula);

    String getSituacao();
}
