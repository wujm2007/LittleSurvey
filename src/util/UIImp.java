package util;

import java.util.List;

/* 
 * This is an Interface which is a part of the Bridge Pattern.
 * It defines some primitive UI operations that is sufficient make up
 * of every complex UI operations in the project.
 */

public abstract class UIImp {

	// read an Integer
	public abstract int readInt(String msg);

	// read a prompt of a certain type of question
	public abstract String readPrompt(String type);

	// print on screen
	public abstract void println(String msg);

	// read a list of a choices
	public abstract List<String> readChoices(String type);

	// read a list of a choices (at most n)
	public abstract List<String> readChoices(String type, int n);

	// read a String
	public abstract String readString(String msg);

	// get the index from a String (returns -1 if input is invalid)
	public abstract int getIndex(String tmp);

	// read a boolean
	public abstract boolean readBoolean(String msg, String strTrue, String strFalse);

	// read the choice
	public abstract int readChoice();

}