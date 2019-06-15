package org.dimigo.gui.Stack;


import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class RealTime {

        private Calendar cal = Calendar.getInstance ( Locale.KOREA );
        public String giveTime(){
            return ( cal.get ( Calendar.MONTH ) + 1 ) + "월 " + cal.get ( Calendar.DATE ) + "일 " + cal.get ( Calendar.HOUR_OF_DAY ) + "시 " + cal.get ( Calendar.MINUTE ) + "분 ";
        };
       // System.out.println (  ( cal.get ( Calendar.MONTH ) + 1 ) + "월 " + cal.get ( Calendar.DATE ) + "일 " + cal.get ( Calendar.HOUR_OF_DAY ) + "시 " + cal.get ( Calendar.MINUTE ) + "분 "  );





}
