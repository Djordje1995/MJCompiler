package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.AnyConst;
import rs.ac.bg.etf.pp1.ast.BoolConst;
import rs.ac.bg.etf.pp1.ast.CharConst;
import rs.ac.bg.etf.pp1.ast.ConstDecl;
import rs.ac.bg.etf.pp1.ast.Designator;
import rs.ac.bg.etf.pp1.ast.DesignatorIdent;
import rs.ac.bg.etf.pp1.ast.EmptySquareBrackets;
import rs.ac.bg.etf.pp1.ast.EnumAssignNumConst;
import rs.ac.bg.etf.pp1.ast.EnumDecl;
import rs.ac.bg.etf.pp1.ast.EnumName;
import rs.ac.bg.etf.pp1.ast.EnumParam;
import rs.ac.bg.etf.pp1.ast.IdentConst;
import rs.ac.bg.etf.pp1.ast.MaybeAssignNumConst;
import rs.ac.bg.etf.pp1.ast.MaybeEmptySquareBrackets;
import rs.ac.bg.etf.pp1.ast.NumConst;
import rs.ac.bg.etf.pp1.ast.ProgName;
import rs.ac.bg.etf.pp1.ast.Program;
import rs.ac.bg.etf.pp1.ast.SyntaxNode;
import rs.ac.bg.etf.pp1.ast.Type;
import rs.ac.bg.etf.pp1.ast.VarDecl;
import rs.ac.bg.etf.pp1.ast.VarName;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class SemanticAnalyser extends VisitorAdaptor {

	boolean errorDetected = false;
	int printCallCount = 0;
	Obj currentMethod = null;
	Type currentType = null;
	Obj currentEnum = null;
	int currentEnumValue = 0;
	boolean returnFound = false;
	int nVars;
	public static final Struct boolType = new Struct(Struct.Bool);
	public static final Struct enumType = new Struct(Struct.Enum);

	Logger log = Logger.getLogger(getClass());

	public SemanticAnalyser() {
		Tab.init();
		Tab.currentScope.addToLocals(new Obj(Obj.Type, "bool", boolType));
//		scopeStack.push(ScopeEnum.GLOBAL);
//		isCorrect = true;
	}

	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" na liniji ").append(line);
		log.info(msg.toString());
	}

	public void visit(Designator designator) {
	}

	public void visit(DesignatorIdent designatorIdent) {
		Obj obj = Tab.find(designatorIdent.getName());
		if (obj == Tab.noObj) {
			report_error("Greska na liniji " + designatorIdent.getLine() + " : ime " + designatorIdent.getName()
					+ " nije deklarisano! ", null);
		}
		designatorIdent.obj = obj;
	}

	public void visit(Program program) {
		nVars = Tab.currentScope.getnVars();
		Tab.chainLocalSymbols(program.getProgName().obj);
		Tab.closeScope();
	}

	public void visit(ProgName progName) {
		progName.obj = Tab.insert(Obj.Prog, progName.getProgName(), Tab.noType);
		Tab.openScope();
	}

	public void visit(VarDecl varDecl) {
		currentType = null;
	}

	public void visit(VarName varName) {
		if (Tab.currentScope.findSymbol(varName.getVarName()) != null
				&& Tab.currentScope.findSymbol(varName.getVarName()) != Tab.noObj) {
			report_error("Visestruka deklaracija promenljive " + varName.getVarName(), varName);
		}
		MaybeEmptySquareBrackets square = varName.getMaybeEmptySquareBrackets();
		if (square instanceof EmptySquareBrackets) {
			Tab.insert(Obj.Var, varName.getVarName(), new Struct(Struct.Array, currentType.struct));
			report_info("Deklarisana je promenljiva " + varName.getVarName() + " tipa "
					+ currentType.getTypeName() + " array", varName);
		} else {
			Tab.insert(Obj.Var, varName.getVarName(), currentType.struct);
			report_info("Deklarisana je promenljiva " + varName.getVarName() + " tipa "
					+ currentType.getTypeName(), varName);
		}
	}

	public void visit(Type type) {
		Obj typeNode = Tab.find(type.getTypeName());
		if (typeNode == Tab.noObj) {
			report_error("Nije pronadjen tip " + type.getTypeName() + " u tabeli simbola", null);
			type.struct = Tab.noType;
		} else {
			if (Obj.Type == typeNode.getKind()) {
				type.struct = typeNode.getType();
			} else {
				report_error("Greska: Ime " + type.getTypeName() + " ne predstavlja tip ", type);
				type.struct = Tab.noType;
			}
		}
//		Type.struct = obj.getType();  ovo je sale koristio za nesto
		currentType = type;
	}

	public void visit(IdentConst identConst) {
		if (Tab.find(identConst.getName()) != null && Tab.find(identConst.getName()) != Tab.noObj) {
			report_error("Konstanta " + identConst.getName() + " je vec definisana ", identConst);
		}
		AnyConst cnst = identConst.getAnyConst();
		Struct tempType = null;
		if (cnst instanceof NumConst) {
			tempType = Tab.intType;
			report_info("Definisana je konstanta " + identConst.getName() + " tipa Int sa vrednoscu "
					+ ((NumConst) cnst).getNumValue(), identConst);
			Obj obj = Tab.insert(Obj.Con, identConst.getName(), Tab.intType);
			obj.setAdr(((NumConst) cnst).getNumValue());
		}
		if (cnst instanceof CharConst) {
			tempType = Tab.charType;
			report_info("Definisana je konstanta " + identConst.getName() + " tipa Char sa vrednoscu '"
					+ ((CharConst) cnst).getCharValue() + "'", identConst);
			Obj obj = Tab.insert(Obj.Con, identConst.getName(), Tab.charType);
			obj.setAdr(((CharConst) cnst).getCharValue());
		}
		if (cnst instanceof BoolConst) {
			tempType = boolType;
			report_info("Definisana je konstanta " + identConst.getName() + " tipa Bool sa vrednoscu "
					+ ((BoolConst) cnst).getBoolValue(), identConst);
			Obj obj = Tab.insert(Obj.Con, identConst.getName(), boolType);
			obj.setAdr(((BoolConst) cnst).getBoolValue() ? 1 : 0);
		}
		if (tempType != currentType.struct) {
			report_error("dodeljena vrednost nije odgovarajuceg tipa ", identConst);
			return;
		}
	}

	public void visit(ConstDecl constant) {
		currentType = null;
	}

	public void visit(EnumDecl enumDecl) {
		Tab.closeScope();
		report_info("Definisan je enum " + enumDecl.getEnumName().getEnumName(), enumDecl);
		currentType = null;
	}

	public void visit(EnumName enumName) {
		if (Tab.find(enumName.getEnumName()) != null && Tab.find(enumName.getEnumName()) != Tab.noObj) {
			report_error("Dvostruka definicija enuma " + enumName.getEnumName(), enumName);
			return;
		}
		currentEnum = Tab.insert(Obj.Type, enumName.getEnumName(), enumType);
		Tab.openScope();
		currentEnumValue = 0;
		report_info("Definise se enum " + enumName.getEnumName(), enumName);
	}

	public void visit(EnumParam enumParam) {
		if (Tab.find(enumParam.getName()) != null && Tab.find(enumParam.getName()) != Tab.noObj) {
			report_error("Polje " + enumParam.getName() + " je vec definisano unutar Enuma " + currentEnum.getName(),
					enumParam);
			return;
		}
		Obj enumField = Tab.insert(Obj.Con, enumParam.getName(), Tab.intType);
		MaybeAssignNumConst anc = enumParam.getMaybeAssignNumConst();
		if (anc instanceof EnumAssignNumConst) {
			enumField.setAdr(((EnumAssignNumConst) anc).getValue());
			currentEnumValue = ((EnumAssignNumConst) anc).getValue() + 1;
		} else {
			enumField.setAdr(currentEnumValue);
			currentEnumValue += 1;
		}
		report_info("Dodato je polje " + enumParam.getName() + " sa vrednoscu " + (currentEnumValue - 1) + " u Enum "
				+ currentEnum.getName(), enumParam);
	}

