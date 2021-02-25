package com.funnycode;

import org.junit.Test;

import java.io.IOException;

/**
 * @author tc
 * @date 2020/8/7
 */
public class EmbeddedZooKeeperServerTest {

    @Test
    public void testZkServer2() throws IOException {
        new EmbeddedZooKeeper(2181, false).start();
        new EmbeddedZooKeeper(2182, false).start();
        new EmbeddedZooKeeper(2183, false).start();

        System.in.read();
    }

}