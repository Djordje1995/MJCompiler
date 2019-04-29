// generated with ast extension for cup
// version 0.8
// 29/3/2019 10:23:43


package rs.ac.bg.etf.pp1.ast;

public class IdentMaybeConstListDerived1 extends IdentMaybeConstList {

    public IdentMaybeConstListDerived1 () {
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
        buffer.append("IdentMaybeConstListDerived1(\n");

        buffer.append(tab);
        buffer.append(") [IdentMaybeConstListDerived1]");
        return buffer.toString();
    }
}
