package com.belloy.aug211.tk;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class TKMainAns {
	public static void main(String[] args) {
		try {
			Configuration c = new Configuration();
//			c.set("mapreduce.framework.name", "yarn");
			Configuration c2 = new Configuration();
			c2.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
			Job j = Job.getInstance(c2);
			
			j.setMapperClass(TKMapperAns.class);
			j.setCombinerClass(TKReducerAns.class);
			j.setReducerClass(TKReducerAns.class);
			
			j.setOutputKeyClass(Text.class);
			j.setOutputValueClass(IntWritable.class);
			
			// 파일 지정
			String fileName = null;
			for (int i = 1; i <= 10; i++) {
				fileName = String.format("/ThreeKingdoms%02d.txt", i);
				FileInputFormat.addInputPath(j, new Path(fileName));
			}
			
			FileOutputFormat.setOutputPath(j,  new Path(args[0]));
			
			j.waitForCompletion(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
