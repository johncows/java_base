package com.kk.cheapter5;

import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author wangjunkang
 * @version 1.0
 * @description: TODO
 * @date 2020/12/2 下午7:31
 */
public class StringSpliterator {
    private final String[] data;

    public StringSpliterator(String text) {
        Objects.requireNonNull(text, "parameter can not be null");
        this.data = text.split("\n");
    }


    private class InnerSpliterator implements Spliterator<String> {

        private int start, end;

        public InnerSpliterator() {
            this.start = 0;
            this.end = data.length - 1;
        }

        public InnerSpliterator(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean tryAdvance(Consumer<? super String> action) {
            if(start <= end){
                start++;
                action.accept(data[start++]);
                return true;
            }
            return false;
        }

        @Override
        public Spliterator<String> trySplit() {
            int mid = (end - start)/2;
            if (mid<=1) {
                return null;
            }
            int left = start;
            int right = start + mid;

            start = start + mid + 1;
            return new InnerSpliterator(left,right);
        }


//        public long getExactSizeIfKnow

        @Override
        public long estimateSize() {
            return end - start;
        }

        @Override
        public int characteristics() {
            return 0;
        }
    }
}
