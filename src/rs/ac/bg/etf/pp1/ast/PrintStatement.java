// generated with ast extension for cup
// version 0.8
// 13/5/2019 19:21:6


package rs.ac.bg.etf.pp1.ast;

public class PrintStatement extends Matched {

    private Expr Expr;
    private MaybeNumConst MaybeNumConst;

    public PrintStatement (Expr Expr, MaybeNumConst MaybeNumConst) {
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.MaybeNumConst=MaybeNumConst;
        if(MaybeNumConst!=null) MaybeNumConst.setParent(this);
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public MaybeNumConst getMaybeNumConst() {
        return MaybeNumConst;
    }

    public void setMaybeNumConst(MaybeNumConst MaybeNumConst) {
        this.MaybeNumConst=MaybeNumConst;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Expr!=null) Expr.accept(visitor);
        if(MaybeNumConst!=null) MaybeNumConst.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(MaybeNumConst!=null) MaybeNumConst.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(MaybeNumConst!=null) MaybeNumConst.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("PrintStatement(\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MaybeNumConst!=null)
            buffer.append(MaybeNumConst.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [PrintStatement]");
        return buffer.toString();
    }
}
