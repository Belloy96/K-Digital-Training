package com.belloy.aug211.tk;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class TKMain2 {
	public static void main(String[] args) {
		try {
			Configuration c = new Configuration();

			Job j = Job.getInstance(c);

			j.setMapperClass(TKMapper.class);
			j.setCombinerClass(TKReducer.class);
			j.setReducerClass(TKReducer.class);

			j.setOutputKeyClass(Text.class);
			j.setOutputValueClass(IntWritable.class);
			
			FileInputFormat.addInputPath(j, new Path(args[0]));

			FileOutputFormat.setOutputPath(j, new Path(args[1]));

			j.waitForCompletion(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
