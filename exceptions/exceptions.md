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