package siga;

public class DescontoNenhum implements Desconto {
    @Override
    public double calcularDesconto(double valorBase) {
        return valorBase;
    }
}