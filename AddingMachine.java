/**
 * Matthew Yates
 * CSE360 (85141) Assignment 2
 * This is a Adding Machine
 */
package cse360assign2;
public class AddingMachine {
	private int total;
	private int count = 0;;
	private int[] history = new int[1000];
	public AddingMachine () {
		total = 0;  // not needed - included for clarity
		count = 0;
		history[count] = total;
	}
	public int getTotal () {
		return total;
	}
	public void add (int value) {
		total += value;
		count++;
		history[count] = total;
	}
	public void subtract (int value) {
		total -= value;
		count++;
		history[count] = total;
	}
	public String toString () {
		String str = String.valueOf(history[0]);
		for(int i = 1; i < count + 1; i++) {
			if(history[i] < history[i-1]) {
				str += " - " + String.valueOf(history[i]);
			}
			else if(history[i] > history[i-1]) {
				str += " + " + String.valueOf(history[i]);
			}
			else {
				//If added or subtracted zero, don't include in history due to it being pointless
			}
		}
		return str;
	}
	public void clear() {}
}