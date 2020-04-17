package eu.supermario.implementation;


public class SuperMarioImplementation implements SuperMario {

	
	private int coin_count;
	private State state;
	
	public SuperMarioImplementation() { // Constructor that sets him to a default state
		this.coin_count = 0;
		this.state = State.SMALL_MARIO;
		// 0 coints and SMALL_MARIO
	}
	
	
	@Override //overriding methods from SuperMario interface in Data.java
	public void pick(Item item) {
		if(state != State.DEAD) { // only do this while Mario is alive
			if(item == Item.COIN) {
				System.out.println("You picked up a coin!");
				coin_count++; // adding the coint count
		}
			else if(item == Item.MUSHROOM) { // if Mario picks up a shroom
				System.out.println("You picked up a shroom!");
				if(state == State.SMALL_MARIO) { // he changes his state to BIG_MARIO
					this.state = State.BIG_MARIO;
			}
			
		}
			else if(item == Item.FLOWER) { // if he picks up a flower
				System.out.println("You picked up a flower!");
				if(state == State.SMALL_MARIO) { // 2 things can happen
					this.state = State.BIG_MARIO; // from SMALL go to BIG
			}
				else if(state == State.BIG_MARIO) { // from BIG go to FIRE
					this.state = State.FIRE_MARIO;
					System.out.println("Woah, now you can FIRE!");
					}}}}
		
	

	@Override
	public void receiveHit() {
		
		if(state != State.DEAD) { // only do this while Mario is alive
		if(state == State.BIG_MARIO || state == State.FIRE_MARIO) { // Mario gets hit, he changes his state
			System.out.println("Mario recieved a hit!");
			this.state = State.SMALL_MARIO;
			System.out.println("His new state is "+state);
		}
		
		else if(state == State.SMALL_MARIO) { // if he is SMALL_MARIO and gets hit
			System.out.println("Mario recieved a hit!");
			this.state = State.DEAD;	 // he is DEAD
			System.out.println("Game over.");
		}}}
	
	@Override
	public boolean fire() {
		
		if(this.state == State.FIRE_MARIO) { // no need for DEAD condition as he
			System.out.println("Mario Fires at the enemies!");
			return true;					// needs to be in FIRE_MARIO anyways
		}
		System.out.println("You can't fire yet, Mario!");
		return false;
	}

	@Override
	public int getCointCount() { // returns coin_count;
		System.out.println("Mario has: "+coin_count+ " coins");
		if(coin_count > 10) {
			System.out.println("Wow, Mario. Could you lend me some?");
		}
		return coin_count;}

	@Override
	public State getCurrentState() { // returns current state;
		// TODO Auto-generated method stub
		System.out.println("Mario's current state is: "+ state);
		return state;
	}
	
	public State checkCurrentState() {
		return state; }
	}



