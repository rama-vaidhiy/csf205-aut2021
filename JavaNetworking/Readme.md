# Java Networking 
This folder contains sources for 
1. Java TCP Server, and a Client
2. Java UDP Server, a Java Client, and a Python Client
3. Java RMI interface, Server implementation, and a Client
4. Java CORBA implementation using JACORB (This is not required for the assessments. The code is here only for demonstration purposes)

They all perform the same task (client sends a language and server responds back by sending the language equivalent of the word 'hello'). It is a very simple task used for illustration purposes. 

As part of the labs, you need to:

1. Create a Server (*say RandomServer*) which **_does not take any request data_** from the Client but on establishing a connection **_sends a random number_** to the Client. You can choose to implement this using either TCP or UDP and it can either be threaded or non-threaded, entirely your choice.
2. Create a Server (*say CalculatorServer*) which **_takes in two numbers [x, y] and an operation [add, sub, mul, div]_** from the Client and then performs the requested operation on the two numbers and **_returns the result of the operation_** to the Client. If your option for task 1 was TCP, then implement this using UDP and vice versa. Having the server in a threaded or non-threaded fashion is your choice.

**_Note_**:
* Your code should be functional 
* You need not use packages, if you don't want to
* Both Server and Client should be in Java, although you can additionally add Clients in different languages of your choice. 

You can work in **groups** and you can use the provided source code as your reference. 
