# Java OOP Interview Questions --- Abstract Classes & Interfaces

## 2. Can an abstract class implement an interface? If yes, why would you do it?

**Answer:** Yes. An abstract class can implement an interface without
implementing all of its abstract methods.

The abstract class can provide partial implementation and leave the
remaining methods for its subclasses.

Example:

``` java
interface Animal {
    void sound();
}

abstract class Dog implements Animal {
    // sound() can remain unimplemented
}
```

------------------------------------------------------------------------

## 3. Why can't we instantiate an abstract class? What would be the consequences if it were allowed?

**Answer:** An abstract class can contain abstract methods that do not
have an implementation.

``` java
abstract class Animal {
    abstract void sound();
}
```

If Java allowed:

``` java
Animal a = new Animal();
```

there would be no concrete implementation of `sound()` to execute.

Therefore:

> An abstract class is an incomplete blueprint intended to be extended
> by a concrete subclass.

------------------------------------------------------------------------

## 4. What are the limitations of using abstract classes over interfaces?

**Answer:** The main limitation is that Java supports only single class
inheritance.

A class can extend only one class:

``` java
class Dog extends Animal {
}
```

It cannot do:

``` java
class Dog extends Animal, Pet { } // ❌
```

But a class can implement multiple interfaces:

``` java
class Dog implements Animal, Pet, Runnable {
}
```

Therefore, interfaces provide more flexibility when a class needs to
follow multiple contracts.

------------------------------------------------------------------------

## 5. When should you not use an interface? Provide a practical example.

**Answer:** Avoid using an interface as the primary abstraction when
closely related classes need to share substantial state and common
implementation.

For example:

``` java
abstract class Animal {
    String name;

    void eat() {
        System.out.println("Eating...");
    }

    abstract void sound();
}
```

If `Dog` and `Cat` both need the same `name` field and `eat()`
implementation, an abstract class can avoid duplication.

Use an interface when you mainly want to define a capability or
contract.

------------------------------------------------------------------------

## 6. What are default methods in Java interfaces? Why were they introduced?

**Answer:** A default method is a method inside an interface that has a
method body.

``` java
interface Animal {

    default void sound() {
        System.out.println("Animal sound");
    }
}
```

Default methods were introduced in **Java 8**, mainly to provide
**backward compatibility**.

Suppose an interface already has many implementing classes. If a new
abstract method were added, every implementing class would be forced to
implement it.

With a default method:

``` java
default void sound() {
    System.out.println("Animal sound");
}
```

existing implementing classes can continue working without changes.

------------------------------------------------------------------------

## 7. What is the difference between abstract methods and default methods in an interface?

  -----------------------------------------------------------------------
  Abstract Method                     Default Method
  ----------------------------------- -----------------------------------
  Has no body                         Has a body

  Must be implemented by a concrete   Can be inherited
  implementing class                  

  Defines required behavior           Provides optional/default behavior

  Example: `void eat();`              Example: `default void eat() { }`
  -----------------------------------------------------------------------

Example:

``` java
interface Animal {

    void eat();             // Abstract method

    default void sound() {  // Default method
        System.out.println("Animal sound");
    }
}
```

------------------------------------------------------------------------

## 8. Why do we need default methods in Java? Couldn't we achieve the same with abstract classes?

**Answer:** Default methods allow interfaces to provide behavior while
still allowing a class to implement multiple interfaces.

Java does not support multiple inheritance of classes:

``` java
class Dog extends Animal, Pet { } // ❌
```

But a class can implement multiple interfaces:

``` java
class Dog implements Animal, Pet, Runnable {
}
```

Therefore, interfaces with default methods provide flexibility without
requiring multiple class inheritance.

Another major reason is **backward compatibility**.

------------------------------------------------------------------------

## 9. Can a class implement an interface without overriding its default methods?

**Answer:** Yes.

If an interface provides a default implementation, the implementing
class does not have to override it.

``` java
interface Animal {

    default void sound() {
        System.out.println("Animal sound");
    }
}

class Dog implements Animal {
    // No need to override sound()
}
```

The default implementation is inherited.

The class can override it if it needs custom behavior.

------------------------------------------------------------------------

## 10. What happens if a class implements an interface with a default method and also inherits the same method from a superclass? Which one gets priority?

**Answer:** The superclass method takes priority over the interface
default method.

Example:

``` java
class Animal {

    void sound() {
        System.out.println("Animal");
    }
}

interface Pet {

    default void sound() {
        System.out.println("Pet");
    }
}

class Dog extends Animal implements Pet {
}
```

Now:

``` java
Dog d = new Dog();
d.sound();
```

Output:

``` text
Animal
```

### Rule

> Class method \> Interface default method

