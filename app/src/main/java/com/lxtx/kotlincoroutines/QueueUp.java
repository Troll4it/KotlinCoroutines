package com.lxtx.kotlincoroutines;

import android.util.Log;

/**
 * @author TangPeng
 * @since 2019/3/4
 */
public class QueueUp {

    private int sum = 1;

    QueueUp() {
        Log.i("Java排队:", "排队开始JavaJavaJavaJavaJavaJavaJavaJavaJava");
    }

    public QueueUpAction doAction() {
        return new QueueUpAction() {
            @Override
            public void add() {
                Log.i("Java排队位置:", "第" + sum + "位");
                sum++;
            }
        };
    }

}

