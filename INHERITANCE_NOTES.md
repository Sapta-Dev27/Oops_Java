# ☕ Java Inheritance — Complete Interview Guide

> Complete end-to-end Java Inheritance notes for technical interviews.
>
> Covers inheritance, all types of inheritance, `extends`, `implements`, interfaces, multiple inheritance, Diamond Problem, hybrid inheritance, method overriding, runtime polymorphism, `super`, `this`, constructors, `static`, `final`, `private`, abstract classes, composition, access modifiers, and interview questions.

---

# 📚 Table of Contents

1. What is Inheritance?
2. Important Terminology
3. IS-A Relationship
4. `extends` Keyword
5. Types of Inheritance
6. Single Inheritance
7. Multilevel Inheritance
8. Hierarchical Inheritance
9. Multiple Inheritance
10. Diamond Problem
11. Interfaces and Multiple Inheritance
12. Default Method Conflict
13. Hybrid Inheritance
14. Advantages of Inheritance
15. Disadvantages of Inheritance
16. Inheritance and Polymorphism
17. Method Overriding
18. `super` Keyword
19. `this` vs `super`
20. Constructors and Inheritance
21. What Gets Inherited?
22. `private` Methods
23. `static` Methods
24. `final` Methods
25. `final` Classes
26. Abstract Classes
27. Inheritance vs Composition
28. `extends` vs `implements`
29. Access Modifiers
30. Important Rules
31. Complete Interview Questions
32. Tricky Interview Questions
33. Rapid Fire Round
34. Perfect Interview Answer
35. Final Revision Map
36. 15 Things to Remember
37. Final Interview Checklist

---

# 1. What is Inheritance?

Inheritance is an OOP mechanism where a child class acquires accessible properties and methods of a parent class.

## Simple Example

    class Animal {

        void eat() {
            System.out.println("Eating");
        }
    }

    class Dog extends Animal {

        void bark() {
            System.out.println("Barking");
        }
    }

Now:

    Dog d = new Dog();

    d.eat();   // inherited from Animal
    d.bark();  // Dog's own method

Output:

    Eating
    Barking

## Interview Definition

> Inheritance is an OOP mechanism in which a subclass acquires accessible properties and behaviors from a superclass and can extend or override them.

## Why do we use inheritance?

1. Code Reusability
2. Maintainability
3. Extensibility
4. Polymorphism

---

# 2. Important Terminology

## Superclass / Parent Class

The class from which another class inherits.

    class Animal {
    }

`Animal` is the superclass.

---

## Subclass / Child Class

The class that inherits from another class.

    class Dog extends Animal {
    }

`Dog` is the subclass.

---

## Base Class

Another name for:

- Parent Class
- Superclass

---

## Derived Class

Another name for:

- Child Class
- Subclass

---

# 3. IS-A Relationship

Inheritance represents an **IS-A relationship**.

Examples:

    Dog IS-A Animal
    Car IS-A Vehicle
    Manager IS-A Employee

Therefore:

    class Dog extends Animal {
    }

makes logical sense.

## Easy Rule

    IS-A  → Inheritance
    HAS-A → Composition

---

# 4. `extends` Keyword

`extends` is used for inheritance between classes.

    class Animal {
    }

    class Dog extends Animal {
    }

It can also be used when one interface extends another interface.

    interface Animal {
    }

    interface Mammal extends Animal {
    }

Remember:

    class → class
            extends

    interface → interface
                extends

---

# 5. Types of Inheritance

The major types are:

1. Single Inheritance
2. Multilevel Inheritance
3. Hierarchical Inheritance
4. Multiple Inheritance
5. Hybrid Inheritance

## Diagrams

### Single

    A
    |
    B

### Multilevel

    A
    |
    B
    |
    C

### Hierarchical

        A
       / \
      B   C

### Multiple

    A     B
     \   /
       C

### Hybrid

        A
       / \
      B   C
      |
      D

---

# 6. Single Inheritance

Single inheritance means:

> One child class inherits from one parent class.

Diagram:

    Animal
       |
      Dog

Example:

    class Animal {

        void eat() {
            System.out.println("Eating");
        }
    }

    class Dog extends Animal {

        void bark() {
            System.out.println("Barking");
        }
    }

Usage:

    Dog d = new Dog();

    d.eat();
    d.bark();

Output:

    Eating
    Barking

## Interview Definition

> Single inheritance occurs when one subclass inherits from one superclass.

---

# 7. Multilevel Inheritance

Multilevel inheritance occurs when inheritance happens in a chain.

Diagram:

    Animal
       |
    Mammal
       |
      Dog

Example:

    class Animal {

        void eat() {
            System.out.println("Eating");
        }
    }

    class Mammal extends Animal {

        void walk() {
            System.out.println("Walking");
        }
    }

    class Dog extends Mammal {

        void bark() {
            System.out.println("Barking");
        }
    }

