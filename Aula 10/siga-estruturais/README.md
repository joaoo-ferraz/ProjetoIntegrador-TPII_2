## Etapa 1 — Divergência identificada
A divergência é esta no ImportadorAlunos.java: aluno.setAtivo("A".equals(linha[2])), aqui só "A" maiúsculo é considerado ativo. 
No RelatorioSituacao.java: aluno.setAtivo("A".equalsIgnoreCase(linha[2])), aqui "A" e "a" são considerados ativos.
Por isso a aluna 2024003 - Ana Pereira - situação "a", fica inativa no importador e ativa no relatório.

## Etapa 2 — Adapter
A conversão dos dados do sistema legado estava sendo feita em mais de um lugar, permitindo que regras diferentes fossem aplicadas ao mesmo dado. Foi criada uma interface para representar uma fonte de alunos e uma classe responsável por adaptar os dados retornados pelo sistema legado para objetos Aluno. Com isso, a conversão passou a existir em apenas um ponto.

## Etapa 3 — Refatoração dos clientes
O ImportadorAlunos e o RelatorioSituacao dependiam diretamente da classe SecretariaLegadoWS.
Os dois foram refatorados para depender da interface FonteDeAlunos, eles passaram a receber uma fonte de alunos por abstração, sem conhecer diretamente a classe concreta responsável pela origem dos dados.

## Etapa 4 — Facade
A tela de matrícula dependia diretamente de seis classes e também precisava conhecer a ordem correta das operações para realizar uma matrícula. Isso fazia com que a camada de apresentação conhecesse regras que não deveriam ser responsabilidade dela.
Foi criada a classe FachadaMatricula para concentrar a validação do CPF, busca do aluno, verificação de vagas, cálculo do desconto, criação da matrícula, reserva da vaga e envio da confirmação.

