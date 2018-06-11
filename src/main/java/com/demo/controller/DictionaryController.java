package com.demo.controller;

import com.demo.core.model.Dictionary;
import com.demo.core.model.Notice;
import com.demo.core.model.base.DataBaseEntity;
import com.demo.core.model.base.ResultEntity;
import com.demo.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("dictionary")
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

    @RequestMapping("/list")
    public String list() {
        return "dictionary";
    }

    @RequestMapping("")
    @ResponseBody
    public Object dictionary(Dictionary dictionary) {
        return convert(dictionaryService.findPageByDictionary(dictionary), dictionary);
    }

    private Map<String,Object> convert(List<Dictionary> dictionaries, Dictionary dictionary) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", 200);
        map.put("msg", "");
        map.put("count", dictionaryService.count(dictionary));
        map.put("data", dictionaries);
        return map;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public ResultEntity create(Dictionary dictionary) {
        List<Dictionary> dictionaries = dictionaryService.find(dictionary);
        if (null != dictionaries && dictionaries.size() > 0) {
            return new ResultEntity(0, "数据已存在");
        }
        DataBaseEntity dataBaseEntity = dictionaryService.create(dictionary);
        return new ResultEntity(1, "保存成功", dataBaseEntity);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResultEntity delete(@PathVariable("id") String id) {
        Dictionary dictionary = dictionaryService.findOne(id);
        if (null == dictionary) {
            return new ResultEntity(0, "资源不存在");
        }
        dictionaryService.delete(id);
        return new ResultEntity(1, "删除成功");
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResultEntity update(@PathVariable("id") String id, Dictionary dictionary) {
        Dictionary oldDictionary = dictionaryService.findOne(id);
        if (null == oldDictionary) {
            return new ResultEntity(0, "资源不存在");
        }
        dictionary.setId(id);
        DataBaseEntity dataBaseEntity = dictionaryService.update(dictionary);
        return new ResultEntity(1, "修改成功", dataBaseEntity);
    }
}
