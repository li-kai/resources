# Notes for Software Development
Copied and summarized from [Learning JavaScript Design Patterns](https://addyosmani.com/resources/essentialjsdesignpatterns/book/#whatisapattern) which is released under a
[Creative Commons Attribution-Noncommercial-No Derivative Works 3.0](https://creativecommons.org/licenses/by-nc-nd/3.0/).
## Design Patterns
A pattern does the following:

- Solves a particular problem
- The solution to this problem cannot be obvious
- The concept described must have been proven
- It must describe a relationship: In some cases it may appear that a pattern describes a type of module. Although an implementation may appear this way, the official description of the pattern must describe much deeper system structures and mechanisms that explain its relationship to code.

### Anti-Patterns
- Describe a bad solution to a particular problem which resulted in a bad situation occurring
- Describe how to get out of said situation and how to go from there to a good solution

## Table of Design Patterns
<table width="100%" border="0" align="center" cellpadding="1" cellspacing="1">
  <tbody><tr>
    <td colspan="4"><strong>&nbsp;&nbsp;<b>Creational</b></strong></td>
    <td colspan="4">&nbsp;&nbsp;Based on the concept of creating an object.</td>
  </tr>
  <tr>
    <td colspan="8"><em><strong>&nbsp;&nbsp;&nbsp;&nbsp;Class </strong></em></td>
  </tr>
  <tr>
    <td colspan="5"><em>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Factory Method</em></td>
    <td colspan="3">This makes an instance of several derived classes based on interfaced data or events.</td>
  </tr>
  <tr>
    <td colspan="8"><em><strong>&nbsp;&nbsp;&nbsp;&nbsp;Object</strong></em></td>
  </tr>
  <tr>
    <td colspan="5"><em>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Abstract Factory</em></td>
    <td colspan="3">Creates an instance of several families of classes without detailing concrete classes.</td>
  </tr>
  <tr>
    <td colspan="5"><em>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Builder</em></td>
    <td colspan="3">Separates object construction from its representation, always creates the same type of object.</td>
  </tr>
  <tr>
    <td colspan="5"><em>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Prototype</em></td>
    <td colspan="3">A fully initialized instance used for copying or cloning.</td>
  </tr>
  <tr>
    <td colspan="5"><em>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Singleton</em></td>
    <td colspan="3">A class with only a single instance with global access points.</td>
  </tr>
  <tr>
    <td height="20" width="6">&nbsp;</td>
    <td width="6">&nbsp;</td>
    <td width="6">&nbsp;</td>
    <td width="139">&nbsp;</td>
    <td width="1">&nbsp;</td>
    <td width="18">&nbsp;</td>
    <td width="18">&nbsp;</td>
    <td width="681">&nbsp;</td>
  </tr>
  <tr>
    <td colspan="4"><strong>&nbsp;&nbsp;<b>Structural</b></strong></td>
    <td colspan="4">&nbsp;&nbsp;Based on the idea of building blocks of objects.</td>
  </tr>
  <tr>
    <td colspan="8"><em><strong>&nbsp;&nbsp;&nbsp;&nbsp;Class </strong></em></td>
  </tr>
  <tr>
    <td colspan="5"><em>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Adapter</em></td>
    <td colspan="3">Match interfaces of different classes therefore classes can work together despite incompatible interfaces.</td>
  </tr>
  <tr>
    <td colspan="8"><em><strong>&nbsp;&nbsp;&nbsp;&nbsp;Object</strong></em></td>
  </tr>
  <tr>
    <td colspan="5"><em>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Adapter</em></td>
    <td colspan="3">Match interfaces of different classes therefore classes can work together despite incompatible interfaces.</td>
  </tr>
  <tr>
    <td colspan="5"><em>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Bridge</em></td>
    <td colspan="3">Separates an object's interface from its implementation so the two can vary independently.</td>
  </tr>
  <tr>
    <td colspan="5"><em>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Composite</em></td>
    <td colspan="3">A structure of simple and composite objects which makes the total object more than just the sum of its parts.</td>
  </tr>
  <tr>
    <td colspan="5"><em>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Decorator</em></td>
    <td colspan="3">Dynamically add alternate processing to objects.</td>
  </tr>
  <tr>
    <td colspan="5"><em>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Facade</em></td>
    <td colspan="3">A single class that hides the complexity of an entire subsystem.</td>
  </tr>
  <tr>
    <td colspan="5"><em>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Flyweight</em></td>
    <td colspan="3">A fine-grained instance used for efficient sharing of information that is contained elsewhere.</td>
  </tr>
  <tr>
    <td colspan="5"><em>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Proxy</em></td>
    <td colspan="3">A place holder object representing the true object.</td>
  </tr>
  <tr>
    <td colspan="8">&nbsp;</td>
  </tr>
  <tr>
      <td colspan="4"><strong>&nbsp;&nbsp;<b>Behavioral</b></strong></td>
    <td colspan="4">&nbsp;&nbsp;Based on the way objects play and work together.</td>
  </tr>
  <tr>
    <td colspan="8"><em><strong>&nbsp;&nbsp;&nbsp;&nbsp;Class </strong></em></td>
  </tr>
  <tr>
    <td colspan="5"><em>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Interpreter</em></td>
    <td colspan="3">A way to include language elements in an application to match the grammar of the intended language.</td>
  </tr>
  <tr>
    <td colspan="5"><em>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Template <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Method</em></td>
    <td colspan="3">Creates the shell of an algorithm in a method, then defer the exact steps to a subclass.</td>
  </tr>
  <tr>
    <td colspan="8"><em><strong>&nbsp;&nbsp;&nbsp;&nbsp;Object</strong></em></td>
  </tr>
  <tr>
    <td colspan="5"><em>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Chain of <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Responsibility</em></td>
    <td colspan="3">A way of passing a request between a chain of objects to find the object that can handle the request.</td>
  </tr>
  <tr>
    <td colspan="5"><em>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Command</em></td>
    <td colspan="3">Encapsulate a command request as an object to enable, logging and/or queuing of requests, and provides error-handling for unhandled requests.</td>
  </tr>
  <tr>
    <td colspan="5"><em>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Iterator</em></td>
    <td colspan="3">Sequentially access the elements of a collection without knowing the inner workings of the collection.</td>
  </tr>
  <tr>
    <td colspan="5"><em>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Mediator</em></td>
    <td colspan="3">Defines simplified communication between classes to prevent a group of classes from referring explicitly to each other.</td>
  </tr>
  <tr>
    <td colspan="5"><em>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Memento</em></td>
    <td colspan="3">Capture an object's internal state to be able to restore it later.</td>
  </tr>
  <tr>
    <td colspan="5"><em>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Observer</em></td>
    <td colspan="3">A way of notifying change to a number of classes to ensure consistency between the classes.</td>
  </tr>
  <tr>
    <td colspan="5"><em>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;State</em></td>
    <td colspan="3">Alter an object's behavior when its state changes.</td>
  </tr>
  <tr>
    <td colspan="5"><em>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Strategy</em></td>
    <td colspan="3">Encapsulates an algorithm inside a class separating the selection from the implementation.</td>
  </tr>
  <tr>
    <td colspan="5"><em>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Visitor</em></td>
    <td colspan="3">Adds a new operation to a class without changing the class.</td>
  </tr>
</tbody></table>

### Module Pattern
The Module pattern encapsulates "privacy", state and organization using closures. It provides a way of wrapping a mix of public and private methods and variables, protecting pieces from leaking into the global scope and accidentally colliding with another developer's interface. With this pattern, only a public API is returned, keeping everything else within the closure private.

```js
var testModule = (function () {

  var counter = 0;

  return {

    incrementCounter: function () {
      return counter++;
    },

    resetCounter: function () {
      console.log( "counter value prior to reset: " + counter );
      counter = 0;
    }
  };

})();

// Usage:

// Increment our counter
testModule.incrementCounter();

// Check the counter value and reset
// Outputs: counter value prior to reset: 1
testModule.resetCounter();
```

### Observer Pattern
The Observer is a design pattern where an object (known as a subject) maintains a list of objects depending on it (observers), automatically notifying them of any changes to state.

When a subject needs to notify observers about something interesting happening, it broadcasts a notification to the observers (which can include specific data related to the topic of the notification).

When we no longer wish for a particular observer to be notified of changes by the subject they are registered with, the subject can remove them from the list of observers.

```js
function ObserverList(){
  this.observerList = [];
}

ObserverList.prototype.add = function( obj ){
  return this.observerList.push( obj );
};

ObserverList.prototype.count = function(){
  return this.observerList.length;
};

ObserverList.prototype.get = function( index ){
  if( index > -1 && index < this.observerList.length ){
    return this.observerList[ index ];
  }
};

ObserverList.prototype.indexOf = function( obj, startIndex ){
  var i = startIndex;

  while( i < this.observerList.length ){
    if( this.observerList[i] === obj ){
      return i;
    }
    i++;
  }

  return -1;
};

ObserverList.prototype.removeAt = function( index ){
  this.observerList.splice( index, 1 );
};
```

```js
function Subject(){
  this.observers = new ObserverList();
}

Subject.prototype.addObserver = function( observer ){
  this.observers.add( observer );
};

Subject.prototype.removeObserver = function( observer ){
  this.observers.removeAt( this.observers.indexOf( observer, 0 ) );
};

Subject.prototype.notify = function( context ){
  var observerCount = this.observers.count();
  for(var i=0; i < observerCount; i++){
    this.observers.get(i).update( context );
  }
};
```

```js
// The Observer
function Observer(){
  this.update = function(){
    // ...
  };
}
```

The Observer patterns encourage us to think hard about the relationships between different parts of our application. They also help us identify what layers containing direct relationships which could instead be replaced with sets of subjects and observers. This effectively could be used to break down an application into smaller, more loosely coupled blocks to improve code management and potentials for re-use.

Further motivation behind using the Observer pattern is where we need to maintain consistency between related objects without making classes tightly coupled. For example, when an object needs to be able to notify other objects without making assumptions regarding those objects.

### Command Pattern
The Command pattern aims to encapsulate method invocation, requests or operations into a single object and gives us the ability to both parameterize and pass method calls around that can be executed at our discretion. In addition, it enables us to decouple objects invoking the action from the objects which implement them, giving us a greater degree of overall flexibility in swapping out concrete classes (objects).

Concrete classes are best explained in terms of class-based programming languages and are related to the idea of abstract classes. An abstract class defines an interface, but doesn't necessarily provide implementations for all of its member functions. It acts as a base class from which others are derived. A derived class which implements the missing functionality is called a concrete class.

The general idea behind the Command pattern is that it provides us a means to separate the responsibilities of issuing commands from anything executing commands, delegating this responsibility to different objects instead.

```js
carManager.execute( "arrangeViewing", "Ferrari", "14523" );
carManager.execute( "requestInfo", "Ford Mondeo", "54323" );
carManager.execute( "requestInfo", "Ford Escort", "34232" );
carManager.execute( "buyVehicle", "Ford Escort", "34232" );
```