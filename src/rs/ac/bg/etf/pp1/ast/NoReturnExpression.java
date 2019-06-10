// generated with ast extension for cup
// version 0.8
// 10/5/2019 18:5:39


package rs.ac.bg.etf.pp1.ast;

public class NoReturnExpression extends ReturnExpression {

    public NoReturnExpression () {
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
        buffer.append("NoReturnExpression(\n");

        buffer.append(tab);
        buffer.append(") [NoReturnExpression]");
        return buffer.toString();
    }
}
