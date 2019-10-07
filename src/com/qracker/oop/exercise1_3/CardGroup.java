package com.qracker.oop.exercise1_3;

public class CardGroup {
	private Card c1;
	private Card c2;
	private Card c3;
	
	CardGroup(Card c1, Card c2, Card c3) {
		// TODO 3.1
		this.c1 = c1;
		this.c2 = c2;
		this.c3 = c3;
	}
	
	/*
	 * Return the number of cards with the same number
	 */
	private int numOfSameNumber() {
		// TODO 3.2
		int count = 0;
		if(c1.getNumber() == c2.getNumber())
			count++;
		if(c1.getNumber() == c3.getNumber())
			count++;
		if(c2.getNumber() == c3.getNumber())
			count++;
		return count;
	}
	
	/*
	 * Return if all cards in the group are of the same suit.
	 */
	private boolean ofSameSuit() {
		// TODO 3.3
		return c1.getSuit() == c2.getSuit() && c2.getSuit() == c3.getSuit();
	}
	
	/*
	 * Compare if it is bigger than CardGroup c
	 * @param c another CardGroup
	 * @return true if it is bigger than c, false otherwise. 
	 */
	public boolean compare(CardGroup c) {
		// TODO 3.4
		if(this.ofSameSuit()){
			if(c.ofSameSuit())
				return false;
			else
				return true;
		}
		else if(c.ofSameSuit())
			return false;
		else
			return (this.numOfSameNumber() > c.numOfSameNumber());
	}

	@Override
	public String toString(){
		return this.c1.getNumber() + " " +this.c1.getSuit() +","
				+ this.c2.getNumber() + " " +this.c2.getSuit() + ","
				+ this.c3.getNumber() + " " +this.c3.getSuit();
	}

}
