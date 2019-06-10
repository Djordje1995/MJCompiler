package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.ActParListRec;
import rs.ac.bg.etf.pp1.ast.ActPars;
import rs.ac.bg.etf.pp1.ast.ActualParams;
import rs.ac.bg.etf.pp1.ast.ActualParamsBrackets;
import rs.ac.bg.etf.pp1.ast.AddopTermListRec;
import rs.ac.bg.etf.pp1.ast.AnyConst;
import rs.ac.bg.etf.pp1.ast.BoolConst;
import rs.ac.bg.etf.pp1.ast.CharConst;
import rs.ac.bg.etf.pp1.ast.ConstDecl;
import rs.ac.bg.etf.pp1.ast.Designator;
import rs.ac.bg.etf.pp1.ast.DesignatorArrayMember;
import rs.ac.bg.etf.pp1.ast.DesignatorDec;
import rs.ac.bg.etf.pp1.ast.DesignatorExpr;
import rs.ac.bg.etf.pp1.ast.DesignatorIdent;
import rs.ac.bg.etf.pp1.ast.DesignatorInc;
import rs.ac.bg.etf.pp1.ast.DesignatorParams;
import rs.ac.bg.etf.pp1.ast.DesignatorRefMember;
import rs.ac.bg.etf.pp1.ast.DesignatorStatement;
import rs.ac.bg.etf.pp1.ast.DesignatorStatementOp;
import rs.ac.bg.etf.pp1.ast.EmptySquareBrackets;
import rs.ac.bg.etf.pp1.ast.EnumAssignNumConst;
import rs.ac.bg.etf.pp1.ast.EnumDecl;
import rs.ac.bg.etf.pp1.ast.EnumName;
import rs.ac.bg.etf.pp1.ast.EnumParam;
import rs.ac.bg.etf.pp1.ast.Expr;
import rs.ac.bg.etf.pp1.ast.Factor;
import rs.ac.bg.etf.pp1.ast.FactorBool;
import rs.ac.bg.etf.pp1.ast.FactorChar;
import rs.ac.bg.etf.pp1.ast.FactorDesignator;
import rs.ac.bg.etf.pp1.ast.FactorExpression;
import rs.ac.bg.etf.pp1.ast.FactorNewType;
import rs.ac.bg.etf.pp1.ast.FactorNumber;
import rs.ac.bg.etf.pp1.ast.FormParams;
import rs.ac.bg.etf.pp1.ast.FormalParam;
import rs.ac.bg.etf.pp1.ast.IdentConst;
import rs.ac.bg.etf.pp1.ast.IsExpression;
import rs.ac.bg.etf.pp1.ast.IsMinus;
import rs.ac.bg.etf.pp1.ast.MaybeActualParams;
import rs.ac.bg.etf.pp1.ast.MaybeAssignNumConst;
import rs.ac.bg.etf.pp1.ast.MaybeEmptySquareBrackets;
import rs.ac.bg.etf.pp1.ast.MaybeExpression;
import rs.ac.bg.etf.pp1.ast.MaybeMinus;
import rs.ac.bg.etf.pp1.ast.MaybeParams;
import rs.ac.bg.etf.pp1.ast.MethodDecl;
import rs.ac.bg.etf.pp1.ast.MethodName;
import rs.ac.bg.etf.pp1.ast.MulopFactorListRec;
import rs.ac.bg.etf.pp1.ast.NoFormParams;
import rs.ac.bg.etf.pp1.ast.NoReturnExpression;
import rs.ac.bg.etf.pp1.ast.NumConst;
import rs.ac.bg.etf.pp1.ast.PrintStatement;
import rs.ac.bg.etf.pp1.ast.ProgName;
import rs.ac.bg.etf.pp1.ast.Program;
import rs.ac.bg.etf.pp1.ast.ReadDesignatorStatement;
import rs.ac.bg.etf.pp1.ast.ReturnExpressionE;
import rs.ac.bg.etf.pp1.ast.SomeType;
import rs.ac.bg.etf.pp1.ast.SyntaxNode;
import rs.ac.bg.etf.pp1.ast.Term;
import rs.ac.bg.etf.pp1.ast.Type;
import rs.ac.bg.etf.pp1.ast.TypeOrVoid;
import rs.ac.bg.etf.pp1.ast.VarDcl;
import rs.ac.bg.etf.pp1.ast.VarName;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.ac.bg.etf.pp1.ast.VoidType;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;
import rs.etf.pp1.symboltable.structure.HashTableDataStructure;
import rs.etf.pp1.symboltable.structure.SymbolDataStructure;

