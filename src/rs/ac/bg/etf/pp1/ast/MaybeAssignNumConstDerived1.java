// generated with ast extension for cup
// version 0.8
// 16/4/2019 21:19:58


package rs.ac.bg.etf.pp1.ast;

public class MaybeAssignNumConstDerived1 extends MaybeAssignNumConst {

    private Integer value;

    public MaybeAssignNumConstDerived1 (Integer value) {
        this.value=value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value=value;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MaybeAssignNumConstDerived1(\n");

        buffer.append(" "+tab+value);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MaybeAssignNumConstDerived1]");
        return buffer.toString();
    }
}
