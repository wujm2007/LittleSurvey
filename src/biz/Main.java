package biz;

import java.util.LinkedList;
import java.util.List;

import entity.Question;
import entity.QuestionFactory;
import entity.SurveyQuestionFactory;
import entity.TestQuestionFactory;

public class Main {
	private static IOHelper io;
	private static List<Question> surveyQuestions;
	private static List<Question> testQuestions;

	public static void main(String args[]) {
		io = IOHelper.getInstance();
		surveyQuestions = new LinkedList<Question>();
		testQuestions = new LinkedList<Question>();
		showMenu();
	}

	public static void showMenu() {
		while (true) {
			io.println("1) Create a new Survey");
			io.println("2) Create a new Test");
			io.println("3) Display a Survey");
			io.println("4) Display a Test");
			io.println("5) Save a Survey");
			io.println("6) Save a Test");
			io.println("7) Quit");
			int op = io.readInt("Select an option");
			switch (op) {
			case 1:
				create(new SurveyQuestionFactory(), surveyQuestions);
				break;
			case 2:
				create(new TestQuestionFactory(), testQuestions);
				break;
			case 3:
				display(surveyQuestions);
				break;
			case 4:
				display(testQuestions);
				break;
			case 5:
				save(surveyQuestions);
				break;
			case 6:
				save(testQuestions);
				break;
			case 7:
				return;
			}
		}
	}

	private static void create(QuestionFactory factory, List<Question> questions) {
		questions.clear();
		while (true) {
			io.println("1) Add a new T/F question");
			io.println("2) Add a new multiple choice question");
			io.println("3) Add a new short answer question");
			io.println("4) Add a new essay question");
			io.println("5) Add a new ranking question");
			io.println("6) Back");
			int op = io.readInt("Select an option");
			switch (op) {
			case 1:
				questions.add(factory.createTF());
				break;
			case 2:
				questions.add(factory.createMC());
				break;
			case 3:
				questions.add(factory.createSA());
				break;
			case 4:
				questions.add(factory.createEssay());
				break;
			case 5:
				questions.add(factory.createRanking());
				break;
			case 6:
				return;
			}
		}
	}

	private static void display(List<Question> questions) {
		if (questions == null) {
			System.out.println("No questions.");
			return;
		}
		for (int i = 0; i < questions.size(); i++)
			System.out.println((i + 1) + ") " + questions.get(i));
	}

	private static void save(List<Question> questions) {
		// TODO Auto-generated method stub
	}

}
