// generated with ast extension for cup
// version 0.8
// 31/4/2019 21:55:20


package rs.ac.bg.etf.pp1.ast;

public class ReturnExpressionDerived2 extends ReturnExpression {

    public ReturnExpressionDerived2 () {
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
        buffer.append("ReturnExpressionDerived2(\n");

        buffer.append(tab);
        buffer.append(") [ReturnExpressionDerived2]");
        return buffer.toString();
    }
}
