// generated with ast extension for cup
// version 0.8
// 19/4/2019 20:48:10


package rs.ac.bg.etf.pp1.ast;

public class VarErrorSemi extends VarList {

    public VarErrorSemi () {
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
        buffer.append("VarErrorSemi(\n");

        buffer.append(tab);
        buffer.append(") [VarErrorSemi]");
        return buffer.toString();
    }
}