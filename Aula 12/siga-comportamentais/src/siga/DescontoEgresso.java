package siga;

public class DescontoEgresso implements PoliticaDesconto {

    private static final double PERCENTUAL = 0.10;

    @Override
    public double aplicar(double valorBase) {
        return valorBase * (1 - PERCENTUAL);
    }

    @Override
    public String getDescricao() {
        return "Egresso (10%)";
    }
}