//	public void visit(MethodDecl methodDecl) {
//		if (!returnFound && currentMethod.getType() != Tab.noType) {
//			report_error("Semanticka greska na liniji " + methodDecl.getLine() + ": funcija " + currentMethod.getName() + " nema return iskaz!", null);
//		}
//		
//		Tab.chainLocalSymbols(currentMethod);
//		Tab.closeScope();
//		
//		returnFound = false;
//		currentMethod = null;
//	}
//
//	public void visit(MethodTypeName methodTypeName) {
//		currentMethod = Tab.insert(Obj.Meth, methodTypeName.getMethName(), methodTypeName.getType().struct);
//		methodTypeName.obj = currentMethod;
//		Tab.openScope();
//		report_info("Obradjuje se funkcija " + methodTypeName.getMethName(), methodTypeName);
//	}
//
//	public void visit(Assignment assignment) {
//		if (!assignment.getExpr().struct.assignableTo(assignment.getDesignator().obj.getType()))
//			report_error("Greska na liniji " + assignment.getLine() + " : " + " nekompatibilni tipovi u dodeli vrednosti ", null);
//	}
//
//	public void visit(PrintStmt printStmt){
//		printCallCount++;    	
//	}
//
//	public void visit(ReturnExpr returnExpr){
//		returnFound = true;
//		Struct currMethType = currentMethod.getType();
//		if (!currMethType.compatibleWith(returnExpr.getExpr().struct)) {
//			report_error("Greska na liniji " + returnExpr.getLine() + " : " + "tip izraza u return naredbi ne slaze se sa tipom povratne vrednosti funkcije " + currentMethod.getName(), null);
//		}			  	     	
//	}
//
//	public void visit(ProcCall procCall){
//		Obj func = procCall.getDesignator().obj;
//		if (Obj.Meth == func.getKind()) { 
//			report_info("Pronadjen poziv funkcije " + func.getName() + " na liniji " + procCall.getLine(), null);
//			//RESULT = func.getType();
//		} 
//		else {
//			report_error("Greska na liniji " + procCall.getLine()+" : ime " + func.getName() + " nije funkcija!", null);
//			//RESULT = Tab.noType;
//		}     	
//	}    
//
//	public void visit(AddExpr addExpr) {
//		Struct te = addExpr.getExpr().struct;
//		Struct t = addExpr.getTerm().struct;
//		if (te.equals(t) && te == Tab.intType)
//			addExpr.struct = te;
//		else {
//			report_error("Greska na liniji "+ addExpr.getLine()+" : nekompatibilni tipovi u izrazu za sabiranje.", null);
//			addExpr.struct = Tab.noType;
//		} 
//	}
//
//	public void visit(TermExpr termExpr) {
//		termExpr.struct = termExpr.getTerm().struct;
//	}
//
//	public void visit(Term term) {
//		term.struct = term.getFactor().struct;    	
//	}
//
//	public void visit(Const cnst){
//		cnst.struct = Tab.intType;    	
//	}
//	
//	public void visit(Var var) {
//		var.struct = var.getDesignator().obj.getType();
//	}
//
//	public void visit(FuncCall funcCall){
//		Obj func = funcCall.getDesignator().obj;
//		if (Obj.Meth == func.getKind()) { 
//			report_info("Pronadjen poziv funkcije " + func.getName() + " na liniji " + funcCall.getLine(), null);
//			funcCall.struct = func.getType();
//		} 
//		else {
//			report_error("Greska na liniji " + funcCall.getLine()+" : ime " + func.getName() + " nije funkcija!", null);
//			funcCall.struct = Tab.noType;
//		}
//
//	}
//	
	public boolean passed() {
		return !errorDetected;
	}

}
