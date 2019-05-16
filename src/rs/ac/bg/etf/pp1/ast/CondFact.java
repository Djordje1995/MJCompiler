// generated with ast extension for cup
// version 0.8
// 16/4/2019 21:19:58


package rs.ac.bg.etf.pp1.ast;

public class CondFact implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Expr Expr;
    private MaybeRelopExpr MaybeRelopExpr;

    public CondFact (Expr Expr, MaybeRelopExpr MaybeRelopExpr) {
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.MaybeRelopExpr=MaybeRelopExpr;
        if(MaybeRelopExpr!=null) MaybeRelopExpr.setParent(this);
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public MaybeRelopExpr getMaybeRelopExpr() {
        return MaybeRelopExpr;
    }

    public void setMaybeRelopExpr(MaybeRelopExpr MaybeRelopExpr) {
        this.MaybeRelopExpr=MaybeRelopExpr;
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
        if(Expr!=null) Expr.accept(visitor);
        if(MaybeRelopExpr!=null) MaybeRelopExpr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(MaybeRelopExpr!=null) MaybeRelopExpr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(MaybeRelopExpr!=null) MaybeRelopExpr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CondFact(\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MaybeRelopExpr!=null)
            buffer.append(MaybeRelopExpr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CondFact]");
        return buffer.toString();
    }
}
