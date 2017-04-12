package com.osdoctor.util.copy;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class TimeUntil {

	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public String getEarlyTime(String trueTime, String sqlTime) {
		try {
			if (!("").equals(trueTime)) {
				Date trueT = sdf.parse(trueTime);
				Date sqlT = sdf.parse(sqlTime);
				if (trueT.getTime() > sqlT.getTime()) {
					trueT = sqlT;
					trueTime = sdf.format(trueT);
				}
			} else {
				trueTime = sqlTime;
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trueTime;
	}

	public String getLateTime(String trueTime, String sqlTime) {
		try {
			if (!("").equals(trueTime)) {
				Date trueT = sdf.parse(trueTime);
				Date sqlT = sdf.parse(sqlTime);
				if (trueT.getTime() < sqlT.getTime()) {
					trueT = sqlT;
					trueTime = sdf.format(trueT);
				}
			} else {
				trueTime = sqlTime;
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trueTime;
	}

	public boolean getTime(String sqlTime, String trueTime) {
		boolean rs = true;
		try {
			if (!("").equals(trueTime) && !("").equals(sqlTime)) {
				Date trueT = sdf.parse(trueTime);
				Date sqlT = sdf.parse(sqlTime);
				if (trueT.getTime() < sqlT.getTime()) {
					rs = false;
				}
			} else {
				trueTime = sqlTime;
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	// 预计报酬=日均报酬*天数
	public String getPayNum(String trueDay, String pay) {
		try {
			Double getDay = Double.parseDouble(trueDay);
			Double getPay = Double.parseDouble(pay);
			getPay = getPay * getDay;
			pay = getPay.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pay;
	}

	public List<Map<String, Object>> getListmap(List<Map<String, Object>> listmap,
			String startime, String endtime) {
		int size = listmap.size();
		String s_startime = "";
		String s_endtime = "";
		TimeUntil tu = new TimeUntil();
		int day = 0;
		Double pay = 0.00;
		for (int i = 0; i < size; i++) {
			s_startime = listmap.get(i).get("start_time").toString()
					.substring(0, 10);
			s_endtime = listmap.get(i).get("end_time").toString()
					.substring(0, 10);
			if (!("").equals(startime) && ("").equals(endtime)) {

				if (tu.getTime(s_startime, startime)
						&& tu.getTime(startime, s_endtime)) {
					listmap.get(i).put("start_time", startime);
				}
				if ((tu.getTime(s_endtime, startime))) {
					listmap.remove(i);
					i = i - 1;
					size = size - 1;
				}
			}
			if (("").equals(startime) && !("").equals(endtime)) {

				if (tu.getTime(s_startime, endtime)
						&& tu.getTime(endtime, s_endtime)) {
					listmap.get(i).put("end_time", endtime);
				}
				if ((tu.getTime(endtime, s_startime))) {
					listmap.remove(i);
					i = i - 1;
					size = size - 1;
				}
			}
			if (!("").equals(startime) && !("").equals(endtime)) {
				if ((tu.getTime(s_startime, endtime) && tu.getTime(endtime,
						s_endtime))) {
					listmap.get(i).put("end_time", endtime);
				}
				if ((tu.getTime(s_startime, startime) && tu.getTime(startime,
						s_endtime))) {
					listmap.get(i).put("start_time", startime);
				}
				if (tu.getTime(s_endtime, startime)) {
					listmap.remove(i);
					i = i - 1;
					size = size - 1;
				}
				if (tu.getTime(endtime, s_startime)) {
					listmap.remove(i);
					i = i - 1;
					size = size - 1;
				}
			}

		}
		if (!(("").equals(startime) && ("").equals(endtime))) {
			for (int i = 0; i < listmap.size(); i++) {
				s_startime = listmap.get(i).get("start_time").toString()
						.substring(0, 10);
				s_endtime = listmap.get(i).get("end_time").toString()
						.substring(0, 10);
				day = tu.getDay(s_startime, s_endtime);
				pay = Double.parseDouble(listmap.get(i).get("pay").toString());
				pay = pay * day;
				BigDecimal b = new BigDecimal(pay);
				pay = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				listmap.get(i).put("paysum", pay);
			}
		}
		return listmap;

	}

	public int getDay(String strTime1, String strTime2) {
		Date date1;
		Date date2;
		int dateDiff = -1;
		try {
			if (!("").equals(strTime1) && !("").equals(strTime2)) {
				date1 = sdf.parse(strTime1);
				date2 = sdf.parse(strTime2);

				Calendar cal1 = Calendar.getInstance();
				Calendar cal2 = Calendar.getInstance();
				cal1.setTime(date1);
				cal2.setTime(date2);
				long ldate1 = date1.getTime() + cal1.get(15) + cal1.get(16);
				long ldate2 = date2.getTime() + cal2.get(15) + cal2.get(16);
				int hr1 = (int) (ldate1 / 3600000L);
				int hr2 = (int) (ldate2 / 3600000L);

				int days1 = hr1 / 24;
				int days2 = hr2 / 24;

				dateDiff = Math.abs(days1 - days2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateDiff;
	}

	// 计算时间差（非绝对值）
	public int getDays(String strTime1, String strTime2) {
		Date date1;
		Date date2;
		int dateDiff = 0;
		try {
			if (!("").equals(strTime1) && !("").equals(strTime2)) {
				date1 = sdf.parse(strTime1);
				date2 = sdf.parse(strTime2);

				Calendar cal1 = Calendar.getInstance();
				Calendar cal2 = Calendar.getInstance();
				cal1.setTime(date1);
				cal2.setTime(date2);
				long ldate1 = date1.getTime() + cal1.get(15) + cal1.get(16);
				long ldate2 = date2.getTime() + cal2.get(15) + cal2.get(16);
				int hr1 = (int) (ldate1 / 3600000L);
				int hr2 = (int) (ldate2 / 3600000L);

				int days1 = hr1 / 24;
				int days2 = hr2 / 24;

				dateDiff = days1 - days2;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateDiff;
	}
}
