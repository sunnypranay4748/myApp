package com.Pranay.myApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/*
If @Component annotation is declared on a class then its like we are specifying spring that this is the bean,
this is the class that you(Spring) needs to manage the object creating, use and destroying etc...
 */

/*
Remember Spring will not create objects for all the classes present in the project.
We need to specify spring with someway like adding @Annotation or declaring in the config or
other ways that it can understand

Let's say we have 1000 classes, we don't want spring to create objects for all the classes right?
So that's the reason we need to specify which class is the bean
 */

@Component
public class Dev {

    /*
    Now we have specified @Component in Laptop Class so that spring will create an object of
    it in Ioc container. But how we will connect it with a class that we want to use that obj in
    See below
     */

    /*
    So basically @Autowired annotation is a field type Injection. It actually connects the
    object of Laptop class to dev class so that we can use it. It is one way of doing.

    But let's say we need x objet's of x classes here, it doesn't look good to add annotation on
    top of each instance variable . @AutoWire is good if we use just one obj of another one class here

     */

    /*
    If Computer is an interface and Laptop actually implements it then we can create an reference variable of
    Computer type like below and do a constructor injection as below
    private Computer computer;  Similarly like LinkedList obj is created with List(Interface) reference as below
    List<String> list = new LinkedList<String>();  We can always reference to interface.

    But if we have two or more implementation classes of the interface with @Component annotation on them,
    Then if creating a constructor injection object with referencing to interface instead of class reference then
    java will throw an error since it will confuse on which class object to create, So add @Primary on one class this
     will specify java to choose the class that @primary annotation along with @Component annotation in confusion.
     Don't add primary on more than one class it will again throw error, or you can add @Qualifier("laptop") on top
     of the creation of instance variable of type Laptop. Remember to have all lowercase letters of the class "laptop"
     */
    //@Autowired // field Injection

    private final Laptop laptop;

    /*
    Constructor Injection is very famous of doing connecting object to referenced instance
    variables.
     */
    public Dev(Laptop laptop){
        this.laptop = laptop;
    }

    /*
    Setter Injection is same like using setters, but it needs @Autowired to connection the injection
    @Autowired
    public void SetLaptop(Laptop laptop){
        this.laptop = laptop;
    }
     */

    public void build(){

        laptop.compile();

        System.out.println("Working on Awesome project");
    }

}
