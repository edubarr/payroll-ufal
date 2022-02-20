package utils;

import employees.*;

import java.util.ArrayList;

public class Payroll {

    public static void run(ArrayList<Employee> employees, ArrayList<Unionist> unionists, ArrayList<String> schedules) {
        System.out.println("Rodando folha de pagamento para hoje");

        for (String schedule : schedules.subList(1, schedules.size())) {

            System.out.println("Agenda: " + schedule + ":\n");

            for (Employee employee : employees) {

                Unionist unionist = Union.find(unionists, Union.calculateUnionId(employee.getId()));

                if (employee instanceof Salaried) {
                    salariedPay((Salaried) employee, unionist, schedule, schedules);
                } else if (employee instanceof Commissioned) {
                    commissionedPay((Commissioned) employee, unionist, schedule, schedules);
                } else if (employee instanceof Hourly) {
                    hourlyPay((Hourly) employee, unionist, schedule, schedules);
                }
            }
        }

    }

    private static int getDays(String schedule){

        return switch (schedule) {
            case "Semanalmente" -> 7;
            case "Quinzenalmente" -> 15;
            case "Mensalmente" -> 30;
            default -> 0;
        };
    }

    private static void salariedPay(Salaried employee, Unionist unionist, String schedule, ArrayList<String> schedules) {
        if (schedule.equals(schedules.get(employee.getPaymentSchedule()))) {
            employee.setWorkedDay();
            int days = getDays(schedule);

            if (employee.getWorkedDays() == days) {
                System.out.println(employee.getName() + ":");
                System.out.println("Pagamento Bruto: $" + employee.getSalary());
                if (unionist != null) {
                    System.out.println("Contribuição sindical: $" + unionist.getUnionFee() + "\nTaxas sindicais: $" + unionist.getTotalServicesFee());
                    System.out.println("Pagamento líquido: $" + (employee.getSalary() - unionist.getUnionFee() - unionist.getTotalServicesFee()) + "\n");
                }
                else {
                    System.out.println("Pagamento líquido: $" + employee.getSalary() + "\n");
                }
                employee.resetWorkedDays();
            } else {
                System.out.println("Empregado: " + employee.getName() + " sem pagamentos a receber\n");
            }
        }
    }

    private static void commissionedPay(Commissioned employee, Unionist unionist, String schedule, ArrayList<String> schedules) {
        if (schedule.equals(schedules.get(employee.getPaymentSchedule()))) {
            employee.setWorkedDay();
            int days = getDays(schedule);

            if (employee.getWorkedDays() == days) {
                System.out.println(employee.getName());
                System.out.println("Salário: $" + employee.getSalary());
                System.out.println("Comissões: $" + employee.getTotalComm());
                System.out.println("Salário Bruto Total: $" + (employee.getSalary() + employee.getTotalComm()));
                if (unionist != null) {
                    System.out.println("Contribuição sindical: $" + unionist.getUnionFee() + "\nTaxas sindicais: $" + unionist.getTotalServicesFee());
                    System.out.println("Pagamento líquido: $" + (employee.getSalary() + employee.getTotalComm() - unionist.getUnionFee() - unionist.getTotalServicesFee()) + "\n");
                }
                else {
                    System.out.println("Pagamento líquido: $" + (employee.getSalary() + employee.getTotalComm()) + "\n");
                }
                employee.resetWorkedDays();
                employee.resetTotalComm();
            } else {
                System.out.println("Empregado: " + employee.getName() + " sem pagamentos a receber\n");
            }
        }

    }

    private static void hourlyPay(Hourly employee, Unionist unionist, String schedule, ArrayList<String> schedules) {
        if (schedule.equals(schedules.get(employee.getPaymentSchedule()))) {
            int days = getDays(schedule);

            if (employee.getWorkedDays() == days) {
                System.out.println("Empregado: " + employee.getName());
                System.out.println("Horas trabalhadas: $" + employee.getWorkedHours());
                System.out.println("Salário Bruto Total: $" + employee.getGrossRevenue());
                if (unionist != null) {
                    System.out.println("Contribuição sindical: $" + unionist.getUnionFee() + "\nTaxas sindicais: $" + unionist.getTotalServicesFee());
                    System.out.println("Pagamento líquido: $" + (employee.getGrossRevenue() - unionist.getUnionFee() - unionist.getTotalServicesFee()) + "\n");
                }
                else {
                    System.out.println("Pagamento líquido: $" + employee.getGrossRevenue() + "\n");
                }
                employee.resetWorkedDays();
                employee.resetWorkedHours();
                employee.resetGrossRevenue();
            } else {
                System.out.println("Empregado " + employee.getName() + " sem pagamentos a receber\n");
            }
        }

    }
}
