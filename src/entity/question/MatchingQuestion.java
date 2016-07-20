package entity.question;

import java.util.List;

import entity.answer.Answer;
import entity.answer.MatchingAnswer;
import util.visitor.QuestionVisitor;

/*
 * See Question.java
 */
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

	// a helper method to transform choices to String
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
		try {
			return new MatchingAnswer(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void accept(QuestionVisitor v) {
		v.visitMatching(this);
	}

}
