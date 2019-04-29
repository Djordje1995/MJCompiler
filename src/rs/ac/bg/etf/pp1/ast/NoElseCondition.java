// generated with ast extension for cup
// version 0.8
// 28/3/2019 13:15:21


package rs.ac.bg.etf.pp1.ast;

public class NoElseCondition extends ElseCondition {

    public NoElseCondition () {
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
        buffer.append("NoElseCondition(\n");

        buffer.append(tab);
        buffer.append(") [NoElseCondition]");
        return buffer.toString();
    }
}
