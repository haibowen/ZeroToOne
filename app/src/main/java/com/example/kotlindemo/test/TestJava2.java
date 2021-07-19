package com.example.kotlindemo.test;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class TestJava2  implements Parcelable {
    
    
    public final @NonNull String name = null;
    
    
    protected TestJava2(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TestJava2> CREATOR = new Creator<TestJava2>() {
        @Override
        public TestJava2 createFromParcel(Parcel in) {
            return new TestJava2(in);
        }

        @Override
        public TestJava2[] newArray(int size) {
            return new TestJava2[size];
        }
    };
}
