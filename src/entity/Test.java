package entity;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("serial")
public class Test extends Questionnaire {
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
