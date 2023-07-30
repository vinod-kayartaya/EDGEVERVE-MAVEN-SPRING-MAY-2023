# Spring data JPA

- Framework that simplifies the implementation of the JPA based repositories (DAO classes)
- A Specification based on set of interfaces
- Opinionated
- provides high level abstractions (methods to do stuff)
  - findById
  - findAll
  - save
  - remove
  - (custom finders are also allowed)
    - findByEmail
    - findByEmailOrPhone
    - findAllByUnitPriceBetween

Some key concepts and features Spring Data JPA:

- Repositories
  - a bunch of interfaces that are introduced by Spring to handle a variety of CRUD and query operations on an `entity`
    - JpaRepository
    - CrudRepository
    - PagingAndSortingRepository
  - we have to write an interface that extend any of the above, and Spring during runtime will create an object of a class that implements our interface
- Entity Mapping
  - Spring data JPA depends on the entity classes annotated with @Entity (and other related annotations)
