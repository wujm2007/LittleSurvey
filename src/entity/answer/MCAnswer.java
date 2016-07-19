package entity.answer;

import java.util.Map;

import entity.question.MCQuestion;
import entity.question.Question;
import util.visitor.AnswerVisitor;
import util.visitor.InitAnswerVisitor;

@SuppressWarnings("serial")
public class MCAnswer extends Answer {
	Map<String, Boolean> choices;

	public final void setChoices(Map<String, Boolean> choices) {
		this.choices = choices;
	}

	public MCAnswer(Question question) throws Exception {
		super(question);
		if (!(question instanceof MCQuestion))
			throw new Exception("Question type error.");
		accept(new InitAnswerVisitor());
	}

	@Override
	public String toString() {
		String result = "";
		for (String key : choices.keySet())
			if (choices.get(key))
				result += key + ")\t";
		return result;
	}

	@Override
	public Object getValue() {
		return choices;
	}

	@Override
	public void accept(AnswerVisitor v) {
		v.visitMC(this);
	}
}
