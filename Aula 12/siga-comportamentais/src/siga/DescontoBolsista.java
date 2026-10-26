package siga;

public class DescontoBolsista implements PoliticaDesconto {

    private static final double PERCENTUAL = 0.50;

    @Override
    public double aplicar(double valorBase) {
        return valorBase * (1 - PERCENTUAL);
    }

    @Override
    public String getDescricao() {
        return "Bolsista (50%)";
    }
}

