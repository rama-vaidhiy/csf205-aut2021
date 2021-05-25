from suds.client import Client
client = Client("http://localhost:8080/HelloService/services/Hello?wsdl")
print (client)
response = client.service.sayHello()
print (response)
