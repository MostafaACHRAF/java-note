## Polymorphism

- Polymorphism is the act of overriding inherited methods,these methods are called polymorphic methods.<br/>
- Polymorphism occurs when parent and derived classes provide different implementations for methods with the same signature and same parameters.<br/>
- It's not possible to have polymorphism with overloaded methods, because these methods may have diffrent parameters and different return types.<br/>
- Polymorphism occurs only with overriden methods, because they have the same signature, and same parameters.<br/>
- A derived class can only override non-final methods.<br/>
- The return type of the overriding method in the subclass can be the same or a subtype of the overiden method's type in the base class.<br/> 
- Overriden methods in the base class can be abstract or concret methods.<br/>
-  The overriding method must have the same signature and exactly the same parameters list as the overriden method to be a polymorphic method.<br/>
- When calling overriding methods, the JVM will take care of resolving the correct method to call based on referenced object's type.<br/>
- When calling overloaded methods, the JVM calls the correct method based on reference variable's type.<br/>

# Variables and methods binding

- Binding refers to resolving methods and variables that a reference variable can access.<br/>
- Variables are bound at compile time, while methods are bound at runtime.<br/>
- Because variables are bound at compile time, the type of the referenced object doesn't matter, what matters is the type of the reference variable.<br/>
- Because methods are bound at runtime, the type of referenced object matters.<br/>
