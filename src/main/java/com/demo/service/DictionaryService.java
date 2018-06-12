package com.demo.service;


import com.demo.core.model.Dictionary;

import java.util.List;

public interface DictionaryService extends BaseService<Dictionary> {

     List<Dictionary> findPageByDictionary(Dictionary dictionary);

     List<Dictionary> findByType(String type);
}
