package com.example.java_test;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created on 5/19/21
 * Author: hyplo
 * Email: haibowen088@gmail.com
 * Description: show me the code change the world
 */
public class Test {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) {

        consumerString(t-> System.out.println(t));

        Consumer<String> stringConsumer=x->{

            ///
            ///
            System.out.println("x");

        };


    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void consumerString(Consumer<Integer> function) {
        function.accept(1);
    }
}
