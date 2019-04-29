// generated with ast extension for cup
// version 0.8
// 29/3/2019 10:23:43


package rs.ac.bg.etf.pp1.ast;

public class EnumDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String I1;
    private String I2;
    private MaybeAssignNumConst MaybeAssignNumConst;
    private IdentMaybeConstList IdentMaybeConstList;

    public EnumDecl (String I1, String I2, MaybeAssignNumConst MaybeAssignNumConst, IdentMaybeConstList IdentMaybeConstList) {
        this.I1=I1;
        this.I2=I2;
        this.MaybeAssignNumConst=MaybeAssignNumConst;
        if(MaybeAssignNumConst!=null) MaybeAssignNumConst.setParent(this);
        this.IdentMaybeConstList=IdentMaybeConstList;
        if(IdentMaybeConstList!=null) IdentMaybeConstList.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public String getI2() {
        return I2;
    }

    public void setI2(String I2) {
        this.I2=I2;
    }

    public MaybeAssignNumConst getMaybeAssignNumConst() {
        return MaybeAssignNumConst;
    }

    public void setMaybeAssignNumConst(MaybeAssignNumConst MaybeAssignNumConst) {
        this.MaybeAssignNumConst=MaybeAssignNumConst;
    }

    public IdentMaybeConstList getIdentMaybeConstList() {
        return IdentMaybeConstList;
    }

    public void setIdentMaybeConstList(IdentMaybeConstList IdentMaybeConstList) {
        this.IdentMaybeConstList=IdentMaybeConstList;
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
        if(MaybeAssignNumConst!=null) MaybeAssignNumConst.accept(visitor);
        if(IdentMaybeConstList!=null) IdentMaybeConstList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MaybeAssignNumConst!=null) MaybeAssignNumConst.traverseTopDown(visitor);
        if(IdentMaybeConstList!=null) IdentMaybeConstList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MaybeAssignNumConst!=null) MaybeAssignNumConst.traverseBottomUp(visitor);
        if(IdentMaybeConstList!=null) IdentMaybeConstList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("EnumDecl(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        buffer.append(" "+tab+I2);
        buffer.append("\n");

        if(MaybeAssignNumConst!=null)
            buffer.append(MaybeAssignNumConst.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(IdentMaybeConstList!=null)
            buffer.append(IdentMaybeConstList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [EnumDecl]");
        return buffer.toString();
    }
}
