package siga;

public class Main {

    public static void main(String[] args) {

        System.out.println();
        System.out.println("1) Relatorios com Decorator");
        Relatorio base = new RelatorioDeAlunos();
        Relatorio[] variantes = {
            new ComNumeracao(new ComCabecalho(base)),
            new ComMarcaDagua(new ComNumeracao(new ComCabecalho(base)))
        };
        for (Relatorio r : variantes) {
            System.out.println("   --- " + r.getClass().getSimpleName() + " ---");
            for (String linha : r.gerar().split("\n")) {
                System.out.println("   " + linha);
            }
        }

        System.out.println();
        Modulo curso = new Modulo("DSM - Desenvolvimento de Software Multiplataforma");

        Modulo primeiro = new Modulo("1o semestre");
        primeiro.adicionar(new Disciplina("Algoritmos", 80));
        primeiro.adicionar(new Disciplina("Banco de Dados I", 60));

        Modulo segundo = new Modulo("2o semestre");
        segundo.adicionar(new Disciplina("Tecnicas de Programacao II", 80));

        Modulo trilha = new Modulo("Trilha de Desenvolvimento Web");
        trilha.adicionar(new Disciplina("Desenvolvimento Web II", 80));
        segundo.adicionar(trilha);

        curso.adicionar(primeiro);
        curso.adicionar(segundo);
        curso.adicionar(new Disciplina("Projeto Integrador", 40));

        curso.imprimir(0);
        System.out.println("   Carga total: " + curso.getCargaHoraria() + "h");

        System.out.println();
    }
}
