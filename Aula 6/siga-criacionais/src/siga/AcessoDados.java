package siga;

/* 1º O primeiro problema identificado é a falta de conexão entre objetos da mesma família, 
o que permite misturar elementos de origens diferentes; 
2º O segundo está no excesso de parametros adicionais deixando o código "sujo", ilegivel, extensa e sujeito a erros; 
3º A terceira é que na classe AcessoDados não existe um controle que garanta uma única instancia. */

public class AcessoDados {

    private static AcessoDados instancia;

    private AcessoDados() {

    }

    public static AcessoDados getInstancia() {
        if (instancia == null) {
            instancia = new AcessoDados();
        }
        return instancia;
    }

    public void conectar(FabricaBanco fabrica) {

        Conexao conexao = fabrica.criarConexao();
        Comando comando = fabrica.criarComando();

        conexao.abrir();
        comando.executar("SELECT * FROM aluno");
    }
}
