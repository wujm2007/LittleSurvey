package entity.answer;

import entity.question.Question;

@SuppressWarnings("serial")
public class EssayAnswer extends Answer {
	private String content;

	public EssayAnswer(Question question, String content) {
		super(question);
		this.content = content;
	}

	@Override
	public boolean match(Answer answer) {
		try {
			throw new Exception("EssayAnswer is not matchable.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String toString() {
		return content;
	}

}
