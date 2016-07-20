package util.visitor;

import entity.answer.*;

/* 
 * The AnswerVisitor interface (an abstract class to be exact).
 * 
 * It'a apart of the Visitor Pattern on Answer.
 */

public abstract class AnswerVisitor {

	public abstract void visitTF(TFAnswer a);

	public abstract void visitMC(MCAnswer a);

	public abstract void visitSA(SAAnswer a);

	public abstract void visitEssay(EssayAnswer a);

	public abstract void visitRanking(RankingAnswer a);

	public abstract void visitMatching(MatchingAnswer a);
}
