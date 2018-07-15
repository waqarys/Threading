# Concurrency Questions
1. What is LOCK interface.
```
Lock interface provide more extensive locking operations than can be obtained using synchronized methods and statements. 
They allow more flexible structuring, may have quite different properties, 
and may support multiple associated Condition objects.
The advantages of a lock are

- it’s possible to make them fair
- it’s possible to make a thread responsive to interruption while waiting on a Lock object.
- it’s possible to try to acquire the lock, but return immediately or after a timeout if the lock can’t be acquired
- it’s possible to acquire and release locks in different scopes, and in different orders
```

2. Difference between LOCK and synchronized
```
Internally Java uses a so called monitor also known as monitor lock or intrinsic lock in order to manage synchronization. 
... A thread can safely acquire the same lock multiple times without running into deadlocks 
(e.g. a synchronized method calls another synchronized method on the same object)
```

3. What is BlockingQueue. Producer Consumer using BlockingQueue
```
java.util.concurrent.BlockingQueue is a Queue that supports operations that wait for the queue to become non-empty when retrieving and removing an element, 
and wait for space to become available in the queue when adding an element.

BlockingQueue doesn’t accept null values and throw NullPointerException if you try to store null value in the queue.

BlockingQueue implementations are thread-safe. 
All queuing methods are atomic in nature and use internal locks or other forms of concurrency control.
```

4. What is Callable and future ?
```
Java 5 introduced java.util.concurrent.Callable interface in concurrency package that is similar to Runnable interface 
but it can return any Object and able to throw Exception.
```

5. What is FutureTask class
```
FutureTask is base concrete implementation of Future interface and provides asynchronous processing. 
It contains the methods to start and cancel a task and also methods 
that can return the state of the FutureTask as whether it’s completed or cancelled. 
```