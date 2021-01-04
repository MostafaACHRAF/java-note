## Interfaces

- An interface can extend multiple interfaces if a set of rules are adhered to.<br/>
- An interface can inherit multiple interfaces with the same abstract method name, if this method is correctly overloaded.<br/>
- If a derived interface extends two interfaces defining two abstract methods with the same name, but different return types, 'unrelated return types' compilation error is raised.<br/>
- An interface can extend multiple interfaces defining default methods with the same name, if the sub-interface provide its own default implementation and the default methods form a set of correctly overloaded methods.<br/>
- If a derived interface extends more than one interface with conflicting default methods without resolving this conflict, 'unrelated defaults' compilation error is raised.<br/>
- Sub-interfaces and derived classes can access base interfaces default methods using the keyword 'super'. Ex: 'BaseInterface.super.doSomething()'.<br/>
- Implemented default methods in derived classes always win.<br/>
- Default methods implemented in sub-interfaces has priority over default methods implemented in base interfaces.<br/>  
- If there is an ambiguity that can't be resolved by the previous rules, then the targeted super-interface must be specified using the keyword 'super'.<br/>
- An interface can inherit multiple interfaces with static methods with the same name irrelevant to their signature. Because the static methods are never inherited, so no conflicts can occur.<br/>
