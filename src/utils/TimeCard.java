package utils;

import employees.Employee;
import employees.Hourly;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class TimeCard {

    public static void add(ArrayList<Employee> employees) {
        Scanner input = new Scanner(System.in);
        int employeeId;

        System.out.println("Informe a matrícula do empregado: ");
        employeeId = input.nextInt();

        if (ManageEmployees.find(employees, employeeId) == null) {
            System.out.println("Não foi localizado empregado com a matrícula informada\n");
        }
        else if (ManageEmployees.find(employees, employeeId) instanceof Hourly employee) {
            System.out.println("Insira a data e hora do início da jornada [dd-MM-yyyy HH:mm]: ");
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            input.nextLine();
            LocalDateTime startTime = LocalDateTime.parse(input.nextLine(), dateFormat);

            System.out.println("Insira a data e hora do final da jornada [dd-MM-yyyy HH:mm]: ");
            LocalDateTime finishTime = LocalDateTime.parse(input.nextLine(), dateFormat);

            String timeBetween = Duration.between(startTime, finishTime).toString();

            double workedHours = Duration.parse(timeBetween).toHours();

            employee.setWorkedDay();
            employee.setWorkedHours(workedHours);

            double dayIncome = employee.getDayIncome();

            employee.setGrossRevenue(dayIncome);

            System.out.println("Cartão de ponto cadastrado com sucesso!");
            System.out.println("Valor a receber por este dia trabalhado: " + dayIncome);
            System.out.print("\n");

        } else {
            System.out.println("Empregado não é Horista!\n");
        }
    }
}
