// generated with ast extension for cup
// version 0.8
// 3/5/2019 19:19:33


package rs.ac.bg.etf.pp1.ast;

public class NoEnumParamsList extends EnumParamList {

    public NoEnumParamsList () {
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
        buffer.append("NoEnumParamsList(\n");

        buffer.append(tab);
        buffer.append(") [NoEnumParamsList]");
        return buffer.toString();
    }
}