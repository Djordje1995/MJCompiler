// generated with ast extension for cup
// version 0.8
// 29/3/2019 20:58:3


package rs.ac.bg.etf.pp1.ast;

public class DesignatorParams extends DesignatorStatement {

    private Designator Designator;
    private MaybeActualParams MaybeActualParams;

    public DesignatorParams (Designator Designator, MaybeActualParams MaybeActualParams) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.MaybeActualParams=MaybeActualParams;
        if(MaybeActualParams!=null) MaybeActualParams.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public MaybeActualParams getMaybeActualParams() {
        return MaybeActualParams;
    }

    public void setMaybeActualParams(MaybeActualParams MaybeActualParams) {
        this.MaybeActualParams=MaybeActualParams;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(MaybeActualParams!=null) MaybeActualParams.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(MaybeActualParams!=null) MaybeActualParams.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(MaybeActualParams!=null) MaybeActualParams.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorParams(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MaybeActualParams!=null)
            buffer.append(MaybeActualParams.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorParams]");
        return buffer.toString();
    }
}
