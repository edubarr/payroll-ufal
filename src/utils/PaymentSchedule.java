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

    public static void listAll(ArrayList<String> schedules) {
        for (String schedule : schedules.subList(1, schedules.size())) {
            System.out.println(schedule);
        }
    }

    private static boolean exists(ArrayList<String> schedules, String choice) {
        for (String schedule : schedules) {
            if (schedule.equals(choice)) {
                return true;
            }
        }
        return false;
    }

    public static void choose(ArrayList<String> schedules, ArrayList<Employee> employees) {
        Scanner input = new Scanner(System.in);
        System.out.println("Informe a matrícula do empregado:");
        int id = input.nextInt();
        input.nextLine();

        Employee employee = ManageEmployees.find(employees, id);

        if (employee != null) {
            System.out.println("Agenda de pagamento atual: " + employee.getPaymentSchedule());
            System.out.println("Escolha a nova agenda de pagamento dentre as opções abaixo (Digite igual o mostrado): ");
            listAll(schedules);

            String choice = input.nextLine();

            if (exists(schedules, choice)){
                employee.setPaymentSchedule(choice);
                System.out.println("Agenda alterada com sucesso!");
            }
            else{
                System.out.println("Agenda não disponível, ou mal digitada, tente novamente ou realize o cadastro da agenda");
            }
        }
    }
}