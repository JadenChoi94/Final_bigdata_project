package bigdata;

<<<<<<< HEAD
=======
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
>>>>>>> 9e0b151a376803217fc285800e3cf968ba377cc7
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import bigdata.GenMeterLogThread;
<<<<<<< HEAD
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
=======
>>>>>>> 9e0b151a376803217fc285800e3cf968ba377cc7

public class GenMeterLog {

	public static void main(String[] args) {
		
		PrintWriter printWriter = null;
		
		try {
			int meterCount = 100;
			String date =  new SimpleDateFormat( "yyyyMMdd" ).format( new Date( System.currentTimeMillis() ) );
	
<<<<<<< HEAD
//			if(args != null  && args.length > 1) {
//				date = args[0];
//			}
//			if(args != null && args.length > 1) {
//				meterCount = Integer.parseInt(args[1]);
//			}
			//D:\Bigdata_Project\Final_project\data
			//"/home/workspace/smartmeter/working/logs/hour/MeterStatus_" + date + ".log";
			
			String logFile = "/home/workspace/smartmeter/working/logs/hour/MeterStatus_" + date + ".log";
			printWriter = new PrintWriter( new FileWriter( logFile ), true );
			
			ArrayList<Thread> threads = new ArrayList<Thread>();			
			
			for(int i = 1; i <= meterCount; i++) {				
				Thread t = new GenMeterLogThread( date, genMeterId( i ), genMacAdd(), genFamily(i), printWriter );
=======
			if(args != null  && args.length > 1) {
				date = args[0];
			}
			if(args != null && args.length > 1) {
				meterCount = Integer.parseInt(args[1]);
			}
			
			String logFile = "/home/pilot-pjt/working/meter-realtime-log/MeterStatus_" + date + ".log";
			printWriter = new PrintWriter( new FileWriter( logFile ), true );
			
			ArrayList<Thread> threads = new ArrayList<Thread>();
			
			for(int i = 1; i <= meterCount; i++) {
				Thread t = new GenMeterLogThread( date, genMeterId( i ), genMacAdd(), genFamily(), printWriter );
>>>>>>> 9e0b151a376803217fc285800e3cf968ba377cc7
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
	
<<<<<<< HEAD
	
	
	public static int genFamily(int koo) {
		int[][] indat = new int[100][2];     
		int famNum = 0;
        try {
        	
            //jar로 만들기 전에 경로변경!!!
        	
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
        
=======
	public static int genFamily(){
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
	    return famCount;
	}
>>>>>>> 9e0b151a376803217fc285800e3cf968ba377cc7
	
	public static String genMeterId(int num) { 
		String prefixNum = ("H");
		DecimalFormat format = new DecimalFormat("000");
		String meterNum = format.format(num);

		return prefixNum + meterNum;
	}
	
	public static String genMacAdd() {
	    Random rand = new Random();
	    
	    byte[] macAddr = new byte[6];
	    rand.nextBytes(macAddr);

	    macAddr[0] = (byte)(macAddr[0] & (byte)254);  

	    StringBuilder sb = new StringBuilder(18);
	    for(byte b : macAddr){
	        if(sb.length() > 0)
	            sb.append(":");
	        sb.append(String.format("%02x", b));
	    }
	   
	    return sb.toString();
	}

}
