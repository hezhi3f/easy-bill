package com.hezhi3f.easybill.sql;

import com.hezhi3f.easybill.entity.record.RecordPO;
import com.hezhi3f.easybill.service.RecordService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.beans.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

@SpringBootTest
public class AutoInsertTest {
    @Autowired
    RecordService recordService;
    Random r = new Random();

    @Test
    @Transient
    void record() {
        String[] when = {"早上", "中午", "晚上"};
        String[] where = {"在家里", "在公司", "在小饭店", "去路边摊", "到大餐厅"};
        String[] what = {"吃面条", "喝酒", "吃炸串", "吃香蕉"};

        for (int i = 0; i < 30; i++) {
            RecordPO recordPO = new RecordPO();
            recordPO.setUserId((long) (r.nextInt(3) + 1));
            recordPO.setTime(new Date());
            recordPO.setGmtCreated(new Date());
            recordPO.setAmount(BigDecimal.valueOf(r.nextInt(20000) / 100.0));
            recordPO.setMemo(when[r.nextInt(when.length)] + where[r.nextInt(where.length)] + what[r.nextInt(what.length)]);
            recordPO.setTypeId(2L);
            recordService.save(recordPO);
        }
    }
}
