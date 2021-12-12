package utils;

import employees.*;

import java.util.ArrayList;
import java.util.Scanner;

public class CreateEmployee {
    public static Employee create(int uniqueID, ArrayList<String> availableSchedules) {
        Scanner input = new Scanner(System.in);
        System.out.println("Matrícula: " + uniqueID);

        System.out.println("Insira o Nome: ");
        String name = input.nextLine();

        System.out.println("Insira o Endereço Completo: ");
        String address = input.nextLine();

        int paymentMethod = -1;
        while((paymentMethod < 0) || (paymentMethod > 2))
        {
            System.out.println("""
                Escolha o método de pagamento:
                  0 - Cheque por Correios
                  1 - Cheque em mãos
                  2 - Depósito em conta bancária""");
            paymentMethod = input.nextInt();
        }

        input.nextLine();

        int jobType = -1;
        while((jobType < 0) || (jobType > 3))
        {
            System.out.println("""
                Escolha o tipo de contratação:
                  0 - Assalariado
                  1 - Comissionado
                  2 - Horista""");
            jobType = input.nextInt();
        }

        System.out.println("É um membro do sindicato?" +
                "\n S - Sim | N - Não");
        String syndicate = input.next();


        if (jobType == 0) {
            Employee newEmployee = new Salaried(uniqueID, name, address, paymentMethod, availableSchedules.get(jobType));
            newEmployee.setSyndicate(syndicate.contentEquals("S"));
            return newEmployee;
        } else if (jobType == 1) {
            Employee newEmployee = new Commissioned(uniqueID, name, address, paymentMethod, availableSchedules.get(jobType));
            newEmployee.setSyndicate(syndicate.contentEquals("S"));
            return newEmployee;
        } else if (jobType == 2) {
            Employee newEmployee = new Hourly(uniqueID, name, address, paymentMethod, availableSchedules.get(jobType));
            newEmployee.setSyndicate(syndicate.contentEquals("S"));
            return newEmployee;
        }
        input.nextLine();
        return null; // only if error occurred
    }

    public static Unionist createUnionist(String name, int id) {
        Unionist newUnionist = new Unionist(name, id);
        newUnionist.setUnionId((id * 100) + 5);

        Scanner input = new Scanner(System.in);
        System.out.println("Informe a contribuição sindical [XXXX,XX]:");
        newUnionist.setUnionFee(input.nextDouble());

        return newUnionist;
    }
}

