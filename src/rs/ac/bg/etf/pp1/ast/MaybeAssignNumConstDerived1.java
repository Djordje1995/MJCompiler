// generated with ast extension for cup
// version 0.8
// 13/5/2019 19:21:6


package rs.ac.bg.etf.pp1.ast;

public class MaybeAssignNumConstDerived1 extends MaybeAssignNumConst {

    public MaybeAssignNumConstDerived1 () {
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

        buffer.append(tab);
        buffer.append(") [MaybeAssignNumConstDerived1]");
        return buffer.toString();
    }
}
