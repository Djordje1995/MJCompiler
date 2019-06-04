package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.Addop;
import rs.ac.bg.etf.pp1.ast.Div;
import rs.ac.bg.etf.pp1.ast.FactorBool;
import rs.ac.bg.etf.pp1.ast.FactorChar;
import rs.ac.bg.etf.pp1.ast.FactorNumber;
import rs.ac.bg.etf.pp1.ast.MethodDecl;
import rs.ac.bg.etf.pp1.ast.MethodName;
import rs.ac.bg.etf.pp1.ast.MethodStart;
import rs.ac.bg.etf.pp1.ast.Mul;
import rs.ac.bg.etf.pp1.ast.Mulop;
import rs.ac.bg.etf.pp1.ast.Plus;
import rs.ac.bg.etf.pp1.ast.PrintStatement;
import rs.ac.bg.etf.pp1.ast.ReturnStatement;
import rs.ac.bg.etf.pp1.ast.VarDecl;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;

public class CodeGenerator extends VisitorAdaptor {
	
	private int varCount;
	
	private int paramCnt;
	
	private int mainPc;
	
	public Obj currentMethod = null;
	
	public int getMainPc() {
		return mainPc;
	}
	
//	@Override
//	public void visit(ProgName ProgName) {
//
//		Collection<Obj> universeLocals = Tab.currentScope.getLocals().symbols();
//		for (Obj obj : universeLocals) {
//			if (obj.getKind() == Obj.Meth) {
//
//				obj.setAdr(Code.pc);
//				Code.put(Code.enter);
//				Code.put(obj.getLevel());
//				Code.put(obj.getLocalSymbols().size());
//				Code.put(Code.load_n);
//
//				if ("len".equals(obj.getName())) {
//					Code.put(Code.arraylength);
//				}
//
//				Code.put(Code.exit);
//				Code.put(Code.return_);
//			}
//		}
//
//		Obj prog = Tab.find(ProgName.getProgName());
//		Tab.openScope();
//		for (Obj obj : prog.getLocalSymbols()) {
//			if (obj.getKind() == Obj.Var) {
//				Code.dataSize++;
//			}
//			Tab.currentScope.addToLocals(obj);
//		}
//	}
	
//	@Override
//	public void visit(MethodTypeName MethodTypeName) {
//		if ("main".equalsIgnoreCase(MethodTypeName.getMethName())) {
//			mainPc = Code.pc;
//		}
//		MethodTypeName.obj.setAdr(Code.pc);
//		
//		// Collect arguments and local variables.
//		SyntaxNode methodNode = MethodTypeName.getParent();
//		VarCounter varCnt = new VarCounter();
//		methodNode.traverseTopDown(varCnt);
//		FormParamCounter fpCnt = new FormParamCounter();
//		methodNode.traverseTopDown(fpCnt);
//		
//		// Generate the entry.
//		Code.put(Code.enter);
//		Code.put(fpCnt.getCount());
//		Code.put(varCnt.getCount() + fpCnt.getCount());
//	}
	
	@Override
	public void visit(VarDecl VarDecl) {
		varCount++;
	}

//	@Override
//	public void visit(FormalParamDecl FormalParam) {
//		paramCnt++;
//	}	
//	
//	@Override
//	public void visit(MethodDecl MethodDecl) {
//		Code.put(Code.exit);
//		Code.put(Code.return_);
//	}
//	@Override
//	public void visit(Assignment Assignment) {
//		Code.store(Assignment.getDesignator().obj);
//	}
//	
//	@Override
//	public void visit(Designator Designator) {
//		SyntaxNode parent = Designator.getParent();
//		if (Assignment.class != parent.getClass() && FuncCall.class != parent.getClass()) {
//			Code.load(Designator.obj);
//		}
//	}
//	
//	@Override
//	public void visit(FuncCall FuncCall) {
//		Obj functionObj = FuncCall.getDesignator().obj;
//		int offset = functionObj.getAdr() - Code.pc; 
//		Code.put(Code.call);
//		Code.put2(offset);
//	}
//	
	

	@Override
	public void visit(MethodDecl methodDecl) {
		currentMethod = null;
		Code.put(Code.exit);
		Code.put(Code.return_);
		Tab.closeScope();
	}

	@Override
	public void visit(MethodName methodName) {
		currentMethod = Tab.find(methodName.getMethodName());
		Tab.openScope();
	}

	@Override
	public void visit(MethodStart methodStart) {
		currentMethod.setAdr(Code.pc);
		if ("main".equals(currentMethod.getName())) {
			Code.mainPc = Code.pc;
		}
		Code.put(Code.enter);
		Code.put(currentMethod.getLevel());
		Code.put(currentMethod.getLocalSymbols().size());
	}
	
	@Override
	public void visit (ReturnStatement returnStatement) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	@Override
	public void visit(FactorNumber factorNumber) {
		Code.load(new Obj(Obj.Con, "", factorNumber.struct, factorNumber.getN1(), 0)); 
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
		if (printStatement.getExpr().struct == Tab.intType || printStatement.getExpr().struct == SemanticAnalyser.boolType) {
			Code.loadConst(5);
			Code.put(Code.print);
		}
		else {
			Code.loadConst(1);
			Code.put(Code.bprint);
		}
	}
	
	@Override
	public void visit(Mulop mulop) {
		if (mulop instanceof Mul) {
			Code.put(Code.mul);
		}
		else if (mulop instanceof Div) {
			Code.put(Code.div);
		}
		else {
			Code.put(Code.rem);
		}
	}
	
	@Override
	public void visit(Addop addop) {
		if (addop instanceof Plus) {
			Code.put(Code.add);
		}
		else {
			Code.put(Code.sub);
		}
	}
}
