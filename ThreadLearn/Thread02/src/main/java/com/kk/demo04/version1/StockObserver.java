package com.kk.demo04.version1;

/**
 * @author KK
 * @create 2019-05-22 21:09
 **/
public class StockObserver {
    private String name;
    private Secretary secretary;

    public StockObserver(String name, Secretary secretary) {
        this.name = name;
        this.secretary = secretary;
    }

    public void update(){
        System.out.println(name+" "+secretary.getSecretaryStatus()+" 停止观看股票行情");
    }


}
