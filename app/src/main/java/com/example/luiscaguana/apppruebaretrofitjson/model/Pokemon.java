package com.example.luiscaguana.apppruebaretrofitjson.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pokemon {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("url")
    @Expose
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Nombre Pokemon= " +"\t"+ name  +
                "\n           " +
                "\n\tURL= '" + "\t"+url+
                "\n"
               ;
    }
}

