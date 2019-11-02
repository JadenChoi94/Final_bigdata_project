package bigdata;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SecMeterLogThread extends Thread{
	String datedate;
	PrintWriter printWriter;
	SecMeterLogStatus secMeterLogStatus;

	public SecMeterLogThread( String datedate, String meterNum, String Macaddr, int Family, PrintWriter printWriter ) {
		this.datedate = datedate;
		this.printWriter = printWriter;
		secMeterLogStatus  = new SecMeterLogStatus( meterNum, Macaddr, Family);
	}

	@Override    
	public void run() {
		synchronized(printWriter){
			int count = (24 * 60 * 60); //시, 분, 초
			Calendar c = Calendar.getInstance ( );
			String[] thedate = new String[8];
			SimpleDateFormat sdf = new SimpleDateFormat ( "yyyyMMdd" );
			
			for ( int k = 0; k < 8; k++ )
			{
				c.clear ( );
				c.set ( 2019, 7, 1 + ( k * 1 ) );
				java.util.Date d = c.getTime ( );				
				thedate[k] = sdf.format ( d );	
				String datedate = thedate[k];
				
				for(int i = 0; i <= count; i += 1) { // 1초마다
					
					printWriter.println(
						datedate +
						getSecToTime(i)	          + "," + 
						secMeterLogStatus.getMeterNum() + "," + 
						//secMeterLogStatus.getFamily()   + "," + 
						secMeterLogStatus.getMacaddr()  + "," + 
						secMeterLogStatus.getKw(datedate)
						);
				}
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
