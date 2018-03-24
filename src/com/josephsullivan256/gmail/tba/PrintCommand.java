package com.josephsullivan256.gmail.tba;

public class PrintCommand implements Command {

	private String name, description;
	
	public PrintCommand(String name, String description){
		this.name = name;
		this.description = description;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void perform() {
		System.out.println(description);
	}

}
