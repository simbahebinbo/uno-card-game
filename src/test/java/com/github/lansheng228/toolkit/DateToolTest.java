package com.github.lansheng228.toolkit;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;


@Slf4j
public class DateToolTest {

    @Test
    public void testCompareDate() {
        int ret = DateTool.compareDate("2008-08-29", "2008-09-02");

        assert ret < 0;
    }

    @Test
    public void testParse() {
        String dt = DateTool.convert("2017-06-26 19:14:17");

        assert "2017-06-26".equals(dt);
    }

    @Test
    public void testGetToday() {
        String dt = DateTool.getToday();

        log.info(dt);
    }

    @Test
    public void testGetYesterday() {
        String dt = DateTool.getYesterday();

        log.info(dt);
    }

    @Test
    public void testGetTomorrow() {
        String dt = DateTool.getTomorrow();

        log.info(dt);
    }

    @Test
    public void testGetNextDay() {
        String dt = DateTool.getNextDay("2017-06-26");

        assert "2017-06-27".equals(dt);
    }

    @Test
    public void testGetPrevDay() {
        String dt = DateTool.getPrevDay("2017-06-26");

        assert "2017-06-25".equals(dt);
    }

    @Test
    public void testGetIntervalMonth() {
        String dt = DateTool.getIntervalMonth(-3);
        log.info(dt);
    }
}
