package com.belloy.aug211.tk;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class TKMain {
	public static void main(String[] args) {
		try {
			Configuration c = new Configuration();
			c.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
			Job j = Job.getInstance(c);
			
			j.setMapperClass(TKMapper.class);
			j.setCombinerClass(TKReducer.class);
			j.setReducerClass(TKReducer.class);

			j.setOutputKeyClass(Text.class);
			j.setOutputValueClass(IntWritable.class);
			
			for (int i = 1; i <= 10; i++) {
				String fileName = String.format("/ThreeKingdoms%02d.txt", i);
				FileInputFormat.addInputPath(j, new Path(fileName));
			}
			
			FileOutputFormat.setOutputPath(j, new Path("/tkResult"));
			
			j.waitForCompletion(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
