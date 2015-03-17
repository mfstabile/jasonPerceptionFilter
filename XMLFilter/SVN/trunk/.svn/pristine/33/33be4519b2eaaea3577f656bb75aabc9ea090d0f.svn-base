package jasonide.xtext.asl.serializer;

import com.google.inject.Inject;
import jasonide.xtext.asl.services.AslGrammarAccess;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("restriction")
public class AbstractAslSyntacticSequencer extends AbstractSyntacticSequencer {

	protected AslGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Body_formula_____ExclamationMarkExclamationMarkKeyword_0_1_or_ExclamationMarkKeyword_0_0_or_PlusSignKeyword_0_3_or_QuestionMarkKeyword_0_2___or___HyphenMinusKeyword_0_4_0_PlusSignKeyword_0_4_1_q____q;
	protected AbstractElementAlias match_Plan_body_SemicolonKeyword_1_q;
	protected AbstractElementAlias match_Plan_term___LessThanSignHyphenMinusKeyword_2_3_0_or_SemicolonKeyword_2_3_1__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (AslGrammarAccess) access;
		match_Body_formula_____ExclamationMarkExclamationMarkKeyword_0_1_or_ExclamationMarkKeyword_0_0_or_PlusSignKeyword_0_3_or_QuestionMarkKeyword_0_2___or___HyphenMinusKeyword_0_4_0_PlusSignKeyword_0_4_1_q____q = new AlternativeAlias(true, false, new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getBody_formulaAccess().getExclamationMarkExclamationMarkKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getBody_formulaAccess().getExclamationMarkKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getBody_formulaAccess().getPlusSignKeyword_0_3()), new TokenAlias(false, false, grammarAccess.getBody_formulaAccess().getQuestionMarkKeyword_0_2())), new GroupAlias(false, false, new TokenAlias(false, false, grammarAccess.getBody_formulaAccess().getHyphenMinusKeyword_0_4_0()), new TokenAlias(true, false, grammarAccess.getBody_formulaAccess().getPlusSignKeyword_0_4_1())));
		match_Plan_body_SemicolonKeyword_1_q = new TokenAlias(true, false, grammarAccess.getPlan_bodyAccess().getSemicolonKeyword_1());
		match_Plan_term___LessThanSignHyphenMinusKeyword_2_3_0_or_SemicolonKeyword_2_3_1__q = new AlternativeAlias(true, false, new TokenAlias(false, false, grammarAccess.getPlan_termAccess().getLessThanSignHyphenMinusKeyword_2_3_0()), new TokenAlias(false, false, grammarAccess.getPlan_termAccess().getSemicolonKeyword_2_3_1()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_Body_formula_____ExclamationMarkExclamationMarkKeyword_0_1_or_ExclamationMarkKeyword_0_0_or_PlusSignKeyword_0_3_or_QuestionMarkKeyword_0_2___or___HyphenMinusKeyword_0_4_0_PlusSignKeyword_0_4_1_q____q.equals(syntax))
				emit_Body_formula_____ExclamationMarkExclamationMarkKeyword_0_1_or_ExclamationMarkKeyword_0_0_or_PlusSignKeyword_0_3_or_QuestionMarkKeyword_0_2___or___HyphenMinusKeyword_0_4_0_PlusSignKeyword_0_4_1_q____q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Plan_body_SemicolonKeyword_1_q.equals(syntax))
				emit_Plan_body_SemicolonKeyword_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Plan_term___LessThanSignHyphenMinusKeyword_2_3_0_or_SemicolonKeyword_2_3_1__q.equals(syntax))
				emit_Plan_term___LessThanSignHyphenMinusKeyword_2_3_0_or_SemicolonKeyword_2_3_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     (('-' '+'?) | ('+' | '?' | '!' | '!!'))?
	 */
	protected void emit_Body_formula_____ExclamationMarkExclamationMarkKeyword_0_1_or_ExclamationMarkKeyword_0_0_or_PlusSignKeyword_0_3_or_QuestionMarkKeyword_0_2___or___HyphenMinusKeyword_0_4_0_PlusSignKeyword_0_4_1_q____q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_Plan_body_SemicolonKeyword_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('<-' | ';')?
	 */
	protected void emit_Plan_term___LessThanSignHyphenMinusKeyword_2_3_0_or_SemicolonKeyword_2_3_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
