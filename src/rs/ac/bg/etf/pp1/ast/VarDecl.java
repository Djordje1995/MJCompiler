// generated with ast extension for cup
// version 0.8
// 29/3/2019 20:58:2


package rs.ac.bg.etf.pp1.ast;

public class VarDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Type Type;
    private String varName;
    private MaybeEmptySquareBrackets MaybeEmptySquareBrackets;
    private IdentList IdentList;

    public VarDecl (Type Type, String varName, MaybeEmptySquareBrackets MaybeEmptySquareBrackets, IdentList IdentList) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.varName=varName;
        this.MaybeEmptySquareBrackets=MaybeEmptySquareBrackets;
        if(MaybeEmptySquareBrackets!=null) MaybeEmptySquareBrackets.setParent(this);
        this.IdentList=IdentList;
        if(IdentList!=null) IdentList.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
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

    public IdentList getIdentList() {
        return IdentList;
    }

    public void setIdentList(IdentList IdentList) {
        this.IdentList=IdentList;
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
        if(IdentList!=null) IdentList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(MaybeEmptySquareBrackets!=null) MaybeEmptySquareBrackets.traverseTopDown(visitor);
        if(IdentList!=null) IdentList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(MaybeEmptySquareBrackets!=null) MaybeEmptySquareBrackets.traverseBottomUp(visitor);
        if(IdentList!=null) IdentList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDecl(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+varName);
        buffer.append("\n");

        if(MaybeEmptySquareBrackets!=null)
            buffer.append(MaybeEmptySquareBrackets.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(IdentList!=null)
            buffer.append(IdentList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDecl]");
        return buffer.toString();
    }
}
