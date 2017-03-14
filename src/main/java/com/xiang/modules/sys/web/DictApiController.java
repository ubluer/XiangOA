package com.xiang.modules.sys.web;

import com.thinkgem.jeesite.modules.sys.entity.Dict;
import com.thinkgem.jeesite.modules.sys.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Xiang.Yu
 * @version 0.0.1
 * @date 2017/3/9
 * @description DictApiController
 */
@Controller
@RequestMapping("api/dictionary")
public class DictApiController {
    private final DictService dictService;

    @Autowired
    public DictApiController(DictService dictService) {
        this.dictService = dictService;
    }

    /**
     * 获取字典信息
     * @return map{type,[dict]}
     */
    @ResponseBody
    @RequestMapping("init")
    public Map<String, List<Dict>> init() {
        List<Dict> all = dictService.findAllList(new Dict());
        Map<String, List<Dict>> map = new HashMap<>();
        for (Dict dict : all) {
            List<Dict> list = map.computeIfAbsent(dict.getType(), k -> new ArrayList<>());
            list.add(dict);
        }
        return map;
    }
}
