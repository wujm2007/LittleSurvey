package entity.question;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
		List<String> standardAnswer = readRanking(choices);
		Map<Integer, String> mapAnswer = new TreeMap<Integer, String>();
		for (int i = 0; i < standardAnswer.size(); i++)
			mapAnswer.put(i, standardAnswer.get(i));
		return new RankingAnswer(this, mapAnswer);
	}

	private List<String> readRanking(List<String> choices) {
		io().println("Enter the ranking:");
		List<String> answer = new ArrayList<String>();
		for (int i = 0; i < choices.size(); i++) {
			String tmp = io().readString("#" + (i + 1));
			int index = io().getIndex(tmp);
			if ((index >= 0) && (index < choices.size()) && (!answer.contains(tmp)))
				answer.add(tmp);
			else {
				io().println("Invalid index.");
				i--;
			}
		}
		return answer;
	}

	@Override
	public void accept(QuestionVisitor v) {
		v.visitRanking(this);
	}
}
