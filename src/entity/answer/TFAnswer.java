package entity.answer;

import entity.question.Question;

@SuppressWarnings("serial")
public class TFAnswer extends Answer {
	private boolean truth;

	public TFAnswer(Question question, boolean truth) {
		super(question);
		this.truth = truth;
	}

	@Override
	public boolean match(Answer answer) {
		if ((answer == null) || (getQuestion() != answer.getQuestion()))
			return false;
		else if (answer instanceof MatchingAnswer)
			return truth == ((TFAnswer) answer).truth;
		else
			return false;
	}

	@Override
	public String toString() {
		return truth ? "T" : "F";
	}

}
