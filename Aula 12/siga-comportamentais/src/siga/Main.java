package siga;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== SIGA - Aula 12: Strategy e Observer (codigo inicial) ===");

        Aluno bolsista = new Aluno("2024001", "Maria Silva");
        bolsista.setBolsista(true);

        Aluno egresso = new Aluno("2024003", "Ana Pereira");
        egresso.setEgresso(true);

        double valorBase = 800.00;
        GeradorBoleto gerador = new GeradorBoleto();

        Matricula[] matriculas = {
                new Matricula(bolsista, "DSM-2A", new DescontoBolsista()),
                new Matricula(egresso, "DSM-2A", new DescontoEgresso())
        };

        System.out.println();     
        for (Matricula m : matriculas) {
            System.out.printf("   %-14s matricula: R$ %.2f%n",
                    m.getAluno().getNome(), m.calcularValor(valorBase));
            gerador.emitir(m, valorBase);
        }

        System.out.println();
        FachadaMatricula fachada = new FachadaMatricula();
        fachada.matricular(bolsista, "DSM-2A", new DescontoBolsista(), false);

        System.out.println();
        System.out.println("   Agora com a turma lotada, e o aviso a coordenacao falhando:");
        try {
            fachada.matricular(egresso, "DSM-2B", new DescontoEgresso(), true);
        } catch (IllegalStateException e) {
            System.out.println("   [erro] " + e.getMessage());
        }
        System.out.println("   >> DESLIZE 2: a falha de UMA reacao impediu a auditoria,");
        System.out.println("      que vinha depois dela. E a quinta reacao sera a quinta");
        System.out.println("      alteracao nesta mesma classe.");

        System.out.println();
        System.out.println("Sua tarefa: ver o README.md e a ficha de atividade pratica.");
    }
}
