// generated with ast extension for cup
// version 0.8
// 10/5/2019 18:5:38


package rs.ac.bg.etf.pp1.ast;

public class EnumDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private EnumName EnumName;
    private EnumParam EnumParam;
    private EnumParamList EnumParamList;

    public EnumDecl (EnumName EnumName, EnumParam EnumParam, EnumParamList EnumParamList) {
        this.EnumName=EnumName;
        if(EnumName!=null) EnumName.setParent(this);
        this.EnumParam=EnumParam;
        if(EnumParam!=null) EnumParam.setParent(this);
        this.EnumParamList=EnumParamList;
        if(EnumParamList!=null) EnumParamList.setParent(this);
    }

    public EnumName getEnumName() {
        return EnumName;
    }

    public void setEnumName(EnumName EnumName) {
        this.EnumName=EnumName;
    }

    public EnumParam getEnumParam() {
        return EnumParam;
    }

    public void setEnumParam(EnumParam EnumParam) {
        this.EnumParam=EnumParam;
    }

    public EnumParamList getEnumParamList() {
        return EnumParamList;
    }

    public void setEnumParamList(EnumParamList EnumParamList) {
        this.EnumParamList=EnumParamList;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(EnumName!=null) EnumName.accept(visitor);
        if(EnumParam!=null) EnumParam.accept(visitor);
        if(EnumParamList!=null) EnumParamList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(EnumName!=null) EnumName.traverseTopDown(visitor);
        if(EnumParam!=null) EnumParam.traverseTopDown(visitor);
        if(EnumParamList!=null) EnumParamList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(EnumName!=null) EnumName.traverseBottomUp(visitor);
        if(EnumParam!=null) EnumParam.traverseBottomUp(visitor);
        if(EnumParamList!=null) EnumParamList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("EnumDecl(\n");

        if(EnumName!=null)
            buffer.append(EnumName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(EnumParam!=null)
            buffer.append(EnumParam.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(EnumParamList!=null)
            buffer.append(EnumParamList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [EnumDecl]");
        return buffer.toString();
    }
}
