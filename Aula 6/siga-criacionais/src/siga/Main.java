package siga;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== SIGA - Atividade de Padrões Criacionais ===\n");

        AcessoDados acessoDados = AcessoDados.getInstancia();

        FabricaBanco fabricaMySQL = new FabricaMySQL();
        acessoDados.conectar(fabricaMySQL);

        FabricaBanco fabricaPostgreSQL = new FabricaPostgreSQL();
        acessoDados.conectar(fabricaPostgreSQL);
        
        ConsultaBuilder builder = new ConsultaBuilder("aluno");
        builder.comFiltro("curso = 'DSM'");
        builder.comOrdenacao("nome");
        builder.comLimite(50);
        builder.comSomenteAtivos(true);

        String consulta = builder.construir();
        System.out.println("Consulta montada: " + consulta);

    }
}
