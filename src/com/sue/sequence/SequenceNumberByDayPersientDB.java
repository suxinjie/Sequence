/**
 * 
 */
package com.sue.sequence;

import java.util.Date;

/**
 * 
 * 通过数据库的方式持久化数据
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
