package jasonide.xtext.asl.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import jasonide.xtext.asl.services.AslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalAslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_TK_LABEL_AT", "RULE_TK_NEG", "RULE_VART", "RULE_UNNAMEDVART", "RULE_STRINGT", "RULE_NUMBERT", "RULE_ATOM", "RULE_LCLETTER", "RULE_CH", "RULE_UCLETTER", "RULE_DIGIT", "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "'{'", "'}'", "':-'", "'.'", "'!'", "':'", "'<-'", "'+'", "'-'", "'^'", "'?'", "';'", "'('", "')'", "'!!'", "','", "'['", "'|'", "']'", "'&'", "'<'", "'<='", "'>'", "'>='", "'=='", "'\\\\=='", "'='", "'*'", "'/'", "'**'", "'begin'", "'end'", "'if'", "'else'", "'for'", "'while'", "'not'", "'div'", "'mod'", "'true'", "'false'"
    };
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_TK_LABEL_AT=4;
    public static final int RULE_ATOM=10;
    public static final int RULE_NUMBERT=9;
    public static final int EOF=-1;
    public static final int RULE_STRINGT=8;
    public static final int T__55=55;
    public static final int T__19=19;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__18=18;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int RULE_CH=12;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int RULE_VART=6;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_TK_NEG=5;
    public static final int RULE_SL_COMMENT=17;
    public static final int RULE_ML_COMMENT=16;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int RULE_LCLETTER=11;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_UCLETTER=13;
    public static final int RULE_UNNAMEDVART=7;
    public static final int RULE_WS=15;
    public static final int RULE_DIGIT=14;

    // delegates
    // delegators


        public InternalAslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalAslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[192+1];
             
             
        }
        

    public String[] getTokenNames() { return InternalAslParser.tokenNames; }
    public String getGrammarFileName() { return "../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     
     	private AslGrammarAccess grammarAccess;
     	
        public InternalAslParser(TokenStream input, AslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Agent";	
       	}
       	
       	@Override
       	protected AslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleAgent"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:74:1: entryRuleAgent returns [EObject current=null] : iv_ruleAgent= ruleAgent EOF ;
    public final EObject entryRuleAgent() throws RecognitionException {
        EObject current = null;
        int entryRuleAgent_StartIndex = input.index();
        EObject iv_ruleAgent = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:75:2: (iv_ruleAgent= ruleAgent EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:76:2: iv_ruleAgent= ruleAgent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAgentRule()); 
            }
            pushFollow(FOLLOW_ruleAgent_in_entryRuleAgent88);
            iv_ruleAgent=ruleAgent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAgent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAgent98); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 1, entryRuleAgent_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleAgent"


    // $ANTLR start "ruleAgent"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:83:1: ruleAgent returns [EObject current=null] : ( ( (lv_directive_0_0= ruleDirective ) )* ( ( (lv_belief_1_0= ruleBelief ) ) ( (lv_directive_2_0= ruleDirective ) )* )* ( ( (lv_initial_goal_3_0= ruleInitial_goal ) ) ( (lv_directive_4_0= ruleDirective ) )* )* ( ( (lv_plan_5_0= rulePlan ) ) ( (lv_belief_6_0= ruleBelief ) )* ( (lv_directive_7_0= ruleDirective ) )* )* ) ;
    public final EObject ruleAgent() throws RecognitionException {
        EObject current = null;
        int ruleAgent_StartIndex = input.index();
        EObject lv_directive_0_0 = null;

        EObject lv_belief_1_0 = null;

        EObject lv_directive_2_0 = null;

        EObject lv_initial_goal_3_0 = null;

        EObject lv_directive_4_0 = null;

        EObject lv_plan_5_0 = null;

        EObject lv_belief_6_0 = null;

        EObject lv_directive_7_0 = null;


         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:86:28: ( ( ( (lv_directive_0_0= ruleDirective ) )* ( ( (lv_belief_1_0= ruleBelief ) ) ( (lv_directive_2_0= ruleDirective ) )* )* ( ( (lv_initial_goal_3_0= ruleInitial_goal ) ) ( (lv_directive_4_0= ruleDirective ) )* )* ( ( (lv_plan_5_0= rulePlan ) ) ( (lv_belief_6_0= ruleBelief ) )* ( (lv_directive_7_0= ruleDirective ) )* )* ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:87:1: ( ( (lv_directive_0_0= ruleDirective ) )* ( ( (lv_belief_1_0= ruleBelief ) ) ( (lv_directive_2_0= ruleDirective ) )* )* ( ( (lv_initial_goal_3_0= ruleInitial_goal ) ) ( (lv_directive_4_0= ruleDirective ) )* )* ( ( (lv_plan_5_0= rulePlan ) ) ( (lv_belief_6_0= ruleBelief ) )* ( (lv_directive_7_0= ruleDirective ) )* )* )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:87:1: ( ( (lv_directive_0_0= ruleDirective ) )* ( ( (lv_belief_1_0= ruleBelief ) ) ( (lv_directive_2_0= ruleDirective ) )* )* ( ( (lv_initial_goal_3_0= ruleInitial_goal ) ) ( (lv_directive_4_0= ruleDirective ) )* )* ( ( (lv_plan_5_0= rulePlan ) ) ( (lv_belief_6_0= ruleBelief ) )* ( (lv_directive_7_0= ruleDirective ) )* )* )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:87:2: ( (lv_directive_0_0= ruleDirective ) )* ( ( (lv_belief_1_0= ruleBelief ) ) ( (lv_directive_2_0= ruleDirective ) )* )* ( ( (lv_initial_goal_3_0= ruleInitial_goal ) ) ( (lv_directive_4_0= ruleDirective ) )* )* ( ( (lv_plan_5_0= rulePlan ) ) ( (lv_belief_6_0= ruleBelief ) )* ( (lv_directive_7_0= ruleDirective ) )* )*
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:87:2: ( (lv_directive_0_0= ruleDirective ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==18) ) {
                    int LA1_2 = input.LA(2);

                    if ( (synpred1_InternalAsl()) ) {
                        alt1=1;
                    }


                }


                switch (alt1) {
            	case 1 :
            	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:88:1: (lv_directive_0_0= ruleDirective )
            	    {
            	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:88:1: (lv_directive_0_0= ruleDirective )
            	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:89:3: lv_directive_0_0= ruleDirective
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAgentAccess().getDirectiveDirectiveParserRuleCall_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleDirective_in_ruleAgent144);
            	    lv_directive_0_0=ruleDirective();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAgentRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"directive",
            	              		lv_directive_0_0, 
            	              		"Directive");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:105:3: ( ( (lv_belief_1_0= ruleBelief ) ) ( (lv_directive_2_0= ruleDirective ) )* )*
            loop3:
            do {
                int alt3=2;
                alt3 = dfa3.predict(input);
                switch (alt3) {
            	case 1 :
            	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:105:4: ( (lv_belief_1_0= ruleBelief ) ) ( (lv_directive_2_0= ruleDirective ) )*
            	    {
            	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:105:4: ( (lv_belief_1_0= ruleBelief ) )
            	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:106:1: (lv_belief_1_0= ruleBelief )
            	    {
            	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:106:1: (lv_belief_1_0= ruleBelief )
            	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:107:3: lv_belief_1_0= ruleBelief
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAgentAccess().getBeliefBeliefParserRuleCall_1_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleBelief_in_ruleAgent167);
            	    lv_belief_1_0=ruleBelief();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAgentRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"belief",
            	              		lv_belief_1_0, 
            	              		"Belief");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:123:2: ( (lv_directive_2_0= ruleDirective ) )*
            	    loop2:
            	    do {
            	        int alt2=2;
            	        int LA2_0 = input.LA(1);

            	        if ( (LA2_0==18) ) {
            	            int LA2_2 = input.LA(2);

            	            if ( (synpred2_InternalAsl()) ) {
            	                alt2=1;
            	            }


            	        }


            	        switch (alt2) {
            	    	case 1 :
            	    	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:124:1: (lv_directive_2_0= ruleDirective )
            	    	    {
            	    	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:124:1: (lv_directive_2_0= ruleDirective )
            	    	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:125:3: lv_directive_2_0= ruleDirective
            	    	    {
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	      	        newCompositeNode(grammarAccess.getAgentAccess().getDirectiveDirectiveParserRuleCall_1_1_0()); 
            	    	      	    
            	    	    }
            	    	    pushFollow(FOLLOW_ruleDirective_in_ruleAgent188);
            	    	    lv_directive_2_0=ruleDirective();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      	        if (current==null) {
            	    	      	            current = createModelElementForParent(grammarAccess.getAgentRule());
            	    	      	        }
            	    	             		add(
            	    	             			current, 
            	    	             			"directive",
            	    	              		lv_directive_2_0, 
            	    	              		"Directive");
            	    	      	        afterParserOrEnumRuleCall();
            	    	      	    
            	    	    }

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop2;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:141:5: ( ( (lv_initial_goal_3_0= ruleInitial_goal ) ) ( (lv_directive_4_0= ruleDirective ) )* )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==22) ) {
                    int LA5_2 = input.LA(2);

                    if ( (synpred5_InternalAsl()) ) {
                        alt5=1;
                    }


                }


                switch (alt5) {
            	case 1 :
            	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:141:6: ( (lv_initial_goal_3_0= ruleInitial_goal ) ) ( (lv_directive_4_0= ruleDirective ) )*
            	    {
            	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:141:6: ( (lv_initial_goal_3_0= ruleInitial_goal ) )
            	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:142:1: (lv_initial_goal_3_0= ruleInitial_goal )
            	    {
            	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:142:1: (lv_initial_goal_3_0= ruleInitial_goal )
            	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:143:3: lv_initial_goal_3_0= ruleInitial_goal
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAgentAccess().getInitial_goalInitial_goalParserRuleCall_2_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleInitial_goal_in_ruleAgent213);
            	    lv_initial_goal_3_0=ruleInitial_goal();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAgentRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"initial_goal",
            	              		lv_initial_goal_3_0, 
            	              		"Initial_goal");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:159:2: ( (lv_directive_4_0= ruleDirective ) )*
            	    loop4:
            	    do {
            	        int alt4=2;
            	        int LA4_0 = input.LA(1);

            	        if ( (LA4_0==18) ) {
            	            int LA4_2 = input.LA(2);

            	            if ( (synpred4_InternalAsl()) ) {
            	                alt4=1;
            	            }


            	        }


            	        switch (alt4) {
            	    	case 1 :
            	    	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:160:1: (lv_directive_4_0= ruleDirective )
            	    	    {
            	    	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:160:1: (lv_directive_4_0= ruleDirective )
            	    	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:161:3: lv_directive_4_0= ruleDirective
            	    	    {
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	      	        newCompositeNode(grammarAccess.getAgentAccess().getDirectiveDirectiveParserRuleCall_2_1_0()); 
            	    	      	    
            	    	    }
            	    	    pushFollow(FOLLOW_ruleDirective_in_ruleAgent234);
            	    	    lv_directive_4_0=ruleDirective();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      	        if (current==null) {
            	    	      	            current = createModelElementForParent(grammarAccess.getAgentRule());
            	    	      	        }
            	    	             		add(
            	    	             			current, 
            	    	             			"directive",
            	    	              		lv_directive_4_0, 
            	    	              		"Directive");
            	    	      	        afterParserOrEnumRuleCall();
            	    	      	    
            	    	    }

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop4;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:177:5: ( ( (lv_plan_5_0= rulePlan ) ) ( (lv_belief_6_0= ruleBelief ) )* ( (lv_directive_7_0= ruleDirective ) )* )*
            loop8:
            do {
                int alt8=2;
                switch ( input.LA(1) ) {
                case RULE_TK_LABEL_AT:
                    {
                    int LA8_2 = input.LA(2);

                    if ( (synpred8_InternalAsl()) ) {
                        alt8=1;
                    }


                    }
                    break;
                case 25:
                    {
                    int LA8_3 = input.LA(2);

                    if ( (synpred8_InternalAsl()) ) {
                        alt8=1;
                    }


                    }
                    break;
                case 26:
                    {
                    int LA8_4 = input.LA(2);

                    if ( (synpred8_InternalAsl()) ) {
                        alt8=1;
                    }


                    }
                    break;
                case 27:
                    {
                    int LA8_5 = input.LA(2);

                    if ( (synpred8_InternalAsl()) ) {
                        alt8=1;
                    }


                    }
                    break;

                }

                switch (alt8) {
            	case 1 :
            	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:177:6: ( (lv_plan_5_0= rulePlan ) ) ( (lv_belief_6_0= ruleBelief ) )* ( (lv_directive_7_0= ruleDirective ) )*
            	    {
            	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:177:6: ( (lv_plan_5_0= rulePlan ) )
            	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:178:1: (lv_plan_5_0= rulePlan )
            	    {
            	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:178:1: (lv_plan_5_0= rulePlan )
            	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:179:3: lv_plan_5_0= rulePlan
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAgentAccess().getPlanPlanParserRuleCall_3_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulePlan_in_ruleAgent259);
            	    lv_plan_5_0=rulePlan();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAgentRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"plan",
            	              		lv_plan_5_0, 
            	              		"Plan");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:195:2: ( (lv_belief_6_0= ruleBelief ) )*
            	    loop6:
            	    do {
            	        int alt6=2;
            	        alt6 = dfa6.predict(input);
            	        switch (alt6) {
            	    	case 1 :
            	    	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:196:1: (lv_belief_6_0= ruleBelief )
            	    	    {
            	    	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:196:1: (lv_belief_6_0= ruleBelief )
            	    	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:197:3: lv_belief_6_0= ruleBelief
            	    	    {
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	      	        newCompositeNode(grammarAccess.getAgentAccess().getBeliefBeliefParserRuleCall_3_1_0()); 
            	    	      	    
            	    	    }
            	    	    pushFollow(FOLLOW_ruleBelief_in_ruleAgent280);
            	    	    lv_belief_6_0=ruleBelief();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      	        if (current==null) {
            	    	      	            current = createModelElementForParent(grammarAccess.getAgentRule());
            	    	      	        }
            	    	             		add(
            	    	             			current, 
            	    	             			"belief",
            	    	              		lv_belief_6_0, 
            	    	              		"Belief");
            	    	      	        afterParserOrEnumRuleCall();
            	    	      	    
            	    	    }

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop6;
            	        }
            	    } while (true);

            	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:213:3: ( (lv_directive_7_0= ruleDirective ) )*
            	    loop7:
            	    do {
            	        int alt7=2;
            	        int LA7_0 = input.LA(1);

            	        if ( (LA7_0==18) ) {
            	            int LA7_2 = input.LA(2);

            	            if ( (synpred7_InternalAsl()) ) {
            	                alt7=1;
            	            }


            	        }


            	        switch (alt7) {
            	    	case 1 :
            	    	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:214:1: (lv_directive_7_0= ruleDirective )
            	    	    {
            	    	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:214:1: (lv_directive_7_0= ruleDirective )
            	    	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:215:3: lv_directive_7_0= ruleDirective
            	    	    {
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	      	        newCompositeNode(grammarAccess.getAgentAccess().getDirectiveDirectiveParserRuleCall_3_2_0()); 
            	    	      	    
            	    	    }
            	    	    pushFollow(FOLLOW_ruleDirective_in_ruleAgent302);
            	    	    lv_directive_7_0=ruleDirective();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      	        if (current==null) {
            	    	      	            current = createModelElementForParent(grammarAccess.getAgentRule());
            	    	      	        }
            	    	             		add(
            	    	             			current, 
            	    	             			"directive",
            	    	              		lv_directive_7_0, 
            	    	              		"Directive");
            	    	      	        afterParserOrEnumRuleCall();
            	    	      	    
            	    	    }

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop7;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 2, ruleAgent_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleAgent"


    // $ANTLR start "entryRuleDirective"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:239:1: entryRuleDirective returns [EObject current=null] : iv_ruleDirective= ruleDirective EOF ;
    public final EObject entryRuleDirective() throws RecognitionException {
        EObject current = null;
        int entryRuleDirective_StartIndex = input.index();
        EObject iv_ruleDirective = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:240:2: (iv_ruleDirective= ruleDirective EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:241:2: iv_ruleDirective= ruleDirective EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDirectiveRule()); 
            }
            pushFollow(FOLLOW_ruleDirective_in_entryRuleDirective341);
            iv_ruleDirective=ruleDirective();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDirective; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDirective351); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 3, entryRuleDirective_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleDirective"


    // $ANTLR start "ruleDirective"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:248:1: ruleDirective returns [EObject current=null] : (otherlv_0= '{' ( ( ( (lv_tk_begin_1_0= ruleTK_BEGIN ) ) ( (lv_pred_2_0= rulePred ) ) otherlv_3= '}' ( (lv_agent_4_0= ruleAgent ) ) ) | ( ( (lv_pred2_5_0= rulePred ) ) otherlv_6= '}' ) ) ) ;
    public final EObject ruleDirective() throws RecognitionException {
        EObject current = null;
        int ruleDirective_StartIndex = input.index();
        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_tk_begin_1_0 = null;

        EObject lv_pred_2_0 = null;

        EObject lv_agent_4_0 = null;

        EObject lv_pred2_5_0 = null;


         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:251:28: ( (otherlv_0= '{' ( ( ( (lv_tk_begin_1_0= ruleTK_BEGIN ) ) ( (lv_pred_2_0= rulePred ) ) otherlv_3= '}' ( (lv_agent_4_0= ruleAgent ) ) ) | ( ( (lv_pred2_5_0= rulePred ) ) otherlv_6= '}' ) ) ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:252:1: (otherlv_0= '{' ( ( ( (lv_tk_begin_1_0= ruleTK_BEGIN ) ) ( (lv_pred_2_0= rulePred ) ) otherlv_3= '}' ( (lv_agent_4_0= ruleAgent ) ) ) | ( ( (lv_pred2_5_0= rulePred ) ) otherlv_6= '}' ) ) )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:252:1: (otherlv_0= '{' ( ( ( (lv_tk_begin_1_0= ruleTK_BEGIN ) ) ( (lv_pred_2_0= rulePred ) ) otherlv_3= '}' ( (lv_agent_4_0= ruleAgent ) ) ) | ( ( (lv_pred2_5_0= rulePred ) ) otherlv_6= '}' ) ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:252:3: otherlv_0= '{' ( ( ( (lv_tk_begin_1_0= ruleTK_BEGIN ) ) ( (lv_pred_2_0= rulePred ) ) otherlv_3= '}' ( (lv_agent_4_0= ruleAgent ) ) ) | ( ( (lv_pred2_5_0= rulePred ) ) otherlv_6= '}' ) )
            {
            otherlv_0=(Token)match(input,18,FOLLOW_18_in_ruleDirective388); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getDirectiveAccess().getLeftCurlyBracketKeyword_0());
                  
            }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:256:1: ( ( ( (lv_tk_begin_1_0= ruleTK_BEGIN ) ) ( (lv_pred_2_0= rulePred ) ) otherlv_3= '}' ( (lv_agent_4_0= ruleAgent ) ) ) | ( ( (lv_pred2_5_0= rulePred ) ) otherlv_6= '}' ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==48) ) {
                int LA9_1 = input.LA(2);

                if ( ((LA9_1>=18 && LA9_1<=19)||LA9_1==30||LA9_1==34) ) {
                    alt9=2;
                }
                else if ( (LA9_1==RULE_ATOM||LA9_1==21||(LA9_1>=48 && LA9_1<=49)) ) {
                    alt9=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA9_0==RULE_ATOM||LA9_0==21||LA9_0==49) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:256:2: ( ( (lv_tk_begin_1_0= ruleTK_BEGIN ) ) ( (lv_pred_2_0= rulePred ) ) otherlv_3= '}' ( (lv_agent_4_0= ruleAgent ) ) )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:256:2: ( ( (lv_tk_begin_1_0= ruleTK_BEGIN ) ) ( (lv_pred_2_0= rulePred ) ) otherlv_3= '}' ( (lv_agent_4_0= ruleAgent ) ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:256:3: ( (lv_tk_begin_1_0= ruleTK_BEGIN ) ) ( (lv_pred_2_0= rulePred ) ) otherlv_3= '}' ( (lv_agent_4_0= ruleAgent ) )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:256:3: ( (lv_tk_begin_1_0= ruleTK_BEGIN ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:257:1: (lv_tk_begin_1_0= ruleTK_BEGIN )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:257:1: (lv_tk_begin_1_0= ruleTK_BEGIN )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:258:3: lv_tk_begin_1_0= ruleTK_BEGIN
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDirectiveAccess().getTk_beginTK_BEGINParserRuleCall_1_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTK_BEGIN_in_ruleDirective411);
                    lv_tk_begin_1_0=ruleTK_BEGIN();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDirectiveRule());
                      	        }
                             		set(
                             			current, 
                             			"tk_begin",
                              		lv_tk_begin_1_0, 
                              		"TK_BEGIN");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:274:2: ( (lv_pred_2_0= rulePred ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:275:1: (lv_pred_2_0= rulePred )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:275:1: (lv_pred_2_0= rulePred )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:276:3: lv_pred_2_0= rulePred
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDirectiveAccess().getPredPredParserRuleCall_1_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePred_in_ruleDirective432);
                    lv_pred_2_0=rulePred();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDirectiveRule());
                      	        }
                             		set(
                             			current, 
                             			"pred",
                              		lv_pred_2_0, 
                              		"Pred");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleDirective444); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getDirectiveAccess().getRightCurlyBracketKeyword_1_0_2());
                          
                    }
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:296:1: ( (lv_agent_4_0= ruleAgent ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:297:1: (lv_agent_4_0= ruleAgent )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:297:1: (lv_agent_4_0= ruleAgent )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:298:3: lv_agent_4_0= ruleAgent
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDirectiveAccess().getAgentAgentParserRuleCall_1_0_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAgent_in_ruleDirective465);
                    lv_agent_4_0=ruleAgent();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDirectiveRule());
                      	        }
                             		set(
                             			current, 
                             			"agent",
                              		lv_agent_4_0, 
                              		"Agent");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:315:6: ( ( (lv_pred2_5_0= rulePred ) ) otherlv_6= '}' )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:315:6: ( ( (lv_pred2_5_0= rulePred ) ) otherlv_6= '}' )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:315:7: ( (lv_pred2_5_0= rulePred ) ) otherlv_6= '}'
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:315:7: ( (lv_pred2_5_0= rulePred ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:316:1: (lv_pred2_5_0= rulePred )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:316:1: (lv_pred2_5_0= rulePred )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:317:3: lv_pred2_5_0= rulePred
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDirectiveAccess().getPred2PredParserRuleCall_1_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePred_in_ruleDirective494);
                    lv_pred2_5_0=rulePred();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDirectiveRule());
                      	        }
                             		set(
                             			current, 
                             			"pred2",
                              		lv_pred2_5_0, 
                              		"Pred");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_6=(Token)match(input,19,FOLLOW_19_in_ruleDirective506); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getDirectiveAccess().getRightCurlyBracketKeyword_1_1_1());
                          
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 4, ruleDirective_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleDirective"


    // $ANTLR start "entryRuleBelief"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:345:1: entryRuleBelief returns [EObject current=null] : iv_ruleBelief= ruleBelief EOF ;
    public final EObject entryRuleBelief() throws RecognitionException {
        EObject current = null;
        int entryRuleBelief_StartIndex = input.index();
        EObject iv_ruleBelief = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:346:2: (iv_ruleBelief= ruleBelief EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:347:2: iv_ruleBelief= ruleBelief EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBeliefRule()); 
            }
            pushFollow(FOLLOW_ruleBelief_in_entryRuleBelief544);
            iv_ruleBelief=ruleBelief();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBelief; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBelief554); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 5, entryRuleBelief_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleBelief"


    // $ANTLR start "ruleBelief"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:354:1: ruleBelief returns [EObject current=null] : ( ( (lv_literal_0_0= ruleLiteral ) ) (otherlv_1= ':-' ( (lv_log_expr_2_0= ruleLog_expr ) ) )? otherlv_3= '.' ) ;
    public final EObject ruleBelief() throws RecognitionException {
        EObject current = null;
        int ruleBelief_StartIndex = input.index();
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_literal_0_0 = null;

        EObject lv_log_expr_2_0 = null;


         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:357:28: ( ( ( (lv_literal_0_0= ruleLiteral ) ) (otherlv_1= ':-' ( (lv_log_expr_2_0= ruleLog_expr ) ) )? otherlv_3= '.' ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:358:1: ( ( (lv_literal_0_0= ruleLiteral ) ) (otherlv_1= ':-' ( (lv_log_expr_2_0= ruleLog_expr ) ) )? otherlv_3= '.' )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:358:1: ( ( (lv_literal_0_0= ruleLiteral ) ) (otherlv_1= ':-' ( (lv_log_expr_2_0= ruleLog_expr ) ) )? otherlv_3= '.' )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:358:2: ( (lv_literal_0_0= ruleLiteral ) ) (otherlv_1= ':-' ( (lv_log_expr_2_0= ruleLog_expr ) ) )? otherlv_3= '.'
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:358:2: ( (lv_literal_0_0= ruleLiteral ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:359:1: (lv_literal_0_0= ruleLiteral )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:359:1: (lv_literal_0_0= ruleLiteral )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:360:3: lv_literal_0_0= ruleLiteral
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getBeliefAccess().getLiteralLiteralParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLiteral_in_ruleBelief600);
            lv_literal_0_0=ruleLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getBeliefRule());
              	        }
                     		set(
                     			current, 
                     			"literal",
                      		lv_literal_0_0, 
                      		"Literal");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:376:2: (otherlv_1= ':-' ( (lv_log_expr_2_0= ruleLog_expr ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==20) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:376:4: otherlv_1= ':-' ( (lv_log_expr_2_0= ruleLog_expr ) )
                    {
                    otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleBelief613); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getBeliefAccess().getColonHyphenMinusKeyword_1_0());
                          
                    }
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:380:1: ( (lv_log_expr_2_0= ruleLog_expr ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:381:1: (lv_log_expr_2_0= ruleLog_expr )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:381:1: (lv_log_expr_2_0= ruleLog_expr )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:382:3: lv_log_expr_2_0= ruleLog_expr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getBeliefAccess().getLog_exprLog_exprParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLog_expr_in_ruleBelief634);
                    lv_log_expr_2_0=ruleLog_expr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getBeliefRule());
                      	        }
                             		set(
                             			current, 
                             			"log_expr",
                              		lv_log_expr_2_0, 
                              		"Log_expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,21,FOLLOW_21_in_ruleBelief648); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getBeliefAccess().getFullStopKeyword_2());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 6, ruleBelief_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleBelief"


    // $ANTLR start "entryRuleInitial_goal"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:410:1: entryRuleInitial_goal returns [EObject current=null] : iv_ruleInitial_goal= ruleInitial_goal EOF ;
    public final EObject entryRuleInitial_goal() throws RecognitionException {
        EObject current = null;
        int entryRuleInitial_goal_StartIndex = input.index();
        EObject iv_ruleInitial_goal = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:411:2: (iv_ruleInitial_goal= ruleInitial_goal EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:412:2: iv_ruleInitial_goal= ruleInitial_goal EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInitial_goalRule()); 
            }
            pushFollow(FOLLOW_ruleInitial_goal_in_entryRuleInitial_goal684);
            iv_ruleInitial_goal=ruleInitial_goal();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInitial_goal; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleInitial_goal694); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 7, entryRuleInitial_goal_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleInitial_goal"


    // $ANTLR start "ruleInitial_goal"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:419:1: ruleInitial_goal returns [EObject current=null] : (otherlv_0= '!' ( (lv_literal_1_0= ruleLiteral ) ) otherlv_2= '.' ) ;
    public final EObject ruleInitial_goal() throws RecognitionException {
        EObject current = null;
        int ruleInitial_goal_StartIndex = input.index();
        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_literal_1_0 = null;


         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:422:28: ( (otherlv_0= '!' ( (lv_literal_1_0= ruleLiteral ) ) otherlv_2= '.' ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:423:1: (otherlv_0= '!' ( (lv_literal_1_0= ruleLiteral ) ) otherlv_2= '.' )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:423:1: (otherlv_0= '!' ( (lv_literal_1_0= ruleLiteral ) ) otherlv_2= '.' )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:423:3: otherlv_0= '!' ( (lv_literal_1_0= ruleLiteral ) ) otherlv_2= '.'
            {
            otherlv_0=(Token)match(input,22,FOLLOW_22_in_ruleInitial_goal731); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getInitial_goalAccess().getExclamationMarkKeyword_0());
                  
            }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:427:1: ( (lv_literal_1_0= ruleLiteral ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:428:1: (lv_literal_1_0= ruleLiteral )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:428:1: (lv_literal_1_0= ruleLiteral )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:429:3: lv_literal_1_0= ruleLiteral
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getInitial_goalAccess().getLiteralLiteralParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLiteral_in_ruleInitial_goal752);
            lv_literal_1_0=ruleLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getInitial_goalRule());
              	        }
                     		set(
                     			current, 
                     			"literal",
                      		lv_literal_1_0, 
                      		"Literal");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,21,FOLLOW_21_in_ruleInitial_goal764); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getInitial_goalAccess().getFullStopKeyword_2());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 8, ruleInitial_goal_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleInitial_goal"


    // $ANTLR start "entryRulePlan"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:457:1: entryRulePlan returns [EObject current=null] : iv_rulePlan= rulePlan EOF ;
    public final EObject entryRulePlan() throws RecognitionException {
        EObject current = null;
        int entryRulePlan_StartIndex = input.index();
        EObject iv_rulePlan = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:458:2: (iv_rulePlan= rulePlan EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:459:2: iv_rulePlan= rulePlan EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPlanRule()); 
            }
            pushFollow(FOLLOW_rulePlan_in_entryRulePlan800);
            iv_rulePlan=rulePlan();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePlan; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePlan810); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 9, entryRulePlan_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRulePlan"


    // $ANTLR start "rulePlan"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:466:1: rulePlan returns [EObject current=null] : ( ( ( (lv_tk_label_at_0_0= RULE_TK_LABEL_AT ) ) ( (lv_pred_1_0= rulePred ) ) )? ( (lv_trigger_2_0= ruleTrigger ) ) (otherlv_3= ':' ( (lv_log_expr_4_0= ruleLog_expr ) ) )? (otherlv_5= '<-' ( (lv_plan_body_6_0= rulePlan_body ) ) )? otherlv_7= '.' ) ;
    public final EObject rulePlan() throws RecognitionException {
        EObject current = null;
        int rulePlan_StartIndex = input.index();
        Token lv_tk_label_at_0_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_pred_1_0 = null;

        EObject lv_trigger_2_0 = null;

        EObject lv_log_expr_4_0 = null;

        EObject lv_plan_body_6_0 = null;


         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:469:28: ( ( ( ( (lv_tk_label_at_0_0= RULE_TK_LABEL_AT ) ) ( (lv_pred_1_0= rulePred ) ) )? ( (lv_trigger_2_0= ruleTrigger ) ) (otherlv_3= ':' ( (lv_log_expr_4_0= ruleLog_expr ) ) )? (otherlv_5= '<-' ( (lv_plan_body_6_0= rulePlan_body ) ) )? otherlv_7= '.' ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:470:1: ( ( ( (lv_tk_label_at_0_0= RULE_TK_LABEL_AT ) ) ( (lv_pred_1_0= rulePred ) ) )? ( (lv_trigger_2_0= ruleTrigger ) ) (otherlv_3= ':' ( (lv_log_expr_4_0= ruleLog_expr ) ) )? (otherlv_5= '<-' ( (lv_plan_body_6_0= rulePlan_body ) ) )? otherlv_7= '.' )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:470:1: ( ( ( (lv_tk_label_at_0_0= RULE_TK_LABEL_AT ) ) ( (lv_pred_1_0= rulePred ) ) )? ( (lv_trigger_2_0= ruleTrigger ) ) (otherlv_3= ':' ( (lv_log_expr_4_0= ruleLog_expr ) ) )? (otherlv_5= '<-' ( (lv_plan_body_6_0= rulePlan_body ) ) )? otherlv_7= '.' )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:470:2: ( ( (lv_tk_label_at_0_0= RULE_TK_LABEL_AT ) ) ( (lv_pred_1_0= rulePred ) ) )? ( (lv_trigger_2_0= ruleTrigger ) ) (otherlv_3= ':' ( (lv_log_expr_4_0= ruleLog_expr ) ) )? (otherlv_5= '<-' ( (lv_plan_body_6_0= rulePlan_body ) ) )? otherlv_7= '.'
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:470:2: ( ( (lv_tk_label_at_0_0= RULE_TK_LABEL_AT ) ) ( (lv_pred_1_0= rulePred ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_TK_LABEL_AT) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:470:3: ( (lv_tk_label_at_0_0= RULE_TK_LABEL_AT ) ) ( (lv_pred_1_0= rulePred ) )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:470:3: ( (lv_tk_label_at_0_0= RULE_TK_LABEL_AT ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:471:1: (lv_tk_label_at_0_0= RULE_TK_LABEL_AT )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:471:1: (lv_tk_label_at_0_0= RULE_TK_LABEL_AT )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:472:3: lv_tk_label_at_0_0= RULE_TK_LABEL_AT
                    {
                    lv_tk_label_at_0_0=(Token)match(input,RULE_TK_LABEL_AT,FOLLOW_RULE_TK_LABEL_AT_in_rulePlan853); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_tk_label_at_0_0, grammarAccess.getPlanAccess().getTk_label_atTK_LABEL_ATTerminalRuleCall_0_0_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getPlanRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"tk_label_at",
                              		lv_tk_label_at_0_0, 
                              		"TK_LABEL_AT");
                      	    
                    }

                    }


                    }

                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:488:2: ( (lv_pred_1_0= rulePred ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:489:1: (lv_pred_1_0= rulePred )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:489:1: (lv_pred_1_0= rulePred )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:490:3: lv_pred_1_0= rulePred
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPlanAccess().getPredPredParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePred_in_rulePlan879);
                    lv_pred_1_0=rulePred();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPlanRule());
                      	        }
                             		set(
                             			current, 
                             			"pred",
                              		lv_pred_1_0, 
                              		"Pred");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:506:4: ( (lv_trigger_2_0= ruleTrigger ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:507:1: (lv_trigger_2_0= ruleTrigger )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:507:1: (lv_trigger_2_0= ruleTrigger )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:508:3: lv_trigger_2_0= ruleTrigger
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPlanAccess().getTriggerTriggerParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTrigger_in_rulePlan902);
            lv_trigger_2_0=ruleTrigger();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPlanRule());
              	        }
                     		set(
                     			current, 
                     			"trigger",
                      		lv_trigger_2_0, 
                      		"Trigger");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:524:2: (otherlv_3= ':' ( (lv_log_expr_4_0= ruleLog_expr ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==23) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:524:4: otherlv_3= ':' ( (lv_log_expr_4_0= ruleLog_expr ) )
                    {
                    otherlv_3=(Token)match(input,23,FOLLOW_23_in_rulePlan915); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getPlanAccess().getColonKeyword_2_0());
                          
                    }
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:528:1: ( (lv_log_expr_4_0= ruleLog_expr ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:529:1: (lv_log_expr_4_0= ruleLog_expr )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:529:1: (lv_log_expr_4_0= ruleLog_expr )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:530:3: lv_log_expr_4_0= ruleLog_expr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPlanAccess().getLog_exprLog_exprParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLog_expr_in_rulePlan936);
                    lv_log_expr_4_0=ruleLog_expr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPlanRule());
                      	        }
                             		set(
                             			current, 
                             			"log_expr",
                              		lv_log_expr_4_0, 
                              		"Log_expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:546:4: (otherlv_5= '<-' ( (lv_plan_body_6_0= rulePlan_body ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==24) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:546:6: otherlv_5= '<-' ( (lv_plan_body_6_0= rulePlan_body ) )
                    {
                    otherlv_5=(Token)match(input,24,FOLLOW_24_in_rulePlan951); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getPlanAccess().getLessThanSignHyphenMinusKeyword_3_0());
                          
                    }
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:550:1: ( (lv_plan_body_6_0= rulePlan_body ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:551:1: (lv_plan_body_6_0= rulePlan_body )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:551:1: (lv_plan_body_6_0= rulePlan_body )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:552:3: lv_plan_body_6_0= rulePlan_body
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPlanAccess().getPlan_bodyPlan_bodyParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePlan_body_in_rulePlan972);
                    lv_plan_body_6_0=rulePlan_body();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPlanRule());
                      	        }
                             		set(
                             			current, 
                             			"plan_body",
                              		lv_plan_body_6_0, 
                              		"Plan_body");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,21,FOLLOW_21_in_rulePlan986); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getPlanAccess().getFullStopKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 10, rulePlan_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "rulePlan"


    // $ANTLR start "entryRuleTrigger"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:580:1: entryRuleTrigger returns [EObject current=null] : iv_ruleTrigger= ruleTrigger EOF ;
    public final EObject entryRuleTrigger() throws RecognitionException {
        EObject current = null;
        int entryRuleTrigger_StartIndex = input.index();
        EObject iv_ruleTrigger = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:581:2: (iv_ruleTrigger= ruleTrigger EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:582:2: iv_ruleTrigger= ruleTrigger EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTriggerRule()); 
            }
            pushFollow(FOLLOW_ruleTrigger_in_entryRuleTrigger1022);
            iv_ruleTrigger=ruleTrigger();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTrigger; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTrigger1032); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 11, entryRuleTrigger_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleTrigger"


    // $ANTLR start "ruleTrigger"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:589:1: ruleTrigger returns [EObject current=null] : ( ( (lv_trigger_0_0= ruleTriggerSymbol ) ) ( ( (lv_literal_1_0= ruleLiteral ) ) | ( (lv_var_2_0= ruleVar ) ) ) ) ;
    public final EObject ruleTrigger() throws RecognitionException {
        EObject current = null;
        int ruleTrigger_StartIndex = input.index();
        AntlrDatatypeRuleToken lv_trigger_0_0 = null;

        EObject lv_literal_1_0 = null;

        EObject lv_var_2_0 = null;


         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:592:28: ( ( ( (lv_trigger_0_0= ruleTriggerSymbol ) ) ( ( (lv_literal_1_0= ruleLiteral ) ) | ( (lv_var_2_0= ruleVar ) ) ) ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:593:1: ( ( (lv_trigger_0_0= ruleTriggerSymbol ) ) ( ( (lv_literal_1_0= ruleLiteral ) ) | ( (lv_var_2_0= ruleVar ) ) ) )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:593:1: ( ( (lv_trigger_0_0= ruleTriggerSymbol ) ) ( ( (lv_literal_1_0= ruleLiteral ) ) | ( (lv_var_2_0= ruleVar ) ) ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:593:2: ( (lv_trigger_0_0= ruleTriggerSymbol ) ) ( ( (lv_literal_1_0= ruleLiteral ) ) | ( (lv_var_2_0= ruleVar ) ) )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:593:2: ( (lv_trigger_0_0= ruleTriggerSymbol ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:594:1: (lv_trigger_0_0= ruleTriggerSymbol )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:594:1: (lv_trigger_0_0= ruleTriggerSymbol )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:595:3: lv_trigger_0_0= ruleTriggerSymbol
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTriggerAccess().getTriggerTriggerSymbolParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTriggerSymbol_in_ruleTrigger1078);
            lv_trigger_0_0=ruleTriggerSymbol();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTriggerRule());
              	        }
                     		set(
                     			current, 
                     			"trigger",
                      		lv_trigger_0_0, 
                      		"TriggerSymbol");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:611:2: ( ( (lv_literal_1_0= ruleLiteral ) ) | ( (lv_var_2_0= ruleVar ) ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_TK_NEG||LA14_0==RULE_ATOM||LA14_0==21||(LA14_0>=48 && LA14_0<=49)||(LA14_0>=57 && LA14_0<=58)) ) {
                alt14=1;
            }
            else if ( ((LA14_0>=RULE_VART && LA14_0<=RULE_UNNAMEDVART)) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:611:3: ( (lv_literal_1_0= ruleLiteral ) )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:611:3: ( (lv_literal_1_0= ruleLiteral ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:612:1: (lv_literal_1_0= ruleLiteral )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:612:1: (lv_literal_1_0= ruleLiteral )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:613:3: lv_literal_1_0= ruleLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTriggerAccess().getLiteralLiteralParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLiteral_in_ruleTrigger1100);
                    lv_literal_1_0=ruleLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTriggerRule());
                      	        }
                             		set(
                             			current, 
                             			"literal",
                              		lv_literal_1_0, 
                              		"Literal");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:630:6: ( (lv_var_2_0= ruleVar ) )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:630:6: ( (lv_var_2_0= ruleVar ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:631:1: (lv_var_2_0= ruleVar )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:631:1: (lv_var_2_0= ruleVar )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:632:3: lv_var_2_0= ruleVar
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTriggerAccess().getVarVarParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleVar_in_ruleTrigger1127);
                    lv_var_2_0=ruleVar();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTriggerRule());
                      	        }
                             		set(
                             			current, 
                             			"var",
                              		lv_var_2_0, 
                              		"Var");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 12, ruleTrigger_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleTrigger"


    // $ANTLR start "entryRuleTriggerSymbol"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:656:1: entryRuleTriggerSymbol returns [String current=null] : iv_ruleTriggerSymbol= ruleTriggerSymbol EOF ;
    public final String entryRuleTriggerSymbol() throws RecognitionException {
        String current = null;
        int entryRuleTriggerSymbol_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_ruleTriggerSymbol = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:657:2: (iv_ruleTriggerSymbol= ruleTriggerSymbol EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:658:2: iv_ruleTriggerSymbol= ruleTriggerSymbol EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTriggerSymbolRule()); 
            }
            pushFollow(FOLLOW_ruleTriggerSymbol_in_entryRuleTriggerSymbol1165);
            iv_ruleTriggerSymbol=ruleTriggerSymbol();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTriggerSymbol.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTriggerSymbol1176); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 13, entryRuleTriggerSymbol_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleTriggerSymbol"


    // $ANTLR start "ruleTriggerSymbol"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:665:1: ruleTriggerSymbol returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' | kw= '^' ) (kw= '!' | kw= '?' )? ) ;
    public final AntlrDatatypeRuleToken ruleTriggerSymbol() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        int ruleTriggerSymbol_StartIndex = input.index();
        Token kw=null;

         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:668:28: ( ( (kw= '+' | kw= '-' | kw= '^' ) (kw= '!' | kw= '?' )? ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:669:1: ( (kw= '+' | kw= '-' | kw= '^' ) (kw= '!' | kw= '?' )? )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:669:1: ( (kw= '+' | kw= '-' | kw= '^' ) (kw= '!' | kw= '?' )? )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:669:2: (kw= '+' | kw= '-' | kw= '^' ) (kw= '!' | kw= '?' )?
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:669:2: (kw= '+' | kw= '-' | kw= '^' )
            int alt15=3;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt15=1;
                }
                break;
            case 26:
                {
                alt15=2;
                }
                break;
            case 27:
                {
                alt15=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:670:2: kw= '+'
                    {
                    kw=(Token)match(input,25,FOLLOW_25_in_ruleTriggerSymbol1215); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getTriggerSymbolAccess().getPlusSignKeyword_0_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:677:2: kw= '-'
                    {
                    kw=(Token)match(input,26,FOLLOW_26_in_ruleTriggerSymbol1234); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getTriggerSymbolAccess().getHyphenMinusKeyword_0_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:684:2: kw= '^'
                    {
                    kw=(Token)match(input,27,FOLLOW_27_in_ruleTriggerSymbol1253); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getTriggerSymbolAccess().getCircumflexAccentKeyword_0_2()); 
                          
                    }

                    }
                    break;

            }

            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:689:2: (kw= '!' | kw= '?' )?
            int alt16=3;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==22) ) {
                alt16=1;
            }
            else if ( (LA16_0==28) ) {
                alt16=2;
            }
            switch (alt16) {
                case 1 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:690:2: kw= '!'
                    {
                    kw=(Token)match(input,22,FOLLOW_22_in_ruleTriggerSymbol1268); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getTriggerSymbolAccess().getExclamationMarkKeyword_1_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:697:2: kw= '?'
                    {
                    kw=(Token)match(input,28,FOLLOW_28_in_ruleTriggerSymbol1287); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getTriggerSymbolAccess().getQuestionMarkKeyword_1_1()); 
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 14, ruleTriggerSymbol_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleTriggerSymbol"


    // $ANTLR start "entryRulePlan_body"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:710:1: entryRulePlan_body returns [EObject current=null] : iv_rulePlan_body= rulePlan_body EOF ;
    public final EObject entryRulePlan_body() throws RecognitionException {
        EObject current = null;
        int entryRulePlan_body_StartIndex = input.index();
        EObject iv_rulePlan_body = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:711:2: (iv_rulePlan_body= rulePlan_body EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:712:2: iv_rulePlan_body= rulePlan_body EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPlan_bodyRule()); 
            }
            pushFollow(FOLLOW_rulePlan_body_in_entryRulePlan_body1329);
            iv_rulePlan_body=rulePlan_body();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePlan_body; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePlan_body1339); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 15, entryRulePlan_body_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRulePlan_body"


    // $ANTLR start "rulePlan_body"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:719:1: rulePlan_body returns [EObject current=null] : ( ( ( (lv_stmtIF_0_0= ruleStmtIF ) ) | ( (lv_stmtFOR_1_0= ruleStmtFOR ) ) | ( (lv_stmtWHILE_2_0= ruleStmtWHILE ) ) | ( (lv_body_formula_3_0= ruleBody_formula ) ) ) (otherlv_4= ';' )? ( (lv_plan_body_5_0= rulePlan_body ) )? ) ;
    public final EObject rulePlan_body() throws RecognitionException {
        EObject current = null;
        int rulePlan_body_StartIndex = input.index();
        Token otherlv_4=null;
        EObject lv_stmtIF_0_0 = null;

        EObject lv_stmtFOR_1_0 = null;

        EObject lv_stmtWHILE_2_0 = null;

        EObject lv_body_formula_3_0 = null;

        EObject lv_plan_body_5_0 = null;


         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:722:28: ( ( ( ( (lv_stmtIF_0_0= ruleStmtIF ) ) | ( (lv_stmtFOR_1_0= ruleStmtFOR ) ) | ( (lv_stmtWHILE_2_0= ruleStmtWHILE ) ) | ( (lv_body_formula_3_0= ruleBody_formula ) ) ) (otherlv_4= ';' )? ( (lv_plan_body_5_0= rulePlan_body ) )? ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:723:1: ( ( ( (lv_stmtIF_0_0= ruleStmtIF ) ) | ( (lv_stmtFOR_1_0= ruleStmtFOR ) ) | ( (lv_stmtWHILE_2_0= ruleStmtWHILE ) ) | ( (lv_body_formula_3_0= ruleBody_formula ) ) ) (otherlv_4= ';' )? ( (lv_plan_body_5_0= rulePlan_body ) )? )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:723:1: ( ( ( (lv_stmtIF_0_0= ruleStmtIF ) ) | ( (lv_stmtFOR_1_0= ruleStmtFOR ) ) | ( (lv_stmtWHILE_2_0= ruleStmtWHILE ) ) | ( (lv_body_formula_3_0= ruleBody_formula ) ) ) (otherlv_4= ';' )? ( (lv_plan_body_5_0= rulePlan_body ) )? )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:723:2: ( ( (lv_stmtIF_0_0= ruleStmtIF ) ) | ( (lv_stmtFOR_1_0= ruleStmtFOR ) ) | ( (lv_stmtWHILE_2_0= ruleStmtWHILE ) ) | ( (lv_body_formula_3_0= ruleBody_formula ) ) ) (otherlv_4= ';' )? ( (lv_plan_body_5_0= rulePlan_body ) )?
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:723:2: ( ( (lv_stmtIF_0_0= ruleStmtIF ) ) | ( (lv_stmtFOR_1_0= ruleStmtFOR ) ) | ( (lv_stmtWHILE_2_0= ruleStmtWHILE ) ) | ( (lv_body_formula_3_0= ruleBody_formula ) ) )
            int alt17=4;
            switch ( input.LA(1) ) {
            case 50:
                {
                alt17=1;
                }
                break;
            case 52:
                {
                alt17=2;
                }
                break;
            case 53:
                {
                alt17=3;
                }
                break;
            case RULE_TK_NEG:
            case RULE_VART:
            case RULE_UNNAMEDVART:
            case RULE_STRINGT:
            case RULE_NUMBERT:
            case RULE_ATOM:
            case 21:
            case 22:
            case 25:
            case 26:
            case 28:
            case 30:
            case 32:
            case 48:
            case 49:
            case 54:
            case 57:
            case 58:
                {
                alt17=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:723:3: ( (lv_stmtIF_0_0= ruleStmtIF ) )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:723:3: ( (lv_stmtIF_0_0= ruleStmtIF ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:724:1: (lv_stmtIF_0_0= ruleStmtIF )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:724:1: (lv_stmtIF_0_0= ruleStmtIF )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:725:3: lv_stmtIF_0_0= ruleStmtIF
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPlan_bodyAccess().getStmtIFStmtIFParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleStmtIF_in_rulePlan_body1386);
                    lv_stmtIF_0_0=ruleStmtIF();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPlan_bodyRule());
                      	        }
                             		set(
                             			current, 
                             			"stmtIF",
                              		lv_stmtIF_0_0, 
                              		"StmtIF");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:742:6: ( (lv_stmtFOR_1_0= ruleStmtFOR ) )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:742:6: ( (lv_stmtFOR_1_0= ruleStmtFOR ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:743:1: (lv_stmtFOR_1_0= ruleStmtFOR )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:743:1: (lv_stmtFOR_1_0= ruleStmtFOR )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:744:3: lv_stmtFOR_1_0= ruleStmtFOR
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPlan_bodyAccess().getStmtFORStmtFORParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleStmtFOR_in_rulePlan_body1413);
                    lv_stmtFOR_1_0=ruleStmtFOR();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPlan_bodyRule());
                      	        }
                             		set(
                             			current, 
                             			"stmtFOR",
                              		lv_stmtFOR_1_0, 
                              		"StmtFOR");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:761:6: ( (lv_stmtWHILE_2_0= ruleStmtWHILE ) )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:761:6: ( (lv_stmtWHILE_2_0= ruleStmtWHILE ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:762:1: (lv_stmtWHILE_2_0= ruleStmtWHILE )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:762:1: (lv_stmtWHILE_2_0= ruleStmtWHILE )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:763:3: lv_stmtWHILE_2_0= ruleStmtWHILE
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPlan_bodyAccess().getStmtWHILEStmtWHILEParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleStmtWHILE_in_rulePlan_body1440);
                    lv_stmtWHILE_2_0=ruleStmtWHILE();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPlan_bodyRule());
                      	        }
                             		set(
                             			current, 
                             			"stmtWHILE",
                              		lv_stmtWHILE_2_0, 
                              		"StmtWHILE");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:780:6: ( (lv_body_formula_3_0= ruleBody_formula ) )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:780:6: ( (lv_body_formula_3_0= ruleBody_formula ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:781:1: (lv_body_formula_3_0= ruleBody_formula )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:781:1: (lv_body_formula_3_0= ruleBody_formula )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:782:3: lv_body_formula_3_0= ruleBody_formula
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPlan_bodyAccess().getBody_formulaBody_formulaParserRuleCall_0_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleBody_formula_in_rulePlan_body1467);
                    lv_body_formula_3_0=ruleBody_formula();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPlan_bodyRule());
                      	        }
                             		set(
                             			current, 
                             			"body_formula",
                              		lv_body_formula_3_0, 
                              		"Body_formula");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:798:3: (otherlv_4= ';' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==29) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:798:5: otherlv_4= ';'
                    {
                    otherlv_4=(Token)match(input,29,FOLLOW_29_in_rulePlan_body1481); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getPlan_bodyAccess().getSemicolonKeyword_1());
                          
                    }

                    }
                    break;

            }

            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:802:3: ( (lv_plan_body_5_0= rulePlan_body ) )?
            int alt19=2;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:803:1: (lv_plan_body_5_0= rulePlan_body )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:803:1: (lv_plan_body_5_0= rulePlan_body )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:804:3: lv_plan_body_5_0= rulePlan_body
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPlan_bodyAccess().getPlan_bodyPlan_bodyParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePlan_body_in_rulePlan_body1504);
                    lv_plan_body_5_0=rulePlan_body();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPlan_bodyRule());
                      	        }
                             		set(
                             			current, 
                             			"plan_body",
                              		lv_plan_body_5_0, 
                              		"Plan_body");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 16, rulePlan_body_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "rulePlan_body"


    // $ANTLR start "entryRuleStmtIF"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:828:1: entryRuleStmtIF returns [EObject current=null] : iv_ruleStmtIF= ruleStmtIF EOF ;
    public final EObject entryRuleStmtIF() throws RecognitionException {
        EObject current = null;
        int entryRuleStmtIF_StartIndex = input.index();
        EObject iv_ruleStmtIF = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:829:2: (iv_ruleStmtIF= ruleStmtIF EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:830:2: iv_ruleStmtIF= ruleStmtIF EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStmtIFRule()); 
            }
            pushFollow(FOLLOW_ruleStmtIF_in_entryRuleStmtIF1541);
            iv_ruleStmtIF=ruleStmtIF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStmtIF; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStmtIF1551); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 17, entryRuleStmtIF_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleStmtIF"


    // $ANTLR start "ruleStmtIF"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:837:1: ruleStmtIF returns [EObject current=null] : ( ( (lv_tk_if_0_0= ruleTK_IF ) ) otherlv_1= '(' ( (lv_log_expr_2_0= ruleLog_expr ) ) otherlv_3= ')' ( (lv_plan_term_4_0= rulePlan_term ) ) ( ( (lv_tk_else_5_0= ruleTK_ELSE ) )? ( (lv_plan_term2_6_0= rulePlan_term ) ) )? ) ;
    public final EObject ruleStmtIF() throws RecognitionException {
        EObject current = null;
        int ruleStmtIF_StartIndex = input.index();
        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_tk_if_0_0 = null;

        EObject lv_log_expr_2_0 = null;

        EObject lv_plan_term_4_0 = null;

        AntlrDatatypeRuleToken lv_tk_else_5_0 = null;

        EObject lv_plan_term2_6_0 = null;


         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:840:28: ( ( ( (lv_tk_if_0_0= ruleTK_IF ) ) otherlv_1= '(' ( (lv_log_expr_2_0= ruleLog_expr ) ) otherlv_3= ')' ( (lv_plan_term_4_0= rulePlan_term ) ) ( ( (lv_tk_else_5_0= ruleTK_ELSE ) )? ( (lv_plan_term2_6_0= rulePlan_term ) ) )? ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:841:1: ( ( (lv_tk_if_0_0= ruleTK_IF ) ) otherlv_1= '(' ( (lv_log_expr_2_0= ruleLog_expr ) ) otherlv_3= ')' ( (lv_plan_term_4_0= rulePlan_term ) ) ( ( (lv_tk_else_5_0= ruleTK_ELSE ) )? ( (lv_plan_term2_6_0= rulePlan_term ) ) )? )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:841:1: ( ( (lv_tk_if_0_0= ruleTK_IF ) ) otherlv_1= '(' ( (lv_log_expr_2_0= ruleLog_expr ) ) otherlv_3= ')' ( (lv_plan_term_4_0= rulePlan_term ) ) ( ( (lv_tk_else_5_0= ruleTK_ELSE ) )? ( (lv_plan_term2_6_0= rulePlan_term ) ) )? )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:841:2: ( (lv_tk_if_0_0= ruleTK_IF ) ) otherlv_1= '(' ( (lv_log_expr_2_0= ruleLog_expr ) ) otherlv_3= ')' ( (lv_plan_term_4_0= rulePlan_term ) ) ( ( (lv_tk_else_5_0= ruleTK_ELSE ) )? ( (lv_plan_term2_6_0= rulePlan_term ) ) )?
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:841:2: ( (lv_tk_if_0_0= ruleTK_IF ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:842:1: (lv_tk_if_0_0= ruleTK_IF )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:842:1: (lv_tk_if_0_0= ruleTK_IF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:843:3: lv_tk_if_0_0= ruleTK_IF
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getStmtIFAccess().getTk_ifTK_IFParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTK_IF_in_ruleStmtIF1597);
            lv_tk_if_0_0=ruleTK_IF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getStmtIFRule());
              	        }
                     		set(
                     			current, 
                     			"tk_if",
                      		lv_tk_if_0_0, 
                      		"TK_IF");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,30,FOLLOW_30_in_ruleStmtIF1609); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getStmtIFAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:863:1: ( (lv_log_expr_2_0= ruleLog_expr ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:864:1: (lv_log_expr_2_0= ruleLog_expr )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:864:1: (lv_log_expr_2_0= ruleLog_expr )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:865:3: lv_log_expr_2_0= ruleLog_expr
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getStmtIFAccess().getLog_exprLog_exprParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLog_expr_in_ruleStmtIF1630);
            lv_log_expr_2_0=ruleLog_expr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getStmtIFRule());
              	        }
                     		set(
                     			current, 
                     			"log_expr",
                      		lv_log_expr_2_0, 
                      		"Log_expr");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,31,FOLLOW_31_in_ruleStmtIF1642); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getStmtIFAccess().getRightParenthesisKeyword_3());
                  
            }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:885:1: ( (lv_plan_term_4_0= rulePlan_term ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:886:1: (lv_plan_term_4_0= rulePlan_term )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:886:1: (lv_plan_term_4_0= rulePlan_term )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:887:3: lv_plan_term_4_0= rulePlan_term
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getStmtIFAccess().getPlan_termPlan_termParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePlan_term_in_ruleStmtIF1663);
            lv_plan_term_4_0=rulePlan_term();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getStmtIFRule());
              	        }
                     		set(
                     			current, 
                     			"plan_term",
                      		lv_plan_term_4_0, 
                      		"Plan_term");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:903:2: ( ( (lv_tk_else_5_0= ruleTK_ELSE ) )? ( (lv_plan_term2_6_0= rulePlan_term ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==18||LA21_0==51) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:903:3: ( (lv_tk_else_5_0= ruleTK_ELSE ) )? ( (lv_plan_term2_6_0= rulePlan_term ) )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:903:3: ( (lv_tk_else_5_0= ruleTK_ELSE ) )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==51) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:904:1: (lv_tk_else_5_0= ruleTK_ELSE )
                            {
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:904:1: (lv_tk_else_5_0= ruleTK_ELSE )
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:905:3: lv_tk_else_5_0= ruleTK_ELSE
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getStmtIFAccess().getTk_elseTK_ELSEParserRuleCall_5_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleTK_ELSE_in_ruleStmtIF1685);
                            lv_tk_else_5_0=ruleTK_ELSE();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getStmtIFRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"tk_else",
                                      		lv_tk_else_5_0, 
                                      		"TK_ELSE");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }
                            break;

                    }

                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:921:3: ( (lv_plan_term2_6_0= rulePlan_term ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:922:1: (lv_plan_term2_6_0= rulePlan_term )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:922:1: (lv_plan_term2_6_0= rulePlan_term )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:923:3: lv_plan_term2_6_0= rulePlan_term
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStmtIFAccess().getPlan_term2Plan_termParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePlan_term_in_ruleStmtIF1707);
                    lv_plan_term2_6_0=rulePlan_term();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStmtIFRule());
                      	        }
                             		set(
                             			current, 
                             			"plan_term2",
                              		lv_plan_term2_6_0, 
                              		"Plan_term");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 18, ruleStmtIF_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleStmtIF"


    // $ANTLR start "entryRuleStmtFOR"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:947:1: entryRuleStmtFOR returns [EObject current=null] : iv_ruleStmtFOR= ruleStmtFOR EOF ;
    public final EObject entryRuleStmtFOR() throws RecognitionException {
        EObject current = null;
        int entryRuleStmtFOR_StartIndex = input.index();
        EObject iv_ruleStmtFOR = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:948:2: (iv_ruleStmtFOR= ruleStmtFOR EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:949:2: iv_ruleStmtFOR= ruleStmtFOR EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStmtFORRule()); 
            }
            pushFollow(FOLLOW_ruleStmtFOR_in_entryRuleStmtFOR1745);
            iv_ruleStmtFOR=ruleStmtFOR();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStmtFOR; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStmtFOR1755); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 19, entryRuleStmtFOR_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleStmtFOR"


    // $ANTLR start "ruleStmtFOR"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:956:1: ruleStmtFOR returns [EObject current=null] : ( ( (lv_tk_for_0_0= ruleTK_FOR ) ) otherlv_1= '(' ( (lv_log_expr_2_0= ruleLog_expr ) ) otherlv_3= ')' ( (lv_plan_term_4_0= rulePlan_term ) ) ) ;
    public final EObject ruleStmtFOR() throws RecognitionException {
        EObject current = null;
        int ruleStmtFOR_StartIndex = input.index();
        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_tk_for_0_0 = null;

        EObject lv_log_expr_2_0 = null;

        EObject lv_plan_term_4_0 = null;


         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:959:28: ( ( ( (lv_tk_for_0_0= ruleTK_FOR ) ) otherlv_1= '(' ( (lv_log_expr_2_0= ruleLog_expr ) ) otherlv_3= ')' ( (lv_plan_term_4_0= rulePlan_term ) ) ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:960:1: ( ( (lv_tk_for_0_0= ruleTK_FOR ) ) otherlv_1= '(' ( (lv_log_expr_2_0= ruleLog_expr ) ) otherlv_3= ')' ( (lv_plan_term_4_0= rulePlan_term ) ) )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:960:1: ( ( (lv_tk_for_0_0= ruleTK_FOR ) ) otherlv_1= '(' ( (lv_log_expr_2_0= ruleLog_expr ) ) otherlv_3= ')' ( (lv_plan_term_4_0= rulePlan_term ) ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:960:2: ( (lv_tk_for_0_0= ruleTK_FOR ) ) otherlv_1= '(' ( (lv_log_expr_2_0= ruleLog_expr ) ) otherlv_3= ')' ( (lv_plan_term_4_0= rulePlan_term ) )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:960:2: ( (lv_tk_for_0_0= ruleTK_FOR ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:961:1: (lv_tk_for_0_0= ruleTK_FOR )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:961:1: (lv_tk_for_0_0= ruleTK_FOR )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:962:3: lv_tk_for_0_0= ruleTK_FOR
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getStmtFORAccess().getTk_forTK_FORParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTK_FOR_in_ruleStmtFOR1801);
            lv_tk_for_0_0=ruleTK_FOR();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getStmtFORRule());
              	        }
                     		set(
                     			current, 
                     			"tk_for",
                      		lv_tk_for_0_0, 
                      		"TK_FOR");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,30,FOLLOW_30_in_ruleStmtFOR1813); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getStmtFORAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:982:1: ( (lv_log_expr_2_0= ruleLog_expr ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:983:1: (lv_log_expr_2_0= ruleLog_expr )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:983:1: (lv_log_expr_2_0= ruleLog_expr )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:984:3: lv_log_expr_2_0= ruleLog_expr
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getStmtFORAccess().getLog_exprLog_exprParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLog_expr_in_ruleStmtFOR1834);
            lv_log_expr_2_0=ruleLog_expr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getStmtFORRule());
              	        }
                     		set(
                     			current, 
                     			"log_expr",
                      		lv_log_expr_2_0, 
                      		"Log_expr");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,31,FOLLOW_31_in_ruleStmtFOR1846); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getStmtFORAccess().getRightParenthesisKeyword_3());
                  
            }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1004:1: ( (lv_plan_term_4_0= rulePlan_term ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1005:1: (lv_plan_term_4_0= rulePlan_term )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1005:1: (lv_plan_term_4_0= rulePlan_term )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1006:3: lv_plan_term_4_0= rulePlan_term
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getStmtFORAccess().getPlan_termPlan_termParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePlan_term_in_ruleStmtFOR1867);
            lv_plan_term_4_0=rulePlan_term();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getStmtFORRule());
              	        }
                     		set(
                     			current, 
                     			"plan_term",
                      		lv_plan_term_4_0, 
                      		"Plan_term");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 20, ruleStmtFOR_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleStmtFOR"


    // $ANTLR start "entryRuleStmtWHILE"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1030:1: entryRuleStmtWHILE returns [EObject current=null] : iv_ruleStmtWHILE= ruleStmtWHILE EOF ;
    public final EObject entryRuleStmtWHILE() throws RecognitionException {
        EObject current = null;
        int entryRuleStmtWHILE_StartIndex = input.index();
        EObject iv_ruleStmtWHILE = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1031:2: (iv_ruleStmtWHILE= ruleStmtWHILE EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1032:2: iv_ruleStmtWHILE= ruleStmtWHILE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStmtWHILERule()); 
            }
            pushFollow(FOLLOW_ruleStmtWHILE_in_entryRuleStmtWHILE1903);
            iv_ruleStmtWHILE=ruleStmtWHILE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStmtWHILE; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStmtWHILE1913); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 21, entryRuleStmtWHILE_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleStmtWHILE"


    // $ANTLR start "ruleStmtWHILE"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1039:1: ruleStmtWHILE returns [EObject current=null] : ( ( (lv_tk_while_0_0= ruleTK_WHILE ) ) otherlv_1= '(' ( (lv_log_expr_2_0= ruleLog_expr ) ) otherlv_3= ')' ( (lv_plan_term_4_0= rulePlan_term ) ) ) ;
    public final EObject ruleStmtWHILE() throws RecognitionException {
        EObject current = null;
        int ruleStmtWHILE_StartIndex = input.index();
        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_tk_while_0_0 = null;

        EObject lv_log_expr_2_0 = null;

        EObject lv_plan_term_4_0 = null;


         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1042:28: ( ( ( (lv_tk_while_0_0= ruleTK_WHILE ) ) otherlv_1= '(' ( (lv_log_expr_2_0= ruleLog_expr ) ) otherlv_3= ')' ( (lv_plan_term_4_0= rulePlan_term ) ) ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1043:1: ( ( (lv_tk_while_0_0= ruleTK_WHILE ) ) otherlv_1= '(' ( (lv_log_expr_2_0= ruleLog_expr ) ) otherlv_3= ')' ( (lv_plan_term_4_0= rulePlan_term ) ) )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1043:1: ( ( (lv_tk_while_0_0= ruleTK_WHILE ) ) otherlv_1= '(' ( (lv_log_expr_2_0= ruleLog_expr ) ) otherlv_3= ')' ( (lv_plan_term_4_0= rulePlan_term ) ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1043:2: ( (lv_tk_while_0_0= ruleTK_WHILE ) ) otherlv_1= '(' ( (lv_log_expr_2_0= ruleLog_expr ) ) otherlv_3= ')' ( (lv_plan_term_4_0= rulePlan_term ) )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1043:2: ( (lv_tk_while_0_0= ruleTK_WHILE ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1044:1: (lv_tk_while_0_0= ruleTK_WHILE )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1044:1: (lv_tk_while_0_0= ruleTK_WHILE )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1045:3: lv_tk_while_0_0= ruleTK_WHILE
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getStmtWHILEAccess().getTk_whileTK_WHILEParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTK_WHILE_in_ruleStmtWHILE1959);
            lv_tk_while_0_0=ruleTK_WHILE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getStmtWHILERule());
              	        }
                     		set(
                     			current, 
                     			"tk_while",
                      		lv_tk_while_0_0, 
                      		"TK_WHILE");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,30,FOLLOW_30_in_ruleStmtWHILE1971); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getStmtWHILEAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1065:1: ( (lv_log_expr_2_0= ruleLog_expr ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1066:1: (lv_log_expr_2_0= ruleLog_expr )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1066:1: (lv_log_expr_2_0= ruleLog_expr )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1067:3: lv_log_expr_2_0= ruleLog_expr
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getStmtWHILEAccess().getLog_exprLog_exprParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLog_expr_in_ruleStmtWHILE1992);
            lv_log_expr_2_0=ruleLog_expr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getStmtWHILERule());
              	        }
                     		set(
                     			current, 
                     			"log_expr",
                      		lv_log_expr_2_0, 
                      		"Log_expr");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,31,FOLLOW_31_in_ruleStmtWHILE2004); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getStmtWHILEAccess().getRightParenthesisKeyword_3());
                  
            }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1087:1: ( (lv_plan_term_4_0= rulePlan_term ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1088:1: (lv_plan_term_4_0= rulePlan_term )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1088:1: (lv_plan_term_4_0= rulePlan_term )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1089:3: lv_plan_term_4_0= rulePlan_term
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getStmtWHILEAccess().getPlan_termPlan_termParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePlan_term_in_ruleStmtWHILE2025);
            lv_plan_term_4_0=rulePlan_term();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getStmtWHILERule());
              	        }
                     		set(
                     			current, 
                     			"plan_term",
                      		lv_plan_term_4_0, 
                      		"Plan_term");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 22, ruleStmtWHILE_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleStmtWHILE"


    // $ANTLR start "entryRuleBody_formula"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1113:1: entryRuleBody_formula returns [EObject current=null] : iv_ruleBody_formula= ruleBody_formula EOF ;
    public final EObject entryRuleBody_formula() throws RecognitionException {
        EObject current = null;
        int entryRuleBody_formula_StartIndex = input.index();
        EObject iv_ruleBody_formula = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1114:2: (iv_ruleBody_formula= ruleBody_formula EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1115:2: iv_ruleBody_formula= ruleBody_formula EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBody_formulaRule()); 
            }
            pushFollow(FOLLOW_ruleBody_formula_in_entryRuleBody_formula2061);
            iv_ruleBody_formula=ruleBody_formula();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBody_formula; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBody_formula2071); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 23, entryRuleBody_formula_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleBody_formula"


    // $ANTLR start "ruleBody_formula"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1122:1: ruleBody_formula returns [EObject current=null] : ( (otherlv_0= '!' | otherlv_1= '!!' | otherlv_2= '?' | otherlv_3= '+' | (otherlv_4= '-' (otherlv_5= '+' )? ) )? ( (lv_log_expr_6_0= ruleLog_expr ) ) ) ;
    public final EObject ruleBody_formula() throws RecognitionException {
        EObject current = null;
        int ruleBody_formula_StartIndex = input.index();
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_log_expr_6_0 = null;


         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1125:28: ( ( (otherlv_0= '!' | otherlv_1= '!!' | otherlv_2= '?' | otherlv_3= '+' | (otherlv_4= '-' (otherlv_5= '+' )? ) )? ( (lv_log_expr_6_0= ruleLog_expr ) ) ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1126:1: ( (otherlv_0= '!' | otherlv_1= '!!' | otherlv_2= '?' | otherlv_3= '+' | (otherlv_4= '-' (otherlv_5= '+' )? ) )? ( (lv_log_expr_6_0= ruleLog_expr ) ) )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1126:1: ( (otherlv_0= '!' | otherlv_1= '!!' | otherlv_2= '?' | otherlv_3= '+' | (otherlv_4= '-' (otherlv_5= '+' )? ) )? ( (lv_log_expr_6_0= ruleLog_expr ) ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1126:2: (otherlv_0= '!' | otherlv_1= '!!' | otherlv_2= '?' | otherlv_3= '+' | (otherlv_4= '-' (otherlv_5= '+' )? ) )? ( (lv_log_expr_6_0= ruleLog_expr ) )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1126:2: (otherlv_0= '!' | otherlv_1= '!!' | otherlv_2= '?' | otherlv_3= '+' | (otherlv_4= '-' (otherlv_5= '+' )? ) )?
            int alt23=6;
            alt23 = dfa23.predict(input);
            switch (alt23) {
                case 1 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1126:4: otherlv_0= '!'
                    {
                    otherlv_0=(Token)match(input,22,FOLLOW_22_in_ruleBody_formula2109); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getBody_formulaAccess().getExclamationMarkKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1131:7: otherlv_1= '!!'
                    {
                    otherlv_1=(Token)match(input,32,FOLLOW_32_in_ruleBody_formula2127); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getBody_formulaAccess().getExclamationMarkExclamationMarkKeyword_0_1());
                          
                    }

                    }
                    break;
                case 3 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1136:7: otherlv_2= '?'
                    {
                    otherlv_2=(Token)match(input,28,FOLLOW_28_in_ruleBody_formula2145); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getBody_formulaAccess().getQuestionMarkKeyword_0_2());
                          
                    }

                    }
                    break;
                case 4 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1141:7: otherlv_3= '+'
                    {
                    otherlv_3=(Token)match(input,25,FOLLOW_25_in_ruleBody_formula2163); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getBody_formulaAccess().getPlusSignKeyword_0_3());
                          
                    }

                    }
                    break;
                case 5 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1146:6: (otherlv_4= '-' (otherlv_5= '+' )? )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1146:6: (otherlv_4= '-' (otherlv_5= '+' )? )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1146:8: otherlv_4= '-' (otherlv_5= '+' )?
                    {
                    otherlv_4=(Token)match(input,26,FOLLOW_26_in_ruleBody_formula2182); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getBody_formulaAccess().getHyphenMinusKeyword_0_4_0());
                          
                    }
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1150:1: (otherlv_5= '+' )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==25) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1150:3: otherlv_5= '+'
                            {
                            otherlv_5=(Token)match(input,25,FOLLOW_25_in_ruleBody_formula2195); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_5, grammarAccess.getBody_formulaAccess().getPlusSignKeyword_0_4_1());
                                  
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1154:6: ( (lv_log_expr_6_0= ruleLog_expr ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1155:1: (lv_log_expr_6_0= ruleLog_expr )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1155:1: (lv_log_expr_6_0= ruleLog_expr )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1156:3: lv_log_expr_6_0= ruleLog_expr
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getBody_formulaAccess().getLog_exprLog_exprParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLog_expr_in_ruleBody_formula2221);
            lv_log_expr_6_0=ruleLog_expr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getBody_formulaRule());
              	        }
                     		set(
                     			current, 
                     			"log_expr",
                      		lv_log_expr_6_0, 
                      		"Log_expr");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 24, ruleBody_formula_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleBody_formula"


    // $ANTLR start "entryRulePlan_term"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1180:1: entryRulePlan_term returns [EObject current=null] : iv_rulePlan_term= rulePlan_term EOF ;
    public final EObject entryRulePlan_term() throws RecognitionException {
        EObject current = null;
        int entryRulePlan_term_StartIndex = input.index();
        EObject iv_rulePlan_term = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1181:2: (iv_rulePlan_term= rulePlan_term EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1182:2: iv_rulePlan_term= rulePlan_term EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPlan_termRule()); 
            }
            pushFollow(FOLLOW_rulePlan_term_in_entryRulePlan_term2257);
            iv_rulePlan_term=rulePlan_term();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePlan_term; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePlan_term2267); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 25, entryRulePlan_term_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRulePlan_term"


    // $ANTLR start "rulePlan_term"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1189:1: rulePlan_term returns [EObject current=null] : ( () otherlv_1= '{' ( ( ( (lv_tk_label_at_2_0= RULE_TK_LABEL_AT ) ) ( (lv_pred_3_0= rulePred ) ) )? ( (lv_trigger_4_0= ruleTrigger ) ) (otherlv_5= ':' ( (lv_log_expr_6_0= ruleLog_expr ) ) )? (otherlv_7= '<-' | otherlv_8= ';' )? )? ( (lv_plan_body_9_0= rulePlan_body ) )? otherlv_10= '}' ) ;
    public final EObject rulePlan_term() throws RecognitionException {
        EObject current = null;
        int rulePlan_term_StartIndex = input.index();
        Token otherlv_1=null;
        Token lv_tk_label_at_2_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_pred_3_0 = null;

        EObject lv_trigger_4_0 = null;

        EObject lv_log_expr_6_0 = null;

        EObject lv_plan_body_9_0 = null;


         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1192:28: ( ( () otherlv_1= '{' ( ( ( (lv_tk_label_at_2_0= RULE_TK_LABEL_AT ) ) ( (lv_pred_3_0= rulePred ) ) )? ( (lv_trigger_4_0= ruleTrigger ) ) (otherlv_5= ':' ( (lv_log_expr_6_0= ruleLog_expr ) ) )? (otherlv_7= '<-' | otherlv_8= ';' )? )? ( (lv_plan_body_9_0= rulePlan_body ) )? otherlv_10= '}' ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1193:1: ( () otherlv_1= '{' ( ( ( (lv_tk_label_at_2_0= RULE_TK_LABEL_AT ) ) ( (lv_pred_3_0= rulePred ) ) )? ( (lv_trigger_4_0= ruleTrigger ) ) (otherlv_5= ':' ( (lv_log_expr_6_0= ruleLog_expr ) ) )? (otherlv_7= '<-' | otherlv_8= ';' )? )? ( (lv_plan_body_9_0= rulePlan_body ) )? otherlv_10= '}' )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1193:1: ( () otherlv_1= '{' ( ( ( (lv_tk_label_at_2_0= RULE_TK_LABEL_AT ) ) ( (lv_pred_3_0= rulePred ) ) )? ( (lv_trigger_4_0= ruleTrigger ) ) (otherlv_5= ':' ( (lv_log_expr_6_0= ruleLog_expr ) ) )? (otherlv_7= '<-' | otherlv_8= ';' )? )? ( (lv_plan_body_9_0= rulePlan_body ) )? otherlv_10= '}' )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1193:2: () otherlv_1= '{' ( ( ( (lv_tk_label_at_2_0= RULE_TK_LABEL_AT ) ) ( (lv_pred_3_0= rulePred ) ) )? ( (lv_trigger_4_0= ruleTrigger ) ) (otherlv_5= ':' ( (lv_log_expr_6_0= ruleLog_expr ) ) )? (otherlv_7= '<-' | otherlv_8= ';' )? )? ( (lv_plan_body_9_0= rulePlan_body ) )? otherlv_10= '}'
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1193:2: ()
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1194:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getPlan_termAccess().getPlan_termAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,18,FOLLOW_18_in_rulePlan_term2316); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getPlan_termAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1206:1: ( ( ( (lv_tk_label_at_2_0= RULE_TK_LABEL_AT ) ) ( (lv_pred_3_0= rulePred ) ) )? ( (lv_trigger_4_0= ruleTrigger ) ) (otherlv_5= ':' ( (lv_log_expr_6_0= ruleLog_expr ) ) )? (otherlv_7= '<-' | otherlv_8= ';' )? )?
            int alt27=2;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1206:2: ( ( (lv_tk_label_at_2_0= RULE_TK_LABEL_AT ) ) ( (lv_pred_3_0= rulePred ) ) )? ( (lv_trigger_4_0= ruleTrigger ) ) (otherlv_5= ':' ( (lv_log_expr_6_0= ruleLog_expr ) ) )? (otherlv_7= '<-' | otherlv_8= ';' )?
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1206:2: ( ( (lv_tk_label_at_2_0= RULE_TK_LABEL_AT ) ) ( (lv_pred_3_0= rulePred ) ) )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==RULE_TK_LABEL_AT) ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1206:3: ( (lv_tk_label_at_2_0= RULE_TK_LABEL_AT ) ) ( (lv_pred_3_0= rulePred ) )
                            {
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1206:3: ( (lv_tk_label_at_2_0= RULE_TK_LABEL_AT ) )
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1207:1: (lv_tk_label_at_2_0= RULE_TK_LABEL_AT )
                            {
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1207:1: (lv_tk_label_at_2_0= RULE_TK_LABEL_AT )
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1208:3: lv_tk_label_at_2_0= RULE_TK_LABEL_AT
                            {
                            lv_tk_label_at_2_0=(Token)match(input,RULE_TK_LABEL_AT,FOLLOW_RULE_TK_LABEL_AT_in_rulePlan_term2335); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_tk_label_at_2_0, grammarAccess.getPlan_termAccess().getTk_label_atTK_LABEL_ATTerminalRuleCall_2_0_0_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getPlan_termRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"tk_label_at",
                                      		lv_tk_label_at_2_0, 
                                      		"TK_LABEL_AT");
                              	    
                            }

                            }


                            }

                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1224:2: ( (lv_pred_3_0= rulePred ) )
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1225:1: (lv_pred_3_0= rulePred )
                            {
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1225:1: (lv_pred_3_0= rulePred )
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1226:3: lv_pred_3_0= rulePred
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getPlan_termAccess().getPredPredParserRuleCall_2_0_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_rulePred_in_rulePlan_term2361);
                            lv_pred_3_0=rulePred();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getPlan_termRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"pred",
                                      		lv_pred_3_0, 
                                      		"Pred");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }

                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1242:4: ( (lv_trigger_4_0= ruleTrigger ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1243:1: (lv_trigger_4_0= ruleTrigger )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1243:1: (lv_trigger_4_0= ruleTrigger )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1244:3: lv_trigger_4_0= ruleTrigger
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPlan_termAccess().getTriggerTriggerParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTrigger_in_rulePlan_term2384);
                    lv_trigger_4_0=ruleTrigger();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPlan_termRule());
                      	        }
                             		set(
                             			current, 
                             			"trigger",
                              		lv_trigger_4_0, 
                              		"Trigger");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1260:2: (otherlv_5= ':' ( (lv_log_expr_6_0= ruleLog_expr ) ) )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==23) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1260:4: otherlv_5= ':' ( (lv_log_expr_6_0= ruleLog_expr ) )
                            {
                            otherlv_5=(Token)match(input,23,FOLLOW_23_in_rulePlan_term2397); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_5, grammarAccess.getPlan_termAccess().getColonKeyword_2_2_0());
                                  
                            }
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1264:1: ( (lv_log_expr_6_0= ruleLog_expr ) )
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1265:1: (lv_log_expr_6_0= ruleLog_expr )
                            {
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1265:1: (lv_log_expr_6_0= ruleLog_expr )
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1266:3: lv_log_expr_6_0= ruleLog_expr
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getPlan_termAccess().getLog_exprLog_exprParserRuleCall_2_2_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleLog_expr_in_rulePlan_term2418);
                            lv_log_expr_6_0=ruleLog_expr();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getPlan_termRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"log_expr",
                                      		lv_log_expr_6_0, 
                                      		"Log_expr");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }

                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1282:4: (otherlv_7= '<-' | otherlv_8= ';' )?
                    int alt26=3;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==24) ) {
                        alt26=1;
                    }
                    else if ( (LA26_0==29) ) {
                        alt26=2;
                    }
                    switch (alt26) {
                        case 1 :
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1282:6: otherlv_7= '<-'
                            {
                            otherlv_7=(Token)match(input,24,FOLLOW_24_in_rulePlan_term2433); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_7, grammarAccess.getPlan_termAccess().getLessThanSignHyphenMinusKeyword_2_3_0());
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1287:7: otherlv_8= ';'
                            {
                            otherlv_8=(Token)match(input,29,FOLLOW_29_in_rulePlan_term2451); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_8, grammarAccess.getPlan_termAccess().getSemicolonKeyword_2_3_1());
                                  
                            }

                            }
                            break;

                    }


                    }
                    break;

            }

            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1291:5: ( (lv_plan_body_9_0= rulePlan_body ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( ((LA28_0>=RULE_TK_NEG && LA28_0<=RULE_ATOM)||(LA28_0>=21 && LA28_0<=22)||(LA28_0>=25 && LA28_0<=26)||LA28_0==28||LA28_0==30||LA28_0==32||(LA28_0>=48 && LA28_0<=50)||(LA28_0>=52 && LA28_0<=54)||(LA28_0>=57 && LA28_0<=58)) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1292:1: (lv_plan_body_9_0= rulePlan_body )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1292:1: (lv_plan_body_9_0= rulePlan_body )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1293:3: lv_plan_body_9_0= rulePlan_body
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPlan_termAccess().getPlan_bodyPlan_bodyParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePlan_body_in_rulePlan_term2476);
                    lv_plan_body_9_0=rulePlan_body();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPlan_termRule());
                      	        }
                             		set(
                             			current, 
                             			"plan_body",
                              		lv_plan_body_9_0, 
                              		"Plan_body");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_10=(Token)match(input,19,FOLLOW_19_in_rulePlan_term2489); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getPlan_termAccess().getRightCurlyBracketKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 26, rulePlan_term_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "rulePlan_term"


    // $ANTLR start "entryRuleLiteral"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1321:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;
        int entryRuleLiteral_StartIndex = input.index();
        EObject iv_ruleLiteral = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1322:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1323:2: iv_ruleLiteral= ruleLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral2525);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral2535); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 27, entryRuleLiteral_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1330:1: ruleLiteral returns [EObject current=null] : ( ( ( (lv_tk_neg_0_0= RULE_TK_NEG ) )? ( (lv_pred_1_0= rulePred ) ) ) | ( (lv_tk_true_2_0= ruleTK_TRUE ) ) | ( (lv_tk_false_3_0= ruleTK_FALSE ) ) ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;
        int ruleLiteral_StartIndex = input.index();
        Token lv_tk_neg_0_0=null;
        EObject lv_pred_1_0 = null;

        AntlrDatatypeRuleToken lv_tk_true_2_0 = null;

        AntlrDatatypeRuleToken lv_tk_false_3_0 = null;


         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1333:28: ( ( ( ( (lv_tk_neg_0_0= RULE_TK_NEG ) )? ( (lv_pred_1_0= rulePred ) ) ) | ( (lv_tk_true_2_0= ruleTK_TRUE ) ) | ( (lv_tk_false_3_0= ruleTK_FALSE ) ) ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1334:1: ( ( ( (lv_tk_neg_0_0= RULE_TK_NEG ) )? ( (lv_pred_1_0= rulePred ) ) ) | ( (lv_tk_true_2_0= ruleTK_TRUE ) ) | ( (lv_tk_false_3_0= ruleTK_FALSE ) ) )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1334:1: ( ( ( (lv_tk_neg_0_0= RULE_TK_NEG ) )? ( (lv_pred_1_0= rulePred ) ) ) | ( (lv_tk_true_2_0= ruleTK_TRUE ) ) | ( (lv_tk_false_3_0= ruleTK_FALSE ) ) )
            int alt30=3;
            switch ( input.LA(1) ) {
            case RULE_TK_NEG:
            case RULE_ATOM:
            case 21:
            case 48:
            case 49:
                {
                alt30=1;
                }
                break;
            case 57:
                {
                alt30=2;
                }
                break;
            case 58:
                {
                alt30=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1334:2: ( ( (lv_tk_neg_0_0= RULE_TK_NEG ) )? ( (lv_pred_1_0= rulePred ) ) )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1334:2: ( ( (lv_tk_neg_0_0= RULE_TK_NEG ) )? ( (lv_pred_1_0= rulePred ) ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1334:3: ( (lv_tk_neg_0_0= RULE_TK_NEG ) )? ( (lv_pred_1_0= rulePred ) )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1334:3: ( (lv_tk_neg_0_0= RULE_TK_NEG ) )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==RULE_TK_NEG) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1335:1: (lv_tk_neg_0_0= RULE_TK_NEG )
                            {
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1335:1: (lv_tk_neg_0_0= RULE_TK_NEG )
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1336:3: lv_tk_neg_0_0= RULE_TK_NEG
                            {
                            lv_tk_neg_0_0=(Token)match(input,RULE_TK_NEG,FOLLOW_RULE_TK_NEG_in_ruleLiteral2578); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_tk_neg_0_0, grammarAccess.getLiteralAccess().getTk_negTK_NEGTerminalRuleCall_0_0_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getLiteralRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"tk_neg",
                                      		lv_tk_neg_0_0, 
                                      		"TK_NEG");
                              	    
                            }

                            }


                            }
                            break;

                    }

                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1352:3: ( (lv_pred_1_0= rulePred ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1353:1: (lv_pred_1_0= rulePred )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1353:1: (lv_pred_1_0= rulePred )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1354:3: lv_pred_1_0= rulePred
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLiteralAccess().getPredPredParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePred_in_ruleLiteral2605);
                    lv_pred_1_0=rulePred();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLiteralRule());
                      	        }
                             		set(
                             			current, 
                             			"pred",
                              		lv_pred_1_0, 
                              		"Pred");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1371:6: ( (lv_tk_true_2_0= ruleTK_TRUE ) )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1371:6: ( (lv_tk_true_2_0= ruleTK_TRUE ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1372:1: (lv_tk_true_2_0= ruleTK_TRUE )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1372:1: (lv_tk_true_2_0= ruleTK_TRUE )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1373:3: lv_tk_true_2_0= ruleTK_TRUE
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLiteralAccess().getTk_trueTK_TRUEParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTK_TRUE_in_ruleLiteral2633);
                    lv_tk_true_2_0=ruleTK_TRUE();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLiteralRule());
                      	        }
                             		set(
                             			current, 
                             			"tk_true",
                              		lv_tk_true_2_0, 
                              		"TK_TRUE");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1390:6: ( (lv_tk_false_3_0= ruleTK_FALSE ) )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1390:6: ( (lv_tk_false_3_0= ruleTK_FALSE ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1391:1: (lv_tk_false_3_0= ruleTK_FALSE )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1391:1: (lv_tk_false_3_0= ruleTK_FALSE )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1392:3: lv_tk_false_3_0= ruleTK_FALSE
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLiteralAccess().getTk_falseTK_FALSEParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTK_FALSE_in_ruleLiteral2660);
                    lv_tk_false_3_0=ruleTK_FALSE();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLiteralRule());
                      	        }
                             		set(
                             			current, 
                             			"tk_false",
                              		lv_tk_false_3_0, 
                              		"TK_FALSE");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 28, ruleLiteral_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRulePred"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1416:1: entryRulePred returns [EObject current=null] : iv_rulePred= rulePred EOF ;
    public final EObject entryRulePred() throws RecognitionException {
        EObject current = null;
        int entryRulePred_StartIndex = input.index();
        EObject iv_rulePred = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1417:2: (iv_rulePred= rulePred EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1418:2: iv_rulePred= rulePred EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPredRule()); 
            }
            pushFollow(FOLLOW_rulePred_in_entryRulePred2696);
            iv_rulePred=rulePred();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePred; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePred2706); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 29, entryRulePred_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRulePred"


    // $ANTLR start "rulePred"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1425:1: rulePred returns [EObject current=null] : ( ( ( (lv_atom_0_0= ruleJASON_ATOM ) ) | ( (lv_tk_begin_1_0= ruleTK_BEGIN ) ) | ( (lv_tk_end_2_0= ruleTK_END ) ) ) (otherlv_3= '(' ( (lv_terms_4_0= ruleTerms ) ) otherlv_5= ')' )? ( (lv_plan_term_6_0= rulePlan_term ) )* ( (lv_list_7_0= ruleList ) )? ) ;
    public final EObject rulePred() throws RecognitionException {
        EObject current = null;
        int rulePred_StartIndex = input.index();
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_atom_0_0 = null;

        AntlrDatatypeRuleToken lv_tk_begin_1_0 = null;

        AntlrDatatypeRuleToken lv_tk_end_2_0 = null;

        EObject lv_terms_4_0 = null;

        EObject lv_plan_term_6_0 = null;

        EObject lv_list_7_0 = null;


         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1428:28: ( ( ( ( (lv_atom_0_0= ruleJASON_ATOM ) ) | ( (lv_tk_begin_1_0= ruleTK_BEGIN ) ) | ( (lv_tk_end_2_0= ruleTK_END ) ) ) (otherlv_3= '(' ( (lv_terms_4_0= ruleTerms ) ) otherlv_5= ')' )? ( (lv_plan_term_6_0= rulePlan_term ) )* ( (lv_list_7_0= ruleList ) )? ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1429:1: ( ( ( (lv_atom_0_0= ruleJASON_ATOM ) ) | ( (lv_tk_begin_1_0= ruleTK_BEGIN ) ) | ( (lv_tk_end_2_0= ruleTK_END ) ) ) (otherlv_3= '(' ( (lv_terms_4_0= ruleTerms ) ) otherlv_5= ')' )? ( (lv_plan_term_6_0= rulePlan_term ) )* ( (lv_list_7_0= ruleList ) )? )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1429:1: ( ( ( (lv_atom_0_0= ruleJASON_ATOM ) ) | ( (lv_tk_begin_1_0= ruleTK_BEGIN ) ) | ( (lv_tk_end_2_0= ruleTK_END ) ) ) (otherlv_3= '(' ( (lv_terms_4_0= ruleTerms ) ) otherlv_5= ')' )? ( (lv_plan_term_6_0= rulePlan_term ) )* ( (lv_list_7_0= ruleList ) )? )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1429:2: ( ( (lv_atom_0_0= ruleJASON_ATOM ) ) | ( (lv_tk_begin_1_0= ruleTK_BEGIN ) ) | ( (lv_tk_end_2_0= ruleTK_END ) ) ) (otherlv_3= '(' ( (lv_terms_4_0= ruleTerms ) ) otherlv_5= ')' )? ( (lv_plan_term_6_0= rulePlan_term ) )* ( (lv_list_7_0= ruleList ) )?
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1429:2: ( ( (lv_atom_0_0= ruleJASON_ATOM ) ) | ( (lv_tk_begin_1_0= ruleTK_BEGIN ) ) | ( (lv_tk_end_2_0= ruleTK_END ) ) )
            int alt31=3;
            switch ( input.LA(1) ) {
            case RULE_ATOM:
            case 21:
                {
                alt31=1;
                }
                break;
            case 48:
                {
                alt31=2;
                }
                break;
            case 49:
                {
                alt31=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1429:3: ( (lv_atom_0_0= ruleJASON_ATOM ) )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1429:3: ( (lv_atom_0_0= ruleJASON_ATOM ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1430:1: (lv_atom_0_0= ruleJASON_ATOM )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1430:1: (lv_atom_0_0= ruleJASON_ATOM )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1431:3: lv_atom_0_0= ruleJASON_ATOM
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPredAccess().getAtomJASON_ATOMParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJASON_ATOM_in_rulePred2753);
                    lv_atom_0_0=ruleJASON_ATOM();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPredRule());
                      	        }
                             		set(
                             			current, 
                             			"atom",
                              		lv_atom_0_0, 
                              		"JASON_ATOM");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1448:6: ( (lv_tk_begin_1_0= ruleTK_BEGIN ) )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1448:6: ( (lv_tk_begin_1_0= ruleTK_BEGIN ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1449:1: (lv_tk_begin_1_0= ruleTK_BEGIN )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1449:1: (lv_tk_begin_1_0= ruleTK_BEGIN )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1450:3: lv_tk_begin_1_0= ruleTK_BEGIN
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPredAccess().getTk_beginTK_BEGINParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTK_BEGIN_in_rulePred2780);
                    lv_tk_begin_1_0=ruleTK_BEGIN();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPredRule());
                      	        }
                             		set(
                             			current, 
                             			"tk_begin",
                              		lv_tk_begin_1_0, 
                              		"TK_BEGIN");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1467:6: ( (lv_tk_end_2_0= ruleTK_END ) )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1467:6: ( (lv_tk_end_2_0= ruleTK_END ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1468:1: (lv_tk_end_2_0= ruleTK_END )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1468:1: (lv_tk_end_2_0= ruleTK_END )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1469:3: lv_tk_end_2_0= ruleTK_END
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPredAccess().getTk_endTK_ENDParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTK_END_in_rulePred2807);
                    lv_tk_end_2_0=ruleTK_END();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPredRule());
                      	        }
                             		set(
                             			current, 
                             			"tk_end",
                              		lv_tk_end_2_0, 
                              		"TK_END");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1485:3: (otherlv_3= '(' ( (lv_terms_4_0= ruleTerms ) ) otherlv_5= ')' )?
            int alt32=2;
            alt32 = dfa32.predict(input);
            switch (alt32) {
                case 1 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1485:5: otherlv_3= '(' ( (lv_terms_4_0= ruleTerms ) ) otherlv_5= ')'
                    {
                    otherlv_3=(Token)match(input,30,FOLLOW_30_in_rulePred2821); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getPredAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1489:1: ( (lv_terms_4_0= ruleTerms ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1490:1: (lv_terms_4_0= ruleTerms )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1490:1: (lv_terms_4_0= ruleTerms )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1491:3: lv_terms_4_0= ruleTerms
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPredAccess().getTermsTermsParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTerms_in_rulePred2842);
                    lv_terms_4_0=ruleTerms();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPredRule());
                      	        }
                             		set(
                             			current, 
                             			"terms",
                              		lv_terms_4_0, 
                              		"Terms");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_5=(Token)match(input,31,FOLLOW_31_in_rulePred2854); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getPredAccess().getRightParenthesisKeyword_1_2());
                          
                    }

                    }
                    break;

            }

            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1511:3: ( (lv_plan_term_6_0= rulePlan_term ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==18) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1512:1: (lv_plan_term_6_0= rulePlan_term )
            	    {
            	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1512:1: (lv_plan_term_6_0= rulePlan_term )
            	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1513:3: lv_plan_term_6_0= rulePlan_term
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPredAccess().getPlan_termPlan_termParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulePlan_term_in_rulePred2877);
            	    lv_plan_term_6_0=rulePlan_term();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getPredRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"plan_term",
            	              		lv_plan_term_6_0, 
            	              		"Plan_term");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1529:3: ( (lv_list_7_0= ruleList ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==34) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1530:1: (lv_list_7_0= ruleList )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1530:1: (lv_list_7_0= ruleList )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1531:3: lv_list_7_0= ruleList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPredAccess().getListListParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleList_in_rulePred2899);
                    lv_list_7_0=ruleList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPredRule());
                      	        }
                             		set(
                             			current, 
                             			"list",
                              		lv_list_7_0, 
                              		"List");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 30, rulePred_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "rulePred"


    // $ANTLR start "entryRuleTerms"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1555:1: entryRuleTerms returns [EObject current=null] : iv_ruleTerms= ruleTerms EOF ;
    public final EObject entryRuleTerms() throws RecognitionException {
        EObject current = null;
        int entryRuleTerms_StartIndex = input.index();
        EObject iv_ruleTerms = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1556:2: (iv_ruleTerms= ruleTerms EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1557:2: iv_ruleTerms= ruleTerms EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTermsRule()); 
            }
            pushFollow(FOLLOW_ruleTerms_in_entryRuleTerms2936);
            iv_ruleTerms=ruleTerms();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTerms; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerms2946); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 31, entryRuleTerms_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleTerms"


    // $ANTLR start "ruleTerms"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1564:1: ruleTerms returns [EObject current=null] : ( ( (lv_term_0_0= ruleTerm ) ) (otherlv_1= ',' ( (lv_term_2_0= ruleTerm ) ) )* ) ;
    public final EObject ruleTerms() throws RecognitionException {
        EObject current = null;
        int ruleTerms_StartIndex = input.index();
        Token otherlv_1=null;
        EObject lv_term_0_0 = null;

        EObject lv_term_2_0 = null;


         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1567:28: ( ( ( (lv_term_0_0= ruleTerm ) ) (otherlv_1= ',' ( (lv_term_2_0= ruleTerm ) ) )* ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1568:1: ( ( (lv_term_0_0= ruleTerm ) ) (otherlv_1= ',' ( (lv_term_2_0= ruleTerm ) ) )* )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1568:1: ( ( (lv_term_0_0= ruleTerm ) ) (otherlv_1= ',' ( (lv_term_2_0= ruleTerm ) ) )* )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1568:2: ( (lv_term_0_0= ruleTerm ) ) (otherlv_1= ',' ( (lv_term_2_0= ruleTerm ) ) )*
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1568:2: ( (lv_term_0_0= ruleTerm ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1569:1: (lv_term_0_0= ruleTerm )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1569:1: (lv_term_0_0= ruleTerm )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1570:3: lv_term_0_0= ruleTerm
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTermsAccess().getTermTermParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTerm_in_ruleTerms2992);
            lv_term_0_0=ruleTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTermsRule());
              	        }
                     		add(
                     			current, 
                     			"term",
                      		lv_term_0_0, 
                      		"Term");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1586:2: (otherlv_1= ',' ( (lv_term_2_0= ruleTerm ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==33) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1586:4: otherlv_1= ',' ( (lv_term_2_0= ruleTerm ) )
            	    {
            	    otherlv_1=(Token)match(input,33,FOLLOW_33_in_ruleTerms3005); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getTermsAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1590:1: ( (lv_term_2_0= ruleTerm ) )
            	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1591:1: (lv_term_2_0= ruleTerm )
            	    {
            	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1591:1: (lv_term_2_0= ruleTerm )
            	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1592:3: lv_term_2_0= ruleTerm
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTermsAccess().getTermTermParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleTerm_in_ruleTerms3026);
            	    lv_term_2_0=ruleTerm();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTermsRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"term",
            	              		lv_term_2_0, 
            	              		"Term");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 32, ruleTerms_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleTerms"


    // $ANTLR start "entryRuleTerm"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1616:1: entryRuleTerm returns [EObject current=null] : iv_ruleTerm= ruleTerm EOF ;
    public final EObject entryRuleTerm() throws RecognitionException {
        EObject current = null;
        int entryRuleTerm_StartIndex = input.index();
        EObject iv_ruleTerm = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1617:2: (iv_ruleTerm= ruleTerm EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1618:2: iv_ruleTerm= ruleTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTermRule()); 
            }
            pushFollow(FOLLOW_ruleTerm_in_entryRuleTerm3064);
            iv_ruleTerm=ruleTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerm3074); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 33, entryRuleTerm_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleTerm"


    // $ANTLR start "ruleTerm"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1625:1: ruleTerm returns [EObject current=null] : ( ( (lv_list_0_0= ruleList ) ) | ( (lv_plan_term_1_0= rulePlan_term ) ) | ( (lv_log_expr_2_0= ruleLog_expr ) ) ) ;
    public final EObject ruleTerm() throws RecognitionException {
        EObject current = null;
        int ruleTerm_StartIndex = input.index();
        EObject lv_list_0_0 = null;

        EObject lv_plan_term_1_0 = null;

        EObject lv_log_expr_2_0 = null;


         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1628:28: ( ( ( (lv_list_0_0= ruleList ) ) | ( (lv_plan_term_1_0= rulePlan_term ) ) | ( (lv_log_expr_2_0= ruleLog_expr ) ) ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1629:1: ( ( (lv_list_0_0= ruleList ) ) | ( (lv_plan_term_1_0= rulePlan_term ) ) | ( (lv_log_expr_2_0= ruleLog_expr ) ) )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1629:1: ( ( (lv_list_0_0= ruleList ) ) | ( (lv_plan_term_1_0= rulePlan_term ) ) | ( (lv_log_expr_2_0= ruleLog_expr ) ) )
            int alt36=3;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt36=1;
                }
                break;
            case 18:
                {
                alt36=2;
                }
                break;
            case RULE_TK_NEG:
            case RULE_VART:
            case RULE_UNNAMEDVART:
            case RULE_STRINGT:
            case RULE_NUMBERT:
            case RULE_ATOM:
            case 21:
            case 26:
            case 30:
            case 48:
            case 49:
            case 54:
            case 57:
            case 58:
                {
                alt36=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1629:2: ( (lv_list_0_0= ruleList ) )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1629:2: ( (lv_list_0_0= ruleList ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1630:1: (lv_list_0_0= ruleList )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1630:1: (lv_list_0_0= ruleList )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1631:3: lv_list_0_0= ruleList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTermAccess().getListListParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleList_in_ruleTerm3120);
                    lv_list_0_0=ruleList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTermRule());
                      	        }
                             		set(
                             			current, 
                             			"list",
                              		lv_list_0_0, 
                              		"List");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1648:6: ( (lv_plan_term_1_0= rulePlan_term ) )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1648:6: ( (lv_plan_term_1_0= rulePlan_term ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1649:1: (lv_plan_term_1_0= rulePlan_term )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1649:1: (lv_plan_term_1_0= rulePlan_term )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1650:3: lv_plan_term_1_0= rulePlan_term
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTermAccess().getPlan_termPlan_termParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePlan_term_in_ruleTerm3147);
                    lv_plan_term_1_0=rulePlan_term();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTermRule());
                      	        }
                             		set(
                             			current, 
                             			"plan_term",
                              		lv_plan_term_1_0, 
                              		"Plan_term");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1667:6: ( (lv_log_expr_2_0= ruleLog_expr ) )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1667:6: ( (lv_log_expr_2_0= ruleLog_expr ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1668:1: (lv_log_expr_2_0= ruleLog_expr )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1668:1: (lv_log_expr_2_0= ruleLog_expr )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1669:3: lv_log_expr_2_0= ruleLog_expr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTermAccess().getLog_exprLog_exprParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLog_expr_in_ruleTerm3174);
                    lv_log_expr_2_0=ruleLog_expr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTermRule());
                      	        }
                             		set(
                             			current, 
                             			"log_expr",
                              		lv_log_expr_2_0, 
                              		"Log_expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 34, ruleTerm_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleTerm"


    // $ANTLR start "entryRuleList"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1693:1: entryRuleList returns [EObject current=null] : iv_ruleList= ruleList EOF ;
    public final EObject entryRuleList() throws RecognitionException {
        EObject current = null;
        int entryRuleList_StartIndex = input.index();
        EObject iv_ruleList = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1694:2: (iv_ruleList= ruleList EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1695:2: iv_ruleList= ruleList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getListRule()); 
            }
            pushFollow(FOLLOW_ruleList_in_entryRuleList3210);
            iv_ruleList=ruleList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleList; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleList3220); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 35, entryRuleList_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleList"


    // $ANTLR start "ruleList"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1702:1: ruleList returns [EObject current=null] : ( () otherlv_1= '[' ( ( (lv_term_in_list_2_0= ruleTerm_in_list ) ) (otherlv_3= ',' ( (lv_term_in_list_4_0= ruleTerm_in_list ) ) )* (otherlv_5= '|' ( ( (lv_var_6_0= RULE_VART ) ) | ( (lv_unnamedvar_7_0= RULE_UNNAMEDVART ) ) | ( (lv_list_8_0= ruleList ) ) ) )? )? otherlv_9= ']' ) ;
    public final EObject ruleList() throws RecognitionException {
        EObject current = null;
        int ruleList_StartIndex = input.index();
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token lv_var_6_0=null;
        Token lv_unnamedvar_7_0=null;
        Token otherlv_9=null;
        EObject lv_term_in_list_2_0 = null;

        EObject lv_term_in_list_4_0 = null;

        EObject lv_list_8_0 = null;


         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1705:28: ( ( () otherlv_1= '[' ( ( (lv_term_in_list_2_0= ruleTerm_in_list ) ) (otherlv_3= ',' ( (lv_term_in_list_4_0= ruleTerm_in_list ) ) )* (otherlv_5= '|' ( ( (lv_var_6_0= RULE_VART ) ) | ( (lv_unnamedvar_7_0= RULE_UNNAMEDVART ) ) | ( (lv_list_8_0= ruleList ) ) ) )? )? otherlv_9= ']' ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1706:1: ( () otherlv_1= '[' ( ( (lv_term_in_list_2_0= ruleTerm_in_list ) ) (otherlv_3= ',' ( (lv_term_in_list_4_0= ruleTerm_in_list ) ) )* (otherlv_5= '|' ( ( (lv_var_6_0= RULE_VART ) ) | ( (lv_unnamedvar_7_0= RULE_UNNAMEDVART ) ) | ( (lv_list_8_0= ruleList ) ) ) )? )? otherlv_9= ']' )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1706:1: ( () otherlv_1= '[' ( ( (lv_term_in_list_2_0= ruleTerm_in_list ) ) (otherlv_3= ',' ( (lv_term_in_list_4_0= ruleTerm_in_list ) ) )* (otherlv_5= '|' ( ( (lv_var_6_0= RULE_VART ) ) | ( (lv_unnamedvar_7_0= RULE_UNNAMEDVART ) ) | ( (lv_list_8_0= ruleList ) ) ) )? )? otherlv_9= ']' )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1706:2: () otherlv_1= '[' ( ( (lv_term_in_list_2_0= ruleTerm_in_list ) ) (otherlv_3= ',' ( (lv_term_in_list_4_0= ruleTerm_in_list ) ) )* (otherlv_5= '|' ( ( (lv_var_6_0= RULE_VART ) ) | ( (lv_unnamedvar_7_0= RULE_UNNAMEDVART ) ) | ( (lv_list_8_0= ruleList ) ) ) )? )? otherlv_9= ']'
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1706:2: ()
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1707:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getListAccess().getListAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,34,FOLLOW_34_in_ruleList3269); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getListAccess().getLeftSquareBracketKeyword_1());
                  
            }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1719:1: ( ( (lv_term_in_list_2_0= ruleTerm_in_list ) ) (otherlv_3= ',' ( (lv_term_in_list_4_0= ruleTerm_in_list ) ) )* (otherlv_5= '|' ( ( (lv_var_6_0= RULE_VART ) ) | ( (lv_unnamedvar_7_0= RULE_UNNAMEDVART ) ) | ( (lv_list_8_0= ruleList ) ) ) )? )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( ((LA40_0>=RULE_TK_NEG && LA40_0<=RULE_ATOM)||LA40_0==18||LA40_0==21||LA40_0==26||LA40_0==30||LA40_0==34||(LA40_0>=48 && LA40_0<=49)||(LA40_0>=57 && LA40_0<=58)) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1719:2: ( (lv_term_in_list_2_0= ruleTerm_in_list ) ) (otherlv_3= ',' ( (lv_term_in_list_4_0= ruleTerm_in_list ) ) )* (otherlv_5= '|' ( ( (lv_var_6_0= RULE_VART ) ) | ( (lv_unnamedvar_7_0= RULE_UNNAMEDVART ) ) | ( (lv_list_8_0= ruleList ) ) ) )?
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1719:2: ( (lv_term_in_list_2_0= ruleTerm_in_list ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1720:1: (lv_term_in_list_2_0= ruleTerm_in_list )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1720:1: (lv_term_in_list_2_0= ruleTerm_in_list )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1721:3: lv_term_in_list_2_0= ruleTerm_in_list
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getListAccess().getTerm_in_listTerm_in_listParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTerm_in_list_in_ruleList3291);
                    lv_term_in_list_2_0=ruleTerm_in_list();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getListRule());
                      	        }
                             		add(
                             			current, 
                             			"term_in_list",
                              		lv_term_in_list_2_0, 
                              		"Term_in_list");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1737:2: (otherlv_3= ',' ( (lv_term_in_list_4_0= ruleTerm_in_list ) ) )*
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==33) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1737:4: otherlv_3= ',' ( (lv_term_in_list_4_0= ruleTerm_in_list ) )
                    	    {
                    	    otherlv_3=(Token)match(input,33,FOLLOW_33_in_ruleList3304); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getListAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1741:1: ( (lv_term_in_list_4_0= ruleTerm_in_list ) )
                    	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1742:1: (lv_term_in_list_4_0= ruleTerm_in_list )
                    	    {
                    	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1742:1: (lv_term_in_list_4_0= ruleTerm_in_list )
                    	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1743:3: lv_term_in_list_4_0= ruleTerm_in_list
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getListAccess().getTerm_in_listTerm_in_listParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleTerm_in_list_in_ruleList3325);
                    	    lv_term_in_list_4_0=ruleTerm_in_list();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getListRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"term_in_list",
                    	              		lv_term_in_list_4_0, 
                    	              		"Term_in_list");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop37;
                        }
                    } while (true);

                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1759:4: (otherlv_5= '|' ( ( (lv_var_6_0= RULE_VART ) ) | ( (lv_unnamedvar_7_0= RULE_UNNAMEDVART ) ) | ( (lv_list_8_0= ruleList ) ) ) )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==35) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1759:6: otherlv_5= '|' ( ( (lv_var_6_0= RULE_VART ) ) | ( (lv_unnamedvar_7_0= RULE_UNNAMEDVART ) ) | ( (lv_list_8_0= ruleList ) ) )
                            {
                            otherlv_5=(Token)match(input,35,FOLLOW_35_in_ruleList3340); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_5, grammarAccess.getListAccess().getVerticalLineKeyword_2_2_0());
                                  
                            }
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1763:1: ( ( (lv_var_6_0= RULE_VART ) ) | ( (lv_unnamedvar_7_0= RULE_UNNAMEDVART ) ) | ( (lv_list_8_0= ruleList ) ) )
                            int alt38=3;
                            switch ( input.LA(1) ) {
                            case RULE_VART:
                                {
                                alt38=1;
                                }
                                break;
                            case RULE_UNNAMEDVART:
                                {
                                alt38=2;
                                }
                                break;
                            case 34:
                                {
                                alt38=3;
                                }
                                break;
                            default:
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 38, 0, input);

                                throw nvae;
                            }

                            switch (alt38) {
                                case 1 :
                                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1763:2: ( (lv_var_6_0= RULE_VART ) )
                                    {
                                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1763:2: ( (lv_var_6_0= RULE_VART ) )
                                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1764:1: (lv_var_6_0= RULE_VART )
                                    {
                                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1764:1: (lv_var_6_0= RULE_VART )
                                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1765:3: lv_var_6_0= RULE_VART
                                    {
                                    lv_var_6_0=(Token)match(input,RULE_VART,FOLLOW_RULE_VART_in_ruleList3358); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      			newLeafNode(lv_var_6_0, grammarAccess.getListAccess().getVarVARTTerminalRuleCall_2_2_1_0_0()); 
                                      		
                                    }
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElement(grammarAccess.getListRule());
                                      	        }
                                             		setWithLastConsumed(
                                             			current, 
                                             			"var",
                                              		lv_var_6_0, 
                                              		"VART");
                                      	    
                                    }

                                    }


                                    }


                                    }
                                    break;
                                case 2 :
                                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1782:6: ( (lv_unnamedvar_7_0= RULE_UNNAMEDVART ) )
                                    {
                                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1782:6: ( (lv_unnamedvar_7_0= RULE_UNNAMEDVART ) )
                                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1783:1: (lv_unnamedvar_7_0= RULE_UNNAMEDVART )
                                    {
                                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1783:1: (lv_unnamedvar_7_0= RULE_UNNAMEDVART )
                                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1784:3: lv_unnamedvar_7_0= RULE_UNNAMEDVART
                                    {
                                    lv_unnamedvar_7_0=(Token)match(input,RULE_UNNAMEDVART,FOLLOW_RULE_UNNAMEDVART_in_ruleList3386); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      			newLeafNode(lv_unnamedvar_7_0, grammarAccess.getListAccess().getUnnamedvarUNNAMEDVARTTerminalRuleCall_2_2_1_1_0()); 
                                      		
                                    }
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElement(grammarAccess.getListRule());
                                      	        }
                                             		setWithLastConsumed(
                                             			current, 
                                             			"unnamedvar",
                                              		lv_unnamedvar_7_0, 
                                              		"UNNAMEDVART");
                                      	    
                                    }

                                    }


                                    }


                                    }
                                    break;
                                case 3 :
                                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1801:6: ( (lv_list_8_0= ruleList ) )
                                    {
                                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1801:6: ( (lv_list_8_0= ruleList ) )
                                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1802:1: (lv_list_8_0= ruleList )
                                    {
                                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1802:1: (lv_list_8_0= ruleList )
                                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1803:3: lv_list_8_0= ruleList
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getListAccess().getListListParserRuleCall_2_2_1_2_0()); 
                                      	    
                                    }
                                    pushFollow(FOLLOW_ruleList_in_ruleList3418);
                                    lv_list_8_0=ruleList();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElementForParent(grammarAccess.getListRule());
                                      	        }
                                             		set(
                                             			current, 
                                             			"list",
                                              		lv_list_8_0, 
                                              		"List");
                                      	        afterParserOrEnumRuleCall();
                                      	    
                                    }

                                    }


                                    }


                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,36,FOLLOW_36_in_ruleList3435); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_9, grammarAccess.getListAccess().getRightSquareBracketKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 36, ruleList_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleList"


    // $ANTLR start "entryRuleTerm_in_list"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1831:1: entryRuleTerm_in_list returns [EObject current=null] : iv_ruleTerm_in_list= ruleTerm_in_list EOF ;
    public final EObject entryRuleTerm_in_list() throws RecognitionException {
        EObject current = null;
        int entryRuleTerm_in_list_StartIndex = input.index();
        EObject iv_ruleTerm_in_list = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1832:2: (iv_ruleTerm_in_list= ruleTerm_in_list EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1833:2: iv_ruleTerm_in_list= ruleTerm_in_list EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTerm_in_listRule()); 
            }
            pushFollow(FOLLOW_ruleTerm_in_list_in_entryRuleTerm_in_list3471);
            iv_ruleTerm_in_list=ruleTerm_in_list();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTerm_in_list; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerm_in_list3481); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 37, entryRuleTerm_in_list_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleTerm_in_list"


    // $ANTLR start "ruleTerm_in_list"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1840:1: ruleTerm_in_list returns [EObject current=null] : ( ( (lv_list_0_0= ruleList ) ) | ( (lv_arithm_expr_1_0= ruleArithm_expr ) ) | ( (lv_string_2_0= ruleString ) ) | ( (lv_plan_term_3_0= rulePlan_term ) ) ) ;
    public final EObject ruleTerm_in_list() throws RecognitionException {
        EObject current = null;
        int ruleTerm_in_list_StartIndex = input.index();
        EObject lv_list_0_0 = null;

        EObject lv_arithm_expr_1_0 = null;

        EObject lv_string_2_0 = null;

        EObject lv_plan_term_3_0 = null;


         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1843:28: ( ( ( (lv_list_0_0= ruleList ) ) | ( (lv_arithm_expr_1_0= ruleArithm_expr ) ) | ( (lv_string_2_0= ruleString ) ) | ( (lv_plan_term_3_0= rulePlan_term ) ) ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1844:1: ( ( (lv_list_0_0= ruleList ) ) | ( (lv_arithm_expr_1_0= ruleArithm_expr ) ) | ( (lv_string_2_0= ruleString ) ) | ( (lv_plan_term_3_0= rulePlan_term ) ) )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1844:1: ( ( (lv_list_0_0= ruleList ) ) | ( (lv_arithm_expr_1_0= ruleArithm_expr ) ) | ( (lv_string_2_0= ruleString ) ) | ( (lv_plan_term_3_0= rulePlan_term ) ) )
            int alt41=4;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt41=1;
                }
                break;
            case RULE_TK_NEG:
            case RULE_VART:
            case RULE_UNNAMEDVART:
            case RULE_NUMBERT:
            case RULE_ATOM:
            case 21:
            case 26:
            case 30:
            case 48:
            case 49:
            case 57:
            case 58:
                {
                alt41=2;
                }
                break;
            case RULE_STRINGT:
                {
                alt41=3;
                }
                break;
            case 18:
                {
                alt41=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1844:2: ( (lv_list_0_0= ruleList ) )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1844:2: ( (lv_list_0_0= ruleList ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1845:1: (lv_list_0_0= ruleList )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1845:1: (lv_list_0_0= ruleList )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1846:3: lv_list_0_0= ruleList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTerm_in_listAccess().getListListParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleList_in_ruleTerm_in_list3527);
                    lv_list_0_0=ruleList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTerm_in_listRule());
                      	        }
                             		set(
                             			current, 
                             			"list",
                              		lv_list_0_0, 
                              		"List");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1863:6: ( (lv_arithm_expr_1_0= ruleArithm_expr ) )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1863:6: ( (lv_arithm_expr_1_0= ruleArithm_expr ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1864:1: (lv_arithm_expr_1_0= ruleArithm_expr )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1864:1: (lv_arithm_expr_1_0= ruleArithm_expr )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1865:3: lv_arithm_expr_1_0= ruleArithm_expr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTerm_in_listAccess().getArithm_exprArithm_exprParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleArithm_expr_in_ruleTerm_in_list3554);
                    lv_arithm_expr_1_0=ruleArithm_expr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTerm_in_listRule());
                      	        }
                             		set(
                             			current, 
                             			"arithm_expr",
                              		lv_arithm_expr_1_0, 
                              		"Arithm_expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1882:6: ( (lv_string_2_0= ruleString ) )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1882:6: ( (lv_string_2_0= ruleString ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1883:1: (lv_string_2_0= ruleString )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1883:1: (lv_string_2_0= ruleString )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1884:3: lv_string_2_0= ruleString
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTerm_in_listAccess().getStringStringParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleString_in_ruleTerm_in_list3581);
                    lv_string_2_0=ruleString();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTerm_in_listRule());
                      	        }
                             		set(
                             			current, 
                             			"string",
                              		lv_string_2_0, 
                              		"String");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1901:6: ( (lv_plan_term_3_0= rulePlan_term ) )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1901:6: ( (lv_plan_term_3_0= rulePlan_term ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1902:1: (lv_plan_term_3_0= rulePlan_term )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1902:1: (lv_plan_term_3_0= rulePlan_term )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1903:3: lv_plan_term_3_0= rulePlan_term
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTerm_in_listAccess().getPlan_termPlan_termParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePlan_term_in_ruleTerm_in_list3608);
                    lv_plan_term_3_0=rulePlan_term();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTerm_in_listRule());
                      	        }
                             		set(
                             			current, 
                             			"plan_term",
                              		lv_plan_term_3_0, 
                              		"Plan_term");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 38, ruleTerm_in_list_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleTerm_in_list"


    // $ANTLR start "entryRuleLog_expr"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1927:1: entryRuleLog_expr returns [EObject current=null] : iv_ruleLog_expr= ruleLog_expr EOF ;
    public final EObject entryRuleLog_expr() throws RecognitionException {
        EObject current = null;
        int entryRuleLog_expr_StartIndex = input.index();
        EObject iv_ruleLog_expr = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1928:2: (iv_ruleLog_expr= ruleLog_expr EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1929:2: iv_ruleLog_expr= ruleLog_expr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLog_exprRule()); 
            }
            pushFollow(FOLLOW_ruleLog_expr_in_entryRuleLog_expr3644);
            iv_ruleLog_expr=ruleLog_expr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLog_expr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLog_expr3654); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 39, entryRuleLog_expr_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleLog_expr"


    // $ANTLR start "ruleLog_expr"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1936:1: ruleLog_expr returns [EObject current=null] : ( ( (lv_log_expr_trm_0_0= ruleLog_expr_trm ) ) (otherlv_1= '|' ( (lv_log_expr_2_0= ruleLog_expr ) ) )? ) ;
    public final EObject ruleLog_expr() throws RecognitionException {
        EObject current = null;
        int ruleLog_expr_StartIndex = input.index();
        Token otherlv_1=null;
        EObject lv_log_expr_trm_0_0 = null;

        EObject lv_log_expr_2_0 = null;


         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1939:28: ( ( ( (lv_log_expr_trm_0_0= ruleLog_expr_trm ) ) (otherlv_1= '|' ( (lv_log_expr_2_0= ruleLog_expr ) ) )? ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1940:1: ( ( (lv_log_expr_trm_0_0= ruleLog_expr_trm ) ) (otherlv_1= '|' ( (lv_log_expr_2_0= ruleLog_expr ) ) )? )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1940:1: ( ( (lv_log_expr_trm_0_0= ruleLog_expr_trm ) ) (otherlv_1= '|' ( (lv_log_expr_2_0= ruleLog_expr ) ) )? )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1940:2: ( (lv_log_expr_trm_0_0= ruleLog_expr_trm ) ) (otherlv_1= '|' ( (lv_log_expr_2_0= ruleLog_expr ) ) )?
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1940:2: ( (lv_log_expr_trm_0_0= ruleLog_expr_trm ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1941:1: (lv_log_expr_trm_0_0= ruleLog_expr_trm )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1941:1: (lv_log_expr_trm_0_0= ruleLog_expr_trm )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1942:3: lv_log_expr_trm_0_0= ruleLog_expr_trm
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLog_exprAccess().getLog_expr_trmLog_expr_trmParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLog_expr_trm_in_ruleLog_expr3700);
            lv_log_expr_trm_0_0=ruleLog_expr_trm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLog_exprRule());
              	        }
                     		set(
                     			current, 
                     			"log_expr_trm",
                      		lv_log_expr_trm_0_0, 
                      		"Log_expr_trm");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1958:2: (otherlv_1= '|' ( (lv_log_expr_2_0= ruleLog_expr ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==35) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1958:4: otherlv_1= '|' ( (lv_log_expr_2_0= ruleLog_expr ) )
                    {
                    otherlv_1=(Token)match(input,35,FOLLOW_35_in_ruleLog_expr3713); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getLog_exprAccess().getVerticalLineKeyword_1_0());
                          
                    }
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1962:1: ( (lv_log_expr_2_0= ruleLog_expr ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1963:1: (lv_log_expr_2_0= ruleLog_expr )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1963:1: (lv_log_expr_2_0= ruleLog_expr )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1964:3: lv_log_expr_2_0= ruleLog_expr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLog_exprAccess().getLog_exprLog_exprParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLog_expr_in_ruleLog_expr3734);
                    lv_log_expr_2_0=ruleLog_expr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLog_exprRule());
                      	        }
                             		set(
                             			current, 
                             			"log_expr",
                              		lv_log_expr_2_0, 
                              		"Log_expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 40, ruleLog_expr_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleLog_expr"


    // $ANTLR start "entryRuleLog_expr_trm"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1988:1: entryRuleLog_expr_trm returns [EObject current=null] : iv_ruleLog_expr_trm= ruleLog_expr_trm EOF ;
    public final EObject entryRuleLog_expr_trm() throws RecognitionException {
        EObject current = null;
        int entryRuleLog_expr_trm_StartIndex = input.index();
        EObject iv_ruleLog_expr_trm = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1989:2: (iv_ruleLog_expr_trm= ruleLog_expr_trm EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1990:2: iv_ruleLog_expr_trm= ruleLog_expr_trm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLog_expr_trmRule()); 
            }
            pushFollow(FOLLOW_ruleLog_expr_trm_in_entryRuleLog_expr_trm3772);
            iv_ruleLog_expr_trm=ruleLog_expr_trm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLog_expr_trm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLog_expr_trm3782); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 41, entryRuleLog_expr_trm_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleLog_expr_trm"


    // $ANTLR start "ruleLog_expr_trm"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1997:1: ruleLog_expr_trm returns [EObject current=null] : ( ( (lv_log_expr_factor_0_0= ruleLog_expr_factor ) ) (otherlv_1= '&' ( (lv_log_expr_trm_2_0= ruleLog_expr_trm ) ) )? ) ;
    public final EObject ruleLog_expr_trm() throws RecognitionException {
        EObject current = null;
        int ruleLog_expr_trm_StartIndex = input.index();
        Token otherlv_1=null;
        EObject lv_log_expr_factor_0_0 = null;

        EObject lv_log_expr_trm_2_0 = null;


         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 42) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2000:28: ( ( ( (lv_log_expr_factor_0_0= ruleLog_expr_factor ) ) (otherlv_1= '&' ( (lv_log_expr_trm_2_0= ruleLog_expr_trm ) ) )? ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2001:1: ( ( (lv_log_expr_factor_0_0= ruleLog_expr_factor ) ) (otherlv_1= '&' ( (lv_log_expr_trm_2_0= ruleLog_expr_trm ) ) )? )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2001:1: ( ( (lv_log_expr_factor_0_0= ruleLog_expr_factor ) ) (otherlv_1= '&' ( (lv_log_expr_trm_2_0= ruleLog_expr_trm ) ) )? )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2001:2: ( (lv_log_expr_factor_0_0= ruleLog_expr_factor ) ) (otherlv_1= '&' ( (lv_log_expr_trm_2_0= ruleLog_expr_trm ) ) )?
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2001:2: ( (lv_log_expr_factor_0_0= ruleLog_expr_factor ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2002:1: (lv_log_expr_factor_0_0= ruleLog_expr_factor )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2002:1: (lv_log_expr_factor_0_0= ruleLog_expr_factor )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2003:3: lv_log_expr_factor_0_0= ruleLog_expr_factor
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLog_expr_trmAccess().getLog_expr_factorLog_expr_factorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLog_expr_factor_in_ruleLog_expr_trm3828);
            lv_log_expr_factor_0_0=ruleLog_expr_factor();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLog_expr_trmRule());
              	        }
                     		set(
                     			current, 
                     			"log_expr_factor",
                      		lv_log_expr_factor_0_0, 
                      		"Log_expr_factor");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2019:2: (otherlv_1= '&' ( (lv_log_expr_trm_2_0= ruleLog_expr_trm ) ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==37) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2019:4: otherlv_1= '&' ( (lv_log_expr_trm_2_0= ruleLog_expr_trm ) )
                    {
                    otherlv_1=(Token)match(input,37,FOLLOW_37_in_ruleLog_expr_trm3841); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getLog_expr_trmAccess().getAmpersandKeyword_1_0());
                          
                    }
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2023:1: ( (lv_log_expr_trm_2_0= ruleLog_expr_trm ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2024:1: (lv_log_expr_trm_2_0= ruleLog_expr_trm )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2024:1: (lv_log_expr_trm_2_0= ruleLog_expr_trm )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2025:3: lv_log_expr_trm_2_0= ruleLog_expr_trm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLog_expr_trmAccess().getLog_expr_trmLog_expr_trmParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLog_expr_trm_in_ruleLog_expr_trm3862);
                    lv_log_expr_trm_2_0=ruleLog_expr_trm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLog_expr_trmRule());
                      	        }
                             		set(
                             			current, 
                             			"log_expr_trm",
                              		lv_log_expr_trm_2_0, 
                              		"Log_expr_trm");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 42, ruleLog_expr_trm_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleLog_expr_trm"


    // $ANTLR start "entryRuleLog_expr_factor"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2049:1: entryRuleLog_expr_factor returns [EObject current=null] : iv_ruleLog_expr_factor= ruleLog_expr_factor EOF ;
    public final EObject entryRuleLog_expr_factor() throws RecognitionException {
        EObject current = null;
        int entryRuleLog_expr_factor_StartIndex = input.index();
        EObject iv_ruleLog_expr_factor = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 43) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2050:2: (iv_ruleLog_expr_factor= ruleLog_expr_factor EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2051:2: iv_ruleLog_expr_factor= ruleLog_expr_factor EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLog_expr_factorRule()); 
            }
            pushFollow(FOLLOW_ruleLog_expr_factor_in_entryRuleLog_expr_factor3900);
            iv_ruleLog_expr_factor=ruleLog_expr_factor();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLog_expr_factor; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLog_expr_factor3910); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 43, entryRuleLog_expr_factor_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleLog_expr_factor"


    // $ANTLR start "ruleLog_expr_factor"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2058:1: ruleLog_expr_factor returns [EObject current=null] : ( ( ( (lv_tk_not_0_0= ruleTK_NOT ) ) ( (lv_log_expr_factor_1_0= ruleLog_expr_factor ) ) ) | ( (lv_rel_expr_2_0= ruleRel_expr ) ) ) ;
    public final EObject ruleLog_expr_factor() throws RecognitionException {
        EObject current = null;
        int ruleLog_expr_factor_StartIndex = input.index();
        AntlrDatatypeRuleToken lv_tk_not_0_0 = null;

        EObject lv_log_expr_factor_1_0 = null;

        EObject lv_rel_expr_2_0 = null;


         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 44) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2061:28: ( ( ( ( (lv_tk_not_0_0= ruleTK_NOT ) ) ( (lv_log_expr_factor_1_0= ruleLog_expr_factor ) ) ) | ( (lv_rel_expr_2_0= ruleRel_expr ) ) ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2062:1: ( ( ( (lv_tk_not_0_0= ruleTK_NOT ) ) ( (lv_log_expr_factor_1_0= ruleLog_expr_factor ) ) ) | ( (lv_rel_expr_2_0= ruleRel_expr ) ) )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2062:1: ( ( ( (lv_tk_not_0_0= ruleTK_NOT ) ) ( (lv_log_expr_factor_1_0= ruleLog_expr_factor ) ) ) | ( (lv_rel_expr_2_0= ruleRel_expr ) ) )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==54) ) {
                alt44=1;
            }
            else if ( ((LA44_0>=RULE_TK_NEG && LA44_0<=RULE_ATOM)||LA44_0==21||LA44_0==26||LA44_0==30||(LA44_0>=48 && LA44_0<=49)||(LA44_0>=57 && LA44_0<=58)) ) {
                alt44=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2062:2: ( ( (lv_tk_not_0_0= ruleTK_NOT ) ) ( (lv_log_expr_factor_1_0= ruleLog_expr_factor ) ) )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2062:2: ( ( (lv_tk_not_0_0= ruleTK_NOT ) ) ( (lv_log_expr_factor_1_0= ruleLog_expr_factor ) ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2062:3: ( (lv_tk_not_0_0= ruleTK_NOT ) ) ( (lv_log_expr_factor_1_0= ruleLog_expr_factor ) )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2062:3: ( (lv_tk_not_0_0= ruleTK_NOT ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2063:1: (lv_tk_not_0_0= ruleTK_NOT )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2063:1: (lv_tk_not_0_0= ruleTK_NOT )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2064:3: lv_tk_not_0_0= ruleTK_NOT
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLog_expr_factorAccess().getTk_notTK_NOTParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTK_NOT_in_ruleLog_expr_factor3957);
                    lv_tk_not_0_0=ruleTK_NOT();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLog_expr_factorRule());
                      	        }
                             		set(
                             			current, 
                             			"tk_not",
                              		lv_tk_not_0_0, 
                              		"TK_NOT");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2080:2: ( (lv_log_expr_factor_1_0= ruleLog_expr_factor ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2081:1: (lv_log_expr_factor_1_0= ruleLog_expr_factor )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2081:1: (lv_log_expr_factor_1_0= ruleLog_expr_factor )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2082:3: lv_log_expr_factor_1_0= ruleLog_expr_factor
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLog_expr_factorAccess().getLog_expr_factorLog_expr_factorParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLog_expr_factor_in_ruleLog_expr_factor3978);
                    lv_log_expr_factor_1_0=ruleLog_expr_factor();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLog_expr_factorRule());
                      	        }
                             		set(
                             			current, 
                             			"log_expr_factor",
                              		lv_log_expr_factor_1_0, 
                              		"Log_expr_factor");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2099:6: ( (lv_rel_expr_2_0= ruleRel_expr ) )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2099:6: ( (lv_rel_expr_2_0= ruleRel_expr ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2100:1: (lv_rel_expr_2_0= ruleRel_expr )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2100:1: (lv_rel_expr_2_0= ruleRel_expr )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2101:3: lv_rel_expr_2_0= ruleRel_expr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLog_expr_factorAccess().getRel_exprRel_exprParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRel_expr_in_ruleLog_expr_factor4006);
                    lv_rel_expr_2_0=ruleRel_expr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLog_expr_factorRule());
                      	        }
                             		set(
                             			current, 
                             			"rel_expr",
                              		lv_rel_expr_2_0, 
                              		"Rel_expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 44, ruleLog_expr_factor_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleLog_expr_factor"


    // $ANTLR start "entryRuleRel_expr"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2125:1: entryRuleRel_expr returns [EObject current=null] : iv_ruleRel_expr= ruleRel_expr EOF ;
    public final EObject entryRuleRel_expr() throws RecognitionException {
        EObject current = null;
        int entryRuleRel_expr_StartIndex = input.index();
        EObject iv_ruleRel_expr = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 45) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2126:2: (iv_ruleRel_expr= ruleRel_expr EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2127:2: iv_ruleRel_expr= ruleRel_expr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRel_exprRule()); 
            }
            pushFollow(FOLLOW_ruleRel_expr_in_entryRuleRel_expr4042);
            iv_ruleRel_expr=ruleRel_expr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRel_expr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRel_expr4052); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 45, entryRuleRel_expr_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleRel_expr"


    // $ANTLR start "ruleRel_expr"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2134:1: ruleRel_expr returns [EObject current=null] : ( ( ( (lv_arithm_exp_0_0= ruleArithm_expr ) ) | ( (lv_string_1_0= ruleString ) ) ) ( ( (lv_relOp_2_0= ruleTK_REL_OP ) ) ( ( (lv_arithm_expr_3_0= ruleArithm_expr ) ) | ( (lv_string2_4_0= ruleString ) ) | ( (lv_list_5_0= ruleList ) ) | ( (lv_plan_term_6_0= rulePlan_term ) ) ) )? ) ;
    public final EObject ruleRel_expr() throws RecognitionException {
        EObject current = null;
        int ruleRel_expr_StartIndex = input.index();
        EObject lv_arithm_exp_0_0 = null;

        EObject lv_string_1_0 = null;

        AntlrDatatypeRuleToken lv_relOp_2_0 = null;

        EObject lv_arithm_expr_3_0 = null;

        EObject lv_string2_4_0 = null;

        EObject lv_list_5_0 = null;

        EObject lv_plan_term_6_0 = null;


         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 46) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2137:28: ( ( ( ( (lv_arithm_exp_0_0= ruleArithm_expr ) ) | ( (lv_string_1_0= ruleString ) ) ) ( ( (lv_relOp_2_0= ruleTK_REL_OP ) ) ( ( (lv_arithm_expr_3_0= ruleArithm_expr ) ) | ( (lv_string2_4_0= ruleString ) ) | ( (lv_list_5_0= ruleList ) ) | ( (lv_plan_term_6_0= rulePlan_term ) ) ) )? ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2138:1: ( ( ( (lv_arithm_exp_0_0= ruleArithm_expr ) ) | ( (lv_string_1_0= ruleString ) ) ) ( ( (lv_relOp_2_0= ruleTK_REL_OP ) ) ( ( (lv_arithm_expr_3_0= ruleArithm_expr ) ) | ( (lv_string2_4_0= ruleString ) ) | ( (lv_list_5_0= ruleList ) ) | ( (lv_plan_term_6_0= rulePlan_term ) ) ) )? )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2138:1: ( ( ( (lv_arithm_exp_0_0= ruleArithm_expr ) ) | ( (lv_string_1_0= ruleString ) ) ) ( ( (lv_relOp_2_0= ruleTK_REL_OP ) ) ( ( (lv_arithm_expr_3_0= ruleArithm_expr ) ) | ( (lv_string2_4_0= ruleString ) ) | ( (lv_list_5_0= ruleList ) ) | ( (lv_plan_term_6_0= rulePlan_term ) ) ) )? )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2138:2: ( ( (lv_arithm_exp_0_0= ruleArithm_expr ) ) | ( (lv_string_1_0= ruleString ) ) ) ( ( (lv_relOp_2_0= ruleTK_REL_OP ) ) ( ( (lv_arithm_expr_3_0= ruleArithm_expr ) ) | ( (lv_string2_4_0= ruleString ) ) | ( (lv_list_5_0= ruleList ) ) | ( (lv_plan_term_6_0= rulePlan_term ) ) ) )?
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2138:2: ( ( (lv_arithm_exp_0_0= ruleArithm_expr ) ) | ( (lv_string_1_0= ruleString ) ) )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( ((LA45_0>=RULE_TK_NEG && LA45_0<=RULE_UNNAMEDVART)||(LA45_0>=RULE_NUMBERT && LA45_0<=RULE_ATOM)||LA45_0==21||LA45_0==26||LA45_0==30||(LA45_0>=48 && LA45_0<=49)||(LA45_0>=57 && LA45_0<=58)) ) {
                alt45=1;
            }
            else if ( (LA45_0==RULE_STRINGT) ) {
                alt45=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2138:3: ( (lv_arithm_exp_0_0= ruleArithm_expr ) )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2138:3: ( (lv_arithm_exp_0_0= ruleArithm_expr ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2139:1: (lv_arithm_exp_0_0= ruleArithm_expr )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2139:1: (lv_arithm_exp_0_0= ruleArithm_expr )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2140:3: lv_arithm_exp_0_0= ruleArithm_expr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRel_exprAccess().getArithm_expArithm_exprParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleArithm_expr_in_ruleRel_expr4099);
                    lv_arithm_exp_0_0=ruleArithm_expr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRel_exprRule());
                      	        }
                             		set(
                             			current, 
                             			"arithm_exp",
                              		lv_arithm_exp_0_0, 
                              		"Arithm_expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2157:6: ( (lv_string_1_0= ruleString ) )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2157:6: ( (lv_string_1_0= ruleString ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2158:1: (lv_string_1_0= ruleString )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2158:1: (lv_string_1_0= ruleString )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2159:3: lv_string_1_0= ruleString
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRel_exprAccess().getStringStringParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleString_in_ruleRel_expr4126);
                    lv_string_1_0=ruleString();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRel_exprRule());
                      	        }
                             		set(
                             			current, 
                             			"string",
                              		lv_string_1_0, 
                              		"String");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2175:3: ( ( (lv_relOp_2_0= ruleTK_REL_OP ) ) ( ( (lv_arithm_expr_3_0= ruleArithm_expr ) ) | ( (lv_string2_4_0= ruleString ) ) | ( (lv_list_5_0= ruleList ) ) | ( (lv_plan_term_6_0= rulePlan_term ) ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( ((LA47_0>=38 && LA47_0<=44)) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2175:4: ( (lv_relOp_2_0= ruleTK_REL_OP ) ) ( ( (lv_arithm_expr_3_0= ruleArithm_expr ) ) | ( (lv_string2_4_0= ruleString ) ) | ( (lv_list_5_0= ruleList ) ) | ( (lv_plan_term_6_0= rulePlan_term ) ) )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2175:4: ( (lv_relOp_2_0= ruleTK_REL_OP ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2176:1: (lv_relOp_2_0= ruleTK_REL_OP )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2176:1: (lv_relOp_2_0= ruleTK_REL_OP )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2177:3: lv_relOp_2_0= ruleTK_REL_OP
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRel_exprAccess().getRelOpTK_REL_OPParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTK_REL_OP_in_ruleRel_expr4149);
                    lv_relOp_2_0=ruleTK_REL_OP();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRel_exprRule());
                      	        }
                             		set(
                             			current, 
                             			"relOp",
                              		lv_relOp_2_0, 
                              		"TK_REL_OP");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2193:2: ( ( (lv_arithm_expr_3_0= ruleArithm_expr ) ) | ( (lv_string2_4_0= ruleString ) ) | ( (lv_list_5_0= ruleList ) ) | ( (lv_plan_term_6_0= rulePlan_term ) ) )
                    int alt46=4;
                    switch ( input.LA(1) ) {
                    case RULE_TK_NEG:
                    case RULE_VART:
                    case RULE_UNNAMEDVART:
                    case RULE_NUMBERT:
                    case RULE_ATOM:
                    case 21:
                    case 26:
                    case 30:
                    case 48:
                    case 49:
                    case 57:
                    case 58:
                        {
                        alt46=1;
                        }
                        break;
                    case RULE_STRINGT:
                        {
                        alt46=2;
                        }
                        break;
                    case 34:
                        {
                        alt46=3;
                        }
                        break;
                    case 18:
                        {
                        alt46=4;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 46, 0, input);

                        throw nvae;
                    }

                    switch (alt46) {
                        case 1 :
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2193:3: ( (lv_arithm_expr_3_0= ruleArithm_expr ) )
                            {
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2193:3: ( (lv_arithm_expr_3_0= ruleArithm_expr ) )
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2194:1: (lv_arithm_expr_3_0= ruleArithm_expr )
                            {
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2194:1: (lv_arithm_expr_3_0= ruleArithm_expr )
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2195:3: lv_arithm_expr_3_0= ruleArithm_expr
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getRel_exprAccess().getArithm_exprArithm_exprParserRuleCall_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleArithm_expr_in_ruleRel_expr4171);
                            lv_arithm_expr_3_0=ruleArithm_expr();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getRel_exprRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"arithm_expr",
                                      		lv_arithm_expr_3_0, 
                                      		"Arithm_expr");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2212:6: ( (lv_string2_4_0= ruleString ) )
                            {
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2212:6: ( (lv_string2_4_0= ruleString ) )
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2213:1: (lv_string2_4_0= ruleString )
                            {
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2213:1: (lv_string2_4_0= ruleString )
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2214:3: lv_string2_4_0= ruleString
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getRel_exprAccess().getString2StringParserRuleCall_1_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleString_in_ruleRel_expr4198);
                            lv_string2_4_0=ruleString();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getRel_exprRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"string2",
                                      		lv_string2_4_0, 
                                      		"String");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 3 :
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2231:6: ( (lv_list_5_0= ruleList ) )
                            {
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2231:6: ( (lv_list_5_0= ruleList ) )
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2232:1: (lv_list_5_0= ruleList )
                            {
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2232:1: (lv_list_5_0= ruleList )
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2233:3: lv_list_5_0= ruleList
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getRel_exprAccess().getListListParserRuleCall_1_1_2_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleList_in_ruleRel_expr4225);
                            lv_list_5_0=ruleList();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getRel_exprRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"list",
                                      		lv_list_5_0, 
                                      		"List");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 4 :
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2250:6: ( (lv_plan_term_6_0= rulePlan_term ) )
                            {
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2250:6: ( (lv_plan_term_6_0= rulePlan_term ) )
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2251:1: (lv_plan_term_6_0= rulePlan_term )
                            {
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2251:1: (lv_plan_term_6_0= rulePlan_term )
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2252:3: lv_plan_term_6_0= rulePlan_term
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getRel_exprAccess().getPlan_termPlan_termParserRuleCall_1_1_3_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_rulePlan_term_in_ruleRel_expr4252);
                            lv_plan_term_6_0=rulePlan_term();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getRel_exprRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"plan_term",
                                      		lv_plan_term_6_0, 
                                      		"Plan_term");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 46, ruleRel_expr_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleRel_expr"


    // $ANTLR start "entryRuleTK_REL_OP"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2276:1: entryRuleTK_REL_OP returns [String current=null] : iv_ruleTK_REL_OP= ruleTK_REL_OP EOF ;
    public final String entryRuleTK_REL_OP() throws RecognitionException {
        String current = null;
        int entryRuleTK_REL_OP_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_ruleTK_REL_OP = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 47) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2280:2: (iv_ruleTK_REL_OP= ruleTK_REL_OP EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2281:2: iv_ruleTK_REL_OP= ruleTK_REL_OP EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTK_REL_OPRule()); 
            }
            pushFollow(FOLLOW_ruleTK_REL_OP_in_entryRuleTK_REL_OP4298);
            iv_ruleTK_REL_OP=ruleTK_REL_OP();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTK_REL_OP.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTK_REL_OP4309); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 47, entryRuleTK_REL_OP_StartIndex); }

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleTK_REL_OP"


    // $ANTLR start "ruleTK_REL_OP"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2291:1: ruleTK_REL_OP returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '<' | kw= '<=' | kw= '>' | kw= '>=' | kw= '==' | kw= '\\\\==' | (kw= '=' (kw= '.' kw= '.' )? ) ) ;
    public final AntlrDatatypeRuleToken ruleTK_REL_OP() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        int ruleTK_REL_OP_StartIndex = input.index();
        Token kw=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 48) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2295:28: ( (kw= '<' | kw= '<=' | kw= '>' | kw= '>=' | kw= '==' | kw= '\\\\==' | (kw= '=' (kw= '.' kw= '.' )? ) ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2296:1: (kw= '<' | kw= '<=' | kw= '>' | kw= '>=' | kw= '==' | kw= '\\\\==' | (kw= '=' (kw= '.' kw= '.' )? ) )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2296:1: (kw= '<' | kw= '<=' | kw= '>' | kw= '>=' | kw= '==' | kw= '\\\\==' | (kw= '=' (kw= '.' kw= '.' )? ) )
            int alt49=7;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt49=1;
                }
                break;
            case 39:
                {
                alt49=2;
                }
                break;
            case 40:
                {
                alt49=3;
                }
                break;
            case 41:
                {
                alt49=4;
                }
                break;
            case 42:
                {
                alt49=5;
                }
                break;
            case 43:
                {
                alt49=6;
                }
                break;
            case 44:
                {
                alt49=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2297:2: kw= '<'
                    {
                    kw=(Token)match(input,38,FOLLOW_38_in_ruleTK_REL_OP4351); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getTK_REL_OPAccess().getLessThanSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2304:2: kw= '<='
                    {
                    kw=(Token)match(input,39,FOLLOW_39_in_ruleTK_REL_OP4370); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getTK_REL_OPAccess().getLessThanSignEqualsSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2311:2: kw= '>'
                    {
                    kw=(Token)match(input,40,FOLLOW_40_in_ruleTK_REL_OP4389); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getTK_REL_OPAccess().getGreaterThanSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2318:2: kw= '>='
                    {
                    kw=(Token)match(input,41,FOLLOW_41_in_ruleTK_REL_OP4408); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getTK_REL_OPAccess().getGreaterThanSignEqualsSignKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2325:2: kw= '=='
                    {
                    kw=(Token)match(input,42,FOLLOW_42_in_ruleTK_REL_OP4427); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getTK_REL_OPAccess().getEqualsSignEqualsSignKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2332:2: kw= '\\\\=='
                    {
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleTK_REL_OP4446); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getTK_REL_OPAccess().getReverseSolidusEqualsSignEqualsSignKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2338:6: (kw= '=' (kw= '.' kw= '.' )? )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2338:6: (kw= '=' (kw= '.' kw= '.' )? )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2339:2: kw= '=' (kw= '.' kw= '.' )?
                    {
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleTK_REL_OP4466); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getTK_REL_OPAccess().getEqualsSignKeyword_6_0()); 
                          
                    }
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2344:1: (kw= '.' kw= '.' )?
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( (LA48_0==21) ) {
                        int LA48_1 = input.LA(2);

                        if ( (LA48_1==21) ) {
                            alt48=1;
                        }
                    }
                    switch (alt48) {
                        case 1 :
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2345:2: kw= '.' kw= '.'
                            {
                            kw=(Token)match(input,21,FOLLOW_21_in_ruleTK_REL_OP4480); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getTK_REL_OPAccess().getFullStopKeyword_6_1_0()); 
                                  
                            }
                            kw=(Token)match(input,21,FOLLOW_21_in_ruleTK_REL_OP4493); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getTK_REL_OPAccess().getFullStopKeyword_6_1_1()); 
                                  
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 48, ruleTK_REL_OP_StartIndex); }

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleTK_REL_OP"


    // $ANTLR start "entryRuleArithm_expr"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2367:1: entryRuleArithm_expr returns [EObject current=null] : iv_ruleArithm_expr= ruleArithm_expr EOF ;
    public final EObject entryRuleArithm_expr() throws RecognitionException {
        EObject current = null;
        int entryRuleArithm_expr_StartIndex = input.index();
        EObject iv_ruleArithm_expr = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 49) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2368:2: (iv_ruleArithm_expr= ruleArithm_expr EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2369:2: iv_ruleArithm_expr= ruleArithm_expr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArithm_exprRule()); 
            }
            pushFollow(FOLLOW_ruleArithm_expr_in_entryRuleArithm_expr4540);
            iv_ruleArithm_expr=ruleArithm_expr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArithm_expr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleArithm_expr4550); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 49, entryRuleArithm_expr_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleArithm_expr"


    // $ANTLR start "ruleArithm_expr"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2376:1: ruleArithm_expr returns [EObject current=null] : ( ( (lv_arithm_expr_trm_0_0= ruleArithm_expr_trm ) ) ( ( (lv_subadd_1_0= ruleTK_SUB_ADD ) ) ( (lv_arithm_expr_2_0= ruleArithm_expr ) ) )? ) ;
    public final EObject ruleArithm_expr() throws RecognitionException {
        EObject current = null;
        int ruleArithm_expr_StartIndex = input.index();
        EObject lv_arithm_expr_trm_0_0 = null;

        AntlrDatatypeRuleToken lv_subadd_1_0 = null;

        EObject lv_arithm_expr_2_0 = null;


         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 50) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2379:28: ( ( ( (lv_arithm_expr_trm_0_0= ruleArithm_expr_trm ) ) ( ( (lv_subadd_1_0= ruleTK_SUB_ADD ) ) ( (lv_arithm_expr_2_0= ruleArithm_expr ) ) )? ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2380:1: ( ( (lv_arithm_expr_trm_0_0= ruleArithm_expr_trm ) ) ( ( (lv_subadd_1_0= ruleTK_SUB_ADD ) ) ( (lv_arithm_expr_2_0= ruleArithm_expr ) ) )? )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2380:1: ( ( (lv_arithm_expr_trm_0_0= ruleArithm_expr_trm ) ) ( ( (lv_subadd_1_0= ruleTK_SUB_ADD ) ) ( (lv_arithm_expr_2_0= ruleArithm_expr ) ) )? )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2380:2: ( (lv_arithm_expr_trm_0_0= ruleArithm_expr_trm ) ) ( ( (lv_subadd_1_0= ruleTK_SUB_ADD ) ) ( (lv_arithm_expr_2_0= ruleArithm_expr ) ) )?
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2380:2: ( (lv_arithm_expr_trm_0_0= ruleArithm_expr_trm ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2381:1: (lv_arithm_expr_trm_0_0= ruleArithm_expr_trm )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2381:1: (lv_arithm_expr_trm_0_0= ruleArithm_expr_trm )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2382:3: lv_arithm_expr_trm_0_0= ruleArithm_expr_trm
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getArithm_exprAccess().getArithm_expr_trmArithm_expr_trmParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleArithm_expr_trm_in_ruleArithm_expr4596);
            lv_arithm_expr_trm_0_0=ruleArithm_expr_trm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getArithm_exprRule());
              	        }
                     		set(
                     			current, 
                     			"arithm_expr_trm",
                      		lv_arithm_expr_trm_0_0, 
                      		"Arithm_expr_trm");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2398:2: ( ( (lv_subadd_1_0= ruleTK_SUB_ADD ) ) ( (lv_arithm_expr_2_0= ruleArithm_expr ) ) )?
            int alt50=2;
            alt50 = dfa50.predict(input);
            switch (alt50) {
                case 1 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2398:3: ( (lv_subadd_1_0= ruleTK_SUB_ADD ) ) ( (lv_arithm_expr_2_0= ruleArithm_expr ) )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2398:3: ( (lv_subadd_1_0= ruleTK_SUB_ADD ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2399:1: (lv_subadd_1_0= ruleTK_SUB_ADD )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2399:1: (lv_subadd_1_0= ruleTK_SUB_ADD )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2400:3: lv_subadd_1_0= ruleTK_SUB_ADD
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getArithm_exprAccess().getSubaddTK_SUB_ADDParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTK_SUB_ADD_in_ruleArithm_expr4618);
                    lv_subadd_1_0=ruleTK_SUB_ADD();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getArithm_exprRule());
                      	        }
                             		set(
                             			current, 
                             			"subadd",
                              		lv_subadd_1_0, 
                              		"TK_SUB_ADD");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2416:2: ( (lv_arithm_expr_2_0= ruleArithm_expr ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2417:1: (lv_arithm_expr_2_0= ruleArithm_expr )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2417:1: (lv_arithm_expr_2_0= ruleArithm_expr )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2418:3: lv_arithm_expr_2_0= ruleArithm_expr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getArithm_exprAccess().getArithm_exprArithm_exprParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleArithm_expr_in_ruleArithm_expr4639);
                    lv_arithm_expr_2_0=ruleArithm_expr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getArithm_exprRule());
                      	        }
                             		set(
                             			current, 
                             			"arithm_expr",
                              		lv_arithm_expr_2_0, 
                              		"Arithm_expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 50, ruleArithm_expr_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleArithm_expr"


    // $ANTLR start "entryRuleTK_SUB_ADD"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2442:1: entryRuleTK_SUB_ADD returns [String current=null] : iv_ruleTK_SUB_ADD= ruleTK_SUB_ADD EOF ;
    public final String entryRuleTK_SUB_ADD() throws RecognitionException {
        String current = null;
        int entryRuleTK_SUB_ADD_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_ruleTK_SUB_ADD = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 51) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2443:2: (iv_ruleTK_SUB_ADD= ruleTK_SUB_ADD EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2444:2: iv_ruleTK_SUB_ADD= ruleTK_SUB_ADD EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTK_SUB_ADDRule()); 
            }
            pushFollow(FOLLOW_ruleTK_SUB_ADD_in_entryRuleTK_SUB_ADD4678);
            iv_ruleTK_SUB_ADD=ruleTK_SUB_ADD();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTK_SUB_ADD.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTK_SUB_ADD4689); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 51, entryRuleTK_SUB_ADD_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleTK_SUB_ADD"


    // $ANTLR start "ruleTK_SUB_ADD"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2451:1: ruleTK_SUB_ADD returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleTK_SUB_ADD() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        int ruleTK_SUB_ADD_StartIndex = input.index();
        Token kw=null;

         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 52) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2454:28: ( (kw= '+' | kw= '-' ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2455:1: (kw= '+' | kw= '-' )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2455:1: (kw= '+' | kw= '-' )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==25) ) {
                alt51=1;
            }
            else if ( (LA51_0==26) ) {
                alt51=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2456:2: kw= '+'
                    {
                    kw=(Token)match(input,25,FOLLOW_25_in_ruleTK_SUB_ADD4727); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getTK_SUB_ADDAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2463:2: kw= '-'
                    {
                    kw=(Token)match(input,26,FOLLOW_26_in_ruleTK_SUB_ADD4746); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getTK_SUB_ADDAccess().getHyphenMinusKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 52, ruleTK_SUB_ADD_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleTK_SUB_ADD"


    // $ANTLR start "entryRuleArithm_expr_trm"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2476:1: entryRuleArithm_expr_trm returns [EObject current=null] : iv_ruleArithm_expr_trm= ruleArithm_expr_trm EOF ;
    public final EObject entryRuleArithm_expr_trm() throws RecognitionException {
        EObject current = null;
        int entryRuleArithm_expr_trm_StartIndex = input.index();
        EObject iv_ruleArithm_expr_trm = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 53) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2477:2: (iv_ruleArithm_expr_trm= ruleArithm_expr_trm EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2478:2: iv_ruleArithm_expr_trm= ruleArithm_expr_trm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArithm_expr_trmRule()); 
            }
            pushFollow(FOLLOW_ruleArithm_expr_trm_in_entryRuleArithm_expr_trm4786);
            iv_ruleArithm_expr_trm=ruleArithm_expr_trm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArithm_expr_trm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleArithm_expr_trm4796); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 53, entryRuleArithm_expr_trm_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleArithm_expr_trm"


    // $ANTLR start "ruleArithm_expr_trm"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2485:1: ruleArithm_expr_trm returns [EObject current=null] : ( ( (lv_arithm_expr_factor_0_0= ruleArithm_expr_factor ) ) ( ( ( (lv_muldiv_1_0= ruleTK_MUL_DIV ) ) | ( (lv_tk_intdiv_2_0= ruleTK_INTDIV ) ) | ( (lv_tk_intmod_3_0= ruleTK_INTMOD ) ) ) ( (lv_arithm_expr_trm_4_0= ruleArithm_expr_trm ) ) )? ) ;
    public final EObject ruleArithm_expr_trm() throws RecognitionException {
        EObject current = null;
        int ruleArithm_expr_trm_StartIndex = input.index();
        EObject lv_arithm_expr_factor_0_0 = null;

        AntlrDatatypeRuleToken lv_muldiv_1_0 = null;

        AntlrDatatypeRuleToken lv_tk_intdiv_2_0 = null;

        AntlrDatatypeRuleToken lv_tk_intmod_3_0 = null;

        EObject lv_arithm_expr_trm_4_0 = null;


         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 54) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2488:28: ( ( ( (lv_arithm_expr_factor_0_0= ruleArithm_expr_factor ) ) ( ( ( (lv_muldiv_1_0= ruleTK_MUL_DIV ) ) | ( (lv_tk_intdiv_2_0= ruleTK_INTDIV ) ) | ( (lv_tk_intmod_3_0= ruleTK_INTMOD ) ) ) ( (lv_arithm_expr_trm_4_0= ruleArithm_expr_trm ) ) )? ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2489:1: ( ( (lv_arithm_expr_factor_0_0= ruleArithm_expr_factor ) ) ( ( ( (lv_muldiv_1_0= ruleTK_MUL_DIV ) ) | ( (lv_tk_intdiv_2_0= ruleTK_INTDIV ) ) | ( (lv_tk_intmod_3_0= ruleTK_INTMOD ) ) ) ( (lv_arithm_expr_trm_4_0= ruleArithm_expr_trm ) ) )? )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2489:1: ( ( (lv_arithm_expr_factor_0_0= ruleArithm_expr_factor ) ) ( ( ( (lv_muldiv_1_0= ruleTK_MUL_DIV ) ) | ( (lv_tk_intdiv_2_0= ruleTK_INTDIV ) ) | ( (lv_tk_intmod_3_0= ruleTK_INTMOD ) ) ) ( (lv_arithm_expr_trm_4_0= ruleArithm_expr_trm ) ) )? )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2489:2: ( (lv_arithm_expr_factor_0_0= ruleArithm_expr_factor ) ) ( ( ( (lv_muldiv_1_0= ruleTK_MUL_DIV ) ) | ( (lv_tk_intdiv_2_0= ruleTK_INTDIV ) ) | ( (lv_tk_intmod_3_0= ruleTK_INTMOD ) ) ) ( (lv_arithm_expr_trm_4_0= ruleArithm_expr_trm ) ) )?
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2489:2: ( (lv_arithm_expr_factor_0_0= ruleArithm_expr_factor ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2490:1: (lv_arithm_expr_factor_0_0= ruleArithm_expr_factor )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2490:1: (lv_arithm_expr_factor_0_0= ruleArithm_expr_factor )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2491:3: lv_arithm_expr_factor_0_0= ruleArithm_expr_factor
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getArithm_expr_trmAccess().getArithm_expr_factorArithm_expr_factorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleArithm_expr_factor_in_ruleArithm_expr_trm4842);
            lv_arithm_expr_factor_0_0=ruleArithm_expr_factor();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getArithm_expr_trmRule());
              	        }
                     		set(
                     			current, 
                     			"arithm_expr_factor",
                      		lv_arithm_expr_factor_0_0, 
                      		"Arithm_expr_factor");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2507:2: ( ( ( (lv_muldiv_1_0= ruleTK_MUL_DIV ) ) | ( (lv_tk_intdiv_2_0= ruleTK_INTDIV ) ) | ( (lv_tk_intmod_3_0= ruleTK_INTMOD ) ) ) ( (lv_arithm_expr_trm_4_0= ruleArithm_expr_trm ) ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( ((LA53_0>=45 && LA53_0<=46)||(LA53_0>=55 && LA53_0<=56)) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2507:3: ( ( (lv_muldiv_1_0= ruleTK_MUL_DIV ) ) | ( (lv_tk_intdiv_2_0= ruleTK_INTDIV ) ) | ( (lv_tk_intmod_3_0= ruleTK_INTMOD ) ) ) ( (lv_arithm_expr_trm_4_0= ruleArithm_expr_trm ) )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2507:3: ( ( (lv_muldiv_1_0= ruleTK_MUL_DIV ) ) | ( (lv_tk_intdiv_2_0= ruleTK_INTDIV ) ) | ( (lv_tk_intmod_3_0= ruleTK_INTMOD ) ) )
                    int alt52=3;
                    switch ( input.LA(1) ) {
                    case 45:
                    case 46:
                        {
                        alt52=1;
                        }
                        break;
                    case 55:
                        {
                        alt52=2;
                        }
                        break;
                    case 56:
                        {
                        alt52=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 52, 0, input);

                        throw nvae;
                    }

                    switch (alt52) {
                        case 1 :
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2507:4: ( (lv_muldiv_1_0= ruleTK_MUL_DIV ) )
                            {
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2507:4: ( (lv_muldiv_1_0= ruleTK_MUL_DIV ) )
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2508:1: (lv_muldiv_1_0= ruleTK_MUL_DIV )
                            {
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2508:1: (lv_muldiv_1_0= ruleTK_MUL_DIV )
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2509:3: lv_muldiv_1_0= ruleTK_MUL_DIV
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getArithm_expr_trmAccess().getMuldivTK_MUL_DIVParserRuleCall_1_0_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleTK_MUL_DIV_in_ruleArithm_expr_trm4865);
                            lv_muldiv_1_0=ruleTK_MUL_DIV();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getArithm_expr_trmRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"muldiv",
                                      		lv_muldiv_1_0, 
                                      		"TK_MUL_DIV");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2526:6: ( (lv_tk_intdiv_2_0= ruleTK_INTDIV ) )
                            {
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2526:6: ( (lv_tk_intdiv_2_0= ruleTK_INTDIV ) )
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2527:1: (lv_tk_intdiv_2_0= ruleTK_INTDIV )
                            {
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2527:1: (lv_tk_intdiv_2_0= ruleTK_INTDIV )
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2528:3: lv_tk_intdiv_2_0= ruleTK_INTDIV
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getArithm_expr_trmAccess().getTk_intdivTK_INTDIVParserRuleCall_1_0_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleTK_INTDIV_in_ruleArithm_expr_trm4892);
                            lv_tk_intdiv_2_0=ruleTK_INTDIV();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getArithm_expr_trmRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"tk_intdiv",
                                      		lv_tk_intdiv_2_0, 
                                      		"TK_INTDIV");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 3 :
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2545:6: ( (lv_tk_intmod_3_0= ruleTK_INTMOD ) )
                            {
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2545:6: ( (lv_tk_intmod_3_0= ruleTK_INTMOD ) )
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2546:1: (lv_tk_intmod_3_0= ruleTK_INTMOD )
                            {
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2546:1: (lv_tk_intmod_3_0= ruleTK_INTMOD )
                            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2547:3: lv_tk_intmod_3_0= ruleTK_INTMOD
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getArithm_expr_trmAccess().getTk_intmodTK_INTMODParserRuleCall_1_0_2_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleTK_INTMOD_in_ruleArithm_expr_trm4919);
                            lv_tk_intmod_3_0=ruleTK_INTMOD();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getArithm_expr_trmRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"tk_intmod",
                                      		lv_tk_intmod_3_0, 
                                      		"TK_INTMOD");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }

                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2563:3: ( (lv_arithm_expr_trm_4_0= ruleArithm_expr_trm ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2564:1: (lv_arithm_expr_trm_4_0= ruleArithm_expr_trm )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2564:1: (lv_arithm_expr_trm_4_0= ruleArithm_expr_trm )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2565:3: lv_arithm_expr_trm_4_0= ruleArithm_expr_trm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getArithm_expr_trmAccess().getArithm_expr_trmArithm_expr_trmParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleArithm_expr_trm_in_ruleArithm_expr_trm4941);
                    lv_arithm_expr_trm_4_0=ruleArithm_expr_trm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getArithm_expr_trmRule());
                      	        }
                             		set(
                             			current, 
                             			"arithm_expr_trm",
                              		lv_arithm_expr_trm_4_0, 
                              		"Arithm_expr_trm");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 54, ruleArithm_expr_trm_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleArithm_expr_trm"


    // $ANTLR start "entryRuleTK_MUL_DIV"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2589:1: entryRuleTK_MUL_DIV returns [String current=null] : iv_ruleTK_MUL_DIV= ruleTK_MUL_DIV EOF ;
    public final String entryRuleTK_MUL_DIV() throws RecognitionException {
        String current = null;
        int entryRuleTK_MUL_DIV_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_ruleTK_MUL_DIV = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 55) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2590:2: (iv_ruleTK_MUL_DIV= ruleTK_MUL_DIV EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2591:2: iv_ruleTK_MUL_DIV= ruleTK_MUL_DIV EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTK_MUL_DIVRule()); 
            }
            pushFollow(FOLLOW_ruleTK_MUL_DIV_in_entryRuleTK_MUL_DIV4980);
            iv_ruleTK_MUL_DIV=ruleTK_MUL_DIV();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTK_MUL_DIV.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTK_MUL_DIV4991); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 55, entryRuleTK_MUL_DIV_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleTK_MUL_DIV"


    // $ANTLR start "ruleTK_MUL_DIV"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2598:1: ruleTK_MUL_DIV returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '/' ) ;
    public final AntlrDatatypeRuleToken ruleTK_MUL_DIV() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        int ruleTK_MUL_DIV_StartIndex = input.index();
        Token kw=null;

         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 56) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2601:28: ( (kw= '*' | kw= '/' ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2602:1: (kw= '*' | kw= '/' )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2602:1: (kw= '*' | kw= '/' )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==45) ) {
                alt54=1;
            }
            else if ( (LA54_0==46) ) {
                alt54=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }
            switch (alt54) {
                case 1 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2603:2: kw= '*'
                    {
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleTK_MUL_DIV5029); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getTK_MUL_DIVAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2610:2: kw= '/'
                    {
                    kw=(Token)match(input,46,FOLLOW_46_in_ruleTK_MUL_DIV5048); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getTK_MUL_DIVAccess().getSolidusKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 56, ruleTK_MUL_DIV_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleTK_MUL_DIV"


    // $ANTLR start "entryRuleArithm_expr_factor"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2623:1: entryRuleArithm_expr_factor returns [EObject current=null] : iv_ruleArithm_expr_factor= ruleArithm_expr_factor EOF ;
    public final EObject entryRuleArithm_expr_factor() throws RecognitionException {
        EObject current = null;
        int entryRuleArithm_expr_factor_StartIndex = input.index();
        EObject iv_ruleArithm_expr_factor = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 57) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2624:2: (iv_ruleArithm_expr_factor= ruleArithm_expr_factor EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2625:2: iv_ruleArithm_expr_factor= ruleArithm_expr_factor EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArithm_expr_factorRule()); 
            }
            pushFollow(FOLLOW_ruleArithm_expr_factor_in_entryRuleArithm_expr_factor5088);
            iv_ruleArithm_expr_factor=ruleArithm_expr_factor();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArithm_expr_factor; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleArithm_expr_factor5098); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 57, entryRuleArithm_expr_factor_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleArithm_expr_factor"


    // $ANTLR start "ruleArithm_expr_factor"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2632:1: ruleArithm_expr_factor returns [EObject current=null] : ( ( (lv_arithm_expr_simple_0_0= ruleArithm_expr_simple ) ) ( ( (lv_exponential_1_0= ruleTK_EXPONENTIAL ) ) ( (lv_arithm_expr_factor_2_0= ruleArithm_expr_factor ) ) )? ) ;
    public final EObject ruleArithm_expr_factor() throws RecognitionException {
        EObject current = null;
        int ruleArithm_expr_factor_StartIndex = input.index();
        EObject lv_arithm_expr_simple_0_0 = null;

        AntlrDatatypeRuleToken lv_exponential_1_0 = null;

        EObject lv_arithm_expr_factor_2_0 = null;


         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 58) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2635:28: ( ( ( (lv_arithm_expr_simple_0_0= ruleArithm_expr_simple ) ) ( ( (lv_exponential_1_0= ruleTK_EXPONENTIAL ) ) ( (lv_arithm_expr_factor_2_0= ruleArithm_expr_factor ) ) )? ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2636:1: ( ( (lv_arithm_expr_simple_0_0= ruleArithm_expr_simple ) ) ( ( (lv_exponential_1_0= ruleTK_EXPONENTIAL ) ) ( (lv_arithm_expr_factor_2_0= ruleArithm_expr_factor ) ) )? )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2636:1: ( ( (lv_arithm_expr_simple_0_0= ruleArithm_expr_simple ) ) ( ( (lv_exponential_1_0= ruleTK_EXPONENTIAL ) ) ( (lv_arithm_expr_factor_2_0= ruleArithm_expr_factor ) ) )? )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2636:2: ( (lv_arithm_expr_simple_0_0= ruleArithm_expr_simple ) ) ( ( (lv_exponential_1_0= ruleTK_EXPONENTIAL ) ) ( (lv_arithm_expr_factor_2_0= ruleArithm_expr_factor ) ) )?
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2636:2: ( (lv_arithm_expr_simple_0_0= ruleArithm_expr_simple ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2637:1: (lv_arithm_expr_simple_0_0= ruleArithm_expr_simple )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2637:1: (lv_arithm_expr_simple_0_0= ruleArithm_expr_simple )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2638:3: lv_arithm_expr_simple_0_0= ruleArithm_expr_simple
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getArithm_expr_factorAccess().getArithm_expr_simpleArithm_expr_simpleParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleArithm_expr_simple_in_ruleArithm_expr_factor5144);
            lv_arithm_expr_simple_0_0=ruleArithm_expr_simple();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getArithm_expr_factorRule());
              	        }
                     		set(
                     			current, 
                     			"arithm_expr_simple",
                      		lv_arithm_expr_simple_0_0, 
                      		"Arithm_expr_simple");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2654:2: ( ( (lv_exponential_1_0= ruleTK_EXPONENTIAL ) ) ( (lv_arithm_expr_factor_2_0= ruleArithm_expr_factor ) ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==47) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2654:3: ( (lv_exponential_1_0= ruleTK_EXPONENTIAL ) ) ( (lv_arithm_expr_factor_2_0= ruleArithm_expr_factor ) )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2654:3: ( (lv_exponential_1_0= ruleTK_EXPONENTIAL ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2655:1: (lv_exponential_1_0= ruleTK_EXPONENTIAL )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2655:1: (lv_exponential_1_0= ruleTK_EXPONENTIAL )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2656:3: lv_exponential_1_0= ruleTK_EXPONENTIAL
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getArithm_expr_factorAccess().getExponentialTK_EXPONENTIALParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTK_EXPONENTIAL_in_ruleArithm_expr_factor5166);
                    lv_exponential_1_0=ruleTK_EXPONENTIAL();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getArithm_expr_factorRule());
                      	        }
                             		set(
                             			current, 
                             			"exponential",
                              		lv_exponential_1_0, 
                              		"TK_EXPONENTIAL");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2672:2: ( (lv_arithm_expr_factor_2_0= ruleArithm_expr_factor ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2673:1: (lv_arithm_expr_factor_2_0= ruleArithm_expr_factor )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2673:1: (lv_arithm_expr_factor_2_0= ruleArithm_expr_factor )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2674:3: lv_arithm_expr_factor_2_0= ruleArithm_expr_factor
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getArithm_expr_factorAccess().getArithm_expr_factorArithm_expr_factorParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleArithm_expr_factor_in_ruleArithm_expr_factor5187);
                    lv_arithm_expr_factor_2_0=ruleArithm_expr_factor();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getArithm_expr_factorRule());
                      	        }
                             		set(
                             			current, 
                             			"arithm_expr_factor",
                              		lv_arithm_expr_factor_2_0, 
                              		"Arithm_expr_factor");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 58, ruleArithm_expr_factor_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleArithm_expr_factor"


    // $ANTLR start "entryRuleTK_EXPONENTIAL"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2698:1: entryRuleTK_EXPONENTIAL returns [String current=null] : iv_ruleTK_EXPONENTIAL= ruleTK_EXPONENTIAL EOF ;
    public final String entryRuleTK_EXPONENTIAL() throws RecognitionException {
        String current = null;
        int entryRuleTK_EXPONENTIAL_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_ruleTK_EXPONENTIAL = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 59) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2699:2: (iv_ruleTK_EXPONENTIAL= ruleTK_EXPONENTIAL EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2700:2: iv_ruleTK_EXPONENTIAL= ruleTK_EXPONENTIAL EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTK_EXPONENTIALRule()); 
            }
            pushFollow(FOLLOW_ruleTK_EXPONENTIAL_in_entryRuleTK_EXPONENTIAL5226);
            iv_ruleTK_EXPONENTIAL=ruleTK_EXPONENTIAL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTK_EXPONENTIAL.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTK_EXPONENTIAL5237); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 59, entryRuleTK_EXPONENTIAL_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleTK_EXPONENTIAL"


    // $ANTLR start "ruleTK_EXPONENTIAL"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2707:1: ruleTK_EXPONENTIAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '**' ;
    public final AntlrDatatypeRuleToken ruleTK_EXPONENTIAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        int ruleTK_EXPONENTIAL_StartIndex = input.index();
        Token kw=null;

         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 60) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2710:28: (kw= '**' )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2712:2: kw= '**'
            {
            kw=(Token)match(input,47,FOLLOW_47_in_ruleTK_EXPONENTIAL5274); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getTK_EXPONENTIALAccess().getAsteriskAsteriskKeyword()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 60, ruleTK_EXPONENTIAL_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleTK_EXPONENTIAL"


    // $ANTLR start "entryRuleArithm_expr_simple"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2725:1: entryRuleArithm_expr_simple returns [EObject current=null] : iv_ruleArithm_expr_simple= ruleArithm_expr_simple EOF ;
    public final EObject entryRuleArithm_expr_simple() throws RecognitionException {
        EObject current = null;
        int entryRuleArithm_expr_simple_StartIndex = input.index();
        EObject iv_ruleArithm_expr_simple = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 61) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2726:2: (iv_ruleArithm_expr_simple= ruleArithm_expr_simple EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2727:2: iv_ruleArithm_expr_simple= ruleArithm_expr_simple EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArithm_expr_simpleRule()); 
            }
            pushFollow(FOLLOW_ruleArithm_expr_simple_in_entryRuleArithm_expr_simple5313);
            iv_ruleArithm_expr_simple=ruleArithm_expr_simple();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArithm_expr_simple; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleArithm_expr_simple5323); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 61, entryRuleArithm_expr_simple_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleArithm_expr_simple"


    // $ANTLR start "ruleArithm_expr_simple"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2734:1: ruleArithm_expr_simple returns [EObject current=null] : ( ( (lv_number_0_0= ruleNumber ) ) | ( ( (lv_unary_1_0= ruleTK_UNARY_OP ) ) ( (lv_arithm_expr_simple_2_0= ruleArithm_expr_simple ) ) ) | (otherlv_3= '(' ( (lv_log_expr_4_0= ruleLog_expr ) ) otherlv_5= ')' ) | ( (lv_var_6_0= ruleVar ) ) | ( (lv_function_7_0= ruleFunction ) ) ) ;
    public final EObject ruleArithm_expr_simple() throws RecognitionException {
        EObject current = null;
        int ruleArithm_expr_simple_StartIndex = input.index();
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_number_0_0 = null;

        AntlrDatatypeRuleToken lv_unary_1_0 = null;

        EObject lv_arithm_expr_simple_2_0 = null;

        EObject lv_log_expr_4_0 = null;

        EObject lv_var_6_0 = null;

        EObject lv_function_7_0 = null;


         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 62) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2737:28: ( ( ( (lv_number_0_0= ruleNumber ) ) | ( ( (lv_unary_1_0= ruleTK_UNARY_OP ) ) ( (lv_arithm_expr_simple_2_0= ruleArithm_expr_simple ) ) ) | (otherlv_3= '(' ( (lv_log_expr_4_0= ruleLog_expr ) ) otherlv_5= ')' ) | ( (lv_var_6_0= ruleVar ) ) | ( (lv_function_7_0= ruleFunction ) ) ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2738:1: ( ( (lv_number_0_0= ruleNumber ) ) | ( ( (lv_unary_1_0= ruleTK_UNARY_OP ) ) ( (lv_arithm_expr_simple_2_0= ruleArithm_expr_simple ) ) ) | (otherlv_3= '(' ( (lv_log_expr_4_0= ruleLog_expr ) ) otherlv_5= ')' ) | ( (lv_var_6_0= ruleVar ) ) | ( (lv_function_7_0= ruleFunction ) ) )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2738:1: ( ( (lv_number_0_0= ruleNumber ) ) | ( ( (lv_unary_1_0= ruleTK_UNARY_OP ) ) ( (lv_arithm_expr_simple_2_0= ruleArithm_expr_simple ) ) ) | (otherlv_3= '(' ( (lv_log_expr_4_0= ruleLog_expr ) ) otherlv_5= ')' ) | ( (lv_var_6_0= ruleVar ) ) | ( (lv_function_7_0= ruleFunction ) ) )
            int alt56=5;
            switch ( input.LA(1) ) {
            case RULE_NUMBERT:
                {
                alt56=1;
                }
                break;
            case 21:
                {
                int LA56_2 = input.LA(2);

                if ( (LA56_2==RULE_ATOM) ) {
                    alt56=5;
                }
                else if ( (LA56_2==RULE_NUMBERT) ) {
                    alt56=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 56, 2, input);

                    throw nvae;
                }
                }
                break;
            case 26:
                {
                alt56=2;
                }
                break;
            case 30:
                {
                alt56=3;
                }
                break;
            case RULE_VART:
            case RULE_UNNAMEDVART:
                {
                alt56=4;
                }
                break;
            case RULE_TK_NEG:
            case RULE_ATOM:
            case 48:
            case 49:
            case 57:
            case 58:
                {
                alt56=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }

            switch (alt56) {
                case 1 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2738:2: ( (lv_number_0_0= ruleNumber ) )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2738:2: ( (lv_number_0_0= ruleNumber ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2739:1: (lv_number_0_0= ruleNumber )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2739:1: (lv_number_0_0= ruleNumber )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2740:3: lv_number_0_0= ruleNumber
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getArithm_expr_simpleAccess().getNumberNumberParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleNumber_in_ruleArithm_expr_simple5369);
                    lv_number_0_0=ruleNumber();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getArithm_expr_simpleRule());
                      	        }
                             		set(
                             			current, 
                             			"number",
                              		lv_number_0_0, 
                              		"Number");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2757:6: ( ( (lv_unary_1_0= ruleTK_UNARY_OP ) ) ( (lv_arithm_expr_simple_2_0= ruleArithm_expr_simple ) ) )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2757:6: ( ( (lv_unary_1_0= ruleTK_UNARY_OP ) ) ( (lv_arithm_expr_simple_2_0= ruleArithm_expr_simple ) ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2757:7: ( (lv_unary_1_0= ruleTK_UNARY_OP ) ) ( (lv_arithm_expr_simple_2_0= ruleArithm_expr_simple ) )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2757:7: ( (lv_unary_1_0= ruleTK_UNARY_OP ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2758:1: (lv_unary_1_0= ruleTK_UNARY_OP )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2758:1: (lv_unary_1_0= ruleTK_UNARY_OP )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2759:3: lv_unary_1_0= ruleTK_UNARY_OP
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getArithm_expr_simpleAccess().getUnaryTK_UNARY_OPParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTK_UNARY_OP_in_ruleArithm_expr_simple5397);
                    lv_unary_1_0=ruleTK_UNARY_OP();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getArithm_expr_simpleRule());
                      	        }
                             		set(
                             			current, 
                             			"unary",
                              		lv_unary_1_0, 
                              		"TK_UNARY_OP");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2775:2: ( (lv_arithm_expr_simple_2_0= ruleArithm_expr_simple ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2776:1: (lv_arithm_expr_simple_2_0= ruleArithm_expr_simple )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2776:1: (lv_arithm_expr_simple_2_0= ruleArithm_expr_simple )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2777:3: lv_arithm_expr_simple_2_0= ruleArithm_expr_simple
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getArithm_expr_simpleAccess().getArithm_expr_simpleArithm_expr_simpleParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleArithm_expr_simple_in_ruleArithm_expr_simple5418);
                    lv_arithm_expr_simple_2_0=ruleArithm_expr_simple();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getArithm_expr_simpleRule());
                      	        }
                             		set(
                             			current, 
                             			"arithm_expr_simple",
                              		lv_arithm_expr_simple_2_0, 
                              		"Arithm_expr_simple");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2794:6: (otherlv_3= '(' ( (lv_log_expr_4_0= ruleLog_expr ) ) otherlv_5= ')' )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2794:6: (otherlv_3= '(' ( (lv_log_expr_4_0= ruleLog_expr ) ) otherlv_5= ')' )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2794:8: otherlv_3= '(' ( (lv_log_expr_4_0= ruleLog_expr ) ) otherlv_5= ')'
                    {
                    otherlv_3=(Token)match(input,30,FOLLOW_30_in_ruleArithm_expr_simple5438); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getArithm_expr_simpleAccess().getLeftParenthesisKeyword_2_0());
                          
                    }
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2798:1: ( (lv_log_expr_4_0= ruleLog_expr ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2799:1: (lv_log_expr_4_0= ruleLog_expr )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2799:1: (lv_log_expr_4_0= ruleLog_expr )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2800:3: lv_log_expr_4_0= ruleLog_expr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getArithm_expr_simpleAccess().getLog_exprLog_exprParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLog_expr_in_ruleArithm_expr_simple5459);
                    lv_log_expr_4_0=ruleLog_expr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getArithm_expr_simpleRule());
                      	        }
                             		set(
                             			current, 
                             			"log_expr",
                              		lv_log_expr_4_0, 
                              		"Log_expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_5=(Token)match(input,31,FOLLOW_31_in_ruleArithm_expr_simple5471); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getArithm_expr_simpleAccess().getRightParenthesisKeyword_2_2());
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2821:6: ( (lv_var_6_0= ruleVar ) )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2821:6: ( (lv_var_6_0= ruleVar ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2822:1: (lv_var_6_0= ruleVar )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2822:1: (lv_var_6_0= ruleVar )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2823:3: lv_var_6_0= ruleVar
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getArithm_expr_simpleAccess().getVarVarParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleVar_in_ruleArithm_expr_simple5499);
                    lv_var_6_0=ruleVar();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getArithm_expr_simpleRule());
                      	        }
                             		set(
                             			current, 
                             			"var",
                              		lv_var_6_0, 
                              		"Var");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 5 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2840:6: ( (lv_function_7_0= ruleFunction ) )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2840:6: ( (lv_function_7_0= ruleFunction ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2841:1: (lv_function_7_0= ruleFunction )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2841:1: (lv_function_7_0= ruleFunction )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2842:3: lv_function_7_0= ruleFunction
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getArithm_expr_simpleAccess().getFunctionFunctionParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFunction_in_ruleArithm_expr_simple5526);
                    lv_function_7_0=ruleFunction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getArithm_expr_simpleRule());
                      	        }
                             		set(
                             			current, 
                             			"function",
                              		lv_function_7_0, 
                              		"Function");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 62, ruleArithm_expr_simple_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleArithm_expr_simple"


    // $ANTLR start "entryRuleTK_UNARY_OP"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2866:1: entryRuleTK_UNARY_OP returns [String current=null] : iv_ruleTK_UNARY_OP= ruleTK_UNARY_OP EOF ;
    public final String entryRuleTK_UNARY_OP() throws RecognitionException {
        String current = null;
        int entryRuleTK_UNARY_OP_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_ruleTK_UNARY_OP = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 63) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2867:2: (iv_ruleTK_UNARY_OP= ruleTK_UNARY_OP EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2868:2: iv_ruleTK_UNARY_OP= ruleTK_UNARY_OP EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTK_UNARY_OPRule()); 
            }
            pushFollow(FOLLOW_ruleTK_UNARY_OP_in_entryRuleTK_UNARY_OP5563);
            iv_ruleTK_UNARY_OP=ruleTK_UNARY_OP();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTK_UNARY_OP.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTK_UNARY_OP5574); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 63, entryRuleTK_UNARY_OP_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleTK_UNARY_OP"


    // $ANTLR start "ruleTK_UNARY_OP"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2875:1: ruleTK_UNARY_OP returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '-' ;
    public final AntlrDatatypeRuleToken ruleTK_UNARY_OP() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        int ruleTK_UNARY_OP_StartIndex = input.index();
        Token kw=null;

         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 64) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2878:28: (kw= '-' )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2880:2: kw= '-'
            {
            kw=(Token)match(input,26,FOLLOW_26_in_ruleTK_UNARY_OP5611); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getTK_UNARY_OPAccess().getHyphenMinusKeyword()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 64, ruleTK_UNARY_OP_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleTK_UNARY_OP"


    // $ANTLR start "entryRuleFunction"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2893:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;
        int entryRuleFunction_StartIndex = input.index();
        EObject iv_ruleFunction = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 65) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2894:2: (iv_ruleFunction= ruleFunction EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2895:2: iv_ruleFunction= ruleFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionRule()); 
            }
            pushFollow(FOLLOW_ruleFunction_in_entryRuleFunction5650);
            iv_ruleFunction=ruleFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunction; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunction5660); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 65, entryRuleFunction_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleFunction"


    // $ANTLR start "ruleFunction"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2902:1: ruleFunction returns [EObject current=null] : ( (lv_literal_0_0= ruleLiteral ) ) ;
    public final EObject ruleFunction() throws RecognitionException {
        EObject current = null;
        int ruleFunction_StartIndex = input.index();
        EObject lv_literal_0_0 = null;


         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 66) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2905:28: ( ( (lv_literal_0_0= ruleLiteral ) ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2906:1: ( (lv_literal_0_0= ruleLiteral ) )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2906:1: ( (lv_literal_0_0= ruleLiteral ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2907:1: (lv_literal_0_0= ruleLiteral )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2907:1: (lv_literal_0_0= ruleLiteral )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2908:3: lv_literal_0_0= ruleLiteral
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFunctionAccess().getLiteralLiteralParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLiteral_in_ruleFunction5705);
            lv_literal_0_0=ruleLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFunctionRule());
              	        }
                     		set(
                     			current, 
                     			"literal",
                      		lv_literal_0_0, 
                      		"Literal");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 66, ruleFunction_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleFunction"


    // $ANTLR start "entryRuleVar"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2932:1: entryRuleVar returns [EObject current=null] : iv_ruleVar= ruleVar EOF ;
    public final EObject entryRuleVar() throws RecognitionException {
        EObject current = null;
        int entryRuleVar_StartIndex = input.index();
        EObject iv_ruleVar = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 67) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2933:2: (iv_ruleVar= ruleVar EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2934:2: iv_ruleVar= ruleVar EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVarRule()); 
            }
            pushFollow(FOLLOW_ruleVar_in_entryRuleVar5740);
            iv_ruleVar=ruleVar();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVar; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVar5750); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 67, entryRuleVar_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleVar"


    // $ANTLR start "ruleVar"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2941:1: ruleVar returns [EObject current=null] : ( ( ( (lv_var_0_0= RULE_VART ) ) | ( (lv_unnamedvar_1_0= RULE_UNNAMEDVART ) ) ) ( (lv_list_2_0= ruleList ) )? ) ;
    public final EObject ruleVar() throws RecognitionException {
        EObject current = null;
        int ruleVar_StartIndex = input.index();
        Token lv_var_0_0=null;
        Token lv_unnamedvar_1_0=null;
        EObject lv_list_2_0 = null;


         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 68) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2944:28: ( ( ( ( (lv_var_0_0= RULE_VART ) ) | ( (lv_unnamedvar_1_0= RULE_UNNAMEDVART ) ) ) ( (lv_list_2_0= ruleList ) )? ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2945:1: ( ( ( (lv_var_0_0= RULE_VART ) ) | ( (lv_unnamedvar_1_0= RULE_UNNAMEDVART ) ) ) ( (lv_list_2_0= ruleList ) )? )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2945:1: ( ( ( (lv_var_0_0= RULE_VART ) ) | ( (lv_unnamedvar_1_0= RULE_UNNAMEDVART ) ) ) ( (lv_list_2_0= ruleList ) )? )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2945:2: ( ( (lv_var_0_0= RULE_VART ) ) | ( (lv_unnamedvar_1_0= RULE_UNNAMEDVART ) ) ) ( (lv_list_2_0= ruleList ) )?
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2945:2: ( ( (lv_var_0_0= RULE_VART ) ) | ( (lv_unnamedvar_1_0= RULE_UNNAMEDVART ) ) )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==RULE_VART) ) {
                alt57=1;
            }
            else if ( (LA57_0==RULE_UNNAMEDVART) ) {
                alt57=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }
            switch (alt57) {
                case 1 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2945:3: ( (lv_var_0_0= RULE_VART ) )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2945:3: ( (lv_var_0_0= RULE_VART ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2946:1: (lv_var_0_0= RULE_VART )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2946:1: (lv_var_0_0= RULE_VART )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2947:3: lv_var_0_0= RULE_VART
                    {
                    lv_var_0_0=(Token)match(input,RULE_VART,FOLLOW_RULE_VART_in_ruleVar5793); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_var_0_0, grammarAccess.getVarAccess().getVarVARTTerminalRuleCall_0_0_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getVarRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"var",
                              		lv_var_0_0, 
                              		"VART");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2964:6: ( (lv_unnamedvar_1_0= RULE_UNNAMEDVART ) )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2964:6: ( (lv_unnamedvar_1_0= RULE_UNNAMEDVART ) )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2965:1: (lv_unnamedvar_1_0= RULE_UNNAMEDVART )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2965:1: (lv_unnamedvar_1_0= RULE_UNNAMEDVART )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2966:3: lv_unnamedvar_1_0= RULE_UNNAMEDVART
                    {
                    lv_unnamedvar_1_0=(Token)match(input,RULE_UNNAMEDVART,FOLLOW_RULE_UNNAMEDVART_in_ruleVar5821); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_unnamedvar_1_0, grammarAccess.getVarAccess().getUnnamedvarUNNAMEDVARTTerminalRuleCall_0_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getVarRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"unnamedvar",
                              		lv_unnamedvar_1_0, 
                              		"UNNAMEDVART");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2982:3: ( (lv_list_2_0= ruleList ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==34) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2983:1: (lv_list_2_0= ruleList )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2983:1: (lv_list_2_0= ruleList )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2984:3: lv_list_2_0= ruleList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getVarAccess().getListListParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleList_in_ruleVar5848);
                    lv_list_2_0=ruleList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getVarRule());
                      	        }
                             		set(
                             			current, 
                             			"list",
                              		lv_list_2_0, 
                              		"List");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 68, ruleVar_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleVar"


    // $ANTLR start "entryRuleString"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3008:1: entryRuleString returns [EObject current=null] : iv_ruleString= ruleString EOF ;
    public final EObject entryRuleString() throws RecognitionException {
        EObject current = null;
        int entryRuleString_StartIndex = input.index();
        EObject iv_ruleString = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 69) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3009:2: (iv_ruleString= ruleString EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3010:2: iv_ruleString= ruleString EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringRule()); 
            }
            pushFollow(FOLLOW_ruleString_in_entryRuleString5885);
            iv_ruleString=ruleString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleString; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleString5895); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 69, entryRuleString_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleString"


    // $ANTLR start "ruleString"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3017:1: ruleString returns [EObject current=null] : ( (lv_string_0_0= RULE_STRINGT ) ) ;
    public final EObject ruleString() throws RecognitionException {
        EObject current = null;
        int ruleString_StartIndex = input.index();
        Token lv_string_0_0=null;

         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 70) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3020:28: ( ( (lv_string_0_0= RULE_STRINGT ) ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3021:1: ( (lv_string_0_0= RULE_STRINGT ) )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3021:1: ( (lv_string_0_0= RULE_STRINGT ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3022:1: (lv_string_0_0= RULE_STRINGT )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3022:1: (lv_string_0_0= RULE_STRINGT )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3023:3: lv_string_0_0= RULE_STRINGT
            {
            lv_string_0_0=(Token)match(input,RULE_STRINGT,FOLLOW_RULE_STRINGT_in_ruleString5936); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_string_0_0, grammarAccess.getStringAccess().getStringSTRINGTTerminalRuleCall_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getStringRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"string",
                      		lv_string_0_0, 
                      		"STRINGT");
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 70, ruleString_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleString"


    // $ANTLR start "entryRuleNumber"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3047:1: entryRuleNumber returns [EObject current=null] : iv_ruleNumber= ruleNumber EOF ;
    public final EObject entryRuleNumber() throws RecognitionException {
        EObject current = null;
        int entryRuleNumber_StartIndex = input.index();
        EObject iv_ruleNumber = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 71) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3051:2: (iv_ruleNumber= ruleNumber EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3052:2: iv_ruleNumber= ruleNumber EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumberRule()); 
            }
            pushFollow(FOLLOW_ruleNumber_in_entryRuleNumber5982);
            iv_ruleNumber=ruleNumber();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumber; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumber5992); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 71, entryRuleNumber_StartIndex); }

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleNumber"


    // $ANTLR start "ruleNumber"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3062:1: ruleNumber returns [EObject current=null] : ( ( ( (lv_number_0_0= RULE_NUMBERT ) )+ otherlv_1= '.' ( (lv_decimalPart_2_0= RULE_NUMBERT ) )+ ) | (otherlv_3= '.' ( (lv_decimalPart_4_0= RULE_NUMBERT ) )+ ) | ( (lv_number_5_0= RULE_NUMBERT ) )+ ) ;
    public final EObject ruleNumber() throws RecognitionException {
        EObject current = null;
        int ruleNumber_StartIndex = input.index();
        Token lv_number_0_0=null;
        Token otherlv_1=null;
        Token lv_decimalPart_2_0=null;
        Token otherlv_3=null;
        Token lv_decimalPart_4_0=null;
        Token lv_number_5_0=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 72) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3066:28: ( ( ( ( (lv_number_0_0= RULE_NUMBERT ) )+ otherlv_1= '.' ( (lv_decimalPart_2_0= RULE_NUMBERT ) )+ ) | (otherlv_3= '.' ( (lv_decimalPart_4_0= RULE_NUMBERT ) )+ ) | ( (lv_number_5_0= RULE_NUMBERT ) )+ ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3067:1: ( ( ( (lv_number_0_0= RULE_NUMBERT ) )+ otherlv_1= '.' ( (lv_decimalPart_2_0= RULE_NUMBERT ) )+ ) | (otherlv_3= '.' ( (lv_decimalPart_4_0= RULE_NUMBERT ) )+ ) | ( (lv_number_5_0= RULE_NUMBERT ) )+ )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3067:1: ( ( ( (lv_number_0_0= RULE_NUMBERT ) )+ otherlv_1= '.' ( (lv_decimalPart_2_0= RULE_NUMBERT ) )+ ) | (otherlv_3= '.' ( (lv_decimalPart_4_0= RULE_NUMBERT ) )+ ) | ( (lv_number_5_0= RULE_NUMBERT ) )+ )
            int alt63=3;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==RULE_NUMBERT) ) {
                int LA63_1 = input.LA(2);

                if ( (synpred87_InternalAsl()) ) {
                    alt63=1;
                }
                else if ( (true) ) {
                    alt63=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 63, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA63_0==21) ) {
                alt63=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }
            switch (alt63) {
                case 1 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3067:2: ( ( (lv_number_0_0= RULE_NUMBERT ) )+ otherlv_1= '.' ( (lv_decimalPart_2_0= RULE_NUMBERT ) )+ )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3067:2: ( ( (lv_number_0_0= RULE_NUMBERT ) )+ otherlv_1= '.' ( (lv_decimalPart_2_0= RULE_NUMBERT ) )+ )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3067:3: ( (lv_number_0_0= RULE_NUMBERT ) )+ otherlv_1= '.' ( (lv_decimalPart_2_0= RULE_NUMBERT ) )+
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3067:3: ( (lv_number_0_0= RULE_NUMBERT ) )+
                    int cnt59=0;
                    loop59:
                    do {
                        int alt59=2;
                        int LA59_0 = input.LA(1);

                        if ( (LA59_0==RULE_NUMBERT) ) {
                            alt59=1;
                        }


                        switch (alt59) {
                    	case 1 :
                    	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3068:1: (lv_number_0_0= RULE_NUMBERT )
                    	    {
                    	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3068:1: (lv_number_0_0= RULE_NUMBERT )
                    	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3069:3: lv_number_0_0= RULE_NUMBERT
                    	    {
                    	    lv_number_0_0=(Token)match(input,RULE_NUMBERT,FOLLOW_RULE_NUMBERT_in_ruleNumber6039); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      			newLeafNode(lv_number_0_0, grammarAccess.getNumberAccess().getNumberNUMBERTTerminalRuleCall_0_0_0()); 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getNumberRule());
                    	      	        }
                    	             		addWithLastConsumed(
                    	             			current, 
                    	             			"number",
                    	              		lv_number_0_0, 
                    	              		"NUMBERT");
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt59 >= 1 ) break loop59;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(59, input);
                                throw eee;
                        }
                        cnt59++;
                    } while (true);

                    otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleNumber6057); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getNumberAccess().getFullStopKeyword_0_1());
                          
                    }
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3089:1: ( (lv_decimalPart_2_0= RULE_NUMBERT ) )+
                    int cnt60=0;
                    loop60:
                    do {
                        int alt60=2;
                        int LA60_0 = input.LA(1);

                        if ( (LA60_0==RULE_NUMBERT) ) {
                            int LA60_2 = input.LA(2);

                            if ( (synpred86_InternalAsl()) ) {
                                alt60=1;
                            }


                        }


                        switch (alt60) {
                    	case 1 :
                    	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3090:1: (lv_decimalPart_2_0= RULE_NUMBERT )
                    	    {
                    	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3090:1: (lv_decimalPart_2_0= RULE_NUMBERT )
                    	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3091:3: lv_decimalPart_2_0= RULE_NUMBERT
                    	    {
                    	    lv_decimalPart_2_0=(Token)match(input,RULE_NUMBERT,FOLLOW_RULE_NUMBERT_in_ruleNumber6074); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      			newLeafNode(lv_decimalPart_2_0, grammarAccess.getNumberAccess().getDecimalPartNUMBERTTerminalRuleCall_0_2_0()); 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getNumberRule());
                    	      	        }
                    	             		addWithLastConsumed(
                    	             			current, 
                    	             			"decimalPart",
                    	              		lv_decimalPart_2_0, 
                    	              		"NUMBERT");
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt60 >= 1 ) break loop60;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(60, input);
                                throw eee;
                        }
                        cnt60++;
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3108:6: (otherlv_3= '.' ( (lv_decimalPart_4_0= RULE_NUMBERT ) )+ )
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3108:6: (otherlv_3= '.' ( (lv_decimalPart_4_0= RULE_NUMBERT ) )+ )
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3108:8: otherlv_3= '.' ( (lv_decimalPart_4_0= RULE_NUMBERT ) )+
                    {
                    otherlv_3=(Token)match(input,21,FOLLOW_21_in_ruleNumber6100); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getNumberAccess().getFullStopKeyword_1_0());
                          
                    }
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3112:1: ( (lv_decimalPart_4_0= RULE_NUMBERT ) )+
                    int cnt61=0;
                    loop61:
                    do {
                        int alt61=2;
                        int LA61_0 = input.LA(1);

                        if ( (LA61_0==RULE_NUMBERT) ) {
                            int LA61_2 = input.LA(2);

                            if ( (synpred88_InternalAsl()) ) {
                                alt61=1;
                            }


                        }


                        switch (alt61) {
                    	case 1 :
                    	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3113:1: (lv_decimalPart_4_0= RULE_NUMBERT )
                    	    {
                    	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3113:1: (lv_decimalPart_4_0= RULE_NUMBERT )
                    	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3114:3: lv_decimalPart_4_0= RULE_NUMBERT
                    	    {
                    	    lv_decimalPart_4_0=(Token)match(input,RULE_NUMBERT,FOLLOW_RULE_NUMBERT_in_ruleNumber6117); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      			newLeafNode(lv_decimalPart_4_0, grammarAccess.getNumberAccess().getDecimalPartNUMBERTTerminalRuleCall_1_1_0()); 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getNumberRule());
                    	      	        }
                    	             		addWithLastConsumed(
                    	             			current, 
                    	             			"decimalPart",
                    	              		lv_decimalPart_4_0, 
                    	              		"NUMBERT");
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt61 >= 1 ) break loop61;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(61, input);
                                throw eee;
                        }
                        cnt61++;
                    } while (true);


                    }


                    }
                    break;
                case 3 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3131:6: ( (lv_number_5_0= RULE_NUMBERT ) )+
                    {
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3131:6: ( (lv_number_5_0= RULE_NUMBERT ) )+
                    int cnt62=0;
                    loop62:
                    do {
                        int alt62=2;
                        int LA62_0 = input.LA(1);

                        if ( (LA62_0==RULE_NUMBERT) ) {
                            int LA62_2 = input.LA(2);

                            if ( (synpred90_InternalAsl()) ) {
                                alt62=1;
                            }


                        }


                        switch (alt62) {
                    	case 1 :
                    	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3132:1: (lv_number_5_0= RULE_NUMBERT )
                    	    {
                    	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3132:1: (lv_number_5_0= RULE_NUMBERT )
                    	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3133:3: lv_number_5_0= RULE_NUMBERT
                    	    {
                    	    lv_number_5_0=(Token)match(input,RULE_NUMBERT,FOLLOW_RULE_NUMBERT_in_ruleNumber6147); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      			newLeafNode(lv_number_5_0, grammarAccess.getNumberAccess().getNumberNUMBERTTerminalRuleCall_2_0()); 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getNumberRule());
                    	      	        }
                    	             		addWithLastConsumed(
                    	             			current, 
                    	             			"number",
                    	              		lv_number_5_0, 
                    	              		"NUMBERT");
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt62 >= 1 ) break loop62;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(62, input);
                                throw eee;
                        }
                        cnt62++;
                    } while (true);


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 72, ruleNumber_StartIndex); }

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleNumber"


    // $ANTLR start "entryRuleJASON_ATOM"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3160:1: entryRuleJASON_ATOM returns [String current=null] : iv_ruleJASON_ATOM= ruleJASON_ATOM EOF ;
    public final String entryRuleJASON_ATOM() throws RecognitionException {
        String current = null;
        int entryRuleJASON_ATOM_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_ruleJASON_ATOM = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 73) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3164:2: (iv_ruleJASON_ATOM= ruleJASON_ATOM EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3165:2: iv_ruleJASON_ATOM= ruleJASON_ATOM EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJASON_ATOMRule()); 
            }
            pushFollow(FOLLOW_ruleJASON_ATOM_in_entryRuleJASON_ATOM6200);
            iv_ruleJASON_ATOM=ruleJASON_ATOM();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJASON_ATOM.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJASON_ATOM6211); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 73, entryRuleJASON_ATOM_StartIndex); }

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleJASON_ATOM"


    // $ANTLR start "ruleJASON_ATOM"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3175:1: ruleJASON_ATOM returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_JASON_ATOM_HEAD_0= ruleJASON_ATOM_HEAD (this_JASON_ATOM_TAIL_1= ruleJASON_ATOM_TAIL )* ) ;
    public final AntlrDatatypeRuleToken ruleJASON_ATOM() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        int ruleJASON_ATOM_StartIndex = input.index();
        AntlrDatatypeRuleToken this_JASON_ATOM_HEAD_0 = null;

        AntlrDatatypeRuleToken this_JASON_ATOM_TAIL_1 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 74) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3179:28: ( (this_JASON_ATOM_HEAD_0= ruleJASON_ATOM_HEAD (this_JASON_ATOM_TAIL_1= ruleJASON_ATOM_TAIL )* ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3180:1: (this_JASON_ATOM_HEAD_0= ruleJASON_ATOM_HEAD (this_JASON_ATOM_TAIL_1= ruleJASON_ATOM_TAIL )* )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3180:1: (this_JASON_ATOM_HEAD_0= ruleJASON_ATOM_HEAD (this_JASON_ATOM_TAIL_1= ruleJASON_ATOM_TAIL )* )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3181:5: this_JASON_ATOM_HEAD_0= ruleJASON_ATOM_HEAD (this_JASON_ATOM_TAIL_1= ruleJASON_ATOM_TAIL )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getJASON_ATOMAccess().getJASON_ATOM_HEADParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleJASON_ATOM_HEAD_in_ruleJASON_ATOM6262);
            this_JASON_ATOM_HEAD_0=ruleJASON_ATOM_HEAD();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_JASON_ATOM_HEAD_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3191:1: (this_JASON_ATOM_TAIL_1= ruleJASON_ATOM_TAIL )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==21) ) {
                    int LA64_2 = input.LA(2);

                    if ( (LA64_2==RULE_ATOM) ) {
                        int LA64_3 = input.LA(3);

                        if ( (synpred91_InternalAsl()) ) {
                            alt64=1;
                        }


                    }


                }


                switch (alt64) {
            	case 1 :
            	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3192:5: this_JASON_ATOM_TAIL_1= ruleJASON_ATOM_TAIL
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getJASON_ATOMAccess().getJASON_ATOM_TAILParserRuleCall_1()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleJASON_ATOM_TAIL_in_ruleJASON_ATOM6290);
            	    this_JASON_ATOM_TAIL_1=ruleJASON_ATOM_TAIL();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_JASON_ATOM_TAIL_1);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop64;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 74, ruleJASON_ATOM_StartIndex); }

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleJASON_ATOM"


    // $ANTLR start "entryRuleJASON_ATOM_HEAD"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3213:1: entryRuleJASON_ATOM_HEAD returns [String current=null] : iv_ruleJASON_ATOM_HEAD= ruleJASON_ATOM_HEAD EOF ;
    public final String entryRuleJASON_ATOM_HEAD() throws RecognitionException {
        String current = null;
        int entryRuleJASON_ATOM_HEAD_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_ruleJASON_ATOM_HEAD = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 75) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3214:2: (iv_ruleJASON_ATOM_HEAD= ruleJASON_ATOM_HEAD EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3215:2: iv_ruleJASON_ATOM_HEAD= ruleJASON_ATOM_HEAD EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJASON_ATOM_HEADRule()); 
            }
            pushFollow(FOLLOW_ruleJASON_ATOM_HEAD_in_entryRuleJASON_ATOM_HEAD6342);
            iv_ruleJASON_ATOM_HEAD=ruleJASON_ATOM_HEAD();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJASON_ATOM_HEAD.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJASON_ATOM_HEAD6353); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 75, entryRuleJASON_ATOM_HEAD_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleJASON_ATOM_HEAD"


    // $ANTLR start "ruleJASON_ATOM_HEAD"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3222:1: ruleJASON_ATOM_HEAD returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '.' )? this_ATOM_1= RULE_ATOM ) ;
    public final AntlrDatatypeRuleToken ruleJASON_ATOM_HEAD() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        int ruleJASON_ATOM_HEAD_StartIndex = input.index();
        Token kw=null;
        Token this_ATOM_1=null;

         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 76) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3225:28: ( ( (kw= '.' )? this_ATOM_1= RULE_ATOM ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3226:1: ( (kw= '.' )? this_ATOM_1= RULE_ATOM )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3226:1: ( (kw= '.' )? this_ATOM_1= RULE_ATOM )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3226:2: (kw= '.' )? this_ATOM_1= RULE_ATOM
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3226:2: (kw= '.' )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==21) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3227:2: kw= '.'
                    {
                    kw=(Token)match(input,21,FOLLOW_21_in_ruleJASON_ATOM_HEAD6392); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getJASON_ATOM_HEADAccess().getFullStopKeyword_0()); 
                          
                    }

                    }
                    break;

            }

            this_ATOM_1=(Token)match(input,RULE_ATOM,FOLLOW_RULE_ATOM_in_ruleJASON_ATOM_HEAD6409); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ATOM_1);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ATOM_1, grammarAccess.getJASON_ATOM_HEADAccess().getATOMTerminalRuleCall_1()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 76, ruleJASON_ATOM_HEAD_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleJASON_ATOM_HEAD"


    // $ANTLR start "entryRuleJASON_ATOM_TAIL"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3247:1: entryRuleJASON_ATOM_TAIL returns [String current=null] : iv_ruleJASON_ATOM_TAIL= ruleJASON_ATOM_TAIL EOF ;
    public final String entryRuleJASON_ATOM_TAIL() throws RecognitionException {
        String current = null;
        int entryRuleJASON_ATOM_TAIL_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_ruleJASON_ATOM_TAIL = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 77) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3248:2: (iv_ruleJASON_ATOM_TAIL= ruleJASON_ATOM_TAIL EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3249:2: iv_ruleJASON_ATOM_TAIL= ruleJASON_ATOM_TAIL EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJASON_ATOM_TAILRule()); 
            }
            pushFollow(FOLLOW_ruleJASON_ATOM_TAIL_in_entryRuleJASON_ATOM_TAIL6455);
            iv_ruleJASON_ATOM_TAIL=ruleJASON_ATOM_TAIL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJASON_ATOM_TAIL.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJASON_ATOM_TAIL6466); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 77, entryRuleJASON_ATOM_TAIL_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleJASON_ATOM_TAIL"


    // $ANTLR start "ruleJASON_ATOM_TAIL"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3256:1: ruleJASON_ATOM_TAIL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '.' this_ATOM_1= RULE_ATOM ) ;
    public final AntlrDatatypeRuleToken ruleJASON_ATOM_TAIL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        int ruleJASON_ATOM_TAIL_StartIndex = input.index();
        Token kw=null;
        Token this_ATOM_1=null;

         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 78) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3259:28: ( (kw= '.' this_ATOM_1= RULE_ATOM ) )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3260:1: (kw= '.' this_ATOM_1= RULE_ATOM )
            {
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3260:1: (kw= '.' this_ATOM_1= RULE_ATOM )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3261:2: kw= '.' this_ATOM_1= RULE_ATOM
            {
            kw=(Token)match(input,21,FOLLOW_21_in_ruleJASON_ATOM_TAIL6504); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getJASON_ATOM_TAILAccess().getFullStopKeyword_0()); 
                  
            }
            this_ATOM_1=(Token)match(input,RULE_ATOM,FOLLOW_RULE_ATOM_in_ruleJASON_ATOM_TAIL6519); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ATOM_1);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ATOM_1, grammarAccess.getJASON_ATOM_TAILAccess().getATOMTerminalRuleCall_1()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 78, ruleJASON_ATOM_TAIL_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleJASON_ATOM_TAIL"


    // $ANTLR start "entryRuleTK_BEGIN"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3281:1: entryRuleTK_BEGIN returns [String current=null] : iv_ruleTK_BEGIN= ruleTK_BEGIN EOF ;
    public final String entryRuleTK_BEGIN() throws RecognitionException {
        String current = null;
        int entryRuleTK_BEGIN_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_ruleTK_BEGIN = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 79) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3282:2: (iv_ruleTK_BEGIN= ruleTK_BEGIN EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3283:2: iv_ruleTK_BEGIN= ruleTK_BEGIN EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTK_BEGINRule()); 
            }
            pushFollow(FOLLOW_ruleTK_BEGIN_in_entryRuleTK_BEGIN6565);
            iv_ruleTK_BEGIN=ruleTK_BEGIN();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTK_BEGIN.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTK_BEGIN6576); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 79, entryRuleTK_BEGIN_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleTK_BEGIN"


    // $ANTLR start "ruleTK_BEGIN"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3290:1: ruleTK_BEGIN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'begin' ;
    public final AntlrDatatypeRuleToken ruleTK_BEGIN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        int ruleTK_BEGIN_StartIndex = input.index();
        Token kw=null;

         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 80) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3293:28: (kw= 'begin' )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3295:2: kw= 'begin'
            {
            kw=(Token)match(input,48,FOLLOW_48_in_ruleTK_BEGIN6613); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getTK_BEGINAccess().getBeginKeyword()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 80, ruleTK_BEGIN_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleTK_BEGIN"


    // $ANTLR start "entryRuleTK_END"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3308:1: entryRuleTK_END returns [String current=null] : iv_ruleTK_END= ruleTK_END EOF ;
    public final String entryRuleTK_END() throws RecognitionException {
        String current = null;
        int entryRuleTK_END_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_ruleTK_END = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 81) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3309:2: (iv_ruleTK_END= ruleTK_END EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3310:2: iv_ruleTK_END= ruleTK_END EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTK_ENDRule()); 
            }
            pushFollow(FOLLOW_ruleTK_END_in_entryRuleTK_END6653);
            iv_ruleTK_END=ruleTK_END();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTK_END.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTK_END6664); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 81, entryRuleTK_END_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleTK_END"


    // $ANTLR start "ruleTK_END"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3317:1: ruleTK_END returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'end' ;
    public final AntlrDatatypeRuleToken ruleTK_END() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        int ruleTK_END_StartIndex = input.index();
        Token kw=null;

         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 82) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3320:28: (kw= 'end' )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3322:2: kw= 'end'
            {
            kw=(Token)match(input,49,FOLLOW_49_in_ruleTK_END6701); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getTK_ENDAccess().getEndKeyword()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 82, ruleTK_END_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleTK_END"


    // $ANTLR start "entryRuleTK_IF"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3335:1: entryRuleTK_IF returns [String current=null] : iv_ruleTK_IF= ruleTK_IF EOF ;
    public final String entryRuleTK_IF() throws RecognitionException {
        String current = null;
        int entryRuleTK_IF_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_ruleTK_IF = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 83) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3336:2: (iv_ruleTK_IF= ruleTK_IF EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3337:2: iv_ruleTK_IF= ruleTK_IF EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTK_IFRule()); 
            }
            pushFollow(FOLLOW_ruleTK_IF_in_entryRuleTK_IF6741);
            iv_ruleTK_IF=ruleTK_IF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTK_IF.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTK_IF6752); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 83, entryRuleTK_IF_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleTK_IF"


    // $ANTLR start "ruleTK_IF"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3344:1: ruleTK_IF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'if' ;
    public final AntlrDatatypeRuleToken ruleTK_IF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        int ruleTK_IF_StartIndex = input.index();
        Token kw=null;

         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 84) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3347:28: (kw= 'if' )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3349:2: kw= 'if'
            {
            kw=(Token)match(input,50,FOLLOW_50_in_ruleTK_IF6789); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getTK_IFAccess().getIfKeyword()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 84, ruleTK_IF_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleTK_IF"


    // $ANTLR start "entryRuleTK_ELSE"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3362:1: entryRuleTK_ELSE returns [String current=null] : iv_ruleTK_ELSE= ruleTK_ELSE EOF ;
    public final String entryRuleTK_ELSE() throws RecognitionException {
        String current = null;
        int entryRuleTK_ELSE_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_ruleTK_ELSE = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 85) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3363:2: (iv_ruleTK_ELSE= ruleTK_ELSE EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3364:2: iv_ruleTK_ELSE= ruleTK_ELSE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTK_ELSERule()); 
            }
            pushFollow(FOLLOW_ruleTK_ELSE_in_entryRuleTK_ELSE6829);
            iv_ruleTK_ELSE=ruleTK_ELSE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTK_ELSE.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTK_ELSE6840); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 85, entryRuleTK_ELSE_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleTK_ELSE"


    // $ANTLR start "ruleTK_ELSE"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3371:1: ruleTK_ELSE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'else' ;
    public final AntlrDatatypeRuleToken ruleTK_ELSE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        int ruleTK_ELSE_StartIndex = input.index();
        Token kw=null;

         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 86) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3374:28: (kw= 'else' )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3376:2: kw= 'else'
            {
            kw=(Token)match(input,51,FOLLOW_51_in_ruleTK_ELSE6877); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getTK_ELSEAccess().getElseKeyword()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 86, ruleTK_ELSE_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleTK_ELSE"


    // $ANTLR start "entryRuleTK_FOR"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3389:1: entryRuleTK_FOR returns [String current=null] : iv_ruleTK_FOR= ruleTK_FOR EOF ;
    public final String entryRuleTK_FOR() throws RecognitionException {
        String current = null;
        int entryRuleTK_FOR_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_ruleTK_FOR = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 87) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3390:2: (iv_ruleTK_FOR= ruleTK_FOR EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3391:2: iv_ruleTK_FOR= ruleTK_FOR EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTK_FORRule()); 
            }
            pushFollow(FOLLOW_ruleTK_FOR_in_entryRuleTK_FOR6917);
            iv_ruleTK_FOR=ruleTK_FOR();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTK_FOR.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTK_FOR6928); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 87, entryRuleTK_FOR_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleTK_FOR"


    // $ANTLR start "ruleTK_FOR"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3398:1: ruleTK_FOR returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'for' ;
    public final AntlrDatatypeRuleToken ruleTK_FOR() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        int ruleTK_FOR_StartIndex = input.index();
        Token kw=null;

         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 88) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3401:28: (kw= 'for' )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3403:2: kw= 'for'
            {
            kw=(Token)match(input,52,FOLLOW_52_in_ruleTK_FOR6965); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getTK_FORAccess().getForKeyword()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 88, ruleTK_FOR_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleTK_FOR"


    // $ANTLR start "entryRuleTK_WHILE"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3416:1: entryRuleTK_WHILE returns [String current=null] : iv_ruleTK_WHILE= ruleTK_WHILE EOF ;
    public final String entryRuleTK_WHILE() throws RecognitionException {
        String current = null;
        int entryRuleTK_WHILE_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_ruleTK_WHILE = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 89) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3417:2: (iv_ruleTK_WHILE= ruleTK_WHILE EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3418:2: iv_ruleTK_WHILE= ruleTK_WHILE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTK_WHILERule()); 
            }
            pushFollow(FOLLOW_ruleTK_WHILE_in_entryRuleTK_WHILE7005);
            iv_ruleTK_WHILE=ruleTK_WHILE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTK_WHILE.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTK_WHILE7016); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 89, entryRuleTK_WHILE_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleTK_WHILE"


    // $ANTLR start "ruleTK_WHILE"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3425:1: ruleTK_WHILE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'while' ;
    public final AntlrDatatypeRuleToken ruleTK_WHILE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        int ruleTK_WHILE_StartIndex = input.index();
        Token kw=null;

         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 90) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3428:28: (kw= 'while' )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3430:2: kw= 'while'
            {
            kw=(Token)match(input,53,FOLLOW_53_in_ruleTK_WHILE7053); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getTK_WHILEAccess().getWhileKeyword()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 90, ruleTK_WHILE_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleTK_WHILE"


    // $ANTLR start "entryRuleTK_NOT"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3443:1: entryRuleTK_NOT returns [String current=null] : iv_ruleTK_NOT= ruleTK_NOT EOF ;
    public final String entryRuleTK_NOT() throws RecognitionException {
        String current = null;
        int entryRuleTK_NOT_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_ruleTK_NOT = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 91) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3444:2: (iv_ruleTK_NOT= ruleTK_NOT EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3445:2: iv_ruleTK_NOT= ruleTK_NOT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTK_NOTRule()); 
            }
            pushFollow(FOLLOW_ruleTK_NOT_in_entryRuleTK_NOT7093);
            iv_ruleTK_NOT=ruleTK_NOT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTK_NOT.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTK_NOT7104); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 91, entryRuleTK_NOT_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleTK_NOT"


    // $ANTLR start "ruleTK_NOT"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3452:1: ruleTK_NOT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'not' ;
    public final AntlrDatatypeRuleToken ruleTK_NOT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        int ruleTK_NOT_StartIndex = input.index();
        Token kw=null;

         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 92) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3455:28: (kw= 'not' )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3457:2: kw= 'not'
            {
            kw=(Token)match(input,54,FOLLOW_54_in_ruleTK_NOT7141); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getTK_NOTAccess().getNotKeyword()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 92, ruleTK_NOT_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleTK_NOT"


    // $ANTLR start "entryRuleTK_INTDIV"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3470:1: entryRuleTK_INTDIV returns [String current=null] : iv_ruleTK_INTDIV= ruleTK_INTDIV EOF ;
    public final String entryRuleTK_INTDIV() throws RecognitionException {
        String current = null;
        int entryRuleTK_INTDIV_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_ruleTK_INTDIV = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 93) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3471:2: (iv_ruleTK_INTDIV= ruleTK_INTDIV EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3472:2: iv_ruleTK_INTDIV= ruleTK_INTDIV EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTK_INTDIVRule()); 
            }
            pushFollow(FOLLOW_ruleTK_INTDIV_in_entryRuleTK_INTDIV7181);
            iv_ruleTK_INTDIV=ruleTK_INTDIV();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTK_INTDIV.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTK_INTDIV7192); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 93, entryRuleTK_INTDIV_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleTK_INTDIV"


    // $ANTLR start "ruleTK_INTDIV"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3479:1: ruleTK_INTDIV returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'div' ;
    public final AntlrDatatypeRuleToken ruleTK_INTDIV() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        int ruleTK_INTDIV_StartIndex = input.index();
        Token kw=null;

         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 94) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3482:28: (kw= 'div' )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3484:2: kw= 'div'
            {
            kw=(Token)match(input,55,FOLLOW_55_in_ruleTK_INTDIV7229); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getTK_INTDIVAccess().getDivKeyword()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 94, ruleTK_INTDIV_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleTK_INTDIV"


    // $ANTLR start "entryRuleTK_INTMOD"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3497:1: entryRuleTK_INTMOD returns [String current=null] : iv_ruleTK_INTMOD= ruleTK_INTMOD EOF ;
    public final String entryRuleTK_INTMOD() throws RecognitionException {
        String current = null;
        int entryRuleTK_INTMOD_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_ruleTK_INTMOD = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 95) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3498:2: (iv_ruleTK_INTMOD= ruleTK_INTMOD EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3499:2: iv_ruleTK_INTMOD= ruleTK_INTMOD EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTK_INTMODRule()); 
            }
            pushFollow(FOLLOW_ruleTK_INTMOD_in_entryRuleTK_INTMOD7269);
            iv_ruleTK_INTMOD=ruleTK_INTMOD();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTK_INTMOD.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTK_INTMOD7280); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 95, entryRuleTK_INTMOD_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleTK_INTMOD"


    // $ANTLR start "ruleTK_INTMOD"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3506:1: ruleTK_INTMOD returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'mod' ;
    public final AntlrDatatypeRuleToken ruleTK_INTMOD() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        int ruleTK_INTMOD_StartIndex = input.index();
        Token kw=null;

         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 96) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3509:28: (kw= 'mod' )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3511:2: kw= 'mod'
            {
            kw=(Token)match(input,56,FOLLOW_56_in_ruleTK_INTMOD7317); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getTK_INTMODAccess().getModKeyword()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 96, ruleTK_INTMOD_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleTK_INTMOD"


    // $ANTLR start "entryRuleTK_TRUE"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3524:1: entryRuleTK_TRUE returns [String current=null] : iv_ruleTK_TRUE= ruleTK_TRUE EOF ;
    public final String entryRuleTK_TRUE() throws RecognitionException {
        String current = null;
        int entryRuleTK_TRUE_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_ruleTK_TRUE = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 97) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3525:2: (iv_ruleTK_TRUE= ruleTK_TRUE EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3526:2: iv_ruleTK_TRUE= ruleTK_TRUE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTK_TRUERule()); 
            }
            pushFollow(FOLLOW_ruleTK_TRUE_in_entryRuleTK_TRUE7357);
            iv_ruleTK_TRUE=ruleTK_TRUE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTK_TRUE.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTK_TRUE7368); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 97, entryRuleTK_TRUE_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleTK_TRUE"


    // $ANTLR start "ruleTK_TRUE"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3533:1: ruleTK_TRUE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'true' ;
    public final AntlrDatatypeRuleToken ruleTK_TRUE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        int ruleTK_TRUE_StartIndex = input.index();
        Token kw=null;

         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 98) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3536:28: (kw= 'true' )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3538:2: kw= 'true'
            {
            kw=(Token)match(input,57,FOLLOW_57_in_ruleTK_TRUE7405); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getTK_TRUEAccess().getTrueKeyword()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 98, ruleTK_TRUE_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleTK_TRUE"


    // $ANTLR start "entryRuleTK_FALSE"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3551:1: entryRuleTK_FALSE returns [String current=null] : iv_ruleTK_FALSE= ruleTK_FALSE EOF ;
    public final String entryRuleTK_FALSE() throws RecognitionException {
        String current = null;
        int entryRuleTK_FALSE_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_ruleTK_FALSE = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 99) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3552:2: (iv_ruleTK_FALSE= ruleTK_FALSE EOF )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3553:2: iv_ruleTK_FALSE= ruleTK_FALSE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTK_FALSERule()); 
            }
            pushFollow(FOLLOW_ruleTK_FALSE_in_entryRuleTK_FALSE7445);
            iv_ruleTK_FALSE=ruleTK_FALSE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTK_FALSE.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTK_FALSE7456); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 99, entryRuleTK_FALSE_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleTK_FALSE"


    // $ANTLR start "ruleTK_FALSE"
    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3560:1: ruleTK_FALSE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'false' ;
    public final AntlrDatatypeRuleToken ruleTK_FALSE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        int ruleTK_FALSE_StartIndex = input.index();
        Token kw=null;

         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 100) ) { return current; }
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3563:28: (kw= 'false' )
            // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3565:2: kw= 'false'
            {
            kw=(Token)match(input,58,FOLLOW_58_in_ruleTK_FALSE7493); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getTK_FALSEAccess().getFalseKeyword()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 100, ruleTK_FALSE_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleTK_FALSE"

    // $ANTLR start synpred1_InternalAsl
    public final void synpred1_InternalAsl_fragment() throws RecognitionException {   
        EObject lv_directive_0_0 = null;


        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:88:1: ( (lv_directive_0_0= ruleDirective ) )
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:88:1: (lv_directive_0_0= ruleDirective )
        {
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:88:1: (lv_directive_0_0= ruleDirective )
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:89:3: lv_directive_0_0= ruleDirective
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getAgentAccess().getDirectiveDirectiveParserRuleCall_0_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleDirective_in_synpred1_InternalAsl144);
        lv_directive_0_0=ruleDirective();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred1_InternalAsl

    // $ANTLR start synpred2_InternalAsl
    public final void synpred2_InternalAsl_fragment() throws RecognitionException {   
        EObject lv_directive_2_0 = null;


        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:124:1: ( (lv_directive_2_0= ruleDirective ) )
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:124:1: (lv_directive_2_0= ruleDirective )
        {
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:124:1: (lv_directive_2_0= ruleDirective )
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:125:3: lv_directive_2_0= ruleDirective
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getAgentAccess().getDirectiveDirectiveParserRuleCall_1_1_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleDirective_in_synpred2_InternalAsl188);
        lv_directive_2_0=ruleDirective();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred2_InternalAsl

    // $ANTLR start synpred3_InternalAsl
    public final void synpred3_InternalAsl_fragment() throws RecognitionException {   
        EObject lv_belief_1_0 = null;

        EObject lv_directive_2_0 = null;


        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:105:4: ( ( (lv_belief_1_0= ruleBelief ) ) ( (lv_directive_2_0= ruleDirective ) )* )
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:105:4: ( (lv_belief_1_0= ruleBelief ) ) ( (lv_directive_2_0= ruleDirective ) )*
        {
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:105:4: ( (lv_belief_1_0= ruleBelief ) )
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:106:1: (lv_belief_1_0= ruleBelief )
        {
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:106:1: (lv_belief_1_0= ruleBelief )
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:107:3: lv_belief_1_0= ruleBelief
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getAgentAccess().getBeliefBeliefParserRuleCall_1_0_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleBelief_in_synpred3_InternalAsl167);
        lv_belief_1_0=ruleBelief();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:123:2: ( (lv_directive_2_0= ruleDirective ) )*
        loop66:
        do {
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==18) ) {
                alt66=1;
            }


            switch (alt66) {
        	case 1 :
        	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:124:1: (lv_directive_2_0= ruleDirective )
        	    {
        	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:124:1: (lv_directive_2_0= ruleDirective )
        	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:125:3: lv_directive_2_0= ruleDirective
        	    {
        	    if ( state.backtracking==0 ) {
        	       
        	      	        newCompositeNode(grammarAccess.getAgentAccess().getDirectiveDirectiveParserRuleCall_1_1_0()); 
        	      	    
        	    }
        	    pushFollow(FOLLOW_ruleDirective_in_synpred3_InternalAsl188);
        	    lv_directive_2_0=ruleDirective();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;

        	default :
        	    break loop66;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred3_InternalAsl

    // $ANTLR start synpred4_InternalAsl
    public final void synpred4_InternalAsl_fragment() throws RecognitionException {   
        EObject lv_directive_4_0 = null;


        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:160:1: ( (lv_directive_4_0= ruleDirective ) )
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:160:1: (lv_directive_4_0= ruleDirective )
        {
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:160:1: (lv_directive_4_0= ruleDirective )
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:161:3: lv_directive_4_0= ruleDirective
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getAgentAccess().getDirectiveDirectiveParserRuleCall_2_1_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleDirective_in_synpred4_InternalAsl234);
        lv_directive_4_0=ruleDirective();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred4_InternalAsl

    // $ANTLR start synpred5_InternalAsl
    public final void synpred5_InternalAsl_fragment() throws RecognitionException {   
        EObject lv_initial_goal_3_0 = null;

        EObject lv_directive_4_0 = null;


        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:141:6: ( ( (lv_initial_goal_3_0= ruleInitial_goal ) ) ( (lv_directive_4_0= ruleDirective ) )* )
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:141:6: ( (lv_initial_goal_3_0= ruleInitial_goal ) ) ( (lv_directive_4_0= ruleDirective ) )*
        {
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:141:6: ( (lv_initial_goal_3_0= ruleInitial_goal ) )
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:142:1: (lv_initial_goal_3_0= ruleInitial_goal )
        {
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:142:1: (lv_initial_goal_3_0= ruleInitial_goal )
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:143:3: lv_initial_goal_3_0= ruleInitial_goal
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getAgentAccess().getInitial_goalInitial_goalParserRuleCall_2_0_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleInitial_goal_in_synpred5_InternalAsl213);
        lv_initial_goal_3_0=ruleInitial_goal();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:159:2: ( (lv_directive_4_0= ruleDirective ) )*
        loop67:
        do {
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==18) ) {
                alt67=1;
            }


            switch (alt67) {
        	case 1 :
        	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:160:1: (lv_directive_4_0= ruleDirective )
        	    {
        	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:160:1: (lv_directive_4_0= ruleDirective )
        	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:161:3: lv_directive_4_0= ruleDirective
        	    {
        	    if ( state.backtracking==0 ) {
        	       
        	      	        newCompositeNode(grammarAccess.getAgentAccess().getDirectiveDirectiveParserRuleCall_2_1_0()); 
        	      	    
        	    }
        	    pushFollow(FOLLOW_ruleDirective_in_synpred5_InternalAsl234);
        	    lv_directive_4_0=ruleDirective();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;

        	default :
        	    break loop67;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred5_InternalAsl

    // $ANTLR start synpred6_InternalAsl
    public final void synpred6_InternalAsl_fragment() throws RecognitionException {   
        EObject lv_belief_6_0 = null;


        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:196:1: ( (lv_belief_6_0= ruleBelief ) )
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:196:1: (lv_belief_6_0= ruleBelief )
        {
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:196:1: (lv_belief_6_0= ruleBelief )
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:197:3: lv_belief_6_0= ruleBelief
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getAgentAccess().getBeliefBeliefParserRuleCall_3_1_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleBelief_in_synpred6_InternalAsl280);
        lv_belief_6_0=ruleBelief();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred6_InternalAsl

    // $ANTLR start synpred7_InternalAsl
    public final void synpred7_InternalAsl_fragment() throws RecognitionException {   
        EObject lv_directive_7_0 = null;


        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:214:1: ( (lv_directive_7_0= ruleDirective ) )
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:214:1: (lv_directive_7_0= ruleDirective )
        {
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:214:1: (lv_directive_7_0= ruleDirective )
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:215:3: lv_directive_7_0= ruleDirective
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getAgentAccess().getDirectiveDirectiveParserRuleCall_3_2_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleDirective_in_synpred7_InternalAsl302);
        lv_directive_7_0=ruleDirective();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred7_InternalAsl

    // $ANTLR start synpred8_InternalAsl
    public final void synpred8_InternalAsl_fragment() throws RecognitionException {   
        EObject lv_plan_5_0 = null;

        EObject lv_belief_6_0 = null;

        EObject lv_directive_7_0 = null;


        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:177:6: ( ( (lv_plan_5_0= rulePlan ) ) ( (lv_belief_6_0= ruleBelief ) )* ( (lv_directive_7_0= ruleDirective ) )* )
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:177:6: ( (lv_plan_5_0= rulePlan ) ) ( (lv_belief_6_0= ruleBelief ) )* ( (lv_directive_7_0= ruleDirective ) )*
        {
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:177:6: ( (lv_plan_5_0= rulePlan ) )
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:178:1: (lv_plan_5_0= rulePlan )
        {
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:178:1: (lv_plan_5_0= rulePlan )
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:179:3: lv_plan_5_0= rulePlan
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getAgentAccess().getPlanPlanParserRuleCall_3_0_0()); 
          	    
        }
        pushFollow(FOLLOW_rulePlan_in_synpred8_InternalAsl259);
        lv_plan_5_0=rulePlan();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:195:2: ( (lv_belief_6_0= ruleBelief ) )*
        loop68:
        do {
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==RULE_TK_NEG||LA68_0==RULE_ATOM||LA68_0==21||(LA68_0>=48 && LA68_0<=49)||(LA68_0>=57 && LA68_0<=58)) ) {
                alt68=1;
            }


            switch (alt68) {
        	case 1 :
        	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:196:1: (lv_belief_6_0= ruleBelief )
        	    {
        	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:196:1: (lv_belief_6_0= ruleBelief )
        	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:197:3: lv_belief_6_0= ruleBelief
        	    {
        	    if ( state.backtracking==0 ) {
        	       
        	      	        newCompositeNode(grammarAccess.getAgentAccess().getBeliefBeliefParserRuleCall_3_1_0()); 
        	      	    
        	    }
        	    pushFollow(FOLLOW_ruleBelief_in_synpred8_InternalAsl280);
        	    lv_belief_6_0=ruleBelief();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;

        	default :
        	    break loop68;
            }
        } while (true);

        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:213:3: ( (lv_directive_7_0= ruleDirective ) )*
        loop69:
        do {
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==18) ) {
                alt69=1;
            }


            switch (alt69) {
        	case 1 :
        	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:214:1: (lv_directive_7_0= ruleDirective )
        	    {
        	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:214:1: (lv_directive_7_0= ruleDirective )
        	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:215:3: lv_directive_7_0= ruleDirective
        	    {
        	    if ( state.backtracking==0 ) {
        	       
        	      	        newCompositeNode(grammarAccess.getAgentAccess().getDirectiveDirectiveParserRuleCall_3_2_0()); 
        	      	    
        	    }
        	    pushFollow(FOLLOW_ruleDirective_in_synpred8_InternalAsl302);
        	    lv_directive_7_0=ruleDirective();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;

        	default :
        	    break loop69;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred8_InternalAsl

    // $ANTLR start synpred23_InternalAsl
    public final void synpred23_InternalAsl_fragment() throws RecognitionException {   
        EObject lv_plan_body_5_0 = null;


        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:803:1: ( (lv_plan_body_5_0= rulePlan_body ) )
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:803:1: (lv_plan_body_5_0= rulePlan_body )
        {
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:803:1: (lv_plan_body_5_0= rulePlan_body )
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:804:3: lv_plan_body_5_0= rulePlan_body
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getPlan_bodyAccess().getPlan_bodyPlan_bodyParserRuleCall_2_0()); 
          	    
        }
        pushFollow(FOLLOW_rulePlan_body_in_synpred23_InternalAsl1504);
        lv_plan_body_5_0=rulePlan_body();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred23_InternalAsl

    // $ANTLR start synpred31_InternalAsl
    public final void synpred31_InternalAsl_fragment() throws RecognitionException {   
        Token otherlv_4=null;
        Token otherlv_5=null;

        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1146:6: ( (otherlv_4= '-' (otherlv_5= '+' )? ) )
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1146:6: (otherlv_4= '-' (otherlv_5= '+' )? )
        {
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1146:6: (otherlv_4= '-' (otherlv_5= '+' )? )
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1146:8: otherlv_4= '-' (otherlv_5= '+' )?
        {
        otherlv_4=(Token)match(input,26,FOLLOW_26_in_synpred31_InternalAsl2182); if (state.failed) return ;
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1150:1: (otherlv_5= '+' )?
        int alt71=2;
        int LA71_0 = input.LA(1);

        if ( (LA71_0==25) ) {
            alt71=1;
        }
        switch (alt71) {
            case 1 :
                // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1150:3: otherlv_5= '+'
                {
                otherlv_5=(Token)match(input,25,FOLLOW_25_in_synpred31_InternalAsl2195); if (state.failed) return ;

                }
                break;

        }


        }


        }
    }
    // $ANTLR end synpred31_InternalAsl

    // $ANTLR start synpred36_InternalAsl
    public final void synpred36_InternalAsl_fragment() throws RecognitionException {   
        Token lv_tk_label_at_2_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject lv_pred_3_0 = null;

        EObject lv_trigger_4_0 = null;

        EObject lv_log_expr_6_0 = null;


        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1206:2: ( ( ( (lv_tk_label_at_2_0= RULE_TK_LABEL_AT ) ) ( (lv_pred_3_0= rulePred ) ) )? ( (lv_trigger_4_0= ruleTrigger ) ) (otherlv_5= ':' ( (lv_log_expr_6_0= ruleLog_expr ) ) )? (otherlv_7= '<-' | otherlv_8= ';' )? )
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1206:2: ( ( (lv_tk_label_at_2_0= RULE_TK_LABEL_AT ) ) ( (lv_pred_3_0= rulePred ) ) )? ( (lv_trigger_4_0= ruleTrigger ) ) (otherlv_5= ':' ( (lv_log_expr_6_0= ruleLog_expr ) ) )? (otherlv_7= '<-' | otherlv_8= ';' )?
        {
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1206:2: ( ( (lv_tk_label_at_2_0= RULE_TK_LABEL_AT ) ) ( (lv_pred_3_0= rulePred ) ) )?
        int alt72=2;
        int LA72_0 = input.LA(1);

        if ( (LA72_0==RULE_TK_LABEL_AT) ) {
            alt72=1;
        }
        switch (alt72) {
            case 1 :
                // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1206:3: ( (lv_tk_label_at_2_0= RULE_TK_LABEL_AT ) ) ( (lv_pred_3_0= rulePred ) )
                {
                // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1206:3: ( (lv_tk_label_at_2_0= RULE_TK_LABEL_AT ) )
                // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1207:1: (lv_tk_label_at_2_0= RULE_TK_LABEL_AT )
                {
                // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1207:1: (lv_tk_label_at_2_0= RULE_TK_LABEL_AT )
                // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1208:3: lv_tk_label_at_2_0= RULE_TK_LABEL_AT
                {
                lv_tk_label_at_2_0=(Token)match(input,RULE_TK_LABEL_AT,FOLLOW_RULE_TK_LABEL_AT_in_synpred36_InternalAsl2335); if (state.failed) return ;

                }


                }

                // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1224:2: ( (lv_pred_3_0= rulePred ) )
                // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1225:1: (lv_pred_3_0= rulePred )
                {
                // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1225:1: (lv_pred_3_0= rulePred )
                // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1226:3: lv_pred_3_0= rulePred
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getPlan_termAccess().getPredPredParserRuleCall_2_0_1_0()); 
                  	    
                }
                pushFollow(FOLLOW_rulePred_in_synpred36_InternalAsl2361);
                lv_pred_3_0=rulePred();

                state._fsp--;
                if (state.failed) return ;

                }


                }


                }
                break;

        }

        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1242:4: ( (lv_trigger_4_0= ruleTrigger ) )
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1243:1: (lv_trigger_4_0= ruleTrigger )
        {
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1243:1: (lv_trigger_4_0= ruleTrigger )
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1244:3: lv_trigger_4_0= ruleTrigger
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getPlan_termAccess().getTriggerTriggerParserRuleCall_2_1_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleTrigger_in_synpred36_InternalAsl2384);
        lv_trigger_4_0=ruleTrigger();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1260:2: (otherlv_5= ':' ( (lv_log_expr_6_0= ruleLog_expr ) ) )?
        int alt73=2;
        int LA73_0 = input.LA(1);

        if ( (LA73_0==23) ) {
            alt73=1;
        }
        switch (alt73) {
            case 1 :
                // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1260:4: otherlv_5= ':' ( (lv_log_expr_6_0= ruleLog_expr ) )
                {
                otherlv_5=(Token)match(input,23,FOLLOW_23_in_synpred36_InternalAsl2397); if (state.failed) return ;
                // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1264:1: ( (lv_log_expr_6_0= ruleLog_expr ) )
                // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1265:1: (lv_log_expr_6_0= ruleLog_expr )
                {
                // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1265:1: (lv_log_expr_6_0= ruleLog_expr )
                // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1266:3: lv_log_expr_6_0= ruleLog_expr
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getPlan_termAccess().getLog_exprLog_exprParserRuleCall_2_2_1_0()); 
                  	    
                }
                pushFollow(FOLLOW_ruleLog_expr_in_synpred36_InternalAsl2418);
                lv_log_expr_6_0=ruleLog_expr();

                state._fsp--;
                if (state.failed) return ;

                }


                }


                }
                break;

        }

        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1282:4: (otherlv_7= '<-' | otherlv_8= ';' )?
        int alt74=3;
        int LA74_0 = input.LA(1);

        if ( (LA74_0==24) ) {
            alt74=1;
        }
        else if ( (LA74_0==29) ) {
            alt74=2;
        }
        switch (alt74) {
            case 1 :
                // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1282:6: otherlv_7= '<-'
                {
                otherlv_7=(Token)match(input,24,FOLLOW_24_in_synpred36_InternalAsl2433); if (state.failed) return ;

                }
                break;
            case 2 :
                // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1287:7: otherlv_8= ';'
                {
                otherlv_8=(Token)match(input,29,FOLLOW_29_in_synpred36_InternalAsl2451); if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred36_InternalAsl

    // $ANTLR start synpred43_InternalAsl
    public final void synpred43_InternalAsl_fragment() throws RecognitionException {   
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_terms_4_0 = null;


        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1485:5: (otherlv_3= '(' ( (lv_terms_4_0= ruleTerms ) ) otherlv_5= ')' )
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1485:5: otherlv_3= '(' ( (lv_terms_4_0= ruleTerms ) ) otherlv_5= ')'
        {
        otherlv_3=(Token)match(input,30,FOLLOW_30_in_synpred43_InternalAsl2821); if (state.failed) return ;
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1489:1: ( (lv_terms_4_0= ruleTerms ) )
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1490:1: (lv_terms_4_0= ruleTerms )
        {
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1490:1: (lv_terms_4_0= ruleTerms )
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:1491:3: lv_terms_4_0= ruleTerms
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getPredAccess().getTermsTermsParserRuleCall_1_1_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleTerms_in_synpred43_InternalAsl2842);
        lv_terms_4_0=ruleTerms();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_5=(Token)match(input,31,FOLLOW_31_in_synpred43_InternalAsl2854); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred43_InternalAsl

    // $ANTLR start synpred72_InternalAsl
    public final void synpred72_InternalAsl_fragment() throws RecognitionException {   
        AntlrDatatypeRuleToken lv_subadd_1_0 = null;

        EObject lv_arithm_expr_2_0 = null;


        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2398:3: ( ( (lv_subadd_1_0= ruleTK_SUB_ADD ) ) ( (lv_arithm_expr_2_0= ruleArithm_expr ) ) )
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2398:3: ( (lv_subadd_1_0= ruleTK_SUB_ADD ) ) ( (lv_arithm_expr_2_0= ruleArithm_expr ) )
        {
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2398:3: ( (lv_subadd_1_0= ruleTK_SUB_ADD ) )
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2399:1: (lv_subadd_1_0= ruleTK_SUB_ADD )
        {
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2399:1: (lv_subadd_1_0= ruleTK_SUB_ADD )
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2400:3: lv_subadd_1_0= ruleTK_SUB_ADD
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getArithm_exprAccess().getSubaddTK_SUB_ADDParserRuleCall_1_0_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleTK_SUB_ADD_in_synpred72_InternalAsl4618);
        lv_subadd_1_0=ruleTK_SUB_ADD();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2416:2: ( (lv_arithm_expr_2_0= ruleArithm_expr ) )
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2417:1: (lv_arithm_expr_2_0= ruleArithm_expr )
        {
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2417:1: (lv_arithm_expr_2_0= ruleArithm_expr )
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:2418:3: lv_arithm_expr_2_0= ruleArithm_expr
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getArithm_exprAccess().getArithm_exprArithm_exprParserRuleCall_1_1_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleArithm_expr_in_synpred72_InternalAsl4639);
        lv_arithm_expr_2_0=ruleArithm_expr();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred72_InternalAsl

    // $ANTLR start synpred86_InternalAsl
    public final void synpred86_InternalAsl_fragment() throws RecognitionException {   
        Token lv_decimalPart_2_0=null;

        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3090:1: ( (lv_decimalPart_2_0= RULE_NUMBERT ) )
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3090:1: (lv_decimalPart_2_0= RULE_NUMBERT )
        {
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3090:1: (lv_decimalPart_2_0= RULE_NUMBERT )
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3091:3: lv_decimalPart_2_0= RULE_NUMBERT
        {
        lv_decimalPart_2_0=(Token)match(input,RULE_NUMBERT,FOLLOW_RULE_NUMBERT_in_synpred86_InternalAsl6074); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred86_InternalAsl

    // $ANTLR start synpred87_InternalAsl
    public final void synpred87_InternalAsl_fragment() throws RecognitionException {   
        Token lv_number_0_0=null;
        Token otherlv_1=null;
        Token lv_decimalPart_2_0=null;

        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3067:2: ( ( ( (lv_number_0_0= RULE_NUMBERT ) )+ otherlv_1= '.' ( (lv_decimalPart_2_0= RULE_NUMBERT ) )+ ) )
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3067:2: ( ( (lv_number_0_0= RULE_NUMBERT ) )+ otherlv_1= '.' ( (lv_decimalPart_2_0= RULE_NUMBERT ) )+ )
        {
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3067:2: ( ( (lv_number_0_0= RULE_NUMBERT ) )+ otherlv_1= '.' ( (lv_decimalPart_2_0= RULE_NUMBERT ) )+ )
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3067:3: ( (lv_number_0_0= RULE_NUMBERT ) )+ otherlv_1= '.' ( (lv_decimalPart_2_0= RULE_NUMBERT ) )+
        {
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3067:3: ( (lv_number_0_0= RULE_NUMBERT ) )+
        int cnt82=0;
        loop82:
        do {
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==RULE_NUMBERT) ) {
                alt82=1;
            }


            switch (alt82) {
        	case 1 :
        	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3068:1: (lv_number_0_0= RULE_NUMBERT )
        	    {
        	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3068:1: (lv_number_0_0= RULE_NUMBERT )
        	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3069:3: lv_number_0_0= RULE_NUMBERT
        	    {
        	    lv_number_0_0=(Token)match(input,RULE_NUMBERT,FOLLOW_RULE_NUMBERT_in_synpred87_InternalAsl6039); if (state.failed) return ;

        	    }


        	    }
        	    break;

        	default :
        	    if ( cnt82 >= 1 ) break loop82;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(82, input);
                    throw eee;
            }
            cnt82++;
        } while (true);

        otherlv_1=(Token)match(input,21,FOLLOW_21_in_synpred87_InternalAsl6057); if (state.failed) return ;
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3089:1: ( (lv_decimalPart_2_0= RULE_NUMBERT ) )+
        int cnt83=0;
        loop83:
        do {
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==RULE_NUMBERT) ) {
                alt83=1;
            }


            switch (alt83) {
        	case 1 :
        	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3090:1: (lv_decimalPart_2_0= RULE_NUMBERT )
        	    {
        	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3090:1: (lv_decimalPart_2_0= RULE_NUMBERT )
        	    // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3091:3: lv_decimalPart_2_0= RULE_NUMBERT
        	    {
        	    lv_decimalPart_2_0=(Token)match(input,RULE_NUMBERT,FOLLOW_RULE_NUMBERT_in_synpred87_InternalAsl6074); if (state.failed) return ;

        	    }


        	    }
        	    break;

        	default :
        	    if ( cnt83 >= 1 ) break loop83;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(83, input);
                    throw eee;
            }
            cnt83++;
        } while (true);


        }


        }
    }
    // $ANTLR end synpred87_InternalAsl

    // $ANTLR start synpred88_InternalAsl
    public final void synpred88_InternalAsl_fragment() throws RecognitionException {   
        Token lv_decimalPart_4_0=null;

        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3113:1: ( (lv_decimalPart_4_0= RULE_NUMBERT ) )
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3113:1: (lv_decimalPart_4_0= RULE_NUMBERT )
        {
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3113:1: (lv_decimalPart_4_0= RULE_NUMBERT )
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3114:3: lv_decimalPart_4_0= RULE_NUMBERT
        {
        lv_decimalPart_4_0=(Token)match(input,RULE_NUMBERT,FOLLOW_RULE_NUMBERT_in_synpred88_InternalAsl6117); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred88_InternalAsl

    // $ANTLR start synpred90_InternalAsl
    public final void synpred90_InternalAsl_fragment() throws RecognitionException {   
        Token lv_number_5_0=null;

        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3132:1: ( (lv_number_5_0= RULE_NUMBERT ) )
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3132:1: (lv_number_5_0= RULE_NUMBERT )
        {
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3132:1: (lv_number_5_0= RULE_NUMBERT )
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3133:3: lv_number_5_0= RULE_NUMBERT
        {
        lv_number_5_0=(Token)match(input,RULE_NUMBERT,FOLLOW_RULE_NUMBERT_in_synpred90_InternalAsl6147); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred90_InternalAsl

    // $ANTLR start synpred91_InternalAsl
    public final void synpred91_InternalAsl_fragment() throws RecognitionException {   
        AntlrDatatypeRuleToken this_JASON_ATOM_TAIL_1 = null;


        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3192:5: (this_JASON_ATOM_TAIL_1= ruleJASON_ATOM_TAIL )
        // ../jasonide.xtext.asl/src-gen/jasonide/xtext/asl/parser/antlr/internal/InternalAsl.g:3192:5: this_JASON_ATOM_TAIL_1= ruleJASON_ATOM_TAIL
        {
        if ( state.backtracking==0 ) {
           
                  newCompositeNode(grammarAccess.getJASON_ATOMAccess().getJASON_ATOM_TAILParserRuleCall_1()); 
              
        }
        pushFollow(FOLLOW_ruleJASON_ATOM_TAIL_in_synpred91_InternalAsl6290);
        this_JASON_ATOM_TAIL_1=ruleJASON_ATOM_TAIL();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred91_InternalAsl

    // Delegated rules

    public final boolean synpred7_InternalAsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalAsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalAsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalAsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred31_InternalAsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred31_InternalAsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalAsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalAsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred87_InternalAsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred87_InternalAsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred90_InternalAsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred90_InternalAsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred43_InternalAsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred43_InternalAsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred72_InternalAsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred72_InternalAsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalAsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalAsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred88_InternalAsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred88_InternalAsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalAsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalAsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred86_InternalAsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred86_InternalAsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred23_InternalAsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_InternalAsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred91_InternalAsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred91_InternalAsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalAsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalAsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalAsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalAsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred36_InternalAsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred36_InternalAsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalAsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalAsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA3 dfa3 = new DFA3(this);
    protected DFA6 dfa6 = new DFA6(this);
    protected DFA19 dfa19 = new DFA19(this);
    protected DFA23 dfa23 = new DFA23(this);
    protected DFA27 dfa27 = new DFA27(this);
    protected DFA32 dfa32 = new DFA32(this);
    protected DFA50 dfa50 = new DFA50(this);
    static final String DFA3_eotS =
        "\12\uffff";
    static final String DFA3_eofS =
        "\1\1\11\uffff";
    static final String DFA3_minS =
        "\1\4\1\uffff\7\0\1\uffff";
    static final String DFA3_maxS =
        "\1\72\1\uffff\7\0\1\uffff";
    static final String DFA3_acceptS =
        "\1\uffff\1\2\7\uffff\1\1";
    static final String DFA3_specialS =
        "\2\uffff\1\2\1\1\1\0\1\3\1\5\1\6\1\4\1\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\1\1\2\4\uffff\1\4\7\uffff\1\1\2\uffff\1\3\1\1\2\uffff\3\1"+
            "\24\uffff\1\5\1\6\7\uffff\1\7\1\10",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            ""
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "()* loopback of 105:3: ( ( (lv_belief_1_0= ruleBelief ) ) ( (lv_directive_2_0= ruleDirective ) )* )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA3_4 = input.LA(1);

                         
                        int index3_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalAsl()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index3_4);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA3_3 = input.LA(1);

                         
                        int index3_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalAsl()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index3_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA3_2 = input.LA(1);

                         
                        int index3_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalAsl()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index3_2);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA3_5 = input.LA(1);

                         
                        int index3_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalAsl()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index3_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA3_8 = input.LA(1);

                         
                        int index3_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalAsl()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index3_8);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA3_6 = input.LA(1);

                         
                        int index3_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalAsl()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index3_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA3_7 = input.LA(1);

                         
                        int index3_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalAsl()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index3_7);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 3, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA6_eotS =
        "\20\uffff";
    static final String DFA6_eofS =
        "\1\1\17\uffff";
    static final String DFA6_minS =
        "\1\4\2\uffff\7\0\6\uffff";
    static final String DFA6_maxS =
        "\1\72\2\uffff\7\0\6\uffff";
    static final String DFA6_acceptS =
        "\1\uffff\1\2\15\uffff\1\1";
    static final String DFA6_specialS =
        "\3\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\6\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\1\1\3\4\uffff\1\5\7\uffff\1\1\2\uffff\1\4\1\1\2\uffff\3\1"+
            "\24\uffff\1\6\1\7\7\uffff\1\10\1\11",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "()* loopback of 195:2: ( (lv_belief_6_0= ruleBelief ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA6_3 = input.LA(1);

                         
                        int index6_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_InternalAsl()) ) {s = 15;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index6_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA6_4 = input.LA(1);

                         
                        int index6_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_InternalAsl()) ) {s = 15;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index6_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA6_5 = input.LA(1);

                         
                        int index6_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_InternalAsl()) ) {s = 15;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index6_5);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA6_6 = input.LA(1);

                         
                        int index6_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_InternalAsl()) ) {s = 15;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index6_6);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA6_7 = input.LA(1);

                         
                        int index6_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_InternalAsl()) ) {s = 15;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index6_7);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA6_8 = input.LA(1);

                         
                        int index6_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_InternalAsl()) ) {s = 15;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index6_8);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA6_9 = input.LA(1);

                         
                        int index6_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_InternalAsl()) ) {s = 15;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index6_9);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 6, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA19_eotS =
        "\30\uffff";
    static final String DFA19_eofS =
        "\1\26\27\uffff";
    static final String DFA19_minS =
        "\1\5\12\uffff\1\0\14\uffff";
    static final String DFA19_maxS =
        "\1\72\12\uffff\1\0\14\uffff";
    static final String DFA19_acceptS =
        "\1\uffff\1\1\24\uffff\1\2\1\uffff";
    static final String DFA19_specialS =
        "\13\uffff\1\0\14\uffff}>";
    static final String[] DFA19_transitionS = {
            "\6\1\10\uffff\1\26\1\uffff\1\13\1\1\2\uffff\2\1\1\uffff\1\1"+
            "\1\uffff\1\1\1\uffff\1\1\17\uffff\3\1\1\uffff\3\1\2\uffff\2"+
            "\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "802:3: ( (lv_plan_body_5_0= rulePlan_body ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA19_11 = input.LA(1);

                         
                        int index19_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalAsl()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index19_11);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 19, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA23_eotS =
        "\24\uffff";
    static final String DFA23_eofS =
        "\24\uffff";
    static final String DFA23_minS =
        "\1\5\4\uffff\1\0\16\uffff";
    static final String DFA23_maxS =
        "\1\72\4\uffff\1\0\16\uffff";
    static final String DFA23_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\uffff\1\6\14\uffff\1\5";
    static final String DFA23_specialS =
        "\5\uffff\1\0\16\uffff}>";
    static final String[] DFA23_transitionS = {
            "\6\6\12\uffff\1\6\1\1\2\uffff\1\4\1\5\1\uffff\1\3\1\uffff\1"+
            "\6\1\uffff\1\2\17\uffff\2\6\4\uffff\1\6\2\uffff\2\6",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA23_eot = DFA.unpackEncodedString(DFA23_eotS);
    static final short[] DFA23_eof = DFA.unpackEncodedString(DFA23_eofS);
    static final char[] DFA23_min = DFA.unpackEncodedStringToUnsignedChars(DFA23_minS);
    static final char[] DFA23_max = DFA.unpackEncodedStringToUnsignedChars(DFA23_maxS);
    static final short[] DFA23_accept = DFA.unpackEncodedString(DFA23_acceptS);
    static final short[] DFA23_special = DFA.unpackEncodedString(DFA23_specialS);
    static final short[][] DFA23_transition;

    static {
        int numStates = DFA23_transitionS.length;
        DFA23_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA23_transition[i] = DFA.unpackEncodedString(DFA23_transitionS[i]);
        }
    }

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = DFA23_eot;
            this.eof = DFA23_eof;
            this.min = DFA23_min;
            this.max = DFA23_max;
            this.accept = DFA23_accept;
            this.special = DFA23_special;
            this.transition = DFA23_transition;
        }
        public String getDescription() {
            return "1126:2: (otherlv_0= '!' | otherlv_1= '!!' | otherlv_2= '?' | otherlv_3= '+' | (otherlv_4= '-' (otherlv_5= '+' )? ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA23_5 = input.LA(1);

                         
                        int index23_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_InternalAsl()) ) {s = 19;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index23_5);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 23, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA27_eotS =
        "\31\uffff";
    static final String DFA27_eofS =
        "\31\uffff";
    static final String DFA27_minS =
        "\1\4\1\uffff\2\0\25\uffff";
    static final String DFA27_maxS =
        "\1\72\1\uffff\2\0\25\uffff";
    static final String DFA27_acceptS =
        "\1\uffff\1\1\3\uffff\1\2\23\uffff";
    static final String DFA27_specialS =
        "\2\uffff\1\0\1\1\25\uffff}>";
    static final String[] DFA27_transitionS = {
            "\1\1\6\5\10\uffff\1\5\1\uffff\2\5\2\uffff\1\2\1\3\1\1\1\5\1"+
            "\uffff\1\5\1\uffff\1\5\17\uffff\3\5\1\uffff\3\5\2\uffff\2\5",
            "",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA27_eot = DFA.unpackEncodedString(DFA27_eotS);
    static final short[] DFA27_eof = DFA.unpackEncodedString(DFA27_eofS);
    static final char[] DFA27_min = DFA.unpackEncodedStringToUnsignedChars(DFA27_minS);
    static final char[] DFA27_max = DFA.unpackEncodedStringToUnsignedChars(DFA27_maxS);
    static final short[] DFA27_accept = DFA.unpackEncodedString(DFA27_acceptS);
    static final short[] DFA27_special = DFA.unpackEncodedString(DFA27_specialS);
    static final short[][] DFA27_transition;

    static {
        int numStates = DFA27_transitionS.length;
        DFA27_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA27_transition[i] = DFA.unpackEncodedString(DFA27_transitionS[i]);
        }
    }

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = DFA27_eot;
            this.eof = DFA27_eof;
            this.min = DFA27_min;
            this.max = DFA27_max;
            this.accept = DFA27_accept;
            this.special = DFA27_special;
            this.transition = DFA27_transition;
        }
        public String getDescription() {
            return "1206:1: ( ( ( (lv_tk_label_at_2_0= RULE_TK_LABEL_AT ) ) ( (lv_pred_3_0= rulePred ) ) )? ( (lv_trigger_4_0= ruleTrigger ) ) (otherlv_5= ':' ( (lv_log_expr_6_0= ruleLog_expr ) ) )? (otherlv_7= '<-' | otherlv_8= ';' )? )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA27_2 = input.LA(1);

                         
                        int index27_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalAsl()) ) {s = 1;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index27_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA27_3 = input.LA(1);

                         
                        int index27_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalAsl()) ) {s = 1;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index27_3);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 27, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA32_eotS =
        "\61\uffff";
    static final String DFA32_eofS =
        "\1\2\60\uffff";
    static final String DFA32_minS =
        "\1\5\1\0\57\uffff";
    static final String DFA32_maxS =
        "\1\72\1\0\57\uffff";
    static final String DFA32_acceptS =
        "\2\uffff\1\2\55\uffff\1\1";
    static final String DFA32_specialS =
        "\1\uffff\1\0\57\uffff}>";
    static final String[] DFA32_transitionS = {
            "\6\2\7\uffff\14\2\1\1\24\2\1\uffff\7\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA32_eot = DFA.unpackEncodedString(DFA32_eotS);
    static final short[] DFA32_eof = DFA.unpackEncodedString(DFA32_eofS);
    static final char[] DFA32_min = DFA.unpackEncodedStringToUnsignedChars(DFA32_minS);
    static final char[] DFA32_max = DFA.unpackEncodedStringToUnsignedChars(DFA32_maxS);
    static final short[] DFA32_accept = DFA.unpackEncodedString(DFA32_acceptS);
    static final short[] DFA32_special = DFA.unpackEncodedString(DFA32_specialS);
    static final short[][] DFA32_transition;

    static {
        int numStates = DFA32_transitionS.length;
        DFA32_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA32_transition[i] = DFA.unpackEncodedString(DFA32_transitionS[i]);
        }
    }

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = DFA32_eot;
            this.eof = DFA32_eof;
            this.min = DFA32_min;
            this.max = DFA32_max;
            this.accept = DFA32_accept;
            this.special = DFA32_special;
            this.transition = DFA32_transition;
        }
        public String getDescription() {
            return "1485:3: (otherlv_3= '(' ( (lv_terms_4_0= ruleTerms ) ) otherlv_5= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA32_1 = input.LA(1);

                         
                        int index32_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalAsl()) ) {s = 48;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index32_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 32, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA50_eotS =
        "\47\uffff";
    static final String DFA50_eofS =
        "\1\3\46\uffff";
    static final String DFA50_minS =
        "\1\5\2\0\44\uffff";
    static final String DFA50_maxS =
        "\1\72\2\0\44\uffff";
    static final String DFA50_acceptS =
        "\3\uffff\1\2\42\uffff\1\1";
    static final String DFA50_specialS =
        "\1\uffff\1\0\1\1\44\uffff}>";
    static final String[] DFA50_transitionS = {
            "\6\3\10\uffff\1\3\1\uffff\2\3\1\uffff\1\3\1\1\1\2\1\uffff\6"+
            "\3\1\uffff\12\3\3\uffff\3\3\1\uffff\3\3\2\uffff\2\3",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA50_eot = DFA.unpackEncodedString(DFA50_eotS);
    static final short[] DFA50_eof = DFA.unpackEncodedString(DFA50_eofS);
    static final char[] DFA50_min = DFA.unpackEncodedStringToUnsignedChars(DFA50_minS);
    static final char[] DFA50_max = DFA.unpackEncodedStringToUnsignedChars(DFA50_maxS);
    static final short[] DFA50_accept = DFA.unpackEncodedString(DFA50_acceptS);
    static final short[] DFA50_special = DFA.unpackEncodedString(DFA50_specialS);
    static final short[][] DFA50_transition;

    static {
        int numStates = DFA50_transitionS.length;
        DFA50_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA50_transition[i] = DFA.unpackEncodedString(DFA50_transitionS[i]);
        }
    }

    class DFA50 extends DFA {

        public DFA50(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 50;
            this.eot = DFA50_eot;
            this.eof = DFA50_eof;
            this.min = DFA50_min;
            this.max = DFA50_max;
            this.accept = DFA50_accept;
            this.special = DFA50_special;
            this.transition = DFA50_transition;
        }
        public String getDescription() {
            return "2398:2: ( ( (lv_subadd_1_0= ruleTK_SUB_ADD ) ) ( (lv_arithm_expr_2_0= ruleArithm_expr ) ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA50_1 = input.LA(1);

                         
                        int index50_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred72_InternalAsl()) ) {s = 38;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index50_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA50_2 = input.LA(1);

                         
                        int index50_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred72_InternalAsl()) ) {s = 38;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index50_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 50, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_ruleAgent_in_entryRuleAgent88 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAgent98 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDirective_in_ruleAgent144 = new BitSet(new long[]{0x060300000E640432L});
    public static final BitSet FOLLOW_ruleBelief_in_ruleAgent167 = new BitSet(new long[]{0x060300000E640430L});
    public static final BitSet FOLLOW_ruleDirective_in_ruleAgent188 = new BitSet(new long[]{0x060300000E640432L});
    public static final BitSet FOLLOW_ruleInitial_goal_in_ruleAgent213 = new BitSet(new long[]{0x060300000E640430L});
    public static final BitSet FOLLOW_ruleDirective_in_ruleAgent234 = new BitSet(new long[]{0x060300000E640432L});
    public static final BitSet FOLLOW_rulePlan_in_ruleAgent259 = new BitSet(new long[]{0x060300000E640430L});
    public static final BitSet FOLLOW_ruleBelief_in_ruleAgent280 = new BitSet(new long[]{0x060300000E640430L});
    public static final BitSet FOLLOW_ruleDirective_in_ruleAgent302 = new BitSet(new long[]{0x060300000E640432L});
    public static final BitSet FOLLOW_ruleDirective_in_entryRuleDirective341 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDirective351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleDirective388 = new BitSet(new long[]{0x0003000000200420L});
    public static final BitSet FOLLOW_ruleTK_BEGIN_in_ruleDirective411 = new BitSet(new long[]{0x0003000000200420L});
    public static final BitSet FOLLOW_rulePred_in_ruleDirective432 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleDirective444 = new BitSet(new long[]{0x060300000E640430L});
    public static final BitSet FOLLOW_ruleAgent_in_ruleDirective465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePred_in_ruleDirective494 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleDirective506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBelief_in_entryRuleBelief544 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBelief554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleBelief600 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_20_in_ruleBelief613 = new BitSet(new long[]{0x06430000442007E0L});
    public static final BitSet FOLLOW_ruleLog_expr_in_ruleBelief634 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleBelief648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInitial_goal_in_entryRuleInitial_goal684 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInitial_goal694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleInitial_goal731 = new BitSet(new long[]{0x0603000000200420L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleInitial_goal752 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleInitial_goal764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePlan_in_entryRulePlan800 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePlan810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TK_LABEL_AT_in_rulePlan853 = new BitSet(new long[]{0x0003000000200420L});
    public static final BitSet FOLLOW_rulePred_in_rulePlan879 = new BitSet(new long[]{0x000000000E000010L});
    public static final BitSet FOLLOW_ruleTrigger_in_rulePlan902 = new BitSet(new long[]{0x0000000001A00000L});
    public static final BitSet FOLLOW_23_in_rulePlan915 = new BitSet(new long[]{0x06430000442007E0L});
    public static final BitSet FOLLOW_ruleLog_expr_in_rulePlan936 = new BitSet(new long[]{0x0000000001200000L});
    public static final BitSet FOLLOW_24_in_rulePlan951 = new BitSet(new long[]{0x06770001566007E0L});
    public static final BitSet FOLLOW_rulePlan_body_in_rulePlan972 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_rulePlan986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTrigger_in_entryRuleTrigger1022 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTrigger1032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTriggerSymbol_in_ruleTrigger1078 = new BitSet(new long[]{0x06030000002004E0L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleTrigger1100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVar_in_ruleTrigger1127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTriggerSymbol_in_entryRuleTriggerSymbol1165 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTriggerSymbol1176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleTriggerSymbol1215 = new BitSet(new long[]{0x0000000010400002L});
    public static final BitSet FOLLOW_26_in_ruleTriggerSymbol1234 = new BitSet(new long[]{0x0000000010400002L});
    public static final BitSet FOLLOW_27_in_ruleTriggerSymbol1253 = new BitSet(new long[]{0x0000000010400002L});
    public static final BitSet FOLLOW_22_in_ruleTriggerSymbol1268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleTriggerSymbol1287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePlan_body_in_entryRulePlan_body1329 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePlan_body1339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStmtIF_in_rulePlan_body1386 = new BitSet(new long[]{0x06770001766007E2L});
    public static final BitSet FOLLOW_ruleStmtFOR_in_rulePlan_body1413 = new BitSet(new long[]{0x06770001766007E2L});
    public static final BitSet FOLLOW_ruleStmtWHILE_in_rulePlan_body1440 = new BitSet(new long[]{0x06770001766007E2L});
    public static final BitSet FOLLOW_ruleBody_formula_in_rulePlan_body1467 = new BitSet(new long[]{0x06770001766007E2L});
    public static final BitSet FOLLOW_29_in_rulePlan_body1481 = new BitSet(new long[]{0x06770001566007E2L});
    public static final BitSet FOLLOW_rulePlan_body_in_rulePlan_body1504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStmtIF_in_entryRuleStmtIF1541 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStmtIF1551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTK_IF_in_ruleStmtIF1597 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleStmtIF1609 = new BitSet(new long[]{0x06430000442007E0L});
    public static final BitSet FOLLOW_ruleLog_expr_in_ruleStmtIF1630 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleStmtIF1642 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rulePlan_term_in_ruleStmtIF1663 = new BitSet(new long[]{0x0008000000040002L});
    public static final BitSet FOLLOW_ruleTK_ELSE_in_ruleStmtIF1685 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rulePlan_term_in_ruleStmtIF1707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStmtFOR_in_entryRuleStmtFOR1745 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStmtFOR1755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTK_FOR_in_ruleStmtFOR1801 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleStmtFOR1813 = new BitSet(new long[]{0x06430000442007E0L});
    public static final BitSet FOLLOW_ruleLog_expr_in_ruleStmtFOR1834 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleStmtFOR1846 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rulePlan_term_in_ruleStmtFOR1867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStmtWHILE_in_entryRuleStmtWHILE1903 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStmtWHILE1913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTK_WHILE_in_ruleStmtWHILE1959 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleStmtWHILE1971 = new BitSet(new long[]{0x06430000442007E0L});
    public static final BitSet FOLLOW_ruleLog_expr_in_ruleStmtWHILE1992 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleStmtWHILE2004 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rulePlan_term_in_ruleStmtWHILE2025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBody_formula_in_entryRuleBody_formula2061 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBody_formula2071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleBody_formula2109 = new BitSet(new long[]{0x06430000442007E0L});
    public static final BitSet FOLLOW_32_in_ruleBody_formula2127 = new BitSet(new long[]{0x06430000442007E0L});
    public static final BitSet FOLLOW_28_in_ruleBody_formula2145 = new BitSet(new long[]{0x06430000442007E0L});
    public static final BitSet FOLLOW_25_in_ruleBody_formula2163 = new BitSet(new long[]{0x06430000442007E0L});
    public static final BitSet FOLLOW_26_in_ruleBody_formula2182 = new BitSet(new long[]{0x06430000462007E0L});
    public static final BitSet FOLLOW_25_in_ruleBody_formula2195 = new BitSet(new long[]{0x06430000442007E0L});
    public static final BitSet FOLLOW_ruleLog_expr_in_ruleBody_formula2221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePlan_term_in_entryRulePlan_term2257 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePlan_term2267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rulePlan_term2316 = new BitSet(new long[]{0x067700015E6807F0L});
    public static final BitSet FOLLOW_RULE_TK_LABEL_AT_in_rulePlan_term2335 = new BitSet(new long[]{0x0003000000200420L});
    public static final BitSet FOLLOW_rulePred_in_rulePlan_term2361 = new BitSet(new long[]{0x000000000E000010L});
    public static final BitSet FOLLOW_ruleTrigger_in_rulePlan_term2384 = new BitSet(new long[]{0x0677000177E807E0L});
    public static final BitSet FOLLOW_23_in_rulePlan_term2397 = new BitSet(new long[]{0x06430000442007E0L});
    public static final BitSet FOLLOW_ruleLog_expr_in_rulePlan_term2418 = new BitSet(new long[]{0x06770001776807E0L});
    public static final BitSet FOLLOW_24_in_rulePlan_term2433 = new BitSet(new long[]{0x06770001566807E0L});
    public static final BitSet FOLLOW_29_in_rulePlan_term2451 = new BitSet(new long[]{0x06770001566807E0L});
    public static final BitSet FOLLOW_rulePlan_body_in_rulePlan_term2476 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_rulePlan_term2489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral2525 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral2535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TK_NEG_in_ruleLiteral2578 = new BitSet(new long[]{0x0003000000200420L});
    public static final BitSet FOLLOW_rulePred_in_ruleLiteral2605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTK_TRUE_in_ruleLiteral2633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTK_FALSE_in_ruleLiteral2660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePred_in_entryRulePred2696 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePred2706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJASON_ATOM_in_rulePred2753 = new BitSet(new long[]{0x0000000440040002L});
    public static final BitSet FOLLOW_ruleTK_BEGIN_in_rulePred2780 = new BitSet(new long[]{0x0000000440040002L});
    public static final BitSet FOLLOW_ruleTK_END_in_rulePred2807 = new BitSet(new long[]{0x0000000440040002L});
    public static final BitSet FOLLOW_30_in_rulePred2821 = new BitSet(new long[]{0x06430004442407E0L});
    public static final BitSet FOLLOW_ruleTerms_in_rulePred2842 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_rulePred2854 = new BitSet(new long[]{0x0000000400040002L});
    public static final BitSet FOLLOW_rulePlan_term_in_rulePred2877 = new BitSet(new long[]{0x0000000400040002L});
    public static final BitSet FOLLOW_ruleList_in_rulePred2899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerms_in_entryRuleTerms2936 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerms2946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleTerms2992 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleTerms3005 = new BitSet(new long[]{0x06430004442407E0L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleTerms3026 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_ruleTerm_in_entryRuleTerm3064 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerm3074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleList_in_ruleTerm3120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePlan_term_in_ruleTerm3147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLog_expr_in_ruleTerm3174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleList_in_entryRuleList3210 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleList3220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleList3269 = new BitSet(new long[]{0x06430014442407E0L});
    public static final BitSet FOLLOW_ruleTerm_in_list_in_ruleList3291 = new BitSet(new long[]{0x0000001A00000000L});
    public static final BitSet FOLLOW_33_in_ruleList3304 = new BitSet(new long[]{0x06430004442407E0L});
    public static final BitSet FOLLOW_ruleTerm_in_list_in_ruleList3325 = new BitSet(new long[]{0x0000001A00000000L});
    public static final BitSet FOLLOW_35_in_ruleList3340 = new BitSet(new long[]{0x00000004000000C0L});
    public static final BitSet FOLLOW_RULE_VART_in_ruleList3358 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RULE_UNNAMEDVART_in_ruleList3386 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_ruleList_in_ruleList3418 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleList3435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerm_in_list_in_entryRuleTerm_in_list3471 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerm_in_list3481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleList_in_ruleTerm_in_list3527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArithm_expr_in_ruleTerm_in_list3554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleString_in_ruleTerm_in_list3581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePlan_term_in_ruleTerm_in_list3608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLog_expr_in_entryRuleLog_expr3644 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLog_expr3654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLog_expr_trm_in_ruleLog_expr3700 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_ruleLog_expr3713 = new BitSet(new long[]{0x06430000442007E0L});
    public static final BitSet FOLLOW_ruleLog_expr_in_ruleLog_expr3734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLog_expr_trm_in_entryRuleLog_expr_trm3772 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLog_expr_trm3782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLog_expr_factor_in_ruleLog_expr_trm3828 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_ruleLog_expr_trm3841 = new BitSet(new long[]{0x06430000442007E0L});
    public static final BitSet FOLLOW_ruleLog_expr_trm_in_ruleLog_expr_trm3862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLog_expr_factor_in_entryRuleLog_expr_factor3900 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLog_expr_factor3910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTK_NOT_in_ruleLog_expr_factor3957 = new BitSet(new long[]{0x06430000442007E0L});
    public static final BitSet FOLLOW_ruleLog_expr_factor_in_ruleLog_expr_factor3978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRel_expr_in_ruleLog_expr_factor4006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRel_expr_in_entryRuleRel_expr4042 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRel_expr4052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArithm_expr_in_ruleRel_expr4099 = new BitSet(new long[]{0x00001FC000000002L});
    public static final BitSet FOLLOW_ruleString_in_ruleRel_expr4126 = new BitSet(new long[]{0x00001FC000000002L});
    public static final BitSet FOLLOW_ruleTK_REL_OP_in_ruleRel_expr4149 = new BitSet(new long[]{0x06430004442407E0L});
    public static final BitSet FOLLOW_ruleArithm_expr_in_ruleRel_expr4171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleString_in_ruleRel_expr4198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleList_in_ruleRel_expr4225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePlan_term_in_ruleRel_expr4252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTK_REL_OP_in_entryRuleTK_REL_OP4298 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTK_REL_OP4309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleTK_REL_OP4351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleTK_REL_OP4370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleTK_REL_OP4389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleTK_REL_OP4408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleTK_REL_OP4427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleTK_REL_OP4446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleTK_REL_OP4466 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_ruleTK_REL_OP4480 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleTK_REL_OP4493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArithm_expr_in_entryRuleArithm_expr4540 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArithm_expr4550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArithm_expr_trm_in_ruleArithm_expr4596 = new BitSet(new long[]{0x0000000006000002L});
    public static final BitSet FOLLOW_ruleTK_SUB_ADD_in_ruleArithm_expr4618 = new BitSet(new long[]{0x06030000442006E0L});
    public static final BitSet FOLLOW_ruleArithm_expr_in_ruleArithm_expr4639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTK_SUB_ADD_in_entryRuleTK_SUB_ADD4678 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTK_SUB_ADD4689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleTK_SUB_ADD4727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleTK_SUB_ADD4746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArithm_expr_trm_in_entryRuleArithm_expr_trm4786 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArithm_expr_trm4796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArithm_expr_factor_in_ruleArithm_expr_trm4842 = new BitSet(new long[]{0x0180600000000002L});
    public static final BitSet FOLLOW_ruleTK_MUL_DIV_in_ruleArithm_expr_trm4865 = new BitSet(new long[]{0x06030000442006E0L});
    public static final BitSet FOLLOW_ruleTK_INTDIV_in_ruleArithm_expr_trm4892 = new BitSet(new long[]{0x06030000442006E0L});
    public static final BitSet FOLLOW_ruleTK_INTMOD_in_ruleArithm_expr_trm4919 = new BitSet(new long[]{0x06030000442006E0L});
    public static final BitSet FOLLOW_ruleArithm_expr_trm_in_ruleArithm_expr_trm4941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTK_MUL_DIV_in_entryRuleTK_MUL_DIV4980 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTK_MUL_DIV4991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleTK_MUL_DIV5029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleTK_MUL_DIV5048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArithm_expr_factor_in_entryRuleArithm_expr_factor5088 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArithm_expr_factor5098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArithm_expr_simple_in_ruleArithm_expr_factor5144 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_ruleTK_EXPONENTIAL_in_ruleArithm_expr_factor5166 = new BitSet(new long[]{0x06030000442006E0L});
    public static final BitSet FOLLOW_ruleArithm_expr_factor_in_ruleArithm_expr_factor5187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTK_EXPONENTIAL_in_entryRuleTK_EXPONENTIAL5226 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTK_EXPONENTIAL5237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleTK_EXPONENTIAL5274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArithm_expr_simple_in_entryRuleArithm_expr_simple5313 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArithm_expr_simple5323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumber_in_ruleArithm_expr_simple5369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTK_UNARY_OP_in_ruleArithm_expr_simple5397 = new BitSet(new long[]{0x06030000442006E0L});
    public static final BitSet FOLLOW_ruleArithm_expr_simple_in_ruleArithm_expr_simple5418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleArithm_expr_simple5438 = new BitSet(new long[]{0x06430000442007E0L});
    public static final BitSet FOLLOW_ruleLog_expr_in_ruleArithm_expr_simple5459 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleArithm_expr_simple5471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVar_in_ruleArithm_expr_simple5499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_ruleArithm_expr_simple5526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTK_UNARY_OP_in_entryRuleTK_UNARY_OP5563 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTK_UNARY_OP5574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleTK_UNARY_OP5611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_entryRuleFunction5650 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunction5660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleFunction5705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVar_in_entryRuleVar5740 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVar5750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VART_in_ruleVar5793 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_RULE_UNNAMEDVART_in_ruleVar5821 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_ruleList_in_ruleVar5848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleString_in_entryRuleString5885 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleString5895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRINGT_in_ruleString5936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumber_in_entryRuleNumber5982 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumber5992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBERT_in_ruleNumber6039 = new BitSet(new long[]{0x0000000000200200L});
    public static final BitSet FOLLOW_21_in_ruleNumber6057 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_NUMBERT_in_ruleNumber6074 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_21_in_ruleNumber6100 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_NUMBERT_in_ruleNumber6117 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_RULE_NUMBERT_in_ruleNumber6147 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_ruleJASON_ATOM_in_entryRuleJASON_ATOM6200 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJASON_ATOM6211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJASON_ATOM_HEAD_in_ruleJASON_ATOM6262 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleJASON_ATOM_TAIL_in_ruleJASON_ATOM6290 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleJASON_ATOM_HEAD_in_entryRuleJASON_ATOM_HEAD6342 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJASON_ATOM_HEAD6353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleJASON_ATOM_HEAD6392 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RULE_ATOM_in_ruleJASON_ATOM_HEAD6409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJASON_ATOM_TAIL_in_entryRuleJASON_ATOM_TAIL6455 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJASON_ATOM_TAIL6466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleJASON_ATOM_TAIL6504 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RULE_ATOM_in_ruleJASON_ATOM_TAIL6519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTK_BEGIN_in_entryRuleTK_BEGIN6565 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTK_BEGIN6576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleTK_BEGIN6613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTK_END_in_entryRuleTK_END6653 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTK_END6664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleTK_END6701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTK_IF_in_entryRuleTK_IF6741 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTK_IF6752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleTK_IF6789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTK_ELSE_in_entryRuleTK_ELSE6829 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTK_ELSE6840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleTK_ELSE6877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTK_FOR_in_entryRuleTK_FOR6917 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTK_FOR6928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleTK_FOR6965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTK_WHILE_in_entryRuleTK_WHILE7005 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTK_WHILE7016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleTK_WHILE7053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTK_NOT_in_entryRuleTK_NOT7093 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTK_NOT7104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleTK_NOT7141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTK_INTDIV_in_entryRuleTK_INTDIV7181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTK_INTDIV7192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleTK_INTDIV7229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTK_INTMOD_in_entryRuleTK_INTMOD7269 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTK_INTMOD7280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleTK_INTMOD7317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTK_TRUE_in_entryRuleTK_TRUE7357 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTK_TRUE7368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleTK_TRUE7405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTK_FALSE_in_entryRuleTK_FALSE7445 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTK_FALSE7456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleTK_FALSE7493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDirective_in_synpred1_InternalAsl144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDirective_in_synpred2_InternalAsl188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBelief_in_synpred3_InternalAsl167 = new BitSet(new long[]{0x060300000E640430L});
    public static final BitSet FOLLOW_ruleDirective_in_synpred3_InternalAsl188 = new BitSet(new long[]{0x060300000E640432L});
    public static final BitSet FOLLOW_ruleDirective_in_synpred4_InternalAsl234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInitial_goal_in_synpred5_InternalAsl213 = new BitSet(new long[]{0x060300000E640430L});
    public static final BitSet FOLLOW_ruleDirective_in_synpred5_InternalAsl234 = new BitSet(new long[]{0x060300000E640432L});
    public static final BitSet FOLLOW_ruleBelief_in_synpred6_InternalAsl280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDirective_in_synpred7_InternalAsl302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePlan_in_synpred8_InternalAsl259 = new BitSet(new long[]{0x060300000E640430L});
    public static final BitSet FOLLOW_ruleBelief_in_synpred8_InternalAsl280 = new BitSet(new long[]{0x060300000E640430L});
    public static final BitSet FOLLOW_ruleDirective_in_synpred8_InternalAsl302 = new BitSet(new long[]{0x060300000E640432L});
    public static final BitSet FOLLOW_rulePlan_body_in_synpred23_InternalAsl1504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_synpred31_InternalAsl2182 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_synpred31_InternalAsl2195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TK_LABEL_AT_in_synpred36_InternalAsl2335 = new BitSet(new long[]{0x0003000000200420L});
    public static final BitSet FOLLOW_rulePred_in_synpred36_InternalAsl2361 = new BitSet(new long[]{0x000000000E000010L});
    public static final BitSet FOLLOW_ruleTrigger_in_synpred36_InternalAsl2384 = new BitSet(new long[]{0x0000000021800002L});
    public static final BitSet FOLLOW_23_in_synpred36_InternalAsl2397 = new BitSet(new long[]{0x06430000442007E0L});
    public static final BitSet FOLLOW_ruleLog_expr_in_synpred36_InternalAsl2418 = new BitSet(new long[]{0x0000000021000002L});
    public static final BitSet FOLLOW_24_in_synpred36_InternalAsl2433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_synpred36_InternalAsl2451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_synpred43_InternalAsl2821 = new BitSet(new long[]{0x06430004442407E0L});
    public static final BitSet FOLLOW_ruleTerms_in_synpred43_InternalAsl2842 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_synpred43_InternalAsl2854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTK_SUB_ADD_in_synpred72_InternalAsl4618 = new BitSet(new long[]{0x06030000442006E0L});
    public static final BitSet FOLLOW_ruleArithm_expr_in_synpred72_InternalAsl4639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBERT_in_synpred86_InternalAsl6074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBERT_in_synpred87_InternalAsl6039 = new BitSet(new long[]{0x0000000000200200L});
    public static final BitSet FOLLOW_21_in_synpred87_InternalAsl6057 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_NUMBERT_in_synpred87_InternalAsl6074 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_RULE_NUMBERT_in_synpred88_InternalAsl6117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBERT_in_synpred90_InternalAsl6147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJASON_ATOM_TAIL_in_synpred91_InternalAsl6290 = new BitSet(new long[]{0x0000000000000002L});

}