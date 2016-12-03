package Queenshaddop.Queens8;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.Iterator;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.ClientContext;
import org.apache.hadoop.io.IntWritable;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Queenreduce extends  Reducer< Text,Text,Text, Text>{
	 
	@SuppressWarnings("unchecked")
	protected void reduce( Text key, Iterable<Text> values,Context context)throws IOException, InterruptedException {
	
		
		Iterator<Text> valuesIt = values.iterator();
	   
	   	  File f=new File("time.txt");
		     FileOutputStream fop=new FileOutputStream(f);
		    
		     long startTime=System.currentTimeMillis();
		while(valuesIt.hasNext()){
			
		        
		        String h=valuesIt.next().toString();
		       int a=Integer.parseInt(h); 	
		        Eightqueenserial Q = new Eightqueenserial(a,"/home/bhasheyam/hadoop"+h+".txt");
		    		Q.startclock();
		            Q.callplaceNqueens();
		            Q.stopclock();
		}
		
	       
		 
		context.write(key,new Text("done"));
		 long endTime = System.currentTimeMillis();
		 long totalTime = endTime - startTime;
	       String g=totalTime+" Milliseconds";
	       byte[] gb=g.getBytes();
	       fop.write(gb);
		    }  
	
	
}
