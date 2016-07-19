package entity.question;

import entity.answer.Answer;
import entity.answer.EssayAnswer;
import util.visitor.QuestionVisitor;

@SuppressWarnings("serial")
public class EssayQuestion extends Question {
	@Override
	public String toString() {
		return getPrompt();
	}

	@Override
	public Answer makeAnswer() {
		return new EssayAnswer(this);
	}

	@Override
	public void accept(QuestionVisitor v) {
		v.visitEssay(this);
	}
}
