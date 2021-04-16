module my.pm {
    // exports com.app;
    requires my.service;
    uses com.service.FooService;
}
