package com.xiang.modules.sys.web;

import com.thinkgem.jeesite.common.persistence.BaseEntity;
import com.thinkgem.jeesite.modules.sys.entity.Dict;
import com.thinkgem.jeesite.modules.sys.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    @ResponseBody
    @RequestMapping("init")
    public List<Dict> init() {
         return dictService.findAllList(new Dict());
    }
}
