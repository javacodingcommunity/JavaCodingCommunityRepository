package eu.supermario.implementation;

public class SecondMain {

	public static void main(String[] args) {
		// this main lets you run the game
		// and the computer will play it for you									
		
		SuperMarioImplementation sm = new SuperMarioImplementation(); // creating Super Mario
		// adding coins
		
		
		sm.getCointCount(); // returns 0
        sm.getCurrentState();
        
        
        
        for(int i=0; i<10;i++) {
            sm.pick(Item.COIN);
        }
        System.out.println();
        sm.getCointCount(); // returns 13
        sm.getCurrentState(); // returns State.SMALL_MARIO
        System.out.println();

        // Mario can't shoot as SMALL_MARIO
        sm.fire(); // returns false

        //picking up the shroom and changes states
        sm.pick(Item.MUSHROOM);
        System.out.println();
       System.out.println(sm.getCurrentState()); // returns State.BIG_MARIO
        System.out.println(sm.fire()); // returns false, he can't shoot as BIG MARIO
        sm.pick(Item.MUSHROOM); // picks up the shroom
        System.out.println(sm.getCurrentState()); // returns  State.BIG_MARIO
        System.out.println(sm.fire()); // returns false, can't shoot as BIG MARIO

        // picks up a flower
        sm.pick(Item.FLOWER);
        System.out.println("Picks up a flower!");
        System.out.println(sm.getCurrentState()); // returns State.FIRE_MARIO
        System.out.println(sm.fire()); // returns true, he CAN shoot as FIRE_MARIO
        sm.pick(Item.FLOWER);
        System.out.println(sm.getCurrentState()); // returns State.FIRE_MARIO
        System.out.println(sm.fire()); // returns true, he CAN shoot as BIG MARIO

        //takes a hit
        sm.receiveHit();
        System.out.println("Mario recieved a hit");
        System.out.println(sm.getCurrentState()); // returns State.SMALL_MARIO
        sm.pick(Item.FLOWER); // picks up the flower
        System.out.println(sm.getCurrentState()); // returns State.BIG_MARIO

        sm.receiveHit();
        System.out.println(sm.getCurrentState()); // returns State.SMALL_MARIO

        sm.receiveHit();
        System.out.println(sm.getCurrentState()); // returns State.DEAD

        sm.receiveHit();
        sm.getCurrentState(); // returns State.DEAD

        // checking if our conditions work while dead
        sm.pick(Item.FLOWER);
        System.out.println(sm.getCurrentState()); // returns State.DEAD
        sm.pick(Item.MUSHROOM);
        System.out.println(sm.getCurrentState()); // returns State.DEAD

        sm.pick(Item.COIN);
        System.out.println(sm.getCointCount()); // returns 13, he didn't loose his coins


	}

}
