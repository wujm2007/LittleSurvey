package entity;

import java.util.Map;

public class SurveyQuestionFactory {
	// private static SurveyQuestionFactory instance;
	//
	// private SurveyQuestionFactory() {
	// }
	//
	// public static SurveyQuestionFactory getInstace() {
	// if (instance == null)
	// instance = new SurveyQuestionFactory();
	// return instance;
	// }

	public Question createTF(String prompt) {
		return new TFQuestion(prompt);
	}

	public Question createMC(String prompt, Map<String, String> map) {
		return new MCQuestion(prompt, map);
	}

	public Question createSA(String prompt) {
		return new SAQuestion(prompt);
	}

	public Question createEssay(String prompt) {
		return new EssayQuestion(prompt);
	}

	public Question createRanking(String prompt, Map<String, String> map) {
		return new RankingQuestion(prompt, map);
	}

}