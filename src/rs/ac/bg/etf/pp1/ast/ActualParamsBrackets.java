// generated with ast extension for cup
// version 0.8
// 13/5/2019 19:21:6


package rs.ac.bg.etf.pp1.ast;

public class ActualParamsBrackets extends MaybeParams {

    private FuncCall FuncCall;
    private MaybeActualParams MaybeActualParams;

    public ActualParamsBrackets (FuncCall FuncCall, MaybeActualParams MaybeActualParams) {
        this.FuncCall=FuncCall;
        if(FuncCall!=null) FuncCall.setParent(this);
        this.MaybeActualParams=MaybeActualParams;
        if(MaybeActualParams!=null) MaybeActualParams.setParent(this);
    }

    public FuncCall getFuncCall() {
        return FuncCall;
    }

    public void setFuncCall(FuncCall FuncCall) {
        this.FuncCall=FuncCall;
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
        if(FuncCall!=null) FuncCall.accept(visitor);
        if(MaybeActualParams!=null) MaybeActualParams.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FuncCall!=null) FuncCall.traverseTopDown(visitor);
        if(MaybeActualParams!=null) MaybeActualParams.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FuncCall!=null) FuncCall.traverseBottomUp(visitor);
        if(MaybeActualParams!=null) MaybeActualParams.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ActualParamsBrackets(\n");

        if(FuncCall!=null)
            buffer.append(FuncCall.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MaybeActualParams!=null)
            buffer.append(MaybeActualParams.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ActualParamsBrackets]");
        return buffer.toString();
    }
}
