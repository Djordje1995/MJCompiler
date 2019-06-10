// generated with ast extension for cup
// version 0.8
// 10/5/2019 18:5:39


package rs.ac.bg.etf.pp1.ast;

public class ReturnStatement extends Matched {

    private ReturnExpression ReturnExpression;

    public ReturnStatement (ReturnExpression ReturnExpression) {
        this.ReturnExpression=ReturnExpression;
        if(ReturnExpression!=null) ReturnExpression.setParent(this);
    }

    public ReturnExpression getReturnExpression() {
        return ReturnExpression;
    }

    public void setReturnExpression(ReturnExpression ReturnExpression) {
        this.ReturnExpression=ReturnExpression;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ReturnExpression!=null) ReturnExpression.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ReturnExpression!=null) ReturnExpression.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ReturnExpression!=null) ReturnExpression.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ReturnStatement(\n");

        if(ReturnExpression!=null)
            buffer.append(ReturnExpression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ReturnStatement]");
        return buffer.toString();
    }
}
