package entity.question;

import java.util.List;

import entity.answer.Answer;
import entity.answer.RankingAnswer;
import util.visitor.QuestionVisitor;

@SuppressWarnings("serial")
public class RankingQuestion extends Question {
	protected List<String> choices;

	public List<String> getChoices() {
		return this.choices;
	}

	public final void setChoices(List<String> choices) {
		this.choices = choices;
	}

	@Override
	public String toString() {
		String result = getPrompt() + "\n";
		result += choicesToString();
		return result;
	}

	public String choicesToString() {
		String result = "";
		for (int i = 0; i < choices.size(); i++)
			result += (char) ('A' + i) + ") " + choices.get(i) + "\t";
		return result;
	}

	@Override
	public Answer makeAnswer() {
		try {
			return new RankingAnswer(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void accept(QuestionVisitor v) {
		v.visitRanking(this);
	}
}
