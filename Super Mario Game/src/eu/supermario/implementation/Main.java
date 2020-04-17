package eu.supermario.implementation;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		SuperMarioImplementation sm = new SuperMarioImplementation(); // creating Super Mario
		Scanner sc = new Scanner(System.in);
		String line = "";
		System.out.println("---------------------------Super Mario Version 1.0---------------------------");
		System.out.println(".......................powered by @javacodingcommunity.......................");
		
    	System.out.println();
    	System.out.println("Pringting possible commands...");
    	System.out.println("GET_COINS | GET_STATE | FIRE | SHROOM | COIN | FLOWER | HIT | ");
    	System.out.println();
        sm.getCointCount(); // returns 0
        sm.getCurrentState();
              
        while(true) {
        	if(sm.checkCurrentState() == State.DEAD) {
        		System.out.println("Whoops. Mario is dead. Game over!");
        		break;
        	}
        	System.out.println("Enter a command or enter 'END' to exit: ");
        	line = sc.nextLine();
        	
        	if(line.contentEquals("END")) {
        		System.out.println("Exiting...");
        		System.out.println("Sucessfully exited");
        		break;
        	}
        	else if(line.contentEquals("GET_COINS")) {
        		sm.getCointCount();
        	}
        	else if(line.contentEquals("GET_STATE")) {
        		sm.getCurrentState();
        	}
        	else if(line.contentEquals("FIRE")) {
        		sm.fire();
        	}
        	else if(line.contentEquals("SHROOM")) {
        		sm.pick(Item.MUSHROOM);
        	}
        	else if(line.contentEquals("COIN")) {
        		sm.pick(Item.COIN);
        	}
        	else if(line.contentEquals("FLOWER")) {
        		sm.pick(Item.FLOWER);
        	}
        	else if(line.contentEquals("HIT")) {
        		sm.receiveHit();
        	}}}}



