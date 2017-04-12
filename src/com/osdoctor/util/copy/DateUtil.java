package com.osdoctor.util.copy;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {
	
	/**
	 * 以一定的格式获得字符串类型日�?
	 * @param date
	 * @param format
	 * @return
	 */
	public static String getDateTime(Date date,String format){
		if(format == null || format.equals("")){
			format = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
	/**
	 * 以一定的格式获得字日期类型日�?
	 * @param date
	 * @param format
	 * @return
	 */
	public static Date getDateTime(String date,String format){
		if(format == null || format.equals("")){
			format = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date formatDate = null;
		try {
			formatDate = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return formatDate;
	}
	
	public static Integer isLateOrIsEarly(String date,String compareDate){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat resultsdf = new SimpleDateFormat("HH:mm:ss");
		Date formateDate = null;
		String tempDate = "";
		String resultDate = "";
		try {
			formateDate = sdf.parse(date);
			tempDate = sdf.format(formateDate);
			resultDate = tempDate.substring(11);
			if(resultsdf.parse(resultDate).getTime() < resultsdf.parse(compareDate).getTime()){
				return 1;
			}else{
				return 2;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 将短时间格式字符串转换为时间 yyyy-MM-dd
	 * 
	 * @param strDate
	 * @return
	 */
	public static Date strToDate(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}
	
	/**
	 * 判断是否润年
	 * 
	 * @param ddate
	 * @return
	 */
	public static boolean isLeapYear(String ddate) {
		/**
		 * 详细设计�?1.�?00整除是闰年，否则�?2.不能�?整除则不是闰�?3.能被4整除同时不能�?00整除则是闰年
		 * 3.能被4整除同时能被100整除则不是闰�?
		 */
		Date d = strToDate(ddate);
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(d);
		int year = gc.get(Calendar.YEAR);
		if ((year % 400) == 0)
			return true;
		else if ((year % 4) == 0) {
			if ((year % 100) == 0)
				return false;
			else
				return true;
		} else
			return false;
	}
	
	/**
	 * 获取�?��月的�?���?��
	 * 
	 * @param dat
	 * @return
	 */
	public static int getEndDateOfMonth(String dat) {// yyyy-MM-dd
		String month = dat.substring(5, 7);
		int mon = Integer.parseInt(month);
		if (mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8
				|| mon == 10 || mon == 12) {
			return 31;
		} else if (mon == 4 || mon == 6 || mon == 9 || mon == 11) {
			return 30;
		} else {
			if (isLeapYear(dat)) {
				return 29;
			} else {
				return 28;
			}
		}
	}
	
	public static String buling(Integer day){
		if(Integer.valueOf(day) < 10)
			return "0"+day;
		return day.toString();
	}
	
	public static String[] getAMonthDay(String start){
		String month = start.substring(0,8);
		int num = getEndDateOfMonth(start);
		String[] months = new String[num];
		for(Integer i=0;i<num;i++){
			months[i] = month+buling(i+1);
		}
		return months;
	}
	
	/**
	 * 获取n天前（后）日�?
	 * @param day
	 * @return
	 */
	public static String getDate(Integer day){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, day);
		String date = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
		return date;
	}
	
	//获取初期时间
	public static String getInitialDate(){
		return getDateTime(new Date(), "yyyy")+"00";
	}
	
	public static String getInitialDate(String reportDate){
		if(reportDate != null && reportDate.length() > 4)
			return reportDate.substring(0, 4)+"00";
		return getInitialDate();
	}
	
	public static void main(String[] args) {
		System.out.println(getFirstMonthOfYear());
	}

	public static String getRecent3Years(String date){
		if(date == null || date.equals("")){
			return date;
		}
		return String.valueOf(Integer.valueOf(date.substring(0,4))-3)+date.substring(4);
	}
	
	public static String[] getSeasonStartEnd(String season){
		if(season == null || season.equals("")){
			return null;
		}
		String[] str = new String[2];
		String year = season.substring(0,4);
		String month = season.substring(4);
		if(month.equals("Q1")){
			str[0] = year+"-01-01";
			str[1] = year+"-03-31";
		}else if(month.equals("Q2")){
			str[0] = year+"-04-01";
			str[1] = year+"-06-30";
		}else if(month.equals("Q3")){
			str[0] = year+"-07-01";
			str[1] = year+"-09-30";
		}else if(month.equals("Q4")){
			str[0] = year+"-10-01";
			str[1] = year+"-12-31";
		}else
			return null;
		return str;
	}
	
	public static String getFirstMonthOfYear() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int year = calendar.get(Calendar.YEAR);
        return year+"01";
	}
	
}
