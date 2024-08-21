package com.belloy.aug211.tk;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

// IN
//		key : ???
//		value : 유비는 귀가 큽니다.
//				장비는 술을 좋아해요
//				...
/////////////////////////////////////////
// OUT
//		key : 유비
//		value : 1

public class TKMapperAns extends Mapper<Object, Text, Text, IntWritable>{
	
	private static final Text WHO = new Text();
	private static final IntWritable ONE = new IntWritable(1);
	
	@Override
	protected void map(Object key, Text value, Mapper<Object, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		
		StringTokenizer st = new StringTokenizer(value.toString(), " ");
		
		String word = null;
		while (st.hasMoreTokens()) {
			word = st.nextToken();
			// 유비는
			// 귀가
			// 큽니다.
			if (word.contains("유비") || word.contains("현덕")) {
				WHO.set("유비");
				context.write(WHO, ONE);
			} else if (word.contains("조조") || word.contains("맹덕")) {
				WHO.set("조조");
				context.write(WHO, ONE);
			} else if (word.contains("손권") || word.contains("중모")) {
				WHO.set("손권");
				context.write(WHO, ONE);
			}
		}
		
	}

}
