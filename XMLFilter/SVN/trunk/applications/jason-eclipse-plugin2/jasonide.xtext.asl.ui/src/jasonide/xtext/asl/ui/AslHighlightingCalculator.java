package jasonide.xtext.asl.ui;

import java.util.Iterator;


import jasonide.xtext.asl.asl.Arithm_expr;
import jasonide.xtext.asl.asl.Arithm_expr_simple;
import jasonide.xtext.asl.asl.Belief;
import jasonide.xtext.asl.asl.Body_formula;
import jasonide.xtext.asl.asl.Directive;
import jasonide.xtext.asl.asl.Initial_goal;
import jasonide.xtext.asl.asl.Pred;
import jasonide.xtext.asl.asl.Number;
import jasonide.xtext.asl.asl.Rel_expr;
import jasonide.xtext.asl.asl.Trigger;

import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.nodemodel.BidiIterator;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.CompositeNodeWithSemanticElement;
import org.eclipse.xtext.nodemodel.impl.HiddenLeafNode;
import org.eclipse.xtext.nodemodel.impl.LeafNode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;

import static jasonide.xtext.asl.ui.AslHighlightingConfiguration.*;

public class AslHighlightingCalculator implements ISemanticHighlightingCalculator {
	private static final int STATUS_BEGIN_PLAN = 1;
	private static final int STATUS_BEGIN_BELIEF = 2;
	private static final int STATUS_BEGIN_PLAN_NAME = 3;
	private static final int STATUS_BEGIN_INTERNAL_ACTION = 4;
	private static final int STATUS_BEGIN_CONDITION = 5;
	private static final int STATUS_BEGIN_BELIEF_DECLARATION = 6;
	private static final int STATUS_BEGIN_DIRECTIVE_DECLARATION = 7;
	
