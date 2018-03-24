package com.josephsullivan256.gmail.tba;

public interface Command {
	public String getName();
	public String getDescription();
	public void perform();
}
