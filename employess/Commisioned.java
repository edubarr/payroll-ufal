package employess;

public class Commissioned extends Employee {

    private double commission;

    public Commissioned(String name, double commission) {
        super(name);s
        this.commission = commission;
    }

    @Override
    public String definePayment(String paymentType) {
        // TODO Auto-generated method stub
        return null;
    }
}