Usage:

    Dog d = new Dog();

    d.eat();   // Animal
    d.walk();  // Mammal
    d.bark();  // Dog

Output:

    Eating
    Walking
    Barking

## Interview Definition

> Multilevel inheritance is a chain of inheritance where a class inherits from another derived class.

---

# 8. Hierarchical Inheritance

Hierarchical inheritance means:

> Multiple child classes inherit from the same parent class.

Diagram:

        Animal
        /    \
      Dog    Cat

Example:

    class Animal {

        void eat() {
            System.out.println("Eating");
        }
    }

    class Dog extends Animal {

        void bark() {
            System.out.println("Barking");
        }
    }

    class Cat extends Animal {

        void meow() {
            System.out.println("Meowing");
        }
    }

Usage:

    Dog d = new Dog();
    d.eat();
    d.bark();

    Cat c = new Cat();
    c.eat();
    c.meow();

Both `Dog` and `Cat` inherit `eat()`.

## Interview Definition

> Hierarchical inheritance occurs when multiple subclasses inherit from the same superclass.

---

# 9. Multiple Inheritance

Multiple inheritance means:

> One class inherits from multiple parent classes.

Diagram:

      A       B
       \     /
         C

Some languages such as C++ allow:

    class C : public A, public B {
    };

But Java does **NOT** allow multiple inheritance through classes.

This is invalid:

    class A {
    }

    class B {
    }

    class C extends A, B {
    }

The main reason is ambiguity.

This leads to the:

> Diamond Problem

---

# 10. Diamond Problem

Suppose Java allowed multiple class inheritance.

Imagine:

        Animal
        /    \
      Dog    Cat
        \    /
        Hybrid

Suppose:

    class Animal {

        void sound() {
            System.out.println("Animal sound");
        }
    }

    class Dog extends Animal {

        @Override
        void sound() {
            System.out.println("Dog sound");
        }
    }

    class Cat extends Animal {

        @Override
        void sound() {
            System.out.println("Cat sound");
        }
    }

Now imagine Java allowed:

    class Hybrid extends Dog, Cat {
    }

Then:

    Hybrid h = new Hybrid();

    h.sound();

Which method should execute?

    Dog.sound()
        OR
    Cat.sound()

This creates ambiguity.

This is the **Diamond Problem**.

## Why does Java avoid multiple class inheritance?

Java avoids multiple inheritance through classes to prevent ambiguity and make the object model simpler.

## Interview Answer

> Java doesn't support multiple inheritance through classes because it can create ambiguity when multiple parent classes provide the same method. This is commonly called the Diamond Problem.

---

# 11. Interfaces and Multiple Inheritance

Java uses interfaces to achieve **multiple inheritance of type**.

Example:

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

Diagram:

    Camera       GPS
       \         /
        \       /
       Smartphone

A class can implement multiple interfaces:

    class Smartphone implements Camera, GPS {
    }

## Why does this work?

The interfaces define contracts:

    Camera → "You must provide takePhoto()"

    GPS → "You must provide navigate()"

And `Smartphone` provides the implementations.

Therefore, there is no ambiguity in this basic case.

## Not Allowed

    class C extends A, B {
    }

## Allowed

    class C implements A, B {
    }

## Interview Answer

> Java does not support multiple inheritance through classes, but it supports multiple inheritance of type through interfaces. A class can implement multiple interfaces.

---

# 12. Default Method Conflict

Java 8 introduced `default` methods in interfaces.

Example:

    interface A {

        default void show() {
            System.out.println("A");
        }
    }

    interface B {

        default void show() {
            System.out.println("B");
        }
    }

Now:

    class C implements A, B {
    }

This creates a conflict.

Which `show()` should `C` use?

    A.show()
        OR
    B.show()

Java forces the class to resolve it.

## Solution 1: Override the Method

    class C implements A, B {

        @Override
        public void show() {
            System.out.println("C");
        }
    }

## Solution 2: Explicitly Call One Interface

    class C implements A, B {

        @Override
        public void show() {
            A.super.show();
        }
    }

Output:

    A

## Interview Question

**Q: What happens if two interfaces have the same default method?**

### Answer

> The implementing class must resolve the conflict by overriding the method or explicitly calling a specific interface's default implementation.

---

# 13. Hybrid Inheritance

Hybrid inheritance is a **combination of two or more types of inheritance**.

Example:

          Animal
         /      \
       Dog      Cat
       |
     Puppy

Here:

    Animal → Dog
    = Single

    Animal → Dog → Puppy
    = Multilevel

    Animal → Dog + Cat
    = Hierarchical

Together:

    Hybrid Inheritance

## Does Java support hybrid inheritance?

Java does not support hybrid inheritance involving **multiple class inheritance**.

However, similar structures can be created using:

    Class inheritance + Interfaces

