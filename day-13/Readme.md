# JPA Query Language

- influenced by Hibernate Query Language
  - which is the way hibernate allows the entity objects to be queried
  - HQL will be converted into SQL by hibernate using a proper dialect
- Use class names where table names are used in SQL
- Use field names instead of column names

Key aspects of JPQL

- entity-centric
- object oriented
  - object graph can be used in queries
    - for example: `where p.supplier.address.city = 'Bangalore'`
- portable across different db vendors
  - JPQL to SQL conversion is done by using an appropriate dialect class
    - for example: `org.hibernate.dialect.H2Dialect`
- syntax is very similar to SQL
- supports named queries
  - queries exists in either XML files or annotated entity classes, and can be referenced in your DAO layer using names
- support for native queries
- support for pagination, sorting etc

# Syntax:

```sql
SELECT * FROM CUSTOMERS WHERE CITY = 'London';
```

JPQL version of the above:

- select c1 from com.infosys.entity.Customer c1 where c1.address.city = 'London'
- select c1 from Customer c1 where c1.address.city = 'London'
- from Customer where address.city = 'London'

# API

- jakarta.persistence.Query
- jakarta.persistence.TypedQuery
