// generated with ast extension for cup
// version 0.8
// 30/3/2019 13:4:41


package rs.ac.bg.etf.pp1.ast;

public class MaybeActualParamsDerived2 extends MaybeActualParams {

    public MaybeActualParamsDerived2 () {
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
        buffer.append("MaybeActualParamsDerived2(\n");

        buffer.append(tab);
        buffer.append(") [MaybeActualParamsDerived2]");
        return buffer.toString();
    }
}
