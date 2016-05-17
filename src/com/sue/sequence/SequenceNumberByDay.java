/**
 * 
 */
package com.sue.sequence;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * 根据天 + 流水的形式获取Sequence
 * 
 * 持久化方式由子类决定
 * 
 * @author sue
 *
 */
abstract class SequenceNumberByDay extends SequenceNumber {

	protected final static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");  
    protected DecimalFormat df = null;  
  
    public SequenceNumberByDay(int width) {  
        if (width < 1) {  
            throw new IllegalArgumentException("Parameter length must > 1");  
        }  
        char[] chs = new char[width];  
        for (int i = 0; i < width; i++) {  
            chs[i] = '0';  
        }  
        df = new DecimalFormat(new String(chs));  
    }
  
	@Override
    protected String process() {  
        Date date = new Date();  
        int n = persientNumber(date, 1);  
        return format(date) + format(n);  
    }
  
    protected String format(Date date) {  
        return sdf.format(date);  
    }  
  
    protected String format(int num) {  
        return df.format(num);  
    }  
  
    protected abstract int persientNumber(Date current, int start);  
}
