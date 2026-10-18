package siga;

import java.util.ArrayList;
import java.util.List;

public class Modulo implements ItemCurricular {

    private final String nome;
    private final List<ItemCurricular> filhos = new ArrayList<>();

    public Modulo(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNome() {
        return nome;
    }

    public void adicionar(ItemCurricular filho) {
        filhos.add(filho);
    }

    @Override
    public int getCargaHoraria() {
        int total = 0;
        for (ItemCurricular filho : filhos) {
            total += filho.getCargaHoraria();
        }
        return total;
    }

    @Override
    public void imprimir(int nivel) {
        String prefixo = "  ".repeat(nivel);
        System.out.println(prefixo + "[" + nome + "]");
        for (ItemCurricular filho : filhos) {
            filho.imprimir(nivel + 1);
        }
    }
  
}
