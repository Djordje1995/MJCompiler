// generated with ast extension for cup
// version 0.8
// 10/5/2019 18:5:38


package rs.ac.bg.etf.pp1.ast;

public class VarName implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String varName;
    private MaybeEmptySquareBrackets MaybeEmptySquareBrackets;

    public VarName (String varName, MaybeEmptySquareBrackets MaybeEmptySquareBrackets) {
        this.varName=varName;
        this.MaybeEmptySquareBrackets=MaybeEmptySquareBrackets;
        if(MaybeEmptySquareBrackets!=null) MaybeEmptySquareBrackets.setParent(this);
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName=varName;
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
        if(MaybeEmptySquareBrackets!=null) MaybeEmptySquareBrackets.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MaybeEmptySquareBrackets!=null) MaybeEmptySquareBrackets.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MaybeEmptySquareBrackets!=null) MaybeEmptySquareBrackets.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarName(\n");

        buffer.append(" "+tab+varName);
        buffer.append("\n");

        if(MaybeEmptySquareBrackets!=null)
            buffer.append(MaybeEmptySquareBrackets.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarName]");
        return buffer.toString();
    }
}
