package entity.question;

import util.visitor.QuestionVisitor;

@SuppressWarnings("serial")
public class TFTestQuestion extends TestQuestion {

	@Override
	public String toString() {
		String result = getQuestion().toString() + "\n";
		result += "The correct answer is " + getAnswer();
		return result;
	}

	@Override
	public void accept(QuestionVisitor v) {
		v.visitTFTest(this);
	}
}
