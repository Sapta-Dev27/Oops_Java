# ☕ Java Basic Interview Notes --- Questions 1--30

> Complete interview-oriented notes for Java basics.
>
> Covers definitions, simple explanations, examples, tricky questions,
> important rules, interview-ready answers, and rapid revision.

------------------------------------------------------------------------

# 📚 Table of Contents

1.  [Why is Java Platform
    Independent?](#1-why-is-java-platform-independent)
2.  [Why is Java Not a Pure Object-Oriented
    Language?](#2-why-is-java-not-a-pure-object-oriented-language)
3.  [Heap vs Stack Memory](#3-heap-vs-stack-memory)
4.  [Is Java Completely
    Object-Oriented?](#4-is-java-completely-object-oriented)
5.  [Java vs C++](#5-java-vs-c)
6.  [Why Doesn't Java Use Raw
    Pointers?](#6-why-doesnt-java-use-raw-pointers)
7.  [Instance Variable vs Local
    Variable](#7-instance-variable-vs-local-variable)
8.  [Default Values in Java](#8-default-values-in-java)
9.  [Data Encapsulation](#9-data-encapsulation)
10. [JIT Compiler](#10-jit-compiler)
11. [`equals()` vs `==`](#11-equals-vs-)
12. [Infinite Loop](#12-infinite-loop)
13. [Constructor Overloading](#13-constructor-overloading)
14. [Copy Constructor](#14-copy-constructor)
15. [Can `main()` Be Overloaded?](#15-can-main-be-overloaded)
16. [Method Overloading vs
    Overriding](#16-method-overloading-vs-overriding)
17. [Multiple Catch Blocks](#17-multiple-catch-blocks)
18. [`final` Keyword](#18-final-keyword)
19. [`final` vs `finally` vs
    `finalize()`](#19-final-vs-finally-vs-finalize)
20. [Can `finally` Not Execute?](#20-can-finally-not-execute)
21. [How to Solve Output-Based Java
    Questions](#21-how-to-solve-output-based-java-questions)
22. [`super` Keyword](#22-super-keyword)
23. [Can Static Methods Be
    Overloaded?](#23-can-static-methods-be-overloaded)
24. [Why is `main()` Static?](#24-why-is-main-static)
25. [Can Static Methods Be
    Overridden?](#25-can-static-methods-be-overridden)
26. [Static Variables, Methods and
    Classes](#26-static-variables-methods-and-classes)
27. [Garbage Collection](#27-garbage-collection)
28. [ClassLoader](#28-classloader)
29. [What Does Garbage Collection
    Clean?](#29-what-does-garbage-collection-clean)
30. [Shallow Copy vs Deep Copy](#30-shallow-copy-vs-deep-copy)
31. [Final Cheat Sheet](#31-final-cheat-sheet)
32. [30-Second Revision](#32-30-second-revision)

------------------------------------------------------------------------

# 1. Why is Java Platform Independent?

Java follows **WORA --- Write Once, Run Anywhere**.

Java source code is compiled by `javac` into **bytecode**.

``` text
Java Source Code
       ↓
     javac
       ↓
    Bytecode
       ↓
      JVM
       ↓
Windows / Linux / macOS
```

The bytecode is platform-independent. The JVM is platform-specific.

### Example

``` java
public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello");
    }
}
```

Compilation:

``` bash
javac Hello.java
```

This produces:

``` text
Hello.class
```

The same `.class` file can run on different operating systems as long as
a compatible JVM is available.

### Interview Answer

> "Java is platform independent because the Java compiler converts
> source code into platform-independent bytecode. This bytecode runs on
> the JVM, and each operating system has its own JVM implementation.
> Therefore, the same bytecode can run on different operating systems
> without recompiling the Java source code."

### Remember

> **Java is platform independent, but JVM is platform dependent.**

------------------------------------------------------------------------

# 2. Why is Java Not a Pure Object-Oriented Language?

A pure object-oriented language generally treats everything as an
object.

Java has **primitive data types**:

``` text
byte
short
int
long
float
double
char
boolean
```

Example:

``` java
int age = 22;
```

`age` is a primitive value, not an object.

Java also supports static members that belong to the class rather than a
particular object.

Java provides wrapper classes when primitive values need object
representations:

``` text
Integer
Character
Double
Boolean
```

### Interview Answer

> "Java is not considered a pure object-oriented language because it
> supports primitive data types such as int, char and boolean, which are
> not objects. It also has static members that can be accessed without
> creating an object."

------------------------------------------------------------------------

# 3. Heap vs Stack Memory

## Stack

Stack memory is associated with **method execution**.

It conceptually contains:

-   Method stack frames
-   Local variables
-   Method parameters
-   References used by the method

Example:

``` java
void test() {
    int x = 10;
    Student s = new Student();
}
```

Conceptually:

``` text
Stack
----------------
x = 10
s -------------┐
----------------│
                ↓
             Heap
          ------------
          Student obj
          ------------
```

## Heap

Heap memory is used for:

-   Objects
-   Arrays
-   Dynamically allocated data

### Comparison

  -----------------------------------------------------------------------
  Stack                               Heap
  ----------------------------------- -----------------------------------
  Method execution                    Objects and arrays

  Local execution state               Dynamically created objects

  Each thread has its own stack       Shared among threads

  Stack frames are removed as methods Unreachable objects can be garbage
  return                              collected

  Generally faster                    Generally larger
  -----------------------------------------------------------------------

### Interview Answer

> "Stack memory is associated with method execution and contains local
> variables, parameters and references conceptually. Heap memory is used
> for dynamically created objects and arrays. Each thread has its own
> stack, while the heap is shared and managed by the JVM and garbage
> collector."

> **Interview note:** This is the conceptual model. JVM/JIT
> implementations can optimize where some data is physically allocated.

------------------------------------------------------------------------

# 4. Is Java Completely Object-Oriented?

### Answer: No.

Java supports the major OOP principles:

-   Encapsulation
-   Inheritance
-   Polymorphism
-   Abstraction

But it is not a pure OOP language because it has:

1.  Primitive data types
2.  Static members
3.  Other class-level language features

### Interview Answer

> "No. Java supports the major object-oriented principles, but it is not
> a pure object-oriented language because it has primitive data types
> and class-level static features."

------------------------------------------------------------------------

# 5. Java vs C++

  -----------------------------------------------------------------------
  Java                                C++
  ----------------------------------- -----------------------------------
  Compiles to bytecode                Usually compiles to native machine
                                      code

  Runs on JVM                         Usually runs directly as native
                                      code

  Platform independent through JVM    Generally platform dependent
                                      binaries

  Does not expose raw pointers        Supports pointers

  Automatic garbage collection        Manual memory management is
                                      possible

  No multiple inheritance through     Supports multiple class inheritance
  classes                             

  No user-defined operator            Supports operator overloading
  overloading                         

  No C++-style destructors            Has destructors

  More managed/safe runtime           More low-level control
  environment                         
  -----------------------------------------------------------------------

### Interview Answer

> "Both Java and C++ support object-oriented programming, but Java
> focuses more on portability and managed memory. Java compiles to
> bytecode and runs on the JVM, doesn't expose raw pointer manipulation,
> uses garbage collection, and doesn't support multiple inheritance
> through classes. C++ provides more low-level control and supports
> features such as pointers, multiple inheritance and operator
> overloading."

------------------------------------------------------------------------

# 6. Why Doesn't Java Use Raw Pointers?

Java does not expose **raw pointers** to programmers.

Instead, Java uses **references**.

``` java
Student s = new Student();
```

`s` is a reference to an object.

Java does not allow pointer arithmetic like:

``` java
s++;
```

### Why?

-   Better memory safety
-   Better security
-   Less complexity
-   No direct arbitrary memory access
-   Easier memory management

### Interview Answer

> "Java does not expose raw pointers because direct pointer manipulation
> can lead to memory corruption, security issues and increased
> complexity. Java uses references to access objects while the JVM
> handles memory management."

### Important

Do not say:

> "Java has no pointers."

Better:

> "Java does not expose raw pointers to the programmer."

------------------------------------------------------------------------

# 7. Instance Variable vs Local Variable

## Instance Variable

Declared inside a class but outside methods/constructors.

``` java
class Student {
    int age;
    String name;
}
```

Each object has its own instance state.

## Local Variable

Declared inside a method, constructor or block.

``` java
void display() {
    int x = 10;
}
```

Its scope is limited to that method/block.

### Comparison

  -----------------------------------------------------------------------
  Instance Variable                   Local Variable
  ----------------------------------- -----------------------------------
  Declared inside class               Declared inside method/block

  Belongs to object                   Belongs to method/block execution

  Gets default value                  Does not get automatic default
                                      value

  Can have access modifiers           Cannot use access modifiers like
                                      `public`/`private`
  -----------------------------------------------------------------------

### Interview Answer

> "An instance variable is declared inside a class but outside methods
> and belongs to an object, so each object has its own copy. A local
> variable is declared inside a method or block and its scope is limited
> there. Instance variables receive default values, while local
> variables must be initialized before use."

------------------------------------------------------------------------

# 8. Default Values in Java

**Fields** (instance and static variables) receive default values.

  Type                     Default
  ------------------------ ------------
  `byte`, `short`, `int`   `0`
  `long`                   `0L`
  `float`                  `0.0f`
  `double`                 `0.0d`
  `char`                   `'\u0000'`
  `boolean`                `false`
  Reference                `null`

Example:

``` java
class Test {
    int x;
    boolean flag;
    String name;
}
```

Defaults:

``` text
x     → 0
flag  → false
name  → null
```

## Local variables are different

``` java
void test() {
    int x;
    System.out.println(x); // Compilation error
}
```

### Interview Answer

> "Instance and static fields receive default values automatically, such
> as 0 for int, false for boolean and null for references. Local
> variables do not receive automatic default values and must be
> initialized before use."

------------------------------------------------------------------------

# 9. What is Data Encapsulation?

Encapsulation means:

> **Bundling data and the methods that operate on it while controlling
> access to the internal state.**

Commonly achieved with `private` fields and public methods.

``` java
class BankAccount {

    private double balance;

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
}
```

Instead of directly changing `balance`, users go through controlled
methods.

### Benefits

1.  Data hiding
2.  Validation
3.  Controlled access
4.  Better maintainability
5.  Reduced coupling

### Interview Answer

> "Encapsulation means bundling data and related behavior into a class
> while restricting direct access to internal state. In Java, we
> commonly use private fields and public methods such as getters,
> setters or controlled operations."

------------------------------------------------------------------------

# 10. JIT Compiler

**JIT = Just-In-Time Compiler**

It is part of the JVM.

``` text
Java Source
    ↓ javac
Bytecode
    ↓ JVM / JIT
Native Machine Code
```

The JIT can identify frequently executed code and compile it into native
machine code at runtime.

This improves performance.

### Don't confuse `javac` and JIT

`javac`:

``` text
Java source → Bytecode
```

JIT:

``` text
Frequently executed bytecode → Native machine code
```

### Interview Answer

> "JIT stands for Just-In-Time compiler. It is part of the JVM and
> improves runtime performance by compiling frequently executed bytecode
> into native machine code and applying runtime optimizations."

------------------------------------------------------------------------

# 11. `equals()` vs `==`

## For primitives

`==` compares values.

``` java
int a = 10;
int b = 10;

System.out.println(a == b); // true
```

## For objects

`==` compares references.

``` java
String a = new String("Java");
String b = new String("Java");

System.out.println(a == b); // false
```

The references point to different String objects.

## `equals()`

`equals()` is used for logical equality when the class overrides it
appropriately.

``` java
System.out.println(a.equals(b)); // true
```

`String` overrides `equals()` to compare content.

### Interview Answer

> "For primitives, `==` compares values. For objects, `==` compares
> whether two references refer to the same object. `equals()` is used
> for logical equality, depending on the class implementation. String
> overrides equals(), so two different String objects containing the
> same text can be equal."

### Remember

``` text
Primitive:
== → value

Object:
== → same reference?

equals() → logical equality
```

------------------------------------------------------------------------

# 12. Infinite Loop

## `while`

``` java
while (true) {
    System.out.println("Hello");
}
```

## `for`

``` java
for (;;) {
    System.out.println("Hello");
}
```

## `do-while`

``` java
do {
    System.out.println("Hello");
} while (true);
```

### Interview Answer

> "An infinite loop can be created using `while(true)` or `for(;;)`. It
> continues until something such as break, return, an exception or
> external termination stops execution."

------------------------------------------------------------------------

# 13. Constructor Overloading

Constructor overloading means having **multiple constructors in the same
class with different parameter lists**.

``` java
class Student {

    String name;
    int age;

    Student() {
        name = "Unknown";
        age = 0;
    }

    Student(String name) {
        this.name = name;
    }

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

Usage:

``` java
Student s1 = new Student();
Student s2 = new Student("Rahul");
Student s3 = new Student("Rahul", 22);
```

### Interview Answer

> "Constructor overloading means defining multiple constructors with
> different parameter lists. It allows objects to be initialized in
> different ways depending on the data available."

### Important

Constructors cannot be overloaded by changing only return type because
constructors do not have a return type.

------------------------------------------------------------------------

# 14. Copy Constructor

Java does not have a special built-in copy constructor feature like C++,
but we can create a constructor that accepts an object of the same
class.

``` java
class Student {

    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Student(Student other) {
        this.name = other.name;
        this.age = other.age;
    }
}
```

Usage:

``` java
Student s1 = new Student("Rahul", 22);
Student s2 = new Student(s1);
```

### Interview Answer

> "Java does not provide a special built-in copy constructor syntax like
> C++, but we can define a constructor that accepts an object of the
> same class and copies its state. This is commonly called a copy
> constructor."

------------------------------------------------------------------------

# 15. Can `main()` Be Overloaded?

### Yes.

``` java
class Test {

    public static void main(String[] args) {
        System.out.println("Standard main");
    }

    public static void main(int x) {
        System.out.println(x);
    }
}
```

The JVM recognizes:

``` java
public static void main(String[] args)
```

as the standard entry point.

The overloaded version must be called explicitly.

### Interview Answer

> "Yes, main can be overloaded because Java supports method overloading.
> However, the JVM recognizes the standard `main(String[] args)`
> signature as the application entry point."

------------------------------------------------------------------------

# 16. Method Overloading vs Overriding

## Method Overloading

Same method name but **different parameter list**.

``` java
class Calculator {

    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }
}
```

Generally called **compile-time polymorphism**.

Changing only return type is not overloading.

## Method Overriding

A subclass provides its own implementation of an inherited instance
method with the same signature.

``` java
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
```

``` java
Animal a = new Dog();
a.sound();
```

Output:

``` text
Dog barks
```

This demonstrates **runtime polymorphism**.

### Comparison

  -----------------------------------------------------------------------
  Overloading                         Overriding
  ----------------------------------- -----------------------------------
  Different parameter list            Same method signature

  Usually same class                  Requires inheritance

  Compile-time resolution             Runtime dispatch

  Return type alone cannot            Return type must be compatible
  distinguish                         

  Static methods can be overloaded    Static methods are hidden, not
                                      overridden
  -----------------------------------------------------------------------

### Interview Answer

> "Overloading means having the same method name with different
> parameter lists and is resolved at compile time. Overriding occurs
> when a subclass provides a new implementation of an inherited instance
> method with the same signature, enabling runtime polymorphism."

------------------------------------------------------------------------

# 17. Multiple Catch Blocks

Yes, one `try` block can have multiple `catch` blocks.

``` java
try {
    int x = 10 / 0;
}
catch (ArithmeticException e) {
    System.out.println("Arithmetic error");
}
catch (Exception e) {
    System.out.println("General exception");
}
```

### Important Rule

Specific exceptions must come before general exceptions.

Correct:

``` java
catch (ArithmeticException e)
catch (Exception e)
```

Wrong:

``` java
catch (Exception e)
catch (ArithmeticException e) // unreachable
```

### Interview Answer

> "Yes, one try block can have multiple catch blocks so different
> exception types can be handled differently. More specific exceptions
> should be caught before more general exceptions."

------------------------------------------------------------------------

# 18. `final` Keyword

The `final` keyword restricts modification.

## Final Variable

Cannot be reassigned.

``` java
final int MAX = 100;

// MAX = 200; // Error
```

## Final Method

Cannot be overridden.

``` java
class Parent {

    final void display() {
        System.out.println("Hello");
    }
}
```

## Final Class

Cannot be extended.

``` java
final class Animal {
}

// class Dog extends Animal {} // Error
```

## Important: Final Reference

``` java
final Student s = new Student();
```

The reference `s` cannot point to another object, but the object's
mutable state can still change.

### Interview Answer

> "The final keyword restricts modification. A final variable cannot be
> reassigned, a final method cannot be overridden, and a final class
> cannot be inherited. A final reference cannot be reassigned, but the
> object it refers to is not automatically immutable."

------------------------------------------------------------------------

# 19. `final` vs `finally` vs `finalize()`

They are completely different.

## `final`

Keyword used with:

-   Variables
-   Methods
-   Classes

## `finally`

Exception-handling block generally used for cleanup.

``` java
try {
    // risky code
}
catch (Exception e) {
    // handling
}
finally {
    // cleanup
}
```

## `finalize()`

An old garbage-collection-related method.

Important modern Java point:

> `finalize()` was deprecated in Java 9 and is deprecated for removal in
> modern Java.

It should not be used for resource cleanup.

Prefer:

-   `try-with-resources`
-   `AutoCloseable`
-   Explicit cleanup

### Interview Answer

> "`final`, `finally` and `finalize()` are completely different. `final`
> is a keyword used with variables, methods and classes. `finally` is an
> exception-handling block generally used for cleanup. `finalize()` was
> an old cleanup mechanism associated with garbage collection, but it
> has been deprecated since Java 9 and is deprecated for removal."

------------------------------------------------------------------------

# 20. Can `finally` Not Execute?

### Yes.

Normally, `finally` executes whether an exception occurs or not, and it
generally executes even when `return` is used.

``` java
static int test() {
    try {
        return 10;
    }
    finally {
        System.out.println("Finally");
    }
}
```

Output:

``` text
Finally
```

## Cases where it may not execute

### 1. `System.exit()`

``` java
try {
    System.exit(0);
}
finally {
    System.out.println("Finally");
}
```

The JVM terminates.

### 2. Abnormal JVM/process termination

A crash or forceful termination can prevent it.

### 3. Execution never reaches `finally`

``` java
try {
    while (true) {
    }
}
finally {
    System.out.println("Finally");
}
```

The program never leaves the `try`.

### Interview Answer

> "Normally, finally executes regardless of whether an exception occurs
> or a return statement is executed. However, it is not guaranteed in
> situations such as System.exit(), abnormal JVM termination, or when
> execution never reaches the finally block."

------------------------------------------------------------------------

# 21. How to Solve Output-Based Java Questions

For output questions, don't guess. Trace the program in execution order.

### Check in this order

1.  Static variable initialization
2.  Static blocks
3.  Parent initialization
4.  Child initialization
5.  Instance initialization
6.  Constructors
7.  Method calls
8.  Overloading/overriding
9.  Expressions and operator precedence

### Example

``` java
class Test {

    static {
        System.out.println("Static");
    }

    {
        System.out.println("Instance");
    }

    Test() {
        System.out.println("Constructor");
    }

    public static void main(String[] args) {
        new Test();
    }
}
```

Output:

``` text
Static
Instance
Constructor
```

### Interview Answer

> "For an output-based question, I first trace the execution order,
> especially static initialization, instance initialization,
> constructors and method calls. Then I evaluate the expressions and
> determine the final output."

------------------------------------------------------------------------

# 22. `super` Keyword

`super` refers to the **immediate parent class**.

It has three major uses.

## 1. Access Parent Variable

``` java
class Parent {
    int x = 10;
}

class Child extends Parent {

    int x = 20;

    void display() {
        System.out.println(super.x);
    }
}
```

Output:

``` text
10
```

## 2. Call Parent Method

``` java
class Parent {

    void display() {
        System.out.println("Parent");
    }
}

class Child extends Parent {

    void display() {
        super.display();
        System.out.println("Child");
    }
}
```

## 3. Call Parent Constructor

``` java
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
```

### Important

`super()` must be the first statement inside a constructor.

If you don't explicitly write it, Java implicitly calls the parent's
accessible no-argument constructor when one exists.

### Interview Answer

> "`super` is used to access members of the immediate parent class. We
> can use it to access a parent variable, call a parent method, or
> invoke a parent constructor using `super()`."

------------------------------------------------------------------------

# 23. Can Static Methods Be Overloaded?

### Yes.

``` java
class Calculator {

    static int add(int a, int b) {
        return a + b;
    }

    static int add(int a, int b, int c) {
        return a + b + c;
    }
}
```

Usage:

``` java
Calculator.add(10, 20);
Calculator.add(10, 20, 30);
```

### Interview Answer

> "Yes, static methods can be overloaded because overloading depends on
> the method name and parameter list. Whether the method is static does
> not prevent overloading."

### Remember

> **Static methods can be overloaded, but they are not overridden.**

------------------------------------------------------------------------

# 24. Why is `main()` Static?

The JVM needs an entry point to start the program.

If `main()` were an instance method, the JVM would need to create an
object first.

Because `main()` is static, the JVM can invoke it without creating an
object.

``` java
public static void main(String[] args)
```

### Conceptually

``` text
JVM
 ↓
Main.main()
```

instead of:

``` text
JVM
 ↓
create object
 ↓
call main()
```

### Interview Answer

> "The main method is static because it is the entry point of the
> application and the JVM needs to invoke it without creating an object
> of the class. Since static methods belong to the class, the JVM can
> directly invoke main."

------------------------------------------------------------------------

# 25. Can Static Methods Be Overridden?

### No.

Static methods are **hidden**, not overridden.

``` java
class Parent {

    static void display() {
        System.out.println("Parent");
    }
}

class Child extends Parent {

    static void display() {
        System.out.println("Child");
    }
}

Parent p = new Child();
p.display();
```

Output:

``` text
Parent
```

The call is resolved based on the reference/class type.

### Compare with Instance Method

``` java
class Parent {

    void display() {
        System.out.println("Parent");
    }
}

class Child extends Parent {

    @Override
    void display() {
        System.out.println("Child");
    }
}

Parent p = new Child();
p.display();
```

Output:

``` text
Child
```

### Interview Answer

> "No, static methods cannot be overridden because they belong to the
> class and are not dynamically dispatched based on the object. If a
> subclass declares a static method with the same signature, it is
> called method hiding."

### Remember

``` text
Instance method → overriding → runtime polymorphism

Static method → hiding → compile-time resolution
```

------------------------------------------------------------------------

# 26. Static Variables, Methods and Classes

## Static Variable

Belongs to the class and is shared among instances.

``` java
class Student {

    static String college = "ABC";
    String name;
}
```

There is one shared `college` variable for the class.

## Static Method

Belongs to the class and can be called without an object.

``` java
class Test {

    static void display() {
        System.out.println("Hello");
    }
}

Test.display();
```

A static method cannot directly access an instance variable because no
specific object is implied.

## Static Class

Java does **not** allow a top-level class to be static.

But a nested class can be static.

``` java
class Outer {

    static class Inner {

        void display() {
            System.out.println("Hello");
        }
    }
}
```

Create it using:

``` java
Outer.Inner obj = new Outer.Inner();
```

### Interview Answer

> "A static variable belongs to the class and is shared among its
> objects. A static method also belongs to the class and can be called
> without an object. Java does not allow top-level static classes, but
> it allows static nested classes."

------------------------------------------------------------------------

# 27. Garbage Collection

Garbage Collection (GC) automatically reclaims heap memory occupied by
objects that are **no longer reachable**.

Example:

``` java
Student s = new Student();

s = null;
```

If no other reachable reference points to the object, it becomes
eligible for garbage collection.

### Main objectives

1.  Reclaim unused heap memory
2.  Reduce manual memory management
3.  Reduce many memory-management errors

### Important

You cannot guarantee exactly when GC runs.

``` java
System.gc();
```

is only a request/hint to the JVM.

### Interview Answer

> "The main objective of garbage collection is to automatically reclaim
> heap memory occupied by objects that are no longer reachable. It
> reduces the need for manual memory management, but the programmer
> cannot control exactly when garbage collection occurs."

------------------------------------------------------------------------

# 28. What is a ClassLoader?

A **ClassLoader** is part of the JVM's class-loading mechanism.

It loads class definitions into the JVM when required.

### Common ClassLoader hierarchy

``` text
Bootstrap ClassLoader
        ↓
Platform ClassLoader
        ↓
Application ClassLoader
```

## Bootstrap ClassLoader

Loads core Java classes.

## Platform ClassLoader

Loads Java platform classes/modules.

## Application ClassLoader

Loads application classes from the classpath/module path.

### Why is ClassLoader important?

-   Dynamic class loading
-   Class isolation
-   Modularity
-   Custom class-loading behavior

### Interview Answer

> "A ClassLoader is part of the JVM's class-loading mechanism that loads
> class definitions into the JVM when needed. Java has a hierarchy
> involving the Bootstrap, Platform and Application class loaders.
> Custom ClassLoaders can also be created for specialized loading
> behavior."

------------------------------------------------------------------------

# 29. What Does Garbage Collection Clean --- Stack or Heap?

### Answer: Heap.

Garbage collection primarily deals with **unreachable objects in heap
memory**.

``` java
Student s = new Student();

s = null;
```

The Student object may become eligible for GC if no other reachable
reference points to it.

## What happens to Stack?

Stack frames are associated with method calls.

``` java
void test() {
    int x = 10;
}
```

When `test()` returns, its stack frame is removed automatically.

This is **not garbage collection**.

### Interview Answer

> "Garbage collection primarily cleans unreachable objects from the
> heap. Stack memory is managed through stack frames, which are removed
> as method calls return. So we should not say that garbage collection
> cleans the stack."

### Remember

``` text
Heap  → Objects → GC handles unreachable objects

Stack → Method frames → Removed as methods return
```

------------------------------------------------------------------------

# 30. Shallow Copy vs Deep Copy

This is a very common interview question.

## First: `s2 = s1` is NOT a copy

``` java
Student s2 = s1;
```

Both variables point to the **same object**.

------------------------------------------------------------------------

## Shallow Copy

### Easy definition

> **New outer object + same inner object**

Suppose:

``` java
class Address {

    String city;

    Address(String city) {
        this.city = city;
    }
}

class Student {

    String name;
    Address address;

    Student(String name, Address address) {
        this.name = name;
        this.address = address;
    }
}
```

Now:

``` java
Address address = new Address("Delhi");

Student s1 = new Student("Rahul", address);

// Shallow copy
Student s2 = new Student(s1.name, s1.address);
```

Both students share the same `Address`.

``` text
s1 ───────┐
          ↓
       Address
       Delhi
          ↑
s2 ───────┘
```

Now:

``` java
s2.address.city = "Kolkata";

System.out.println(s1.address.city);
System.out.println(s2.address.city);
```

Output:

``` text
Kolkata
Kolkata
```

Why?

Because:

``` java
s2.address = s1.address;
```

Both references point to the same Address object.

------------------------------------------------------------------------

## Deep Copy

### Easy definition

> **New outer object + new inner object**

``` java
Address address = new Address("Delhi");

Student s1 = new Student("Rahul", address);

// Deep copy
Student s2 = new Student(
    s1.name,
    new Address(s1.address.city)
);
```

Now:

``` text
s1 → Student → Address A → Delhi

s2 → Student → Address B → Delhi
```

They have separate Address objects.

Now:

``` java
s2.address.city = "Kolkata";

System.out.println(s1.address.city);
System.out.println(s2.address.city);
```

Output:

``` text
Delhi
Kolkata
```

### Comparison

  -----------------------------------------------------------------------
  Shallow Copy                        Deep Copy
  ----------------------------------- -----------------------------------
  New outer object                    New outer object

  Nested references are shared        Nested objects are separately
                                      copied

  Less memory                         More memory

  Usually simpler/faster              Usually more work

  Changes to shared nested data can   Changes remain independent
  affect original                     
  -----------------------------------------------------------------------

### Interview Answer

> "In a shallow copy, a new outer object is created but nested reference
> objects are shared. In a deep copy, nested objects are also copied, so
> the original and copied objects are independent. Therefore, modifying
> nested data can affect the original in a shallow copy but not in a
> deep copy."

### Memory Trick

``` text
SHALLOW
New outer object
+
Same inner object

DEEP
New outer object
+
New inner object
```

------------------------------------------------------------------------

# 31. Final Cheat Sheet

  -----------------------------------------------------------------------
  Question                            Core Answer
  ----------------------------------- -----------------------------------
  Platform independence               Bytecode runs on platform-specific
                                      JVM

  Pure OOP?                           No --- primitives and static
                                      features

  Heap                                Objects and arrays

  Stack                               Method frames/local execution state

  Pointers                            Raw pointers are not exposed

  Encapsulation                       Bundle state/behavior + controlled
                                      access

  JIT                                 Compiles hot bytecode to native
                                      code

  `==`                                Value comparison for primitives;
                                      reference comparison for objects

  `equals()`                          Logical equality when properly
                                      implemented

  Infinite loop                       `while(true)` / `for(;;)`

  Constructor overloading             Multiple constructors, different
                                      parameters

  Copy constructor                    User-defined constructor copying
                                      another object's state

  Main overloaded                     Yes

  Overloading                         Same name + different parameters

  Overriding                          Same signature + subclass

  Multiple catch                      Yes; specific before general

  `final` variable                    Cannot reassign

  `final` method                      Cannot override

  `final` class                       Cannot extend

  `finally`                           Exception-handling block

  `finalize()`                        Deprecated legacy mechanism

  `super`                             Parent variable/method/constructor

  Static overload                     Yes

  Static override                     No --- method hiding

  Static variable                     Class-level shared variable

  Static method                       Class-level method

  Static class                        Only nested classes can be static

  Garbage collection                  Reclaims unreachable heap objects

  ClassLoader                         Loads class definitions into JVM

  Shallow copy                        New outer object + shared nested
                                      references

  Deep copy                           New outer object + independent
                                      nested objects
  -----------------------------------------------------------------------

------------------------------------------------------------------------

# 32. 30-Second Revision

Before an interview, remember these five groups.

## 1. JVM

``` text
Source Code
    ↓
javac
    ↓
Bytecode
    ↓
JVM
    ↓
Machine Code
```

**JIT** helps optimize frequently executed bytecode at runtime.

------------------------------------------------------------------------

## 2. Memory

``` text
Stack → Method execution
Heap  → Objects
GC    → Unreachable heap objects
```

------------------------------------------------------------------------

## 3. Polymorphism

``` text
Overloading
→ Different parameters
→ Compile time

Overriding
→ Same signature in child
→ Runtime
```

------------------------------------------------------------------------

## 4. Static

``` text
Static variable → Class-level data
Static method   → Class-level behavior
Static method   → Can be overloaded
Static method   → Cannot be overridden
```

------------------------------------------------------------------------

## 5. Copying

``` text
s2 = s1
→ Same object

Shallow
→ New outer + shared inner

Deep
→ New outer + new inner
```

------------------------------------------------------------------------

# 🎯 How to Answer in the Interview

For most questions, use this structure:

> **Definition → Why → Small Example → Important Point**

Do not unnecessarily give a 2-minute lecture.

### Example: "Can static methods be overridden?"

A strong answer:

> "No, static methods cannot be overridden because they belong to the
> class rather than being dynamically dispatched based on the object. If
> a child class declares a static method with the same signature, it is
> called method hiding. The method is resolved based on the reference
> type."

Then stop and allow the interviewer to ask the next question.

### Final Rule

> **Understand the concept first. Memorize the interview answer
> second.**

That will make your answers sound natural instead of memorized.


# ☕ Java Intermediate Interview Questions — 31 to 38

> Complete interview-ready notes for Questions **31–38**.
>
> Simple explanations, examples, interview answers, common follow-ups, traps, and quick revision.

---

# 📚 Table of Contents

- [31. Why Are Strings Immutable?](#31-apart-from-security-why-are-strings-immutable-in-java)
- [32. Singleton Class](#32-what-is-a-singleton-class-how-do-you-implement-it)
- [33. Compile-Time Error](#33-which-of-the-below-generates-a-compile-time-error)
- [34. String vs StringBuffer vs StringBuilder](#34-difference-between-string-stringbuffer-and-stringbuilder)
- [35. Interface vs Abstract Class](#35-difference-between-interface-and-abstract-class)
- [36. Compile-Time Errors in a Program](#36-does-this-program-give-a-compile-time-error)
- [37. Comparator in Java](#37-what-is-a-comparator-in-java)
- [38. Static and Private Method Overriding](#38-can-static-and-private-methods-be-overridden)
- [Final Revision Table](#final-revision-table)
- [Important Interview Traps](#important-interview-traps)

---

# 31. Apart From Security, Why Are Strings Immutable in Java?

### First: What does immutable mean?

Immutable means:

> **Once a String object is created, its value cannot be changed.**

Example:

```java
String s = "Hello";

s.concat(" World");

System.out.println(s);
```

### Output

```text
Hello
```

`concat()` creates another String rather than changing the original.

---

## Why Are Strings Immutable?

### 1. String Pool

Java maintains a String Pool to reuse String objects.

```java
String s1 = "Java";
String s2 = "Java";
```

They can refer to the same pooled String.

```text
s1 ──┐
     ↓
   "Java"
     ↑
s2 ──┘
```

If Strings were mutable, changing one reference could unexpectedly affect another reference using the same pooled object.

Immutability makes sharing safe.

---

### 2. Thread Safety

Strings can safely be shared between threads because their contents cannot change after creation.

---

### 3. Stable `hashCode()`

Strings are commonly used as keys in:

```java
HashMap
HashSet
```

Example:

```java
HashMap<String, Integer> map = new HashMap<>();

map.put("Java", 100);
```

Because a String cannot change, its value and hash code remain stable.

---

### 4. Performance and Reusability

Since String objects cannot change, Java can safely reuse String objects.

This is especially useful with the String Pool.

### Interview Answer

> **"Apart from security, String is immutable mainly because of the String Pool, thread safety, stable hash codes and safe object sharing. Since a String cannot change after creation, the JVM can safely reuse String objects and Strings can safely be used as keys in hash-based collections."**

### Remember

```text
String immutable
      ↓
Safe sharing
      ↓
String Pool
      ↓
Stable hashCode
      ↓
Thread-safe sharing
```

---

# 32. What Is a Singleton Class? How Do You Implement It?

A **Singleton class** is a class designed so that **only one instance is created** and a common access point is provided to that instance.

## Three Important Things

```text
1. private constructor
2. static variable
3. static getInstance() method
```

---

## 1. Private Constructor

```java
private Singleton() {
}
```

This prevents direct object creation from outside.

This is not allowed:

```java
Singleton s = new Singleton(); // ERROR
```

---

## 2. Static Variable

```java
private static Singleton instance;
```

This stores the single object.

---

## 3. `getInstance()` Method

```java
public static Singleton getInstance() {

    if (instance == null) {
        instance = new Singleton();
    }

    return instance;
}
```

---

# Complete Example

```java
class Singleton {

    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {

        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }
}

public class Main {

    public static void main(String[] args) {

        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println(s1 == s2);
    }
}
```

### Output

```text
true
```

### Why?

First call:

```java
Singleton.getInstance();
```

`instance` is null, so the object is created.

Second call:

```java
Singleton.getInstance();
```

The object already exists, so the same object is returned.

```text
s1 ───────┐
          ↓
     Singleton Object
          ↑
s2 ───────┘
```

### Interview Answer

> **"A Singleton class allows only one object to be created. We use a private constructor to prevent direct object creation, a static variable to store the single object, and a static `getInstance()` method to create and return that object."**

### One-Line Answer

> **"Singleton means one class, one object, and one common access point to that object."**

---

## Important Follow-Up: Is This Thread-Safe?

The basic implementation is **not thread-safe**.

Two threads could simultaneously see:

```java
instance == null
```

and both create an object.

A simple thread-safe version is:

```java
class Singleton {

    private static Singleton instance;

    private Singleton() {
    }

    public static synchronized Singleton getInstance() {

        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }
}
```

Now only one thread at a time can execute `getInstance()`.

### Interview Point

> **"The basic lazy Singleton implementation is not thread-safe. In a multithreaded environment, synchronization or another thread-safe initialization technique is required."**

---

# 33. Which of the Below Generates a Compile-Time Error?

The actual program/options for Question 33 are not visible in the provided image, so the exact option cannot be identified.

For this type of question, check common compile-time problems.

## 1. Uninitialized Local Variable

```java
int x;

System.out.println(x);
```

Compilation error.

---

## 2. Incompatible Types

```java
int x = "Hello";
```

Compilation error.

---

## 3. Invalid Access

```java
class Test {

    private int x;
}
```

Trying to access `x` from outside the class causes an access error.

---

## 4. Invalid Overriding

```java
class Parent {

    public void show() {
    }
}

class Child extends Parent {

    protected void show() {
    }
}
```

Compilation error because the child cannot reduce the access level of an overridden method.

---

## 5. Unhandled Checked Exception

```java
FileReader f = new FileReader("test.txt");
```

If the checked exception is not caught or declared, compilation fails.

### Important

Do not confuse compile-time errors with runtime errors.

```java
int x = 10 / 0;
```

This normally compiles but causes a runtime `ArithmeticException`.

Whereas:

```java
int x = "Hello";
```

is a compile-time type error.

### Interview Answer

> **"The exact program is required to identify the exact compile-time error and number of errors. I would check syntax, data types, declarations, access modifiers, inheritance, overriding rules and checked exceptions. Runtime exceptions should not be counted as compile-time errors."**

---

# 34. Difference Between String, StringBuffer and StringBuilder

This is a **very common interview question**.

The easiest way to remember it is:

```text
String
→ Immutable

StringBuffer
→ Mutable
→ Synchronized

StringBuilder
→ Mutable
→ Not synchronized
```

---

# String

String is immutable.

```java
String s = "Hello";

s = s + " World";
```

A new String object is created rather than modifying the old String.

### Use String when:

The text does not need frequent modification.

---

# StringBuffer

StringBuffer is mutable.

```java
StringBuffer sb = new StringBuffer("Hello");

sb.append(" World");

System.out.println(sb);
```

### Output

```text
Hello World
```

StringBuffer methods are synchronized, so it is designed for thread-safe mutable string operations.

---

# StringBuilder

StringBuilder is also mutable.

```java
StringBuilder sb = new StringBuilder("Hello");

sb.append(" World");

System.out.println(sb);
```

### Output

```text
Hello World
```

StringBuilder is not synchronized.

Therefore, when synchronization is not required, StringBuilder is generally preferred for better performance.

---

## Comparison

| Feature | String | StringBuffer | StringBuilder |
|---|---|---|---|
| Mutable | ❌ No | ✅ Yes | ✅ Yes |
| Synchronized | Not applicable | ✅ Yes | ❌ No |
| Repeated modification | Less suitable | Suitable | Most commonly preferred |
| Thread-safe mutable operations | N/A due to immutability | ✅ | ❌ |
| Performance | Repeated concatenation can create objects | Generally slower than Builder | Generally faster than Buffer |

### Interview Answer

> **"String is immutable, so modifying it creates another String object. StringBuffer and StringBuilder are mutable and modify the same object. StringBuffer provides synchronized methods and is suitable when synchronized mutable string operations are needed, while StringBuilder is not synchronized and is generally preferred when thread safety is not required."**

### Remember

```text
String        → Immutable
StringBuffer  → Mutable + Synchronized
StringBuilder → Mutable + Not synchronized
```

---

# 35. Difference Between Interface and Abstract Class

This is one of the **most important Java OOP questions**.

---

# Abstract Class

An abstract class can contain:

- Abstract methods
- Concrete methods
- Instance variables
- Constructors
- Static members
- Final members

Example:

```java
abstract class Animal {

    String name;

    Animal(String name) {
        this.name = name;
    }

    abstract void sound();

    void eat() {
        System.out.println("Eating");
    }
}
```

---

# Interface

An interface is mainly used to define a **contract or capability**.

Modern Java interfaces can contain:

- Abstract methods
- `default` methods
- `static` methods
- `private` methods
- Constants

Example:

```java
interface Flyable {

    void fly();

    default void land() {
        System.out.println("Landing");
    }
}
```

---

## Major Differences

| Abstract Class | Interface |
|---|---|
| `abstract class` | `interface` |
| Can have constructors | Cannot have constructors |
| Can have instance variables | Fields are implicitly `public static final` |
| Can have abstract and concrete methods | Can have abstract, default, static and private methods |
| A class can extend only one class | A class can implement multiple interfaces |
| Can maintain instance state | Cannot have normal per-object instance fields |
| Useful for common base implementation | Useful for contracts/capabilities |

---

## Example

```java
abstract class Animal {

    abstract void sound();

    void sleep() {
        System.out.println("Sleeping");
    }
}

interface Flyable {

    void fly();
}

class Bird extends Animal implements Flyable {

    public void sound() {
        System.out.println("Chirp");
    }

    public void fly() {
        System.out.println("Flying");
    }
}
```

Here:

```text
Animal
→ Common base behavior

Flyable
→ Capability/contract
```

### When to Use Abstract Class?

Use an abstract class when related classes need:

- Common state
- Common implementation
- Constructors
- Shared protected/private behavior

### When to Use Interface?

Use an interface when you want:

- A contract
- A capability
- Multiple implementations
- A type that unrelated classes can implement

### Interview Answer

> **"An abstract class is useful when related classes need to share state, constructors and common implementation, while an interface is mainly used to define a contract or capability. A class can extend only one class but can implement multiple interfaces. Abstract classes can have instance variables and constructors, whereas interface fields are implicitly public, static and final."**

### Easy Memory Trick

```text
Abstract Class
→ Shared base
→ State + implementation

Interface
→ Contract
→ Capability
```

---

# 36. Does This Program Give a Compile-Time Error?

The actual program for Question 36 is not visible in the provided image, so the exact number of errors cannot be determined.

For this type of question, check:

1. Syntax
2. Variable declarations
3. Data types
4. Method signatures
5. Access modifiers
6. Constructors
7. Inheritance
8. Overriding rules
9. Exception handling
10. Static/instance access
11. `final` restrictions
12. Duplicate declarations

### Important

Don't count runtime exceptions as compile-time errors.

Example:

```java
int x = 10 / 0;
```

This generally compiles and fails at runtime.

But:

```java
int x = "Hello";
```

fails at compile time because the types are incompatible.

### Interview Answer

> **"I would check the program against Java's compile-time rules, including syntax, types, declarations, access, inheritance, overriding and exception handling. I would distinguish compilation errors from runtime exceptions before counting the errors."**

> **Note:** Send the actual Q36 program if you want the exact number of errors and the reason for each.

---

# 37. What Is a Comparator in Java?

`Comparator` is an interface from:

```java
java.util.Comparator
```

It is used to define **custom ordering** for objects.

Its main method is:

```java
int compare(T o1, T o2)
```

---

# Example

Suppose:

```java
class Student {

    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

We want to sort students by age.

```java
Comparator<Student> byAge = new Comparator<Student>() {

    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.age, s2.age);
    }
};
```

Then:

```java
Collections.sort(students, byAge);
```

Or using a lambda:

```java
students.sort((s1, s2) -> Integer.compare(s1.age, s2.age));
```

---

# Comparator vs Comparable

This is a very common follow-up.

## Comparable

Used to define a class's **natural ordering**.

```java
class Student implements Comparable<Student> {

    int age;

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.age, other.age);
    }
}
```

Method:

```text
compareTo()
```

---

## Comparator

Used to define **custom/external ordering**.

```java
Comparator<Student> byName =
    (s1, s2) -> s1.name.compareTo(s2.name);
```

You can create multiple Comparators:

```java
Comparator<Student> byAge;
Comparator<Student> byName;
Comparator<Student> byMarks;
```

### Comparison

| Comparable | Comparator |
|---|---|
| `java.lang.Comparable` | `java.util.Comparator` |
| `compareTo()` | `compare()` |
| Natural ordering | Custom ordering |
| Implemented by the class | Usually separate from the class |
| Usually one natural ordering | Can have multiple strategies |

### Interview Answer

> **"Comparator is an interface used to define custom ordering for objects. Its main method is `compare()`, which returns a negative value, zero, or a positive value according to the ordering. Unlike Comparable, which defines natural ordering using `compareTo()`, Comparator lets us define multiple external sorting strategies."**

### Remember

```text
Comparable
→ compareTo()
→ Natural ordering

Comparator
→ compare()
→ Custom ordering
```

---

# 38. Can Static and Private Methods Be Overridden?

The statement:

> "In Java, static as well as private method overriding is possible."

is **incorrect**.

Neither static methods nor private methods are overridden.

---

# 1. Static Methods

Static methods belong to the **class**, not to individual objects.

If a child class declares a static method with the same signature, it is called **method hiding**.

```java
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
```

Now:

```java
Parent p = new Child();

p.show();
```

### Output

```text
Parent
```

This is method hiding, not overriding.

---

# 2. Private Methods

Private methods are **not inherited** by subclasses.

Therefore, they cannot be overridden.

```java
class Parent {

    private void show() {
        System.out.println("Parent");
    }
}

class Child extends Parent {

    private void show() {
        System.out.println("Child");
    }
}
```

These are two separate methods.

The child's `show()` is not an override of the parent's private method.

---

# What Can Be Overridden?

An eligible inherited **instance method** can be overridden.

```java
class Parent {

    void show() {
        System.out.println("Parent");
    }
}

class Child extends Parent {

    @Override
    void show() {
        System.out.println("Child");
    }
}
```

```java
Parent p = new Child();

p.show();
```

### Output

```text
Child
```

### Interview Answer

> **"The statement is incorrect. Static methods cannot be overridden; they are hidden when a subclass declares a static method with the same signature. Private methods also cannot be overridden because they are not inherited by the subclass. Only eligible inherited instance methods can participate in overriding."**

### ⭐ Remember

| Method | Can Be Overridden? |
|---|---|
| Normal instance method | ✅ Yes |
| `final` method | ❌ No |
| `static` method | ❌ No — hidden |
| `private` method | ❌ No — not inherited |
| Constructor | ❌ No |

---

# 🚀 Final Revision Table

| # | Topic | Key Point |
|---|---|---|
| 21 | Output question | Trace execution order carefully |
| 22 | `super` | Parent variable, method and constructor |
| 23 | Static overloading | ✅ Yes |
| 24 | Why `main()` static? | JVM can invoke it without an object |
| 25 | Static overriding | ❌ No — method hiding |
| 26 | Static members | Class-level variable/method; nested static class |
| 27 | Garbage collection | Reclaims unreachable heap objects |
| 28 | ClassLoader | Loads class definitions into JVM |
| 29 | GC memory | Heap |
| 30 | Shallow vs deep | Shared nested references vs independent nested objects |
| 31 | String immutable | Pool, safe sharing, stable hashCode, thread-safe sharing |
| 32 | Singleton | One instance + common access point |
| 33 | Compile-time error | Need actual program/options for exact answer |
| 34 | String/Buffer/Builder | Immutable vs mutable synchronized vs mutable unsynchronized |
| 35 | Interface/Abstract | Contract/capability vs shared base/state |
| 36 | Compile-time errors | Need actual program for exact count |
| 37 | Comparator | Custom ordering using `compare()` |
| 38 | Static/private overriding | ❌ Neither is overridden |

---

# 🔥 Important Interview Traps

## Trap 1: Static methods can be overloaded

```text
Static
→ Can overload
→ Cannot override
```

---

## Trap 2: `private` methods cannot be overridden

```text
private
→ Not inherited
→ Cannot override
```

---

## Trap 3: `s2 = s1` is not a shallow copy

```java
Student s2 = s1;
```

means:

```text
Same object
```

Shallow copy means:

```text
New outer object
+
Shared nested object
```

---

## Trap 4: `System.gc()` does not force garbage collection

```java
System.gc();
```

is only a request/hint.

---

## Trap 5: String is immutable

```java
String s = "Hello";

s.concat(" World");

System.out.println(s);
```

Output:

```text
Hello
```

---

## Trap 6: StringBuilder vs StringBuffer

```text
StringBuffer
→ synchronized

StringBuilder
→ not synchronized
→ generally preferred when synchronization isn't needed
```

---

## Trap 7: Interface can have implemented methods

Modern Java interfaces can contain:

```text
default methods
static methods
private methods
```

So don't say:

> "An interface can contain only abstract methods."

That is outdated.

---

## Trap 8: Static nested class vs static top-level class

```text
Top-level static class
→ ❌ Not allowed

Static nested class
→ ✅ Allowed
```

---

# 🎯 Best Way to Answer in the Interview

For most questions, use:

```text
Definition
    ↓
Why
    ↓
Small example
    ↓
Important distinction
```

For example:

### Interviewer:
**"Can static methods be overridden?"**

### You:

> **"No, static methods cannot be overridden because they belong to the class rather than being dynamically dispatched based on the object. If a subclass declares a static method with the same signature, it is called method hiding. The method is resolved based on the reference type."**

Then stop.

Let the interviewer ask the follow-up.

---

# ⭐ Most Important Answers to Memorize

### String Immutability

> **"String is immutable mainly because of the String Pool, safe sharing, thread safety and stable hash codes. Since String objects cannot change, the JVM can safely reuse them and they remain safe as keys in hash-based collections."**

### Singleton

> **"A Singleton class allows only one object to be created. We use a private constructor to prevent direct object creation, a static variable to store the single object, and a static `getInstance()` method to create and return that object."**

### String vs StringBuffer vs StringBuilder

> **"String is immutable. StringBuffer and StringBuilder are mutable. StringBuffer is synchronized, while StringBuilder is not synchronized and is generally preferred when thread safety is not required."**

### Abstract Class vs Interface

> **"An abstract class is useful for sharing state and implementation among related classes, while an interface is mainly used to define a contract or capability. A class can extend only one class but can implement multiple interfaces."**

### Comparator

> **"Comparator is used to define custom ordering for objects using the `compare()` method. Comparable defines natural ordering using `compareTo()`, while Comparator allows multiple custom sorting strategies."**

### Static/Private Overriding

> **"Static methods are hidden, not overridden, and private methods cannot be overridden because they are not inherited. Therefore, neither static nor private methods participate in normal method overriding."**


---

# 🚀 Final Revision Table

| # | Topic | Key Point |
|---|---|---|
| 31 | String immutability | String Pool, safe sharing, thread safety and stable hashCode |
| 32 | Singleton | One instance + common access point |
| 33 | Compile-time error | Need the actual program/options for the exact answer |
| 34 | String / Buffer / Builder | Immutable vs mutable synchronized vs mutable unsynchronized |
| 35 | Interface / Abstract class | Contract/capability vs shared base/state |
| 36 | Compile-time errors | Need the actual program for the exact count |
| 37 | Comparator | Custom ordering using `compare()` |
| 38 | Static/private overriding | Neither is overridden |

---

# 🔥 Important Interview Traps

## Trap 1: Static methods can be overloaded

```text
Static
→ Can be overloaded
→ Cannot be overridden
```

---

## Trap 2: Private methods cannot be overridden

```text
private
→ Not inherited
→ Cannot be overridden
```

---

## Trap 3: `s2 = s1` is not a shallow copy

```java
Student s2 = s1;
```

means both references point to the **same object**.

Shallow copy means:

```text
New outer object
+
Shared nested object
```

---

## Trap 4: `System.gc()` does not force garbage collection

```java
System.gc();
```

is only a request/hint to the JVM.

---

## Trap 5: String is immutable

```java
String s = "Hello";

s.concat(" World");

System.out.println(s);
```

Output:

```text
Hello
```

---

## Trap 6: StringBuilder vs StringBuffer

```text
StringBuffer
→ synchronized

StringBuilder
→ not synchronized
→ generally preferred when synchronization isn't needed
```

---

## Trap 7: Interfaces can have implemented methods

Modern Java interfaces can contain:

```text
default methods
static methods
private methods
```

So don't say:

> "An interface can contain only abstract methods."

That statement is outdated.

---

## Trap 8: Static nested class vs static top-level class

```text
Top-level static class
→ ❌ Not allowed

Static nested class
→ ✅ Allowed
```

---

# 🎯 Best Way to Answer in the Interview

For most questions, use:

```text
Definition
    ↓
Why
    ↓
Small example
    ↓
Important distinction
```

Don't give a long lecture unless the interviewer asks for more detail.

---

# ⭐ Most Important Answers to Memorize

### String Immutability

> **"String is immutable mainly because of the String Pool, safe sharing, thread safety and stable hash codes. Since String objects cannot change, the JVM can safely reuse them and they remain safe as keys in hash-based collections."**

### Singleton

> **"A Singleton class allows only one object to be created. We use a private constructor to prevent direct object creation, a static variable to store the single object, and a static `getInstance()` method to create and return that object."**

### String vs StringBuffer vs StringBuilder

> **"String is immutable. StringBuffer and StringBuilder are mutable. StringBuffer is synchronized, while StringBuilder is not synchronized and is generally preferred when thread safety is not required."**

### Abstract Class vs Interface

> **"An abstract class is useful for sharing state and implementation among related classes, while an interface is mainly used to define a contract or capability. A class can extend only one class but can implement multiple interfaces."**

### Comparator

> **"Comparator is used to define custom ordering for objects using the `compare()` method. Comparable defines natural ordering using `compareTo()`, while Comparator allows multiple custom sorting strategies."**

### Static/Private Overriding

> **"Static methods are hidden, not overridden, and private methods cannot be overridden because they are not inherited. Therefore, neither static nor private methods participate in normal method overriding."**

# Java Intermediate Interview Questions 39–49

This README contains the questions from the provided interview-question list, with simple explanations, examples, and interview-ready answers.

---

# 39. What makes a HashSet different from a TreeSet?

Both `HashSet` and `TreeSet` store **unique elements**, but they work differently.

## HashSet

```java
HashSet<Integer> set = new HashSet<>();

set.add(30);
set.add(10);
set.add(20);
set.add(10);
```

Characteristics:

- Does not allow duplicate elements
- Does not maintain sorted order
- Usually provides faster `add()`, `remove()`, and `contains()` operations
- Allows one `null` element
- Uses hashing internally

Example output order is not guaranteed:

```text
30 10 20
```

## TreeSet

```java
TreeSet<Integer> set = new TreeSet<>();

set.add(30);
set.add(10);
set.add(20);
set.add(10);
```

Output:

```text
10 20 30
```

Characteristics:

- Does not allow duplicates
- Maintains elements in sorted order
- Generally slower than `HashSet`
- Does not allow `null` with natural ordering
- Uses a tree-based data structure internally

## Comparison

| HashSet | TreeSet |
|---|---|
| No duplicates | No duplicates |
| No guaranteed sorted order | Sorted order |
| Generally faster | Generally slower |
| Hash-based | Tree-based |
| Allows one `null` | Generally does not allow `null` |

### Interview Answer

> "HashSet stores unique elements without guaranteeing sorted order and generally provides faster operations. TreeSet also stores unique elements but maintains them in sorted order. HashSet is hash-based, while TreeSet is tree-based."

---

# 40. Why is the character array preferred over String for storing confidential information?

A `char[]` is often preferred over a `String` for sensitive information such as passwords because a `String` is **immutable**.

Once a String object is created, its contents cannot be changed.

```java
String password = "secret123";
```

The original contents remain in memory until the JVM eventually removes the object through garbage collection.

With a character array:

```java
char[] password = {'s', 'e', 'c', 'r', 'e', 't'};

Arrays.fill(password, '\0');
```

We can explicitly overwrite the contents after use.

### Important

Using `char[]` does **not guarantee perfect security**. It simply gives us more control over when the sensitive data is cleared.

### Interview Answer

> "A char array is preferred for sensitive information because it is mutable, so its contents can be explicitly overwritten after use. String is immutable, so we cannot directly clear its contents."

---

# 41. What do we get in the JDK file?

The **JDK (Java Development Kit)** provides the tools and components needed to develop and run Java applications.

The JDK contains:

```text
JDK
├── JRE
│   ├── JVM
│   └── Java Class Libraries
│
└── Development Tools
    ├── javac
    ├── java
    ├── javadoc
    ├── jar
    └── jdb
```

### Important Tools

#### `javac`

Compiles Java source code into bytecode.

```bash
javac Test.java
```

Produces:

```text
Test.class
```

#### `java`

Runs a compiled Java application.

```bash
java Test
```

#### `javadoc`

Generates documentation from Java source code.

#### `jar`

Creates and manages JAR files.

#### `jdb`

Java debugger.

### Interview Answer

> "The JDK is the complete development kit for Java. It includes the runtime environment and development tools such as javac, java, javadoc, jar, and debugging tools."

---

# 42. What are the differences between JVM, JRE, and JDK in Java?

These three terms are commonly asked together.

## JVM

**Java Virtual Machine**

The JVM executes Java bytecode.

```text
.class file
    ↓
JVM
    ↓
Machine instructions
```

Its responsibilities include:

- Executing bytecode
- Memory management
- Garbage collection
- Providing platform independence

---

## JRE

**Java Runtime Environment**

JRE provides the environment required to run Java applications.

Conceptually:

```text
JRE
 ├── JVM
 └── Java Libraries
```

---

## JDK

**Java Development Kit**

JDK is used to develop Java applications.

Conceptually:

```text
JDK
 ├── JRE/runtime components
 └── Development tools
```

### Easy Relationship

```text
JDK
 ↓
Runtime + Development Tools

Runtime
 ↓
JVM + Java Libraries
```

### Comparison

| JVM | JRE | JDK |
|---|---|---|
| Runs bytecode | Runs Java applications | Develops Java applications |
| Part of runtime | Runtime environment | Development kit |
| Executes `.class` files | JVM + libraries | Runtime + development tools |

### Interview Answer

> "JVM is responsible for executing Java bytecode. JRE provides the runtime environment, including the JVM and required libraries. JDK is the complete development kit containing the runtime components plus development tools such as the Java compiler."

---

# 43. What are the differences between HashMap and HashTable in Java?

Both store data as:

```text
key → value
```

## HashMap

```java
HashMap<Integer, String> map = new HashMap<>();

map.put(1, "Java");
map.put(2, "Python");
map.put(null, "C++");
```

Characteristics:

- Not synchronized
- Generally faster for ordinary single-threaded use
- Allows one `null` key
- Allows multiple `null` values
- Modern and commonly preferred

## Hashtable

```java
Hashtable<Integer, String> table = new Hashtable<>();

table.put(1, "Java");
table.put(2, "Python");
```

Characteristics:

- Synchronized
- Generally slower than `HashMap`
- Does not allow `null` keys
- Does not allow `null` values
- Legacy class

## What is a null key?

A map stores:

```text
key → value
```

Normally:

```text
1 → Java
2 → Python
```

A `null` key means:

```text
null → Java
```

`HashMap` allows one `null` key:

```java
map.put(null, "Java");
```

A map cannot have multiple identical keys.

```java
map.put(null, "Java");
map.put(null, "Python");
```

The second value replaces the first.

Result:

```text
null → Python
```

## What does synchronized mean?

Synchronization controls access to shared data when multiple threads are working at the same time.

Conceptually:

```text
Thread 1 → 🔒 → Shared Map
Thread 2 → waits
```

The lock helps coordinate access so that multiple threads do not perform conflicting operations at the same time.

### Comparison

| HashMap | Hashtable |
|---|---|
| Not synchronized | Synchronized |
| Generally faster | Generally slower |
| One `null` key allowed | No `null` key |
| Multiple `null` values allowed | No `null` values |
| Modern | Legacy |

### Modern Alternative

For concurrent applications, `ConcurrentHashMap` is generally preferred over `Hashtable`.

### Interview Answer

> "HashMap is not synchronized and generally provides better performance for ordinary use. It allows one null key and multiple null values. Hashtable is a legacy synchronized class that does not allow null keys or values. For modern concurrent applications, ConcurrentHashMap is generally preferred."

---

# 44. What is the importance of reflection in Java?

**Reflection** allows a Java program to inspect and interact with classes, methods, fields, and constructors at runtime.

For example:

```java
Class<?> cls = String.class;

System.out.println(cls.getName());
```

Reflection can be used to:

- Find information about a class
- Inspect methods
- Inspect fields
- Inspect constructors
- Create objects dynamically
- Invoke methods dynamically
- Access certain members reflectively

Example:

```java
Class<?> cls = Student.class;

Method[] methods = cls.getDeclaredMethods();

for (Method method : methods) {
    System.out.println(method.getName());
}
```

### Where is Reflection Used?

Reflection is commonly used internally by:

- Frameworks
- Dependency injection systems
- Testing frameworks
- Serialization libraries
- ORM frameworks

### Disadvantages

Reflection can:

- Be harder to understand
- Reduce type safety
- Have performance overhead
- Make code more complex

### Interview Answer

> "Reflection is a Java mechanism that allows us to inspect and interact with classes, methods, fields, and constructors at runtime. It is widely used by frameworks and testing tools."

---

# 45. What are the different ways of threads usage?

There are several ways to create and use threads in Java.

## 1. Extending `Thread`

```java
class MyThread extends Thread {

    public void run() {
        System.out.println("Thread is running");
    }
}

public class Main {
    public static void main(String[] args) {

        MyThread t = new MyThread();
        t.start();
    }
}
```

Here, we override `run()` and call `start()`.

---

## 2. Implementing `Runnable`

```java
class MyTask implements Runnable {

    public void run() {
        System.out.println("Thread is running");
    }
}

public class Main {
    public static void main(String[] args) {

        Thread t = new Thread(new MyTask());
        t.start();
    }
}
```

This is generally preferred when we only need to define a task because the class can still extend another class.

---

## 3. Using Lambda Expression

Since `Runnable` is a functional interface:

```java
Runnable task = () -> {
    System.out.println("Thread is running");
};

Thread t = new Thread(task);
t.start();
```

Or:

```java
new Thread(() -> System.out.println("Hello")).start();
```

---

## 4. Using ExecutorService

For real applications, thread pools are commonly preferred over manually creating many threads.

```java
ExecutorService executor = Executors.newFixedThreadPool(2);

executor.submit(() -> {
    System.out.println("Task running");
});

executor.shutdown();
```

### Interview Answer

> "Threads can be created by extending Thread or implementing Runnable. We can also use lambda expressions with Runnable. For managing multiple tasks efficiently, ExecutorService and thread pools are commonly preferred."

---

# 46. What are the different types of Thread Priorities in Java? And what is the default priority of a thread assigned by JVM?

Java provides three commonly used priority constants:

```java
Thread.MIN_PRIORITY     // 1
Thread.NORM_PRIORITY    // 5
Thread.MAX_PRIORITY     // 10
```

### Default Priority

A newly created thread normally inherits the priority of the thread that creates it.

The default priority of the main thread is:

```text
5
```

So a thread created from the normal-priority main thread normally receives priority `5`.

Example:

```java
Thread t = new Thread(() -> {
    System.out.println("Running");
});

System.out.println(t.getPriority());
```

Output:

```text
5
```

### Setting Priority

```java
t.setPriority(Thread.MAX_PRIORITY);
```

or:

```java
t.setPriority(10);
```

### Important

Thread priority is a **scheduling hint**, not a guarantee that a higher-priority thread will always execute first.

### Interview Answer

> "Java thread priorities range from 1 to 10. MIN_PRIORITY is 1, NORM_PRIORITY is 5, and MAX_PRIORITY is 10. A newly created thread normally inherits its creator's priority, and the main thread normally has priority 5."

---

# 47. What is the difference between the program and the process?

## Program

A **program** is a set of instructions stored on a storage device.

For example:

```text
MyApp.java
MyApp.class
```

It is passive until it is executed.

## Process

A **process** is a program that is currently executing.

For example:

```text
Program
   ↓ execution
Process
```

A process has resources such as:

- Memory
- CPU time
- File handles
- Other operating-system resources

### Simple Example

Think of a recipe:

```text
Recipe → Program
Cooking the recipe → Process
```

The recipe is stored instructions.

Cooking is the actual execution.

### Interview Answer

> "A program is a set of instructions stored on a system, while a process is a program that is currently being executed and has allocated system resources."

---

# 48. What is the difference between the `throw` and `throws` keyword in Java?

Both are related to exception handling, but they have different purposes.

## `throw`

`throw` is used to **explicitly throw an exception**.

```java
public void checkAge(int age) {

    if (age < 18) {
        throw new IllegalArgumentException("Age must be 18 or above");
    }
}
```

It throws a specific exception object.

---

## `throws`

`throws` is used in a method declaration to indicate that the method may throw certain exceptions.

```java
public void readFile() throws IOException {
    // file operations
}
```

The caller must handle or further declare the checked exception.

## Comparison

| `throw` | `throws` |
|---|---|
| Used to actually throw an exception | Declares possible exceptions |
| Used inside method/block | Used in method declaration |
| Followed by an exception object | Followed by exception class names |
| Throws one exception at a time | Can declare multiple exceptions |

Example:

```java
throw new IOException();
```

vs.

```java
void read() throws IOException, SQLException {
}
```

### Interview Answer

> "`throw` is used to explicitly throw an exception, while `throws` is used in a method declaration to declare that the method may throw one or more exceptions."

---

# 49. What are the differences between constructor and method of a class in Java?

A constructor and a method are both members associated with a class, but they serve different purposes.

## Constructor

A constructor is used to initialize an object.

```java
class Student {

    String name;

    Student(String name) {
        this.name = name;
    }
}
```

Creating an object:

```java
Student s = new Student("Rahul");
```

## Method

A method performs some operation or behavior.

```java
class Student {

    void study() {
        System.out.println("Student is studying");
    }
}
```

Calling the method:

```java
s.study();
```

## Comparison

| Constructor | Method |
|---|---|
| Initializes an object | Performs an operation |
| Same name as class | Can have any valid name |
| Has no return type | Can have a return type |
| Called automatically during object creation | Called explicitly |
| Cannot be inherited | Methods can be inherited depending on access/modifiers |
| Cannot be `static`, `final`, or `abstract` | Methods can use these modifiers where applicable |

### Important

A constructor does **not** have a return type.

This is a constructor:

```java
Student() {
}
```

This is a method:

```java
void Student() {
}
```

The second one is a method, not a constructor, because it has a return type (`void`).

### Interview Answer

> "A constructor is used to initialize an object and has the same name as the class with no return type. A method represents behavior or an operation and can have a return type. Constructors are invoked during object creation, while methods are called explicitly."

---

# 🎯 Quick Revision

| No. | Topic | Key Point |
|---|---|---|
| 39 | HashSet vs TreeSet | HashSet is unordered; TreeSet is sorted |
| 40 | `char[]` vs String | `char[]` can be overwritten |
| 41 | JDK | Development kit + runtime components + tools |
| 42 | JVM/JRE/JDK | JVM runs, JRE provides runtime, JDK develops |
| 43 | HashMap vs Hashtable | HashMap is unsynchronized; Hashtable is legacy synchronized |
| 44 | Reflection | Inspect/use classes at runtime |
| 45 | Thread usage | Thread, Runnable, Lambda, ExecutorService |
| 46 | Thread priority | 1–10; normal priority is 5 |
| 47 | Program vs Process | Program = instructions; Process = executing program |
| 48 | `throw` vs `throws` | Throw exception vs declare exception |
| 49 | Constructor vs Method | Constructor initializes; method performs behavior |

---

# 🧠 One-Line Memory Tricks

### HashSet vs TreeSet

> **HashSet = unique + no sorted order**

> **TreeSet = unique + sorted**

### `char[]` vs String

> **String is immutable; char[] can be cleared.**

### JVM / JRE / JDK

> **JVM runs → JRE provides runtime → JDK develops**

### HashMap / Hashtable

> **HashMap = modern + unsynchronized + null allowed**

> **Hashtable = legacy + synchronized + null not allowed**

### Reflection

> **Reflection = inspect classes at runtime**

### Threads

> **Thread / Runnable / Lambda / ExecutorService**

### Priority

> **1 = minimum, 5 = normal, 10 = maximum**

### Program / Process

> **Program = passive instructions**

> **Process = running program**

### `throw` / `throws`

> **throw = do it**

> **throws = declare it**

### Constructor / Method

> **Constructor = initialize**

> **Method = perform an action**
