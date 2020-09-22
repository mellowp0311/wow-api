package com.wow.api.init;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class AppVersionTest {

    @Test
    public void test_compare_to() {
        InetAddress local;
        try {
            local = InetAddress.getLocalHost();
            String ip = local.getHostAddress();
            System.out.println("local ip : "+ip);
        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        }

    }


}
