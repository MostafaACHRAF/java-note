# Exceptions

Exception are errors, there are three types of exceptions in Java:<br/>
- Checked exceptions
- Runtime exceptions
- Errors

## Benefits of handling exceptions

If you don't handle exceptions, your code will be a mess.<br/>
You want be able to differenciate between business logic and edge cases that may cause errors.<br/>

### Unconvenient code

```
if (user instanceof Manager) {
    Session session = checkconnection();
    if (session == null) {
        session = createNewSession(user);
    }
    Page homePage = redirectToHomePage();
    if (homePage.isReady()) {
        showSomething();
        ....
    } else {
        return "unavailablePage";
    }
} else {
    return "unsupportedUser";
}
```

### Convenient code

```
try {
    checkUSer();
    checkConnection();
    redirectToHomePage();
    showSomething();
    ....

} catch(InvalidUserException e) {
    return "InvalidUser";

} catch(InvalidSessionException e) {
    createNewConnection();

} catch(PageUnavailableException e1) {
    return "unavailablePage";
}
```

The above code looks much more cleaner. Because of "separation of concerns".<br/>
The 'try' block contains the normal flow, without taking care of errors.<br/>
If somthing went's wrong the logic in 'catch' blocks will be executed, according to the triggered exception's type.<br/>

- Another advantage of exception handling is 'stack-trace', because it gives you a list of called methods when the JVM encouter an unhandled exception.<br/>

## Exception categories

- Unchecked exceptions = Runtime exceptions + errors
- Errors are JVM errors, generally related to JVM configuration
- All exceptions, extends the class 'Throwable'

### Class hierarchies of exception categories

                    Object
                      |
                   Throwable
                    /    \
                Error    Exception
                            \
                            RuntimeException

### Checked exceptions

- Checked exceptions, are unacceptable conditions that are foresees by the author of the code. Example: FileNotFoundException.
- Checked exceptions, makes it clear for the users, that this code may throw an exception, so either he retrow the exception or handle it properly.
- Checked exceptions, are called because, thet are checked during compilation.
- When a method call throws an exception, the compiler check if the calling methods are either rethrow the exception, or handling it.
- Checked exceptions subclasses Exception, and not RuntimeException.

### Runtime exceptions

- Runtime exceptions are errors that are detectable at runtime only.
- Runtime exceptions subclass of RuntimeException.
- Runtime exceptions with JVM errors are called 'unchecked' exceptions.
- NullPointerException and ArrayIndexOutOfBoundsException are examples of RuntimeExceptions.

### Error exceptions

- Errors are serious JVM errors, that can't be handled by your code.
- For example NoClassDefFoundError and StackOverflowError are Error exceptions.
- Your code can handle errors, but it's not supposed to.
- Error is a subclass of 'java.lang.Error'.

## Throw / throws

- Throws informs the calling methods that this method throws an exception, that must be handled or rethrown.
- Throw keyword do the actual exception throwing.
- Method signature can have multiple exceptions declarations, separated by comma.
- Method signature can have Runtime and Error exceptions, by it's optional.
- It's prefered to declare runtime and error exception at documentation.

## Handle-or-declare rule

- To use a method that throws a checked exception, you must either handle the exception or declare it to be thrown.
- You can do both, handle the exception and declare it to be thrown.
- The act of handling the exception ordeclaring it to be thrown is called the rule of 'handle-or-declare'.
- You can't use 'handle-or-declare' rule with Runtime and Error exceptions. This rule applies only to checked exceptions.
- If you don't apply this rule, you will get a compilation error.
- The declaration of Runtime and Error exceptions in 'throws' and 'throw' statements is optional.
- A method can be declared to throw any type of exception checked or unchecked.
- A 'try/catch' block can catch checked exceptions other than 'Exception' if the 'try' block throw that exception, or calls a method that throws that exception.
- A 'try/catch' can have multiple catch blocks but only one 'finaly' block.
- 'finaly' block must be always the last block.
- I you don't apply 'handle-or-declare' rule, an exception is risen.
- You don't have to handle-or-declare Runtime exceptions.
- You can declare or handle Runtime exception, though the prefered way is to use appropriate (if/else) tests.
- The 'finally' block will still be executed even if the 'try' block or one the 'catch' blocks define a 'return' statement.
- After executing the 'finally' block. If the 'try' block or one of the 'catch' blocks define a 'return' statement, the control will be returned to that line, and the code after 'finally' block will not be executed.
- If you declare a return statement in 'try' block and in all your catch blocks, all statements after 'try/catch' block will never be executed, so the compilation error 'unreachable statement' is thrown.
- Normally the 'finally' block will always be executed, except when encountering 'System.exit' statement which immediately terminates the application. Or when a crash of the JVM or OS occurs.
- If both 'finally' and 'catch' blocks returns a value, the 'return' statement of 'finally' block will be executed.
- If there is 'return' statement into 'finally' block, that return statement will be executed.
- The 'finally' block can't modifiy the value of primitive vairables. Because primitive variables are passed by value not by reference.
- The 'finally' block can modifiy the value of reference variables. Because reference variables are passed by reference not by value.
- You can declare a 'try' block followed by'finally' block without worring about compilation errors. But only if the try block doesn't throw a checked exception.
- If a 'try' block throws a checked exception, you either have to declare the exception into method's signature, or handle it using 'catch' block.
- The order of caught exceptions in the catch blocks matters. You can't catch 'base class exception' before catching 'derived class exception' because the 'derived class exception' will never be reached. So a compilation error arise.
- Java compiler doesn't allow 'unreachable' statements.
- In the catch block you can do anything with catched exception.
- In the catch block you can rethrow a checked exception, but to prevent compilation errors you must either surround the exception with 'try/catch' or declare it in method's signature.
- In the catch block you can rethrow unchecked exceptions without caring about handling or declaring them.
- You can declare a method to declare checked exceptions if you don't wich to handle the checked exception within that method.
- If you try to handle a checked exception without having a code that trow that exception, you will get the following compilation error: 'EXCEPTION_NAME is never thrown'
- You can handle JVM errors, but we can't be sure that the exception will be handled, for example you can't catch 'VirtualMachineError', but you can handle 'StackOverflowError'.