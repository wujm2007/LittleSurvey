package entity.question;

import entity.answer.Answer;
import entity.answer.SAAnswer;
import util.visitor.QuestionVisitor;

@SuppressWarnings("serial")
public class SAQuestion extends Question {

	@Override
	public String toString() {
		return getPrompt();
	}

	@Override
	public Answer makeAnswer() {
		return new SAAnswer(this);
	}

	@Override
	public void accept(QuestionVisitor v) {
		v.visitSA(this);
	}
}
