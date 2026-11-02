## Etapa 1 — Identificação da duplicação e inversão dos passos

A classe DeclaracaoVinculo registra a emissão no log antes de verificar se o aluno está regular. O aluno João Souza, matrícula 2024002, aparece no registro de emissões, mesmo que sua irregularidade impeça a emissão da declaração.
Nas três classes (HistoricoEscolar, AtestadoFrequencia e DeclaracaoVinculo), o processo de emissao que é envolvido em cinco etapas: Validar a Situacao do Aluno, Gerar o cabecalho, Gerar o corpo do documento, Gerar o rodapé e Registrar a emissão no log, se repetem nas três classes

## Etapa 5 — Inclusão do estado Concluida

Para implementar o novo estado CONCLUIDA, foram necessários apenas dois arquivos Java: Concluida.java e Confirmada.java. Não foi necessário modificar a classe Matricula.java, pois com o padrão State, as regras de transição ficam nas próprias classes de estado.
Na implementação original, seria necessário alterar as condicionais dos três métodos de transição da classe Matricula. Com o padrão State, a inclusão do novo estado se torna mais simples, sem a necessidade de modificar esses métodos.