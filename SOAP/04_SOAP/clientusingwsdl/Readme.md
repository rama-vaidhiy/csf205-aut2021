# SOAP 
This folder consists of a WSDL file retrieved from the server and a Java Client.

Using the WSDL file generate the Java Proxies using the *wsimport* command.

The *_wsimport Hello.wsdl_* will generate a set of file (in a package). Using the generated files and the jaxws-ri jar files (along with activation-1.1.jar) in the classpath compile the client program. _You dont need the jaxws-ri and activation jar for compilation but you will need it for execution_.

Start the server (steps provided to do that using Eclipse) and run the client (ensure to use the classpath as provided above for compilation).   
