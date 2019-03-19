The 6 Java classes in this package are copies of the classes generated from the schemas defining the request of the 3 
web services consumed by this sample app and have been extended with the annotation: 

```
@XmlRootElement(name="...")
```

The change allows in-code marshalling of XML to Objects. 