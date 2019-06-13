// generated with ast extension for cup
// version 0.8
// 13/5/2019 19:21:6


package rs.ac.bg.etf.pp1.ast;

public class IdentConst implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String name;
    private AnyConst AnyConst;

    public IdentConst (String name, AnyConst AnyConst) {
        this.name=name;
        this.AnyConst=AnyConst;
        if(AnyConst!=null) AnyConst.setParent(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public AnyConst getAnyConst() {
        return AnyConst;
    }

    public void setAnyConst(AnyConst AnyConst) {
        this.AnyConst=AnyConst;
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
        if(AnyConst!=null) AnyConst.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AnyConst!=null) AnyConst.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AnyConst!=null) AnyConst.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IdentConst(\n");

        buffer.append(" "+tab+name);
        buffer.append("\n");

        if(AnyConst!=null)
            buffer.append(AnyConst.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IdentConst]");
        return buffer.toString();
    }
}
