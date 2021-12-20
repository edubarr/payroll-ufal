package utils;

import employees.Employee;

import java.util.ArrayList;
import java.util.Scanner;

public class PaymentSchedule {

    public static ArrayList<String> createDefault() {
        ArrayList<String> schedules = new ArrayList<>();
        String hourlyDefault = "Semanalmente";
        String commissionedDefault = "Quinzenalmente";
        String salariedDefault = "Mensalmente";
        schedules.add(0, "ERROR : schedules array 0");
        schedules.add(1, salariedDefault);
        schedules.add(2, commissionedDefault);
        schedules.add(3, hourlyDefault);

        return schedules;
    }

    public static void manage(ArrayList<String> schedules) {
        System.out.println("""
                Escolha uma opção:
                                    
                1 - Alterar agendas padrão
                2 - Criar nova agenda
                3 - Listar todas as agendas
                4 - Apagar agenda
                """);

        int option;

        Scanner input = new Scanner(System.in);

        option = input.nextInt();
        input.nextLine();

        switch (option) {
            case 1 -> changeDefault(schedules);
            case 2 -> add(schedules);
            case 3 -> listAll(schedules);
            case 4 -> delete(schedules);
            default -> System.out.println("Opção inválida!");
        }
    }

    @SuppressWarnings("SuspiciousListRemoveInLoop")
    private static void changeDefault(ArrayList<String> schedules) {
        System.out.println("Agendas de pagamento padrão atual [Assalariado, Comissionado e Horista respectivamente]: ");
        int index = 1;
        for (String schedule : schedules.subList(1, 4)) {
            System.out.println((index++) + " - " + schedule);
        }

        System.out.println("Digite as novas agendas de pagamento padrão para os tipos [Assalariado, Comissionado e Horista respectivamente] uma por uma entre as disponíveis abaixo (Caso não deseja alterar algum tipo, confirme em branco): ");
        listAll(schedules);

        Scanner input = new Scanner(System.in);
        String newSchedule;
        for (int i = 1; i < 4; i++) {
            newSchedule = input.nextLine();
            if (!newSchedule.isEmpty()) {
                schedules.remove(i);
                schedules.add(i, newSchedule);
            }
        }
    }

    private static void add(ArrayList<String> schedules) {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite a nova agenda de pagamento: ");
        String newSchedule = input.nextLine();

        schedules.add(newSchedule);

        System.out.println("Nova agenda adicionada com sucesso! Agendas disponíveis: ");
        listAll(schedules);

    }

    private static void delete(ArrayList<String> schedules) {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite a agenda de pagamento que deseja apagar (exceto agendas padrão 1-3): ");
        int schedule = input.nextInt();

        if (schedule > 3){
            schedules.remove(schedule);
        }

        System.out.println("Agenda" + schedule + "apagada com sucesso! Agendas disponíveis: ");
        listAll(schedules);
    }

    public static void listAll(ArrayList<String> schedules) {
        int index = 1;
        for (String schedule : schedules.subList(1, schedules.size())) {
            System.out.println((index++) + " - " + schedule);
        }
    }

    private static boolean exists(ArrayList<String> schedules, int choice) {
        return choice < schedules.size() && choice != 0;
    }

    public static void choose(ArrayList<String> schedules, ArrayList<Employee> employees) {
        Scanner input = new Scanner(System.in);
        System.out.println("Informe a matrícula do empregado:");
        int id = input.nextInt();
        input.nextLine();

        Employee employee = ManageEmployees.find(employees, id);

        if (employee != null) {
            System.out.println("Agenda de pagamento atual: " + employee.getPaymentSchedule());
            System.out.println("Escolha a nova agenda de pagamento dentre as opções abaixo: ");
            listAll(schedules);

            int choice = input.nextInt();

            if (exists(schedules, choice)) {
                employee.setPaymentSchedule(choice);
                System.out.println("Agenda alterada com sucesso!");
            } else {
                System.out.println("Agenda não disponível, ou mal digitada, tente novamente ou realize o cadastro da agenda");
            }
        }
    }
}