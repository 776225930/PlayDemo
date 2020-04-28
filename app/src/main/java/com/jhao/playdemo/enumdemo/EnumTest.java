package com.jhao.playdemo.enumdemo;

import java.util.EnumSet;

import static com.jhao.playdemo.enumdemo.Week.FRIDAY;
import static com.jhao.playdemo.enumdemo.Week.MONDAY;
import static com.jhao.playdemo.enumdemo.Week.SATURDAY;
import static com.jhao.playdemo.enumdemo.Week.SUNDAY;
import static com.jhao.playdemo.enumdemo.Week.THUESDAY;
import static com.jhao.playdemo.enumdemo.Week.TUESDAY;
import static com.jhao.playdemo.enumdemo.Week.WEDNESDAY;

/**
 * @author JiangHao
 * @date 2020/4/3
 * @describe
 */
public class EnumTest {

    Week mWeek;

    public EnumTest(Week week) {
        mWeek = week;
    }

    public void tellItLikeIt() {
        switch (mWeek) {
            case SUNDAY:
                System.out.println(SUNDAY.name() + " : " + SUNDAY);
                break;
            case MONDAY:
                System.out.println(MONDAY.name() + " : " + MONDAY);
                break;
            case TUESDAY:
                System.out.println(TUESDAY.name() + " : " + TUESDAY);
                break;
            case WEDNESDAY:
                System.out.println(WEDNESDAY.name() + " : " + WEDNESDAY);
                break;
            case THUESDAY:
                System.out.println(THUESDAY.name() + " : " + THUESDAY);
                break;
            case FRIDAY:
                System.out.println(FRIDAY.name() + " : " + FRIDAY);
                break;
            case SATURDAY:
                System.out.println(SATURDAY.name() + " : " + SATURDAY);
                break;
        }
    }

    public static void main(String[] args) {
        EnumTest enumTest = new EnumTest(SUNDAY);
        enumTest.tellItLikeIt();
    }
}
