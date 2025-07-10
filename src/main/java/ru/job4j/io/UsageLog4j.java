package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class);

    public static void main(String[] args) {
        byte b = 121;
        short s = 31000;
        int i = 1_001_002;
        long l = 8_221_454_222_855_756_909L;
        float f = 3.14f;
        double d = 3.718345432123456;
        char a = 'A';
        boolean bool = true;

        LOG.debug("byte b = {}", b);
        LOG.debug("short s = {}", s);
        LOG.debug("int i = {}", i);
        LOG.debug("long l = {}", l);
        LOG.debug("float f = {}", f);
        LOG.debug("double d = {}", d);
        LOG.debug("char a = {}", a);
        LOG.debug("boolean bool = {}", bool);
    }
}
