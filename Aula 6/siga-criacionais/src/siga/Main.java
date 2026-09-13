package siga;

/**
 * Ponto de entrada do SIGA (código INICIAL da atividade da Aula 6).
 *
 * Demonstra o acesso a dados nos dois fornecedores. O programa FUNCIONA, mas:
 * (1) nada garante que conexão e comando sejam do mesmo fornecedor;
 * (2) a montagem da consulta usa um método com parâmetros demais;
 * (3) qualquer parte do sistema pode instanciar seu próprio AcessoDados.
 * Sua tarefa é aplicar Abstract Factory, Builder e Singleton.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== SIGA - Atividade de Padrões Criacionais (código inicial) ===\n");

        AcessoDados acesso = new AcessoDados();
        FabricaBanco fabricaMySQL = new FabricaMySQL();
        acesso.conectar(fabricaMySQL);

        FabricaBanco fabricaPostgreSQL = new FabricaPostgreSQL();
        acesso.conectar(fabricaPostgreSQL);
        
        ConsultaBuilder builder = new ConsultaBuilder("aluno");
        builder.comFiltro("curso = 'DSM'");
        builder.comOrdenacao("nome");
        builder.comLimite(50);
        builder.comSomenteAtivos(true);

        String consulta = builder.construir();
        System.out.println("Consulta montada: " + consulta);

    }
}
