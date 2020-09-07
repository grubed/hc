package com.hongcheng.techinnovte.common.designpattern;

import com.hongcheng.techinnovte.common.enumeration.NormalStatusEnum;

public interface State {
    NormalStatusEnum getState();
    void next(Context c);
    void fail(Context c);
    void pass(Context c);
    void reject(Context c);
}
