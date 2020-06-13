### Behavior and State in java

- Person class is not optimal due to lot of usage of primitive data types
  (Primitive Obsession lol :D)

- We have a Object Oriented Model ;
  To achieve rich domain model avoid primitives most of the times.

- Decide what makes two Entities same
  embeddable insure value objects

- How to make sure class is immutable ex. Money class make sure BigDecimal is immutable ?
  implement MoneyAttributeConverter class as we do for JPA Attribute Converters
  add methods like Money of DbData

- How to make sure api is receiving something valid from UI and how to provide DTO classes ?
  validate json values; Precondition can be applied
  if using json we can make fields final
  you can use annoatations on fields
  you can make classed immutable even if when passing to a view

- Collections.unmodifiableList(list) vs Lists.immutable.ofAll(items) ?
  the performance should not matter that much ;

### Reading List
- 97 things a java developer should know
- Effective JAVA
- https://yanaga.io/blog/97-things-java
- https://www.geeksforgeeks.org/immutable-list-in-java/
- https://www.baeldung.com/java-immutable-list 

