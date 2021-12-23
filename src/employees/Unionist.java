package employees;

public class Unionist extends Employee {
    private double totalServicesFee;
    private double unionFee;
    private int unionId;


    public Unionist(String name, int id) {
        setName(name);
        setId(id);
        totalServicesFee = 0;
    }

    public void setUnionId(int UnionId) {
        this.unionId = UnionId;
    }

    public int getUnionId() {
        return unionId;
    }

    public void setUnionFee(double unionFee) {
        this.unionFee = unionFee;
    }

    public double getUnionFee() {
        return unionFee;
    }

    public void addServiceFee(double serviceFee) {
        totalServicesFee += serviceFee;
    }

    public double getTotalServicesFee() {
        return this.totalServicesFee;
    }
}
