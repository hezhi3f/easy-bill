package com.hezhi3f.easybill.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hezhi3f.easybill.entity.Record;
import com.hezhi3f.easybill.result.Result;
import com.hezhi3f.easybill.service.RecordService;
import com.hezhi3f.easybill.util.ResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/record")
public class RecordController {

    private RecordService recordService;

    public void save(@RequestBody Record record) {

    }

    @GetMapping("/get")
    public Result<List<Record>> list() {
        QueryWrapper<Record> wrapper = Wrappers.<Record>query().eq("user_id", 1);
        Page<Record> page = recordService.page(new Page<>(1, 5), wrapper);
        return ResultUtils.success(page.getRecords());
    }
}
