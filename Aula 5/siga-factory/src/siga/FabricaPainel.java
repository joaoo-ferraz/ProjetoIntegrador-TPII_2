package siga;

public class FabricaPainel {
    public Painel criarPainel(String tipoUsuario){
        switch (tipoUsuario) {
            case "ALUNO":
                return new PainelAluno();
            case "PROFESSOR":
                return new PainelProfessor();
            case "COORDENADOR":
                return new PainelCoordenador();
            default:
                throw new IllegalArgumentException("Perfil desconhecido: " + tipoUsuario);
        }
    }
}
