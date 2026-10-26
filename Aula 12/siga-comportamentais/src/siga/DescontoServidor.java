package siga;

public class DescontoServidor implements PoliticaDesconto {

    private static final double PERCENTUAL = 0.20;

    @Override
    public double aplicar(double valorBase) {
        return valorBase * (1 - PERCENTUAL);
    }

    @Override
    public String getDescricao() {
        return "Servidor (20%)";
    }
}

