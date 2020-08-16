package com.kk.cheapter10.context;

        import java.util.stream.IntStream;

public class ContextTest {
    public static void main(String[] args) {
        IntStream.range(1,4).forEach(
                i ->{
                    new ExecutionTask().start();
                }
        );
    }
}
