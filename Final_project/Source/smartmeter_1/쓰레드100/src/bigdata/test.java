package bigdata;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.io.*;
import java.lang.reflect.Array;
import java.io.*;
import java.util.*;

	public class test {
	
		public static void main(String[] args) {	

			Random rand   = new Random();
			System.out.println ( ((10.16406573*rand.nextGaussian())+206)/720 );
			
			
			SimpleDateFormat sdf = new SimpleDateFormat ( "yyyyMMdd" );
			Calendar c = Calendar.getInstance ( );
			String[] thedate = new String[1826];

			for ( int k = 0; k < 1826; k++ ){
				c.clear ( );
				c.set ( 2014, 0, 1 + ( k * 1 ) );
				java.util.Date d = c.getTime ( );				
				thedate[k] = sdf.format ( d );	
				String datedate = thedate[k];
			}
		} 
}
		
	
