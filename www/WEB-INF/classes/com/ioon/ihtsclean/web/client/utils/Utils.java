package com.ioon.ihtsclean.web.client.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.ListBox;
import com.ioon.ihtsclean.web.client.AppConstants;
import com.ioon.ihtsclean.web.client.i18n.userMessages.AppMessages;
import com.ioon.ihtscommon.common.constants.Errors;

//Helper class
public class Utils {
	
	static AppConstants constants = GWT.create(AppConstants.class);
	static AppMessages messages = GWT.create(AppMessages.class);
	
	
	public static String getMessageFromErrorCode(String errorCode) {
		String result = messages.generalError();
		
		if (isEmpty(errorCode)) {
			result = messages.generalError();
			
		} else if (errorCode.equalsIgnoreCase(Errors.AUTH.getCode()) &&
			errorCode.equalsIgnoreCase(Errors.AUTH_INTERNAL_ERROR.getCode()) &&
			errorCode.equalsIgnoreCase(Errors.AUTH_TOKEN_UNKNOWN.getCode()) &&
			errorCode.equalsIgnoreCase(Errors.AUTH_TOKEN_EMPTY.getCode()) &&
			errorCode.equalsIgnoreCase(Errors.AUTH_NOT_CREDENTIALS.getCode())) {
			
			result = messages.generalError();
			
		} else if (errorCode.equalsIgnoreCase(Errors.AUTH_USER_NOT_FOUND.getCode())) {
			
			result = messages.invalidUserPassword();
			
		} else if (errorCode.equalsIgnoreCase(Errors.AUTH_USER_DISABLED.getCode())) {
			
			result = messages.disabledUser();
		}
		
		return result;
	}
	
	public static void setIdList(ListBox list, String id) {
		for (int i = 0; i < list.getItemCount(); i++) {
			if (list.getValue(i).equals(id)) {
				list.setSelectedIndex(i);
				break;
			}
		}
	}

	public static String encodeTextJson(String stringToEncode) {
		String result = "";
		for (int x = 0; x < stringToEncode.length(); x++) {
			if (stringToEncode.charAt(x) == '\n') {
				result += "\\n";
			} else if (stringToEncode.charAt(x) == '"') {
				result += "\\\"";
			} else {
				result += stringToEncode.charAt(x);
			}
		}

		return result;
	}
	
	public static String encodeTextForHtml(String stringToEncode) {
		String result = "";
		for (int x = 0; x < stringToEncode.length(); x++) {
			if (stringToEncode.charAt(x) == '\n') {
				result += "<br/>";
			} else {
				result += stringToEncode.charAt(x);
			}
		}

		return result;
	}

	public static boolean exitsStringInString(String toSearch, String string) {
		return string.lastIndexOf(toSearch) != -1;
	}

	public static boolean isEmpty(String in) {
		return in == null || in.trim().isEmpty();
	}

	public static String getFilename(String in) {
		String filename = in.trim();

		if (filename.lastIndexOf('/') != -1) {
			filename = filename.substring(in.lastIndexOf('/') + 1);
		} else if (filename.lastIndexOf('\\') != -1) {
			filename = filename.substring(in.lastIndexOf('\\') + 1);
		}

		return filename;
	}

	public static boolean onlyAlfachar(String in) {
		boolean result = true;

		if (in != null) {
			String string = getFilename(in);

			for (int i = 0; i < string.length(); i++) {
				if (constants.alfaChar().lastIndexOf(string.charAt(i)) == -1) {
					result = false;
					break;
				}
			}
		}

		return result;
	}

	public static String getFullName(String name, String surname1,
			String surname2) {
		String nameTmp = name != null ? name : "";
		String surname1Tmp = surname1 != null ? surname1 : "";
		String surname2Tmp = surname2 != null ? surname2 : "";

		return surname1Tmp + " " + surname2Tmp + ", " + nameTmp;
	}
	
	public static String getBoleanValueToJson(boolean value) {
		String result = "false";

		if (value) {
			result = "true";
		}

		return result;
	}
	
	public static int getIntValueToJson(boolean value) {
		int result = 0;

		if (value) {
			result = 1;
		}

		return result;
	}
	
	public static boolean getBooleanValueFromJson(int value) {
		boolean result = false;

		if (value==1) {
			result = true;
		}

		return result;
	}
	
	public static String getBooleanValueToUser(boolean value) {
		String result = "NO";

		if (value) {
			result = "SI";
		}

		return result;
	}
	
	public static boolean getBooleanValueFromUser(String value) {
		boolean result = false;

		if (value.equalsIgnoreCase("SI")) {
			result = true;
		}

		return result;
	}
	
	public static String getArrayValueToJson(int[] array) {
		String result = "";

		if (array!=null) {
			for (int i=0; i<array.length; i++) {
				result += array[i]+" ";
			}
		}

		return result.trim();
	}
	
	public static String getArrayValueToUser(int[] array) {
		String result = "- ";

		if (array!=null) {
			for (int i=0; i<array.length; i++) {
				result += array[i]+" - ";
			}
		}

		return result.trim();
	}
	
