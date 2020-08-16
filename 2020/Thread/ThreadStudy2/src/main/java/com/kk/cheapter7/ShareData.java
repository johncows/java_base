package com.kk.cheapter7;


import java.util.Arrays;
import java.util.stream.IntStream;


public class ShareData {
    private final char[] buffer;

    private final RWLock readWriteLock = new RWLock();

    public ShareData(int size) {
        this.buffer = new char[size];
        IntStream.range(0, buffer.length).forEach(i -> {
            buffer[i] = '*';
        });
    }


    public char[] read() {
        try {
            readWriteLock.readLock();
            return doRead();
        } finally {
            readWriteLock.releaseReadLock();
        }
    }

    public void write(char c){
        try{
            readWriteLock.writeLock();
            doWrite(c);
            slowly(10_000);
        }finally {
            readWriteLock.releaseWriteLock();
        }


    }

    private void doWrite(char c) {
        System.out.println(Thread.currentThread().getName() + " write " + c);
        IntStream.range(0,buffer.length).forEach(index->{
            buffer[index] = c;
            slowly(10);
        });
    }

    private char[]  doRead() {
        char[] cp = new char[this.buffer.length];
        IntStream.range(0, cp.length).forEach(i ->
                cp[i] = buffer[i]
        );
        slowly(10);
        return cp;
    }

    private void slowly(Integer mill) {
        try {
            Thread.sleep(mill);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
