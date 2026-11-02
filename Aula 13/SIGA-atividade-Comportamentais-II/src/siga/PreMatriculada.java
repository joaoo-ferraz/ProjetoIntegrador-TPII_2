package siga;

public class PreMatriculada implements EstadoMatricula {
    @Override
    public void confirmar(Matricula matricula) {
        matricula.setEstado(new Confirmada());
    }

    @Override
    public void trancar(Matricula matricula) {
        throw new IllegalStateException(
                "Nao e possivel trancar uma matricula PRE_MATRICULADA");
    }

    @Override
    public void cancelar(Matricula matricula) {
        matricula.setEstado(new Cancelada());
    }

    @Override 
    public String getSituacao() {
        return "PRE_MATRICULADA";
    }
}
