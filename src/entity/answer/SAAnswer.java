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
	public boolean match(Answer answer) {
		if ((answer == null) || (getQuestion() != answer.getQuestion()))
			return false;
		else if (answer instanceof MatchingAnswer)
			return content.equals(((SAAnswer) answer).content);
		else
			return false;
	}

	@Override
	public String toString() {
		return content;
	}

}
