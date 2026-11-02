package siga;

public class Cancelada implements EstadoMatricula {

    @Override
    public void confirmar(Matricula matricula) {
        throw new IllegalStateException("Nao e possivel confirmar uma matricula CANCELADA");
    }

    @Override
    public void trancar(Matricula matricula) {
        throw new IllegalStateException("Nao e possivel trancar uma matricula CANCELADA");
    }

    @Override
    public void cancelar(Matricula matricula) {
        throw new IllegalStateException("Nao e possivel cancelar uma matricula CANCELADA");
    }

    @Override
    public String getSituacao() {
        return "CANCELADA";
    }
    
}
