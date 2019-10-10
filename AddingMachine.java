/**
 * Matthew Yates
 * CSE360 (85141) Assignment 2
 * This class allows the user to add and subtract values from a running
 * total, while keeping a transaction record of all modifiers
 */
package cse360assign2;
public class AddingMachine {
	private int total;
	private int count = 0;;
	private int[] history = new int[1000];
	
	/**
	 * AddingMachine Constructor
	 */
	public AddingMachine () {
		total = 0;  // not needed - included for clarity
		count = 0;
		history[count] = total;
	}
	
	/**
	 * Gets the total
	 * @return total
	 */
	public int getTotal () {
		return total;
	}
	
	/**
	 * adds a value to the total
	 * @param value the value to be added
	 */
	public void add (int value) {
		total += value;
		count++;
		history[count] = total;
	}
	
	/**
	 * subtracts a value from the total
	 * @param value the value to be subtracted
	 */
	public void subtract (int value) {
		total -= value;
		count++;
		history[count] = total;
	}
	
	/**
	 * @return a string of the history of additions and subtractions (except 0)
	 */
	public String toString () {
		String str = String.valueOf(history[0]);
		for(int i = 1; i < count + 1; i++) {
			if(history[i] < history[i-1]) {
				str += " - " + String.valueOf(history[i-1] - history[i]);
			}
			else if(history[i] > history[i-1]) {
				str += " + " + String.valueOf(history[i] - history[i-1]);
			}
			else {
				//If added or subtracted zero, don't include in history
			}
		}
		return str;
	}
	
	/**
	 * resets all variables
	 */
	public void clear() {
		for(int i = 0; i <= count; i++) {
			history[i] = 0;
		}
		count = 0;
		total = 0;
	}
}