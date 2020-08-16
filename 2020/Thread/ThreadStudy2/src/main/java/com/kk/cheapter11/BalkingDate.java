package com.kk.cheapter11;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 *  试想如下场景：当你坐在餐厅需要点餐，两位服务员监听到动作后准备发起服务的动作，
 *  当服务员A看到服务员B已经到达了你的餐桌时，服务员A停止动作。这就是balking设计。
 *
 *  Balking是“退缩不前”的意思。Balking Pattern和Guarded Suspension Pattern 一样需要警戒条件。
 *  在Balking Pattern中，当警戒条件不成立时，会马上中断，
 *  而Guarded Suspension Pattern 则是等待到可以执行时再去执行。
 *
 */
public class BalkingDate {

    private String fileName;
    private String content;
    private boolean flag;

    public BalkingDate(String fileName) {
        this.fileName = fileName;
        this.content = "";
        this.flag = false;
    }

    public synchronized void appendContent(String content) {
        this.content = content;
        this.flag = true;
    }

    public synchronized void save() {
        if (!this.flag) {
            return;
        }
        try {
            doSave();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.flag = false;
    }

    private void doSave() throws IOException {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(this.content);
        }
    }
}