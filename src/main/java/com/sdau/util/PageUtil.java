package com.sdau.util;

import java.util.Map;

public class PageUtil {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void start(Map params) {
		
		if (params.containsKey("page") && params.containsKey("limit")) {

			int page = Integer.parseInt(params.get("page").toString());
			int limit = Integer.parseInt(params.get("limit").toString());
			int start = (page - 1) * limit;
		
			params.put("start",start);
		}
	}
}
