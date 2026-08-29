# 🔗 Association, Aggregation & Composition — Complete Interview Q&A

> Complete Java/LLD interview notes covering all 30 questions, answers, examples, UML notation, lifecycle, ownership, and rapid-fire revision.

---

# 📚 Quick Memory

```text
Association
    ↓
General relationship

Aggregation
    ↓
Weak HAS-A
    ↓
Part can exist independently

Composition
    ↓
Strong HAS-A
    ↓
Part is strongly tied to whole

Inheritance
    ↓
IS-A
```

---

# 1–10. Basic Interview Questions

## Q1. What is association?

**Answer:** Association is a general relationship between two classes where their objects are connected or interact.

**Easy example:**
```text
Teacher ─── Student
```

A teacher can interact with a student, but this relationship does not by itself imply ownership.

**Interview line:**  
> "Association is a general relationship between two classes where objects of one class are connected to or interact with objects of another class. It does not necessarily imply ownership." 

---

## Q2. What is aggregation?

**Answer:** Aggregation is a **weak HAS-A** whole-part relationship.

The whole contains or groups the part, but the part can exist independently.

```text
Department ◇── Employee
```

If the department disappears, an employee can still exist.

**Interview line:**  
> "Aggregation is a weak HAS-A relationship where the contained object can exist independently of the containing object." 

---

## Q3. What is composition?

**Answer:** Composition is a **strong HAS-A** whole-part relationship.

The part has a strong lifecycle dependency on the whole.

```text
House ◆── Room
```

**Interview line:**  
> "Composition is a strong HAS-A relationship where the part's lifecycle is strongly tied to the whole." 

---

## Q4. What is a HAS-A relationship?

**Answer:** HAS-A means one class contains, owns, or uses an object of another class.

```java
class Car {
    private Engine engine;
}
```

```text
Car HAS-A Engine
```

HAS-A relationships are commonly modeled using object references.

---

## Q5. What is an IS-A relationship?

**Answer:** IS-A represents inheritance.

```java
class Dog extends Animal {
}
```

```text
Dog IS-A Animal
```

The child class is a type of the parent class.

---

## Q6. Difference between IS-A and HAS-A?

**Answer:**

| IS-A | HAS-A |
|---|---|
| Represents inheritance | Represents object relationship |
| Usually uses `extends` | Usually uses object references |
| Dog IS-A Animal | Car HAS-A Engine |

```java
class Dog extends Animal { }
```

```java
class Car {
    private Engine engine;
}
```

---

## Q7. Is aggregation a type of association?

**Answer:** Yes. Aggregation is a specialized whole-part form of association with weak ownership.

```text
Association
    ↓
Aggregation
```

It adds a whole-part relationship to the general association.

---

## Q8. Is composition a type of association?

**Answer:** Yes. Composition is a stronger whole-part form of association with strong ownership and lifecycle dependency.

---

## Q9. Does Java have an aggregation keyword?

**Answer:** No.

Java has no keyword such as:

```java
aggregation
```

Aggregation is modeled using object references and the way objects are related, owned, and managed.

---

## Q10. Does Java have a composition keyword?

**Answer:** No.

Java has no `composition` keyword. Composition is modeled using object references together with strong ownership/lifecycle relationships.

---

# 11–20. Intermediate Interview Questions

## Q11. Difference between association and aggregation?

**Answer:** Association is a general relationship. Aggregation is a specific whole-part relationship with weak ownership.

```text
Association
    ↓
Objects are related

Aggregation
    ↓
Whole-part + weak ownership
    ↓
Part can exist independently
```

---

## Q12. Difference between aggregation and composition?

**Answer:**

| Aggregation | Composition |
|---|---|
| Weak HAS-A | Strong HAS-A |
| Weak ownership | Strong ownership |
| Part can exist independently | Part is strongly tied to whole |
| Lifecycle is independent | Lifecycle is strongly dependent |

Examples:

```text
Department ◇── Employee
House ◆── Room
```

---

## Q13. What is weak ownership?

**Answer:** Weak ownership means the whole contains or groups a part, but the part can exist independently.

Example:

```text
Department ◇── Employee
```

An employee can continue to exist even if the department object is removed from the model.

