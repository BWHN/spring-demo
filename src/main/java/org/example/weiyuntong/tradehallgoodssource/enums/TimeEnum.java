package org.example.weiyuntong.tradehallgoodssource.enums;

public enum TimeEnum {

    DAY_IN_3(true, 3),
    DAY_IN_7(true, 7),
    DAY_IN_15(true, 15),
    DAY_IN_30(true, 30),
    DAY_OUT_15(false, 15),
    DAY_OUT_30(false, 30);

    private final boolean in;
    private final Integer day;

    TimeEnum(boolean in, Integer day) {
        this.in = in;
        this.day = day;
    }

    public Integer getStart() {
        return in ? 0: day;
    }

    public Integer getEnd() {
        return in ? day: null;
    }

}
