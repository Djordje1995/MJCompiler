// generated with ast extension for cup
// version 0.8
// 3/5/2019 19:19:33


package rs.ac.bg.etf.pp1.ast;

public class NoSquareBrackets extends MaybeEmptySquareBrackets {

    public NoSquareBrackets () {
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
        buffer.append("NoSquareBrackets(\n");

        buffer.append(tab);
        buffer.append(") [NoSquareBrackets]");
        return buffer.toString();
    }
}