	@Override
	public void provideHighlightingFor(XtextResource resource,
			IHighlightedPositionAcceptor acceptor) {
		
		if ( resource == null || resource.getParseResult() == null ) return;
		
		INode root = resource.getParseResult().getRootNode();
		BidiTreeIterator<INode> it = root.getAsTreeIterable().iterator();
		
		int status = 0;
		int openedParentheses = 0;
		int openedSquareBrackets = 0;
		
		while (it.hasNext()) {
			INode node = it.next();
			if (node == null) continue;
			
			//if (node.getParent() != null)
				//System.out.println("" + node.getOffset() + " " + node.getLength() + node.toString() + " ## " + node.getGrammarElement().toString() + " ## " + node.getSemanticElement().toString() + " -- " + node.getParent().getSemanticElement().toString() + " &&& " + node.getRootNode().getSemanticElement().toString() + " -> " + status + " " + node.getNextSibling());
				//System.out.println(node.getSemanticElement().toString());
			
			if (node instanceof HiddenLeafNode && node.getGrammarElement() instanceof TerminalRule) {
				TerminalRule ge = (TerminalRule) node.getGrammarElement();
				
				if (ge.getName().equalsIgnoreCase("SL_COMMENT"))
					setStyle(acceptor, node, COMMENT_SINGLE);
					
				if (ge.getName().equalsIgnoreCase("ML_COMMENT"))
					setStyle(acceptor, node, COMMENT_MULTI);
			} else if (node.getGrammarElement() != null && node.getGrammarElement() instanceof Keyword) {
				Keyword k = (Keyword) node.getGrammarElement();
				
				if (ALL_KEYWORDS.contains(k.getValue())) {
					if (k.getValue().equals("begin") || k.getValue().equals("end")) {
						if (status == STATUS_BEGIN_DIRECTIVE_DECLARATION)
							setStyle( acceptor, node, BELIEF);
					} else {
						setStyle( acceptor, node, KEYWORD);
					}
				} else if (ALL_SYMBOLS.contains(k.getValue())) {
					
					if (k.getValue().equals(".") && node.getSemanticElement() instanceof Pred && !((Pred) node.getSemanticElement()).getAtom().contains(" ") && !((Pred) node.getSemanticElement()).getAtom().contains("\t") && !((Pred) node.getSemanticElement()).getAtom().contains("\r") && !((Pred) node.getSemanticElement()).getAtom().contains("\n")) {
					//if (k.getValue().equals(".") && node.getSemanticElement() instanceof Pred && !(node.getNextSibling() instanceof HiddenLeafNode)) {
						setStyle( acceptor, node, INTERNAL_ACTION);
					} else if (k.getValue().equals(".") && (node.getSemanticElement() instanceof Number || node.getSemanticElement() instanceof Rel_expr)) {
						setStyle( acceptor, node, MATH_OPERATOR);
					} else {
						setStyle( acceptor, node, SYMBOL);
					}
					
					if (k.getValue().equals(":")) {
						status = STATUS_BEGIN_CONDITION;
					} else if (k.getValue().equals("<-")) {
						status = 0;
					} else if (k.getValue().equals(".") && node.getSemanticElement() instanceof Belief && status == STATUS_BEGIN_BELIEF_DECLARATION) {
						status = 0;
					}
					
				} else if (ALL_RESERVED_WORDS.contains(k.getValue())) {
					setStyle( acceptor, node, RESERVED_WORD);
				} else if ((k.getValue().equals("+") || k.getValue().equals("-") || k.getValue().equals("<") || k.getValue().equals(">")) && status == STATUS_BEGIN_BELIEF) {
					setStyle( acceptor, node, BELIEF);
				} else if (k.getValue().equals("(")) {
					openedParentheses++;
				} else if (k.getValue().equals(")")) {
					openedParentheses--;
				} else if (k.getValue().equals("[")) {
					openedSquareBrackets++;
				} else if (k.getValue().equals("]")) {
					openedSquareBrackets--;
				} else if (ALL_MATH_OPERATORS.contains(k.getValue()) && !(node.getSemanticElement() instanceof Trigger)) {
					setStyle( acceptor, node, MATH_OPERATOR);
				} else {
					//System.out.println("" + node.getOffset() + " " + node.getLength() + node.toString() + " ## " + node.getGrammarElement().toString() + " ## " + node.getSemanticElement().toString() + " " + status);
				}
			} else if (node instanceof CompositeNodeWithSemanticElement && node.getSemanticElement() instanceof Trigger) {
				CompositeNodeWithSemanticElement comp = (CompositeNodeWithSemanticElement) node;

				Iterator<ILeafNode> itComp = comp.getLeafNodes().iterator();
				boolean plan = false;
				boolean directive = false;
				
				if (openedParentheses == 0 && openedSquareBrackets == 0) {
					while (itComp.hasNext()) {
						INode nodeComp = itComp.next();
						
						if (nodeComp.getGrammarElement() instanceof Keyword) {
							if (((Keyword) nodeComp.getGrammarElement()).getValue().equals("!") || ((Keyword) nodeComp.getGrammarElement()).getValue().equals("?")) {
								plan = true;
								break;
							} else if (((Keyword) nodeComp.getGrammarElement()).getValue().equals("{") || ((Keyword) nodeComp.getGrammarElement()).getValue().equals("(") || ((Keyword) nodeComp.getGrammarElement()).getValue().equals("[")) {
								directive = true;
							}
						} else if (nodeComp.getGrammarElement() instanceof RuleCall && ((RuleCall) nodeComp.getGrammarElement()).getRule().getName().equals("ATOM")) {
							break;
						}
					}
				} else {
					directive = true;
				}
				
				if (plan && !directive) {
					status = STATUS_BEGIN_PLAN;
					setStyles(acceptor, it, PLAN, PLAN);
				} else if (!directive) {
					status = STATUS_BEGIN_BELIEF;
					setStyles(acceptor, it, BELIEF);
				}

				//setStyle( acceptor, node, PLAN);
			} else if (node instanceof CompositeNodeWithSemanticElement && node.getSemanticElement() instanceof Initial_goal) {	
				status = STATUS_BEGIN_PLAN;
				setStyles(acceptor, it, PLAN);
			} else if (node instanceof CompositeNodeWithSemanticElement && node.getSemanticElement() instanceof Belief) {	
				status = STATUS_BEGIN_BELIEF_DECLARATION;
			} else if (node instanceof CompositeNodeWithSemanticElement && node.getSemanticElement() instanceof Directive) {	
				status = STATUS_BEGIN_DIRECTIVE_DECLARATION;
			} else if (node instanceof CompositeNodeWithSemanticElement && node.getSemanticElement() instanceof Body_formula) {
				CompositeNodeWithSemanticElement comp = (CompositeNodeWithSemanticElement) node;
				
				Iterator<ILeafNode> itComp = comp.getLeafNodes().iterator();
				boolean plan = false;
				boolean belief = false;
				
				if (openedParentheses == 0 && openedSquareBrackets == 0) {
					while (itComp.hasNext()) {
						INode nodeComp = itComp.next();
						
						if (nodeComp.getGrammarElement() instanceof Keyword) {
							if (((Keyword) nodeComp.getGrammarElement()).getValue().equals("!") || ((Keyword) nodeComp.getGrammarElement()).getValue().equals("?") || ((Keyword) nodeComp.getGrammarElement()).getValue().equals("!!")) {
								plan = true;
								break;
							} else if (!(nodeComp.getSemanticElement() instanceof Arithm_expr || nodeComp.getSemanticElement() instanceof Arithm_expr_simple) && (((Keyword) nodeComp.getGrammarElement()).getValue().equals("-") || ((Keyword) nodeComp.getGrammarElement()).getValue().equals("+"))) {
								belief = true;
								break;
							} else if ((((Keyword) nodeComp.getGrammarElement()).getValue().equals("{")) || (((Keyword) nodeComp.getGrammarElement()).getValue().equals("(")) || (((Keyword) nodeComp.getGrammarElement()).getValue().equals("["))) {
								break;
							}
						}
					}
				}
				
				if (plan) {
					status = STATUS_BEGIN_PLAN;
					setStyles(acceptor, it, PLAN);
				} else if (belief) {
					status = STATUS_BEGIN_BELIEF;
					setStyles(acceptor, it, BELIEF);
				} else {
					status = STATUS_BEGIN_INTERNAL_ACTION;
				}
			} else if (node instanceof LeafNode && node.getSemanticElement() != null) {
				boolean painted = false;
				if (node.getSemanticElement() instanceof Pred && openedSquareBrackets > 0 && ((Pred) node.getSemanticElement()).getAtom() != null && ALL_ANNOTATION_WORDS.contains(((Pred) node.getSemanticElement()).getAtom())) {
					setStyle( acceptor, node, RESERVED_WORD);
					painted = true;
				} else if (node.getSemanticElement() instanceof Pred && (openedSquareBrackets > 0 || openedParentheses > 0)  && ((Pred) node.getSemanticElement()).getAtom() != null && ALL_RESERVED_WORDS.contains(((Pred) node.getSemanticElement()).getAtom())) {
					setStyle( acceptor, node, RESERVED_WORD);
					painted = true;
				} else if (node.getSemanticElement() instanceof Pred && ((Pred) node.getSemanticElement()).getAtom() != null && ((Pred) node.getSemanticElement()).getAtom().contains(".") && !((Pred) node.getSemanticElement()).getAtom().contains(" ") && !((Pred) node.getSemanticElement()).getAtom().contains("\t") && !((Pred) node.getSemanticElement()).getAtom().contains("\r") && !((Pred) node.getSemanticElement()).getAtom().contains("\n")) {
				//} else if (node.getSemanticElement() instanceof Pred && ((Pred) node.getSemanticElement()).getAtom() != null && ((Pred) node.getSemanticElement()).getAtom().contains(".") && !(node.getNextSibling() instanceof HiddenLeafNode)) {
					
					//System.out.println("" + node.getOffset() + " " + node.getLength() + node.toString() + " ## " + node.getGrammarElement().toString() + " ## " + node.getSemanticElement().toString() + " -- " + node.getParent().getSemanticElement().toString() + " &&& " + node.getRootNode().getSemanticElement().toString() + " -> " + status + " " + node.getNextSibling());
					
					setStyle( acceptor, node, INTERNAL_ACTION);
					painted = true;
				}
				
				if (node.getGrammarElement() != null && !painted) {
					if (node.getGrammarElement() instanceof RuleCall) {
						RuleCall rc = (RuleCall) node.getGrammarElement();
						
						//System.out.println("" + node.getOffset() + " " + node.getLength() + node.toString() + " ## " + node.getGrammarElement().toString() + " ## " + node.getSemanticElement().toString() + " // " + rc.getRule().getName() + " -> " + status);
						
						if (rc.getRule().getName().equals("STRINGT")) {
							setStyle( acceptor, node, STRING);
						} else if (rc.getRule().getName().equals("NUMBERT") || rc.getRule().getName().equals("EXPONENT")) {
							setStyle( acceptor, node, NUMBER);
						} else if (rc.getRule().getName().equals("VART")) {
							setStyle( acceptor, node, VARIABLE);
							if (status != STATUS_BEGIN_CONDITION && status != STATUS_BEGIN_BELIEF_DECLARATION && status != STATUS_BEGIN_INTERNAL_ACTION && status != STATUS_BEGIN_DIRECTIVE_DECLARATION)
								status = 0;
						} else if (rc.getRule().getName().equals("ATOM") && openedParentheses > 0) {
							setStyle( acceptor, node, ATOM);
						} else if (rc.getRule().getName().equals("TK_NEG") && openedParentheses > 0) {
							setStyle( acceptor, node, ATOM);
						} else if (rc.getRule().getName().equals("ATOM") && openedSquareBrackets > 0) {
							setStyle( acceptor, node, ATOM);
						} else if (rc.getRule().getName().equals("TK_NEG") && openedSquareBrackets > 0) {
							setStyle( acceptor, node, ATOM);
						} else if (rc.getRule().getName().equals("ATOM") && status == STATUS_BEGIN_PLAN) {
							setStyle( acceptor, node, PLAN);
							status = 0;
						} else if (rc.getRule().getName().equals("TK_LABEL_AT")) {
							setStyle(acceptor, node, PLAN_NAME);
							status = STATUS_BEGIN_PLAN_NAME;
						} else if (rc.getRule().getName().equals("ATOM") && status == STATUS_BEGIN_PLAN_NAME) {
							setStyle( acceptor, node, PLAN_NAME);
							status = 0;
						} else if (rc.getRule().getName().equals("TK_NEG") && status == STATUS_BEGIN_PLAN) {
							setStyle( acceptor, node, PLAN);
						} else if (rc.getRule().getName().equals("ATOM") && status == STATUS_BEGIN_BELIEF) {
							setStyle( acceptor, node, BELIEF);
							status = 0;
						} else if (rc.getRule().getName().equals("TK_NEG") && status == STATUS_BEGIN_BELIEF) {
							setStyle( acceptor, node, BELIEF);
						} else if (rc.getRule().getName().equals("TK_NEG") && status == STATUS_BEGIN_BELIEF_DECLARATION) {
							setStyle( acceptor, node, BELIEF);
						} else if (rc.getRule().getName().equals("ATOM") && status == STATUS_BEGIN_INTERNAL_ACTION) {
							setStyle( acceptor, node, INTERNAL_ACTION);
							status = 0;
						} else if (rc.getRule().getName().equals("ATOM") && status == STATUS_BEGIN_CONDITION) {
							setStyle( acceptor, node, BELIEF);
						} else if (rc.getRule().getName().equals("TK_NEG") && status == STATUS_BEGIN_CONDITION) {
							setStyle( acceptor, node, BELIEF);
						} else if (rc.getRule().getName().equals("ATOM") && status == STATUS_BEGIN_BELIEF_DECLARATION) {
							setStyle( acceptor, node, BELIEF);
						} else if (rc.getRule().getName().equals("TK_NEG") && status == STATUS_BEGIN_DIRECTIVE_DECLARATION) {
							setStyle( acceptor, node, BELIEF);
						} else if (rc.getRule().getName().equals("ATOM") && status == STATUS_BEGIN_DIRECTIVE_DECLARATION) {
							setStyle( acceptor, node, BELIEF);
						} else {
							//System.out.println("" + node.getOffset() + " " + node.getLength() + node.toString() + " ## " + node.getGrammarElement().toString() + " ## " + node.getSemanticElement().toString() + " // " + rc.getRule().getName());
						}
					}
				}
			}
		}
		
	}
	
	
	private void setStyle(IHighlightedPositionAcceptor acceptor, INode n, String style) {
		if (n != null) {
			acceptor.addPosition( n.getOffset(), n.getLength(), style );
		}
	}

