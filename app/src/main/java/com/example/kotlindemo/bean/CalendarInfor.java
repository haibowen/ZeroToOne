package com.example.kotlindemo.bean;

/**
 * Created on 4/20/21
 * Author: hyplo
 * Email: haibowen088@gmail.com
 * Description: show me the code change the world
 */
public class CalendarInfor {

    public String content;

    public int type;

    public CalendarInfor(String content, int type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public CalendarInfor setContent(String content) {
        this.content = content;
        return this;
    }

    public int getType() {
        return type;
    }

    public CalendarInfor setType(int type) {
        this.type = type;
        return this;
    }
}
