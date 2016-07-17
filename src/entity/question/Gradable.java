package entity.question;

import entity.answer.Answer;

public interface Gradable {
	public boolean isCorrect(Answer answer);
}
