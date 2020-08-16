package com.kk.cheapter10.context;

import com.kk.cheapter10.context.extend.ActionContext;

import java.util.Optional;

public class ExecutionTask extends Thread {
    private QueryFromDBAction queryFromDBAction = new QueryFromDBAction();

    private QueryFromHttpAction queryFromHttpAction = new QueryFromHttpAction();

    @Override
    public void run() {
        queryFromDBAction.execute();
        Optional.of("Query name success").ifPresent(System.out::println);

        queryFromHttpAction.execute();
        Optional.of("Query certId success").ifPresent(System.out::println);

        Context context = ActionContext.getActionContext().getContext();
        Optional.of("the context name is "+context.getName()+" and the certId is "+context.getCertId()).ifPresent(System.out::println);
    }

}