Example:

    class Animal {

        void eat() {
            System.out.println("Eating");
        }
    }

    class Dog extends Animal {

        void bark() {
            System.out.println("Barking");
        }
    }

    interface Pet {

        void play();
    }

    interface Guard {

        void protect();
    }

    class Puppy extends Dog implements Pet, Guard {

        @Override
        public void play() {
            System.out.println("Playing");
        }

        @Override
        public void protect() {
            System.out.println("Protecting");
        }
    }

Diagram:

                 Animal
                    |
                   Dog
                    |
                  Puppy
                 /     \
              Pet     Guard

---

# 14. Advantages of Inheritance

## 1. Code Reusability

Common code can be written in the parent class.

    class Animal {

        void eat() {
            System.out.println("Eating");
        }
    }

Child classes can reuse it:

    class Dog extends Animal {
    }

    class Cat extends Animal {
    }

Both get:

    eat()

---

## 2. Maintainability

Common functionality can be maintained in one place.

Instead of changing:

    Dog
    Cat
    Horse
    Cow

separately, common behavior can be placed in:

    Animal

---

## 3. Extensibility

We can create new subclasses without changing the existing parent.

    class Horse extends Animal {
    }

---

## 4. Polymorphism

Inheritance enables runtime polymorphism through method overriding.

    Animal a = new Dog();

    a.sound();

---

# 15. Disadvantages of Inheritance

## 1. Tight Coupling

Child classes depend strongly on parent classes.

    Parent changes
         ↓
    Child may be affected

---

## 2. Complexity

Deep inheritance hierarchies can become difficult to understand.

    Animal
       ↓
    Mammal
       ↓
      Dog
       ↓
    GermanShepherd
       ↓
    PoliceDog

It can become difficult to determine where a method or variable comes from.

---

## 3. Reduced Flexibility

A subclass is strongly connected to the superclass.

This is why developers often prefer:

> **Composition over inheritance**

when an IS-A relationship does not genuinely exist.

---

# 16. Inheritance and Polymorphism

Inheritance is closely connected with **runtime polymorphism**.

Example:

    class Animal {

        void sound() {
            System.out.println("Animal sound");
        }
    }

    class Dog extends Animal {

        @Override
        void sound() {
            System.out.println("Dog barks");
        }
    }

Now:

    Animal a = new Dog();

    a.sound();

Output:

    Dog barks

Why?

    Reference type → Animal
    Actual object  → Dog

The actual object's overridden method is selected at runtime.

This is:

> **Runtime Polymorphism**

Also called:

> **Dynamic Method Dispatch**

## Important Concept

    Animal a = new Dog();

means:

    Reference → Animal
    Object    → Dog

The reference determines what members are accessible at compile time.

The actual object determines which overridden instance method executes at runtime.

---

# 17. Method Overriding

Method overriding occurs when a child class provides its own implementation of a method inherited from the parent.

Example:

    class Animal {

        void sound() {
            System.out.println("Animal");
        }
    }

    class Dog extends Animal {

        @Override
        void sound() {
            System.out.println("Dog");
        }
    }

The child provides a new implementation.

## `@Override`

`@Override` tells the compiler:

> "I intend to override a method from the parent."

Example:

    @Override
    void sound() {
        System.out.println("Dog");
    }

It helps catch mistakes.

---

# 18. `super` Keyword

`super` refers to the parent-class portion of the current object.

There are three important uses.

## 1. Access Parent Variable

    super.x;

Example:

    class Parent {

        int x = 10;
    }

    class Child extends Parent {

        int x = 20;

        void show() {
            System.out.println(x);
            System.out.println(super.x);
        }
    }

Output:

    20
    10

---

## 2. Call Parent Method

    super.show();

Example:

    class Animal {

        void sound() {
            System.out.println("Animal");
        }
    }

    class Dog extends Animal {

        @Override
        void sound() {

            super.sound();

            System.out.println("Dog");
        }
    }

Output:

    Animal
    Dog

---

## 3. Call Parent Constructor

    super();

Example:

    class Parent {

        Parent() {
            System.out.println("Parent constructor");
        }
    }

    class Child extends Parent {

        Child() {
            super();
            System.out.println("Child constructor");
        }
    }

---

# 19. `this` vs `super`

| `this` | `super` |
|---|---|
| Refers to current object | Refers to parent class |
| Current class member | Parent class member |
| `this.x` | `super.x` |
| `this.show()` | `super.show()` |
| `this()` | `super()` |

## Easy Memory Trick

    this  → current
    super → parent

---

# 20. Constructors and Inheritance

## Are constructors inherited?

**NO.**

Example:

    class Parent {

        Parent() {
            System.out.println("Parent");
        }
    }

    class Child extends Parent {

        Child() {
            System.out.println("Child");
        }
    }

Now:

    Child c = new Child();

Output:

    Parent
    Child

The parent constructor executes first.

Conceptually:

    Child()
       ↓
    super()
       ↓
    Parent()

