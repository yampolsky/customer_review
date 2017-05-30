package de.hybris.platform.customerreview.util;

import java.util.List;

public class StringUtils {
	
	public static boolean stringContainsItemFromList(String inputStr, List<String> items) {
	    return items.parallelStream().anyMatch(inputStr::contains);
	}
}
