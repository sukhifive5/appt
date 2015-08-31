package com.appt.common.utils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.util.StringUtils;

public class DataUtils {

	public static HashMap resultSetToHashMap(ResultSet rs) throws SQLException
	{
		  ResultSetMetaData md = rs.getMetaData();
		  int columns = md.getColumnCount();
		  HashMap row = new HashMap();
		  while (rs.next()){
		     for(int i=1; i<=columns; i++){
		       row.put(md.getColumnName(i),rs.getObject(i));
		     }
		  }
		 return row;
	}
	
	
	public static Long getLongFromMap(Map map, String key) throws NumberFormatException
	{
		Object obj = map.get(key);
		if (obj != null)	
		{
			if (obj instanceof Number)
			{
				Number num = (Number) obj;
				return num.longValue();
			}
			else if (obj instanceof String)
			{
				return Long.parseLong((String) obj);
			}
		}
		return null;
	}
	
	
	public static DateTime getDateTimeFromMap(Map map, String key) throws NumberFormatException
	{
		Object obj = map.get(key);
		if (obj != null)	
		{
			if (obj instanceof Date)
			{
				Date dt = (Date) obj;
				return new DateTime(dt);
			}
		}
		return null;
	}
	
	public static String getStringFromMap(Map map, String key) throws NumberFormatException
	{
		Object obj = map.get(key);
		if (obj != null)	
		{
			if (obj instanceof String)
			{
				String str = (String) obj;
				if (StringUtils.hasLength(str))
					return str;
			}
		}
		return null;
	}
	
	/**
	 * Compares two long includes if both are null for equality
	 * @param long1
	 * @param long2
	 * @return true/false
	 */
	public static boolean areLongValEqual(Long long1, Long long2)
	{
		// if both are null, return true
		if (long1 == null && long2 == null)
			return true;
		// if both are not null, and equal return true
		else if ((long1 != null && long2 != null) && (long1.equals(long2)))
			return true;
		// else return false
		else
			return false;
	}
	
	/**
	 * Compares two String includes if both are null for equality
	 * @param str1
	 * @param str2
	 * @return true/false
	 */
	public static boolean areStringValEqual(String str1, String str2)
	{
		// if both are null, return true
		if (str1 == null && str2 == null)
			return true;
		// if both are not null, and equal return true
		else if ((str1 != null && str2 != null) &&
				(str1.trim().equalsIgnoreCase(str2.trim())))
			return true;
		// else return false
		else
			return false;
	}
	
	/**
	 * Compares two DateTime includes if both are null for equality
	 * @param dt1
	 * @param dt2
	 * @return true/false
	 */
	public static boolean areDateTimeValEqual(DateTime dt1, DateTime dt2)
	{
		// if both are null, return true
		if (dt1 == null && dt2 == null)
			return true;
		// if both are not null, and equal return true
		else if ((dt1 != null && dt2 != null) &&
				(dt1.equals(dt2)))
			return true;
		// else return false
		else
			return false;
	}
}
