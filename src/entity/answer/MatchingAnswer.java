package entity.answer;

import java.util.Map;

import entity.question.MatchingQuestion;
import entity.question.Question;
import util.visitor.AnswerVisitor;
import util.visitor.InitAnswerVisitor;

/*
 * See Answer.java
 */
@SuppressWarnings("serial")
public class MatchingAnswer extends Answer {
	private Map<String, String> match;

	public final void setMatch(Map<String, String> match) {
		this.match = match;
	}

	public MatchingAnswer(Question question) throws Exception {
		super(question);
		if (!(question instanceof MatchingQuestion))
			throw new Exception("Question type error.");
		accept(new InitAnswerVisitor());
	}

	@Override
	public String toString() {
		String result = "";
		for (String key : match.keySet())
			result += key + ": " + match.get(key) + "\t";
		return result;
	}

	@Override
	public Object getValue() {
		return match;
	}

	@Override
	public void accept(AnswerVisitor v) {
		v.visitMatching(this);
	}

}
