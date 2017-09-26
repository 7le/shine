package com.shine.service.impl;


import com.shine.dao.DictCategoryMapper;
import com.shine.dao.DictionaryMapper;
import com.shine.dao.model.DictCategory;
import com.shine.dao.model.Dictionary;
import com.shine.server.DataSource;
import com.shine.service.DictionaryService;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class DictionaryServiceImpl implements DictionaryService {

	@Resource
	private DictionaryMapper dictionaryMapper;
	@Resource
	private DictCategoryMapper dictCategoryMapper;

	public Dictionary getById(Integer id) {
		return (Dictionary) dictionaryMapper.selectByPrimaryKey(id);
	}

	public List<Dictionary> getByAll() {
		return dictionaryMapper.getByAll();
	}

	public int insert(Dictionary object) {
		return dictionaryMapper.insert(object);
	}

	public int deleteById(Integer id) {
		return dictionaryMapper.deleteByPrimaryKey(id);
	}

	public List<DictCategory> getByAllDicts() {
		return dictCategoryMapper.getByAllDicts();
	}

	public List<Dictionary> getDataByDictId(Integer dictId) {
		return dictionaryMapper.getDataByDictId(dictId);
	}

	public String getDictValueByKey(String code, String key) {
		if (key == null || key.length() == 0) {
			return "";
		}
		
		List<Dictionary> list;
		String sKey = "," + key.replace(" ", "") + ",";
		String[] sCodes = code.split(",");
		for (String sCode : sCodes) {
			if (DataSource.dictionaries.get(sCode) != null) {
				list = DataSource.dictionaries.get(sCode);
			} else {
				list = dictionaryMapper.getDataByDictId(Integer.valueOf(sCode));
				DataSource.dictionaries.put(sCode, list);
			}
			for (Dictionary dicData : list) {
				sKey = sKey.replace("," + dicData.getCode() + ",",
						"," + dicData.getDictDesc() + ",");
			}
		}
		return sKey.substring(1, sKey.length() - 1);
	}

	public Map<String, String> getDictionary(String code) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		List<Dictionary> dicList;
		if (DataSource.dictionaries.get(code) != null) {
			dicList = DataSource.dictionaries.get(code);
		} else {
			dicList = dictionaryMapper.getDataByDictId(Integer.valueOf(code));
			DataSource.dictionaries.put(code, dicList);
		}
		for (int i = 0; i < dicList.size(); i++) {
			map.put(dicList.get(i).getCode(), dicList.get(i).getDictDesc());
		}
		return map;
	}

	@Override
	public void update(Dictionary dict) {
		dictionaryMapper.updateByPrimaryKey(dict);
	}
}