## Important

Constructors:

    ❌ Are not inherited
    ❌ Cannot be overridden
    ✅ Are called during object creation
    ✅ Can be overloaded

---

## What if the child constructor does not explicitly call `super()`?

Java automatically inserts:

    super();

if a valid no-argument parent constructor exists.

Example:

    class Parent {

        Parent() {
            System.out.println("Parent");
        }
    }

    class Child extends Parent {

        Child() {
            // Compiler implicitly adds super();
            System.out.println("Child");
        }
    }

---

## What if the parent has only a parameterized constructor?

Example:

    class Parent {

        Parent(int x) {
            System.out.println(x);
        }
    }

    class Child extends Parent {

        Child() {
            // ❌ Compile-time error
        }
    }

Why?

Because Java tries to insert:

    super();

but `Parent()` does not exist.

Solution:

    class Child extends Parent {

        Child() {
            super(10);
        }
    }

---

# 21. What Gets Inherited?

Don't simply say:

> "Everything from the parent is inherited."

Access modifiers matter.

| Parent Member | Child Access |
|---|---|
| `public` | Accessible |
| `protected` | Accessible subject to protected rules |
| default/package-private | Accessible within same package |
| `private` | Not directly accessible |
| Constructor | Not inherited |

## Private State Example

    class Parent {

        private int x = 10;
    }

    class Child extends Parent {

        void show() {
            // System.out.println(x); // ❌
        }
    }

The private field belongs to the parent class and cannot be directly accessed by the child.

---

# 22. `private` Methods

A `private` method cannot be overridden.

Example:

    class Parent {

        private void show() {
            System.out.println("Parent");
        }
    }

Child:

    class Child extends Parent {

        void show() {
            System.out.println("Child");
        }
    }

This is **NOT overriding**.

The two methods are unrelated because the parent's method is private.

## Interview Answer

> Private methods cannot be overridden because they are not accessible to subclasses.

## Important

Private methods **can be overloaded**.

Example:

    class Test {

        private void show() {
        }

        private void show(int x) {
        }
    }

This is valid.

---

# 23. `static` Methods

Static methods belong to the **class**, not to individual objects.

Example:

    class Parent {

        static void show() {
            System.out.println("Parent");
        }
    }

    class Child extends Parent {
    }

The static method can be accessed through the child:

    Child.show();

## Can static methods be overridden?

**NO.**

Static methods are:

> **Hidden, not overridden.**

Example:

    class Parent {

        static void show() {
            System.out.println("Parent");
        }
    }

    class Child extends Parent {

        static void show() {
            System.out.println("Child");
        }
    }

This is called:

> **Method Hiding**

---

## Static Method Example

    class Parent {

        static void show() {
            System.out.println("Parent");
        }
    }

    class Child extends Parent {

        static void show() {
            System.out.println("Child");
        }
    }

    public class Main {

        public static void main(String[] args) {

            Parent p = new Child();

            p.show();
        }
    }

Output:

    Parent

Why?

Because static method selection is based on the reference/class, not runtime object dispatch.

---

## Can static methods be overloaded?

Yes.

    class Test {

        static void show() {
        }

        static void show(int x) {
        }
    }

This is valid.

---

# 24. `final` Methods

A `final` method cannot be overridden.

Example:

    class Parent {

        final void show() {
            System.out.println("Parent");
        }
    }

    class Child extends Parent {

        // ❌ Cannot override
        /*
        @Override
        void show() {
            System.out.println("Child");
        }
        */
    }

But the child can use the method:

    class Child extends Parent {

        void test() {
            show(); // ✅
        }
    }

Therefore:

    final method
         |
         ├── Can be inherited/used → YES
         |
         └── Can be overridden → NO

## Interview Answer

> A final method can be inherited if accessible, but it cannot be overridden.

## Can final methods be overloaded?

Yes.

    class Parent {

        final void show() {
        }

        final void show(int x) {
        }
    }

This is valid.

`final` prevents overriding, not overloading.

---

# 25. `final` Classes

A `final` class cannot be extended.

Example:

    final class Animal {

        void eat() {
            System.out.println("Eating");
        }
    }

This is invalid:

    class Dog extends Animal {
        // ❌ Compile-time error
    }

## Interview Answer

> A final class cannot be inherited or extended.

## Why make a class final?

To prevent other classes from extending it and changing its behavior through inheritance.

---

# 26. Abstract Classes

An abstract class can be inherited.

Example:

    abstract class Animal {

        void eat() {
            System.out.println("Eating");
        }

        abstract void sound();
    }

Child:

    class Dog extends Animal {

        @Override
        void sound() {
            System.out.println("Bark");
        }
    }

An abstract class can contain:

- Abstract methods
- Concrete methods
- Variables
- Constructors

## Can we create an object of an abstract class?

No.

    Animal a = new Animal(); // ❌

