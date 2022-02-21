# payroll-ufal
Projeto de folha de pagamento da disciplina de Projeto de Software

Progresso:

AB1:

| Índice   |          Função                        | Progresso |
|:--------:|:--------------------------------------:|:---------:|
|     1    |  Adicionar empregado                   |     ✅    |
|     2    |  Remover empregado                     |     ✅    |
|     3    |  Lançar cartão de ponto                |     ✅    |
|     4    |  Lançar resultado de venda             |     ✅    |
|     5    |  Lançar taxa de serviço                |     ✅    |
|     6    |  Atualizar dados do empregado          |     ✅    |
|     7    |  Rodar folha de pagamento (hoje)       |     ✅    |
|     8    |  Alterar agenda de pagamento de empregado |     ✅    |
|     9    |  Criar / Alterar agendas de pagamento  |     ✅    |
|    10    |  Desfazer/Refazer alteração            |     ✅    |
|    11    |  Listar empregados                     |     ✅    |
|    12    |  Listar filiados sindicais             |     ✅    |
|    13    |  Sair do sistema                       |     ✅    |

AB2:
## Code Smells to Patterns
| Índice   |     Code smell      |     Método de resolução |  Classe afetada | Status | Commit |
|:--------:|:-------------------:|:-----------------------:|:---------------:|:------:|:------:|
|     1    |  Código duplicado   |     Extract Method      |     utils.Payroll     |  ✅    | [76a93a1 - refactoring using Extract Method to eliminate duplicated code](https://github.com/edubarr/payroll-ufal/commit/76a93a108ee600e113a0784f2321c2ed7205e9ef) |
|     2    |  Método muito longo | Dividir em dois métodos | utils.ManageEmployees |  ✅    | [b11e349 - refactoring to avoid long method](https://github.com/edubarr/payroll-ufal/commit/b11e349ea86d6c660757ad0e97687786f5db4b56) |
|     3    |  atribuição fora da classe | Padrão de projeto Expert | utils.TimeCard e employees.Hourly |  ✅    | [f91f0d5 - refactoring to apply Expert pattern](https://github.com/edubarr/payroll-ufal/commit/f91f0d5f416a7a654f5d32cd02167aac2f36dfd1) |