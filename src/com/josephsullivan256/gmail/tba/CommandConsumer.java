package com.josephsullivan256.gmail.tba;

import java.util.List;

public interface CommandConsumer extends Node{
	public void addCommands(Node n, List<Command> c);
	public ConsumerType getType();
}