But:

    Animal a = new Dog(); // ✅

This is also an example of runtime polymorphism.

---

## Can an abstract class have a constructor?

Yes.

    abstract class Animal {

        Animal() {
            System.out.println("Animal constructor");
        }
    }

The constructor executes when a subclass object is created.

---

## Can an abstract class have concrete methods?

Yes.

    abstract class Animal {

        void eat() {
            System.out.println("Eating");
        }

        abstract void sound();
    }

---

## Can an abstract class be final?

No.

This is invalid:

    final abstract class A {
    }

Why?

Because:

    abstract → must be extended
    final    → cannot be extended

These concepts conflict.

---

# 27. Inheritance vs Composition

## Inheritance

    class Dog extends Animal {
    }

Means:

    Dog IS-A Animal

---

## Composition

    class Car {

        Engine engine;
    }

Means:

    Car HAS-A Engine

## Easy Rule

    IS-A  → Inheritance
    HAS-A → Composition

## Examples

    Dog IS-A Animal
    Car HAS-A Engine
    House HAS-A Room
    Computer HAS-A Processor

## Why is composition often preferred?

Composition usually provides:

- Lower coupling
- Greater flexibility
- Easier replacement of components
- Better control over dependencies

---

# 28. `extends` vs `implements`

| `extends` | `implements` |
|---|---|
| Class extends class | Class implements interface |
| Interface extends interface | Class can implement interfaces |
| Class can extend only one class | Class can implement multiple interfaces |

## Class → Class

    class Dog extends Animal {
    }

## Class → Interface

    class Dog implements Pet {
    }

## Interface → Interface

    interface Mammal extends Animal {
    }

## Multiple Interfaces

    class Dog implements Pet, Guard, Runnable {
    }

---

# 29. Access Modifiers

## `public`

Accessible from anywhere, subject to Java access/module rules.

    public int x;

---

## `protected`

Accessible in the same package and through subclasses according to Java's protected-access rules.

    protected int x;

---

## Default / Package-Private

No modifier.

Accessible within the same package.

    int x;

---

## `private`

Accessible only within the declaring class.

    private int x;

---

# 30. Important Rules

## Rule 1: A class can extend only one class

Allowed:

    class C extends A {
    }

Not allowed:

    class C extends A, B {
    }

---

## Rule 2: A class can implement multiple interfaces

Allowed:

    class C implements A, B, C {
    }

---

## Rule 3: An interface can extend multiple interfaces

Allowed:

    interface C extends A, B {
    }

---

## Rule 4: Constructors are not inherited

    Constructor → ❌ Inherited

---

## Rule 5: Constructors cannot be overridden

    Constructor → ❌ Overridden

---

## Rule 6: Private methods cannot be overridden

    private → ❌ Override

---

## Rule 7: Static methods are hidden, not overridden

    static → Method Hiding

---

## Rule 8: Final methods cannot be overridden

    final method → ❌ Override

---

## Rule 9: Final classes cannot be extended

    final class → ❌ Inherit

---

## Rule 10: Abstract classes can be extended

    abstract class → ✅ Extend

---

# 31. Complete Interview Questions

## Q1. What is inheritance?

### Answer

> Inheritance is an OOP mechanism where a subclass acquires accessible properties and behaviors from a superclass.

---

## Q2. Why is inheritance used?

### Answer

> Inheritance is mainly used for code reusability, maintainability, extensibility, and polymorphism.

---

## Q3. What is a superclass?

The parent class from which another class inherits.

---

## Q4. What is a subclass?

The child class that inherits from another class.

---

## Q5. What keyword is used for class inheritance?

    extends

---

## Q6. What is an IS-A relationship?

It represents inheritance.

Example:

    Dog IS-A Animal

---

## Q7. What are the types of inheritance?

    Single
    Multilevel
    Hierarchical
    Multiple
    Hybrid

---

## Q8. What is single inheritance?

One child inherits from one parent.

    A
    |
    B

---

## Q9. What is multilevel inheritance?

A chain of inheritance.

    A
    |
    B
    |
    C

---

## Q10. What is hierarchical inheritance?

Multiple children inherit from one parent.

        A
       / \
      B   C

---

## Q11. What is multiple inheritance?

One class inherits from multiple parent classes.

Java does not support this through classes.

---

## Q12. Does Java support multiple inheritance?

### Answer

> Java does not support multiple inheritance through classes, but it supports multiple inheritance of type through interfaces.

---

## Q13. Why doesn't Java support multiple class inheritance?

### Answer

Because it can create ambiguity such as the Diamond Problem.

---

## Q14. What is the Diamond Problem?

### Answer

> It is ambiguity that can occur when a class inherits the same method through multiple parent paths and the language cannot determine which implementation to use.

---

## Q15. How does Java solve the Diamond Problem?

### Answer

