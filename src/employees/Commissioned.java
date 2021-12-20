package employees;

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


    @Override
    public void setPaymentSchedule(int paymentSchedule) {
        super.setPaymentSchedule(paymentSchedule);
    }


}
