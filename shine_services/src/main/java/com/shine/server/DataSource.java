package com.shine.server;

import com.shine.dao.model.Dictionary;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DataSource {
	@SuppressWarnings("unchecked")
	public static Map<String,List<Dictionary>> dictionaries = new HashMap();
}
