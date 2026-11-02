package siga;

public class Confirmada implements EstadoMatricula {

    public void concluir(Matricula matricula){
        matricula.setEstado(new Concluida());
    }

    @Override
    public void confirmar(Matricula matricula) {
        throw new IllegalStateException("Nao e possivel confirmar uma matricula CONFIRMADA");
    }

    @Override
    public void trancar(Matricula matricula) {
        matricula.setEstado(new Trancada());
    }

    @Override
    public void cancelar(Matricula matricula) {
        matricula.setEstado(new Cancelada());
    }

    @Override
    public String getSituacao() {
        return "CONFIRMADA";
    }
}
