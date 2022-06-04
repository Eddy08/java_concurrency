package app;

public class main {

	public static void main(String[] args) {
		Runnable run= ()->{
			System.out.println(
					"I am running in thread"+Thread.currentThread().getName());
		};
		Thread t=new Thread(run);
		t.start();
		MillionNumber m=new MillionNumber(10l);

		Runnable second_task=()->{
			for(int i=0;i<1;i++) {
				m.incrementValue();
			}
			System.out.println(m.getValue());
		};
		Thread t3_arr[]=new Thread[10000];
		for(int i=0;i<t3_arr.length;i++) {
			
			t3_arr[i]=new Thread(second_task);
			t3_arr[i].start();
		}
//		Thread t2=new Thread(second_task);
//		t2.start();
		
	}
		

}
class MillionNumber{
	// for Syncronization create a key
	Object key=new Object();
	private long l;
	public MillionNumber(long l) {
		this.l=l;
	}
	
	public long getValue() {
		return l;
	}
	public void incrementValue() {
		synchronized(key){
			
			l=l+1;
		}
	}
	
}
