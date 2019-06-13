package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.ActualParamsBrackets;
import rs.ac.bg.etf.pp1.ast.Addop;
import rs.ac.bg.etf.pp1.ast.AddopTermListRec;
import rs.ac.bg.etf.pp1.ast.Designator;
import rs.ac.bg.etf.pp1.ast.DesignatorArrayMember;
import rs.ac.bg.etf.pp1.ast.DesignatorDec;
import rs.ac.bg.etf.pp1.ast.DesignatorExpr;
import rs.ac.bg.etf.pp1.ast.DesignatorIdent;
import rs.ac.bg.etf.pp1.ast.DesignatorInc;
import rs.ac.bg.etf.pp1.ast.DesignatorStatement;
import rs.ac.bg.etf.pp1.ast.DesignatorStatementOp;
import rs.ac.bg.etf.pp1.ast.Div;
import rs.ac.bg.etf.pp1.ast.Expr;
import rs.ac.bg.etf.pp1.ast.FactorBool;
import rs.ac.bg.etf.pp1.ast.FactorChar;
import rs.ac.bg.etf.pp1.ast.FactorDesignator;
import rs.ac.bg.etf.pp1.ast.FactorNewType;
import rs.ac.bg.etf.pp1.ast.FactorNumber;
import rs.ac.bg.etf.pp1.ast.IsMinus;
import rs.ac.bg.etf.pp1.ast.IsNumConst;
import rs.ac.bg.etf.pp1.ast.MaybeMinus;
import rs.ac.bg.etf.pp1.ast.MaybeNumConst;
import rs.ac.bg.etf.pp1.ast.MethodDecl;
import rs.ac.bg.etf.pp1.ast.MethodName;
import rs.ac.bg.etf.pp1.ast.MethodStart;
import rs.ac.bg.etf.pp1.ast.Mul;
import rs.ac.bg.etf.pp1.ast.Mulop;
import rs.ac.bg.etf.pp1.ast.MulopFactorListRec;
import rs.ac.bg.etf.pp1.ast.Plus;
import rs.ac.bg.etf.pp1.ast.PrintStatement;
import rs.ac.bg.etf.pp1.ast.ReadDesignatorStatement;
import rs.ac.bg.etf.pp1.ast.ReturnStatement;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor {

	private int mainPc;

	public Obj currentMethod = null;

	public int getMainPc() {
		return mainPc;
	}
	
	@Override
	public void visit(MethodDecl methodDecl) {
		currentMethod = null;
		Code.put(Code.exit);
		Code.put(Code.return_);
	}

	@Override
	public void visit(MethodName methodName) {
		currentMethod = methodName.obj;
	}

	@Override
	public void visit(MethodStart methodStart) {
		currentMethod.setAdr(Code.pc);
		if ("main".equals(currentMethod.getName())) {
			Code.mainPc = Code.pc;
			mainPc = Code.mainPc;
		}
		Code.put(Code.enter);
		Code.put(currentMethod.getLevel());
		Code.put(currentMethod.getLocalSymbols().size());
	}

	@Override
	public void visit(ReturnStatement returnStatement) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}

	@Override
	public void visit(FactorNewType factorNewType) {
		Struct type = factorNewType.getType().struct;
		Code.put(Code.newarray);
		Code.put(type == Tab.intType ? 1 : 0);
	}
	
	@Override
	public void visit(FactorDesignator factorDesignator) {
		Obj obj = factorDesignator.getDesignator().obj;
		
		if (factorDesignator.getMaybeParams() instanceof ActualParamsBrackets) {
			Code.put(Code.call);
			Code.put2(obj.getAdr() - Code.pc + 1);
		}
		else {
			Code.load(obj);
		}
	}

	@Override
	public void visit(FactorNumber factorNumber) {
		Obj obj = new Obj(Obj.Con, "", factorNumber.struct, factorNumber.getN1(), 0);
		Code.load(obj);
	}

	@Override
	public void visit(FactorChar factorChar) {
		Code.load(new Obj(Obj.Con, "", Tab.charType, factorChar.getC1(), 0));
	}

	@Override
	public void visit(FactorBool factorBool) {
		Code.load(new Obj(Obj.Con, "", SemanticAnalyser.boolType, factorBool.getB1() ? 1 : 0, 0));
	}

	@Override
	public void visit(PrintStatement printStatement) {
		MaybeNumConst mnc = printStatement.getMaybeNumConst();
		if (mnc instanceof IsNumConst) {
			IsNumConst isc = (IsNumConst) mnc;
			Code.loadConst(isc.getN1());
		}
		else {
			Code.loadConst(3);
		}
		if (printStatement.getExpr().struct == Tab.intType
		    || printStatement.getExpr().struct == SemanticAnalyser.boolType) {
			Code.put(Code.print);
		} else {
			Code.put(Code.bprint);
		}
	}
	
	@Override
	public void visit(ReadDesignatorStatement readDesignatorStatement) {
		Struct type = readDesignatorStatement.getDesignator().obj.getType();
		if (type == Tab.intType) {
			Code.put(Code.read);
		}
		else {
			Code.put(Code.bread);
		}
		Code.store(readDesignatorStatement.getDesignator().obj);
	}

	@Override
	public void visit(DesignatorStatement designatorStatement) {
		Designator designator = designatorStatement.getDesignator();
		DesignatorStatementOp stmt = designatorStatement.getDesignatorStatementOp();
		if (stmt instanceof DesignatorInc) {
			if (designator instanceof DesignatorArrayMember) {
				Code.put(Code.dup2);
			}
			Code.load(designator.obj);
			Code.loadConst(1);
			Code.put(Code.add);
			Code.store(designator.obj);
		}
		else if (stmt instanceof DesignatorDec) {
			if (designator instanceof DesignatorArrayMember) {
				Code.put(Code.dup2);
			}
			Code.load(designator.obj);
			Code.loadConst(1);
			Code.put(Code.sub);
			Code.store(designator.obj);
		}
		else if (stmt instanceof DesignatorExpr) {
			Code.store(designator.obj);
		}
		else {
			Code.put(Code.call);
			Code.put2(designatorStatement.getDesignator().obj.getAdr() - Code.pc + 1);
		}
	}

	@Override
	public void visit(Expr expr) {
		MaybeMinus neg = expr.getMaybeMinus();
		if (neg instanceof IsMinus) {
			Code.put(Code.neg);
		}
	}
	
	@Override
	public void visit(DesignatorIdent designatorIdent) {
		if (designatorIdent.getParent() instanceof DesignatorArrayMember) {
			Code.load(designatorIdent.obj);
		}
	}
	
	@Override
	public void visit(MulopFactorListRec mulopFactorListRec) {
		Mulop mulop = mulopFactorListRec.getMulop();
		if (mulop instanceof Mul) {
			Code.put(Code.mul);
		} else if (mulop instanceof Div) {
			Code.put(Code.div);
		} else {
			Code.put(Code.rem);
		}
	}
	
	@Override 
	public void visit(AddopTermListRec addopTermListRec) {
		Addop addop = addopTermListRec.getAddop();
		if (addop instanceof Plus) {
			Code.put(Code.add);
		} else {
			Code.put(Code.sub);
		}
	}
	
	@Override
	public void visit(Mulop mulop) {
		if (mulop instanceof Mul) {
			Code.put(Code.mul);
		} else if (mulop instanceof Div) {
			Code.put(Code.div);
		} else {
			Code.put(Code.rem);
		}
	}

	@Override
	public void visit(Addop addop) {
		if (addop instanceof Plus) {
			Code.put(Code.add);
		} else {
			Code.put(Code.sub);
		}
	}
}
