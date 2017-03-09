package com.xiang.modules.sys.web;

import com.thinkgem.jeesite.modules.sys.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Xiang.Yu
 * @version 0.0.1
 * @date 2017/3/9
 * @description DictApiController
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/dict")
public class DictApiController {
    private final DictService dictService;

    @Autowired
    public DictApiController(DictService dictService) {
        this.dictService = dictService;
    }

    @RequestMapping("init")
    @ResponseBody
    public String get(@RequestParam(required=false) String id) {

        return "aaa";
    }
}
