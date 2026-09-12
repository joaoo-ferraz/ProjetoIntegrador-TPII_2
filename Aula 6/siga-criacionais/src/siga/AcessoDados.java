package siga;


/* 1º O primeiro problema identificado é a falta de conexão entre objetos da mesma família, 
o que permite misturar elementos de origens diferentes; 
2º O segundo está no excesso de parametros adicionais deixando o código "sujo", ilegivel, extensa e sujeito a erros; 
3º A terceira é que na classe AcessoDados não existe um controle que garanta uma única instancia. */

public class AcessoDados {

    // PROBLEMA 1: conexão e comando criados separadamente, sem garantia de coerência.
    public void conectar(String fornecedor) {
        Conexao conexao;
        Comando comando;
        if (fornecedor.equals("MYSQL")) {
            conexao = new ConexaoMySQL();
            comando = new ComandoMySQL();
        } else {
            conexao = new ConexaoPostgreSQL();
            comando = new ComandoPostgreSQL();
        }
        // Nada impede o engano abaixo (fornecedores misturados):
        //   conexao = new ConexaoMySQL();
        //   comando = new ComandoPostgreSQL();  // <- incoerência não detectada!
        conexao.abrir();
        comando.executar("SELECT * FROM aluno");
    }

    // PROBLEMA 2: método telescópico — muitos parâmetros opcionais.
    public String montarConsulta(String tabela, String filtro, String ordenacao,
                                 int limite, int offset, int timeoutSegundos,
                                 boolean somenteAtivos) {
        StringBuilder sb = new StringBuilder("SELECT * FROM ").append(tabela);
        if (filtro != null) sb.append(" WHERE ").append(filtro);
        if (somenteAtivos) sb.append(filtro != null ? " AND ativo = 1" : " WHERE ativo = 1");
        if (ordenacao != null) sb.append(" ORDER BY ").append(ordenacao);
        if (limite > 0) sb.append(" LIMIT ").append(limite);
        if (offset > 0) sb.append(" OFFSET ").append(offset);
        return sb.toString();
    }
}
