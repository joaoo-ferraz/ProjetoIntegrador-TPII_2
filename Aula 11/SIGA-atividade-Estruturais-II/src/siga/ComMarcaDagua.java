package siga;

public class ComMarcaDagua extends DecoradorRelatorio {
    public ComMarcaDagua(Relatorio interno){
        super(interno);
    }

    @Override
    public String gerar() {
        String conteudo = interno.gerar();
        return conteudo.stripTrailing()
            + "\n*** RASCUNHO — NAO E DOCUMENTO OFICIAL ***";
    }
    
}
