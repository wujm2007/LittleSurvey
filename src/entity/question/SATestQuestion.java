package entity.question;

import util.visitor.QuestionVisitor;

@SuppressWarnings("serial")
public class SATestQuestion extends TestQuestion {

	@Override
	public String toString() {
		String result = getQuestion().toString() + "\n";
		result += "The correct choice is " + getAnswer();
		return result;
	}

	@Override
	public void accept(QuestionVisitor v) {
		v.visitSATest(this);
	}
}