// generated with ast extension for cup
// version 0.8
// 18/4/2019 18:19:46


package rs.ac.bg.etf.pp1.ast;

public class EnumParamsList extends EnumParamList {

    private EnumParamList EnumParamList;
    private EnumParam EnumParam;

    public EnumParamsList (EnumParamList EnumParamList, EnumParam EnumParam) {
        this.EnumParamList=EnumParamList;
        if(EnumParamList!=null) EnumParamList.setParent(this);
        this.EnumParam=EnumParam;
        if(EnumParam!=null) EnumParam.setParent(this);
    }

    public EnumParamList getEnumParamList() {
        return EnumParamList;
    }

    public void setEnumParamList(EnumParamList EnumParamList) {
        this.EnumParamList=EnumParamList;
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
        if(EnumParamList!=null) EnumParamList.accept(visitor);
        if(EnumParam!=null) EnumParam.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(EnumParamList!=null) EnumParamList.traverseTopDown(visitor);
        if(EnumParam!=null) EnumParam.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(EnumParamList!=null) EnumParamList.traverseBottomUp(visitor);
        if(EnumParam!=null) EnumParam.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("EnumParamsList(\n");

        if(EnumParamList!=null)
            buffer.append(EnumParamList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(EnumParam!=null)
            buffer.append(EnumParam.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [EnumParamsList]");
        return buffer.toString();
    }
}
