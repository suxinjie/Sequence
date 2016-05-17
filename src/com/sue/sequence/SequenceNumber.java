/**
 * 
 */
package com.sue.sequence;

/**
 * 
 * 统一抽象父类，具体处理方法由子类实现
 * 
 * @author sue
 *
 */
abstract class SequenceNumber {
	
	public synchronized String getSequence() {
		return process();
	}
	
	protected abstract String process();
}
