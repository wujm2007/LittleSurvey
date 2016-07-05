package entity;

import java.util.List;

import biz.IOHelper;

public class TestQuestionFactory extends QuestionFactory {
	private static IOHelper io = IOHelper.getInstance();

	@Override
	public TFQuestion createTF() {
		return new TFTQuestion(io.readPrompt("True/False"), io.readBoolean("Enter correct choice"));
	}

	@Override
	public MCQuestion createMC() {
		List<String> choices;
		return new MCTQuestion(io.readPrompt("multiple choice"), (choices = io.readMultipleChoices()),
				io.readCorrectChoices(choices));
	}

	@Override
	public SAQuestion createSA() {
		return new SATQuestion(io.readPrompt("short answer"), io.readString("Enter correct answer"));
	}

	@Override
	public EssayQuestion createEssay() {
		return new EssayTQuestion(io.readPrompt("short answer"));
	}

	@Override
	public RankingQuestion createRanking() {
		List<String> choices;
		return new RankingTQuestion(io.readPrompt("ranking"), (choices = io.readRankingchoices()),
				io.readCorrectRanking(choices));
	}

}
