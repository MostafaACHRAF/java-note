package com.app.impl;

import com.app.MyService;

public class MyServiceImpl implements MyService {
    @Override
    public void foo() {
        System.out.println("This is foo interface");
    }
}