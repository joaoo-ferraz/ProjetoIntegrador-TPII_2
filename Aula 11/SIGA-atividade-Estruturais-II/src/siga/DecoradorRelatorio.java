package siga;

public abstract class DecoradorRelatorio implements Relatorio {
    protected final Relatorio interno;

    protected DecoradorRelatorio(Relatorio interno) {
        this.interno = interno;
    }
}
