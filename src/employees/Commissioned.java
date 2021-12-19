package employees;

public class Commissioned extends Employee {

    private double salary;
    private double commPerSale;
    private double totalComm;

    public Commissioned(int uniqueID, String name, String address, int paymentMethod, String paymentSchedule) {
        this.id = uniqueID;
        this.name = name;
        this.address = address;
        this.paymentMethod = paymentMethod;
        this.paymentSchedule = paymentSchedule;
        this.employeeType = "Comissionado";
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
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


    @Override
    public void setPaymentSchedule(String paymentSchedule) {
        super.setPaymentSchedule(paymentSchedule);
    }


}