---

## Q14. What is strong ownership?

**Answer:** Strong ownership means the whole controls the lifecycle of the part, and the part is strongly tied to the whole.

Example:

```text
House ◆── Room
```

---

## Q15. What is lifecycle dependency?

**Answer:** Lifecycle dependency means the existence/lifetime of one object is tied to another object's lifetime.

In composition:

```text
Whole
  ↓
controls/strongly owns
  ↓
Part
```

This is stronger than a normal association or aggregation.

---

## Q16. Can the child exist without the parent in aggregation?

**Answer:** Yes.

That is one of the main ideas of aggregation.

```text
Department ◇── Employee

Department removed
       ↓
Employee can still exist
```

---

## Q17. Can the child exist independently in composition?

**Answer:** In the modeled composition relationship, the part is strongly lifecycle-dependent on the whole. Therefore, the intended answer is **no**.

```text
House ◆── Room
```

The room is treated as part of the house's lifecycle.

---

## Q18. How do you implement aggregation in Java?

**Answer:** Use an object reference where the contained object can be created independently.

```java
class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }
}

class Department {
    private List<Employee> employees;

    Department(List<Employee> employees) {
        this.employees = employees;
    }
}
```

Usage:

```java
Employee e1 = new Employee("A");

Department d = new Department(
    List.of(e1)
);
```

The employee exists independently of the department.

---

## Q19. How do you implement composition in Java?

**Answer:** Use an object reference with strong ownership/lifecycle management. A common simple example is when the containing class creates the contained object.

```java
class Engine {
    void start() {
        System.out.println("Engine started");
    }
}

class Car {
    private Engine engine;

    Car() {
        engine = new Engine();
    }

    void startCar() {
        engine.start();
    }
}
```

Here the `Car` creates and owns its `Engine` in this design.

---

## Q20. Why is composition preferred over inheritance?

**Answer:** Composition usually gives more flexibility and reduces tight coupling.

Inheritance creates a fixed parent-child relationship:

```text
Parent
  ↑
Child
```

Composition lets us replace or combine behavior:

```java
class Car {
    private Engine engine;

    Car(Engine engine) {
        this.engine = engine;
    }
}
```

**Interview line:**  
> "Composition is often preferred over inheritance because it reduces coupling and allows behavior to be changed by composing different objects." 

---

# 21–30. Tricky Interview Questions

## Q21. Is aggregation actually enforced by Java?

**Answer:** No.

Aggregation is an object-oriented modeling concept. Java does not enforce it with a special keyword.

The distinction comes from the relationship, ownership, and lifecycle of the objects.

---

## Q22. Is composition actually enforced by Java?

**Answer:** No.

Java does not have a special composition keyword. Composition is modeled through object references and the ownership/lifecycle semantics designed by the programmer.

---

## Q23. Can an aggregated object exist independently?

**Answer:** Yes.

Independent existence is a key characteristic of aggregation.

```text
Department ◇── Employee
```

The employee can exist separately from the department.

---

## Q24. Can a composed object be shared?

**Answer:** For a strict composition model, the part is strongly owned by one whole and its lifecycle is tied to that whole, so sharing the same part across multiple wholes would generally conflict with that model.

**Interview-safe answer:**  
> "Strict composition implies strong ownership, so the part is generally not shared between multiple owners." 

---

## Q25. Difference between association and composition?

**Answer:** Association only says that two objects are related. Composition additionally says there is a strong whole-part relationship and strong ownership/lifecycle dependency.

```text
Association
Teacher ─── Student

Composition
House ◆── Room
```

---

## Q26. How do you represent aggregation in UML?

**Answer:** Aggregation is represented using a **hollow diamond**:

```text
◇──────────
```

The diamond is placed on the **whole/aggregate side**.

Example:

```text
Department ◇──── Employee
```

---

## Q27. How do you represent composition in UML?

**Answer:** Composition is represented using a **filled diamond**:

```text
◆──────────
```

The diamond is placed on the **whole/composite side**.

Example:

```text
House ◆──── Room
```

---

## Q28. Where is the diamond placed in UML?

**Answer:** The diamond is placed on the **whole/owner side**.

