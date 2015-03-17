package jasonide.xtext.asl.ui;

import static org.eclipse.swt.SWT.NORMAL;
import static org.eclipse.swt.SWT.BOLD;


import java.util.HashSet;
import java.util.Set;

import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

public class AslHighlightingConfiguration implements IHighlightingConfiguration {
	// provide an id string for the highlighting calculator
	public static final String COMMENT_SINGLE = "Comment (single line)"; //Orange
	public static final String COMMENT_MULTI = "Comment (multi line)"; //Dark orange
	public static final String STRING = "String"; //Pink
	public static final String NUMBER = "Number"; //Red
	public static final String KEYWORD = "Keyword"; //Bold, Black
	public static final String SYMBOL = "Symbol"; //Blue
	public static final String RESERVED_WORD = "Reserved word"; //Blue
	
	public static final String INTERNAL_ACTION = "Internal action"; //.sa
	public static final String PLAN = "Plan"; //!lal
	public static final String PLAN_NAME = "Plan name"; //@ll
	public static final String BELIEF = "Belief"; //+lala -lala
	public static final String ATOM = "Atom"; //lala
	public static final String VARIABLE = "Variable"; //Lala
	
	public static final String MATH_OPERATOR = "Math operator"; //Lala
	
	public static final String[] ALL_STRINGS = { COMMENT_SINGLE , COMMENT_MULTI , STRING , NUMBER , KEYWORD, SYMBOL, RESERVED_WORD, INTERNAL_ACTION, PLAN, PLAN_NAME, BELIEF, ATOM, VARIABLE, MATH_OPERATOR };
	
	public static Set<String> ALL_KEYWORDS = new HashSet<String>();
	public static Set<String> ALL_SYMBOLS = new HashSet<String>();
	public static Set<String> ALL_RESERVED_WORDS = new HashSet<String>();
	public static Set<String> ALL_ANNOTATION_WORDS = new HashSet<String>();
	public static Set<String> ALL_MATH_OPERATORS = new HashSet<String>();
	
	{
		ALL_KEYWORDS.add("if");
		ALL_KEYWORDS.add("else");
		ALL_KEYWORDS.add("for");
		ALL_KEYWORDS.add("while");
		ALL_KEYWORDS.add("not");
		ALL_KEYWORDS.add("div");
		ALL_KEYWORDS.add("mod");
		ALL_KEYWORDS.add("begin");
		ALL_KEYWORDS.add("end");
		ALL_KEYWORDS.add("&");
		ALL_KEYWORDS.add("|");
		
		ALL_SYMBOLS.add(":");
		ALL_SYMBOLS.add(".");
		ALL_SYMBOLS.add("<-");
		ALL_SYMBOLS.add(":-");
		
		ALL_RESERVED_WORDS.add("true");
		ALL_RESERVED_WORDS.add("false");
		ALL_RESERVED_WORDS.add("tell");
		ALL_RESERVED_WORDS.add("untell");
		ALL_RESERVED_WORDS.add("achieve");
		ALL_RESERVED_WORDS.add("unachieve");
		ALL_RESERVED_WORDS.add("askOne");
		ALL_RESERVED_WORDS.add("askAll");
		ALL_RESERVED_WORDS.add("tellHow");
		ALL_RESERVED_WORDS.add("untellHow");
		ALL_RESERVED_WORDS.add("askHow");
		
		ALL_ANNOTATION_WORDS.add("source");
		ALL_ANNOTATION_WORDS.add("atomic");
		ALL_ANNOTATION_WORDS.add("breakpoint");
		ALL_ANNOTATION_WORDS.add("all_unifs");
		
		ALL_MATH_OPERATORS.add("+");
		ALL_MATH_OPERATORS.add("-");
		ALL_MATH_OPERATORS.add("*");
		ALL_MATH_OPERATORS.add("/");
		ALL_MATH_OPERATORS.add("**");
		ALL_MATH_OPERATORS.add("=");
		ALL_MATH_OPERATORS.add("<");
		ALL_MATH_OPERATORS.add("<=");
		ALL_MATH_OPERATORS.add(">");
		ALL_MATH_OPERATORS.add(">=");
		ALL_MATH_OPERATORS.add("==");
		ALL_MATH_OPERATORS.add("\\==");
		ALL_MATH_OPERATORS.add("=..");
	}
	
	@Override
	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		addType( acceptor, STRING, 255, 0, 204, NORMAL );
		addType( acceptor, COMMENT_SINGLE, 255, 132, 0, NORMAL );
		addType( acceptor, COMMENT_MULTI, 204, 0, 0, NORMAL );
		addType( acceptor, NUMBER, 255, 0, 0, NORMAL );
		addType( acceptor, KEYWORD, 0, 0, 0, BOLD );
		addType( acceptor, SYMBOL, 0, 102, 153, NORMAL );
		addType( acceptor, RESERVED_WORD, 204, 0, 204, NORMAL );
		
		addType( acceptor, INTERNAL_ACTION, 204, 102, 0, NORMAL );
		addType( acceptor, PLAN, 0, 0, 255, NORMAL );
		addType( acceptor, PLAN_NAME, 255, 0, 0, NORMAL );
		addType( acceptor, BELIEF, 2, 185, 2, NORMAL );
		addType( acceptor, ATOM, 102, 0, 204, NORMAL );
		addType( acceptor, VARIABLE, 153, 0, 204, NORMAL );
		
		addType( acceptor, MATH_OPERATOR, 0, 0, 0, NORMAL );
	}
	
	public void addType( IHighlightingConfigurationAcceptor acceptor, String s, int r, int g, int b, int style) {
		TextStyle textStyle = new TextStyle();
		//textStyle.setBackgroundColor(new RGB(255, 255, 255));
		textStyle.setColor(new RGB(r, g, b));
		textStyle.setStyle(style);
		acceptor.acceptDefaultHighlighting(s, s, textStyle);
	}
}
