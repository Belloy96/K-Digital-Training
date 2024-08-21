package com.belloy.aug212.bd;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class BDMain {
    public static void main(String[] args) {
        try {
            Configuration c = new Configuration();
            c.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
            Job j = Job.getInstance(c);
            
            j.setMapperClass(BDMapper.class);
            j.setCombinerClass(BDReducer.class);
            j.setReducerClass(BDReducer.class);

            j.setOutputKeyClass(Text.class);
            j.setOutputValueClass(IntWritable.class);
            
            String fileName = null;
            for (int i = 2021; i <= 2023; i++) {
				fileName = String.format("/busData%d.csv", i);
				FileInputFormat.addInputPath(j, new Path(fileName));
			}
            
            FileOutputFormat.setOutputPath(j, new Path(args[0]));
            
            j.waitForCompletion(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
