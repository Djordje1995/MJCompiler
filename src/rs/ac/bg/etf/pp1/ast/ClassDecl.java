// generated with ast extension for cup
// version 0.8
// 10/5/2019 18:5:38


package rs.ac.bg.etf.pp1.ast;

public class ClassDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String I1;
    private MaybeExtends MaybeExtends;
    private MaybeImplements MaybeImplements;
    private VarDeclList VarDeclList;
    private MaybeMethodDecl MaybeMethodDecl;

    public ClassDecl (String I1, MaybeExtends MaybeExtends, MaybeImplements MaybeImplements, VarDeclList VarDeclList, MaybeMethodDecl MaybeMethodDecl) {
        this.I1=I1;
        this.MaybeExtends=MaybeExtends;
        if(MaybeExtends!=null) MaybeExtends.setParent(this);
        this.MaybeImplements=MaybeImplements;
        if(MaybeImplements!=null) MaybeImplements.setParent(this);
        this.VarDeclList=VarDeclList;
        if(VarDeclList!=null) VarDeclList.setParent(this);
        this.MaybeMethodDecl=MaybeMethodDecl;
        if(MaybeMethodDecl!=null) MaybeMethodDecl.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public MaybeExtends getMaybeExtends() {
        return MaybeExtends;
    }

    public void setMaybeExtends(MaybeExtends MaybeExtends) {
        this.MaybeExtends=MaybeExtends;
    }

    public MaybeImplements getMaybeImplements() {
        return MaybeImplements;
    }

    public void setMaybeImplements(MaybeImplements MaybeImplements) {
        this.MaybeImplements=MaybeImplements;
    }

    public VarDeclList getVarDeclList() {
        return VarDeclList;
    }

    public void setVarDeclList(VarDeclList VarDeclList) {
        this.VarDeclList=VarDeclList;
    }

    public MaybeMethodDecl getMaybeMethodDecl() {
        return MaybeMethodDecl;
    }

    public void setMaybeMethodDecl(MaybeMethodDecl MaybeMethodDecl) {
        this.MaybeMethodDecl=MaybeMethodDecl;
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
        if(MaybeExtends!=null) MaybeExtends.accept(visitor);
        if(MaybeImplements!=null) MaybeImplements.accept(visitor);
        if(VarDeclList!=null) VarDeclList.accept(visitor);
        if(MaybeMethodDecl!=null) MaybeMethodDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MaybeExtends!=null) MaybeExtends.traverseTopDown(visitor);
        if(MaybeImplements!=null) MaybeImplements.traverseTopDown(visitor);
        if(VarDeclList!=null) VarDeclList.traverseTopDown(visitor);
        if(MaybeMethodDecl!=null) MaybeMethodDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MaybeExtends!=null) MaybeExtends.traverseBottomUp(visitor);
        if(MaybeImplements!=null) MaybeImplements.traverseBottomUp(visitor);
        if(VarDeclList!=null) VarDeclList.traverseBottomUp(visitor);
        if(MaybeMethodDecl!=null) MaybeMethodDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDecl(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(MaybeExtends!=null)
            buffer.append(MaybeExtends.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MaybeImplements!=null)
            buffer.append(MaybeImplements.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclList!=null)
            buffer.append(VarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MaybeMethodDecl!=null)
            buffer.append(MaybeMethodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDecl]");
        return buffer.toString();
    }
}
