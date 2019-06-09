// generated with ast extension for cup
// version 0.8
// 8/5/2019 18:57:43


package rs.ac.bg.etf.pp1.ast;

public class FactorDesignator extends Factor {

    private Designator Designator;
    private MaybeParams MaybeParams;

    public FactorDesignator (Designator Designator, MaybeParams MaybeParams) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.MaybeParams=MaybeParams;
        if(MaybeParams!=null) MaybeParams.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public MaybeParams getMaybeParams() {
        return MaybeParams;
    }

    public void setMaybeParams(MaybeParams MaybeParams) {
        this.MaybeParams=MaybeParams;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(MaybeParams!=null) MaybeParams.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(MaybeParams!=null) MaybeParams.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(MaybeParams!=null) MaybeParams.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorDesignator(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MaybeParams!=null)
            buffer.append(MaybeParams.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorDesignator]");
        return buffer.toString();
    }
}
