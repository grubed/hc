package com.hongcheng.techinnovte.common.designpattern;

import com.hongcheng.techinnovte.common.enumeration.NormalStatusEnum;

public class WaitVerify2State implements State {
    @Override
    public NormalStatusEnum getState() {
        return NormalStatusEnum.WATTING_SRCRETARIAT_SEC_VERIFY;
    }
    @Override
    public void next(Context c) {

    }

    @Override
    public void fail(Context c) {
        c.setState(new FailedState());
    }

    @Override
    public void pass(Context c) {
        c.setState(new PassState());
    }

    @Override
    public void reject(Context c) {
        c.setState(new RejectState());
    }
}
