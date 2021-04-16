# Modules

To compile 'my.pm' module run the following command:

```
javac -d out --module-source-path . --module my.pm
```

And to run the main class of the package 'com.app' run:

```
java --module-path out --module my.pm/com.app.Main
```