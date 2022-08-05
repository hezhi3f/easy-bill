package com.hezhi3f.easybill.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hezhi3f.easybill.entity.record.RecordDTO;
import com.hezhi3f.easybill.entity.record.RecordPO;
import com.hezhi3f.easybill.exception.BillException;
import com.hezhi3f.easybill.exception.ExceptionEnum;
import com.hezhi3f.easybill.result.Result;
import com.hezhi3f.easybill.service.RecordService;
import com.hezhi3f.easybill.util.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/record")
public class RecordController {

    private RecordService recordService;

    @RequestMapping("/save")
    public Result<Void> save(@RequestBody RecordDTO recordDTO) {
        recordDTO.setGmtCreated(new Date());

        boolean save = recordService.save(recordDTO);
        if (save) {
            return ResultUtils.success();
        }

        throw new BillException(ExceptionEnum.SHOULD_NOT_OCCUR_ERROR);
    }

    @GetMapping("/list")
    public Result<Page<RecordPO>> list(
            @RequestParam("page") Integer page,
            @RequestParam("size") Integer size) {
        Page<RecordPO> list = getRecordPage(page, size, false);
        return ResultUtils.success(list);
    }

    @GetMapping("/rubbish")
    public Result<Page<RecordPO>> rubbish(
            @RequestParam("page") Integer page,
            @RequestParam("size") Integer size) {
        Page<RecordPO> list = getRecordPage(page, size, true);
        return ResultUtils.success(list);
    }

    private Page<RecordPO> getRecordPage(Integer page, Integer size, Boolean deleted) {
        QueryWrapper<RecordPO> wrapper = Wrappers.<RecordPO>query()
                .eq("user_id", 2)
                .eq("is_deleted", deleted);

        return recordService.page(new Page<>(page, size), wrapper);
    }


    @Autowired
    public void setRecordService(RecordService recordService) {
        this.recordService = recordService;
    }
}
