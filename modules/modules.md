# Modules

## Compile a module
To compile 'my.pm' module run the following command:<br/>

```
cd modules
javac -d out --module-source-path . --module my.pm
```
-d: directory to where put the compiled files.<br/>
--module-source-path: the parent fodler of your module's root folder.<br/>
--module: the name of your module (must be the same as the name of the root folder).<br/>

## Run a module
And to run the main class of the package 'com.app' run:<br/>

```
java --module-path out --module my.pm/com.app.Main
```

--module-path: folder of compiled module.<br/>
--module: name of the module then the main class, separated by "/".<br/>

## Package a module
To build a java module jar run the following command:<br/>

```
jar --create --file out/my-pm.jar --main-class com.app.Main -C out/my.pm .
```
--create: to create a new jar.<br/>
--file: specify the name of your jar. The destination folder where you want your jar must be already exist.<br/>
-C: point on the folder from where you want to package the app. "." means that we want to include everything into the jar.<br/>
--main-class: specify the main class

## Running a module jar

```
java --module-path out/jar -m my.pm/com.app.Main
```
--module-path: path to your jar.<br/>
-m | --module: module's name with the main class, separated by "/".<br/>

You can use the following shortcut, if you specified the main class when creating your jar using "--main-class" option:<br/>

```
java -jar out/jar/my-pm.jar
```

-jar: specify the path and name of your jar.<br/>

## Package a module as a standalone

```
jlink --module-path out --add-modules my.pm --output out/standalone
```

--module-path: path to the compiled module.<br/>
--add-modules: accept a list of commat separated module's names.<br/>
--output: the path to a folder where to create the image.(must not be already exist).<br/>

## Run a standalone module

cd into the folder of the image. Then run:<br/>

```
cd out/standalone
bin/java --module my.pm/com.app.Main
```

--module: name of the module and Main class.<br/>
