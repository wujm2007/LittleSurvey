package entity.answer;

import entity.question.Question;
import util.visitor.AnswerVisitor;
import util.visitor.InitAnswerVisitor;

/*
 * See Answer.java
 */
@SuppressWarnings("serial")
public class EssayAnswer extends Answer {
	private String content;

	public EssayAnswer(Question question) {
		super(question);
		accept(new InitAnswerVisitor());
	}

	public final void setContent(String content) {
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

	@Override
	public void accept(AnswerVisitor v) {
		v.visitEssay(this);
	}

	// This is specially overridden because EssayAnswer is not matchable.
	@Override
	public boolean match(Answer answer) {
		try {
			throw new Exception("EssayAnswer is not matchable.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
