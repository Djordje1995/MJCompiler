// generated with ast extension for cup
// version 0.8
// 16/4/2019 21:19:58


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(Unmatched Unmatched);
    public void visit(DeclarationList DeclarationList);
    public void visit(Mulop Mulop);
    public void visit(MaybeMinus MaybeMinus);
    public void visit(InterfaceMethodDeclList InterfaceMethodDeclList);
    public void visit(Matched Matched);
    public void visit(Relop Relop);
    public void visit(ActParList ActParList);
    public void visit(Assignop Assignop);
    public void visit(MulopFactorList MulopFactorList);
    public void visit(MaybeImplements MaybeImplements);
    public void visit(StatementList StatementList);
    public void visit(CondFactAnd CondFactAnd);
    public void visit(Addop Addop);
    public void visit(IdentConstList IdentConstList);
    public void visit(TypeList TypeList);
    public void visit(Factor Factor);
    public void visit(MaybeExpression MaybeExpression);
    public void visit(Designator Designator);
    public void visit(MaybeFormPars MaybeFormPars);
    public void visit(FormParsList FormParsList);
    public void visit(IdentList IdentList);
    public void visit(ReturnExpression ReturnExpression);
    public void visit(MaybeRelopExpr MaybeRelopExpr);
    public void visit(AnyConst AnyConst);
    public void visit(MaybeCondition MaybeCondition);
    public void visit(MaybeDesignatorStatement MaybeDesignatorStatement);
    public void visit(MaybeMethodDecl MaybeMethodDecl);
    public void visit(MaybeEmptySquareBrackets MaybeEmptySquareBrackets);
    public void visit(VarDeclList VarDeclList);
    public void visit(TypeOrVoid TypeOrVoid);
    public void visit(MaybeAssignNumConst MaybeAssignNumConst);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(MaybeActualParams MaybeActualParams);
    public void visit(MaybeParams MaybeParams);
    public void visit(Statement Statement);
    public void visit(EnumParamList EnumParamList);
    public void visit(MaybeNumConst MaybeNumConst);
    public void visit(MaybeExtends MaybeExtends);
    public void visit(MethodDeclList MethodDeclList);
    public void visit(CondTermOr CondTermOr);
    public void visit(AddopTermList AddopTermList);
    public void visit(Mod Mod);
    public void visit(Div Div);
    public void visit(Mul Mul);
    public void visit(Minus Minus);
    public void visit(Plus Plus);
    public void visit(LesserOrEqual LesserOrEqual);
    public void visit(Lesser Lesser);
    public void visit(GreaterOrEqual GreaterOrEqual);
    public void visit(Greater Greater);
    public void visit(NotEqual NotEqual);
    public void visit(Equal Equal);
    public void visit(Assign Assign);
    public void visit(DesignatorIdent DesignatorIdent);
    public void visit(DesignatorArrayMember DesignatorArrayMember);
    public void visit(DesignatorRefMember DesignatorRefMember);
    public void visit(MaybeExpressionDerived2 MaybeExpressionDerived2);
    public void visit(MaybeExpressionDerived1 MaybeExpressionDerived1);
    public void visit(MaybeActualParamsDerived2 MaybeActualParamsDerived2);
    public void visit(MaybeActualParamsDerived1 MaybeActualParamsDerived1);
    public void visit(MaybeParamsDerived2 MaybeParamsDerived2);
    public void visit(MaybeParamsDerived1 MaybeParamsDerived1);
    public void visit(FactorExpression FactorExpression);
    public void visit(FactorNewType FactorNewType);
    public void visit(FactorBool FactorBool);
    public void visit(FactorChar FactorChar);
    public void visit(FactorNumber FactorNumber);
    public void visit(FactorDesignator FactorDesignator);
    public void visit(MulopFactorListDerived1 MulopFactorListDerived1);
    public void visit(MulopFactorListRec MulopFactorListRec);
    public void visit(Term Term);
    public void visit(AddopTermListDerived1 AddopTermListDerived1);
    public void visit(AddopTermListRec AddopTermListRec);
    public void visit(MaybeMinusDerived2 MaybeMinusDerived2);
    public void visit(MaybeMinusDerived1 MaybeMinusDerived1);
    public void visit(Expr Expr);
    public void visit(MaybeRelopExprDerived2 MaybeRelopExprDerived2);
    public void visit(MaybeRelopExprDerived1 MaybeRelopExprDerived1);
    public void visit(CondFact CondFact);
    public void visit(CondFactAndDerived1 CondFactAndDerived1);
    public void visit(CondFactAndRec CondFactAndRec);
    public void visit(CondTerm CondTerm);
    public void visit(CondTermOrDerived1 CondTermOrDerived1);
    public void visit(CondTermOrRec CondTermOrRec);
    public void visit(Condition Condition);
    public void visit(ActParListDerived1 ActParListDerived1);
    public void visit(ActParListRec ActParListRec);
    public void visit(ActPars ActPars);
    public void visit(DesignatorDec DesignatorDec);
    public void visit(DesignatorInc DesignatorInc);
    public void visit(DesignatorParams DesignatorParams);
    public void visit(DesignatorExpr DesignatorExpr);
    public void visit(MaybeDesignatorStatementDerived2 MaybeDesignatorStatementDerived2);
    public void visit(MaybeDesignatorStatementDerived1 MaybeDesignatorStatementDerived1);
    public void visit(MaybeConditionDerived2 MaybeConditionDerived2);
    public void visit(MaybeConditionDerived1 MaybeConditionDerived1);
    public void visit(ReturnExpressionDerived2 ReturnExpressionDerived2);
    public void visit(ReturnExpressionDerived1 ReturnExpressionDerived1);
    public void visit(MaybeNumConstDerived2 MaybeNumConstDerived2);
    public void visit(MaybeNumConstDerived1 MaybeNumConstDerived1);
    public void visit(StatementListDerived1 StatementListDerived1);
    public void visit(StatementListRec StatementListRec);
    public void visit(StatementBody StatementBody);
    public void visit(PrintStatement PrintStatement);
    public void visit(ReadDesignatorStatement ReadDesignatorStatement);
    public void visit(ReturnStatement ReturnStatement);
    public void visit(Continue Continue);
    public void visit(Break Break);
    public void visit(ForStatement ForStatement);
    public void visit(MatchedIf MatchedIf);
    public void visit(DesignStatement DesignStatement);
    public void visit(UnmatchedIfElse UnmatchedIfElse);
    public void visit(UnmatchedIf UnmatchedIf);
    public void visit(UnmatchedStmt UnmatchedStmt);
    public void visit(MatchedStmt MatchedStmt);
    public void visit(Type Type);
    public void visit(FormParsListDerived1 FormParsListDerived1);
    public void visit(FormParsListRec FormParsListRec);
    public void visit(MaybeEmptySquareBracketsDerived2 MaybeEmptySquareBracketsDerived2);
    public void visit(MaybeEmptySquareBracketsDerived1 MaybeEmptySquareBracketsDerived1);
    public void visit(FormPars FormPars);
    public void visit(VarDeclListDerived1 VarDeclListDerived1);
    public void visit(VarDeclListRec VarDeclListRec);
    public void visit(MaybeFormParsDerived2 MaybeFormParsDerived2);
    public void visit(MaybeFormParsDerived1 MaybeFormParsDerived1);
    public void visit(VoidType VoidType);
    public void visit(SomeType SomeType);
    public void visit(MethodDecl MethodDecl);
    public void visit(InterfaceMethodDecl InterfaceMethodDecl);
    public void visit(InterfaceMethodDeclListDerived1 InterfaceMethodDeclListDerived1);
    public void visit(InterfaceMethodDeclListRec InterfaceMethodDeclListRec);
    public void visit(InterfaceDecl InterfaceDecl);
    public void visit(MaybeExtendsDerived2 MaybeExtendsDerived2);
    public void visit(MaybeExtendsDerived1 MaybeExtendsDerived1);
    public void visit(TypeListDerived1 TypeListDerived1);
    public void visit(TypeListRec TypeListRec);
    public void visit(MaybeImplementsDerived2 MaybeImplementsDerived2);
    public void visit(MaybeImplementsDerived1 MaybeImplementsDerived1);
    public void visit(MethodDeclListDerived1 MethodDeclListDerived1);
    public void visit(MethodDeclListRec MethodDeclListRec);
    public void visit(MaybeMethodDeclDerived2 MaybeMethodDeclDerived2);
    public void visit(MaybeMethodDeclDerived1 MaybeMethodDeclDerived1);
    public void visit(ClassDecl ClassDecl);
    public void visit(IdentListDerived1 IdentListDerived1);
    public void visit(IdentListRec IdentListRec);
    public void visit(VarDecl VarDecl);
    public void visit(MaybeAssignNumConstDerived2 MaybeAssignNumConstDerived2);
    public void visit(MaybeAssignNumConstDerived1 MaybeAssignNumConstDerived1);
    public void visit(NoEnumParamsList NoEnumParamsList);
    public void visit(EnumParamsList EnumParamsList);
    public void visit(EnumParam EnumParam);
    public void visit(EnumName EnumName);
    public void visit(EnumDecl EnumDecl);
    public void visit(BoolConst BoolConst);
    public void visit(CharConst CharConst);
    public void visit(NumConst NumConst);
    public void visit(IdentConstListDerived1 IdentConstListDerived1);
    public void visit(IdentConstListRec IdentConstListRec);
    public void visit(IdentConst IdentConst);
    public void visit(ConstDecl ConstDecl);
    public void visit(InterfaceDeclaration InterfaceDeclaration);
    public void visit(EnumDeclaration EnumDeclaration);
    public void visit(ClassDeclaration ClassDeclaration);
    public void visit(VarDeclaration VarDeclaration);
    public void visit(ConstDeclaration ConstDeclaration);
    public void visit(ProgName ProgName);
    public void visit(Program Program);

}
