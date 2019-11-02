package bigdata;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.*;
import java.util.*;
import java.text.*;


public class RealMeterLog {

	public static void main(String[] args) {
		PrintWriter printWriter = null;
					
			try {
					int MeterCount = 100;
					String date = new SimpleDateFormat( "yyyyMMdd" ).format( new Date( System.currentTimeMillis() ) );
									
			
					///home/workspace/smartmeter/working/logs/sec	
					//D:/Bigdata_Project/Final_project/data
					
					String logFile = "/home/workspace/smartmeter/working/logs/sec/MeterMin_" + date + ".log";
					printWriter = new PrintWriter( new FileWriter( logFile ), true );
					String datedate = "";
					ArrayList<Thread> threads = new ArrayList<Thread>();
					
					for(int i = 1; i <= MeterCount; i++) {
							
						
						Thread t =  new RealMeterLogThread( datedate, genMeterId( i ), genMacAdd(i), genFamily(i), printWriter );
						t.start();
				        threads.add(t);
						}
					for(Thread thread : threads){
						thread.join();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if( printWriter != null ) {
						printWriter.close();
						System.out.println( "finished" );
					}
				}
	}

	
	public static int randomRange(int n1, int n2) {
		return (int)((Math.random() * (n2 - n1 + 1)) + n1);
	}

	
	public static int genFamily(int koo) {
		int[][] indat = new int[100][2];     
		int famNum = 0;
        try {
            ///home/workspace/smartmeter/working
            File csv = new File("/home/workspace/smartmeter/working/domain.csv");
            BufferedReader br = new BufferedReader(new FileReader(csv));
            String line = "";
            int row =0 ,i; 
            while ((line = br.readLine()) != null) {
            	
                String[] token = line.split(",", -1);
                for(i=1;i<2;i++)    indat[row][i] = Integer.parseInt(token[i]);                               
                row++;
            }
            br.close(); 
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        famNum = indat[koo-1][1];  
        
	    return famNum;       
	}
	
        
	
	public static String genMeterId(int num) { 
		String prefixNum = ("H");
		DecimalFormat format = new DecimalFormat("000");
		String meterNum = format.format(num);

		return prefixNum + meterNum;
	}
	
	public static String genMacAdd(int goo) {
		
		String[][] indat = new String[100][3];     
		String Macadd;
        try {
        	
            File csv = new File("/home/workspace/smartmeter/working/domain.csv");
            BufferedReader br = new BufferedReader(new FileReader(csv));
            String line = "";
            int row =0 ,i; 
            while ((line = br.readLine()) != null) {
            	
                String[] token = line.split(",", -1);
                for(i=1;i<3;i++)    indat[row][i] = (token[i]);                               
                row++;
            }
            br.close(); 
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        Macadd = indat[goo-1][2];  
        
	    return Macadd;
	}
	
//	    Random rand = new Random();2
//	    
//	    byte[] macAddr = new byte[6];
//	    rand.nextBytes(macAddr);
//
//	    macAddr[0] = (byte)(macAddr[0] & (byte)254);  
//
//	    StringBuilder sb = new StringBuilder(18);
//	    for(byte b : macAddr){
//	        if(sb.length() > 0)
//	            sb.append(":");
//	        sb.append(String.format("%02x", b));
//	    }
//	   
//	    return sb.toString();


}
