// generated with ast extension for cup
// version 0.8
// 8/5/2019 18:57:42


package rs.ac.bg.etf.pp1.ast;

public class EnumParam implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String name;
    private MaybeAssignNumConst MaybeAssignNumConst;

    public EnumParam (String name, MaybeAssignNumConst MaybeAssignNumConst) {
        this.name=name;
        this.MaybeAssignNumConst=MaybeAssignNumConst;
        if(MaybeAssignNumConst!=null) MaybeAssignNumConst.setParent(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public MaybeAssignNumConst getMaybeAssignNumConst() {
        return MaybeAssignNumConst;
    }

    public void setMaybeAssignNumConst(MaybeAssignNumConst MaybeAssignNumConst) {
        this.MaybeAssignNumConst=MaybeAssignNumConst;
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
        if(MaybeAssignNumConst!=null) MaybeAssignNumConst.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MaybeAssignNumConst!=null) MaybeAssignNumConst.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MaybeAssignNumConst!=null) MaybeAssignNumConst.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("EnumParam(\n");

        buffer.append(" "+tab+name);
        buffer.append("\n");

        if(MaybeAssignNumConst!=null)
            buffer.append(MaybeAssignNumConst.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [EnumParam]");
        return buffer.toString();
    }
}
