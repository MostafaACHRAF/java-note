package com.app;

import com.app.impl.MyServiceImpl;
import com.service.FooService;
import java.util.ServiceLoader;

public class Main {
   public static void main(String... args) {
      System.out.println("Hey there! I'm a module");
      MyService service = new MyServiceImpl();
      service.foo();

      FooService fooService = ServiceLoader.load(FooService.class).findFirst().get();
      fooService.fooFoo();
   }
}
