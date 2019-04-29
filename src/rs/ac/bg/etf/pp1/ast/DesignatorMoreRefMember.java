// generated with ast extension for cup
// version 0.8
// 29/3/2019 20:58:3


package rs.ac.bg.etf.pp1.ast;

public class DesignatorMoreRefMember extends DesignatorMore {

    private DesignatorMore DesignatorMore;
    private String I2;

    public DesignatorMoreRefMember (DesignatorMore DesignatorMore, String I2) {
        this.DesignatorMore=DesignatorMore;
        if(DesignatorMore!=null) DesignatorMore.setParent(this);
        this.I2=I2;
    }

    public DesignatorMore getDesignatorMore() {
        return DesignatorMore;
    }

    public void setDesignatorMore(DesignatorMore DesignatorMore) {
        this.DesignatorMore=DesignatorMore;
    }

    public String getI2() {
        return I2;
    }

    public void setI2(String I2) {
        this.I2=I2;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorMore!=null) DesignatorMore.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorMore!=null) DesignatorMore.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorMore!=null) DesignatorMore.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorMoreRefMember(\n");

        if(DesignatorMore!=null)
            buffer.append(DesignatorMore.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+I2);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorMoreRefMember]");
        return buffer.toString();
    }
}