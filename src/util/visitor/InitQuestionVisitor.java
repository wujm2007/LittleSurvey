package util.visitor;

import java.util.List;

import entity.question.EssayQuestion;
import entity.question.MCQuestion;
import entity.question.MCTestQuestion;
import entity.question.MatchingQuestion;
import entity.question.MatchingTestQuestion;
import entity.question.RankingQuestion;
import entity.question.RankingTestQuestion;
import entity.question.SAQuestion;
import entity.question.SATestQuestion;
import entity.question.TFQuestion;
import entity.question.TFTestQuestion;
import util.UIImp;
import util.ConsoleUIImp;

/* 
 * An QuestionVisitor defines how to initiate a Question.
 */
public class InitQuestionVisitor extends QuestionVisitor {
	UIImp io = ConsoleUIImp.getInstance();

	@Override
	public void visitTF(TFQuestion q) {
		q.setPrompt(io.readPrompt("True/False"));
	}

	@Override
	public void visitTFTest(TFTestQuestion q) {
		q.setQuestion(new TFQuestion());
		q.setAnswer(q.makeAnswer());
	}

	@Override
	public void visitMC(MCQuestion q) {
		q.setPrompt(io.readPrompt("multiple choice"));
		q.setChoices(io.readChoices("multiple choice"));
	}

	@Override
	public void visitMCTest(MCTestQuestion q) {
		q.setQuestion(new MCQuestion());
		q.setAnswer(q.makeAnswer());
	}

	@Override
	public void visitSA(SAQuestion q) {
		q.setPrompt(io.readPrompt("short answer"));
	}

	@Override
	public void visitSATest(SATestQuestion q) {
		q.setQuestion(new SAQuestion());
		q.setAnswer(q.makeAnswer());
	}

	@Override
	public void visitEssay(EssayQuestion q) {
		q.setPrompt(io.readPrompt("essay"));
	}

	@Override
	public void visitRanking(RankingQuestion q) {
		q.setPrompt(io.readPrompt("ranking"));
		q.setChoices(io.readChoices("ranking"));
	}

	@Override
	public void visitRankingTest(RankingTestQuestion q) {
		q.setQuestion(new RankingQuestion());
		q.setAnswer(q.makeAnswer());
	}

	@Override
	public void visitMatching(MatchingQuestion q) {
		q.setPrompt(io.readPrompt("matching"));
		List<String> tmpLeft = io.readChoices("matching(left)");
		q.setChoicesLeft(tmpLeft);
		List<String> tmpRight = io.readChoices("matching(right)", tmpLeft.size());
		q.setChoicesRight(tmpRight);
	}

	@Override
	public void visitMatchingTest(MatchingTestQuestion q) {
		q.setQuestion(new MatchingQuestion());
		io.println("Standard answer:");
		q.setAnswer(q.makeAnswer());
	}

}
