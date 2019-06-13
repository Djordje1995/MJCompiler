// generated with ast extension for cup
// version 0.8
// 13/5/2019 19:21:6


package rs.ac.bg.etf.pp1.ast;

public class EnumParamListError extends EnumParamList {

    private EnumParam EnumParam;

    public EnumParamListError (EnumParam EnumParam) {
        this.EnumParam=EnumParam;
        if(EnumParam!=null) EnumParam.setParent(this);
    }

    public EnumParam getEnumParam() {
        return EnumParam;
    }

    public void setEnumParam(EnumParam EnumParam) {
        this.EnumParam=EnumParam;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(EnumParam!=null) EnumParam.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(EnumParam!=null) EnumParam.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(EnumParam!=null) EnumParam.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("EnumParamListError(\n");

        if(EnumParam!=null)
            buffer.append(EnumParam.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [EnumParamListError]");
        return buffer.toString();
    }
}
