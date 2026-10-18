package siga;

public class ComNumeracao extends DecoradorRelatorio {
    public ComNumeracao(Relatorio interno){
        super(interno);
    }

    @Override
    public String gerar() {
        String conteudo = interno.gerar();
        String[] linhas = conteudo.split("\n");
        StringBuilder numerado = new StringBuilder();
        for (int i = 0; i < linhas.length; i++) {
            numerado.append((i + 1)).append(": ").append(linhas[i]).append("\n");
        }
        return numerado.toString();
    }
}
