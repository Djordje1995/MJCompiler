// generated with ast extension for cup
// version 0.8
// 31/4/2019 23:46:48


package rs.ac.bg.etf.pp1.ast;

public class MaybeParamsDerived2 extends MaybeParams {

    public MaybeParamsDerived2 () {
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
        buffer.append("MaybeParamsDerived2(\n");

        buffer.append(tab);
        buffer.append(") [MaybeParamsDerived2]");
        return buffer.toString();
    }
}
