package com.marex333.inventory;

import org.apache.commons.codec.digest.DigestUtils;

public class test {
    public static void main(String[] args) {
        System.out.println(DigestUtils.md5Hex("admin"));
        System.out.println(DigestUtils.md5Hex("user"));
        System.out.println(DigestUtils.md5Hex("demo"));

}}
