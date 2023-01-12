package calendarandtime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFunctionality {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DateFunctionality df = new DateFunctionality();
//        String Result = df.getFutureDate(20); Example for 30 DAYS
//        System.out.println(Result);
//       
//        String Result2 = df.getFutureDate(30);
//        System.out.println(Result2);
        
        String Result3 = df.getFutureDate(60);//To add month name do MMMM (e.g. (60,"yyyyy.MMMMM.dd"))
        System.out.println(Result3);
        String DateArr[]= Result3.split("/");
        System.out.print(DateArr[0]);
        System.out.print(DateArr[1]);
        System.out.print(DateArr[2]);
	}
	
	
        
     public String getFutureDate(int NooFdays)
     
     {
    	 Calendar cal = Calendar.getInstance(); // (We are NOT able to create a an Object for the class like 
                                                // "Calendar cal = new calendar" because the method is static, the Class is abstract)
         cal.add(Calendar.DAY_OF_MONTH, NooFdays);

         Date d = cal.getTime();
         System.out.println("Current Date :" + d);

         SimpleDateFormat sdf = new SimpleDateFormat();  // To Create a Date format
         String defaultFormat = sdf.format(d);
         System.out.println(defaultFormat);


         sdf = new SimpleDateFormat("dd/MM/yyyy"); // diffrent Date format
         String FormattedDate = sdf.format(d);
         System.out.println(FormattedDate);
		 return FormattedDate;      
     }
     
     
     
        
	}


