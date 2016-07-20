package entity.answer;

import java.util.Map;

import entity.answer.Answer;
import entity.question.Question;
import entity.question.RankingQuestion;
import util.visitor.AnswerVisitor;
import util.visitor.InitAnswerVisitor;

/*
 * See Answer.java
 */
@SuppressWarnings("serial")
public class RankingAnswer extends Answer {
	private Map<Integer, String> map;

	public final void setMap(Map<Integer, String> map) {
		this.map = map;
	}

	public RankingAnswer(Question question) throws Exception {
		super(question);
		if (!(question instanceof RankingQuestion))
			throw new Exception("Question type error.");
		accept(new InitAnswerVisitor());
	}

	@Override
	public String toString() {
		String result = "";
		for (int key : map.keySet())
			result += (key + 1) + ": " + map.get(key) + "\t";
		return result;
	}

	@Override
	public Object getValue() {
		return map;
	}

	@Override
	public void accept(AnswerVisitor v) {
		v.visitRanking(this);
	}

}
