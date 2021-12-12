package employees;

public class Salaried extends Employee {

    private double salary;

    public Salaried(int uniqueID, String name, String address, int paymentMethod, String paymentSchedule) {
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

    @Override
    public void setPaymentSchedule(String paymentSchedule) {
        super.setPaymentSchedule(paymentSchedule);
    }

}