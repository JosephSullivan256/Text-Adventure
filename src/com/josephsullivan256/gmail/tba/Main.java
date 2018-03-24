package com.josephsullivan256.gmail.tba;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		String input = "";
		
		Scanner sc = new Scanner(System.in);
		
		Room a = new Room("a","There is a door to your east");
		Room b = new Room("b","There is a door to your west and south");
		Room c = new Room("c","There is a door to your west and north");
		Room d = new Room("d","There is a door to your east");
		
		a.addRoom("east", b);
		b.addRoom("west", a);
		b.addRoom("south", c);
		c.addRoom("north", b);
		c.addRoom("west", d);
		d.addRoom("east", c);
		
		Player p = new Player();
		
		a.addChild(p);
		
		while (true){
			input = sc.nextLine();
			
			if("exit".equals(input)) break;
			
			if(!p.perform(input)){
				System.out.println("unknown command");
			}
		}
		
		sc.close();
	}
}
