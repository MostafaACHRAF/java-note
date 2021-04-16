package com.service.impl;

import com.service.FooService;

public class FooServiceImpl implements FooService {

    @Override
    public void fooFoo() {
        System.out.println("Hey! This foo from the service foo imported from a foo module ^^");
    }

} 