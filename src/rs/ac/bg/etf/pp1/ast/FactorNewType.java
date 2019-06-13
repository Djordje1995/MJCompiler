// generated with ast extension for cup
// version 0.8
// 13/5/2019 19:21:6


package rs.ac.bg.etf.pp1.ast;

public class FactorNewType extends Factor {

    private Type Type;
    private MaybeExpression MaybeExpression;

    public FactorNewType (Type Type, MaybeExpression MaybeExpression) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.MaybeExpression=MaybeExpression;
        if(MaybeExpression!=null) MaybeExpression.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public MaybeExpression getMaybeExpression() {
        return MaybeExpression;
    }

    public void setMaybeExpression(MaybeExpression MaybeExpression) {
        this.MaybeExpression=MaybeExpression;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(MaybeExpression!=null) MaybeExpression.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(MaybeExpression!=null) MaybeExpression.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(MaybeExpression!=null) MaybeExpression.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorNewType(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MaybeExpression!=null)
            buffer.append(MaybeExpression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorNewType]");
        return buffer.toString();
    }
}
