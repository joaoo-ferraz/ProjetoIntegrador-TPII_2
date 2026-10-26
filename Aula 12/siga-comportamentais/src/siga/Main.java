package siga;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== SIGA - Aula 12: Strategy e Observer ===");

        Aluno bolsista = new Aluno("2024001", "Maria Silva");
        bolsista.setBolsista(true);

        Aluno egresso = new Aluno("2024003", "Ana Pereira");
        egresso.setEgresso(true);

        double valorBase = 800.00;
        GeradorBoleto gerador = new GeradorBoleto();

        Matricula[] matriculas = {
                new Matricula(bolsista, "DSM-2A", new DescontoBolsista(), false),
                new Matricula(egresso, "DSM-2A", new DescontoEgresso(), false)
        };

        System.out.println();     
        for (Matricula m : matriculas) {
            System.out.printf("   %-14s matricula: R$ %.2f%n",
                    m.getAluno().getNome(), m.calcularValor(valorBase));
            gerador.emitir(m, valorBase);
        }

        System.out.println();
        PublicadorMatricula publicador = new PublicadorMatricula();
        publicador.registrar(new NotificadorEmail());
        publicador.registrar(new PainelVagas());
        publicador.registrar(new AvisoCoordenacao());
        publicador.registrar(new RegistroAuditoria());
        FachadaMatricula fachada = new FachadaMatricula(publicador);

        fachada.matricular(bolsista, "DSM-2A", new DescontoBolsista(), false);
        fachada.matricular(egresso, "DSM-2B", new DescontoEgresso(), true);
    }
}
