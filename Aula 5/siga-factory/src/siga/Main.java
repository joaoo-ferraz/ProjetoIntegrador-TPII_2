package siga;

/**
 * Ponto de entrada do SIGA (código INICIAL da atividade da Aula 5).
 *
 * Demonstra, em execução, a criação de painéis por perfil. O programa
 * FUNCIONA — mas a classe GerenciadorLogin precisa ser modificada a cada
 * novo perfil. Sua tarefa é encapsular essa criação com a Simple Factory e,
 * depois, com o padrão Factory Method.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== SIGA - Atividade Factory ===\n");

        GerenciadorLogin login = new GerenciadorLogin();

        // Simulação de logins de diferentes perfis.
        login.montarPainel("ALUNO");
        System.out.println();
        login.montarPainel("PROFESSOR");
        System.out.println();
        login.montarPainel("COORDENADOR");

    }
}
