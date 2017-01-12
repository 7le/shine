package com.shine.service;


import com.shine.dao.model.DictCategory;
import com.shine.dao.model.Dictionary;

import java.util.List;
import java.util.Map;

public interface DictionaryService {

	Dictionary getById(Integer id);

	List<DictCategory> getByAllDicts();

	List<Dictionary> getDataByDictId(Integer dictId);

	String getDictValueByKey(String code, String key);

	Map<String, String> getDictionary(String code);
	
	int deleteById(Integer id);
	
	int insert(Dictionary object);

	List<Dictionary> getByAll();

	void update(Dictionary dict);
}
