// generated with ast extension for cup
// version 0.8
// 13/5/2019 19:21:6


package rs.ac.bg.etf.pp1.ast;

public class NumConst extends AnyConst {

    private Integer numValue;

    public NumConst (Integer numValue) {
        this.numValue=numValue;
    }

    public Integer getNumValue() {
        return numValue;
    }

    public void setNumValue(Integer numValue) {
        this.numValue=numValue;
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
        buffer.append("NumConst(\n");

        buffer.append(" "+tab+numValue);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NumConst]");
        return buffer.toString();
    }
}
