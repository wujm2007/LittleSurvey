package entity.question;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import entity.answer.Answer;
import entity.answer.MCAnswer;
import util.visitor.QuestionVisitor;

@SuppressWarnings("serial")
public class MCQuestion extends Question {
	protected List<String> choices;

	public List<String> getChoices() {
		return choices;
	}

	public void setChoices(List<String> choices) {
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
			result += (char) ('A' + i) + ") " + choices.get(i) + " ";
		return result;
	}

	@Override
	public Answer makeAnswer() {
		List<String> standardAnswer = readChoices(choices);
		Map<String, Boolean> mapAnswer = new TreeMap<String, Boolean>();
		for (int i = 0; i < standardAnswer.size(); i++)
			mapAnswer.put(standardAnswer.get(i), true);
		return new MCAnswer(this, mapAnswer);
	}

	private List<String> readChoices(List<String> choices) {
		int n = io().readInt("Enter the number of choices");
		if ((n > choices.size()) || (n < 1)) {
			io().println("Invalid number.");
			return readChoices(choices);
		}
		List<String> answer = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			String tmp = io().readString("answer #" + (i + 1)).toUpperCase();
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
		v.visitMC(this);
	}
}
