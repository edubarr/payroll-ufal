package employees;

import utils.ManageEmployees;

import java.util.ArrayList;
import java.util.Scanner;

public class Commissioned extends Employee {

    private double salary;
    private int workedDays;
    private double commPerSale;
    private double totalComm;

    public Commissioned(int uniqueID, String name, String address, int paymentMethod, int paymentSchedule) {
        this.id = uniqueID;
        this.name = name;
        this.address = address;
        this.paymentMethod = paymentMethod;
        this.paymentSchedule = paymentSchedule;
        this.employeeType = "Comissionado";
    }

    public static void addCommission(ArrayList<Employee> employees) {
        Scanner input = new Scanner(System.in);
        int employeeId;

        System.out.println("Informe a matrícula do empregado: ");
        employeeId = input.nextInt();

        if (ManageEmployees.find(employees, employeeId) == null) {
            System.out.println("Não foi localizado empregado com a matrícula informada\n");
        }
        else if (ManageEmployees.find(employees, employeeId) instanceof Commissioned employee) {
            System.out.println("Insira o valor total da venda [XXXX,XX]:");
            double saleTotal = input.nextDouble();
            double commission = (saleTotal * employee.getCommPerSale());

            employee.setTotalComm(commission);

            System.out.println("Comissão recebida por esta venda: " + commission);
            System.out.print("\n");

        } else {
            System.out.println("Empregado não é Comissionado!\n");
        }
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setWorkedDay() {
        this.workedDays += 1;
    }

    public int getWorkedDays() {
        return workedDays;
    }

    public void resetWorkedDays() {
        workedDays = 0;
    }

    public void setCommPerSale(double commPerSale) {
        this.commPerSale = commPerSale;
    }

    public double getCommPerSale() {
        return commPerSale;
    }

    public void setTotalComm(double totalComm) {
        this.totalComm += totalComm;
    }

    public double getTotalComm() {
        return totalComm;
    }

    public void resetTotalComm() {
        totalComm = 0;
    }


    @Override
    public void setPaymentSchedule(int paymentSchedule) {
        super.setPaymentSchedule(paymentSchedule);
    }


}
