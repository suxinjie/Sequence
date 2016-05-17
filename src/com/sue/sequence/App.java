package com.sue.sequence;

/**
 * 
 * APIʹ��
 * 
 * @author sue
 *
 */
public class App {

	public static void main(String[] args) {
		final SequenceNumberByDayPersientFile sequence = new SequenceNumberByDayPersientFile(5, "sequence.data");
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0 ;i<10 ;i++){
					System.out.println("thread-1 : " + sequence.getSequence());
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0 ;i<10 ;i++){
					System.out.println("thread-2 : " + sequence.getSequence());
				}			
			}
		}).start();

		new Thread(new Runnable() {
	
			@Override
			public void run() {
				for(int i=0 ;i<10 ;i++){
					System.out.println("thread-3 : " + sequence.getSequence());
				}			
			}
		}).start();

	}
}
