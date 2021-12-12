package employees;

import java.util.LinkedList;

public class Hourly extends Employee {

    private double hourlyRate;
    private double workedHours;
    private int workedDays;
    private final short maxHours = 8;

    public Hourly(int uniqueID, String name, String address, int paymentMethod, String paymentSchedule) {
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

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setWorkedHours(double workedHours) {
        this.workedHours += workedHours;
    }

    public double getWorkedHours() {
        return workedHours;
    }

    public void setWorkedDay() {
        this.workedDays += 1;
    }

    public int getWorkedDays() {
        return workedDays;
    }

    public short getMaxHours() {
        return maxHours;
    }

    @Override
    public void setPaymentSchedule(String paymentSchedule) {
        super.setPaymentSchedule(paymentSchedule);
    }

}