package entity.question;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.answer.Answer;
import entity.answer.MatchingAnswer;
import util.visitor.QuestionVisitor;

@SuppressWarnings("serial")
public class MatchingQuestion extends Question {
	private List<String> choicesLeft;
	private List<String> choicesRight;

	public final List<String> getChoicesLeft() {
		return choicesLeft;
	}

	public final void setChoicesLeft(List<String> choicesLeft) {
		this.choicesLeft = choicesLeft;
	}

	public final List<String> getChoicesRight() {
		return choicesRight;
	}

	public final void setChoicesRight(List<String> choicesRight) {
		this.choicesRight = choicesRight;
	}

	@Override
	public String toString() {
		String result = getPrompt() + "\n";
		result += choicesToString();
		return result;
	}

	public String choicesToString() {
		String result = "";
		int maxChoiceNum = choicesLeft.size() > choicesRight.size() ? choicesLeft.size() : choicesRight.size();
		for (int i = 0; i < maxChoiceNum; i++) {
			if (i < choicesLeft.size())
				result += (char) ('a' + i) + ") " + choicesLeft.get(i);
			if (i < choicesRight.size())
				result += "\t" + (char) ('A' + i) + ") " + choicesRight.get(i);
			result += "\n";
		}
		return result;
	}

	@Override
	public Answer makeAnswer() {
		return new MatchingAnswer(this, readMatching(choicesLeft, choicesRight));
	}

	private Map<String, String> readMatching(List<String> choicesLeft, List<String> choicesRight) {
		io().println("Enter the matching:");
		Map<String, String> answer = new HashMap<String, String>();
		for (int i = 0; i < choicesLeft.size(); i++) {
			String tmp = io().readString("#" + (i + 1) + ": " + choicesLeft.get(i));
			int index = io().getIndex(tmp);
			if ((index >= 0) && (index < choicesRight.size()))
				answer.put(choicesLeft.get(i), choicesRight.get(index));
			else {
				io().println("Invalid index.");
				i--;
			}
		}
		return answer;
	}

	@Override
	public void accept(QuestionVisitor v) {
		v.visitMatching(this);
	}

}
