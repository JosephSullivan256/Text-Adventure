package com.josephsullivan256.gmail.tba;

import java.util.ArrayList;
import java.util.List;

public class Room implements Node {

	private String name, description;
	
	private List<ChangeRoomCommand> commands;
	private List<Node> children;
	
	public Room(String name, String description){
		this.name = name;
		this.description = description;
		commands = new ArrayList<ChangeRoomCommand>();
		children = new ArrayList<Node>();
	}
	
	@Override
	public void provide(CommandConsumer c, RelationType rt) {
		if(rt.equals(RelationType.child)){
			List<Command> temp = generateChangeRoomCommands(c);
			temp.add(new PrintCommand("look",toString()+"\n"+description));
			c.addCommands(this, temp);
		}
	}
	
	public List<Command> generateChangeRoomCommands(Node n){
		List<Command> temp = new ArrayList<Command>();
		for(ChangeRoomCommand command : commands){
			temp.add(new ChangeRoomCommand(command,n));
		}
		return temp;
	}
	
	public void addRoom(String relativeName, Room r){
		commands.add(new ChangeRoomCommand(relativeName, this, r, null));
	}
	
	private static class ChangeRoomCommand implements Command{
		private String relativeName;
		private Room src;
		private Room des;
		private Node n;
		public ChangeRoomCommand(String relativeName, Room src, Room des, Node n){
			this.relativeName = relativeName;
			this.src = src;
			this.des = des;
			this.n = n;
		}
		public ChangeRoomCommand(ChangeRoomCommand c, Node n){
			this(c.relativeName,c.src,c.des,n);
		}
		@Override
		public String getName() {
			return relativeName;
		}
		@Override
		public String getDescription() {
			return "Move from room " + src + " to room " + des;
		}
		@Override
		public void perform() {
			System.out.println(getDescription());
			if(n!=null && src.removeChild(n)){
				des.addChild(n);
			}
		}
	}

	@Override
	public void addChild(Node n) {
		n.associate(this,RelationType.child);
		for(Node child : children){
			n.associate(child, RelationType.sibling);
		}
		children.add(n);
	}

	@Override
	public boolean removeChild(Node n) {
		if(children.remove(n)){
			n.dissociate(this);
			this.dissociate(n);
			for(Node child : children){
				if(child!=n){
					n.dissociate(child);
				}
			}
			return true;
		}
		return false;
	}
	
	@Override
	public List<Node> getChildren() {
		return new ArrayList<Node>(children);
	}
	
	@Override
	public void dissociate(Node n) {
		
	}

	@Override
	public void associate(Node n, RelationType rt) {
		
	}
	
	@Override
	public String toString(){
		return name;
	}
	
	public String getDescription(){
		return description;
	}
}
