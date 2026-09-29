package siga;

public class DescontoFuncionario implements Desconto {
    @Override
    public double calcularDesconto(double valorBase) {
        return valorBase * 0.7;
    }
}