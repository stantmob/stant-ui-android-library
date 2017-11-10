package br.com.stant.libraries.stantuiandroid.entities;

import java.io.Serializable;

/**
 * Created by denisvieira on 29/10/17.
 */

public class UiComponent implements Serializable{

    private final String mName;
    private final String mMarkdownDocUrl;

    public UiComponent(String name, String markdownDocUrl) {
        this.mName = name;
        this.mMarkdownDocUrl = markdownDocUrl;
    }

    public String getName() {
        return mName;
    }

    public String getMarkdownDocUrl() {
        return mMarkdownDocUrl;
    }
}