The inherited superclass implementation wins unless the subclass
explicitly overrides it.

------------------------------------------------------------------------

## 11. What happens if a class implements two interfaces that have a default method with the same name?

**Answer:** The class must override the conflicting method to resolve
the ambiguity.

Example:

``` java
interface DogBehaviour {

    default void makeSound() {
        System.out.println("Dog");
    }
}

interface CatBehaviour {

    default void makeSound() {
        System.out.println("Cat");
    }
}

class AnimalProcessor implements DogBehaviour, CatBehaviour {

    @Override
    public void makeSound() {
        System.out.println("My implementation");
    }
}
```

Without the override, Java produces a compile-time error because it
cannot decide which default implementation to use.

You can also explicitly choose one interface's default implementation:

``` java
@Override
public void makeSound() {
    DogBehaviour.super.makeSound();
}
```

------------------------------------------------------------------------

## 12. Is it possible to override a default method and make it abstract in a subclass or interface? Why or why not?

**Answer:** Yes. An inherited default method can be redeclared as
abstract in an abstract class or subinterface.

Example with an abstract class:

``` java
interface Animal {

    default void sound() {
        System.out.println("Animal sound");
    }
}

abstract class Dog implements Animal {

    @Override
    public abstract void sound();
}
```

Now `Dog` removes the inherited concrete implementation and requires its
concrete subclasses to implement `sound()`.

It can also be done in a subinterface:

``` java
interface Animal {

    default void sound() {
        System.out.println("Animal sound");
    }
}

interface Dog extends Animal {

    void sound(); // Redeclared as abstract
}
```

### Important

The statement "a default method cannot be made abstract" is incorrect.
It **can** be redeclared as abstract.

------------------------------------------------------------------------

## 13. Can default methods access instance variables of the implementing class? Why or why not?

**Answer:** A default method cannot directly access instance variables
declared only in the implementing class.

Example:

``` java
interface Animal {

    default void show() {
        System.out.println(name); // ❌
    }
}

class Dog implements Animal {
    String name = "Tommy";
}
```

The interface does not know about `Dog`'s `name` field.

However, the default method can call an interface method that exposes
the value:

``` java
interface Animal {

    String getName();

    default void show() {
        System.out.println(getName());
    }
}

class Dog implements Animal {

    String name = "Tommy";

    public String getName() {
        return name;
    }
}
```

### Key point

> Interfaces do not have normal instance state like classes do. A
> default method can work with parameters, its own local variables,
> constants, and methods available through the interface.

------------------------------------------------------------------------

## 14. What are some limitations of default methods compared with methods in abstract classes?

**Answer:** Abstract classes can maintain instance state and provide
constructors, while interfaces cannot have normal instance fields or
constructors.

An abstract class can have:

``` java
abstract class Animal {

    String name;

    Animal(String name) {
        this.name = name;
    }

    abstract void sound();

    void eat() {
        System.out.println(name + " is eating");
    }
}
```

An abstract class can provide:

-   Instance variables
-   Constructors
-   Instance state
-   Shared implementation
-   Abstract methods
-   Access to `super`

An interface is primarily used for contracts and can additionally
provide default/static methods.

------------------------------------------------------------------------

# Quick Interview Revision

## Abstract Class

-   Can have abstract and concrete methods.
-   Can have instance variables.
-   Can have constructors.
-   Can maintain object state.
-   A class can extend only one class.
-   Cannot be instantiated directly.
-   Can implement one or more interfaces.

## Interface

-   Defines a contract/capability.
-   A class can implement multiple interfaces.
-   Can contain abstract methods.
-   Can contain default methods.
-   Can contain static methods.
-   Can contain constants (`public static final` fields).
-   Does not have normal instance state or constructors.

## Default Method Rules

1.  Default method has a body.
2.  Introduced in Java 8.
3.  Mainly useful for backward compatibility.
4.  Implementing classes can inherit it without overriding.
5.  A class's inherited method takes priority over an interface default
    method.
6.  If two interfaces provide conflicting default methods, the class
    must resolve the conflict.
7.  A default method can be redeclared as abstract in an abstract class
    or subinterface.
8.  A default method cannot directly access instance fields belonging
    only to the implementing class.

------------------------------------------------------------------------

# Most Important Interview Rules

``` text
Abstract Class
    ↓
State + Constructor + Common Implementation

Interface
    ↓
Contract + Multiple Implementation

Abstract Method
    ↓
"No implementation — you must implement it"

Default Method
    ↓
"Here is a default implementation — override if needed"

Priority
    ↓
Class Method > Interface Default Method

Two Conflicting Interface Defaults
    ↓
Implementing Class MUST Override

Default Methods
    ↓
Introduced in Java 8
    ↓
Main reason: Backward Compatibility
```
