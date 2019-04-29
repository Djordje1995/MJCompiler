// generated with ast extension for cup
// version 0.8
// 29/3/2019 20:58:2


package rs.ac.bg.etf.pp1.ast;

public class IdentMaybeConstListRec extends IdentMaybeConstList {

    private IdentMaybeConstList IdentMaybeConstList;
    private String I2;
    private MaybeAssignNumConst MaybeAssignNumConst;

    public IdentMaybeConstListRec (IdentMaybeConstList IdentMaybeConstList, String I2, MaybeAssignNumConst MaybeAssignNumConst) {
        this.IdentMaybeConstList=IdentMaybeConstList;
        if(IdentMaybeConstList!=null) IdentMaybeConstList.setParent(this);
        this.I2=I2;
        this.MaybeAssignNumConst=MaybeAssignNumConst;
        if(MaybeAssignNumConst!=null) MaybeAssignNumConst.setParent(this);
    }

    public IdentMaybeConstList getIdentMaybeConstList() {
        return IdentMaybeConstList;
    }

    public void setIdentMaybeConstList(IdentMaybeConstList IdentMaybeConstList) {
        this.IdentMaybeConstList=IdentMaybeConstList;
    }

    public String getI2() {
        return I2;
    }

    public void setI2(String I2) {
        this.I2=I2;
    }

    public MaybeAssignNumConst getMaybeAssignNumConst() {
        return MaybeAssignNumConst;
    }

    public void setMaybeAssignNumConst(MaybeAssignNumConst MaybeAssignNumConst) {
        this.MaybeAssignNumConst=MaybeAssignNumConst;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(IdentMaybeConstList!=null) IdentMaybeConstList.accept(visitor);
        if(MaybeAssignNumConst!=null) MaybeAssignNumConst.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IdentMaybeConstList!=null) IdentMaybeConstList.traverseTopDown(visitor);
        if(MaybeAssignNumConst!=null) MaybeAssignNumConst.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IdentMaybeConstList!=null) IdentMaybeConstList.traverseBottomUp(visitor);
        if(MaybeAssignNumConst!=null) MaybeAssignNumConst.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IdentMaybeConstListRec(\n");

        if(IdentMaybeConstList!=null)
            buffer.append(IdentMaybeConstList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+I2);
        buffer.append("\n");

        if(MaybeAssignNumConst!=null)
            buffer.append(MaybeAssignNumConst.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IdentMaybeConstListRec]");
        return buffer.toString();
    }
}
