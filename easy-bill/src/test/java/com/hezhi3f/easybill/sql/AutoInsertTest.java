package com.hezhi3f.easybill.sql;

import com.hezhi3f.easybill.entity.record.RecordPO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

@SpringBootTest
public class AutoInsertTest {
    private
    Random r = new Random();

    @Test
    void record() {
        String[] when = {"早饭", "中饭", "晚饭"};
        String[] where = {"家里", "公司", "小饭店", "路边摊", "大餐厅"};
        String[] what = {"吃面条", "喝酒", "吃炸串", "吃香蕉"};

        RecordPO recordPO = new RecordPO();
        recordPO.setUserId((long) r.nextInt(3));
        recordPO.setTime(new Date());
        recordPO.setGmtCreated(new Date());
        recordPO.setAmount(BigDecimal.valueOf(r.nextInt(20000) / 100.0));
        recordPO.setMemo(when[r.nextInt(when.length)] + where[r.nextInt(where.length)] + what[r.nextInt(where.length)]);


    }
}
