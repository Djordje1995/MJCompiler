// generated with ast extension for cup
// version 0.8
// 8/5/2019 18:57:43


package rs.ac.bg.etf.pp1.ast;

public class MaybeActualParamsDerived1 extends MaybeActualParams {

    public MaybeActualParamsDerived1 () {
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
        buffer.append("MaybeActualParamsDerived1(\n");

        buffer.append(tab);
        buffer.append(") [MaybeActualParamsDerived1]");
        return buffer.toString();
    }
}
