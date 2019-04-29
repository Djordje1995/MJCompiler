// generated with ast extension for cup
// version 0.8
// 29/3/2019 10:23:44


package rs.ac.bg.etf.pp1.ast;

public class ForStatement extends Matched {

    private MaybeDesignatorStatement MaybeDesignatorStatement;
    private MaybeCondition MaybeCondition;
    private MaybeDesignatorStatement MaybeDesignatorStatement1;
    private Matched Matched;

    public ForStatement (MaybeDesignatorStatement MaybeDesignatorStatement, MaybeCondition MaybeCondition, MaybeDesignatorStatement MaybeDesignatorStatement1, Matched Matched) {
        this.MaybeDesignatorStatement=MaybeDesignatorStatement;
        if(MaybeDesignatorStatement!=null) MaybeDesignatorStatement.setParent(this);
        this.MaybeCondition=MaybeCondition;
        if(MaybeCondition!=null) MaybeCondition.setParent(this);
        this.MaybeDesignatorStatement1=MaybeDesignatorStatement1;
        if(MaybeDesignatorStatement1!=null) MaybeDesignatorStatement1.setParent(this);
        this.Matched=Matched;
        if(Matched!=null) Matched.setParent(this);
    }

    public MaybeDesignatorStatement getMaybeDesignatorStatement() {
        return MaybeDesignatorStatement;
    }

    public void setMaybeDesignatorStatement(MaybeDesignatorStatement MaybeDesignatorStatement) {
        this.MaybeDesignatorStatement=MaybeDesignatorStatement;
    }

    public MaybeCondition getMaybeCondition() {
        return MaybeCondition;
    }

    public void setMaybeCondition(MaybeCondition MaybeCondition) {
        this.MaybeCondition=MaybeCondition;
    }

    public MaybeDesignatorStatement getMaybeDesignatorStatement1() {
        return MaybeDesignatorStatement1;
    }

    public void setMaybeDesignatorStatement1(MaybeDesignatorStatement MaybeDesignatorStatement1) {
        this.MaybeDesignatorStatement1=MaybeDesignatorStatement1;
    }

    public Matched getMatched() {
        return Matched;
    }

    public void setMatched(Matched Matched) {
        this.Matched=Matched;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MaybeDesignatorStatement!=null) MaybeDesignatorStatement.accept(visitor);
        if(MaybeCondition!=null) MaybeCondition.accept(visitor);
        if(MaybeDesignatorStatement1!=null) MaybeDesignatorStatement1.accept(visitor);
        if(Matched!=null) Matched.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MaybeDesignatorStatement!=null) MaybeDesignatorStatement.traverseTopDown(visitor);
        if(MaybeCondition!=null) MaybeCondition.traverseTopDown(visitor);
        if(MaybeDesignatorStatement1!=null) MaybeDesignatorStatement1.traverseTopDown(visitor);
        if(Matched!=null) Matched.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MaybeDesignatorStatement!=null) MaybeDesignatorStatement.traverseBottomUp(visitor);
        if(MaybeCondition!=null) MaybeCondition.traverseBottomUp(visitor);
        if(MaybeDesignatorStatement1!=null) MaybeDesignatorStatement1.traverseBottomUp(visitor);
        if(Matched!=null) Matched.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ForStatement(\n");

        if(MaybeDesignatorStatement!=null)
            buffer.append(MaybeDesignatorStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MaybeCondition!=null)
            buffer.append(MaybeCondition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MaybeDesignatorStatement1!=null)
            buffer.append(MaybeDesignatorStatement1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Matched!=null)
            buffer.append(Matched.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ForStatement]");
        return buffer.toString();
    }
}
