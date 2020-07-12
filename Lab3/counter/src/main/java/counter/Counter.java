package counter;

public class Counter extends Subject {
	
	private int count=0;
	
	public void increment(){
		count++;
		onNotify();
	}
	
	public void decrement(){
		count--;
		onNotify();
	}

	public int getCount() {
		return count;
	}
}
