## Etapa 1 — Divergência identificada
A divergência é esta no ImportadorAlunos.java: aluno.setAtivo("A".equals(linha[2])), aqui só "A" maiúsculo é considerado ativo. 
No RelatorioSituacao.java: aluno.setAtivo("A".equalsIgnoreCase(linha[2])), aqui "A" e "a" são considerados ativos.
Por isso a aluna 2024003 - Ana Pereira - situação "a", fica inativa no importador e ativa no relatório.