package com.ky2009666.apps.nio;

import lombok.extern.slf4j.Slf4j;

import java.nio.IntBuffer;

/**
 * @author Lenovo
 * 演示IntBuffer的使用方法
 */
@Slf4j
public class BasicBuffer {
    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(5);
        for (int i = 0; i < intBuffer.capacity(); i++) {
            intBuffer.put(i * 2);
        }
        /**
         * Flips this buffer.  The limit is set to the current position and then
         * the position is set to zero.  If the mark is defined then it is
         * discarded.
         *
         */
        intBuffer.flip();
        while (intBuffer.hasRemaining()) {
            log.info("intBuffer.get():{}",intBuffer.get());
        }
    }
}