> Java avoids multiple inheritance through classes and allows multiple interfaces. Conflicting default methods must be resolved explicitly by the implementing class.

---

## Q16. Can Java achieve multiple inheritance?

Yes, through multiple interfaces.

    class C implements A, B {
    }

---

## Q17. Can a class extend multiple classes?

No.

    class C extends A, B {
    }

---

## Q18. Can a class implement multiple interfaces?

Yes.

    class C implements A, B {
    }

---

## Q19. Can an interface extend multiple interfaces?

Yes.

    interface C extends A, B {
    }

---

## Q20. What is hybrid inheritance?

A combination of two or more inheritance types.

---

## Q21. Does Java support hybrid inheritance?

Java does not support hybrid inheritance involving multiple class inheritance, but similar designs can be created using class inheritance and interfaces.

---

## Q22. What is method overriding?

When a child class provides its own implementation of a parent instance method.

---

## Q23. What is runtime polymorphism?

When a parent reference points to a child object and the overridden instance method is selected at runtime.

Example:

    Animal a = new Dog();

    a.sound();

---

## Q24. What is `super`?

`super` refers to the parent-class portion of the current object.

It can be used for:

- Parent variable
- Parent method
- Parent constructor

---

## Q25. What is `this`?

`this` refers to the current object.

---

## Q26. Difference between `this` and `super`?

    this  → Current object
    super → Parent class

---

## Q27. Are constructors inherited?

No.

---

## Q28. Can constructors be overridden?

No.

---

## Q29. Can private methods be overridden?

No.

---

## Q30. Can static methods be overridden?

No.

Static methods are hidden.

---

## Q31. Can static methods be inherited?

An accessible static method can be available through a subclass.

However, static methods do not participate in runtime overriding.

---

## Q32. Can final methods be inherited?

Yes, if accessible.

But they cannot be overridden.

---

## Q33. Can final classes be inherited?

No.

---

## Q34. Can abstract classes be inherited?

Yes.

---

## Q35. Can private variables be directly accessed from a child?

No.

---

## Q36. Can protected members be accessed by subclasses?

Yes, subject to Java's protected-access rules.

---

# 32. Tricky Interview Questions

## Q37. Is a final method inherited?

### Answer

Yes, if accessible.

    Inherited → YES
    Overridden → NO

---

## Q38. Is a final class inherited?

### Answer

No.

A final class cannot be extended.

---

## Q39. Is a static method inherited?

An accessible static method can be inherited/used through a subclass.

But:

    Overridden → NO
    Hidden     → YES

---

## Q40. Why can't static methods be overridden?

Because static methods belong to the class and are resolved using class/reference information rather than runtime dynamic dispatch.

---

## Q41. If a child has the same static method as parent, what happens?

It is **method hiding**, not overriding.

---

## Q42. If a child has the same private method as parent, is it overriding?

No.

The parent private method is not visible to the child.

---

## Q43. Can a final method be overloaded?

Yes.

Example:

    class Parent {

        final void show() {
        }

        final void show(int x) {
        }
    }

`final` prevents overriding, not overloading.

---

## Q44. Can static methods be overloaded?

Yes.

Example:

    class Test {

        static void show() {
        }

        static void show(int x) {
        }
    }

---

## Q45. Can private methods be overloaded?

Yes.

Example:

    class Test {

        private void show() {
        }

        private void show(int x) {
        }
    }

---

## Q46. Can constructors be overloaded?

Yes.

Example:

    class Student {

        Student() {
        }

        Student(int age) {
        }
    }

Constructors can be overloaded but not inherited or overridden.

---

## Q47. Can an abstract class have a constructor?

Yes.

Example:

    abstract class Animal {

        Animal() {
            System.out.println("Animal constructor");
        }
    }

---

## Q48. Can an abstract class have concrete methods?

Yes.

Example:

    abstract class Animal {

        void eat() {
            System.out.println("Eating");
        }

        abstract void sound();
    }

---

## Q49. Can an abstract class be final?

No.

    final abstract class A {
    }

This is invalid because:

    abstract → must be extended
    final    → cannot be extended

---

## Q50. Can an interface extend multiple interfaces?

Yes.

Example:

    interface A {
    }

    interface B {
    }

    interface C extends A, B {
    }

---

## Q51. Can a class extend a class and implement interfaces at the same time?

Yes.

Example:

    class Dog extends Animal implements Pet, Guard {
    }

This is very important for hybrid designs.

---

# 33. Rapid Fire Round

