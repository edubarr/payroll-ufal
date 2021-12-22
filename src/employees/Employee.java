package employees;

public abstract class Employee {
    protected String name;
    protected String employeeType;
    protected int id;
    protected boolean union = false;
    protected String address;
    protected int paymentMethod;
    protected int paymentSchedule;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
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

    public void setUnion(boolean union) {
        this.union = union;
    }

    public boolean getUnion() {
        return this.union;
    }

    public void setPaymentMethod(int paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getPaymentMethod() {
        return this.paymentMethod;
    }

    public void setPaymentSchedule(int paymentSchedule) {
        this.paymentSchedule = paymentSchedule;
    }

    public int getPaymentSchedule() {
        return this.paymentSchedule;
    }

    public String getEmployeeType() {
        return this.employeeType;
    }
    
}