package utils;

import employees.Unionist;

import java.util.ArrayList;
import java.util.Scanner;

public class Union {

    public static int calculateUnionId(int employeeId) {
        return ((employeeId * 100) + 5);
    }

    public static Unionist find(ArrayList<Unionist> unionists, int unionId) {
        for (Unionist unionist : unionists) {
            if (unionist.getUnionId() == unionId) {
                return unionist;
            }
        }
        return null;
    }

    public static void addServiceFee(ArrayList<Unionist> unionists) {
        Scanner input = new Scanner(System.in);
        int unionId;

        System.out.println("Informe a matrícula sindical do empregado: ");
        unionId = input.nextInt();

        Unionist unionist = Union.find(unionists, unionId);
        if (unionist != null) {
            System.out.println("Informe o valor da taxa de serviço: ");
            unionist.addServiceFee(input.nextDouble());
            System.out.println("Taxa de serviço cadastrada com sucesso!\n");
        } else {
            System.out.println("Não foi localizado sindicalista com a matrícula informada\n");
        }
    }

    public static void list(Unionist unionist) {

        System.out.println("\nMatrícula do empregado: " + unionist.getId() + "\nMatrícula sindical do empregado: " + unionist.getUnionId());
        System.out.println("Nome: " + unionist.getName() + "\nContribuição sindical atual: $" + unionist.getUnionFee());
        System.out.println("\nTotal de taxas de serviço:" + unionist.getTotalServicesFee());

    }

    public static Unionist create(String name, int id) {
        Unionist newUnionist = new Unionist(name, id);
        newUnionist.setUnionId(calculateUnionId(id));

        Scanner input = new Scanner(System.in);
        System.out.println("Informe a contribuição sindical [XXXX,XX]:");
        newUnionist.setUnionFee(input.nextDouble());

        return newUnionist;
    }

    public static void remove(ArrayList<Unionist> unionists, int unionId) {
        unionists.remove(Union.find(unionists, unionId));
    }
}
