package entity;

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