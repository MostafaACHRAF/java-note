module my.service.impl {
    requires my.service;
    provides com.service.FooService with com.service.impl.FooServiceImpl;
}