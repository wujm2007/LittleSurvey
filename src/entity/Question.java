package entity;

import java.io.Serializable;

import biz.IOHelper;

@SuppressWarnings("serial")
public abstract class Question implements Serializable {

	public IOHelper io() {
		return IOHelper.getInstance();
	}

	protected abstract String getPrompt();

	public abstract void setPrompt(String prompt);

	@Override
	public abstract String toString();
}