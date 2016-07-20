package entity.factory;

import entity.question.EssayQuestion;
import entity.question.MCTestQuestion;
import entity.question.MatchingTestQuestion;
import entity.question.Question;
import entity.question.RankingTestQuestion;
import entity.question.SATestQuestion;
import entity.question.TFTestQuestion;

/*
 * This is the TestQuestionFactory.
 * It's job is to create TestQuestion.
 */
public class TestQuestionFactory extends QuestionFactory {

	public Question createTF() {
		return new TFTestQuestion();
	}

	public Question createMC() {
		return new MCTestQuestion();
	}

	public Question createSA() {
		return new SATestQuestion();
	}

	public Question createEssay() {
		return new EssayQuestion();
	}

	public Question createRanking() {
		return new RankingTestQuestion();
	}

	public Question createMatching() {
		return new MatchingTestQuestion();
	}

}
