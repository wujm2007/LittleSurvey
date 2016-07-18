package driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import entity.AnswerSheet;
import entity.answer.Answer;
import entity.factory.QuestionFactory;
import entity.factory.SurveyQuestionFactory;
import entity.factory.TestQuestionFactory;
import entity.questionnaire.Questionnaire;
import entity.questionnaire.Survey;
import entity.questionnaire.Test;
import util.IOHelper;

public class Main {
	private static IOHelper io = IOHelper.getInstance();
	private static Map<String, Survey> surveys;
	private static Map<String, Test> tests;
	private static QuestionFactory factory;

	public static void main(String args[]) {
		io = IOHelper.getInstance();
		surveys = new HashMap<String, Survey>();
		tests = new HashMap<String, Test>();
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
			io.println("7) Modify a Survey");
			io.println("8) Modify a Test");
			io.println("9) Load a Survey");
			io.println("10) Load a Test");
			io.println("11) Take a Survey");
			io.println("12) Take a Test");
			io.println("13) Quit");
			int op = io.readInt("Select an option");
			switch (op) {
			case 1:
				factory = new SurveyQuestionFactory();
				Survey createdSurvey = (Survey) create("Survey");
				surveys.put(createdSurvey.getName(), createdSurvey);
				break;
			case 2:
				factory = new TestQuestionFactory();
				Test createdTest = (Test) create("Test");
				tests.put(createdTest.getName(), createdTest);
				break;
			case 3:
				display(surveys);
				break;
			case 4:
				display(tests);
				break;
			case 5:
				save(surveys);
				break;
			case 6:
				save(tests);
				break;
			case 7:
				modify(surveys);
				break;
			case 8:
				modify(tests);
				break;
			case 9:
				Survey loadedSurvey = (Survey) load("Survey");
				surveys.put(loadedSurvey.getName(), loadedSurvey);
				break;
			case 10:
				Test loadedTest = (Test) load("Test");
				tests.put(loadedTest.getName(), loadedTest);
				break;
			case 11:
				take(surveys);
				break;
			case 12:
				take(tests);
				break;
			case 13:
				return;
			case 14:
				loadAnswerSheet();
			}
		}
	}

	private static void take(Map<String, ? extends Questionnaire> qnMap) {
		String qnName = io.readString("What questionnaire do you wish to take?");
		Questionnaire container = qnMap.get(qnName);

		if ((container == null) || (container.size() == 0)) {
			io.println("The questionnaire is empty.");
			return;
		}

		AnswerSheet as = new AnswerSheet();
		for (int i = 0; i < container.size(); i++) {
			io.println((i + 1) + ") " + container.getQuestionWithouAnswer(i));
			as.addAnswer(container.getQuestion(i).makeAnswer());
		}

		File file = new File(io.readString("Save the answersheet: Enter file name"));
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
			os.writeObject(as);
			os.close();
			io.println("Saved.");
		} catch (Exception ex) {
			ex.printStackTrace(System.out);
			io.println("Save Failed.");
		}
	}

	private static void modify(Map<String, ? extends Questionnaire> qnMap) {
		String qnName = io.readString("What questionnaire do you wish to modify?");
		Questionnaire container = qnMap.get(qnName);

		if ((container == null) || (container.size() == 0)) {
			io.println("The questionnaire is empty.");
			return;
		}

		display(container);
		int index = 0;
		do {
			index = io.readInt("What question do you wish to modify (Enter -1 to exit)") - 1;
			if (index == -1)
				break;
		} while ((index < 0) || (index >= container.size()));

		container.getQuestion(index).modify();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static Questionnaire create(String type) {

		String qnName = io.readString("What is the name of the " + type + "?");
		Questionnaire container = null;
		try {
			Class qnClass = Class.forName("entity.questionnaire." + type);
			container = (Questionnaire) qnClass.getConstructor(String.class).newInstance(qnName);
		} catch (Exception e) {
			e.printStackTrace();
			return container;
		}

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
				return container;
			}
		}
	}

	private static void display(Map<String, ? extends Questionnaire> qnMap) {
		String qnName = io.readString("What questionnaire do you wish to display?");
		Questionnaire container = qnMap.get(qnName);
		display(container);
	}

	private static void display(Questionnaire container) {
		if ((container == null) || (container.size() == 0)) {
			io.println("The questionnaire is empty.");
			return;
		}

		for (int i = 0; i < container.size(); i++)
			io.println((i + 1) + ") " + container.getQuestion(i) + "\n");
	}

	private static void save(Map<String, ? extends Questionnaire> qnMap) {
		String qnName = io.readString("What questionnaire do you wish to save?");
		Questionnaire container = qnMap.get(qnName);
		File file = new File(io.readString("Save: Enter file name"));
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
	private static Questionnaire load(String type) {
		File file = new File(io.readString("Load: Enter file name"));
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(file));
			Questionnaire c = (Questionnaire) is.readObject();
			if (c.getClass() == Class.forName("entity.questionnaire." + type)) {
				io.println(c.getName() + " loaded.");
				return c;
			} else {
				io.println("Type mismatch.");
			}
		} catch (Exception ex) {
			ex.printStackTrace(System.out);
			io.println("Load Failed.");
		}
		return null;
	}

	@SuppressWarnings("resource")
	private static void loadAnswerSheet() {
		File file = new File(io.readString("Load: Enter file name"));
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(file));
			AnswerSheet as = (AnswerSheet) is.readObject();
			if (as instanceof AnswerSheet) {
				int i = 0;
				for (Answer a : as) {
					io.println((++i) + ") " + a.getQuestion());
					io.println(a.toString() + "\n");
				}
			} else {
				io.println("Type mismatch.");
			}
		} catch (Exception ex) {
			io.println("Load Failed.");
		}
	}

}
