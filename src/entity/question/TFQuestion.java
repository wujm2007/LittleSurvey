package entity.question;

import entity.answer.Answer;
import entity.answer.TFAnswer;
import util.visitor.QuestionVisitor;

@SuppressWarnings("serial")
public class TFQuestion extends Question {

	@Override
	public String toString() {
		return getPrompt() + "\n" + "True/False";
	}

	@Override
	public Answer makeAnswer() {
		return new TFAnswer(this, io().readBoolean("Enter choice", "true", "false"));
	}

	@Override
	public void accept(QuestionVisitor v) {
		v.visitTF(this);
	}
}
