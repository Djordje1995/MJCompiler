// generated with ast extension for cup
// version 0.8
// 10/5/2019 18:5:39


package rs.ac.bg.etf.pp1.ast;

public class FormalParam implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Type Type;
    private String I1;
    private MaybeEmptySquareBrackets MaybeEmptySquareBrackets;

    public FormalParam (Type Type, String I1, MaybeEmptySquareBrackets MaybeEmptySquareBrackets) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.I1=I1;
        this.MaybeEmptySquareBrackets=MaybeEmptySquareBrackets;
        if(MaybeEmptySquareBrackets!=null) MaybeEmptySquareBrackets.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public MaybeEmptySquareBrackets getMaybeEmptySquareBrackets() {
        return MaybeEmptySquareBrackets;
    }

    public void setMaybeEmptySquareBrackets(MaybeEmptySquareBrackets MaybeEmptySquareBrackets) {
        this.MaybeEmptySquareBrackets=MaybeEmptySquareBrackets;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(MaybeEmptySquareBrackets!=null) MaybeEmptySquareBrackets.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(MaybeEmptySquareBrackets!=null) MaybeEmptySquareBrackets.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(MaybeEmptySquareBrackets!=null) MaybeEmptySquareBrackets.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormalParam(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(MaybeEmptySquareBrackets!=null)
            buffer.append(MaybeEmptySquareBrackets.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormalParam]");
        return buffer.toString();
    }
}
