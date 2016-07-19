package util;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CmdLineIOHelper extends AbstractIOHelper {
	private static CmdLineIOHelper instance;
	private Scanner scanner;

	private CmdLineIOHelper() {
	};

	public static AbstractIOHelper getInstance() {
		if (instance == null) {
			return (instance = new CmdLineIOHelper());
		}
		return instance;
	}

	public int readInt(String msg) {
		System.out.print(msg + ":\n> ");
		scanner = new Scanner(System.in);
		String strinput = scanner.next();
		int input;
		try {
			input = Integer.parseInt(strinput);
		} catch (NumberFormatException e) {
			println("Number Format Error!");
			return readInt(msg);
		}
		return input;
	}

	public String readPrompt(String type) {
		System.out.print("Enter the prompt for you " + type + " question:\n> ");
		scanner = new Scanner(System.in);
		return scanner.next();
	}

	public void println(String msg) {
		System.out.println(msg);
	}

	public List<String> readChoices(String type) {
		int n = readInt("Enter the number of choices for " + type);
		if ((n < 2) || (n > 9)) {
			println("Invalid number.");
			return readChoices(type);
		}
		List<String> choiceList = new LinkedList<String>();
		for (int i = 0; i < n; i++)
			choiceList.add(readString("(" + (char) ('A' + i) + ")"));
		return choiceList;
	}

	public List<String> readChoices(String type, int n) {
		this.println("Enter the choices for " + type);
		List<String> choiceList = new LinkedList<String>();
		for (int i = 0; i < n; i++)
			choiceList.add(readString("(" + (char) ('A' + i) + ")"));
		return choiceList;
	}

	public String readString(String msg) {
		scanner = new Scanner(System.in);
		System.out.print(msg + ":\n> ");
		return read();
	}

	private String read() {
		scanner = new Scanner(System.in);
		return scanner.next();
	}

	public int getIndex(String tmp) {
		if (tmp.length() == 1) {
			char charInedex = tmp.charAt(0);
			if ((charInedex >= 'A') && (charInedex <= 'Z'))
				return charInedex - 'A';
			else if ((charInedex >= 'a') && (charInedex <= 'z'))
				return charInedex - 'a';
		}
		return -1;
	}

	public boolean readBoolean(String msg, String strTrue, String strFalse) {
		System.out.print(msg + ":\n> ");
		scanner = new Scanner(System.in);
		String input = scanner.next();
		if (input.equalsIgnoreCase(strTrue))
			return true;
		else if (input.equalsIgnoreCase(strFalse))
			return false;
		else {
			System.out.println("Boolean Format Error! (Please input " + strTrue + "/" + strFalse + ")");
			return readBoolean(msg, strTrue, strFalse);
		}
	}

	public int readChoice() {
		int index = getIndex(readString("index "));
		if (index == -1) {
			println("Invalid index.");
			return readChoice();
		}
		return index;
	}

}