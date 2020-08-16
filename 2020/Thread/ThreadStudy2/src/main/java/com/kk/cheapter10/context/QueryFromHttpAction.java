package com.kk.cheapter10.context;

import com.kk.cheapter10.context.extend.ActionContext;

public class QueryFromHttpAction {


    public  void execute( ){
        try {
            Thread.sleep(5_000L);
            String certId  = Thread.currentThread().getName()+"-> 342425199611280831";
            ActionContext.getActionContext().getContext().setCertId(certId);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
