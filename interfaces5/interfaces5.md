## Interfaces

- Interface's constants are implicitly "public final static".<br/>
- Interface's constants must be initialized, or a compilition error is thrown.<br/>
- Interface's methods are implicitly public.<br/>
- The classes implementing interface's abstract methods can't assign weaker access to those methods, thus the implemented methods must be public.<br/> 
- Interfaces can't define constructors like classes do.<br/>
- We can define a reference variable of type interface, but this reference variable must refer to an object of a class that implements that interface.<br/>.
- Reference variable of type interface can't access all attributes of an interface.<br/>
- Since java SE 9, you can use private methods inside an interface, to remove redundant code and restrict it to not be accessible outside the interface.
- You can declare a private static method in an interface.
- The overriding method can't have a more restrictive access modifier than the overriden method. This rule is valid for interfaces, and abstract classes.
-If a class X defines the same method as an interface Y, and if a class W extend X and implements Y. The method of the class X must be public, otherwise the code won't compile: 'attempting to assign weaker access privileges'.
