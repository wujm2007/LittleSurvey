package entity;

import biz.IOHelper;

public class SurveyQuestionFactory extends QuestionFactory {
	private static IOHelper io = IOHelper.getInstance();

	@Override
	public TFQuestion createTF() {
		return new TFQuestion(io.readPrompt("True/False"));
	}

	@Override
	public MCQuestion createMC() {
		return new MCQuestion(io.readPrompt("multiple choice"), io.readMultipleChoices());
	}

	@Override
	public SAQuestion createSA() {
		return new SAQuestion(io.readPrompt("short answer"));
	}

	@Override
	public EssayQuestion createEssay() {
		return new EssayQuestion(io.readPrompt("short answer"));
	}

	@Override
	public RankingQuestion createRanking() {
		return new RankingQuestion(io.readPrompt("ranking"), io.readRankingchoices());
	}

}