#!/usr/bin/python3
#@author rama_swuni
import socket
#Sample Python UDP Client Program to illustrate the networking concepts
#where this client calls a Java UDP Server with a language it wants the
#word 'hello' to be represented in and receives the response from the java
#server
host = '127.0.0.1'
port = 2929
bufferSize = 256
bytesToSend = str.encode('Spanish')
#Create a socket and specify it to be a datagram socket instead of the one that
#uses the streams (TCP)
s = socket.socket(socket.AF_INET,socket.SOCK_DGRAM)
#Send the bytes (message) to the host and port (just like in the java client)
s.sendto(bytesToSend,(host,port))
#receive the buffer from the server
msgFromServer = s.recvfrom(bufferSize)
#decode it and print it in the console
msg = "Message from Server: {}".format(msgFromServer[0].decode('utf-8'))
print(msg)
