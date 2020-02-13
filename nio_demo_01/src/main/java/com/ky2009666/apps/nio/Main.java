package com.ky2009666.apps.nio;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        ZdKnowLedge zdKnowLedge = new ZdKnowLedge();
        zdKnowLedge.setDocId("1135");
        log.info(zdKnowLedge.toString());
    }
}
