// generated with ast extension for cup
// version 0.8
// 30/3/2019 13:4:40


package rs.ac.bg.etf.pp1.ast;

public class IdentListRec extends IdentList {

    private IdentList IdentList;
    private String I2;
    private MaybeEmptySquareBrackets MaybeEmptySquareBrackets;

    public IdentListRec (IdentList IdentList, String I2, MaybeEmptySquareBrackets MaybeEmptySquareBrackets) {
        this.IdentList=IdentList;
        if(IdentList!=null) IdentList.setParent(this);
        this.I2=I2;
        this.MaybeEmptySquareBrackets=MaybeEmptySquareBrackets;
        if(MaybeEmptySquareBrackets!=null) MaybeEmptySquareBrackets.setParent(this);
    }

    public IdentList getIdentList() {
        return IdentList;
    }

    public void setIdentList(IdentList IdentList) {
        this.IdentList=IdentList;
    }

    public String getI2() {
        return I2;
    }

    public void setI2(String I2) {
        this.I2=I2;
    }

    public MaybeEmptySquareBrackets getMaybeEmptySquareBrackets() {
        return MaybeEmptySquareBrackets;
    }

    public void setMaybeEmptySquareBrackets(MaybeEmptySquareBrackets MaybeEmptySquareBrackets) {
        this.MaybeEmptySquareBrackets=MaybeEmptySquareBrackets;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(IdentList!=null) IdentList.accept(visitor);
        if(MaybeEmptySquareBrackets!=null) MaybeEmptySquareBrackets.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IdentList!=null) IdentList.traverseTopDown(visitor);
        if(MaybeEmptySquareBrackets!=null) MaybeEmptySquareBrackets.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IdentList!=null) IdentList.traverseBottomUp(visitor);
        if(MaybeEmptySquareBrackets!=null) MaybeEmptySquareBrackets.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IdentListRec(\n");

        if(IdentList!=null)
            buffer.append(IdentList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+I2);
        buffer.append("\n");

        if(MaybeEmptySquareBrackets!=null)
            buffer.append(MaybeEmptySquareBrackets.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IdentListRec]");
        return buffer.toString();
    }
}
