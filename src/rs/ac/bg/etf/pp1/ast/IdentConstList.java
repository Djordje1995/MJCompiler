// generated with ast extension for cup
// version 0.8
// 29/3/2019 10:23:43


package rs.ac.bg.etf.pp1.ast;

public class IdentConstList implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private IdentConstList IdentConstList;
    private String I2;
    private AnyConst AnyConst;

    public IdentConstList (IdentConstList IdentConstList, String I2, AnyConst AnyConst) {
        this.IdentConstList=IdentConstList;
        if(IdentConstList!=null) IdentConstList.setParent(this);
        this.I2=I2;
        this.AnyConst=AnyConst;
        if(AnyConst!=null) AnyConst.setParent(this);
    }

    public IdentConstList getIdentConstList() {
        return IdentConstList;
    }

    public void setIdentConstList(IdentConstList IdentConstList) {
        this.IdentConstList=IdentConstList;
    }

    public String getI2() {
        return I2;
    }

    public void setI2(String I2) {
        this.I2=I2;
    }

    public AnyConst getAnyConst() {
        return AnyConst;
    }

    public void setAnyConst(AnyConst AnyConst) {
        this.AnyConst=AnyConst;
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
        if(IdentConstList!=null) IdentConstList.accept(visitor);
        if(AnyConst!=null) AnyConst.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IdentConstList!=null) IdentConstList.traverseTopDown(visitor);
        if(AnyConst!=null) AnyConst.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IdentConstList!=null) IdentConstList.traverseBottomUp(visitor);
        if(AnyConst!=null) AnyConst.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IdentConstList(\n");

        if(IdentConstList!=null)
            buffer.append(IdentConstList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+I2);
        buffer.append("\n");

        if(AnyConst!=null)
            buffer.append(AnyConst.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IdentConstList]");
        return buffer.toString();
    }
}
