# `record` in Java

- introduced in Java 14 (preview)
- became a standard in Java 16
- substitute for a regular data class
- used for creating immutable objects
- cannot be used as an entity class in JPA
- can be used as DTOs (since they are generally readonly)
- fields are final
- extends by default the `Record`
  - hence you record cannot extend another class/record
- the record itself is final, and hence cannot act as a super type
- cannot contain additional fields (member variable)
- can have static final variables
- can also have static/non-static methods


```java
public record Shipper(Integer shipperId, String companyName, String phone){
}
```

equivalent of:

```java
public final class Shipper {
    private final Integer shipperId;
    private final String companyName;
    private final String phone;

    public Shipper(Integer shipperId, String companyName, String phone){
        this.shipperId = shipperId;
        this.companyName = companyName;
        this.phone = phone;
    }

    public Integer getShipperId(){
        return this.shipperId;
    }
    public String getCompanyName(){
        return this.companyName;
    }
    public String getPhone(){
        return this.phone;
    }

    public String toString(){
        //...
    }
    public boolean equals(Object object){
        ///...
    }
    public int hashCode(){
        //...
    }
}
```