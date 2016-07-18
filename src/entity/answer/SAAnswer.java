package entity.answer;

import entity.question.Question;

@SuppressWarnings("serial")
public class SAAnswer extends Answer {
	private String content;

	public SAAnswer(Question question, String content) {
		super(question);
		this.content = content;
	}

	@Override
	public String toString() {
		return content;
	}

	@Override
	public Object getValue() {
		return content;
	}

}
