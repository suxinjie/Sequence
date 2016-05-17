/**
 * 
 */
package com.sue.sequence;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 
 * 性能测试
 * 
 * @author sue
 *
 */
public class TPSTest {
	
	public static void main(String[] args) {
		
		ExecutorService executorPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		final SequenceNumberByDayPersientFile sequence = new SequenceNumberByDayPersientFile(5, "sequence.data");
		List<Callable<String>> list = new ArrayList<Callable<String>>();
			
		for(int i=0 ;i<100000; i++){
			list.add(new Callable<String>() {

				@Override
				public String call() throws Exception {
					return sequence.getSequence();
				}
				
			});
		}
		
		try {
            long s = System.currentTimeMillis();
            executorPool.invokeAll(list, 10000, TimeUnit.SECONDS);
            long s_avg = System.currentTimeMillis() - s;
            System.out.println("完成时间需要: " + s_avg / 1.0e3 + "秒");
            executorPool.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
		
}
