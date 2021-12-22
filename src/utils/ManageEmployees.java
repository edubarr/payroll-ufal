package utils;

import employees.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ManageEmployees {

    public static Employee find(ArrayList<Employee> employees, int employeeId) {
        for (Employee employee : employees) {
            if (employee.getId() == employeeId) {
                return employee;
            }
        }
        return null;
    }

    public static Employee create(int uniqueID) {
        Scanner input = new Scanner(System.in);
        System.out.println("Matrícula: " + uniqueID);

        System.out.println("Insira o Nome: ");
        String name = input.nextLine();

        System.out.println("Insira o Endereço Completo: ");
        String address = input.nextLine();

        int paymentMethod = 0;
        while ((paymentMethod < 1) || (paymentMethod > 3)) {
            System.out.println("""
                    Escolha o método de pagamento:
                      1 - Cheque por Correios
                      2 - Cheque em mãos
                      3 - Depósito em conta bancária""");
            paymentMethod = input.nextInt();
        }

        input.nextLine();

        int jobType = 0;
        while ((jobType < 1) || (jobType > 4)) {
            System.out.println("""
                    Escolha o tipo de contratação:
                      1 - Assalariado
                      2 - Comissionado
                      3 - Horista""");
            jobType = input.nextInt();
        }

        System.out.println("É um membro do sindicato?" +
                "\n S - Sim | N - Não");
        String syndicate = input.next();


        if (jobType == 1) {
            Salaried newEmployee = new Salaried(uniqueID, name, address, paymentMethod, jobType);
            newEmployee.setUnion(syndicate.contentEquals("S"));
            System.out.println("Informe o valor da remuneração mensal (xxxx,xx): ");
            newEmployee.setSalary(input.nextDouble());
            return newEmployee;
        } else if (jobType == 2) {
            Commissioned newEmployee = new Commissioned(uniqueID, name, address, paymentMethod, jobType);
            newEmployee.setUnion(syndicate.contentEquals("S"));
            System.out.println("Informe o valor da remuneração mensal (xxxx,xx): ");
            newEmployee.setSalary(input.nextDouble());
            System.out.println("Informe o percentual da comissão por venda (xx): ");
            newEmployee.setCommPerSale(input.nextDouble() / 100);
            newEmployee.setTotalComm(0);
            return newEmployee;
        } else if (jobType == 3) {
            Hourly newEmployee = new Hourly(uniqueID, name, address, paymentMethod, jobType);
            newEmployee.setUnion(syndicate.contentEquals("S"));
            System.out.println("Informe o valor da hora trabalhada (xxxx,xx): ");
            newEmployee.setHourlyRate(input.nextDouble());
            return newEmployee;
        }


        input.nextLine();
        return null; // only if error occurred
    }

    public static void print(ArrayList<String> schedules, Employee employee) {

        System.out.println("\nMatrícula do empregado: " + employee.getId() +
                "\nNome: " + employee.getName() +
                "\nEndereço: " + employee.getAddress() +
                "\nTipo de Empregado: " + employee.getEmployeeType());

        int paymentType = employee.getPaymentMethod();
        if (paymentType == 1) {
            System.out.println("Método de pagamento: Cheque via Correios [" + schedules.get(employee.getPaymentSchedule()) + "]");
        } else if (paymentType == 2) {
            System.out.println("\nMétodo de pagamento: Cheque em mãos [" + schedules.get(employee.getPaymentSchedule()) + "]");
        } else if (paymentType == 3) {
            System.out.println("\nMétodo de pagamento: Depósito em conta [" + schedules.get(employee.getPaymentSchedule()) + "]");
        }

        System.out.print("Sindicato: ");
        if (employee.getUnion()) {
            System.out.println("Sim");
        } else {
            System.out.println("Não");
        }
    }

    public static void remove(ArrayList<Employee> employees, ArrayList<Unionist> unionists) {
        Scanner input = new Scanner(System.in);
        int employeeId;

        System.out.println("Informe a matrícula do empregado: ");
        employeeId = input.nextInt();

        Employee employee = find(employees, employeeId);

        if (employee == null) {
            System.out.println("Empregado não localizado, confira a matrícula!");
        } else if (employee.getId() == employeeId) {
            System.out.println("Empregado(a) " + employee.getName() + " será removido, tem certeza? (Esta ação também o removerá do cadastro Sindical) [S/N]");

            String delete = input.next().toLowerCase();

            if (delete.equals("s")) {
                employees.remove(employee);

                unionists.removeIf(unionist -> unionist.getUnionId() == Union.calculateUnionId(employee.getId()));

                System.out.println("Empregado removido com sucesso!");

            } else {
                System.out.println("Abortado.");
            }
        }

    }

    public static void update(ArrayList<String> schedules, ArrayList<Employee> employees, ArrayList<Unionist> unionists) {
        Scanner input = new Scanner(System.in);
        int registerType, id;

        System.out.println("Informe a matrícula do funcionário: ");
        id = input.nextInt();

        Employee employee = ManageEmployees.find(employees, id);

        if (employee != null) {
            System.out.println("\nEmpregado a ser alterado o cadastro:");
            ManageEmployees.print(schedules, employee);

            System.out.println("\nEscolha o tipo de cadastro a ser atualizado:\n1 - Funcional \n2 - Sindical");
            registerType = input.nextInt();

            switch (registerType) {
                case 1 -> {
                    System.out.println("""
                            Escolha o dado a ser atualizado:
                            1 - Nome
                            2 - Endereço
                            3 - Tipo de empregado
                            4 - Método de pagamento""");
                    int funcAction = input.nextInt();
                    input.nextLine();
                    switch (funcAction) {
                        case 1 -> {
                            System.out.println("Insira o novo nome para o empregado:");
                            employee.setName(input.nextLine());
                            System.out.println("Nome do empregado atualizado com sucesso!");
                        }
                        case 2 -> {
                            System.out.println("Insira o novo endereço para o empregado:");
                            employee.setAddress(input.nextLine());
                            System.out.println("Endereço do empregado atualizado com sucesso!");
                        }
                        case 3 -> {
                            System.out.println("""
                                    Insira o novo tipo de empregado:
                                    1 - Assalariado
                                    2 - Comissionado
                                    3 - Horista""");

                            int oldId = employee.getId();
                            String oldName = employee.getName();
                            String oldAddress = employee.getAddress();
                            int oldPaymentMethod = employee.getPaymentMethod();
                            boolean oldUnion = employee.getUnion();
                            int oldPaymentSchedule = employee.getPaymentSchedule();
                            int newType = input.nextInt();

                            switch (newType) {
                                case 1 -> {
                                    employees.remove(employee);
                                    Salaried newSalaried = new Salaried(oldId, oldName, oldAddress, oldPaymentMethod, oldPaymentSchedule);
                                    newSalaried.setUnion(oldUnion);
                                    employees.add(newSalaried);
                                    System.out.println("Informe o valor da remuneração mensal (xxxx,xx): ");
                                    newSalaried.setSalary(input.nextDouble());
                                    System.out.println("Tipo de empregado alterado para Assalariado com sucesso!");
                                }
                                case 2 -> {
                                    employees.remove(employee);
                                    Commissioned newCommissioned = new Commissioned(oldId, oldName, oldAddress, oldPaymentMethod, oldPaymentSchedule);
                                    newCommissioned.setUnion(oldUnion);
                                    employees.add(newCommissioned);
                                    System.out.println("Informe o valor da remuneração mensal (xxxx,xx): ");
                                    newCommissioned.setSalary(input.nextDouble());
                                    System.out.println("Informe o valor da comissão por venda (0,xx): ");
                                    newCommissioned.setCommPerSale(input.nextDouble());
                                    System.out.println("Tipo de empregado alterado para Comissionado com sucesso!");
                                }
                                case 3 -> {
                                    employees.remove(employee);
                                    Hourly newHourly = new Hourly(oldId, oldName, oldAddress, oldPaymentMethod, oldPaymentSchedule);
                                    newHourly.setUnion(oldUnion);
                                    employees.add(newHourly);
                                    System.out.println("Informe o valor da hora trabalhada (xxxx,xx): ");
                                    newHourly.setHourlyRate(input.nextDouble());
                                    System.out.println("Tipo de empregado alterado para Horista com sucesso!");
                                }
                                default -> System.out.println("Opção inválida! Abortando operação");
                            }
                        }
                        case 4 -> {
                            System.out.println("""
                                    Escolha o novo método de pagamento:
                                    1 - Cheque por Correios
                                    2 - Cheque em mãos
                                    3 - Depósito em conta bancária""");
                            employee.setPaymentMethod(input.nextInt());
                            System.out.println("Método de pagamento alterado com sucesso!");
                        }
                        default -> System.out.println("Opção inválida! Abortando operação");
                    }
                }
                case 2 -> {
                    int unionId = Union.calculateUnionId(id);
                    Unionist unionist = Union.find(unionists, unionId);
                    if (unionist == null) {
                        System.out.println("Empregado não é filiado ao sindicato. Deseja filiar ao sindicato?\n S - Sim | N - Não");
                        if (input.nextLine().equalsIgnoreCase("s")) {
                            Unionist newUnionist = Union.create(employee.getName(), id);
                            unionists.add(newUnionist);
                            System.out.println("Empregado filiado ao sindicato pela Matrícula: " + newUnionist.getUnionId());
                        }
                    } else {
                        System.out.println("Escolha o que deseja atualizar: \n1 - Filiação sindical \n2 - Taxa sindical");
                        int unionAction = input.nextInt();

                        switch (unionAction) {
                            case 1 -> { // TODO: Verificar valor das taxas sindicais após remoção do sindicato
                                System.out.println("Empregado filiado ao sindicato. Deseja CANCELAR a filiação ao sindicato?" +
                                        "\n S - Sim | N - Não");
                                if (input.nextLine().equalsIgnoreCase("s")) {
                                    Union.remove(unionists, unionId);
                                    System.out.println("Empregado removido do sindicato com sucesso!");
                                }
                            }
                            case 2 -> {
                                System.out.println("Insira a nova taxa sindical: ");
                                unionist.setUnionFee(input.nextDouble());
                                System.out.println("Taxa sindical atualizada com sucesso!");
                            }
                            default -> System.out.println("Opção inválida! Abortando operação");
                        }
                    }
                }
                default -> System.out.println("Opção inválida! Abortando operação");
            }
        } else {
            System.out.println("Empregado não encontrado!");
        }
    }
}
