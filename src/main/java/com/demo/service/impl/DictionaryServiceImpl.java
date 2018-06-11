package com.demo.service.impl;

import com.demo.core.mapper.DictionaryMapper;
import com.demo.core.model.Dictionary;
import com.demo.core.model.Notice;
import com.demo.core.model.base.DataBaseEntity;
import com.demo.mybatis.MyMapper;
import com.demo.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class DictionaryServiceImpl extends BaseServiceImpl<Dictionary> implements DictionaryService {

    @Autowired
    private DictionaryMapper dictionaryMapper;

    @Override
    protected MyMapper<Dictionary> getMapper() {
        return dictionaryMapper;
    }


    @Override
    public List<Dictionary> findPageByDictionary(Dictionary dictionary) {
        if (dictionary.getPage() <= 0) {
            dictionary.setPage(1);
        }
        return dictionaryMapper.findPageByDictionary((dictionary.getPage()-1)*dictionary.getRows(),
                                                        dictionary.getRows(), dictionary.getName(),dictionary.getType());
    }

    public long count(Dictionary dictionary) {
        return dictionaryMapper.count(dictionary);
    }

    @Override
    public Dictionary findOne(String id) {
        return dictionaryMapper.findOne(id);
    }

    @Override
    public DataBaseEntity update(Dictionary dictionary) {
        Assert.notNull(dictionary);
        Assert.notNull(dictionary.getId());
        int count = dictionaryMapper.updateByPrimaryKeySelective(dictionary);
        Dictionary existing = dictionaryMapper.findOne(dictionary.getId());
        return new DataBaseEntity(count>0,null==existing?"":existing.getId(),existing);
    }

}
