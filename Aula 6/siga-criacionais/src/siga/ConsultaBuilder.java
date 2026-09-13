package siga;

public class ConsultaBuilder {
    private String tabela; 
    private String filtro; 
    private String ordenacao;
    private int limite;
    private int offset;
    private int timeoutSegundos;
    private boolean somenteAtivos;

    public ConsultaBuilder(String tabela) {
        this.tabela = tabela;
    }

    public ConsultaBuilder comFiltro(String filtro) {
        this.filtro = filtro;
        return this;
    }

    public ConsultaBuilder comOrdenacao(String ordenacao) {
        this.ordenacao = ordenacao;
        return this;
    }

    public ConsultaBuilder comLimite(int limite) {
        this.limite = limite;
        return this;
    }

    public ConsultaBuilder comOffset(int offset) {
        this.offset = offset;
        return this;
    }

    public ConsultaBuilder comTimeoutSegundos(int timeoutSegundos) {
        this.timeoutSegundos = timeoutSegundos;
        return this;
    }
    
    public ConsultaBuilder comSomenteAtivos(boolean somenteAtivos) {
        this.somenteAtivos = somenteAtivos;
        return this;
    }

    public ConsultaBuilder comTabela(String tabela) {
        this.tabela = tabela;
        return this;
    }

    public String construir() {
        String consulta = "SELECT * FROM " + tabela;
            if (filtro != null && !filtro.isEmpty()) {
                consulta += " WHERE " + filtro;
            }
            if (somenteAtivos) {
                consulta += (filtro != null && !filtro.isEmpty()) ? " AND ativo = 1" : " WHERE ativo = 1";
            }
            if (ordenacao != null && !ordenacao.isEmpty()) {
                consulta += " ORDER BY " + ordenacao;
            }
            if (limite > 0) {
                consulta += " LIMIT " + limite;
            }
            if (offset > 0) {
                consulta += " OFFSET " + offset;
            }
        return consulta;
    }
}