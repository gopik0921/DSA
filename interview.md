                           Java Interview Questions
                           
Aggregation and Composition are subsets of association

Aggregation implies a relationship where the child can exist independently of the parent. Example: Class (parent) and Student (child). Delete the Class and the Students still exist.

Composition implies a relationship where the child cannot exist independent of the parent. Example: House (parent) and Room (child). Rooms don't exist separate to a House.

Aggregation is weak association.

Inheritence Is-A relationship

Composition Has-A relationship

Command and Query Responsibility Segregation (CQRS) design pattern for microservices.

Transaction Isolation Problems::

Dirty read: read the uncommitted change of a concurrent transaction

Nonrepeatable read: get different value on re-read of a row if a concurrent transaction updates the same row and commits

Phantom read: get different rows after re-execution of a range query if another transaction adds or removes some rows in the range and commits  


Transaction Isolation Levels::

DEFAULT, READ_UNCOMMITTED, READ_COMMITTED, REPEATABLE_READ, SERIALIZABLE


Get vs Load Hibernate::

Null Object 
:::Get:::
It object not found for the given identifier then it will return null object 
:::Load:::
It will throw object not found exception 


Lazy or Eager loading 
:::Get:::
It returns fully initialized object so this method eager load the object  
:::Load:::
It always returns proxy object so this method is lazy load the object  


Performance 
:::Get:::
It is slower than load() because it return fully initialized object which impact the performance of the application 
:::Load:::
It is slightly faster.


Use Case
:::Get:::
If you are not sure that object exist then use get() method 
:::Load:::
If you are sure that object exist then use load() method 


Autowiring types: (Match by Type, Match by Qualifier, Match by Name) @Autowired, @Resource, @Inject

1)Field Autowiring:::

@Component
public class SomeService {
     @Autowired private SomeOtherService someOtherService;
}

you are allowing anyone (in different class outside/inside the Spring container) to create an instance using default constructor (like new SomeService())

2)Constructor Autowiring::

@Component
public class SomeService {
    private final SomeOtherService someOtherService;
    
    @Autowired
    public SomeService(SomeOtherService someOtherService){
        this.someOtherService = someOtherService;
    }
}

the dependencies are clearly identified. There is no way to forget one when testing, or instantiating the object in any other circumstance (like creating the bean instance explicitly in a config class)

the dependencies can be final, which helps with robustness and thread-safety

you don't need reflection to set the dependencies. InjectMocks is still usable, but not necessary. You can just create mocks by yourself and inject them by simply calling the constructor


3)Setter Autowiring::
@Component
public class SomeService {
   private final SomeOtherService someOtherService;

    @Autowired
    protected void setSomeOtherService(SomeOtherService someOtherService) {
        this.someOtherService = someOtherService;
    }
}
Partial dependency: can be injected using setter injection but it is not possible by constructor. Suppose there are 3 properties in a class, having 3 arg constructor and setters methods. In such case, if you want to pass information for only one property, it is possible by setter method only.

Overriding: Setter injection overrides the constructor injection. If we use both constructor and setter injection, IOC container will use the setter injection.

Changes: We can easily change the value by setter injection. It doesn't create a new bean instance always like constructor. So setter injection is flexible than constructor injection.





In short, IoC is a much broader term that includes, but is not limited to, DI.

Inversion of Control (IoC) means that objects do not create other objects on which they rely to do their work. Instead, they get the objects that they need from an outside source (for example, an xml configuration file). Beans are stored in IoC container.

Dependency Injection (DI) means that this is done without the object intervention, usually by a framework component that passes constructor parameters and set properties. Framework job to create dependencies.




Factory Pattern::

// Factory
static class FruitFactory {
    static Fruit create(name, color, firmness) {
        // Additional logic
        return new Fruit(name, color, firmness);
    }
}

// Usage
Fruit fruit = FruitFactory.create("apple", "red", "crunchy");


Builder Pattern:::

// Builder
class FruitBuilder {
    String name, color, firmness;
    FruitBuilder setName(name)         { this.name     = name;     return this; }
    FruitBuilder setColor(color)       { this.color    = color;    return this; }
    FruitBuilder setFirmness(firmness) { this.firmness = firmness; return this; }
    Fruit build() {
        return new Fruit(this); // Pass in the builder
    }
}

// Usage
Fruit fruit = new FruitBuilder()
        .setName("apple")
        .setColor("red")
        .setFirmness("crunchy")
        .build();




                         