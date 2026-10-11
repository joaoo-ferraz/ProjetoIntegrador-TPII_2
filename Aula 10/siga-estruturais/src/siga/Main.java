package siga;

public class Main {

    public static void main(String[] args) {
        SecretariaLegadoWS servicoLegado = new SecretariaLegadoWS();
        FonteDeAlunos fonte = new AdaptadorSecretariaLegado(servicoLegado);
        AlunoDAO alunoDAO = new AlunoDAOMemoria();

        ImportadorAlunos importador = new ImportadorAlunos(fonte, alunoDAO);
        System.out.println("   Alunos importados: " + importador.importar());
        System.out.println("   Situação segundo o importador:");
        for (Aluno aluno : alunoDAO.listarTodos()) {
            System.out.println("     " + aluno);
        }

        System.out.println();
    
        new RelatorioSituacao(fonte).imprimir();
        
        Aluno bolsista = alunoDAO.buscarPorMatricula("2024001");
        bolsista.setBolsista(true);

        FachadaMatricula fachadaMatricula = new FachadaMatricula(
        new ValidadorCpf(),
        alunoDAO,
        new ControleVagas(),
        new CalculadoraDesconto(),
        new MatriculaDAOMemoria(),
        new NotificadorEmail());

        TelaMatricula tela = new TelaMatricula(fachadaMatricula);

        tela.aoClicarEmMatricular("2024001", "123.456.789-09", "DSM-2A");
        tela.aoClicarEmMatricular("2024002", "111", "DSM-2A");
        tela.aoClicarEmMatricular("2024009", "123.456.789-09", "DSM-2A");
        tela.aoClicarEmMatricular("2024004", "123.456.789-09", "DSM-2B");
    }
}
