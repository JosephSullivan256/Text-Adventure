package com.josephsullivan256.gmail.tba;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player implements CommandConsumer {
	
	private Map<Node,List<Command>> commands;
	
	public Player(){
		commands = new HashMap<Node,List<Command>>();
	}
	
	public boolean perform(String input){
		for(List<Command> commands : commands.values()){
			for(Command c : commands){
				if(c.getName().equals(input)){
					c.perform();
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public ConsumerType getType() {
		return ConsumerType.player;
	}

	@Override
	public void provide(CommandConsumer c, RelationType rt) {
		
	}

	@Override
	public void addChild(Node n) {
		
	}

	@Override
	public boolean removeChild(Node n) {
		return false;
	}
	
	@Override
	public List<Node> getChildren() {
		return null;
	}

	@Override
	public void addCommands(Node n, List<Command> c) {
		commands.put(n, c);
	}

	@Override
	public void dissociate(Node n) {
		commands.remove(n);
	}

	@Override
	public void associate(Node n, RelationType r) {
		n.provide(this, r);
		
	}
}
