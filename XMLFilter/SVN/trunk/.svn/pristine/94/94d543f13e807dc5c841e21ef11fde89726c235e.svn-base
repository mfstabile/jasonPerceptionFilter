package jasonide.xtext.mas2j.ui;

import java.util.HashSet;

import java.util.Set;

import org.eclipse.swt.graphics.RGB;

import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;
import static org.eclipse.swt.SWT.*;

public class Mas2jHighlightingConfiguration implements IHighlightingConfiguration {
	// provide an id string for the highlighting calculator
	public static final String COMMENT_SINGLE = "Comment (single line)"; //Orange
	public static final String COMMENT_MULTI = "Comment (multi line)"; //Dark orange
	public static final String STRING = "String"; //Pink
	public static final String NUMBER = "Number"; //Red
	public static final String SYMBOL = "Symbol"; //Blue (= : ; # { })
	public static final String RESERVED_WORD = "Reserved word"; //Purple
	public static final String KEYWORD = "Keyword"; //Blue
	public static final String PREDEFINED_PARAM = "Predefined param"; //Light purple

	public static final String[] ALL_STRINGS = { COMMENT_SINGLE , COMMENT_MULTI , STRING , NUMBER , SYMBOL , RESERVED_WORD , KEYWORD, PREDEFINED_PARAM };
	
	public static Set<String> ALL_KEYWORDS = new HashSet<String>();
	public static Set<String> ALL_SYMBOLS = new HashSet<String>();
	public static Set<String> ALL_RESERVED_WORDS = new HashSet<String>();
	public static Set<String> ALL_PREDEFINED_PARAMS = new HashSet<String>();
	
	{
		ALL_KEYWORDS.add("MAS");
		ALL_KEYWORDS.add("infrastructure");
		ALL_KEYWORDS.add("environment");
		ALL_KEYWORDS.add("executionControl");
		ALL_KEYWORDS.add("classpath");
		ALL_KEYWORDS.add("aslSourcePath");
		ALL_KEYWORDS.add("directives");
		ALL_KEYWORDS.add("agents");
		
		ALL_SYMBOLS.add("{");
		ALL_SYMBOLS.add("}");
		ALL_SYMBOLS.add(":");
		ALL_SYMBOLS.add(";");
		ALL_SYMBOLS.add("=");
		ALL_SYMBOLS.add("#");

		ALL_RESERVED_WORDS.add("at");
		ALL_RESERVED_WORDS.add("events");
		ALL_RESERVED_WORDS.add("discard");
		ALL_RESERVED_WORDS.add("requeue");
		ALL_RESERVED_WORDS.add("retrieve");
		ALL_RESERVED_WORDS.add("intBels");
		ALL_RESERVED_WORDS.add("sameFocus");
		ALL_RESERVED_WORDS.add("newFocus");
		ALL_RESERVED_WORDS.add("nrcbp");
		ALL_RESERVED_WORDS.add("verbose");
		ALL_RESERVED_WORDS.add("agentArchClass");
		ALL_RESERVED_WORDS.add("beliefBaseClass");
		ALL_RESERVED_WORDS.add("agentClass");
		
		ALL_PREDEFINED_PARAMS.add("Jade");
		//ALL_PREDEFINED_PARAMS.add("Saci");
		ALL_PREDEFINED_PARAMS.add("Centralised");
		ALL_PREDEFINED_PARAMS.add("JaCaMo");
	}
	
	@Override
	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		addType( acceptor, STRING, 255, 0, 204, NORMAL );
		addType( acceptor, COMMENT_SINGLE, 255, 132, 0, NORMAL );
		addType( acceptor, COMMENT_MULTI, 204, 0, 0, NORMAL );
		addType( acceptor, NUMBER, 255, 0, 0, NORMAL );
		addType( acceptor, SYMBOL, 0, 0, 255, NORMAL );
		addType( acceptor, RESERVED_WORD, 102, 0, 204, NORMAL );
		addType( acceptor, KEYWORD, 0, 0, 255, NORMAL );
		addType( acceptor, PREDEFINED_PARAM, 204, 0, 204, NORMAL );
	}
	
	public void addType( IHighlightingConfigurationAcceptor acceptor, String s, int r, int g, int b, int style) {
		TextStyle textStyle = new TextStyle();
		//textStyle.setBackgroundColor(new RGB(255, 255, 255));
		textStyle.setColor(new RGB(r, g, b));
		textStyle.setStyle(style);
		acceptor.acceptDefaultHighlighting(s, s, textStyle);
	}
}