| Question | Answer |
|---|---|
| Inheritance keyword? | `extends` |
| Interface implementation keyword? | `implements` |
| Multiple class inheritance? | ❌ No |
| Multiple interface implementation? | ✅ Yes |
| Interface extends multiple interfaces? | ✅ Yes |
| Constructor inherited? | ❌ No |
| Constructor overridden? | ❌ No |
| Constructor overloaded? | ✅ Yes |
| Private method overridden? | ❌ No |
| Private method overloaded? | ✅ Yes |
| Static method overridden? | ❌ No |
| Static method hidden? | ✅ Yes |
| Static method overloaded? | ✅ Yes |
| Final method overridden? | ❌ No |
| Final method inherited? | ✅ If accessible |
| Final method overloaded? | ✅ Yes |
| Final class inherited? | ❌ No |
| Abstract class inherited? | ✅ Yes |
| Abstract class final? | ❌ No |
| `this` means? | Current object |
| `super` means? | Parent class |
| IS-A? | Inheritance |
| HAS-A? | Composition |
| Diamond Problem? | Multiple inheritance ambiguity |
| Runtime polymorphism? | Method overriding |
| `@Override`? | Verifies intended overriding |
| `extends` for? | Class/interface inheritance |
| `implements` for? | Class implementing interface |

---

# 34. Perfect Interview Answer

If the interviewer asks:

> **"Explain inheritance in Java."**

You can answer:

> "Inheritance is an OOP mechanism where a subclass acquires accessible properties and methods from a superclass. In Java, class inheritance is implemented using the `extends` keyword. It promotes code reusability, maintainability, extensibility, and enables runtime polymorphism through method overriding.
>
> Java supports single, multilevel, and hierarchical inheritance through classes. It does not support multiple inheritance through classes because it can cause ambiguity, commonly known as the Diamond Problem. However, Java supports multiple inheritance of type through interfaces, where a class can implement multiple interfaces.
>
> Constructors are not inherited, private methods cannot be overridden, static methods are hidden rather than overridden, and final methods cannot be overridden."

---

# 35. Final Revision Map

    INHERITANCE
          |
          ├──────────────────────────────┐
          |                              |
       Concepts                         Types
          |                              |
     ┌────┼────┐             ┌──────────┼──────────┐
     |    |    |             |          |          |
   Parent Child IS-A       Single   Multilevel  Hierarchical
     |
   extends
     |
   Subclass
     
   Multiple
      |
   Interfaces
      |
   Diamond Problem
      |
   Hybrid

Inheritance
     |
     ├── Method Overriding
     │       |
     │       └── Runtime Polymorphism
     |
     ├── super
     │
     ├── Constructors
     │       └── Not inherited
     |
     ├── private
     │       └── Cannot override
     |
     ├── static
     │       └── Hiding, not overriding
     |
     ├── final method
     │       └── Cannot override
     |
     ├── final class
     │       └── Cannot extend
     |
     └── Composition
             └── HAS-A

---

# 36. 15 Things to Remember

    1. Inheritance = IS-A relationship

    2. extends = class inheritance

    3. implements = class implementing interface

    4. Single inheritance = one parent → one child

    5. Multilevel inheritance = A → B → C

    6. Hierarchical inheritance = one parent → multiple children

    7. Java does NOT support multiple inheritance through classes

    8. Java supports multiple interface implementation

    9. Diamond Problem = ambiguity in multiple inheritance

    10. Constructors are NOT inherited

    11. final method → can be inherited, but CANNOT be overridden

    12. final class → CANNOT be extended

    13. static method → hidden, NOT overridden

    14. private method → CANNOT be overridden

    15. Inheritance + overriding → Runtime Polymorphism

---

# 🧠 One-Line Memory Trick

> **`extends` → one class | `implements` → multiple interfaces | `super` → parent | `this` → current object | `final` → stop overriding/inheritance | `static` → class-level/hiding | `private` → class-only | `@Override` → overriding | IS-A → inheritance | HAS-A → composition**

---

# 37. Final Interview Checklist

Before an interview, make sure you can explain these without looking at notes:

- [ ] What is inheritance?
- [ ] Parent vs Child class
- [ ] Superclass vs Subclass
- [ ] IS-A relationship
- [ ] `extends`
- [ ] `implements`
- [ ] Single inheritance
- [ ] Multilevel inheritance
- [ ] Hierarchical inheritance
- [ ] Multiple inheritance
- [ ] Hybrid inheritance
- [ ] Diamond Problem
- [ ] Why Java doesn't support multiple class inheritance
- [ ] How interfaces provide multiple inheritance of type
- [ ] Interface default method conflict
- [ ] Advantages of inheritance
- [ ] Disadvantages of inheritance
- [ ] Method overriding
- [ ] Runtime polymorphism
- [ ] Dynamic method dispatch
- [ ] `this`
- [ ] `super`
- [ ] Parent constructor
- [ ] Constructor inheritance
- [ ] Constructor overriding
- [ ] Constructor overloading
- [ ] Private methods
- [ ] Static methods
- [ ] Method hiding
- [ ] Final methods
- [ ] Final classes
- [ ] Abstract classes
- [ ] Abstract methods
- [ ] Access modifiers
- [ ] Inheritance vs Composition
- [ ] IS-A vs HAS-A
- [ ] `extends` vs `implements`
- [ ] Final method inheritance
- [ ] Static method inheritance
- [ ] Private method overriding
- [ ] Default interface method conflict
- [ ] Multiple interface inheritance
- [ ] Class + multiple interfaces

