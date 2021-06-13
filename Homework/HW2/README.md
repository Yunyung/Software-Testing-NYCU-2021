# HW2 - Input Space Partitioning for BoundedQueue

## Lab Requirements

Derive input space partitioning test inputs for the BoundedQueue class with the following method signatures:

public BoundedQueue(int capacity); // The Maximum number of elements
public void enQueue(Object X);
public Object deQueue();
public boolean isEmpty();
public boolean isFull();
Assume the usual semantics for a queue with a fixed, maximal capacity. Try to keep your partitioning simple -- choose a small number of partitions and blocks.

(a) List all of the input variables, including the state variables.

(b) Define the characteristics of the input variables. Make sure you cover all input variables.

(c) Partition the characteristics into blocks. Designate one block in each partition as the "Base" block.

(d) Define values for each block.

(e) Define a test set that satisfies Base Choice Coverage (BCC). Write your tests with the values from the previous step. Be sure to include the test oracles. 
