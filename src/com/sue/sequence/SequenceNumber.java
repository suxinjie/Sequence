/**
 * 
 */
package com.sue.sequence;

/**
 * 
 * ͳһ�����࣬���崦����������ʵ��
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
