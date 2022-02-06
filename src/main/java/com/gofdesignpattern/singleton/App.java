package com.gofdesignpattern.singleton;

import java.io.*;
import java.lang.reflect.Constructor;

public class App {
    public static void main(String[] args) throws NoSuchMethodException {
        Settings settings = Settings.getInstance();
        System.out.println(settings = Settings.getInstance());
    }
}
