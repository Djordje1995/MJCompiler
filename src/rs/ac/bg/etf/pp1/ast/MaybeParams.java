// generated with ast extension for cup
// version 0.8
// 29/3/2019 10:23:44


package rs.ac.bg.etf.pp1.ast;

public class MaybeParams implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private MaybeActualParams MaybeActualParams;

    public MaybeParams (MaybeActualParams MaybeActualParams) {
        this.MaybeActualParams=MaybeActualParams;
        if(MaybeActualParams!=null) MaybeActualParams.setParent(this);
    }

    public MaybeActualParams getMaybeActualParams() {
        return MaybeActualParams;
    }

    public void setMaybeActualParams(MaybeActualParams MaybeActualParams) {
        this.MaybeActualParams=MaybeActualParams;
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
        if(MaybeActualParams!=null) MaybeActualParams.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MaybeActualParams!=null) MaybeActualParams.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MaybeActualParams!=null) MaybeActualParams.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MaybeParams(\n");

        if(MaybeActualParams!=null)
            buffer.append(MaybeActualParams.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MaybeParams]");
        return buffer.toString();
    }
}
