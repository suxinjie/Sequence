/**
 * 
 */
package com.sue.sequence;

import java.util.Date;

/**
 * 
 * ͨ�����ݿ�ķ�ʽ�־û�����
 * 
 * @author sue
 *
 */
public class SequenceNumberByDayPersientDB extends SequenceNumberByDay {

	public SequenceNumberByDayPersientDB(int width) {
		super(width);
	}

	@Override
	protected int persientNumber(Date current, int start) {
		//
		return 0;
	}

}
