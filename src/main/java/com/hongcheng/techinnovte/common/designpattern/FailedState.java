package com.hongcheng.techinnovte.common.designpattern;

import com.hongcheng.techinnovte.common.enumeration.NormalStatusEnum;

public class FailedState implements State {
    @Override
    public NormalStatusEnum getState() {
        return NormalStatusEnum.FAILED;
    }

    @Override
    public void next(Context c) {
        c.setState(new WaitVerifyState());
    }

    @Override
    public void fail(Context c) {

    }

    @Override
    public void pass(Context c) {
        c.setState(new WaitVerifyState());
    }

    @Override
    public void reject(Context c) {
        c.setState(new RejectState());
    }
}
