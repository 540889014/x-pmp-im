package com.jd.x.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONObject;

public class StringUtil {

	private static MessageDigest digest = null;

	public static String getRandom() {
		Random random = new Random();
		return String.valueOf(100000 + random.nextInt(899999));
	}

	public static String converString(Object str) {
		if (str == null)
			return "";
		return str.toString();
	}

	public static Integer converInteger(Object str) {
		if (str == null || "".equals(str))
			return 0;
		return Integer.valueOf(str.toString());
	}

	public static Double converDouble(Map<String, Object> map,String key) {
		if (map == null)
			return 0.0;
		if (map.containsKey(key)){
			Object obj = map.get(key);
			if(obj == null)
				return 0.0;
			return Double.valueOf(obj.toString());
		}
		return 0.0;
	}
	
	public static Double converDouble(Object str) {
		if (str == null || "".equals(str)) {
			return 0.0;
		}
		return Double.valueOf(str.toString());
	}
	
	public static Double converDoubleOrNull(Object str) {
		if (str == null || "".equals(str)) {
			return null;
		}
		return Double.valueOf(str.toString());
	}
	
	public static Float converFloat(Object str) {
		if (str == null || "".equals(str))
			return 0f;
		return Float.valueOf(str.toString());
	}

	public static Long converLong(Object str) {
		if (str == null || "".equals(str))
			return 0l;
		return Long.valueOf(str.toString());
	}

	public static Date converDate(Object str) {
		if (str == null)
			return parseDate("2000-01-01 00:00:00", "yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return parseDate(sdf.format(str), "yyyy-MM-dd HH:mm:ss");
	}

	public static String date2String(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	public static Date parseDate(String source) {
		String format = "yyyy-MM-dd HH:mm:ss";
		return parseDate(source, format);
	}

	public static Date parseDate(String source, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(source);
		} catch (Exception e) {
			return null;
		}
	}

	public static final synchronized String hash(String data) {
		if (digest == null)
			try {
				digest = MessageDigest.getInstance("MD5");
			} catch (Exception e) {}
	    try {
			digest.update(data.getBytes("utf-8"));
		} catch (Exception e) {}
		return encodeHex(digest.digest());
	}
	
	public static final String encodeHex(byte bytes[])
    {
        StringBuffer buf = new StringBuffer(bytes.length * 2);
        for(int i = 0; i < bytes.length; i++)
        {
            if((bytes[i] & 0xff) < 16)
                buf.append("0");
            buf.append(Long.toString(bytes[i] & 0xff, 16));
        }

        return buf.toString();
    }
	
	public static double DoubleAdd(double dou1, double dou2) {
		return new BigDecimal(Double.toString(dou1)).add(
				new BigDecimal(Double.toString(dou2))).doubleValue();
	}

	public static double DoubleSubtract(double dou1, double dou2) {
		return new BigDecimal(Double.toString(dou1)).subtract(
				new BigDecimal(Double.toString(dou2))).doubleValue();
	}
	
	public static double DoubleDivide(double dou1, double dou2) {
		if(dou1 == 0.0 || dou2 == 0.0)
			return 0.0;
		MathContext mc = new MathContext(2, RoundingMode.HALF_DOWN);
		return new BigDecimal(Double.toString(dou1)).divide(
				new BigDecimal(Double.toString(dou2)),mc).doubleValue();
	}
	
	 public static double DoubleMultiply(double d1,double d2){ 
		 MathContext mc = new MathContext(2, RoundingMode.HALF_DOWN);
	     return new BigDecimal(Double.toString(d1)).multiply(new BigDecimal(Double.toString(d2)),mc).doubleValue(); 
	 } 
	
	public static String getKilometer(String num){
		DecimalFormat df = new DecimalFormat("##.#");
		double temp = Double.parseDouble(num);
		double m = 1000;
        double result = temp/m;		
		return df.format(result);
	}
	
	public static boolean contains(String[] array, String source) {
		List<String> tempList = Arrays.asList(array);
		if (tempList.contains(source)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static String getCollectionnum(){
		Random random = new Random();
		int x = random.nextInt(89999999)+10000000;
		return "us"+x;
	}
	
	public static String getActivityCollectionNum(String code){
		Random random = new Random();
		int x = random.nextInt(89999999)+10000000;
		return code+x;
	}
	
	public static String getNumberFromString(String str) {
		String regEx="[^0-9]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.replaceAll("");
	}
	
	public static String formatNumber(double d) {
		DecimalFormat fmt = new DecimalFormat("##,###,###,###,##0.00");
		return fmt.format(d);
	}
	
	public static long getRandomNum() {
		StringBuffer sb = new StringBuffer();
		int r[] = new int[10];
		for (int i=0 ; i<r.length ; i++) {
			r[i] = (int)(10*(Math.random()));
			sb.append(r[i]);
		}
		long x = Long.valueOf(sb.toString());
		if (x < 1000000000l) {
			x = Long.valueOf((int)(1+Math.random()*9)+sb.toString());
		}
		return x;
	}
	
	public static String filterSymbol(String str){
		return str.replaceAll("[\\pP‘’“”\\p{Space}]", "");
	}
	
	public static String Json(boolean issuccess,String errorinfo) {
		JSONObject json = new JSONObject();
		json.put("success", issuccess);
		json.put("msg",errorinfo);
		return json.toString();
	}
	
	public static String getEmptyGrid() {
		JSONObject json = new JSONObject();
		json.put("total", 0);
		json.put("rows", "");
		return json.toString();
	}
	
	private static boolean isMatch(String regex, String orginal){
        if (orginal == null || orginal.trim().equals("")) {
            return false;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher isNum = pattern.matcher(orginal);
        return isNum.matches();
    }
  
    public static boolean isPositiveInteger(String orginal) {
        return isMatch("^\\+{0,1}[1-9]\\d*", orginal);
    }
    
    public static boolean isNegativeInteger(String orginal) {
        return isMatch("^-[1-9]\\d*", orginal);
    }
	
	public static boolean isWholeNumber(String orginal) {
        return isMatch("[+-]{0,1}0", orginal) || isPositiveInteger(orginal) || isNegativeInteger(orginal);
    }
	
	public static boolean isDecimal(String orginal){
        return isMatch("[-+]{0,1}\\d+\\.\\d*|[-+]{0,1}\\d*\\.\\d+", orginal);
    }
	
	public static boolean isRealNumber(String orginal){
        return isWholeNumber(orginal) || isDecimal(orginal);
    }

	public static void main(String[] args) {
		System.out.println(isRealNumber("234234234234.00"));
	}
	
}
