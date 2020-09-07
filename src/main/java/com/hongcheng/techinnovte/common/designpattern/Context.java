package com.hongcheng.techinnovte.common.designpattern;

public class Context {
    private State state;

    public void setState(State s){
        System.out.println("修改状态！");
        state = s;
    }
    public State getState() {
        return state;
    }
    public void next(){
        state.next(this);
    }
    public void fail(){
        state.fail(this);
    }
    public void pass(){
        state.pass(this);
    }
    public void reject(){
        state.reject(this);
    }
}
