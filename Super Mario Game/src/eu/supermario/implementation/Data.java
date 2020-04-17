package eu.supermario.implementation;

interface SuperMario { 
	
	// We've stored methods in side an interface
	// And we implement them in SuperMarioImplementation.java
	
	// NOTE: Mario MUST be alive to preform these actions
	
	void pick(Item item); // picks up and item and 
                          // changes the state depending on what he picked up
    
    public void receiveHit(); // if he is alive, he recieves a hit and changes the state
    
   
    public boolean fire(); // shoots fire if in correct state
    					  //  returns true if possible, false otherwise
    
    
    public int getCointCount(); // returns and integer containing Coin Count
    
    
    public State getCurrentState(); // returns the Current State of Mario
    
}

enum Item {  // storing items that Mario can pick up
    COIN, MUSHROOM, FLOWER // inside an enumeration
}

enum State { // storing Mario's states 
    DEAD, SMALL_MARIO, BIG_MARIO, FIRE_MARIO  // inside an enumeration
   
}



