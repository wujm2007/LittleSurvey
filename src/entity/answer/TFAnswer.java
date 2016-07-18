package entity.answer;

import entity.question.Question;

@SuppressWarnings("serial")
public class TFAnswer extends Answer {
	private Boolean truth;

	public TFAnswer(Question question, boolean truth) {
		super(question);
		this.truth = truth;
	}

	@Override
	public String toString() {
		return truth ? "True" : "False";
	}

	@Override
	public Object getValue() {
		return truth;
	}

}
