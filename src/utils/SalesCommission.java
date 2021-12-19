package utils;

import employees.Commissioned;
import employees.Employee;
import java.util.ArrayList;
import java.util.Scanner;

public class SalesCommission {

    public static void add(ArrayList<Employee> employees) {
        Scanner input = new Scanner(System.in);
        int employeeId;

        System.out.println("Informe a matrícula do empregado: ");
        employeeId = input.nextInt();

        if (ManageEmployees.find(employees, employeeId) == null) {
            System.out.println("Não foi localizado empregado com a matrícula informada");
        }
        else if (ManageEmployees.find(employees, employeeId) instanceof Commissioned employee) {
            System.out.println("Insira o valor total da venda [XXXX,XX]:");
            double saleTotal = input.nextDouble();
            double commission = (saleTotal * employee.getCommPerSale());

            employee.setTotalComm(commission);

            System.out.println("Comissão recebida por esta venda: " + commission);

        } else {
            System.out.println("Empregado não é Comissionado!");
        }
    }
}
