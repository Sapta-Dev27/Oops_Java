# 🎭 Java Abstraction — Complete Interview Guide

> Complete end-to-end Java Abstraction notes for technical interviews.
>
> Covers Abstraction, Abstract Classes, Abstract Methods, Concrete Classes, Interfaces, Default Methods, Static Methods, Private Interface Methods, Abstract Class vs Interface, Abstraction vs Encapsulation, Inheritance, Polymorphism, Multiple Interfaces, Runtime Polymorphism, Functional Interfaces, tricky interview questions, rapid-fire questions, and final revision.

---

# 📚 Table of Contents

1. [What is Abstraction?](#1-what-is-abstraction)
2. [Real-Life Example](#2-real-life-example)
3. [Simple Java Example](#3-simple-java-example)
4. [Why Do We Need Abstraction?](#4-why-do-we-need-abstraction)
5. [How is Abstraction Achieved in Java?](#5-how-is-abstraction-achieved-in-java)
6. [Abstract Class](#6-abstract-class)
7. [Abstract Method](#7-abstract-method)
8. [Concrete Method](#8-concrete-method)
9. [Concrete Class](#9-concrete-class)
10. [`abstract` Keyword](#10-abstract-keyword)
11. [Abstract Class Example](#11-abstract-class-example)
12. [Rules of Abstract Classes](#12-rules-of-abstract-classes)
13. [Can Abstract Class Have Variables?](#13-can-abstract-class-have-variables)
14. [Can Abstract Class Have Constructors?](#14-can-abstract-class-have-constructors)
15. [Can Abstract Class Have Concrete Methods?](#15-can-abstract-class-have-concrete-methods)
16. [Can Abstract Class Have Static Methods?](#16-can-abstract-class-have-static-methods)
17. [Can Abstract Class Have Final Methods?](#17-can-abstract-class-have-final-methods)
18. [Can Abstract Class Have Private Methods?](#18-can-abstract-class-have-private-methods)
19. [Can We Create Object of Abstract Class?](#19-can-we-create-object-of-abstract-class)
20. [Can Abstract Class Have No Abstract Methods?](#20-can-abstract-class-have-no-abstract-methods)
21. [What If Child Does Not Implement Abstract Methods?](#21-what-if-child-does-not-implement-abstract-methods)
22. [Multiple Levels of Abstraction](#22-multiple-levels-of-abstraction)
23. [Interface](#23-interface)
24. [Abstraction Using Interface](#24-abstraction-using-interface)
25. [Why Use Interfaces?](#25-why-use-interfaces)
26. [Multiple Interfaces](#26-multiple-interfaces)
27. [Default Methods](#27-default-methods)
28. [Default Method Conflict](#28-default-method-conflict)
29. [Static Methods in Interfaces](#29-static-methods-in-interfaces)
30. [Private Methods in Interfaces](#30-private-methods-in-interfaces)
31. [Interface Variables](#31-interface-variables)
32. [Functional Interface](#32-functional-interface)
33. [Abstraction and Runtime Polymorphism](#33-abstraction-and-runtime-polymorphism)
34. [Abstraction vs Encapsulation](#34-abstraction-vs-encapsulation)
35. [Abstraction vs Inheritance](#35-abstraction-vs-inheritance)
36. [Abstraction vs Polymorphism](#36-abstraction-vs-polymorphism)
37. [Four Pillars of OOP](#37-four-pillars-of-oop)
38. [Real-World Examples](#38-real-world-examples)
39. [Benefits of Abstraction](#39-benefits-of-abstraction)
40. [Disadvantages / Trade-offs](#40-disadvantages--trade-offs)
41. [Complete Interview Questions](#41-complete-interview-questions)
42. [Medium Interview Questions](#42-medium-interview-questions)
43. [Interface Interview Questions](#43-interface-interview-questions)
44. [Abstract Class vs Interface Questions](#44-abstract-class-vs-interface-questions)
45. [Tricky Interview Questions](#45-tricky-interview-questions)
46. [Very Tricky Questions](#46-very-tricky-questions)
47. [Perfect Interview Answer](#47-perfect-interview-answer)
48. [Perfect Example Answer](#48-perfect-example-answer)
49. [Rapid Fire Round](#49-rapid-fire-round)
50. [Final Revision Map](#50-final-revision-map)
51. [15 Things to Remember](#51-15-things-to-remember)
52. [Final Interview Checklist](#52-final-interview-checklist)
53. [One-Minute Revision](#53-one-minute-revision)
54. [Golden Interview Rule](#54-golden-interview-rule)
55. [Final Cheat Sheet](#55-final-cheat-sheet)

---

# 1. What is Abstraction?

The easiest definition:

> **Abstraction is the process of hiding implementation details and exposing only the essential functionality to the user.**

In simple words:

```text
User
  ↓
Sees WHAT the object can do
  ↓
Doesn't need to know HOW it does it
```

For example, when you use an ATM, you know:

```text
withdraw()
deposit()
checkBalance()
```

But you don't need to know:

```text
Bank database
Transaction processing
Security verification
Network communication
Server implementation
```

That is abstraction.

---

# 2. Real-Life Example

Consider a car.

You use:

```text
start()
accelerate()
brake()
```

You don't need to know exactly how:

```text
Fuel injection
Engine combustion
Transmission
Brake system
ECU
```

work internally.

You only interact with the required functionality.

Therefore:

```text
Abstraction
     ↓
Show essential functionality
     ↓
Hide implementation details
```

---

# 3. Simple Java Example

Suppose we have:

```java
abstract class Animal {

    abstract void sound();
}
```

The abstract class says:

```text
Every Animal must have sound()
```

But it does not define exactly how every animal sounds.

Dog:

```java
class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}
```

Cat:

```java
class Cat extends Animal {

    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}
```

The abstraction is:

```text
Animal
   |
   └── sound()
```

The implementations are:

```text
Dog → bark
Cat → meow
```

---

# 4. Why Do We Need Abstraction?

Abstraction helps us:

1. Reduce complexity
2. Hide implementation details
3. Expose only necessary functionality
4. Reduce coupling
5. Improve maintainability
6. Improve flexibility
7. Support polymorphism
8. Create clean APIs
9. Make code easier to extend
10. Separate what something does from how it does it

---

# 5. How is Abstraction Achieved in Java?

Java mainly provides two mechanisms:

```text
                 Abstraction
                      |
             ┌────────┴────────┐
             |                 |
       Abstract Class       Interface
```

## Abstract Class

Uses:

```java
abstract class
```

It can contain:

```text
abstract methods
concrete methods
instance variables
static variables
constructors
static methods
final methods
private methods
```

---

## Interface

Uses:

```java
interface
```

It primarily defines a contract.

Example:

```java
interface Payment {

    void pay();
}
```

Implementation:

```java
class CreditCardPayment implements Payment {

    @Override
    public void pay() {
        System.out.println("Payment using credit card");
    }
}
```

---

# 6. Abstract Class

An abstract class is a class declared using:

```java
abstract
```

Example:

```java
abstract class Animal {

    abstract void sound();
}
```

It is designed to be used as a base class.

---

# 7. Abstract Method

An abstract method is a method declared without an implementation body.

Example:

```java
abstract class Animal {

    abstract void sound();
}
```

Notice:

```java
abstract void sound();
```

There is no method body.

The child class must provide the implementation unless the child is also abstract.

Example:

```java
class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Bark");
    }
}
```

---

# 8. Concrete Method

A concrete method has an implementation/body.

Example:

```java
void eat() {

    System.out.println("Eating");
}
```

An abstract class can contain both:

```text
Abstract methods
+
Concrete methods
```

Example:

```java
abstract class Animal {

    abstract void sound();

    void eat() {
        System.out.println("Eating");
    }
}
```

Here:

```text
sound() → abstract
eat()   → concrete
```

---

# 9. Concrete Class

A concrete class is a normal class that can be instantiated.

Example:

```java
class Dog {

    void bark() {
        System.out.println("Bark");
    }
}
```

We can create:

```java
Dog d = new Dog();
```

---

# 10. `abstract` Keyword

The `abstract` keyword can be used with:

```text
Class
Method
```

Example:

```java
abstract class Animal {
}
```

and:

```java
abstract void sound();
```

Important:

```text
abstract class
      ↓
Cannot directly instantiate

abstract method
      ↓
No implementation in declaring class
```

---

# 11. Abstract Class Example

Complete example:

```java
abstract class Animal {

    void eat() {
        System.out.println("Animal eats");
    }

    abstract void sound();
}

class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

public class Main {

    public static void main(String[] args) {

        Dog d = new Dog();

        d.eat();
        d.sound();
    }
}
```

Output:

```text
Animal eats
Dog barks
```

Here:

```text
Animal
   |
   ├── eat()     → concrete
   |
   └── sound()   → abstract
```

Dog provides:

```text
sound()
```

---

# 12. Rules of Abstract Classes

## Rule 1 — Cannot Directly Instantiate

```java
abstract class Animal {
}
```

This is invalid:

```java
Animal a = new Animal(); // ❌
```

---

## Rule 2 — Can Have Constructors

```java
abstract class Animal {

    Animal() {
        System.out.println("Animal constructor");
    }
}
```

---

## Rule 3 — Can Have Concrete Methods

```java
abstract class Animal {

    void eat() {
        System.out.println("Eating");
    }
}
```

---

## Rule 4 — Can Have Abstract Methods

```java
abstract class Animal {

    abstract void sound();
}
```

---

## Rule 5 — Child Must Implement Abstract Methods

A concrete subclass must implement all inherited abstract methods.

---

## Rule 6 — Abstract Child Can Leave Them Unimplemented

If the child is also abstract, it can leave abstract methods unimplemented.

---

# 13. Can Abstract Class Have Variables?

Yes.

It can contain:

```text
Instance variables
Static variables
Final variables
```

Example:

```java
abstract class Animal {

    protected String name;

    static int count;

    final String type = "Animal";
}
```

---

# 14. Can Abstract Class Have Constructors?

Yes.

This is a very common interview question.

Example:

```java
abstract class Animal {

    Animal() {
        System.out.println("Animal constructor");
    }
}
```

Child:

```java
class Dog extends Animal {

    Dog() {
        System.out.println("Dog constructor");
    }
}
```

Create:

```java
Dog d = new Dog();
```

Output:

```text
Animal constructor
Dog constructor
```

Why?

The child constructor invokes the parent constructor.

Conceptually:

```text
Dog()
 ↓
super()
 ↓
Animal()
```

---

# 15. Can Abstract Class Have Concrete Methods?

Yes.

Example:

```java
abstract class Animal {

    void eat() {
        System.out.println("Eating");
    }

    abstract void sound();
}
```

Here:

```text
eat()    → concrete
sound()  → abstract
```

This is one of the major advantages of abstract classes.

They can provide:

```text
Common implementation
+
Abstract behavior
```

---

# 16. Can Abstract Class Have Static Methods?

Yes.

Example:

```java
abstract class Animal {

    static void info() {
        System.out.println("Animal class");
    }
}
```

Call:

```java
Animal.info();
```

Static methods belong to the class.

---

# 17. Can Abstract Class Have Final Methods?

Yes.

Example:

```java
abstract class Animal {

    final void breathe() {
        System.out.println("Breathing");
    }

    abstract void sound();
}
```

The child inherits:

```text
breathe()
```

but cannot override it.

---

# 18. Can Abstract Class Have Private Methods?

Yes.

Example:

```java
abstract class Animal {

    private void helper() {
        System.out.println("Helper");
    }

    abstract void sound();
}
```

Private methods:

```text
Can be used inside declaring class
Cannot be directly accessed by subclasses
Cannot be overridden
```

---

# 19. Can We Create Object of Abstract Class?

No.

This is invalid:

```java
abstract class Animal {
}

Animal a = new Animal(); // ❌
```

But this is valid:

```java
Animal a = new Dog();
```

provided:

```java
class Dog extends Animal {
}
```

This is extremely important.

Remember:

```text
Abstract reference → YES
Abstract object    → NO
```

Example:

```java
Animal a = new Dog();
```

Reference type:

```text
Animal
```

Actual object:

```text
Dog
```

This is runtime polymorphism.

---

# 20. Can Abstract Class Have No Abstract Methods?

Yes.

Example:

```java
abstract class Animal {

    void eat() {
        System.out.println("Eating");
    }
}
```

There is no abstract method.

But the class is still abstract.

Why might we do this?

To prevent direct instantiation while providing common functionality to subclasses.

---

# 21. What If Child Does Not Implement Abstract Methods?

Suppose:

```java
abstract class Animal {

    abstract void sound();
}
```

Child:

```java
class Dog extends Animal {
}
```

This causes a compile-time error.

Why?

Because `Dog` does not implement:

```text
sound()
```

The child must either implement it:

```java
class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Bark");
    }
}
```

or remain abstract:

```java
abstract class Dog extends Animal {
}
```

Remember:

```text
Concrete child
      ↓
Must implement abstract methods

Abstract child
      ↓
Can leave them unimplemented
```

---

# 22. Multiple Levels of Abstraction

Abstract classes can form an inheritance hierarchy.

Example:

```java
abstract class Vehicle {

    abstract void start();
}

abstract class EngineVehicle extends Vehicle {

    void fuel() {
        System.out.println("Uses fuel");
    }
}

class Car extends EngineVehicle {

    @Override
    void start() {
        System.out.println("Car starts");
    }
}
```

Hierarchy:

```text
Vehicle
   |
   ↓
EngineVehicle
   |
   ↓
Car
```

`Car` eventually provides the implementation of:

```text
start()
```

---

# 23. Interface

An interface is another major mechanism for abstraction in Java.

Example:

```java
interface Payment {

    void pay();
}
```

It defines a contract.

It says:

```text
Any Payment implementation
must provide pay()
```

Example:

```java
class CreditCardPayment implements Payment {

    @Override
    public void pay() {
        System.out.println("Credit card payment");
    }
}
```

---

# 24. Abstraction Using Interface

Example:

```java
interface Vehicle {

    void start();
}
```

Implementation:

```java
class Car implements Vehicle {

    @Override
    public void start() {
        System.out.println("Car starts");
    }
}
```

Another implementation:

```java
class Bike implements Vehicle {

    @Override
    public void start() {
        System.out.println("Bike starts");
    }
}
```

Client code:

```java
Vehicle v1 = new Car();

Vehicle v2 = new Bike();

v1.start();
v2.start();
```

The client only depends on:

```text
Vehicle
   ↓
start()
```

It doesn't need to know the internal implementation.

That's abstraction.

---

# 25. Why Use Interfaces?

Interfaces are useful when we want:

```text
Common contract
+
Multiple implementations
+
Loose coupling
+
Multiple interface implementation
```

Example:

```java
interface Payment {

    void pay();
}
```

Implementations:

```java
class UpiPayment implements Payment {

    @Override
    public void pay() {
        System.out.println("UPI");
    }
}
```

```java
class CardPayment implements Payment {

    @Override
    public void pay() {
        System.out.println("Card");
    }
}
```

Client:

```java
Payment payment = new UpiPayment();

payment.pay();
```

The client depends on:

```text
Payment
```

not:

```text
UpiPayment
```

This gives loose coupling.

---

# 26. Multiple Interfaces

A class can implement multiple interfaces.

Example:

```java
interface Camera {

    void takePhoto();
}

interface GPS {

    void navigate();
}

class Smartphone implements Camera, GPS {

    @Override
    public void takePhoto() {
        System.out.println("Taking photo");
    }

    @Override
    public void navigate() {
        System.out.println("Navigating");
    }
}
```

Conceptually:

```text
Camera       GPS
   \         /
    \       /
   Smartphone
```

Java allows:

```java
class Smartphone implements Camera, GPS
```

This supports multiple inheritance of **type/contracts**, while Java does not support multiple inheritance of classes.

---

# 27. Default Methods

Java 8 introduced default methods in interfaces.

Example:

```java
interface Vehicle {

    default void start() {
        System.out.println("Vehicle starts");
    }
}
```

A class can use it directly:

```java
class Car implements Vehicle {
}
```

Then:

```java
Car c = new Car();

c.start();
```

Output:

```text
Vehicle starts
```

---

# 28. Default Method Conflict

Suppose:

```java
interface A {

    default void show() {
        System.out.println("A");
    }
}
```

and:

```java
interface B {

    default void show() {
        System.out.println("B");
    }
}
```

Now:

```java
class C implements A, B {
}
```

There is a conflict.

Java requires the class to resolve it.

Solution:

```java
class C implements A, B {

    @Override
    public void show() {

        System.out.println("C");
    }
}
```

Or explicitly use one interface's implementation:

```java
class C implements A, B {

    @Override
    public void show() {

        A.super.show();
    }
}
```

This is an important interview question.

---

# 29. Static Methods in Interfaces

Interfaces can have static methods.

Example:

```java
interface Payment {

    static void info() {
        System.out.println("Payment interface");
    }
}
```

Call:

```java
Payment.info();
```

Not:

```java
Payment p = new Payment();
p.info(); // ❌
```

Static interface methods belong to the interface itself.

---

# 30. Private Methods in Interfaces

Modern Java interfaces can have private methods.

Example:

```java
interface Payment {

    default void process() {

        validate();

        System.out.println("Processing");
    }

    private void validate() {

        System.out.println("Validating");
    }
}
```

The private method:

```text
validate()
```

is used internally by the interface.

It is not directly accessible to implementing classes.

---

# 31. Interface Variables

Variables declared in an interface are implicitly:

```text
public
static
final
```

Example:

```java
interface Constants {

    int MAX = 100;
}
```

Conceptually:

```java
public static final int MAX = 100;
```

Therefore:

```java
Constants.MAX;
```

is valid.

But:

```java
Constants.MAX = 200; // ❌
```

because it is final.

---

# 32. Functional Interface

A functional interface has exactly one abstract method.

Example:

```java
@FunctionalInterface
interface Calculator {

    int calculate(int a, int b);
}
```

It can be used with a lambda:

```java
Calculator add = (a, b) -> a + b;

System.out.println(add.calculate(10, 20));
```

Output:

```text
30
```

Common functional interfaces in Java:

```text
Runnable
Comparator
Predicate
Consumer
Function
Supplier
```

Important:

A functional interface can still have:

```text
default methods
static methods
private methods
```

It must have exactly one **abstract** method.

---

# 33. Abstraction and Runtime Polymorphism

Abstraction works very well with runtime polymorphism.

Example:

```java
abstract class Animal {

    abstract void sound();
}
```

Implementations:

```java
class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Bark");
    }
}
```

```java
class Cat extends Animal {

    @Override
    void sound() {
        System.out.println("Meow");
    }
}
```

Now:

```java
Animal a;

a = new Dog();
a.sound();

a = new Cat();
a.sound();
```

Output:

```text
Bark
Meow
```

The reference type is:

```text
Animal
```

but different implementations execute.

This combines:

```text
Abstraction
+
Inheritance
+
Method Overriding
+
Runtime Polymorphism
```

---

# 34. Abstraction vs Encapsulation

🔥 Very common interview question.

## Abstraction

Focus:

```text
Hide implementation complexity
```

Question:

```text
WHAT should the user know?
```

Example:

```java
interface Payment {

    void pay();
}
```

---

## Encapsulation

Focus:

```text
Protect/control internal state
```

Question:

```text
HOW is access to data controlled?
```

Example:

```java
class BankAccount {

    private double balance;
}
```

---

## Easy Memory Trick

```text
Abstraction
    ↓
Hide complexity

Encapsulation
    ↓
Protect data
```

### Interview Answer

> "Abstraction hides implementation details and exposes essential functionality, while encapsulation bundles data and behavior and controls access to the object's internal state."

---

# 35. Abstraction vs Inheritance

## Abstraction

Defines what functionality should exist.

Example:

```java
abstract class Animal {

    abstract void sound();
}
```

## Inheritance

Allows a class to acquire and extend behavior from another class.

Example:

```java
class Dog extends Animal {
}
```

Therefore:

```text
Abstraction
    ↓
Define essential behavior

Inheritance
    ↓
Reuse/extend behavior
```

They often work together.

---

# 36. Abstraction vs Polymorphism

## Abstraction

Hides implementation details.

## Polymorphism

Allows one interface/reference to represent multiple implementations.

Example:

```java
Animal a = new Dog();
```

The `Animal` type provides abstraction.

The fact that:

```text
Dog
Cat
Horse
```

can all be treated as:

```text
Animal
```

demonstrates polymorphism.

---

# 37. Four Pillars of OOP

The four pillars are:

```text
Encapsulation
Abstraction
Inheritance
Polymorphism
```

Easy memory:

```text
Encapsulation → Protect
Abstraction   → Hide
Inheritance   → Reuse
Polymorphism  → Many forms
```

---

# 38. Real-World Examples

## 1. ATM

User sees:

```text
withdraw()
deposit()
checkBalance()
```

Internal implementation is hidden.

---

## 2. Car

User interacts with:

```text
start()
accelerate()
brake()
```

Engine details are hidden.

---

## 3. Payment System

Common interface:

```java
interface Payment {

    void pay();
}
```

Implementations:

```text
UPI
Credit Card
Debit Card
Net Banking
Wallet
```

The client only needs:

```text
pay()
```

---

## 4. Database

Application may use:

```text
save()
find()
delete()
```

without needing to know:

```text
SQL generation
Connection management
Query optimization
Network communication
```

---

# 39. Benefits of Abstraction

## 1. Reduces Complexity

Users don't need to understand implementation details.

## 2. Improves Maintainability

Internal implementation can change without changing the external contract.

## 3. Loose Coupling

Client code depends on abstractions rather than concrete implementations.

## 4. Flexibility

Different implementations can be substituted.

Example:

```text
Payment
   |
   ├── UPI
   ├── Card
   └── Wallet
```

## 5. Reusability

A common abstraction can be used by many implementations.

## 6. Security

Internal implementation details can be hidden from users.

## 7. Supports Polymorphism

A common abstraction can represent multiple implementations.

---

# 40. Disadvantages / Trade-offs

Abstraction is useful, but overusing it can make a system unnecessarily complex.

## 1. More Classes/Interfaces

You may create additional abstraction layers.

## 2. Learning Curve

A new developer may need to understand multiple interfaces/classes before understanding the implementation.

## 3. Over-Abstraction

Creating abstractions where they provide no real benefit can make code harder to understand.

## 4. Indirection

You may need to navigate:

```text
Interface
    ↓
Abstract class
    ↓
Concrete class
```

instead of directly reading one implementation.

---

# 41. Complete Interview Questions

## Q1. What is abstraction?

### Answer

> Abstraction is the OOP principle of hiding implementation details and exposing only the essential functionality to the user.

---

## Q2. Why is abstraction used?

### Answer

> Abstraction reduces complexity, hides implementation details, improves maintainability, reduces coupling, provides flexibility, and supports polymorphism.

---

## Q3. How is abstraction achieved in Java?

### Answer

Mainly through:

```text
Abstract classes
Interfaces
```

---

## Q4. What is an abstract class?

### Answer

> An abstract class is a class declared with the `abstract` keyword that cannot be directly instantiated and can contain both abstract and concrete methods.

---

## Q5. What is an abstract method?

### Answer

> An abstract method is a method declared without an implementation body and is generally implemented by a concrete subclass.

Example:

```java
abstract void sound();
```

---

## Q6. What is a concrete method?

### Answer

A method with an implementation/body.

---

## Q7. What is a concrete class?

### Answer

A class that can be instantiated and is not abstract.

---

## Q8. Can we create an object of an abstract class?

No.

```java
Animal a = new Animal(); // ❌
```

But:

```java
Animal a = new Dog(); // ✅
```

---

## Q9. Can abstract class have constructors?

Yes.

---

## Q10. Can abstract class have concrete methods?

Yes.

---

# 42. Medium Interview Questions

## Q11. Can an abstract class have variables?

Yes.

It can contain:

```text
instance variables
static variables
final variables
```

---

## Q12. Can an abstract class have static methods?

Yes.

---

## Q13. Can an abstract class have final methods?

Yes.

A final method cannot be overridden.

---

## Q14. Can an abstract class have private methods?

Yes.

Private methods cannot be overridden.

---

## Q15. Can an abstract class have no abstract methods?

Yes.

Example:

```java
abstract class Animal {

    void eat() {
        System.out.println("Eating");
    }
}
```

---

## Q16. What happens if a concrete subclass doesn't implement all abstract methods?

Compile-time error.

The subclass must either:

```text
Implement all abstract methods
```

or:

```text
Also be abstract
```

---

## Q17. Can an abstract class extend another abstract class?

Yes.

Example:

```java
abstract class Animal {

    abstract void sound();
}

abstract class Mammal extends Animal {

    abstract void walk();
}
```

---

## Q18. Can an abstract class extend a concrete class?

Yes.

Example:

```java
class Animal {

    void eat() {
        System.out.println("Eating");
    }
}

abstract class Dog extends Animal {

    abstract void sound();
}
```

---

# 43. Interface Interview Questions

## Q19. What is an interface?

> An interface is a contract that defines behavior that implementing classes agree to provide.

Example:

```java
interface Payment {

    void pay();
}
```

---

## Q20. Can a class implement multiple interfaces?

Yes.

```java
class Smartphone implements Camera, GPS {
}
```

---

## Q21. Can an interface extend another interface?

Yes.

```java
interface A {
}

interface B extends A {
}
```

---

## Q22. Can an interface extend multiple interfaces?

Yes.

```java
interface C extends A, B {
}
```

---

## Q23. Can an interface have variables?

Yes.

They are implicitly:

```text
public static final
```

---

## Q24. Can an interface have constructors?

No.

Interfaces cannot be instantiated directly, so they don't have constructors.

---

## Q25. Can an interface have default methods?

Yes.

Since Java 8.

---

## Q26. Can an interface have static methods?

Yes.

---

## Q27. Can an interface have private methods?

Yes, modern Java allows private methods in interfaces.

---

# 44. Abstract Class vs Interface Questions

## Q28. Abstract class vs interface?

### Answer

> An abstract class is useful when related classes need shared state and implementation, while an interface is useful for defining a contract or capability that multiple classes can implement.

---

## Q29. Why can a class implement multiple interfaces?

Because Java allows multiple interface implementation, which supports multiple inheritance of type without allowing multiple class inheritance.

---

## Q30. Why does Java not allow multiple class inheritance?

To avoid ambiguity such as the Diamond Problem.

---

## Q31. Can an abstract class implement an interface?

Yes.

Example:

```java
interface Payment {

    void pay();
}

abstract class OnlinePayment implements Payment {

}
```

It doesn't have to implement `pay()` because it is abstract.

A concrete subclass must eventually implement it.

---

# 45. Tricky Interview Questions

## Q32. Can abstract class be final?

No.

```java
final abstract class A {
}
```

is invalid.

Why?

```text
abstract → designed to be extended
final    → cannot be extended
```

These concepts conflict.

---

## Q33. Can abstract method be final?

No.

```java
abstract final void show();
```

is invalid.

Why?

```text
abstract → must be implemented/overridden
final    → cannot be overridden
```

---

## Q34. Can abstract method be static?

No.

An abstract method needs subclass implementation through overriding, while static methods belong to the class and are not overridden dynamically.

---

## Q35. Can abstract method be private?

No.

A private method cannot be overridden, but an abstract method needs to be implemented by a subclass.

Therefore:

```text
abstract + private
```

is invalid.

---

## Q36. Can abstract class have private constructor?

Yes.

Example:

```java
abstract class Animal {

    private Animal() {
    }
}
```

However, if the class has no accessible constructor for subclasses, normal external subclassing can be restricted.

---

## Q37. Can abstract class have static method?

Yes.

---

## Q38. Can abstract class have final method?

Yes.

---

## Q39. Can abstract class have concrete method?

Yes.

---

## Q40. Can abstract class have zero abstract methods?

Yes.

---

## Q41. Can abstract class have all abstract methods?

Yes.

---

## Q42. Can interface have implementation?

Yes.

Modern Java interfaces can contain:

```text
default methods
static methods
private methods
```

in addition to abstract method declarations.

---

## Q43. Can interface be instantiated?

No.

```java
Payment p = new Payment(); // ❌
```

But:

```java
Payment p = new UpiPayment(); // ✅
```

---

## Q44. Can interface reference point to implementing class?

Yes.

```java
Payment p = new UpiPayment();
```

This is runtime polymorphism.

---

## Q45. Can abstract class reference point to child object?

Yes.

```java
Animal a = new Dog();
```

---

# 46. Very Tricky Questions

## Q46. What is the difference between an abstract class and a normal class?

A normal concrete class can generally be instantiated.

An abstract class cannot be directly instantiated and is designed to provide a partial abstraction/base for subclasses.

---

## Q47. Why use abstract class if we cannot create its object?

Because it provides:

```text
Common implementation
Common state
Common contract
Base behavior
```

for subclasses.

---

## Q48. Why use interface instead of abstract class?

Use an interface when you primarily want to define a contract/capability and potentially allow unrelated classes to implement it.

Examples:

```text
Flyable
Payable
Runnable
Serializable
```

---

## Q49. Why use abstract class instead of interface?

Use an abstract class when closely related subclasses need shared state or common implementation.

Example:

```text
Animal
   |
   ├── Dog
   ├── Cat
   └── Horse
```

---

## Q50. Can an abstract class implement an interface without implementing its methods?

Yes, if the abstract class itself remains abstract.

Example:

```java
interface Payment {

    void pay();
}

abstract class OnlinePayment implements Payment {

}
```

---

## Q51. Can a class extend an abstract class and implement interfaces?

Yes.

Example:

```java
class Dog extends Animal implements Pet, Guard {
}
```

---

## Q52. Can an interface extend multiple interfaces?

Yes.

```java
interface C extends A, B {
}
```

---

## Q53. Can a class extend multiple abstract classes?

No.

Even if both are abstract:

```java
class C extends A, B {
}
```

is invalid.

Java allows only one superclass.

---

# 47. Perfect Interview Answer

If interviewer asks:

> **"What is abstraction in Java?"**

Say:

> "Abstraction is an OOP principle where we hide implementation details and expose only the essential functionality to the user. In Java, abstraction is mainly achieved using abstract classes and interfaces. An abstract class can contain both abstract and concrete methods, while an interface primarily defines a contract and can provide default, static, and private methods. Abstraction helps reduce complexity, improve maintainability, reduce coupling, and support polymorphism."

---

# 48. Perfect Example Answer

If interviewer asks:

> "Give me an example of abstraction."

Say:

> "For example, I can define a Payment interface with a `pay()` method. Different classes such as UpiPayment and CardPayment implement `pay()` differently. The client only interacts with the Payment interface and doesn't need to know how each payment method internally works."

Example:

```java
interface Payment {

    void pay();
}

class UpiPayment implements Payment {

    @Override
    public void pay() {
        System.out.println("Payment through UPI");
    }
}

class CardPayment implements Payment {

    @Override
    public void pay() {
        System.out.println("Payment through Card");
    }
}
```

Usage:

```java
Payment payment = new UpiPayment();

payment.pay();
```

---

# 49. Rapid Fire Round

| Question | Answer |
|---|---|
| What is abstraction? | Hiding implementation details and exposing essential functionality |
| Main purpose? | Reduce complexity |
| Java mechanisms? | Abstract classes and interfaces |
| Abstract class instantiated? | ❌ No |
| Abstract class constructor? | ✅ Yes |
| Abstract class variables? | ✅ Yes |
| Abstract class concrete methods? | ✅ Yes |
| Abstract class abstract methods? | ✅ Yes |
| Abstract class static methods? | ✅ Yes |
| Abstract class final methods? | ✅ Yes |
| Abstract class private methods? | ✅ Yes |
| Abstract class with zero abstract methods? | ✅ Yes |
| Abstract method body? | ❌ No |
| Abstract method final? | ❌ No |
| Abstract method static? | ❌ No |
| Abstract method private? | ❌ No |
| Concrete class must implement abstract methods? | ✅ Yes |
| Abstract subclass must implement immediately? | ❌ No |
| Interface instantiated? | ❌ No |
| Interface constructor? | ❌ No |
| Interface variables? | `public static final` |
| Interface default methods? | ✅ Yes |
| Interface static methods? | ✅ Yes |
| Interface private methods? | ✅ Yes |
| Multiple interfaces? | ✅ Yes |
| Multiple abstract classes? | ❌ No |
| Interface extends interface? | ✅ Yes |
| Interface extends multiple interfaces? | ✅ Yes |
| Abstract class implements interface? | ✅ Yes |
| Abstract class final? | ❌ No |
| Abstract reference to child? | ✅ Yes |
| Interface reference to implementation? | ✅ Yes |
| Can abstract class have no abstract methods? | ✅ Yes |
| Can abstract class have all abstract methods? | ✅ Yes |
| Can interface have default implementation? | ✅ Yes |
| Can interface have static methods? | ✅ Yes |
| Can interface have private methods? | ✅ Yes |
| Can interface have constructors? | ❌ No |

---

# 50. Final Revision Map

```text
                         ABSTRACTION
                              |
               ┌──────────────┴──────────────┐
               |                             |
         ABSTRACT CLASS                  INTERFACE
               |                             |
       ┌───────┼────────┐              Contract
       |       |        |                   |
    Abstract Concrete Variables       Multiple Implementations
    Methods  Methods
       |
       ↓
    Subclass
       |
       ↓
 Implementation
```

---

# 51. 15 Things to Remember

1. Abstraction = hiding implementation details.
2. Abstraction exposes essential functionality.
3. Java mainly uses abstract classes and interfaces.
4. Abstract classes cannot be directly instantiated.
5. Abstract classes can have constructors.
6. Abstract classes can have concrete methods.
7. Abstract classes can have variables.
8. Abstract methods have no implementation body.
9. Concrete subclasses must implement inherited abstract methods.
10. An abstract subclass can leave abstract methods unimplemented.
11. An abstract class can have zero abstract methods.
12. An abstract method cannot be `final`.
13. An abstract method cannot be `static`.
14. An abstract method cannot be `private`.
15. Interfaces are useful for contracts, loose coupling, and multiple interface implementation.

---

# 52. Final Interview Checklist

Before an interview, make sure you can explain:

- [ ] What is abstraction?
- [ ] Why is abstraction important?
- [ ] How is abstraction achieved in Java?
- [ ] What is an abstract class?
- [ ] What is an abstract method?
- [ ] What is a concrete method?
- [ ] What is a concrete class?
- [ ] Why can't abstract classes be instantiated?
- [ ] Can abstract classes have constructors?
- [ ] Can abstract classes have variables?
- [ ] Can abstract classes have concrete methods?
- [ ] Can abstract classes have static methods?
- [ ] Can abstract classes have final methods?
- [ ] Can abstract classes have private methods?
- [ ] Can abstract classes have zero abstract methods?
- [ ] What happens if child doesn't implement abstract methods?
- [ ] What is an interface?
- [ ] Why use interfaces?
- [ ] Can class implement multiple interfaces?
- [ ] Can interface extend multiple interfaces?
- [ ] Can interfaces have variables?
- [ ] Can interfaces have constructors?
- [ ] Can interfaces have default methods?
- [ ] Can interfaces have static methods?
- [ ] Can interfaces have private methods?
- [ ] What is a functional interface?
- [ ] Abstract class vs interface
- [ ] Abstraction vs encapsulation
- [ ] Abstraction vs inheritance
- [ ] Abstraction vs polymorphism
- [ ] Abstract class vs concrete class
- [ ] Abstract method vs concrete method
- [ ] Abstract + final?
- [ ] Abstract + static?
- [ ] Abstract + private?
- [ ] Can abstract class implement interface?
- [ ] Can class extend abstract class and implement interfaces?
- [ ] Can abstract class extend another abstract class?
- [ ] Can abstract class be final?
- [ ] Can abstract reference point to child?
- [ ] Can interface reference point to implementation?

---

# 53. One-Minute Revision

```text
Abstraction
     ↓
Hide implementation details
     ↓
Expose essential functionality
     ↓
Java provides
     |
     ├── Abstract Class
     |
     └── Interface
```

Abstract class:

```text
abstract class
     |
     ├── abstract methods
     ├── concrete methods
     ├── variables
     ├── constructors
     ├── static methods
     ├── final methods
     └── private methods
```

Interface:

```text
interface
     |
     ├── abstract methods
     ├── default methods
     ├── static methods
     ├── private methods
     └── public static final fields
```

Remember:

```text
Abstract class
    ↓
Shared state + shared implementation + abstraction

Interface
    ↓
Contract + multiple implementations + loose coupling
```

---

# 54. Golden Interview Rule

> **Abstraction is NOT simply "hiding data."**

A stronger definition is:

> **Abstraction means hiding implementation complexity and exposing only the essential behavior or contract that the client needs.**

Remember:

```text
Encapsulation → Protect data
Abstraction   → Hide complexity
Inheritance   → Reuse behavior
Polymorphism  → Multiple forms
```

---

# 55. Final Cheat Sheet

| Concept | Remember |
|---|---|
| Abstraction | Hide implementation details |
| Main goal | Expose essential functionality |
| Java mechanisms | Abstract class + Interface |
| Abstract class | Cannot instantiate directly |
| Abstract method | No implementation body |
| Concrete method | Has implementation |
| Concrete class | Can instantiate |
| Abstract class constructor | ✅ Yes |
| Abstract class variables | ✅ Yes |
| Abstract class concrete methods | ✅ Yes |
| Abstract class static methods | ✅ Yes |
| Abstract class final methods | ✅ Yes |
| Abstract class private methods | ✅ Yes |
| Abstract class with zero abstract methods | ✅ Yes |
| Abstract method final | ❌ No |
| Abstract method static | ❌ No |
| Abstract method private | ❌ No |
| Abstract class final | ❌ No |
| Interface constructor | ❌ No |
| Interface variables | `public static final` |
| Interface default method | ✅ Yes |
| Interface static method | ✅ Yes |
| Interface private method | ✅ Yes |
| Multiple interfaces | ✅ Yes |
| Multiple abstract classes | ❌ No |
| Interface extends interface | ✅ Yes |
| Interface extends multiple interfaces | ✅ Yes |
| Abstract class implements interface | ✅ Yes |
| Abstract class reference | Can point to child |
| Interface reference | Can point to implementation |
| Abstraction + overriding | Runtime polymorphism |
| Abstraction vs encapsulation | Hide complexity vs control state |
| Abstraction vs inheritance | Define essential behavior vs reuse |
| Abstraction vs polymorphism | Hide complexity vs multiple forms |

---

# ☕ End of Java Abstraction Notes

> If you can explain the difference between an abstract class and an interface, explain why abstract classes cannot be instantiated, explain abstract methods, constructors, default methods, interface variables, and answer the `abstract + final`, `abstract + static`, and `abstract + private` questions, you are well-prepared for most Java Abstraction questions in a technical interview.
