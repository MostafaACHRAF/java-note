## Super keyword

- The 'super' keyword is an implicit reference variable that refers to object's parent (base class).<br/>
- You can use the 'super' keyword to access parent class methods and variables.<br/>
- You can use the 'super' keyword to call parent constructors, this statement must be the first line within derived class constructors.<br/> 
- You can't use the 'super' keyword within static methods of a class or an interface.<br/>
- The use of 'super' is optional, except when there is a clash between methods names and variables names defined in parent and derived classes.<br/>
- If there is no collision between variables defined in a base class and a derived class, you can access base class variables using the keyword 'super' and 'this'.<br/>
- If there is a collision between variables defined in a base class and a derived class, the use of 'super' and 'this' is obligatory to differentiate between those variables.<br/>
- The the parent's default constructor is implicitly called using 'super' keyword in derived class's constructors.<br/>
- If the parent class has no default constructor, the derived classes must call parent's constructor explicitly using the keyword 'super', otherwise a compilation error is thrown.<br/>
