# Java Concurrency API

### Basic Concurrency classes
- Thread class
- Runnable Interface
- ThreadLocal Class : stores variables locally to a thread
- ThreadFactory Interface : Factory design pattern

### Synchronization Mechanism
- synchronised keyword
- Lock Interface: 
    - ReentrantLock
    - ReentrantReadWriteLock
    - StampLock(Java 8)
- Semaphore Class: 
- CountDownLatch: A class that allows a task to wait for the finalization of multiple operations.
- CyclicBarrier: A class that allows the synchronization of multiple threads at a common point.
- Phaser Class: A class that allows you to control the execution of tasks divided into phases. None of the tasks advance to the next phase until all of the tasks have finished the current phase.

### Executors
- The Executor and ExecutorService interface: This includes the execute() method common to all executors
- ThreadPoolExecutor
- ScheduledThreadPoolExecutor
- Executors: This is a class that facilitates the creation of executors
- Callable Interface: Returns a value
- Future Interface: obtain value from a Callable.

### Fork/Join Framework
Uses divide-and-conquer technique.
- ForkJoinPool: This is a class that implements the executor that is going to run the tasks
- ForkJoinTask: This is a task that can be executed in the ForkJoinPool class
- ForkJoinWorkerThread: This is a thread that is going to execute tasks in the ForkJoinPool class

### Parallel Streams
- Stream Interface
- Optional
- Collectors
- Lambda expressions

### Concurrent data structures
- ConcurrentLinkedDeque: This is a non-blocking list
- ConcurrentLinkedQueue: This is a non-blocking queue
- LinkedBlockingDeque: This is a blocking list
- LinkedBlockingQueue: This is a blocking queue
- PriorityBlockingQueue: This is a blocking queue that orders its elements based on their priority
- ConcurrentSkipListMap: This is a non-blocking navigable map
- ConcurrentHashMap: This is a non-blocking hash map
- AtomicBoolean, AtomicInteger, AtomicLong, and AtomicReference: These are atomic implementations of the basic Java data types
back 

# Concurrency Design Pattern

### Signalling
This design pattern explains how to implement the situation where a task has to notify an event to another task.

Implementation: 
- Semaphore or a mutex, using the ReentrantLock.
- wait() and notify() methods.

### Rendezvous

###Mutex
only One task can execute the portion of code protected by the mutex at once.
You can implement a critical section using the synchronized keyword (that allows you to protect a portion of code or a full method), the ReentrantLock class, or the Semaphore class.

### Multiplex
The Multiplex design pattern is a generalization of the Mutex.
In this case, a determined number of tasks can execute the critical section at once.
This design pattern can be implemented with `Semaphore`
```aidl
public void task() { 
  preCriticalSection(); 
  semaphoreObject.acquire(); 
  criticalSection(); 
  semaphoreObject.release(); 
  postCriticalSection(); 
}
```

### Barrier
This design pattern explains how to implement the situation where you need to synchronize some tasks at a common point.
```aidl
public void task() { 
  preSyncPoint(); 
  barrierObject.await(); 
  postSyncPoint(); 
} 
```

### Double-checked locking
This design pattern provides a solution to the problem that occurs when you acquire a lock and then check for a condition.

```aidl
public class Singleton{ 
  private Object reference; 
  private Lock lock=new ReentrantLock(); 
  public Object getReference() { 
    if (reference==null) { 
      lock.lock(); 
      if (reference == null) { 
        reference=new Object(); 
      } 
      lock.unlock(); 
    } 
    return reference; 
  } 
} 
```

### Read-Write Lock
A lock provides poor performance if there are multiple reads and only few writes.
Read-write lock can be used here.
- If one task is doing a read operation and another task wants to do another read operation, it can do it
- If one task is doing a read operation and another task wants to do a write operation, it's blocked until all the readers finish
- If one task is doing a write operation and another task wants to do an operation (read or write), it's blocked until the writer finishes

The Java Concurrency API includes the class ReentrantReadWriteLock that implements this design pattern.

### ThreadPool
This design pattern tries to remove the overhead introduced by creating a thread per task you want to execute.

The Java Concurrency API includes some classes that implement the ExecutorService interface that internally uses a pool of threads.

### Thread local storage
This design pattern defines how to use global or static variables locally to tasks. 

# Tips and Tricks
