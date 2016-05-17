/**
 * 
 */
package com.sue.sequence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 文件操作工具类：提供文件读和写
 * 
 * @author sue
 *
 */
public class FileUtils {
	
	public static List<String> readList(File file){
		BufferedReader br = null;
		List<String> data = new ArrayList<String>();
		try{
			br = new BufferedReader(new FileReader(file));
			for(String str=null; (str = br.readLine())!=null; ){
				data.add(str);
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return data;
	}
	
	public static void rewrite(File file, String data){
		BufferedWriter bw = null;
		try{
			bw = new BufferedWriter(new FileWriter(file));
			bw.write(data);
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(bw != null){
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
