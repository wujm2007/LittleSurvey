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
import util.UIImp;
import util.ConsoleUIImp;
import util.visitor.ModifyQuestionVisitor;

/*
 * This is the main driver of the project.
 */

public class Main {
	private static UIImp io = ConsoleUIImp.getInstance();
	private static Map<String, Survey> surveys;
	private static Map<String, Test> tests;

	// initialize the filed and print menu
	public static void main(String args[]) {
		io = ConsoleUIImp.getInstance();
		surveys = new HashMap<String, Survey>();
		tests = new HashMap<String, Test>();
		showMenu();
	}

	// print menu and operate according to user's selection
	public static void showMenu() {
		while (true) {
			io.println("0) Display Survey/Test list");
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
			case 0:
				displayList();
				break;
			case 1:
				Survey createdSurvey = (Survey) create("Survey", new SurveyQuestionFactory());
				surveys.put(createdSurvey.getName(), createdSurvey);
				break;
			case 2:
				Test createdTest = (Test) create("Test", new TestQuestionFactory());
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
				modify(surveys, new SurveyQuestionFactory());
				break;
			case 8:
				modify(tests, new TestQuestionFactory());
				break;
			case 9:
				Survey loadedSurvey = (Survey) load("Survey");
				if (loadedSurvey != null)
					surveys.put(loadedSurvey.getName(), loadedSurvey);
				break;
			case 10:
				Test loadedTest = (Test) load("Test");
				if (loadedTest != null)
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
			// this is a hidden entry for debugging (see loadAnswerSheet())
			case 14:
				loadAnswerSheet();
			}
		}
	}

	// display survey list and test list
	private static void displayList() {
		io.println("Survey list:");
		if (surveys.isEmpty())
			io.println("There's no survey.");
		else
			for (String s : surveys.keySet())
				io.println(s);
		io.println("Test list:");
		if (surveys.isEmpty())
			io.println("There's no test.");
		else
			for (String s : tests.keySet())
				io.println(s);

	}

	// take a Questionnaire according to user's selection
	private static void take(Map<String, ? extends Questionnaire> qnMap) {
		// get user's selection
		String qnName = io.readString("What questionnaire do you wish to take?");
		Questionnaire container = qnMap.get(qnName);

		// check if the Questionnaire is null or empty
		if ((container == null) || (container.size() == 0)) {
			io.println("The questionnaire is empty.");
			return;
		}

		// create an AnswerSheet to hold the answer
		AnswerSheet as = new AnswerSheet();
		// iterate the Questionnaire to let user answer
		for (int i = 0; i < container.size(); i++) {
			io.println((i + 1) + ") " + container.getQuestionWithoutAnswer(i));
			as.addAnswer(container.getQuestion(i).makeAnswer());
		}

		// save the response
		File file = new File(io.readString("Save the answersheet: Enter file name"));
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
			os.writeObject(as);
			os.close();
			io.println("Saved.");
		} catch (Exception ex) {
			// ex.printStackTrace(System.out);
			io.println("Save Failed.");
		}
	}

	// modify a Questionnaire according to user's selection
	private static void modify(Map<String, ? extends Questionnaire> qnMap, QuestionFactory factory) {
		String qnName = io.readString("What questionnaire do you wish to modify?");
		Questionnaire container = qnMap.get(qnName);

		// check if the Questionnaire is null or empty
		if ((container == null) || (container.size() == 0)) {
			io.println("The questionnaire is empty.");
			return;
		}

		// add questions
		if (io.readBoolean("Do you wish to add questions", "yes", "no")) {
			display(container);
			addQuestion(factory, container);
		}
		// remove questions
		while (io.readBoolean("Do you wish to remove questions", "yes", "no")) {
			display(container);
			if (container.isEmpty())
				break;
			int index = io.readInt("Enter the index of that question") - 1;
			if ((index >= 0) && (index < container.size()))
				container.removeQuestion(index);
			else
				io.println("Index error.");
		}
		// modify questions
		while (io.readBoolean("Do you wish to modify questions", "yes", "no")) {
			display(container);
			if (container.isEmpty())
				break;
			int index = io.readInt("Enter the index of that question") - 1;
			if ((index >= 0) && (index < container.size()))
				container.getQuestion(index).accept(new ModifyQuestionVisitor());
			else
				io.println("Index error.");
		}
	}

	// create a Questionnaire (Test or Survey)
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static Questionnaire create(String type, QuestionFactory factory) {

		// read its name
		String qnName = io.readString("What is the name of the " + type + "?");
		Questionnaire container = null;
		try {
			// use reflection to create it
			Class qnClass = Class.forName("entity.questionnaire." + type);
			container = (Questionnaire) qnClass.getConstructor(String.class).newInstance(qnName);
		} catch (Exception e) {
			// e.printStackTrace(System.out);
			return container;
		}
		// add questions to it
		addQuestion(factory, container);
		return container;
	}

	// addQuestion is reused by create() and modify()
	private static void addQuestion(QuestionFactory factory, Questionnaire container) {
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

	// iterate the Questionnaire to display its content
	private static void display(Map<String, ? extends Questionnaire> qnMap) {
		String qnName = io.readString("What questionnaire do you wish to display?");
		Questionnaire container = qnMap.get(qnName);
		display(container);
	}

	// it's reused by display() and modify()
	private static void display(Questionnaire container) {
		if ((container == null) || (container.size() == 0)) {
			io.println("The questionnaire is empty.");
			return;
		}

		for (int i = 0; i < container.size(); i++)
			io.println((i + 1) + ") " + container.getQuestion(i) + "\n");
	}

	// save a Questionnaire to a file using ObjectOutputStream
	private static void save(Map<String, ? extends Questionnaire> qnMap) {
		String qnName = io.readString("What questionnaire do you wish to save?");
		Questionnaire container = qnMap.get(qnName);
		if (container == null) {
			io.println(qnName + " don't exsist.");
			return;
		}
		File file = new File(io.readString("Save: Enter file name"));
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
			os.writeObject(container);
			os.close();
			io.println("Saved.");
		} catch (Exception ex) {
			// ex.printStackTrace(System.out);
			io.println("Save Failed.");
		}
	}

	// load a Questionnaire from a file using ObjectInputStream
	@SuppressWarnings("resource")
	private static Questionnaire load(String type) {
		File file = new File(io.readString("Load: Enter file name"));
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(file));
			Questionnaire c = (Questionnaire) is.readObject();
			// check if the loaded Questionnaire is the exact type we want
			if (c.getClass() == Class.forName("entity.questionnaire." + type)) {
				io.println(c.getName() + " loaded.");
				return c;
			} else {
				io.println("Type mismatch.");
			}
		} catch (Exception ex) {
			// ex.printStackTrace(System.out);
			io.println("Load Failed.");
		}
		return null;
	}

	// load an AnswerSheet from a file using ObjectInputStream
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
