// generated with ast extension for cup
// version 0.8
// 18/4/2019 18:19:46


package rs.ac.bg.etf.pp1.ast;

public class IdentConstListRec extends IdentConstList {

    private IdentConstList IdentConstList;
    private IdentConst IdentConst;

    public IdentConstListRec (IdentConstList IdentConstList, IdentConst IdentConst) {
        this.IdentConstList=IdentConstList;
        if(IdentConstList!=null) IdentConstList.setParent(this);
        this.IdentConst=IdentConst;
        if(IdentConst!=null) IdentConst.setParent(this);
    }

    public IdentConstList getIdentConstList() {
        return IdentConstList;
    }

    public void setIdentConstList(IdentConstList IdentConstList) {
        this.IdentConstList=IdentConstList;
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
        if(IdentConstList!=null) IdentConstList.accept(visitor);
        if(IdentConst!=null) IdentConst.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IdentConstList!=null) IdentConstList.traverseTopDown(visitor);
        if(IdentConst!=null) IdentConst.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IdentConstList!=null) IdentConstList.traverseBottomUp(visitor);
        if(IdentConst!=null) IdentConst.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IdentConstListRec(\n");

        if(IdentConstList!=null)
            buffer.append(IdentConstList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(IdentConst!=null)
            buffer.append(IdentConst.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IdentConstListRec]");
        return buffer.toString();
    }
}
