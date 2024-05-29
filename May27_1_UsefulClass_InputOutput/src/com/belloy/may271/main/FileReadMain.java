package com.belloy.may271.main;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileReadMain {
	public static void main(String[] args) {
		
		BufferedReader br = null;
		try {
			FileReader fr = new FileReader("C:\\Users\\tpgns\\OneDrive\\바탕 화면\\Test/belloy1.txt");
			br = new BufferedReader(fr);
			
			String line = null;
			while ( ( line = br.readLine()) != null )  {
				System.out.println(line);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
