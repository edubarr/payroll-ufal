import employees.Employee;
import employees.Unionist;
import utils.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class InitMenu {

    public void run() {
        Scanner input = new Scanner(System.in);

        ArrayList<Employee> employees = new ArrayList<>();
        ArrayList<Unionist> unionists = new ArrayList<>();
        ArrayList<String> schedules = PaymentSchedule.createDefault();

        Stack<State> stateNow = new Stack<>();
        Stack<State> stateUndo = new Stack<>();

        State initialState = new State(employees, unionists, schedules);
        stateNow.add(initialState);

        System.out.println("\n##########################################");
        System.out.println("##### Folha de pagamento v0.1 Alpha #####");
        System.out.println("##########################################\n");

        boolean exit = false;
        int uniqueID = 0;
        while (!exit) {

            System.out.println("""
                    Escolha uma opção:
                                        
                    0 - DEV: Debug
                    1 - Adicionar empregado
                    2 - Remover empregado
                    3 - Lançar cartão de ponto
                    4 - Lançar resultado de venda
                    5 - Lançar taxa de serviço
                    6 - Alterar dados de empregado
                    7 - Rodar folha de pagamento (Hoje)
                    8 - Alterar agenda de pagamento de empregado
                    9 - Criar / Alterar agendas de pagamento
                    10 - Desfazer/Refazer alteração
                    11 - Listar empregados
                    12 - Listar filiados sindicais
                    13 - Sair do sistema
                    """);

            int selection = input.nextInt();

            switch (selection) {
                case 0 -> {
                    System.out.println("Selecionada opção 0 - Debug - em implementação\n");
                    System.out.println("statenow:");
                    System.out.println(stateNow);

                    System.out.println("stateUndo");
                    System.out.println(stateUndo);

                    System.out.println("statenow peek:");
                    System.out.println(stateNow.peek().getEmployees());
                }
                case 1 -> {
                    System.out.println("1 - Cadastro de empregado - Em testes\n"); //TODO: Tratar inputs!
                    uniqueID++;
                    Employee newEmployee = ManageEmployees.create(uniqueID);
                    if (newEmployee != null) {
                        employees.add(newEmployee);
                        if (newEmployee.getUnion()) {
                            Unionist newUnionist = Union.create(newEmployee.getName(), uniqueID);
                            unionists.add(newUnionist);
                            System.out.println("Empregado filiado ao sindicato pela Matrícula: " + newUnionist.getUnionId());
                        }

                        stateNow.push(State.update(employees, unionists, schedules));

                        System.out.println("Empregado criado com sucesso!");
                        System.out.print("\n");
                    } else {
                        System.out.println("Erro ao criar novo empregado!");
                    }
                } // OK
                case 2 -> {
                    System.out.println("2 - Remoção de empregado - Em testes");
                    if (employees.isEmpty()) {
                        System.out.println("Nenhum empregado cadastrado!");
                    } else {
                        ManageEmployees.remove(employees, unionists);
                    }

                    stateNow.push(State.update(employees, unionists, schedules));
                } // OK
                case 3 -> {
                    System.out.println("3 - Lançar cartão de ponto - Em testes");
                    if (employees.isEmpty()) {
                        System.out.println("Nenhum empregado cadastrado!");
                    } else {
                        TimeCard.add(employees);
                    }

                    stateNow.push(State.update(employees, unionists, schedules));
                } // OK
                case 4 -> {
                    System.out.println("4 - Lançar resultado de venda - Em testes");
                    if (employees.isEmpty()) {
                        System.out.println("Nenhum empregado cadastrado!");
                    } else {
                        SalesCommission.add(employees);
                    }

                    stateNow.push(State.update(employees, unionists, schedules));
                } // OK
                case 5 -> {
                    System.out.println("5 - Lançar taxa de serviço - Em testes");
                    if (employees.isEmpty()) {
                        System.out.println("Nenhum empregado cadastrado!");
                    } else {
                        Union.addServiceFee(unionists);
                    }

                    stateNow.push(State.update(employees, unionists, schedules));
                } // OK
                case 6 -> {
                    System.out.println("6 - Alterar dados de empregado - Em testes");
                    if (employees.isEmpty()) {
                        System.out.println("Nenhum empregado cadastrado!");
                    } else {
                        ManageEmployees.update(schedules, employees, unionists);
                    }

                    stateNow.push(State.update(employees, unionists, schedules));
                } // OK
                case 7 -> {
                    System.out.println("7 - Rodar folha de pagamento - em implementação\n");
                    if (employees.isEmpty()) {
                        System.out.println("Nenhum empregado cadastrado!");
                    } else {
                        Payroll.run(employees, unionists, schedules);
                    }
                    stateNow.push(State.update(employees, unionists, schedules));
                } // OK - NECESSITA TESTES
                case 8 -> {
                    System.out.println("8 - Alterar agenda de pagamento do empregado - Em testes");
                    if (employees.isEmpty()) {
                        System.out.println("Nenhum empregado cadastrado!");
                    } else {
                        PaymentSchedule.choose(schedules, employees);
                    }

                    stateNow.push(State.update(employees, unionists, schedules));
                } // OK
                case 9 -> {
                    System.out.println("9 - Criar / Alterar agendas de pagamento - em testes\n");
                    if (employees.isEmpty()) {
                        System.out.println("Nenhum empregado cadastrado!");
                    } else {
                        PaymentSchedule.manage(schedules);
                    }

                    stateNow.push(State.update(employees, unionists, schedules));
                } // OK
                case 10 -> {
                    System.out.println("10 - Desfazer/Refazer  - em implementação\n");
                    State newState = State.menu(stateNow, stateUndo);
                    if (newState != null) {
                        employees = new ArrayList<Employee>(newState.getEmployees());
                        unionists = new ArrayList<Unionist>(newState.getUnionists());
                        schedules = new ArrayList<String>(newState.getSchedules());
                    } else {
                        System.out.println("Erro ao Desfazer / Refazer!");
                    }
                }
                case 11 -> {
                    if (employees.isEmpty()) {
                        System.out.println("\n\n{!} Nenhum empregado cadastrado.\n");
                    } else {
                        System.out.println("\n\n" + employees.size() + " empregados cadastrados.\n");
                        for (Employee employee : employees) {
                            ManageEmployees.print(schedules, employee);
                        }
                    }
                    System.out.println("Selecionada opção 12 - Listar empregados - em testes\n");
                } // OK
                case 12 -> {
                    if (unionists.isEmpty()) {
                        System.out.println("\n\n{!} Nenhum filiado cadastrado.\n");
                    } else {
                        System.out.println("\n\n" + unionists.size() + " filiados cadastrados.\n");
                        for (Unionist unionist : unionists) {
                            Union.list(unionist);
                        }
                    }
                    System.out.println("Selecionada opção 13 - Listar filiados sindicais - em testes\n");
                } // OK
                case 13 -> {
                    System.out.println("Saindo do sistema, até logo...\n");
                    exit = true;
                } // OK
                default -> // OK
                        System.out.println("Opção inválida, favor selecionar uma das opções disponíveis:\n");
            }
        }
    }
}