package com.kk.cheapter10.context;

import com.kk.cheapter10.context.extend.ActionContext;

public class QueryFromDBAction {

    public  void execute(){
        try {
            Thread.sleep(1_000L);
            String name = Thread.currentThread().getName()+"-> 张三";
            ActionContext.getActionContext().getContext().setName(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