	public static boolean isValueInArray(int[] array, int value) {
		boolean result = false;

		if (array!=null) {
			for (int i=0; i<array.length; i++) {
				if (array[i]==value) {
					result = true;
					break;
				}
			}
		}

		return result;
	}
	
	public static String getValueOptionalParameter(String value) {
		String result = value;
		
		if (value==null) {
			result = "";
		}
		
		return result;
	}

	// DATE FORMAT YYYY-DD-MM
	public static Date stringToDate(String date) throws Exception {
		Date result = null;

		if (date != null && !date.equalsIgnoreCase("")) {
			result = DateTimeFormat.getFormat("yyyy-MM-dd").parse(
					date.substring(0, 10));
		}

		return result;
	}
	
	// DATE FORMAT DD-MM-YYYY
	public static Date stringToDateFromUser(String date) throws Exception {
		Date result = null;

		if (date != null && !date.equalsIgnoreCase("")) {
			result = DateTimeFormat.getFormat("dd-MM-yyyy").parse(
					date.substring(0, 10));
		}

		return result;
	}
	
	// DATE FORMAT YYYY-MM-DD HH:mm:ss
	public static Date stringToDateWithHour(String date) throws Exception {
		Date result = null;

		if (date != null && !date.equalsIgnoreCase("")) {
			result = DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss").parse(
					date.substring(0, 19));
		}

		return result;
	}
	
	public static String dateToString(Date date) throws Exception {
		String result = "";

		if (date != null) {
			result = DateTimeFormat.getFormat("yyyy").format(date) + "-"
					+ DateTimeFormat.getFormat("MM").format(date) + "-"
					+ DateTimeFormat.getFormat("dd").format(date);
		}

		return result;
	}
	
	public static String dateToReport(Date date) throws Exception {
		String result = "";

		if (date != null) {
			result = DateTimeFormat.getFormat("yyyy").format(date) + "-"
					+ DateTimeFormat.getFormat("dd").format(date) + "-"
					+ DateTimeFormat.getFormat("MM").format(date);
		}

		return result;
	}

	public static String dateToStringForUser(Date date) throws Exception {
		String result = "";

		if (date != null) {
			result = DateTimeFormat.getFormat("dd").format(date) + "-"
					+ DateTimeFormat.getFormat("MM").format(date) + "-"
					+ DateTimeFormat.getFormat("yyyy").format(date);
		}

		return result;
	}
	
	public static String dateToStringForUserWithHour(Date date) throws Exception {
		String result = "";

		if (date != null) {
			result = DateTimeFormat.getFormat("dd").format(date) + "-"
					+ DateTimeFormat.getFormat("MM").format(date) + "-"
					+ DateTimeFormat.getFormat("yyyy").format(date) + " "
					+ DateTimeFormat.getFormat("HH").format(date) + ":"
					+ DateTimeFormat.getFormat("mm").format(date);
		}

		return result;
	}

	public static String dateToTimestamp(Date date) throws Exception {
		String result = "";

		if (date != null) {
			result = DateTimeFormat.getFormat("yyyy").format(date) + "-"
					+ DateTimeFormat.getFormat("MM").format(date) + "-"
					+ DateTimeFormat.getFormat("dd").format(date) + " 00:00:00";
		}

		return result;
	}
	
	public static String dateToTimestampWithHour(Date date) throws Exception {
		String result = "";

		if (date != null) {
			result = DateTimeFormat.getFormat("yyyy").format(date) + "-"
					+ DateTimeFormat.getFormat("MM").format(date) + "-"
					+ DateTimeFormat.getFormat("dd").format(date) + " "
					+ DateTimeFormat.getFormat("HH").format(date) + ":"
					+ DateTimeFormat.getFormat("mm").format(date) + ":"
					+ DateTimeFormat.getFormat("ss").format(date);
		}

		return result;
	}
	
	public static boolean isDateAfterDays(Date date, int days) throws Exception{
		boolean result = false;
		
		long timeStampDate = date.getTime();
		long daysBefore = Long.parseLong(String.valueOf(days)) * Long.parseLong("24") * Long.parseLong("60") * Long.parseLong("60") * Long.parseLong("1000");
		long timeStamp = new Date().getTime() - daysBefore;
		
		if ((timeStampDate - timeStamp) < 0) {
			result = true;
		}
		
		return result;
	}
	
	public static boolean isDateBeforeDays(Date date, int days) throws Exception{
		boolean result = false;
		
		long timeStampDate = date.getTime();
		long daysAfter = Long.parseLong(String.valueOf(days)) * Long.parseLong("24") * Long.parseLong("60") * Long.parseLong("60") * Long.parseLong("1000");
		long timeStamp = new Date().getTime() + daysAfter;
		
		if ((timeStampDate - timeStamp) < 0) {
			result = true;
		}
		
		return result;
	}
			
	public static List<Integer> getListFromArray(int[] array) {
		List<Integer> result = new ArrayList<Integer>();
		
		for (int i=0; i<array.length; i++) {
			result.add(array[i]);
		}
		
		return result;
	}
	
	public static int[] getArrayFromList(List<Integer> list) {
		int[] array = new int[list.size()];
		
		for (int i=0; i<list.size(); i++) {
			array[i] = list.get(i).intValue();
		}
		
		return array;
	}	
}
