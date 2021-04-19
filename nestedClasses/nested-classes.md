# Nested classes

- Nested class is a class that is inside another class.
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