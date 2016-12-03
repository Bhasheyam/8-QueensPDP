package Queenshaddop.Queens8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Eightqueenserial {

	static long startTime;
	static  long endTime;
	static long totalTime;
	
	 FileOutputStream fop;
		
	
	 int[] x;

	    public Eightqueenserial(int N,String s) throws FileNotFoundException {
	        x = new int[N];
	    	File file = new File(s);
	       fop = new FileOutputStream(file);
	    }

	    public boolean canPlaceQueen(int r, int c) {
	        /**
	         * Returns TRUE if a queen can be placed in row r and column c.
	         * Otherwise it returns FALSE. x[] is a global array whose first (r-1)
	         * values have been set.
	         */
	        for (int i = 0; i < r; i++) {
	            if (x[i] == c || (i - r) == (x[i] - c) ||(i - r) == (c - x[i])) 
	            {
	                return false;
	            }
	        }
	        return true;
	    }

	    public void printQueens(int[] x) throws IOException {
	        int N = x.length;
	        for (int i = 0; i < N; i++) {
	            for (int j = 0; j < N; j++) {
	                if (x[i] == j) {
	                	String g="q";
	                	byte[] contentInBytes=g.getBytes();
	                	fop.write(contentInBytes);

	                    //System.out.print("Q ");
	                } else {
	                	String g="*";
	                	byte[] contentInBytes=g.getBytes();
	                	fop.write(contentInBytes);
	                   // System.out.print("* ");
	                }
	            }
	            fop.write(System.getProperty("line.separator").getBytes());
	        }
	        fop.write(System.getProperty("line.separator").getBytes());
	    }

	    public void startclock(){
	    startTime = System.currentTimeMillis();
	    	
	    }
	    public void stopclock() throws IOException
	    {
	    	 endTime   = System.currentTimeMillis();
		       totalTime = endTime - startTime;
		       String g=totalTime+" Millisec";
		       byte[] gb=g.getBytes();
		       fop.write(gb);
	    }
	    public void placeNqueens(int r, int n) throws IOException {
	        /**
	         * Using backtracking this method prints all possible placements of n
	         * queens on an n x n chessboard so that they are non-attacking.
	         */
	   
	        for (int c = 0; c < n; c++) {
	            if (canPlaceQueen(r, c)) {
	                x[r] = c;
	                if (r == n - 1) {
	                    printQueens(x);
	                } else {
	                    placeNqueens(r + 1, n);
	                }
	            }
	        }
	    }

	    public void callplaceNqueens() throws IOException {
	        placeNqueens(0, x.length);
	    }

}
