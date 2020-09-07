package com.hongcheng.techinnovte.common.designpattern;

import com.hongcheng.techinnovte.common.enumeration.NormalStatusEnum;

public class PassState implements State {
    @Override
    public NormalStatusEnum getState() {
        return NormalStatusEnum.PASS;
    }
    @Override
    public void next(Context c) {

    }

    @Override
    public void fail(Context c) {

    }

    @Override
    public void pass(Context c) {

    }

    @Override
    public void reject(Context c) {

    }
}
