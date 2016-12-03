package Queenshaddop.Queens8;

import java.io.IOException;

import java.util.StringTokenizer;

 
import org.apache.hadoop.io.IntWritable;

import org.apache.hadoop.io.LongWritable;

import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Mapper;

public class Queenmap extends Mapper<LongWritable, Text,Text,Text> {

	private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();
   
    
    /**
     * map function of Mapper parent class takes a line of text at a time
     * splits to tokens and passes to the context as word along with value as one
     */
	@Override
	protected void map(LongWritable key, Text value,
			Context context)
			throws IOException, InterruptedException {
		
		String line = value.toString();
		StringTokenizer st = new StringTokenizer(line," ");
		
		while(st.hasMoreTokens()){
			System.out.println("in");
			word.set(st.nextToken().toString());
			context.write(new Text("kk"),word);
			 
			//System.out.println("mapper"+st.nextToken());
		}
		
	}
	
	

}
