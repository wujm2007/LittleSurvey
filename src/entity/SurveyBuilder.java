package entity;

import biz.IOHelper;

public class SurveyBuilder extends QuestionContainerBuilder {
	private static IOHelper io = IOHelper.getInstance();
	private static SurveyQuestionFactory factory = new SurveyQuestionFactory();
	private Survey survey = new Survey();

	@Override
	public void buildTF() {
		survey.addQuestion(factory.createTF(io.readPrompt("True/False")));
	}

	@Override
	public void buildMC() {
		survey.addQuestion(factory.createMC(io.readPrompt("multiple choice"), io.readChoices("multiple choice")));
	}

	@Override
	public void buildSA() {
		survey.addQuestion(factory.createSA(io.readPrompt("short answer")));
	}

	@Override
	public void buildEssay() {
		survey.addQuestion(factory.createEssay(io.readPrompt("essay")));
	}

	@Override
	public void buildRanking() {
		survey.addQuestion(factory.createRanking(io.readPrompt("ranking"), io.readChoices("ranking")));
	}

	@Override
	public QuestionContainer getResult() {
		return survey;
	}

}
