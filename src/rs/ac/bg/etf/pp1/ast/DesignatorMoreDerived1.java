// generated with ast extension for cup
// version 0.8
// 29/3/2019 20:58:3


package rs.ac.bg.etf.pp1.ast;

public class DesignatorMoreDerived1 extends DesignatorMore {

    public DesignatorMoreDerived1 () {
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
        buffer.append("DesignatorMoreDerived1(\n");

        buffer.append(tab);
        buffer.append(") [DesignatorMoreDerived1]");
        return buffer.toString();
    }
}