	private void setStyles( IHighlightedPositionAcceptor acceptor, BidiIterator<INode> it, String...styles )
	{
		for( String s : styles )
		{
			if( !it.hasNext() ) return;
			INode n = skipWhiteSpace( acceptor, it );
			if( n != null && s != null ) acceptor.addPosition( n.getOffset(), n.getLength(), s );
		}
	}
 
	private INode skipWhiteSpace( IHighlightedPositionAcceptor acceptor, BidiIterator<INode> it )
	{
		INode n = null;
		
		while ( it.hasNext() && ( n = it.next() ).getClass() == HiddenLeafNode.class )
			processHiddenNode( acceptor, (HiddenLeafNode)n );
		return n;
	}
 
	private void processHiddenNode( IHighlightedPositionAcceptor acceptor, HiddenLeafNode node )
	{
		if( node.getGrammarElement() instanceof TerminalRule )
		{
			TerminalRule ge = (TerminalRule) node.getGrammarElement();
			
			if (ge.getName().equalsIgnoreCase("SL_COMMENT"))
				setStyle(acceptor, node, COMMENT_SINGLE);
				
			if (ge.getName().equalsIgnoreCase("ML_COMMENT"))
				setStyle(acceptor, node, COMMENT_MULTI);
		}
	}
}
