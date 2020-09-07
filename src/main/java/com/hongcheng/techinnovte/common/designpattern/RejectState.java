package com.hongcheng.techinnovte.common.designpattern;

import com.hongcheng.techinnovte.common.enumeration.NormalStatusEnum;

public class RejectState implements State{
    @Override
    public NormalStatusEnum getState() {
        return NormalStatusEnum.REJECT;
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
