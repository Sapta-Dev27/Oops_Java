# 🔐 Java Access Modifiers — Complete Interview Notes

> Complete interview-focused notes for Java Access Modifiers: easy explanations, examples, interview-ready answers, tricky questions, rapid-fire revision, and final cheat sheet.

---

# 📚 Table of Contents

- [1. What are Access Modifiers?](#1-what-are-access-modifiers)
- [2. Why Do We Need Access Modifiers?](#2-why-do-we-need-access-modifiers)
- [3. The Four Access Levels](#3-the-four-access-levels)
- [4. public](#4-public)
- [5. private](#5-private)
- [6. default / package-private](#6-default--package-private)
- [7. protected](#7-protected)
- [8. Access Modifier Comparison](#8-access-modifier-comparison)
- [9. Access Modifier Hierarchy](#9-access-modifier-hierarchy)
- [10. Top-Level Classes](#10-top-level-classes)
- [11. Nested Classes](#11-nested-classes)
- [12. Constructors](#12-constructors)
- [13. Methods and Variables](#13-methods-and-variables)
- [14. Interfaces](#14-interfaces)
- [15. Inheritance](#15-inheritance)
- [16. Method Overriding](#16-method-overriding)
- [17. private, final and static Methods](#17-private-final-and-static-methods)
- [18. Encapsulation](#18-encapsulation)
- [19. Common Interview Questions](#19-common-interview-questions)
- [20. Rapid-Fire Table](#20-rapid-fire-table)
- [21. Interview-Ready Answers](#21-interview-ready-answers)
- [22. Most Important Table](#22-most-important-table)
- [23. One-Line Revision](#23-one-line-revision)
- [24. Final Cheat Sheet](#24-final-cheat-sheet)
- [25. Golden Interview Answer](#25-golden-interview-answer)
- [26. What You MUST Know](#26-what-you-must-know)

---

# 1. What are Access Modifiers?

> **Access modifiers are keywords in Java that control the visibility and accessibility of classes, methods, variables, constructors, and nested types.**

In simple words:

```text
Access Modifier
      ↓
Controls WHO can access something
```

Java has four access levels:

```text
1. public
2. protected
3. default / package-private
4. private
```

### Easy Memory

```text
public
   ↓
Broadest access

protected
   ↓
Same package + subclasses outside package

default
   ↓
Same package

private
   ↓
Same class
```

---

# 2. Why Do We Need Access Modifiers?

Access modifiers are mainly used for:

```text
1. Encapsulation
2. Data hiding
3. Controlled access
4. Security
5. Reducing coupling
6. Better maintainability
```

Example:

```java
class BankAccount {

    private double balance;

    public double getBalance() {
        return balance;
    }
}
```

Outside code cannot directly access `balance`.

### Interview Answer

> "Access modifiers control the visibility of class members. They help us achieve encapsulation, data hiding, controlled access, and maintainable code."

---

# 3. The Four Access Levels

```text
private
   ↓
default / package-private
   ↓
protected
   ↓
public
```

From **most restrictive → least restrictive**:

```text
private < default < protected < public
```

Here `<` means "less accessible than."

---

# 4. public

`public` provides the broadest access.

Example:

```java
public class Student {

    public String name;
}
```

Another accessible class can use:

```java
Student s = new Student();

s.name = "Saptarshi";
```

### Interview Answer

> "A public member has the broadest access and can generally be accessed from classes in other packages, provided the containing type is accessible."

---

# 5. private

`private` provides the most restricted access.

A private member can be directly accessed only inside the class where it is declared.

```java
class BankAccount {

    private double balance;

    void deposit(double amount) {
        balance += amount;
    }
}
```

This is invalid:

```java
BankAccount account = new BankAccount();

account.balance = 1000; // ❌
```

### Interview Answer

> "Private is the most restrictive access level. A private member can be directly accessed only within the class where it is declared."

---

# 6. default / package-private

When no access modifier is specified, Java uses **default**, also called **package-private**, access.

```java
class Student {

    String name;
}
```

`name` is package-private.

It can be accessed by classes in the same package.

It cannot be directly accessed from another package.

### Important

This is invalid:

```java
default String name; // ❌
```

Correct:

```java
String name; // ✅
```

### Interview Answer

> "Default or package-private access means that no access modifier is specified. The member is accessible only within the same package."

---

# 7. protected

`protected` provides:

```text
Same class
+
Same package
+
Subclass in another package
```

Example:

```java
class Animal {

    protected void sound() {
        System.out.println("Animal sound");
    }
}
```

A subclass can access it:

```java
class Dog extends Animal {

    void test() {
        sound(); // ✅
    }
}
```

### Important Protected Rule

Outside the package, protected access is available through the subclass relationship. It is **not unrestricted access through any Parent object**.

### Interview Answer

> "Protected members are accessible within the same package and also by subclasses outside the package, subject to Java's protected access rules."

---

# 8. Access Modifier Comparison

| Modifier | Same Class | Same Package | Subclass Outside Package | Other Package |
|---|---:|---:|---:|---:|
| `private` | ✅ | ❌ | ❌ | ❌ |
| default | ✅ | ✅ | ❌ | ❌ |
| `protected` | ✅ | ✅ | ✅* | ❌ |
| `public` | ✅ | ✅ | ✅ | ✅ |

`*` Outside the package, protected access is through inheritance and is subject to additional rules.

### Easy Table

```text
                 SAME     SAME       CHILD        OTHER
                 CLASS    PACKAGE    OTHER PKG    PACKAGE

private           ✅        ❌          ❌            ❌

default           ✅        ✅          ❌            ❌

protected         ✅        ✅          ✅*           ❌

public            ✅        ✅          ✅            ✅
```

---

# 9. Access Modifier Hierarchy

From most restrictive to least restrictive:

```text
private
   ↓
default
   ↓
protected
   ↓
public
```

### Memory Trick

```text
private
   ↓
class

default
   ↓
package

protected
   ↓
package + child

public
   ↓
broadest access
```

---

# 10. Top-Level Classes

A top-level class can be:

```java
public class Student {
}
```

or:

```java
class Student {
}
```

The second is package-private.

A top-level class cannot be:

```java
private class Student { // ❌
}
```

or:

```java
protected class Student { // ❌
}
```

### Interview Answer

> "A top-level class can be public or package-private. It cannot be private or protected."

---

# 11. Nested Classes

A nested/member class can have access modifiers.

```java
class Outer {

    private class Inner1 {
    }

    protected class Inner2 {
    }

    public class Inner3 {
    }

    class Inner4 {
    }
}
```

So nested classes can use:

```text
private
default
protected
public
```

### Interview Question

> Can an inner class be private?

**Yes.**

---

# 12. Constructors

Constructors can have all four access levels.

## public constructor

```java
class Student {

    public Student() {
    }
}
```

## protected constructor

```java
class Parent {

    protected Parent() {
    }
}
```

## default constructor

```java
class Student {

    Student() {
    }
}
```

## private constructor

```java
class Singleton {

    private Singleton() {
    }
}
```

A private constructor prevents other classes from directly creating objects:

```java
Singleton s = new Singleton(); // ❌
```

### Common Use

```text
Singleton Pattern
```

### Interview Answer

> "Yes, constructors can have all four access levels. A private constructor can be used to restrict object creation."

---

# 13. Methods and Variables

Methods and fields can use:

```text
public
protected
default
private
```

Example:

```java
class Example {

    public void method1() {
    }

    protected void method2() {
    }

    void method3() {
    }

    private void method4() {
    }
}
```

Fields:

```java
class Student {

    public String name;

    protected int age;

    String college;

    private double marks;
}
```

### Good Design

Instead of exposing mutable fields publicly:

```java
public double balance;
```

prefer controlled access:

```java
private double balance;

public double getBalance() {
    return balance;
}
```

---

# 14. Interfaces

Modern Java interfaces can contain:

```text
public abstract methods
default methods
static methods
private methods
```

Example:

```java
interface Payment {

    void pay();

    default void receipt() {
        System.out.println("Receipt");
    }

    static void info() {
        System.out.println("Payment");
    }

    private void validate() {
        System.out.println("Validation");
    }
}
```

A protected interface method is not allowed:

```java
interface Test {

    protected void show(); // ❌
}
```

### Interview Answer

> "Interface abstract methods are public by default. Modern Java interfaces can also contain default, static, and private methods, but protected interface methods are not allowed."

---

# 15. Inheritance

Access modifiers affect what a child class can directly access from its parent.

```java
class Parent {

    private int a;

    int b;

    protected int c;

    public int d;
}
```

A child in the same package can directly access:

```text
b
c
d
```

but not:

```text
a
```

A child in another package can access:

```text
c
d
```

through the appropriate inheritance rules, but not:

```text
a
b
```

### Important

A child class does not get direct access to private parent members.

---

# 16. Method Overriding

🔥 **Very important interview topic.**

When overriding a method:

> **The child cannot reduce the visibility of the parent method.**

Example:

```java
class Parent {

    protected void show() {
    }
}
```

This is valid:

```java
class Child extends Parent {

    public void show() {
    }
}
```

because:

```text
protected → public
```

Visibility increased.

But this is invalid:

```java
class Child extends Parent {

    private void show() { // ❌
    }
}
```

because visibility decreased.

### Rule

```text
Same visibility       → ✅
Higher visibility     → ✅
Lower visibility      → ❌
```

---

# 17. private, final and static Methods

## Can a private method be overridden?

**No.**

```java
class Parent {

    private void show() {
    }
}
```

```java
class Child extends Parent {

    private void show() {
    }
}
```

The `show()` in `Child` is not an override. It is a separate method.

### Why?

Private methods are not inherited for overriding.

---

## Can a final method be overridden?

**No.**

```java
class Parent {

    public final void show() {
    }
}
```

```java
class Child extends Parent {

    public void show() { // ❌
    }
}
```

### Can a final method be private?

Yes:

```java
class Test {

    private final void show() {
    }
}
```

A private method is already not inherited for overriding, so `final` does not add the usual overriding restriction here.

---

## Can a final method be protected?

Yes:

```java
class Parent {

    protected final void show() {
    }
}
```

A child can access it according to protected rules but cannot override it.

---

## Can a static method be overridden?

**No.**

Static methods are associated with the class, not dynamically overridden on objects.

If a subclass declares a static method with the same signature, it is **method hiding**, not overriding.

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

### Interview Answer

> "Static methods cannot be overridden. A static method declared again in a subclass is hidden, not overridden."

---

# 18. Encapsulation

Access modifiers are an important tool for encapsulation.

Example:

```java
class BankAccount {

    private double balance;

    public void deposit(double amount) {

        if (amount > 0) {
            balance += amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}
```

Instead of allowing:

```java
account.balance = -1000; // ❌
```

the class controls how its internal state changes.

### Interview Answer

> "Access modifiers support encapsulation by hiding internal implementation details and exposing only the operations that should be available to other classes."

---

# 19. Common Interview Questions

## Basic

```text
1. What are access modifiers?

2. How many access modifiers does Java have?

3. What is public?

4. What is private?

5. What is protected?

6. What is default access?

7. What is package-private?

8. Which is the most restrictive?

9. Which is the least restrictive?

10. What is the difference between default and protected?
```

---

## Intermediate

```text
11. Can a top-level class be private?

12. Can a top-level class be protected?

13. Can an inner class be private?

14. Can a constructor be private?

15. Can a constructor be protected?

16. Can an interface have private methods?

17. Can an interface have protected methods?

18. Can local variables have access modifiers?

19. Can method parameters have access modifiers?

20. Can private methods be overridden?
```

---

## Tricky

```text
21. Can access modifiers be changed while overriding?

22. Can a child reduce the visibility of a parent method?

23. Can a child increase the visibility of a parent method?

24. Why can't an abstract method be private?

25. Can a final method be private?

26. Can a final method be protected?

27. Can a static method be overridden?

28. Can a private method be overridden?

29. Can a subclass access private members?

30. Can a subclass access protected members from another package?
```

---

# 20. Rapid-Fire Table

| Question | Answer |
|---|---|
| Number of access modifiers | 4 |
| Most restrictive | `private` |
| Least restrictive | `public` |
| Same class | All four, according to declaration |
| Same package | default, protected, public; private only in declaring class |
| Other package | `public` |
| Other-package subclass | `protected`, `public` |
| Top-level class private? | ❌ |
| Top-level class protected? | ❌ |
| Nested class private? | ✅ |
| Nested class protected? | ✅ |
| Constructor private? | ✅ |
| Constructor protected? | ✅ |
| Interface private methods? | ✅ |
| Interface protected methods? | ❌ |
| Local variable private? | ❌ |
| Parameter public? | ❌ |
| Private method overridden? | ❌ |
| Final method overridden? | ❌ |
| Static method overridden? | ❌ |
| Can visibility increase during overriding? | ✅ |
| Can visibility decrease during overriding? | ❌ |
| Private field directly accessible by child? | ❌ |
| Protected field accessible by child? | ✅, subject to protected rules |
| Public field accessible by child? | ✅ |
| Default field accessible by child in same package? | ✅ |
| Default field accessible by child in another package? | ❌ |

---

# 21. Interview-Ready Answers

## Q1. What are access modifiers?

> **"Access modifiers are keywords in Java that control the visibility and accessibility of classes, methods, variables, constructors, and nested types. Java provides public, protected, default or package-private, and private access."**

---

## Q2. How many access modifiers does Java have?

> **"Java has four access levels: public, protected, default or package-private, and private."**

---

## Q3. What is public?

> **"Public provides the broadest access. A public member can generally be accessed from classes in other packages, provided the containing type is accessible."**

---

## Q4. What is private?

> **"Private is the most restrictive access level. A private member can be directly accessed only within the class where it is declared."**

---

## Q5. What is protected?

> **"Protected members are accessible within the same package and also by subclasses outside the package, subject to Java's protected access rules."**

---

## Q6. What is default access?

> **"Default, also called package-private, means no access modifier is specified. The member can be accessed only within the same package."**

---

## Q7. What is package-private?

> **"Package-private is another name for default access. It means that no access modifier is written and the member is accessible within the same package."**

---

## Q8. Which is the most restrictive?

> **"Private is the most restrictive access level."**

---

## Q9. Which is the least restrictive?

> **"Public provides the broadest access."**

---

## Q10. Difference between default and protected?

> **"Both provide access within the same package, but protected additionally allows access to subclasses located in other packages, subject to protected access rules."**

---

## Q11. Can a top-level class be private?

> **"No. A top-level class can be public or package-private, but it cannot be private or protected."**

---

## Q12. Can a top-level class be protected?

> **"No. Protected is not allowed for top-level classes. A top-level class can be public or package-private."**

---

## Q13. Can an inner class be private?

> **"Yes. A nested/member class is a member of the enclosing class, so it can be declared private."**

---

## Q14. Can a constructor be private?

> **"Yes. A private constructor prevents other classes from directly creating objects. It is commonly used when object creation needs to be controlled, such as in a Singleton design."**

---

## Q15. Can a constructor be protected?

> **"Yes. A protected constructor can be accessed within the same package and by appropriate subclasses."**

---

## Q16. Can an interface have private methods?

> **"Yes. Modern Java interfaces can have private methods, which are useful as internal helper methods for default and static methods."**

---

## Q17. Can an interface have protected methods?

> **"No. Protected methods are not allowed in interfaces. Interface abstract methods are public, and modern interfaces can also contain default, static, and private methods."**

---

## Q18. Can local variables have access modifiers?

> **"No. Local variables cannot use access modifiers such as public, protected, or private. Their scope is already limited to the block or method where they are declared."**

Invalid:

```java
void test() {

    private int x = 10; // ❌
}
```

---

## Q19. Can method parameters have access modifiers?

> **"No. Method parameters cannot be declared with Java access modifiers."**

Invalid:

```java
void test(public int x) { // ❌
}
```

---

## Q20. Can private methods be overridden?

> **"No. Private methods are not inherited by subclasses for overriding, so they cannot be overridden."**

---

## Q21. Can access modifiers be changed while overriding?

> **"Yes, but visibility cannot be reduced. An overriding method must have the same or broader visibility than the method it overrides."**

---

## Q22. Can a child reduce the visibility of a parent method?

> **"No. Java does not allow an overriding method to reduce the visibility of the parent method."**

Example:

```text
protected → private ❌
public → protected ❌
```

---

## Q23. Can a child increase the visibility of a parent method?

> **"Yes. An overriding method can increase visibility."**

Example:

```text
protected → public ✅
```

---

## Q24. Why can't an abstract method be private?

> **"An abstract method must be implemented by a subclass, but a private method is not inherited and cannot be overridden. Therefore, an abstract method cannot be private."**

Invalid:

```java
abstract class Animal {

    private abstract void sound(); // ❌
}
```

---

## Q25. Can a final method be private?

> **"Yes. A final method can be private. However, private methods are not inherited for overriding anyway, so final does not provide the usual additional overriding restriction in this case."**

---

## Q26. Can a final method be protected?

> **"Yes. A protected method can be final. It can be accessed according to protected rules, but subclasses cannot override it."**

---

## Q27. Can a static method be overridden?

> **"No. Static methods belong to the class rather than the object. If a subclass declares a static method with the same signature, it is method hiding, not overriding."**

---

## Q28. Can a private method be overridden?

> **"No. Private methods are not inherited by subclasses, so they cannot be overridden."**

---

## Q29. Can a subclass access private members?

> **"A subclass cannot directly access private members declared in its parent. Private members are directly accessible only within the class that declares them."**

---

## Q30. Can a subclass access protected members from another package?

> **"Yes, a subclass in another package can access inherited protected members through the inheritance relationship, subject to Java's protected access rules. Protected does not mean unrestricted access through any parent-class object."**

---

# 22. Most Important Table to Memorize

```text
                 SAME     SAME       CHILD        OTHER
                 CLASS    PACKAGE    OTHER PKG    PACKAGE

private           ✅        ❌          ❌            ❌

default           ✅        ✅          ❌            ❌

protected         ✅        ✅          ✅*           ❌

public            ✅        ✅          ✅            ✅
```

### Memory Trick

```text
private
   ↓
class

default
   ↓
package

protected
   ↓
package + child

public
   ↓
broadest access
```

---

# 23. One-Line Interview Revision

```text
private   → same class only

default   → same package

protected → same package + subclasses outside package

public    → broadest access
```

---

# 24. Final Cheat Sheet

## Access Levels

```text
private < default < protected < public
```

---

## Top-Level Class

```text
public
default / package-private
```

Allowed.

Not allowed:

```text
private
protected
```

---

## Class Members

```text
private
default
protected
public
```

---

## Constructors

```text
private
default
protected
public
```

All four are allowed.

---

## Interface Methods

Modern Java interfaces can contain:

```text
abstract
default
static
private
```

Protected interface methods:

```text
❌
```

---

## Overriding

```text
Same visibility       → ✅

Higher visibility     → ✅

Lower visibility      → ❌
```

---

## private

```text
Not directly accessible by child
Not inherited for overriding
Cannot be overridden
```

---

## final

```text
Cannot be overridden
```

---

## static

```text
Cannot be overridden
Same-signature subclass declaration = method hiding
```

---

# 25. Golden Interview Answer

> **"Java provides four access levels: private, default or package-private, protected, and public. Private members are accessible only within the declaring class, default members within the same package, protected members within the same package and through subclass access outside the package, and public members have the broadest access. Access modifiers are mainly used for encapsulation, data hiding, and controlled access."**

---

# 26. What You MUST Know

If you have limited time before the interview, memorize these **10 points**:

```text
1. Java has 4 access levels.

2. private → same class only.

3. default → same package.

4. protected → same package + subclasses outside package,
   subject to protected access rules.

5. public → broadest access.

6. Top-level classes cannot be private or protected.

7. Constructors can have all four access levels.

8. Private methods cannot be overridden.

9. Overriding cannot reduce visibility.

10. Access modifiers are an important part of encapsulation.
```

---

# 🧠 Final Memory Map

```text
                    ACCESS MODIFIERS
                           |
          ┌────────────────┼────────────────┐
          ↓                ↓                ↓
       private          default          protected
          |                |                |
      same class       same package    same package
                                           +
                                       child classes
                                           |
                                           ↓
                                         public
                                           |
                                    broadest access
```

## The 4 Lines You Should Say in an Interview

```text
private   → same class

default   → same package

protected → same package + subclasses outside package

public    → broadest access
```

## The 3 Tricky Rules

```text
1. private methods cannot be overridden.

2. overriding cannot reduce visibility.

3. static methods are hidden, not overridden.
```

## Final Connection

```text
Access Modifiers
       ↓
Controlled Access
       ↓
Encapsulation
       ↓
Data Hiding
       ↓
Maintainable Code
```

> **Interview Tip:** Be especially ready for follow-up questions about `protected` across packages, private methods, method overriding, static method hiding, and why abstract methods cannot be private.
