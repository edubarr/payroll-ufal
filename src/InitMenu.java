import employees.Employee;
import employees.Unionist;
import utils.CreateEmployee;
import utils.ListEmployees;
import utils.PaymentSchedule;

import java.util.ArrayList;
import java.util.Scanner;

import static utils.ListEmployees.*;

public class InitMenu {

    public void run() {
        Scanner input = new Scanner(System.in);

        ArrayList<Employee> employees = new ArrayList<>();
        ArrayList<Unionist> unionists = new ArrayList<>();

        ArrayList<String> schedules = PaymentSchedule.createDefault();

        System.out.println("\n##########################################");
        System.out.println("##### Folha de pagamento v0.1 Alpha #####");
        System.out.println("##########################################\n");

        boolean exit = false;
        int uniqueID = 0;
        while (!exit) {

            System.out.println("Escolha uma opção:");
            System.out.println("0 - DEV: Debug");
            System.out.println("1 - Adicionar empregado");
            System.out.println("2 - Remover empregado");
            System.out.println("3 - Lançar cartão de ponto");
            System.out.println("4 - Lançar resultado de venda");
            System.out.println("5 - Lançar taxa de serviço");
            System.out.println("6 - Alterar dados de empregado");
            System.out.println("7 - Rodar folha de pagamento (Hoje)");
            System.out.println("8 - Alterar agenda de pagamento");
            System.out.println("9 - Criar agenda de pagamento");
            System.out.println("10 - Desfazer/Refazer alteração");
            System.out.println("11 - Listar empregados");
            System.out.println("12 - Listar filiados sindicais");
            System.out.println("13 - Sair do sistema\n");

            int selection = input.nextInt();


            switch (selection) {
                case 0:
                    System.out.println("Selecionada opção 0 - Debug - em implementação\n");
                    break;
                case 1:
                    uniqueID++;
                    Employee newEmployee = CreateEmployee.create(uniqueID, schedules);

                    if (newEmployee != null) {
                        employees.add(newEmployee);
                        if (newEmployee.getSyndicate()) {
                            Unionist newUnionist = CreateEmployee.createUnionist(newEmployee.getName(), uniqueID);
                            unionists.add(newUnionist);
                            System.out.println("Empregado filiado ao sindicato pela Matrícula: " + newUnionist.getUnionId());
                        }
                        System.out.println("Empregado criado com sucesso!");
                    } else {
                        System.out.println("Erro ao criar novo empregado!");
                    }
                    System.out.println("Selecionada opção 1 - Adicionar empregado - em testes\n");
                    break;
                case 2:
                    System.out.println("Selecionada opção 2 - Remover empregado - em implementação\n");
                    break;
                case 3:
                    System.out.println("Selecionada opção 3 - Lançar cartão de ponto - em implementação\n");
                    break;
                case 4:
                    System.out.println("Selecionada opção 4 - Lançar resultado de venda - em implementação\n");
                    break;
                case 5:
                    System.out.println("Selecionada opção 5 - Lançar taxa de serviço - em implementação\n");
                    break;
                case 6:
                    System.out.println("Selecionada opção 6 - Alterar dados de empregado - em implementação\n");
                    break;
                case 7:
                    System.out.println("Selecionada opção 7 - Rodar folha de pagamento - em implementação\n");
                    break;
                case 8:
                    System.out.println("Selecionada opção 8 - Alterar agenda de pagamento - em implementação\n");
                    break;
                case 9:
                    System.out.println("Selecionada opção 9 - Criar agenda de pagamento - em implementação\n");
                    break;
                case 10:
                    System.out.println("Selecionada opção 10 - Desfazer/Refazer alterações - em implementação\n");
                    break;

                case 11:
                    if (employees.isEmpty()) {
                        System.out.println("\n\n{!} Nenhum empregado cadastrado.\n");
                    } else {
                        System.out.println("\n\n" + employees.size() + " empregados cadastrados.\n");
                        for (Employee employee : employees) {
                            listEmployee(employee, unionists);
                        }
                    }
                    System.out.println("Selecionada opção 12 - Listar empregados - em testes\n");
                    break;

                case 12:
                    if (unionists.isEmpty()) {
                        System.out.println("\n\n{!} Nenhum filiado cadastrado.\n");
                    } else {
                        System.out.println("\n\n" + unionists.size() + " filiados cadastrados.\n");
                        for (Unionist unionist : unionists) {
                            listUnionist(unionist);
                        }
                    }
                    System.out.println("Selecionada opção 13 - Listar filiados sindicais - em testes\n");
                    break;

                case 13:
                    System.out.println("Saindo do sistema, até logo...\n");
                    exit = true;
                    break;
                default:
                    System.out.println("Opção inválida, favor selecionar uma das opções disponíveis:\n");
                    break;
            }
        }
    }


}