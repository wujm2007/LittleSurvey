package entity.question;

import entity.answer.Answer;

/* 
 * This is Gradable interface.
 * Any subclass of Question that implement it means that the class
 * has a standard Answer. (all subclass of TestQustion)
 */
public interface Gradable {
	public boolean isCorrect(Answer answer);
}
