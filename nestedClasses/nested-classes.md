# Nested classes

- Nested class is a class that is inside another class.
- Nested classes are divided to two types, static and non-static. Non-static nested classes are called 'inner classes' while static ones are called 'static nested classes'.
- Because inner classes are associated with an instance, they can't define static member itself.
- Inner classes have direct access to outer memebers of the enclosing instance.
- There are two special types of inner classes: 'local inner classes' and 'anonymous inner classes'.
- Static nested class is behaviorally a top-level class, so you can reference it using the 'new' operator: StaticNestedClass sc = new StaticNestedClass().
- You can define inner classes inside a method, a for loop, an if statement, a constructor,... Inside any block.
- Local inner classes are similar to inner classes, they can access all outer class's members.
- Local inner classes defined inside a static method, can only access the static memebers of its outer class.
- You can't define an interface inside a local or inner class because interfaces are static by inheritence. And as we know we can't do static declaration inside a local/inner class.
- You can declare constants inside local/inner classes. Constants are static and final variables of type primitive or string, and initialized with a compile-time constant expression (a string, or an arithmetic expression that can be evaluated at compile time)
- Anonymous classes are expressions, you can instantiate and declare a class at the same time, its must be a part of an expression, because of that it end with ";"
- Anonymous classes like local classes can access all members of its outer class.
- Anonymous classes can only access local variables that are final or effectively.
- Anonymous classes can't use static initializers, and can't declare interfaces.
- Anonymous classes can have fields, methods, instance initializers, but can't have constructors.
- Lambda expressions doesn't define a new level of scoping, so you can't redeclare another local variable as a parameter: var x = 5; x -> ++x;//won't compile, because x is already a local variable in the scope.
- Lambda expressions are like inner and anonymous classes, they can't access local variable that aren't final or effectively final.
- Lambda expressions can access outer classes static and instance members.
- There are 4 types of nested classes:

## Static nested class
- Related to static context of the outer class. If you have two nested classes one is the parent of the other, if one of them is static the other must be static too, otherwise a compilation error is thrown.
- A static nested class can see all static methods and variables of its outer class.
- The use of keyword this referes to the nested class itself not the outer class.

## Member inner class

- A member inner class isn't associated with the static context of a class, its associated with the instance context.
- A member inner class can see all instance and static variables and methods of the outer class.

## Local inner class

- The most restrective inner class. Lives inside a method.
- local variables of an outer method referenced from an inner class must be final or effectively final.
- If you want to reference outer method non-final local variables from an inner class, you can pass them as method parameters.

## Anonymous inner class

- An inline representation of a class, an anonymous class that can implement an interface of extends a class.
- The anonymous inner class can see outer method local variables only if they are final or effectively final.
- The anonymous inner class can see the instance and static variables and methods of the outer class.
- You can't add a new method into an anonymous inner class.