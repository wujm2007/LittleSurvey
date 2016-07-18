package entity.questionnaire;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import entity.AnswerSheet;
import entity.questionnaire.Questionnaire;
import entity.question.Gradable;
import entity.question.Question;
import entity.question.TestQuestion;

@SuppressWarnings("serial")
public class Test extends Questionnaire {
	public Test(String name) {
		super(name);
	}

	private List<Question> questions = new LinkedList<Question>();

	@Override
	public final void addQuestion(final Question q) {
		this.questions.add(q);
	}

	@Override
	public final Question getQuestion(int number) {
		return questions.get(number);
	}

	@Override
	public final Question getQuestionWithouAnswer(int number) {
		Question q = questions.get(number);
		if (q instanceof TestQuestion) {
			return ((TestQuestion) q).getQuestion();
		} else
			return questions.get(number);
	}

	@Override
	public Iterator<Question> iterator() {
		return questions.iterator();
	}

	@Override
	public void clear() {
		questions.clear();
	}

	@Override
	public int size() {
		return questions.size();
	}

	@Override
	public boolean isEmpty() {
		return questions.isEmpty();
	}

	public double grade(AnswerSheet answerSheet) {
		int correct = 0;
		int total = 0;
		for (Question q : this) {
			if (q instanceof Gradable) {
				total++;
				if (((Gradable) q).isCorrect(answerSheet.getAnswer(q)))
					correct++;
			}
		}
		if (total == 0)
			return 0;
		return correct / total * 100;
	}

}
