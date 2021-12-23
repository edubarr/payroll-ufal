import employees.Commissioned;
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
        stateUndo.add(initialState);

        System.out.println("\n##########################################");
        System.out.println("##### Folha de pagamento v0.1 Alpha ######");
        System.out.println("##########################################\n");

        boolean exit = false;
        int uniqueID = 0;
        while (!exit) {

            System.out.println("""
                    Escolha uma opção:
                                        
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
                    System.out.println("state now:");
                    System.out.println(stateNow);

                    System.out.println("state Undo");
                    System.out.println(stateUndo);

                    System.out.println("state now peek:");
                    System.out.println(stateNow.peek().getEmployees());

                    System.out.println("state undo peek:");
                    System.out.println(stateUndo.peek().getEmployees());
                }
                case 1 -> {
                    System.out.println("1 - Cadastro de empregado\n");
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

                        System.out.println("Empregado criado com sucesso!\n");
                    } else {
                        System.out.println("Erro ao criar novo empregado!\n");
                    }
                } // OK
                case 2 -> {
                    System.out.println("2 - Remoção de empregado\n");
                    if (employees.isEmpty()) {
                        System.out.println("Nenhum empregado cadastrado!\n");
                    } else {
                        ManageEmployees.remove(employees, unionists);

                        stateNow.push(State.update(employees, unionists, schedules));
                    }
                } // OK
                case 3 -> {
                    System.out.println("3 - Lançar cartão de ponto\n");
                    if (employees.isEmpty()) {
                        System.out.println("Nenhum empregado cadastrado!\n");
                    } else {
                        TimeCard.add(employees);

                        stateNow.push(State.update(employees, unionists, schedules));
                    }
                } // OK
                case 4 -> {
                    System.out.println("4 - Lançar resultado de venda\n");
                    if (employees.isEmpty()) {
                        System.out.println("Nenhum empregado cadastrado!\n");
                    } else {
                        Commissioned.addCommission(employees);

                        stateNow.push(State.update(employees, unionists, schedules));
                    }
                } // OK
                case 5 -> {
                    System.out.println("5 - Lançar taxa de serviço\n");
                    if (employees.isEmpty()) {
                        System.out.println("Nenhum empregado cadastrado!\n");
                    } else {
                        Union.addServiceFee(unionists);

                        stateNow.push(State.update(employees, unionists, schedules));
                    }
                } // OK
                case 6 -> {
                    System.out.println("6 - Alterar dados de empregado\n");
                    if (employees.isEmpty()) {
                        System.out.println("Nenhum empregado cadastrado!\n");
                    } else {
                        ManageEmployees.update(schedules, employees, unionists);

                        stateNow.push(State.update(employees, unionists, schedules));
                    }
                } // OK
                case 7 -> {
                    System.out.println("7 - Rodar folha de pagamento\n");
                    if (employees.isEmpty()) {
                        System.out.println("Nenhum empregado cadastrado!\n");
                    } else {
                        Payroll.run(employees, unionists, schedules);

                        stateNow.push(State.update(employees, unionists, schedules));
                    }
                } // OK
                case 8 -> {
                    System.out.println("8 - Alterar agenda de pagamento do empregado\n");
                    if (employees.isEmpty()) {
                        System.out.println("Nenhum empregado cadastrado!\n");
                    } else {
                        PaymentSchedule.choose(schedules, employees);

                        stateNow.push(State.update(employees, unionists, schedules));
                    }
                } // OK
                case 9 -> {
                    System.out.println("9 - Criar / Alterar agendas de pagamento\n");
                    if (employees.isEmpty()) {
                        System.out.println("Nenhum empregado cadastrado!\n");
                    } else {
                        PaymentSchedule.manage(schedules);

                        stateNow.push(State.update(employees, unionists, schedules));
                    }
                } // OK
                case 10 -> {
                    System.out.println("10 - Desfazer/Refazer\n");
                    State newState = State.menu(stateNow, stateUndo);
                    if (newState != null) {
                        employees = new ArrayList<>(newState.getEmployees());
                        unionists = new ArrayList<>(newState.getUnionists());
                        schedules = new ArrayList<>(newState.getSchedules());
                    }
                }
                case 11 -> {
                    System.out.println("11 - Listar empregados\n");
                    if (employees.isEmpty()) {
                        System.out.println("{!} Nenhum empregado cadastrado.\n\n");
                    } else {
                        System.out.println("\n\n" + employees.size() + " empregados cadastrados.\n");
                        for (Employee employee : employees) {
                            ManageEmployees.print(schedules, employee);
                        }
                    }
                } // OK
                case 12 -> {
                    System.out.println("12 - Listar filiados sindicais\n");
                    if (unionists.isEmpty()) {
                        System.out.println("{!} Nenhum filiado cadastrado.\n\n");
                    } else {
                        System.out.println("\n\n" + unionists.size() + " filiados cadastrados.\n");
                        for (Unionist unionist : unionists) {
                            Union.list(unionist);
                        }
                    }
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