package com.github.lansheng228.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public enum IntervalEnum {
    DAY30(30, "30 day");


    @Setter
    @Getter
    private Integer interval;

    @Setter
    @Getter
    private String desc;


    public static IntervalEnum getIntervalEnum(Integer interval) {
        IntervalEnum result = null;
        for (IntervalEnum e : IntervalEnum.values()) {
            if (e.getInterval().equals(interval)) {
                result = e;
                break;
            }
        }
        return result;
    }
}
