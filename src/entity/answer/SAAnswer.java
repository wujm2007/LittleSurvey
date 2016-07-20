package entity.answer;

import entity.question.Question;
import util.visitor.AnswerVisitor;
import util.visitor.InitAnswerVisitor;

/*
 * See Answer.java
 */
@SuppressWarnings("serial")
public class SAAnswer extends Answer {
	private String content;

	public SAAnswer(Question question) {
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
		v.visitSA(this);
	}

}
