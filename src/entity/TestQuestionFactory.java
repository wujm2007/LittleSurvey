package entity;

import java.util.List;
import java.util.Map;

public class TestQuestionFactory {
	// private static IOHelper io = IOHelper.getInstance();
	// private static TestQuestionFactory instance;
	//
	// private TestQuestionFactory() {
	// }
	//
	// public static TestQuestionFactory getInstace() {
	// if (instance == null)
	// instance = new TestQuestionFactory();
	// return instance;
	// }

	public Question createTF(String prompt, boolean standardAnswer) {
		return new TFTestQuestion(prompt, standardAnswer);
	}

	public Question createMC(String prompt, Map<String, String> map, List<String> standardAnswer) {
		return new MCTestQuestion(prompt, map, standardAnswer);
	}

	public Question createSA(String prompt, String standardAnswer) {
		return new SATestQuestion(prompt, standardAnswer);
	}

	public Question createEssay(String prompt) {
		return new EssayQuestion(prompt);
	}

	public Question createRanking(String prompt, Map<String, String> map, List<String> standardAnswer) {
		return new RankingTestQuestion(prompt, map, standardAnswer);
	}

}
