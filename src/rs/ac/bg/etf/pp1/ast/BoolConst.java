// generated with ast extension for cup
// version 0.8
// 29/3/2019 20:58:2


package rs.ac.bg.etf.pp1.ast;

public class BoolConst extends AnyConst {

    private java.lang.Boolean B1;

    public BoolConst (java.lang.Boolean B1) {
        this.B1=B1;
        if(B1!=null) B1.setParent(this);
    }

    public java.lang.Boolean getB1() {
        return B1;
    }

    public void setB1(java.lang.Boolean B1) {
        this.B1=B1;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(B1!=null) B1.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(B1!=null) B1.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(B1!=null) B1.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("BoolConst(\n");

        if(B1!=null)
            buffer.append(B1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [BoolConst]");
        return buffer.toString();
    }
}
