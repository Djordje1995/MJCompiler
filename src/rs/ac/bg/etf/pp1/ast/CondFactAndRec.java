// generated with ast extension for cup
// version 0.8
// 10/5/2019 18:5:39


package rs.ac.bg.etf.pp1.ast;

public class CondFactAndRec extends CondFactAnd {

    private CondFactAnd CondFactAnd;
    private CondFact CondFact;

    public CondFactAndRec (CondFactAnd CondFactAnd, CondFact CondFact) {
        this.CondFactAnd=CondFactAnd;
        if(CondFactAnd!=null) CondFactAnd.setParent(this);
        this.CondFact=CondFact;
        if(CondFact!=null) CondFact.setParent(this);
    }

    public CondFactAnd getCondFactAnd() {
        return CondFactAnd;
    }

    public void setCondFactAnd(CondFactAnd CondFactAnd) {
        this.CondFactAnd=CondFactAnd;
    }

    public CondFact getCondFact() {
        return CondFact;
    }

    public void setCondFact(CondFact CondFact) {
        this.CondFact=CondFact;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CondFactAnd!=null) CondFactAnd.accept(visitor);
        if(CondFact!=null) CondFact.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CondFactAnd!=null) CondFactAnd.traverseTopDown(visitor);
        if(CondFact!=null) CondFact.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CondFactAnd!=null) CondFactAnd.traverseBottomUp(visitor);
        if(CondFact!=null) CondFact.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CondFactAndRec(\n");

        if(CondFactAnd!=null)
            buffer.append(CondFactAnd.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondFact!=null)
            buffer.append(CondFact.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CondFactAndRec]");
        return buffer.toString();
    }
}
