package utils;

import employees.Employee;
import employees.Unionist;

import java.util.ArrayList;

public class ListEmployees {
    public static void listEmployee(Employee employee, ArrayList<Unionist> unionists) {

        System.out.println("\nMatrícula do empregado: " + employee.getId() +
                "\nNome: " + employee.getName() +
                "\nEndereço: " + employee.getAddress() +
                "\nTipo de Empregado: " + employee.getEmployeeType());

        int paymentType = employee.getPaymentMethod();
        if (paymentType == 0) {
            System.out.println("Método de pagamento: Cheque via Correios [" + employee.getPaymentSchedule() + "]");
        } else if (paymentType == 1) {
            System.out.println("\nMétodo de pagamento: Cheque em mãos [" + employee.getPaymentSchedule() + "]");
        } else if (paymentType == 2) {
            System.out.println("\nMétodo de pagamento: Depósito em conta [" + employee.getPaymentSchedule() + "]");
        }

        System.out.println("Sindicato: ");
        if (employee.getSyndicate())
        {
            System.out.println("Sim");
        }
        else
        {
            System.out.println("Não");
        }

        System.out.println("\n");
    }

    public static void listUnionist(Unionist unionist) {

        System.out.println("\nMatrícula do empregado: " + unionist.getId() + "\nMatrícula sindical do empregado: " + unionist.getUnionId());
        System.out.println("Nome: " + unionist.getName() + "\nContribuição sindical atual: $" + unionist.getUnionFee());

    }
}
