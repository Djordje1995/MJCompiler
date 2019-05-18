// generated with ast extension for cup
// version 0.8
// 18/4/2019 18:19:46


package rs.ac.bg.etf.pp1.ast;

public class InterfaceMethodDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private TypeOrVoid TypeOrVoid;
    private String I2;
    private MaybeFormPars MaybeFormPars;

    public InterfaceMethodDecl (TypeOrVoid TypeOrVoid, String I2, MaybeFormPars MaybeFormPars) {
        this.TypeOrVoid=TypeOrVoid;
        if(TypeOrVoid!=null) TypeOrVoid.setParent(this);
        this.I2=I2;
        this.MaybeFormPars=MaybeFormPars;
        if(MaybeFormPars!=null) MaybeFormPars.setParent(this);
    }

    public TypeOrVoid getTypeOrVoid() {
        return TypeOrVoid;
    }

    public void setTypeOrVoid(TypeOrVoid TypeOrVoid) {
        this.TypeOrVoid=TypeOrVoid;
    }

    public String getI2() {
        return I2;
    }

    public void setI2(String I2) {
        this.I2=I2;
    }

    public MaybeFormPars getMaybeFormPars() {
        return MaybeFormPars;
    }

    public void setMaybeFormPars(MaybeFormPars MaybeFormPars) {
        this.MaybeFormPars=MaybeFormPars;
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
        if(TypeOrVoid!=null) TypeOrVoid.accept(visitor);
        if(MaybeFormPars!=null) MaybeFormPars.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(TypeOrVoid!=null) TypeOrVoid.traverseTopDown(visitor);
        if(MaybeFormPars!=null) MaybeFormPars.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(TypeOrVoid!=null) TypeOrVoid.traverseBottomUp(visitor);
        if(MaybeFormPars!=null) MaybeFormPars.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("InterfaceMethodDecl(\n");

        if(TypeOrVoid!=null)
            buffer.append(TypeOrVoid.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+I2);
        buffer.append("\n");

        if(MaybeFormPars!=null)
            buffer.append(MaybeFormPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [InterfaceMethodDecl]");
        return buffer.toString();
    }
}
