package siga;

public class ComCabecalho extends DecoradorRelatorio {
    public ComCabecalho(Relatorio interno){
        super(interno);
    }

    @Override
    public String gerar() {
        return "FATEC DE PORTO FERREIRA\n"
            + "Sistema de Gestão Acadêmica\n"
            + "---\n"
            + interno.gerar();
    }
    
}
