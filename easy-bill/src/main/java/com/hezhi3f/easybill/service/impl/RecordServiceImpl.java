package com.hezhi3f.easybill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hezhi3f.easybill.dao.RecordMapper;
import com.hezhi3f.easybill.entity.Record;
import com.hezhi3f.easybill.service.RecordService;
import org.springframework.stereotype.Service;

@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements RecordService {
}
