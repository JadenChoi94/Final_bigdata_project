package bigdata;

<<<<<<< HEAD
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.io.*;
=======
import java.util.Random;
>>>>>>> 9e0b151a376803217fc285800e3cf968ba377cc7

public class test {

	public static void main(String[] args) {
<<<<<<< HEAD
		 
		Random rand   = new Random();
	    System.out.println(((10.16406573*rand.nextGaussian())+206)/(720*3600));
		
    		
    		
    		
    		
//    		int famCount = 0;
//    		Random rand   = new Random();
//    		
//    		int a[] = new int[100];
//    		
//    		for(int i=0; i<100; i++) 
//    		{
//    			a[i] = rand.nextInt(100)+1;
//    			for(int j=0; j<i; j++)
//    			{
//    				if(a[i] == a[j])
//    				{
//    					i--;
//    				}
//    			}				
//    		}
//
//    		for (int b=0; b<100; b++)
//    		{
//    			//1명일때 
//    	        if(a[b] >=0 && a[b] <= 14) {
//    	        	famCount = 1;
//    	        }
//    	        //2명일때
//    	        else if (a[b] > 14 && a[b] <= 42){
//    	        	famCount = 2;
//    	        }
//    	        //3명일때
//    	        else if (a[b] > 42 && a[b] <= 66){
//    	        	famCount = 3;
//    	        }
//    	        //4명 일때
//    	        else if (a[b] > 66 && a[b] <= 90){
//    	        	famCount = 4;
//    	        }
//    	        //5명 일때
//    	        else if (a[b] > 90 && a[b] <= 96){
//    	        	famCount = 5;
//    	        }
//    	        //6명 일때
//    	        else if (a[b] == 97){
//    	        	famCount = 6;
//    	        }
//    	        //7명 일때
//    	        else if (a[b] == 98){
//    	        	famCount = 7;
//    	        }
//    	        //8명 일때
//    	        else if (a[b] == 99) {
//    	        	famCount = 8;
//    	        }
//    	        //9명 일때
//    	        else {
//    	        	famCount = 9;
//    	        }	 
//    		}
               
 	}
	
}
=======
		int famCount = 0;
		Random rand   = new Random();
		int a[] = new int[100];
		
		for(int i=0; i<100; i++) 
		{
			a[i] = rand.nextInt(100)+1;
			for(int j=0; j<i; j++)
			{
				if(a[i] == a[j])
				{
					i--;
				}
			}				
		}
		for (int b=0; b<100; b++)
		{		    
			//1명일때 
	        if(a[b] >=0 && a[b] <= 14) {
	        	famCount = 1;
	        }
	        //2명일때
	        else if (a[b] > 14 && a[b] <= 42){
	        	famCount = 2;
	        }
	        //3명일때
	        else if (a[b] > 42 && a[b] <= 66){
	        	famCount = 3;
	        }
	        //4명 일때
	        else if (a[b] > 66 && a[b] <= 90){
	        	famCount = 4;
	        }
	        //5명 일때
	        else if (a[b] > 90 && a[b] <= 96){
	        	famCount = 5;
	        }
	        //6명 일때
	        else if (a[b] == 97){
	        	famCount = 6;
	        }
	        //7명 일때
	        else if (a[b] == 98){
	        	famCount = 7;
	        }
	        //8명 일때
	        else if (a[b] == 99) {
	        	famCount = 8;
	        }
	        //9명 일때
	        else {
	        	famCount = 9;
	        }	 
		}
		System.out.println( famCount );
		}
	}
>>>>>>> 9e0b151a376803217fc285800e3cf968ba377cc7
