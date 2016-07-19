package entity.answer;

import entity.question.Question;
import util.visitor.AnswerVisitor;
import util.visitor.InitAnswerVisitor;

@SuppressWarnings("serial")
public class TFAnswer extends Answer {
	private Boolean truth;

	public final void setTruth(Boolean truth) {
		this.truth = truth;
	}

	public TFAnswer(Question question) {
		super(question);
		accept(new InitAnswerVisitor());
	}

	@Override
	public String toString() {
		return truth ? "True" : "False";
	}

	@Override
	public Object getValue() {
		return truth;
	}

	@Override
	public void accept(AnswerVisitor v) {
		v.visitTF(this);
	}

}
