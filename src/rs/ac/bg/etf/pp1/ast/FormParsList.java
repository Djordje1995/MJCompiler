// generated with ast extension for cup
// version 0.8
// 29/3/2019 10:23:43


package rs.ac.bg.etf.pp1.ast;

public class FormParsList implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private FormParsList FormParsList;
    private Type Type;
    private String I2;
    private MaybeEmptySquareBrackets MaybeEmptySquareBrackets;

    public FormParsList (FormParsList FormParsList, Type Type, String I2, MaybeEmptySquareBrackets MaybeEmptySquareBrackets) {
        this.FormParsList=FormParsList;
        if(FormParsList!=null) FormParsList.setParent(this);
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.I2=I2;
        this.MaybeEmptySquareBrackets=MaybeEmptySquareBrackets;
        if(MaybeEmptySquareBrackets!=null) MaybeEmptySquareBrackets.setParent(this);
    }

    public FormParsList getFormParsList() {
        return FormParsList;
    }

    public void setFormParsList(FormParsList FormParsList) {
        this.FormParsList=FormParsList;
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
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
        if(FormParsList!=null) FormParsList.accept(visitor);
        if(Type!=null) Type.accept(visitor);
        if(MaybeEmptySquareBrackets!=null) MaybeEmptySquareBrackets.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormParsList!=null) FormParsList.traverseTopDown(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(MaybeEmptySquareBrackets!=null) MaybeEmptySquareBrackets.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormParsList!=null) FormParsList.traverseBottomUp(visitor);
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(MaybeEmptySquareBrackets!=null) MaybeEmptySquareBrackets.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParsList(\n");

        if(FormParsList!=null)
            buffer.append(FormParsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
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
        buffer.append(") [FormParsList]");
        return buffer.toString();
    }
}
