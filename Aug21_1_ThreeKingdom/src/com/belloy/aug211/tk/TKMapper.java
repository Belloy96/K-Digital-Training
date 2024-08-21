package com.belloy.aug211.tk;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TKMapper extends Mapper<Object, Text, Text, IntWritable> {
	
	private static final Text PERSON = new Text();
	private static final IntWritable ONE = new IntWritable(1);
	
	@Override
	protected void map(Object key, Text value, Mapper<Object, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		
		String line = value.toString();
		
		String[] names = {"유비", "현덕", "조조", "맹덕", "손권", "중모"};
		
		for (String name : names) {
			if (line.contains(name)) {
				PERSON.set(name);
				context.write(PERSON, ONE);
			}
		}
		
	}

}
