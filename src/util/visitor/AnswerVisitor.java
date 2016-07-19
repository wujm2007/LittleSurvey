package util.visitor;

import entity.answer.*;

public abstract class AnswerVisitor {

	public abstract void visitTF(TFAnswer a);

	public abstract void visitMC(MCAnswer a);

	public abstract void visitSA(SAAnswer a);

	public abstract void visitEssay(EssayAnswer a);

	public abstract void visitRanking(RankingAnswer a);

	public abstract void visitMatching(MatchingAnswer a);
}