---

# 🚀 Quick Summary

    Inheritance
        ↓
    Reuse parent functionality
        ↓
    extends
        ↓
    IS-A relationship
        ↓
    Single / Multilevel / Hierarchical
        ↓
    Multiple class inheritance ❌
        ↓
    Interfaces → Multiple inheritance of type ✅
        ↓
    Diamond Problem → ambiguity
        ↓
    Method Overriding
        ↓
    Runtime Polymorphism
        ↓
    super → parent
    this → current object
        ↓
    final → cannot override/extend
    static → hiding, not overriding
    private → not directly accessible / not overridden
    constructor → not inherited
        ↓
    Composition → HAS-A

---

# ⭐ Final Interview Golden Rule

> **Don't just memorize definitions. Explain every concept using a small class diagram + Java code + a real-world example.**

For example:

       Animal
       /    \
     Dog    Cat

    class Animal {

        void eat() {
            System.out.println("Eating");
        }

        void sound() {
            System.out.println("Animal sound");
        }
    }

    class Dog extends Animal {

        @Override
        void sound() {
            System.out.println("Dog barks");
        }

        void bark() {
            System.out.println("Barking");
        }
    }

Then explain:

    Dog IS-A Animal
           ↓
    Dog inherits eat()
           ↓
    Dog can add bark()
           ↓
    Dog can override Animal methods
           ↓
    Animal reference can point to Dog object
           ↓
    Runtime polymorphism occurs

---

# 🎯 Most Important Interview Connections

    Inheritance
         |
         ├── extends
         |
         ├── IS-A
         |
         ├── Code Reuse
         |
         ├── Method Overriding
         |       |
         |       └── Runtime Polymorphism
         |
         ├── super
         |       ├── Parent variable
         |       ├── Parent method
         |       └── Parent constructor
         |
         ├── Multiple Inheritance
         |       |
         |       ├── Classes → ❌
         |       |
         |       └── Interfaces → ✅
         |
         ├── Diamond Problem
         |
         ├── final
         |       ├── final method → cannot override
         |       └── final class → cannot extend
         |
         ├── static
         |       └── method hiding
         |
         ├── private
         |       └── cannot override
         |
         └── Composition
                 |
                 └── HAS-A

---

# 🏆 Java Inheritance Cheat Sheet

| Concept | Remember |
|---|---|
| Inheritance | Child gets accessible parent functionality |
| Parent | Superclass |
| Child | Subclass |
| `extends` | Class inheritance |
| `implements` | Interface implementation |
| IS-A | Inheritance |
| HAS-A | Composition |
| Single | A → B |
| Multilevel | A → B → C |
| Hierarchical | A → B and A → C |
| Multiple classes | ❌ Java |
| Multiple interfaces | ✅ Java |
| Hybrid | Combination of inheritance types |
| Diamond Problem | Ambiguity |
| Overriding | Child changes inherited instance method behavior |
| Runtime polymorphism | Parent reference + child object |
| `super` | Parent |
| `this` | Current object |
| Constructor | Not inherited |
| Constructor overloading | ✅ |
| Constructor overriding | ❌ |
| `private` method overriding | ❌ |
| `static` overriding | ❌ |
| Static method hiding | ✅ |
| `final` method overriding | ❌ |
| `final` method inherited | ✅ If accessible |
| `final` class inheritance | ❌ |
| Abstract class inheritance | ✅ |
| Interface default conflict | Child must resolve |
| `@Override` | Compiler checks intended override |

---

# 📌 Final One-Minute Revision

    Inheritance = IS-A

    extends = class inheritance

    implements = interface implementation

    Single:
    A → B

    Multilevel:
    A → B → C

    Hierarchical:
        A
       / \
      B   C

    Multiple:
    A + B → C

    ❌ Through classes
    ✅ Through interfaces

    Diamond Problem:
    Ambiguity from multiple inheritance paths

    Method Overriding:
    Child provides new implementation

    Runtime Polymorphism:
    Animal a = new Dog();

    super:
    Parent

    this:
    Current object

    final method:
    Can be inherited
    Cannot be overridden

    final class:
    Cannot be extended

    static method:
    Can be used through subclass if accessible
    Cannot be overridden
    Can be hidden

    private method:
    Not directly accessible in child
    Cannot be overridden

    Constructor:
    Not inherited
    Not overridden
    Can be overloaded

    Abstract class:
    Can be inherited

    Composition:
    HAS-A

    Inheritance:
    IS-A

---

# ☕ End of Java Inheritance Notes

> If you can explain every section above without looking at the README, you are well-prepared for most Java inheritance questions in a technical interview.
