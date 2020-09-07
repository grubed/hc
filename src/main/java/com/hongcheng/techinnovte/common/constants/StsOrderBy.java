package com.hongcheng.techinnovte.common.constants;

import lombok.Data;


public class StsOrderBy {
    public static final String columnSts = "case sts " +
    "when '2' then 1 " +
    "when '1' then 2 " +
    "when '5' then 3 " +
    "when '3' then 4 " +
    "when '0' then 5 " +
    "when '4' then 6 " +
    "when '6' then 7 " +
    "when '7' then 8 " +
    "end,sts";
}
