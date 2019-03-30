/**
 * 
 */
package com.tracker.controller;

/**
 * @author bujair
 *
 */
public class BaseController {
	
	public static final String SUCCESS = "SUCCESS";
	
	public long getLongFromString(String id) {
		try {
			return Long.parseLong(id);
		} catch (Exception e) {
			return 0;
		}
	}

}
