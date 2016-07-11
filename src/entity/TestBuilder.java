package entity;

import java.util.Map;

import biz.IOHelper;

public class TestBuilder extends QuestionContainerBuilder {
	private static IOHelper io = IOHelper.getInstance();
	private static TestQuestionFactory factory = new TestQuestionFactory();
	private Test test = new Test();

	@Override
	public void buildTF() {
		test.addQuestion(factory.createTF(io.readPrompt("True/False"), io.readBoolean("Enter correct choice")));
	}

	@Override
	public void buildMC() {
		Map<String, String> choices;
		test.addQuestion(factory.createMC(io.readPrompt("multiple choice"),
				(choices = io.readChoices("multiple choice")), io.readCorrectChoices(choices)));
	}

	@Override
	public void buildSA() {
		test.addQuestion(factory.createSA(io.readPrompt("short answer"), io.readString("Enter correct answer")));
	}

	@Override
	public void buildEssay() {
		test.addQuestion(factory.createEssay(io.readPrompt("essay")));
	}

	@Override
	public void buildRanking() {
		Map<String, String> choices;
		test.addQuestion(factory.createRanking(io.readPrompt("ranking"), (choices = io.readChoices("ranking")),
				io.readCorrectRanking(choices)));
	}

	@Override
	public QuestionContainer getResult() {
		return test;
	}

}
