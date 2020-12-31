# Interfaces

- An interface is a contract between the interface and the classes implementing it.<br/>
- A class can implement multiple interfaces.<br/>
- An interface can be implemented by multiple classes.<br/>
- Unlike a class, an interface can extends multiple interfaces.<br/>
- We can't instanciate an interface.<br/>
- Top level classes, enums, and interfaces in java, can only be "public" or "default access".<br/>
- Top level interfaces, can only use "strictfp", "abstract" non access modifiers.<br/>
- Top level classes... are not inner classes. They are not withing other classes.<br/>
- Non top level classes can have any access modifier (public, private, protecter, default);<br/>
- Interfaces can have variables, methods, classes, interfaces.<br/>
- All members of an interface, are implicitly public.<br/>
- All members of an interface, can be explicitly public, using an other access modifier will cause a compilition error. <br/>
- Interface's variables are by default : public static final.<br/>
- Interface's methods are by default : public abstract.<br/>
- Since Java 8 we can use "static" and "default" methods. Not only "abstract" methods.<br/>
- Default methods are methods with default implementation. Default methods resolve the problem of breaking all implementations of an interface X, whenever we add a new methods.
- static methods are utility methods. That can only be accessed from outside by using interface's name.<br/>
- Unlike interfaces. Base classes static methods can be accessed using reference variables, or class name.</br>
- Interface's static method can't be overloaded, or overriden by any of the classes implementing this interface.<br/>
- A non abstract class that implement an interface must implement all it's non default methods.<br/>
- The overrided default methods, and implemented abstract methods on an interface X in a class Y must be public, otherwise a compilation error is rised. <br/> 
- When overriding an interface's default method we must respect "method-overrriding rules". Like the return type of the overridee method must be included into interface's method return type.<br/>

