package siga;

/**
 * Código INICIAL da atividade — contém o problema PROPOSITAL a refatorar.
 *
 * PROBLEMA — criação direta com if/else e new:
 * o método montarPainel escolhe o painel do usuário com um bloco de condicionais
 * que instancia as classes concretas diretamente (new PainelAluno(), etc.).
 * A cada novo perfil de usuário, é preciso MODIFICAR este método, acrescentando
 * mais um ramo — o que viola o Princípio Aberto/Fechado (OCP) e acopla esta
 * classe a todas as classes concretas de painel.
 *
 * Tarefa:
 *   - Etapa 2: encapsular a criação em uma Simple Factory (uma classe fábrica
 *     que recebe o tipo e devolve o Painel), removendo o "new" concreto daqui.
 *   - Etapa 3: refatorar para o padrão Factory Method (um criador abstrato com
 *     uma subclasse por perfil, que sobrescreve o método de criação).
 *   - Etapa 4: adicionar um novo perfil (ex.: "SECRETARIA") sem modificar o
 *     código existente, comprovando o respeito ao OCP.
 */

/*
    É possível identificar a violação do OCP, pois caso o sistema precise de um novo tipo de usuário, seria necessário modificar o método montarPainel,
    adicionando mais uma condicional, indicando que a classe não está fechada para modificações. Além disso, GerenciadorLogin está dependendo 
    diretamente das classes concretas de Painel, criando um acoplamento que pode dificultar extensões.
*/

public class GerenciadorLogin {

    public Painel montarPainel(CriadorPainel criador) {
        Painel painel = criador.criarPainel();
        painel.montar();
        return painel;
    }
}
