# SIGA — Atividade de padrões comportamentais: Strategy e Observer 

## Etapa 1 - Divergência nas políticas de desconto
Foi observado que em Matricula.java a Classe possui três condicoes, if o aluno é bolsista, if o aluno é servidor ou if aluno é egresso, todavia na Classe GeradorBoleto.java a condicao para alunos egressos não existe, desta forma a aluna Ana Pereira que está cadastrada como egresso deveria receber um desconto de 10% sobre o valor base, porém ao gerar o boleto o desconto não é aplicado.

