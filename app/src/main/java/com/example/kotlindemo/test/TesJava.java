package com.example.kotlindemo.test;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.Nullable;

public class TesJava implements Parcelable {

    public final String name;
    public final String type;

    //可为null的
    private final @Nullable String accessId;


    protected TesJava(Parcel in) {
        name = in.readString();
        type = in.readString();
        accessId = in.readString();
    }

    public static final Creator<TesJava> CREATOR = new Creator<TesJava>() {
        @Override
        public TesJava createFromParcel(Parcel in) {
            return new TesJava(in);
        }

        @Override
        public TesJava[] newArray(int size) {
            return new TesJava[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(type);
        dest.writeString(accessId);
    }
}
