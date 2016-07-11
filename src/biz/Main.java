package biz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import entity.Questionnaire;
import entity.QuestionFactory;
import entity.Survey;
import entity.SurveyQuestionFactory;
import entity.Test;
import entity.TestQuestionFactory;

public class Main {
	private static IOHelper io = IOHelper.getInstance();
	private static Survey survey;
	private static Test test;
	private static QuestionFactory factory;

	public static void main(String args[]) {
		io = IOHelper.getInstance();
		survey = new Survey();
		test = new Test();
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
			io.println("7) Load a Survey");
			io.println("8) Load a Test");
			io.println("9) Quit");
			int op = io.readInt("Select an option");
			switch (op) {
			case 1:
				factory = new SurveyQuestionFactory();
				create(survey);
				break;
			case 2:
				factory = new TestQuestionFactory();
				create(test);
				break;
			case 3:
				display(survey);
				break;
			case 4:
				display(test);
				break;
			case 5:
				save(survey);
				break;
			case 6:
				save(test);
				break;
			case 7:
				load(survey);
				break;
			case 8:
				load(test);
				break;
			case 9:
				return;
			}
		}
	}

	private static void create(Questionnaire container) {
		while (true) {
			io.println("1) Add a new T/F question");
			io.println("2) Add a new multiple choice question");
			io.println("3) Add a new short answer question");
			io.println("4) Add a new essay question");
			io.println("5) Add a new ranking question");
			io.println("6) Add a new matching question");
			io.println("7) Back");
			int op = io.readInt("Select an option");
			switch (op) {
			case 1:
				container.addQuestion(factory.createTF());
				break;
			case 2:
				container.addQuestion(factory.createMC());
				break;
			case 3:
				container.addQuestion(factory.createSA());
				break;
			case 4:
				container.addQuestion(factory.createEssay());
				break;
			case 5:
				container.addQuestion(factory.createRanking());
				break;
			case 6:
				container.addQuestion(factory.createMatching());
				break;
			case 7:
				return;
			}
		}
	}

	private static void display(Questionnaire container) {
		if ((container == null) || (container.isEmpty())) {
			System.out.println("Null QuestionContainer.");
			return;
		}
		for (int i = 0; i < container.size(); i++)
			System.out.println((i + 1) + ") " + container.getQuestion(i));
	}

	private static void save(Questionnaire container) {
		File file = new File(io.readString("Save file name"));
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
			os.writeObject(container);
			os.close();
			io.println("Saved.");
		} catch (Exception ex) {
			ex.printStackTrace(System.out);
			io.println("Save Failed.");
		}
	}

	@SuppressWarnings("resource")
	private static void load(Questionnaire container) {
		File file = new File(io.readString("Load file name"));
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(file));
			Questionnaire c = (Questionnaire) is.readObject();
			if (c.getClass() == container.getClass()) {
				container.clear();
				container.addAll(c);
				io.println("Loaded.");
			} else {
				io.println("Mismatched type.");
			}
		} catch (Exception ex) {
			io.println("Load Failed.");
		}
	}

}
