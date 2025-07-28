# Singleton Pattern

### Definition
Ensure a class has **only one instance** and provide a **global point of access** to it.


### Example: 
Singleton pattern is commonly used in cases of **logging**, **caches**, **thread pools**, **configuration managers**.

For our example we will consider a logger for an application.

#### Problem

Imagine an application where all modules (UI, backend, analytics) log their activity.  
Creating multiple instances of the logger can cause inconsistent logging, overwriting issues or file access conflicts.

#### Solution using the Pattern:

Using a Singleton ensures there's:
1.  **Only one Logger instance** used throughout the app.
2. This guarantees proper working of the logging utility, across the app.
3. Global shared state is centralized and consistent.


#### Implementation Flow details:
1. Private constructor prevents external instantiation using new.

2. `getInstance()` checks whether an instance exists:

    - If not, it enters a synchronized block.

    - Double-checks again to avoid race conditions in multithreaded environments.

3. Creates and returns the Singleton instance.

4. Uses volatile to ensure visibility across threads.

5. The object initialization within the class can be eager or lazy.
6. There needs to be double-checked locking to make the code thread safe, this is not easily implemented in versions of Java older than Java 5.
7. Example of the code includes:
```java
public class Singleton {
    private volatile static Singleton uniqueObject;
    private Singleton() {}
    
    // Other methods... 
    
    public static Singleton getInstance() {
        if(uniqueObject == null) {
            synchronized (Singleton.class) {
                if(uniqueObject == null) uniqueObject = new Singleton();
            }
        }
        return uniqueObject;
    }
}
```
8. Using `synchronized` does make the code thread safe however, it also makes the code significantly slower, this limits the utility and flexiblity of the Singleton pattern.
### Key Concepts:

1. **Controlled Instantiation**: Prevents misuse by restricting access to constructor.

2. **Thread-Safety**: Uses synchronized and volatile for correctness.

3. **Global Access**: All consumers share a single instance.

4. **Performance**: Lazy instantiation with double-checked locking is efficient.

5. **Immutable Identity**: Only one object of its type ever exists.

6. **Single Responsibility Principle**: All singleton classes have 2 responsibilities, the first to make sure that only one object of it's kind exists, the second, to do whatever job it was designed to do, this violates the principle.
7. Singleton classes generally do not support loose coupling.
8. A true singleton class cannot be extended or inherited from cause the constructor is private
9. Vunerable to reflection and serialization attacks, specific protection is needed.

### Code
