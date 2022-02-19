package com.example.browsesolar;

import com.google.gson.annotations.SerializedName;

public class example {
    @SerializedName("main")
    Main main;

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
