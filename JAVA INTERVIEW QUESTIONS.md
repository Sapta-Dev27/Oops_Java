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
