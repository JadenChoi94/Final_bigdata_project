package bigdata;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.*;
import java.lang.reflect.Array;
import java.io.*;
import java.util.*;
import java.util.Random;

	public class test {
	
		public static void main(String[] args) {	
			 
			SimpleDateFormat sdf = new SimpleDateFormat ( "yyyyMMdd" );
			Calendar c = Calendar.getInstance ( );
			String[] thedate = new String[1461];
			
			for ( int i = 0; i < 1461; i++ )
			{
			c.clear ( );
			c.set ( 2015, 0, 1 + ( i * 1 ) );
			java.util.Date d = c.getTime ( );
			thedate[i] = sdf.format ( d );
			
			
			
			System.out.println ( thedate[i] );
			} 
	}
}
		
	
