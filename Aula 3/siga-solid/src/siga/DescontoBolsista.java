package siga;

public class DescontoBolsista implements Desconto {
    @Override
    public double calcularDesconto(double valorBase) {
        return valorBase * 0.5;
    }
}