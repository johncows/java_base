package com.kk.cheapter7;

/**
 * 读写锁
 */
public class RWLock {

    // read标识位
    private int reading_readers = 0;
    private int waiting_readers = 0;

    // write标示位
    private int writing_writers = 0;
    private int waiting_writers = 0;

    /**
     *     是否优先写入
     */
    private boolean preferWriter;

    public RWLock(boolean preferWriter) {
        this.preferWriter = preferWriter;
    }

    public RWLock() {
        this(true);
    }

    // 读锁
    public synchronized void readLock() {
        this.waiting_readers++;
        try {
            while ( writing_writers > 0 || (preferWriter && this.waiting_writers > 0)) {
                this.wait();
            }
            this.waiting_readers--;
            this.reading_readers++;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    public synchronized void releaseReadLock() {
        this.reading_readers--;
        this.notifyAll();
    }


    public synchronized void writeLock() {
        this.waiting_readers++;
        try {
            while (writing_writers > 0 || reading_readers > 0) {
                this.wait();
            }
            this.waiting_readers--;
            this.writing_writers++;
        } catch (Exception e) {

        } finally {
        }
    }

    public synchronized void releaseWriteLock() {
        this.writing_writers--;
        this.notifyAll();
    }
}
