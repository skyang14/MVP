package com.yangshikun.mvp.beans;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * Created by yang.shikun on 2020/3/16 11:51
 */

@Entity
public class Bean {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String text;

    public Bean() {
    }

    @Ignore
    public Bean(String text) {
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
