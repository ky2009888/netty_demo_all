package com.ky2009666.apps.netty.server;

import io.netty.util.NettyRuntime;
import lombok.extern.slf4j.Slf4j;

/**
 * 展示CPU的核数
 */
@Slf4j
public class CpuAvailableNumsShow {
    public static void main(String[] args) {
        int availableProcessors = NettyRuntime.availableProcessors();
        log.info("可以使用的CPU的核数:{}",availableProcessors);
    }
}
