## Diagrama de Sequência

```mermaid
sequenceDiagram
    participant Main
    participant Matricula
    participant Desconto

    Main ->> Matricula : calcularMensalidade()
    Matricula ->> Desconto : calcularDesconto(valorBase)

    Desconto -->> Matricula : valor calculado
    Matricula -->> Main : mensalidade
```