public class SemanticAnalyser extends VisitorAdaptor {

	boolean errorDetected = false;
	int printCallCount = 0;
	Obj currentMethod = null;
	Type currentType = null;
	Type methodType = null;
	Obj currentEnum = null;
	int currentEnumValue = 0;
	boolean returnFound = false;
	boolean hasArguments = false;
	boolean wasMain = false;
	int numLocalVars;
	int numGlobalVars;
	boolean isGlobal;
	boolean isVoid;
	public static final Struct boolType = new Struct(Struct.Bool);
	public static final Struct enumType = new Struct(Struct.Enum);
	public SymbolDataStructure sds;
	public List<Struct> actualParamsList = new ArrayList<>();

	Logger log = Logger.getLogger(getClass());

	public SemanticAnalyser() {
		Tab.init();
		Tab.currentScope.addToLocals(new Obj(Obj.Type, "bool", boolType));
		numLocalVars = 0;
		numGlobalVars = 0;
		isGlobal = true;
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

	public void visit(FactorNewType factorNewType) {
		Type type = factorNewType.getType();
		MaybeExpression me = factorNewType.getMaybeExpression();
		Expr expr = null;
		if (me instanceof IsExpression) {
			expr = ((IsExpression) me).getExpr();
		}
		if (expr != null && expr.struct.getKind() != Struct.Int) {
			report_error("Greska, duzina niza mora da bude tipa int", factorNewType);
			return;
		}
		Struct arrayType = new Struct(Struct.Array, type.struct);
		factorNewType.struct = arrayType;
	}

	public void visit(FactorDesignator factorDesignator) {
		Designator designator = factorDesignator.getDesignator();
		if (designator.obj == null) {
			report_error("Greska, promenljiva nije deklarisana", factorDesignator);
			return;
		}
		if (designator instanceof DesignatorIdent) {
			factorDesignator.struct = designator.obj.getType();
		} else if (designator instanceof DesignatorRefMember) {
			factorDesignator.struct = Tab.intType;
		} else {
			factorDesignator.struct = designator.obj.getType();
		}
		if (factorDesignator.getMaybeParams() instanceof ActualParamsBrackets) {
			MaybeParams mp = (MaybeParams) factorDesignator.getMaybeParams();
			if (designator.obj.getKind() != Obj.Meth) {
				report_error("Greska, " + designator.obj.getName() + " nije funkcija", factorDesignator);
				return;
			}
			if (mp instanceof ActualParamsBrackets) {
				MaybeActualParams map = ((ActualParamsBrackets) mp).getMaybeActualParams();
				if (map instanceof ActualParams) {
					List<Struct> formalParams = new ArrayList<>();
					Collection<Obj> localSymbols = designator.obj.getLocalSymbols();
					int numOfParams = designator.obj.getLevel();
					int counter = 0;
					for (Obj obj:localSymbols) {
						if (counter < numOfParams) {
							formalParams.add(obj.getType());
							counter++;
						}
						else {
							break;
						}
					}
					if (formalParams.size() != actualParamsList.size()) {
						report_error("Greska, neodgovarajuci broj argumenata ", factorDesignator);
						return;
					}
					else {
						for (int i = 0; i < formalParams.size(); i++) {
							if (!formalParams.get(i).compatibleWith(actualParamsList.get(i))) {
								report_error("Greska, neodgovarajuci tip argumenta pri pozivu funkcije ", factorDesignator);
								return;
							}
						}
					}
					actualParamsList.clear();
				}

			}
		}
//		if (factorDesignator.getMaybeParams() instanceof MaybeParams) {
//			MaybeParams mp = factorDesignator.getMaybeParams();
//			if (mp instanceof ActualParamsBrackets) {
//				MaybeActualParams apb = ((ActualParamsBrackets) mp).getMaybeActualParams();
//				if (apb instanceof ActualParams) {
//					ActPars ap = ((ActualParams) apb).getActPars();
////					ap.getExpr()
//				}
//			}
//		}
	}

	public void visit(FormalParam formalParam) {
		Type type = formalParam.getType();
		Struct paramType = type.struct;
		MaybeEmptySquareBrackets isArray = formalParam.getMaybeEmptySquareBrackets();
		if (isArray instanceof EmptySquareBrackets) {
			paramType = new Struct(Struct.Array, type.struct);
		}
		Tab.insert(Obj.Var, formalParam.getI1(), paramType);
		report_info("Dodat formalni parametar " + formalParam.getI1() + "", formalParam);
		currentMethod.setLevel(currentMethod.getLevel() + 1);
	}
	
	public void visit(ActParListRec actParListRec) {
		actualParamsList.add(0, actParListRec.getExpr().struct);  //valjda je dovoljno
	}
	
	public void visit(ActPars actPars) {
		actualParamsList.add(0, actPars.getExpr().struct);
	}
	
	public void visit(FactorExpression factorExpression) {
		factorExpression.struct = factorExpression.getExpr().struct;
	}

	public void visit(DesignatorIdent designatorIdent) {
		Obj obj = Tab.find(designatorIdent.getName());
		if (obj == Tab.noObj) {
			report_error("Greska na liniji " + designatorIdent.getLine() + " : ime " + designatorIdent.getName()
			    + " nije deklarisano! ", null);
			return;
		}
		designatorIdent.obj = obj;
	}

	public void visit(DesignatorRefMember designatorRefMember) {
		Designator designator = designatorRefMember.getDesignator();
		if (designator.obj != null && designator.obj.getType() != enumType) {
			report_error("Greska, " + designator.obj.getName() + " nije enum", designatorRefMember);
			return;
		}
		Collection<Obj> enumFields = designator.obj.getLocalSymbols();
		for (Obj field : enumFields) {
			if (field.getName().equals(designatorRefMember.getI2())) {
				designatorRefMember.obj = field;
				break;
			}
		}
	}

	public void visit(DesignatorArrayMember designatorArrayMember) {
		Designator designator = designatorArrayMember.getDesignator();
		Expr expr = designatorArrayMember.getExpr();
		if (designator.obj.getType().getKind() != Struct.Array) {
			report_error("Greska, promenljiva " + designator.obj.getName() + " nije niz", designatorArrayMember);
			return;
		}
		if (expr.struct.getKind() != Struct.Int) {
			report_error("Greska, indeks niza mora biti int tipa", designatorArrayMember);
		}
		designatorArrayMember.obj = new Obj(Obj.Elem, designator.obj.getName(), designator.obj.getType().getElemType());
	}

	public void visit(Program program) {
		numGlobalVars = Tab.currentScope.getnVars();
		if (!wasMain) {
			report_error("Nije definisana metoda main u programu", program);
			return;
		}
		log.info("Globalnih promeljivih ima " + numGlobalVars + ", a lokalnih " + numLocalVars);
		Tab.chainLocalSymbols(program.getProgName().obj);
		Tab.closeScope();
	}

	public void visit(ProgName progName) {
		progName.obj = Tab.insert(Obj.Prog, progName.getProgName(), Tab.noType);
		Tab.openScope();
	}

	public void visit(VarDcl varDcl) {
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
			report_info("Deklarisana je " + (isGlobal ? "globalna" : "lokalna") + " promenljiva " + varName.getVarName()
			    + " tipa " + currentType.getTypeName() + " array", varName);
		} else {
			Tab.insert(Obj.Var, varName.getVarName(), currentType.struct);
			report_info("Deklarisana je " + (isGlobal ? "globalna" : "lokalna") + " promenljiva " + varName.getVarName()
			    + " tipa " + currentType.getTypeName(), varName);
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
		type.struct = typeNode.getType();
		currentType = type;
	}

	public void visit(IdentConst identConst) {
		if (Tab.find(identConst.getName()) != null && Tab.find(identConst.getName()) != Tab.noObj) {
			report_error("Konstanta " + identConst.getName() + " je vec definisana ", identConst);
			return;
		}
		AnyConst cnst = identConst.getAnyConst();
		Struct tempType = null;
		if (cnst instanceof NumConst) {
			tempType = Tab.intType;
			report_info("Definisana je konstanta " + identConst.getName() + " tipa Int sa vrednoscu "
			    + ((NumConst) cnst).getNumValue(), identConst);
			Obj obj = Tab.insert(Obj.Con, identConst.getName(), Tab.intType);
			obj.setAdr(((NumConst) cnst).getNumValue());
			System.out.println("ovo je adr " + obj.getAdr());
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
			report_error("Greska, dodeljena vrednost konstanti nije odgovarajuceg tipa ", identConst);
			return;
		}
	}

	public void visit(ConstDecl constDecl) {
		currentType = null;
	}

	public void visit(EnumDecl enumDecl) {
		Tab.closeScope();
		currentEnum.setLocals(sds);
		sds = null;
		currentEnum = null;
		report_info("Definisan je enum " + enumDecl.getEnumName().getEnumName(), enumDecl);
		currentType = null;
	}

	public void visit(EnumName enumName) {
		if (Tab.find(enumName.getEnumName()) != null && Tab.find(enumName.getEnumName()) != Tab.noObj) {
			report_error("Dvostruka definicija enuma " + enumName.getEnumName(), enumName);
			return;
		}
		currentEnum = Tab.insert(Obj.Type, enumName.getEnumName(), enumType);
		sds = new HashTableDataStructure();
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
		sds.insertKey(enumField);

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

	public void visit(ReturnExpressionE returnExpressionE) {
		if (currentMethod == null) {
			report_error("Sintaksna greska, return iskaz nije u metodi", returnExpressionE);
			return;
		}
		if (methodType == null) {
			report_error("Sintaksna greska, metoda nema povratnu vrednost", returnExpressionE);
			return;
		}
		if (returnExpressionE.getExpr().struct != methodType.struct) {
			report_error("Semanticka greska, povratna vrednost metode nije odgovarajuceg tipa", returnExpressionE);
			return;
		}
	}

	public void visit(NoReturnExpression noReturnExpression) {
		if (!"void".equals(methodType.getTypeName())) {
			report_error("Sintaksna greska, return iskaz nema povratnu vrednost", noReturnExpression);
		}
	}

	public void visit(Expr expr) {
		MaybeMinus mm = expr.getMaybeMinus();
		if (mm instanceof IsMinus) {
			if (expr.getTerm().struct != Tab.intType) {
				report_error("Greska, tip terma mora da bude int", expr);
				return;
			}
		}
		if (expr.getAddopTermList() instanceof AddopTermListRec) {
			Term term = expr.getTerm();
			Term term2 = ((AddopTermListRec) expr.getAddopTermList()).getTerm();
			if (term.struct != Tab.intType || term2.struct != Tab.intType) {
				report_error("Greska, Ne mogu se mnoziti term-ovi koji nisu tipa int", expr);
				return;
			}
			expr.struct = Tab.intType;
		} else {
			expr.struct = expr.getTerm().struct;
		}
	}

	public void visit(Term term) {
		if (term.getMulopFactorList() instanceof MulopFactorListRec) {
			Factor factor = term.getFactor();
			Factor factor2 = ((MulopFactorListRec) term.getMulopFactorList()).getFactor();
			if (factor.struct != Tab.intType || factor2.struct != Tab.intType) {
				report_error("Greska, Ne mogu se mnoziti faktori koji nisu tipa int", term);
				return;
			}
			term.struct = Tab.intType;
		} else {
			term.struct = term.getFactor().struct;
		}
	}

	public void visit(FactorNumber factorNumber) {
		factorNumber.struct = Tab.intType;
	}

	public void visit(FactorChar factorChar) {
		factorChar.struct = Tab.charType;
	}

	public void visit(FactorBool factorBool) {
		factorBool.struct = boolType;
	}

	public void visit(MethodDecl methodDecl) {
		numLocalVars += Tab.currentScope.getnVars();
		isGlobal = true;
		TypeOrVoid type = methodDecl.getMethodName().getTypeOrVoid();
		SomeType t = null;
		if (type instanceof SomeType) {
			t = (SomeType) type;
		}
		if (currentMethod.getName().equals("main")) {
			if (methodType.struct != Tab.noType) {
				report_error("Main metoda mora biti tipa void", methodDecl);
				return;
			} else if (hasArguments) {
				report_error("Main metoda ne sme da ima argumente", methodDecl);
				return;
			} else
				wasMain = true;
		}
		report_info("Definisana je metoda " + methodDecl.getMethodName().getMethodName() + " tipa "
		    + ((type instanceof VoidType) ? "void" : t.getType().getTypeName()), methodDecl);
		Tab.chainLocalSymbols(methodDecl.getMethodName().obj);
		Tab.closeScope();
		currentType = null;
		methodType = null;
		isVoid = false;
	}

	public void visit(MethodName methodName) {
		methodName.obj = Tab.insert(Obj.Meth, methodName.getMethodName(), methodType.struct);
		currentMethod = methodName.obj;
		Tab.openScope();
		isGlobal = false;
	}

	public void visit(SomeType someType) {
		isVoid = false;
		methodType = someType.getType();
		methodType.struct = someType.getType().struct;
	}

	public void visit(VoidType voidType) {
		isVoid = true;
		methodType = new Type("void");
		methodType.struct = Tab.noType;
	}

	public void visit(FormParams formParams) {
		hasArguments = true;
	}

	public void visit(NoFormParams noFormParams) {
		hasArguments = false;
	}

	public void visit(PrintStatement printStatement) {
		if (printStatement.getExpr().struct != Tab.intType && printStatement.getExpr().struct != boolType
		    && printStatement.getExpr().struct != Tab.charType) {
			report_error("Pogresan tip argumenta funkcije print, argumenti mogu biti samo int ili char tipa", printStatement);
		}
	}

	public void visit(ReadDesignatorStatement readDesignatorStatement) {
		if (readDesignatorStatement.getDesignator().obj == null
		    || readDesignatorStatement.getDesignator().obj == Tab.noObj) {
			report_error("Greska, argurment read funkcije mora biti promenljiva", readDesignatorStatement);
			return;
		}
		Struct type = readDesignatorStatement.getDesignator().obj.getType();
		if (type != Tab.intType || type != Tab.charType || type != boolType) {
			report_error("Greska, argument read funckije mora biti int, char ili bool tipa", readDesignatorStatement);
		}
	}

	public void visit(DesignatorStatement designatorStatement) {
		Obj designator = designatorStatement.getDesignator().obj;
		if (designator == null || designator == Tab.noObj) {
			report_error("Greska, promenljiva nije deklarisana", designatorStatement);
			return;
		}
		DesignatorStatementOp stmt = designatorStatement.getDesignatorStatementOp();
		if (stmt instanceof DesignatorExpr) {
			if (designatorStatement.getDesignator().obj.getType().getKind() != ((DesignatorExpr) stmt).getExpr().struct
			    .getKind()) {
				report_error("Greska, dodeljena vrednost nije istog tipa kao promenljiva", designatorStatement);
				return;
			}
		} else if (stmt instanceof DesignatorInc || stmt instanceof DesignatorDec) {
			if (designator.getType() != Tab.intType) {
				report_error("Greska, promenljiva mora biti int tipa da bi se mogla inkrementirati/dekrementirati",
				    designatorStatement);
				return;
			}
		}
		else {
			MaybeActualParams map = ((DesignatorParams) stmt).getMaybeActualParams();
			if (map instanceof ActualParams) {
				if (designator.getKind() != Obj.Meth) {
					report_error("Greska, " + designator.getName() + " nije funkcija", designatorStatement);
					return;
				}
				List<Struct> formalParams = new ArrayList<>();
				Collection<Obj> localSymbols = designator.getLocalSymbols();
				int numOfParams = designator.getLevel();
				int counter = 0;
				for (Obj obj:localSymbols) {
					if (counter < numOfParams) {
						formalParams.add(obj.getType());
						counter++;
					}
					else {
						break;
					}
				}
				if (formalParams.size() != actualParamsList.size()) {
					report_error("Greska, neodgovarajuci broj argumenata ", designatorStatement);
					return;
				}
				else {
					for (int i = 0; i < formalParams.size(); i++) {
						if (!formalParams.get(i).compatibleWith(actualParamsList.get(i))) {
							report_error("Greska, neodgovarajuci tip argumenta pri pozivu funkcije ", designatorStatement);
							return;
						}
					}
				}
				actualParamsList.clear();
			}
		}
	}

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
