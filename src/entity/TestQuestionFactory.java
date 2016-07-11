package entity;

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
