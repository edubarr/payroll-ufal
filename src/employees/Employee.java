package employees;

import java.util.Scanner;

public abstract class Employee {
    Scanner scan = new Scanner(System.in);
    protected String name;
    protected String employeeType;
    protected int age;
    protected int id;
    protected boolean syndicate;
    protected String address;
    protected int paymentMethod;
    protected String paymentSchedule;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setSyndicate(boolean syn) {
        this.syndicate = syn;
    }

    public boolean getSyndicate() {
        return this.syndicate;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void setPaymentMethod(int paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getPaymentMethod() {
        return this.paymentMethod;
    }

    public void setPaymentSchedule(String paymentSchedule) {
        this.paymentSchedule = paymentSchedule;
    }

    public String getPaymentSchedule() {
        return this.paymentSchedule;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getEmployeeType() {
        return this.employeeType;
    }

    public void printEmployee() {
        System.out.println("CPF: " + this.getId() + " Name: " + this.getName() +
                "\nAge: " + this.getAge() +
                "\nAddress: " + this.getAddress() +
                "\nSyndicate: " + this.getSyndicate() +
                "\nType: " + this.getEmployeeType() +
                "\nPayment method: " + this.getPaymentMethod() +
                "\n Payment schedule: " + this.getPaymentSchedule());
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.getName();
    }
}