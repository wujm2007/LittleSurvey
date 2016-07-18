package util.visitor;

import entity.question.*;

public abstract class QuestionVisitor {

	public abstract void visitTF(TFQuestion q);

	public abstract void visitTFTest(TFTestQuestion q);

	public abstract void visitMC(MCQuestion q);

	public abstract void visitMCTest(MCTestQuestion q);

	public abstract void visitSA(SAQuestion q);

	public abstract void visitSATest(SATestQuestion q);

	public abstract void visitEssay(EssayQuestion q);

	public abstract void visitRanking(RankingQuestion q);

	public abstract void visitRankingTest(RankingTestQuestion q);

	public abstract void visitMatching(MatchingQuestion q);

	public abstract void visitMatchingTest(MatchingTestQuestion q);
}
