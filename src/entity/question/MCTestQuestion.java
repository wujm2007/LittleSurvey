package entity.question;

import util.visitor.QuestionVisitor;

@SuppressWarnings("serial")
public class MCTestQuestion extends TestQuestion {
	@Override
	public String toString() {
		String result = getQuestion().toString() + "\n";
		result += "The correct choice is " + getAnswer().toString();
		return result;
	}

	@Override
	public void accept(QuestionVisitor v) {
		v.visitMCTest(this);
	}

}
