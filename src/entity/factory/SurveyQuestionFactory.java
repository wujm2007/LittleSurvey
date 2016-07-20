package entity.factory;

import entity.question.EssayQuestion;
import entity.question.MCQuestion;
import entity.question.MatchingQuestion;
import entity.question.Question;
import entity.question.RankingQuestion;
import entity.question.SAQuestion;
import entity.question.TFQuestion;

/*
 * This is the SurveyQuestionFactory.
 * It's job is to create SurveyQuestion.
 */
public class SurveyQuestionFactory extends QuestionFactory {
	public Question createTF() {
		return new TFQuestion();
	}

	public Question createMC() {
		return new MCQuestion();
	}

	public Question createSA() {
		return new SAQuestion();
	}

	public Question createEssay() {
		return new EssayQuestion();
	}

	public Question createRanking() {
		return new RankingQuestion();
	}

	public Question createMatching() {
		return new MatchingQuestion();
	}

}