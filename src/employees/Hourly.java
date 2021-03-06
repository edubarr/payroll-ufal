package employees;

public class Hourly extends Employee {

    private double hourlyRate;
    private double workedHours;
    private double grossRevenue;
    private int workedDays;
    @SuppressWarnings("FieldCanBeLocal")
    private final short maxHours = 8;

    public Hourly(int uniqueID, String name, String address, int paymentMethod, int paymentSchedule) {
        this.id = uniqueID;
        this.name = name;
        this.address = address;
        this.paymentMethod = paymentMethod;
        this.paymentSchedule = paymentSchedule;
        this.employeeType = "Horista";
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public void setWorkedHours(double workedHours) {
        this.workedHours += workedHours;
    }

    public double getWorkedHours() {
        return workedHours;
    }

    public void resetWorkedHours() { workedHours = 0;}

    public void setWorkedDay() {
        this.workedDays += 1;
    }

    public int getWorkedDays() {
        return workedDays;
    }

    public void resetWorkedDays() {
        workedDays = 0;
    }

    public double getGrossRevenue() {
        return grossRevenue;
    }

    public void setGrossRevenue(double grossWage) {
        this.grossRevenue += grossWage;
    }

    public void resetGrossRevenue() {
        this.grossRevenue = 0.0;
    }

    public double getDayIncome(){
        if (workedHours > maxHours) {
            return ((maxHours * hourlyRate) + (workedHours - maxHours) * (hourlyRate * 1.5));
        }
        else {
            return hourlyRate * workedHours;
        }
    }

    @Override
    public void setPaymentSchedule(int paymentSchedule) {
        super.setPaymentSchedule(paymentSchedule);
    }

}