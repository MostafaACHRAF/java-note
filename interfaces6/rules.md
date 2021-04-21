# Default methods inheretence rules

## Rule1
- A super-class method's takes priority over an interface's default method.

### Example
If we have a class A that defines a method read(); This method may be concret or abstract
And
If we have an interface B that defines a default method read();
And
If we have a class C that extends A and implements B
If the class C tries to call the method read, the one that will be called is the method read of the super-class A

## Rule2
- Subtype interface's default method takes priority over super-type interface's default method

### Example
If an interface A defines a default method m
And
If an interface B defines a default method m, and B extends A
And
If a class C implements A and B
If a class C tries to call the method m, the method m of B will be executed

## Rul3
-If there is a conflict, the class must implement the default method, even if it's default.

### Example
If an interface A and B defines a default method m
And
If a class C implements A and B, in that case C won't compile, because there is a conflict between A and B
To prevent that compilation error, C must implement the default method m, even if the class is abstract.