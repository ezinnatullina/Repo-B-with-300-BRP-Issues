package com.aurea.brpcs.ruletest.squid.noncompliant;

import java.util.Date;

public class S2184Rule {

    float twoThirdsFloat = 2 / 3; // Noncompliant; int division. Yields 0.0
    float multiFloat = 2 * 3;
    double twoThirdsDouble = 2 / 3; // Noncompliant; int division. Yields 0.0
    double multiDouble = 2 * 3;
    long millisInYear = 1_000 * 3_600 * 24 * 365; // Noncompliant; int multiplication. Yields 1471228928
    long bigNum = Integer.MAX_VALUE + 2; // Noncompliant. Yields -2147483647
    long bigNegNum = Integer.MIN_VALUE - 1; //Noncompliant, gives a positive result instead of a negative one.

    long seconds = 2147483647;
    Date myDate = new Date(seconds * 1_000); //Noncompliant, won't produce the expected result if seconds > 2_147_483_647

    public long compute(int factor) {
        return factor * 10_000;  //Noncompliant, won't produce the expected result if factor > 214_748
    }

    public float compute2(long factor) {
        return factor / 123;  //Noncompliant, will be rounded to closest long integer
    }

    public double compute3(long factor) {
        return factor / 123;  //Noncompliant, will be rounded to closest long integer
    }

}