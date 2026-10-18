package siga;

public class Disciplina implements ItemCurricular {

    private final String nome;
    private final int cargaHoraria;

    public Disciplina(String nome, int cargaHoraria) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }

    @Override 
    public String getNome() {
        return nome;
    }

    @Override
    public int getCargaHoraria() {
        return cargaHoraria;
    }

    @Override
    public void imprimir(int nivel) {
        String prefixo = "  ".repeat(nivel);
        System.out.println(prefixo + nome + " (" + cargaHoraria + "h)");
    }
}
