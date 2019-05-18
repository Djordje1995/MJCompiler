// generated with ast extension for cup
// version 0.8
// 18/4/2019 18:19:46


package rs.ac.bg.etf.pp1.ast;

public class MaybeParamsDerived1 extends MaybeParams {

    private MaybeActualParams MaybeActualParams;

    public MaybeParamsDerived1 (MaybeActualParams MaybeActualParams) {
        this.MaybeActualParams=MaybeActualParams;
        if(MaybeActualParams!=null) MaybeActualParams.setParent(this);
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
        buffer.append("MaybeParamsDerived1(\n");

        if(MaybeActualParams!=null)
            buffer.append(MaybeActualParams.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MaybeParamsDerived1]");
        return buffer.toString();
    }
}
