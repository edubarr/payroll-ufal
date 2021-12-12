package employees;

public class Unionist extends Employee {
    private double unionFee;
    private int unionId;

    public Unionist(String name, int id)
    {
        setName(name);
        setId(id);
    }

    public void setUnionFee(double unionFee) {
        this.unionFee = unionFee;
    }

    public double getUnionFee() {
        return unionFee;
    }

    public void setUnionId(int UnionId){
        this.unionId = UnionId;
    }

    public int getUnionId() {
        return unionId;
    }

}
