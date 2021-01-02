## Interfaces

- A class can't inherit multiple classes.<br/>
- Multiple inheritances isn't allowed, because base classes may define different implementations for the same method signature.<br/>
- A class can't inherit multiple classes but can implement multiple interfaces.<br/>
- Unlike classes, interfaces can extend (inherit) multiple interfaces.<br/>
- A class can implement multiple interfaces only if a set of rules is adhered to.<br/>
- Referring to interfaces constants with the same name without prefixing them with the interface name is an ambiguous call and would raise a compilation error.<br/>
- If the implicit reference to constants defined in interfaces isn't ambiguous, prefixing a constant with its interface name is optional.<br/>
- A class can implement multiple interfaces if they define abstract methods with the same signature or form an overloaded set of methods.<br/>
- A class can implement multiple interfaces if they define default methods with the same signature of form an overloaded set of methods.<br/>
- A class can implement multiple interfaces with the same default method signature, if it overrides its default implementation.<br/>
- A class can implement multiple interfaces with the same static methods names, irrelevant to their return types or signature.<br/>
