package employees;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public abstract class Employee {
    Scanner scan = new Scanner(System.in);
    protected String name;
    protected String employeeType;
    protected int age;
    protected int cpf;
    protected boolean syndicate;
    protected String address;
    protected String paymentMethod;

    public Employee(String name){
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;  // Retirar \n
    }

    public String getName() {
        return name;
    }

    public void setCpf(int cpf) {
        // Check cpf
        this.cpf = cpf;
    }

    public int getCpf() {
        return cpf;
    }

    public void setSyndicate(@NotNull String syndicate) {
        this.syndicate = syndicate.equals("Y");
    }

    public boolean getSyndicate() {
        return this.syndicate;
    }

    public void setAddress(String address) {
        this.address = address;
        // check only first line input
    }

    public String getAddress() {
        return this.address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethod() {
        return this.paymentMethod;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getEmployeeType() {
        return this.employeeType;
    }

    public abstract String definePayment(String paymentType);

    public void printEmployee() {
        System.out.println("CPF: " + this.getCpf() + " Name: " + this.getName() +
                "\nAge: " + this.getAge() +
                "\nAddress: " + this.getAddress() +
                "\nSyndicate: " + this.getSyndicate() +
                "\nType: " + this.getEmployeeType() +
                "\nPayment method: " + this.getPaymentMethod());
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.getName();
    }
}