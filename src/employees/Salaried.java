package employees;

public class Salaried extends Employee {

    private double salary;
    private int workedDays;

    public Salaried(int uniqueID, String name, String address, int paymentMethod, int paymentSchedule) {
        this.id = uniqueID;
        this.name = name;
        this.address = address;
        this.paymentMethod = paymentMethod;
        this.paymentSchedule = paymentSchedule;
        this.employeeType = "Assalariado";
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

    @Override
    public void setPaymentSchedule(int paymentSchedule) {
        super.setPaymentSchedule(paymentSchedule);
    }

}