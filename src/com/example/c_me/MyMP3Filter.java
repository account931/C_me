package com.example.c_me;
import java.io.File;
import java.io.FilenameFilter;

//USED in MAIn MpPlay.java
class MyMP3Filter implements FilenameFilter {
    public boolean accept(File dir, String name) {
        return (name.endsWith(".mp3"));
    }
}

