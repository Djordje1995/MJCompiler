// generated with ast extension for cup
// version 0.8
// 16/4/2019 21:19:58


package rs.ac.bg.etf.pp1.ast;

public class InterfaceMethodDeclListDerived1 extends InterfaceMethodDeclList {

    public InterfaceMethodDeclListDerived1 () {
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
        buffer.append("InterfaceMethodDeclListDerived1(\n");

        buffer.append(tab);
        buffer.append(") [InterfaceMethodDeclListDerived1]");
        return buffer.toString();
    }
}