```text
Department ◇──── Employee
     ↑
   whole

House ◆──── Room
 ↑
whole
```

`◇` = aggregation  
`◆` = composition

---

## Q29. What is multiplicity?

**Answer:** Multiplicity tells us how many objects can participate in a relationship.

Common UML multiplicities:

```text
1      → exactly one
*      → many
0..1   → zero or one
1..*   → one or more
```

Example:

```text
Teacher 1 ───── * Student
```

means one teacher can be related to many students.

---

## Q30. Difference between aggregation and composition in terms of lifecycle?

**Answer:** The main difference is lifecycle dependency.

```text
Aggregation
    ↓
Weak ownership
    ↓
Part can survive independently

Composition
    ↓
Strong ownership
    ↓
Part is strongly tied to whole
```

Example:

```text
Department ◇── Employee
House ◆── Room
```

---

# 35. Rapid-Fire Interview Table

| Question | Answer |
|---|---|
| Association | General relationship between classes/objects |
| Aggregation | Weak whole-part relationship |
| Composition | Strong whole-part relationship |
| IS-A | Inheritance |
| HAS-A | Object/reference relationship |
| Aggregation ownership | Weak |
| Composition ownership | Strong |
| Aggregation lifecycle | Part can exist independently |
| Composition lifecycle | Part is strongly tied to whole |
| Association requires ownership? | No |
| Aggregation is association? | Yes |
| Composition is association? | Yes, as a stronger whole-part relationship |
| Java keyword for aggregation? | None |
| Java keyword for composition? | None |
| Aggregation represented using | Object references + relationship/ownership |
| Composition represented using | Object references + strong ownership/lifecycle |
| UML aggregation | Hollow diamond `◇` |
| UML composition | Filled diamond `◆` |
| UML inheritance | Hollow triangle `△` |
| Multiplicity `*` | Many |
| Multiplicity `1` | Exactly one |
| `0..1` | Zero or one |
| `1..*` | One or more |

---

# 36. Most Important Comparison

| Relationship | Meaning | Ownership | Lifecycle |
|---|---|---|---|
| Association | General relationship | None required | Independent |
| Aggregation | Weak whole-part | Weak | Part can exist independently |
| Composition | Strong whole-part | Strong | Part strongly tied to whole |
| Inheritance | IS-A relationship | Not ownership | Type relationship |

---

# 37. UML Symbols to Memorize

```text
Association:
────────────

Aggregation:
◇──────────

Composition:
◆──────────

Inheritance:
△──────────
```

### Memory

```text
◇ = hollow diamond = aggregation
◆ = filled diamond = composition
△ = hollow triangle = inheritance
```

---

# 38. The Most Important Interview Difference

```text
Association
    ↓
"We are related."

Aggregation
    ↓
"I have you, but you can exist without me."

Composition
    ↓
"I strongly own you; your lifecycle is tied to me."

Inheritance
    ↓
"You are a type of me."
```

---

# 39. Java Implementation Summary

## Association

```java
class Teacher {
    void teach(Student student) {
        // interaction
    }
}
```

## Aggregation

```java
class Department {
    private List<Employee> employees;

    Department(List<Employee> employees) {
        this.employees = employees;
    }
}
```

Objects are supplied independently.

## Composition

```java
class Car {
    private Engine engine;

    Car() {
        engine = new Engine();
    }
}
```

The containing object creates/manages the contained object in this design.

---

# 40. Final Interview Answer

> **"Association is a general relationship between two classes. Aggregation is a weak HAS-A whole-part relationship where the part can exist independently of the whole. Composition is a strong HAS-A relationship where the part's lifecycle is strongly tied to the whole. Inheritance represents an IS-A relationship. Java has no separate keywords for aggregation or composition; they are modeled using object references and ownership/lifecycle relationships."**

---

# 🧠 Final 5 Things to Memorize

```text
1. Association = general relationship.

2. Aggregation = weak HAS-A.

3. Composition = strong HAS-A.

4. Inheritance = IS-A.

5. Java has no special aggregation/composition keywords.
```

### One-Line Revision

```text
Association → Relationship
Aggregation → Weak HAS-A
Composition → Strong HAS-A
Inheritance → IS-A
```
