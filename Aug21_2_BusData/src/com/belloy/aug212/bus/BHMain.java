package com.belloy.aug212.bus;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class BHMain {
	public static void main(String[] args) {
		try {
			Configuration c = new Configuration();
			Job j = Job.getInstance(c);
			
			j.setMapperClass(BHMapper.class);
			j.setCombinerClass(BHReducer.class);
			j.setReducerClass(BHReducer.class);
			
			j.setOutputKeyClass(Text.class);
			j.setOutputValueClass(LongWritable.class);
			
			String fileName = null;
			for (int i = 2021; i <= 2023; i++) {
				fileName = String.format("/busData%d.csv", i);
				FileInputFormat.addInputPath(j, new Path(fileName));
			}
			FileOutputFormat.setOutputPath(j, new Path("/busResult"));
			
			j.waitForCompletion(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
