package com.kk.cheapter10.context.extend;

import com.kk.cheapter10.context.Context;

public class ActionContext {

    private static final ThreadLocal<Context> THREAD_LOCAL = new ThreadLocal(){
        @Override
        protected Object initialValue() {
            return new Context();
        }
    };

    private static class  contextHolder{
        private final static ActionContext ACTION_CONTEXT = new ActionContext();
    }

    public static ActionContext getActionContext(){
        return contextHolder.ACTION_CONTEXT;
    }


    public Context getContext(){
        return THREAD_LOCAL.get();
    }

}
