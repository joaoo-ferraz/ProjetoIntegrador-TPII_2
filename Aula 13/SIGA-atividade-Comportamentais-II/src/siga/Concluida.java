package siga;

public class Concluida implements EstadoMatricula {

    @Override
    public String getSituacao() {
        return "CONCLUIDA";
    }

    @Override
    public void confirmar(Matricula matricula) {
        throw new IllegalStateException("Nao e possivel confirmar uma matricula concluida.");
    }

    @Override
    public void trancar(Matricula matricula) {
        throw new IllegalStateException("Nao e possivel trancar uma matricula concluida.");
    }

    @Override
    public void cancelar(Matricula matricula) {
        throw new IllegalStateException("Nao e possivel cancelar uma matricula concluida.");
    }
}
