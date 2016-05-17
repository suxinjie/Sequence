/**
 * 
 */
package com.sue.sequence;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * 
 * 通过文件的方式持久化数据
 * 
 * @author sue
 *
 */
public class SequenceNumberByDayPersientFile extends SequenceNumberByDay {

	private File file = null;
	
	private final static String FILE_SEPARATOR = ",";
	
	public SequenceNumberByDayPersientFile(int width, String filename) {
		super(width);
		file = new File(filename);
	}

	@Override
	protected int persientNumber(Date current, int start) {
		String date = format(current);
		int num = start;
		if(file.exists()){
			//file内容：20160516,40
			List<String> list = FileUtils.readList(file);
			String[] data = list.get(0).split(FILE_SEPARATOR);
			//如果是两天一重置的话：date - data[0] > 2
			if(date.equals(data[0])){
				num = Integer.parseInt(data[1]);
			}
		}
		FileUtils.rewrite(file, date + FILE_SEPARATOR + (num + 1));
		return num;
	}

}
