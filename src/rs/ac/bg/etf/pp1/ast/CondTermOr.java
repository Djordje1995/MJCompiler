// generated with ast extension for cup
// version 0.8
// 29/3/2019 10:23:44


package rs.ac.bg.etf.pp1.ast;

public class CondTermOr implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private CondTermOr CondTermOr;
    private CondTerm CondTerm;

    public CondTermOr (CondTermOr CondTermOr, CondTerm CondTerm) {
        this.CondTermOr=CondTermOr;
        if(CondTermOr!=null) CondTermOr.setParent(this);
        this.CondTerm=CondTerm;
        if(CondTerm!=null) CondTerm.setParent(this);
    }

    public CondTermOr getCondTermOr() {
        return CondTermOr;
    }

    public void setCondTermOr(CondTermOr CondTermOr) {
        this.CondTermOr=CondTermOr;
    }

    public CondTerm getCondTerm() {
        return CondTerm;
    }

    public void setCondTerm(CondTerm CondTerm) {
        this.CondTerm=CondTerm;
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
        if(CondTermOr!=null) CondTermOr.accept(visitor);
        if(CondTerm!=null) CondTerm.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CondTermOr!=null) CondTermOr.traverseTopDown(visitor);
        if(CondTerm!=null) CondTerm.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CondTermOr!=null) CondTermOr.traverseBottomUp(visitor);
        if(CondTerm!=null) CondTerm.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CondTermOr(\n");

        if(CondTermOr!=null)
            buffer.append(CondTermOr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondTerm!=null)
            buffer.append(CondTerm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CondTermOr]");
        return buffer.toString();
    }
}
