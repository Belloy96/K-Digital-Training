package com.belloy.aug212.bd;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class BDMapper extends Mapper<Object, Text, Text, IntWritable> {
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy,MM,dd");
	private final Text dayOfWeek = new Text();
	private final IntWritable getOnCount = new IntWritable();
	private final IntWritable getOffCount = new IntWritable();
	
	@Override
	protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {

		String line = value.toString();
		String[] busData = line.split(",");

		String year = busData[0];
		String month = busData[1];
		String day = busData[2];
		String dateString = year + "," + month + "," + day;
		
		int getOn = Integer.parseInt(busData[5]);
		int getOff = Integer.parseInt(busData[6]);
		
		try {
			Date date = dateFormat.parse(dateString);
			SimpleDateFormat dayOfWeekFormat = new SimpleDateFormat("EEEE");
			String dayOfWeekStr = dayOfWeekFormat.format(date);

			dayOfWeek.set(dayOfWeekStr + "_GetOn");
			getOnCount.set(getOn);
			context.write(dayOfWeek, getOnCount);

			dayOfWeek.set(dayOfWeekStr + "_GetOff");
			getOffCount.set(getOff);
			context.write(dayOfWeek, getOffCount);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
