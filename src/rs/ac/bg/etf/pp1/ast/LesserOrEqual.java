// generated with ast extension for cup
// version 0.8
// 30/3/2019 13:4:41


package rs.ac.bg.etf.pp1.ast;

public class LesserOrEqual extends Relop {

    public LesserOrEqual () {
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
        buffer.append("LesserOrEqual(\n");

        buffer.append(tab);
        buffer.append(") [LesserOrEqual]");
        return buffer.toString();
    }
}
