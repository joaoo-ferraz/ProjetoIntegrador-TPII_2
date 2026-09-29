package siga;

public class DescontoConvenio implements Desconto {
    @Override
    public double calcularDesconto(double valorBase) {
        return valorBase * 0.8;
    }
}