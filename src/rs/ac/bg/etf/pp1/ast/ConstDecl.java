// generated with ast extension for cup
// version 0.8
// 8/5/2019 18:57:42


package rs.ac.bg.etf.pp1.ast;

public class ConstDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Type Type;
    private IdentConst IdentConst;
    private IdentConstList IdentConstList;

    public ConstDecl (Type Type, IdentConst IdentConst, IdentConstList IdentConstList) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.IdentConst=IdentConst;
        if(IdentConst!=null) IdentConst.setParent(this);
        this.IdentConstList=IdentConstList;
        if(IdentConstList!=null) IdentConstList.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public IdentConst getIdentConst() {
        return IdentConst;
    }

    public void setIdentConst(IdentConst IdentConst) {
        this.IdentConst=IdentConst;
    }

    public IdentConstList getIdentConstList() {
        return IdentConstList;
    }

    public void setIdentConstList(IdentConstList IdentConstList) {
        this.IdentConstList=IdentConstList;
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
        if(IdentConst!=null) IdentConst.accept(visitor);
        if(IdentConstList!=null) IdentConstList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(IdentConst!=null) IdentConst.traverseTopDown(visitor);
        if(IdentConstList!=null) IdentConstList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(IdentConst!=null) IdentConst.traverseBottomUp(visitor);
        if(IdentConstList!=null) IdentConstList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDecl(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(IdentConst!=null)
            buffer.append(IdentConst.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(IdentConstList!=null)
            buffer.append(IdentConstList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDecl]");
        return buffer.toString();
    }
}
