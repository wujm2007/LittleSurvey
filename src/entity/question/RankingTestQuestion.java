package entity.question;

import util.visitor.QuestionVisitor;

/*
 * See TestQuestion.java
 */
@SuppressWarnings("serial")
public class RankingTestQuestion extends TestQuestion {

	@Override
	public String toString() {
		String result = getQuestion().toString() + "\n";
		result += "The correct ranking is " + getAnswer();
		return result;
	}

	@Override
	public void accept(QuestionVisitor v) {
		v.visitRankingTest(this);
	}
}