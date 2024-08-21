package com.belloy.aug212.bus;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

// IN
//		key : ???
//		value : 2024,8,21,100,XXXX,12,0
// OUT
//		key : 수
//		value : 12 (12 + 0)

public class BHMapper extends Mapper<Object, Text, Text, LongWritable> {
	
	private static final Text DAY = new Text();
	private static final LongWritable SUM = new LongWritable();
	
	@Override
	protected void map(Object key, Text value, Mapper<Object, Text, Text, LongWritable>.Context context)
			throws IOException, InterruptedException {

		try {
			String line = value.toString();
			String[] line2 = line.split(",");

			// 날짜처리
			String y = line2[0];
			int m = Integer.parseInt(line2[1]);
			int d = Integer.parseInt(line2[2]);

			String date = String.format("%s%02d%02d", y, m, d);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			Date date2 = sdf.parse(date);
			
			sdf = new SimpleDateFormat("E");
			String day = sdf.format(date2);		
			
			long l1 = Long.parseLong(line2[5]);		
			long l2 = Long.parseLong(line2[6]);		
			
			DAY.set(day);
			SUM.set(l1 + l2);
			context.write(DAY, SUM);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
