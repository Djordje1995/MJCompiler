// generated with ast extension for cup
// version 0.8
// 10/5/2019 18:5:38


package rs.ac.bg.etf.pp1.ast;

public class IdentConstListError extends IdentConstList {

    private IdentConst IdentConst;

    public IdentConstListError (IdentConst IdentConst) {
        this.IdentConst=IdentConst;
        if(IdentConst!=null) IdentConst.setParent(this);
    }

    public IdentConst getIdentConst() {
        return IdentConst;
    }

    public void setIdentConst(IdentConst IdentConst) {
        this.IdentConst=IdentConst;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(IdentConst!=null) IdentConst.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IdentConst!=null) IdentConst.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IdentConst!=null) IdentConst.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IdentConstListError(\n");

        if(IdentConst!=null)
            buffer.append(IdentConst.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IdentConstListError]");
        return buffer.toString();
    }
}
