package bigdata;

import java.io.PrintWriter;


public class GenMeterLogThread extends Thread {
	String date;
	PrintWriter printWriter;
	MeterStatus meterStatus;

	public GenMeterLogThread( String date, String meterNum, String Macaddr, int Family, PrintWriter printWriter ) {
		this.date = date;
		this.printWriter = printWriter;
		meterStatus  = new MeterStatus( meterNum, Macaddr, Family );
	}

	@Override    
	public void run() {
		synchronized(printWriter){
			int count = 24 * 60 * 60;
			
<<<<<<< HEAD
		//	printWriter.println("Time"+",MeterNum"+",FamCount"+",MacAdd"+",Kwh");
=======
			printWriter.println("Time"+",MeterNum"+",FamCount"+",MacAdd"+",Kwh");
>>>>>>> 9e0b151a376803217fc285800e3cf968ba377cc7
	
			for(int i = 0; i <= count; i += 3600) { // 3600초 간격 1시간
				
				printWriter.println(
					date +
<<<<<<< HEAD
					getSecToTime(i)	          + "," + 
					meterStatus.getMeterNum() + "," + 
					//meterStatus.getFamily()   + "," + 
					meterStatus.getMacaddr()  + "," + 
=======
					getSecToTime(i)	          + "," + "\t" +
					meterStatus.getMeterNum() + "," + "\t" +
					meterStatus.getFamily()   + "," + "\t" +
					meterStatus.getMacaddr()  + "," + "\t" +
>>>>>>> 9e0b151a376803217fc285800e3cf968ba377cc7
					meterStatus.getKw(date)
					);
			}
		}
	}

	public String getSecToTime(int inSec) {

		String time = String.valueOf(inSec/3600);
	
		if(time.length() == 1){
			time = "0" + time;
		}
		String min = String.valueOf(inSec%3600/60);
		
		if(min.length() == 1){
			min = "0" + min;
		}
		
		String sec = String.valueOf(inSec%3600%60%60);
		if(sec.length() == 1){
			sec = "0" + sec;
		}

		return time + min + sec;
	}
}
