#Front-end Job Interview Answers

This file contains a number of front-end interview answers. Subjective questions will be left answered.

**Note:** Keep in mind that many of these answers are mine, and may not be entirely correct.

## Table of Contents

  1. [General Questions](#general-questions)
  1. [HTML Questions](#html-questions)
  1. [CSS Questions](#css-questions)
  1. [JS Questions](#js-questions)
  1. [Testing Questions](#testing-questions)
  1. [Performance Questions](#performance-questions)
  1. [Network Questions](#network-questions)
  1. [Coding Questions](#coding-questions)
  1. [Fun Questions](#fun-questions)

## Getting Involved

  1. [Contributors](#contributors)
  1. [How to Contribute](https://github.com/h5bp/Front-end-Developer-Interview-Questions/blob/master/CONTRIBUTING.md)
  1. [License](https://github.com/h5bp/Front-end-Developer-Interview-Questions/blob/master/LICENSE.md)

#### General Questions:

* What did you learn yesterday/this week?
* What excites or interests you about coding?
* What is a recent technical challenge you experienced and how did you solve it?
* What UI, Security, Performance, SEO, Maintainability or Technology considerations do you make while building a web application or site?
* Talk about your preferred development environment.
* Which version control systems are you familiar with?
* Can you describe your workflow when you create a web page?
* If you have 5 different stylesheets, how would you best integrate them into the site?
* Can you describe the difference between progressive enhancement and graceful degradation?
* How would you optimize a website's assets/resources?
* How many resources will a browser download from a given domain at a time?
  * What are the exceptions?
* Name 3 ways to decrease page load (perceived or actual load time).
* If you jumped on a project and they used tabs and you used spaces, what would you do?
* Describe how you would create a simple slideshow page.
* If you could master one technology this year, what would it be?
* Explain the importance of standards and standards bodies.
* What is Flash of Unstyled Content? How do you avoid FOUC?
* Explain what ARIA and screenreaders are, and how to make a website accessible.
* Explain some of the pros and cons for CSS animations versus JavaScript animations.
* What does CORS stand for and what issue does it address?

#### HTML Questions:

* What does a `doctype` do?
* What's the difference between full standards mode, almost standards mode and quirks mode?
* What's the difference between HTML and XHTML?
* Are there any problems with serving pages as `application/xhtml+xml`?
* How do you serve a page with content in multiple languages?
* What kind of things must you be wary of when design or developing for multilingual sites?
* What are `data-` attributes good for?
* Consider HTML5 as an open web platform. What are the building blocks of HTML5?
* Describe the difference between a `cookie`, `sessionStorage` and `localStorage`.
* Describe the difference between `<script>`, `<script async>` and `<script defer>`.
* Why is it generally a good idea to position CSS `<link>`s between `<head></head>` and JS `<script>`s just before `</body>`? Do you know any exceptions?
* What is progressive rendering?
* Have you used different HTML templating languages before?

#### CSS Questions:

* What is the difference between classes and IDs in CSS?

> Classes apply to a group of DOM elements while IDs refer to only one. Hence IDs have a higher specificity.

* What's the difference between "resetting" and "normalizing" CSS? Which would you choose, and why?

> Normalizing CSS only fixes abnormal behaviors among different browsers. Resetting CSS applies sensible defaults to elements in addition to normalizing it. I would choose to normalize, as this gives me more flexibility and reduces the amount of overriding I would have to do.

* Describe Floats and how they work.

> Floats differ from normal behavior and pushes the element into the direction specified.

* Describe z-index and how stacking context is formed.

> z-index is the index in which elements overlay on top of. In a stacking context, elements with a higher index is overlayed on top of elements with a lower one.

* Describe BFC(Block Formatting Context) and how it works.

> (no idea)

* What are the various clearing techniques and which is appropriate for what context?

> The only clearing technique I know is the `clear` property. It is used to arrange float elements such that they do not arrange themselves horizontally in the direction specified.

* Explain CSS sprites, and how you would implement them on a page or site.

> CSS sprites are a file in which image elements are combined together. We can use CSS then to split them into individual sprites for use as icons or graphics. This is to reduce page requests and load time.

* What are your favourite image replacement techniques and which do you use when?

> I have only used base-64 inline for images. This reduces the requests needed and avoids the image rendering after the user sees the DOM.

* How would you approach fixing browser-specific styling issues?

> I would use auto-prefixer to prevent cross browser styling issues. On top of that, I would check in actual browsers to ensure styling is working correctly.

* How do you serve your pages for feature-constrained browsers?

> If the feature is important, try to find work-arounds or polyfills for the feature. If not, have the feature degrade naturally and use a fall back. If all else fails, recommend the user to upgrade their browser.

* What techniques/processes do you use?

> (Not sure what the question is asking)

* What are the different ways to visually hide content (and make it available only for screen readers)?

> Different ways to hide content. `display: none`, `opacity: 0`, `background-clip: 100%` and `position: absolute` with `left: -99999px`. Only the last two work with screen readers.

* Have you ever used a grid system, and if so, what do you prefer?

> I have used the bootstrap grid system. I prefer hand-writing my own css as it enables me to learn more about CSS itself.

* Have you used or implemented media queries or mobile specific layouts/CSS?

> I used mobile-first web development with [modify.sg](https://www.modify.sg) and my codepens are also similarly focused on the mobile first aspect. Media queries are used.

* Are you familiar with styling SVG?

> I have styled SVG with simple CSS but have not tried animating them.

* How do you optimize your webpages for print?

> No idea.

* What are some of the "gotchas" for writing efficient CSS?

> Efficient CSS does not have too many specific class names and ids. Having high specificity is also not good since it takes longer to parse the CSS.

* What are the advantages/disadvantages of using CSS preprocessors?

> Advantages include being able to write cleaner, more modularized, more semantic CSS, all while increasing speed of development. Disadvantages include having to learn the preprocessor syntax. However the difficulty of learning them is not high.

* Describe what you like and dislike about the CSS preprocessors you have used.

> I have used SCSS. I enjoy it because it looks very similar to CSS, in addition to being able to write for/while loops that reduce repetition. Constants enable the team to change the structure more easily. I do not find disadvantages in SCSS.

* How would you implement a web design comp that uses non-standard fonts?

> Find a CDN to load the font file and have a fallback. There are other font importing techniques but I am not familiar.

* Explain how a browser determines what elements match a CSS selector.

> The browser essentially crawls the DOM tree and match elements with the right class/id/tag. The higher the specificity, the longer and hard the browser works to find the elements.

* Describe pseudo-elements and discuss what they are used for.

> Pseudo-elements are usually used to add styling that are not part of the DOM structure. They can also be used to add prefixes and subfixes to text, which can be used smartly for responsive reasons.

* Explain your understanding of the box model and how you would tell the browser in CSS to render your layout in different box models.

> Box model contains a `margin-box`, `border-box`, `padding-box` and position. For example, in the `padding=box` model, assigning a border would make the actual object larger than the size defined in `margin-box`. Similarly, if you account for `border-box`, then additional margin would make the box larger than you defined.

* What does ```* { box-sizing: border-box; }``` do? What are its advantages?

> Changes the box model to account for the border. This is more intuitive for people and makes writing and debugging CSS easier.

* List as many values for the display property that you can remember.

> `inline`, `inline-block`, `block`, `flex`, `inline-flex`, `table`, `table-row`, `table-cell`, `table-col`, `none`, `inline-table` and ...

* What's the difference between inline and inline-block?

> Inline does not have a width and height.

* What's the difference between a relative, fixed, absolute and statically positioned element?

> Relative is positioned relative to its parent element. Fixed is positioned to the browser screen. Absolue is positioned outside until it hits an element with the `relative` position. Static is the default attribute for all elements.

* The 'C' in CSS stands for Cascading.  How is priority determined in assigning styles (a few examples)?  How can you use this system to your advantage?

> Prority is determined by specificity. For example, elements with `!important` are always given the highest priority and will be styled that way. Specificity can also be used in unique ways to override sibling styles (Pure CSS implementations of dropdowns / carousels)

* What existing CSS frameworks have you used locally, or in production? How would you change/improve them?

> I have used Bootstrap. It is nice to use it for rapid prototypes, but would be quite hard to debug if you try to override attributes without understanding why they were put there in the first place.

* Have you played around with the new CSS Flexbox or Grid specs?

> Yes. Flexbox is very powerful but hard to get right. I hope Grid lands soon, I really need it!

* How is responsive design different from adaptive design?

> Responsive design allows for different screen sizes and different height and widths. Adaptive design cater to specific sizes only.

* Have you ever worked with retina graphics? If so, when and what techniques did you use?

> A nice header `<meta id="viewport" name="viewport" content="width=device-width, height=device-height, initial-scale=1, minimum-scale=1">` will enable retina graphics to work as if each pixel is density-independent.

* Is there any reason you'd want to use `translate()` instead of *absolute positioning*, or vice-versa? And why?

> Translate is more efficient for animation as there will be less redraws, and thus trigger less jank for animations. Translate also allows you to move elements without moving the element out of its position. Hence places where this could be useful will be things like pure CSS dropdowns.

#### JS Questions:

* Explain event delegation
* Explain how `this` works in JavaScript
* Explain how prototypal inheritance works
* What do you think of AMD vs CommonJS?
* Explain why the following doesn't work as an IIFE: `function foo(){ }();`.
  * What needs to be changed to properly make it an IIFE?
* What's the difference between a variable that is: `null`, `undefined` or undeclared?
  * How would you go about checking for any of these states?
* What is a closure, and how/why would you use one?
* What's a typical use case for anonymous functions?
* How do you organize your code? (module pattern, classical inheritance?)
* What's the difference between host objects and native objects?
* Difference between: `function Person(){}`, `var person = Person()`, and `var person = new Person()`?
* What's the difference between `.call` and `.apply`?
* Explain `Function.prototype.bind`.
* When would you use `document.write()`?
* What's the difference between feature detection, feature inference, and using the UA string?
* Explain Ajax in as much detail as possible.
* What are the advantages and disadvantages of using Ajax?
* Explain how JSONP works (and how it's not really Ajax).
* Have you ever used JavaScript templating?
  * If so, what libraries have you used?
* Explain "hoisting".
* Describe event bubbling.
* What's the difference between an "attribute" and a "property"?
* Why is extending built-in JavaScript objects not a good idea?
* Difference between document load event and document DOMContentLoaded event?
* What is the difference between `==` and `===`?
* Explain the same-origin policy with regards to JavaScript.
* Make this work:
```javascript
duplicate([1,2,3,4,5]); // [1,2,3,4,5,1,2,3,4,5]
```
* Why is it called a Ternary expression, what does the word "Ternary" indicate?
* What is `"use strict";`? what are the advantages and disadvantages to using it?
* Create a for loop that iterates up to `100` while outputting **"fizz"** at multiples of `3`, **"buzz"** at multiples of `5` and **"fizzbuzz"** at multiples of `3` and `5`
* Why is it, in general, a good idea to leave the global scope of a website as-is and never touch it?
* Why would you use something like the `load` event? Does this event have disadvantages? Do you know any alternatives, and why would you use those?
* Explain what a single page app is and how to make one SEO-friendly.
* What is the extent of your experience with Promises and/or their polyfills?
* What are the pros and cons of using Promises instead of callbacks?
* What are some of the advantages/disadvantages of writing JavaScript code in a language that compiles to JavaScript?
* What tools and techniques do you use debugging JavaScript code?
* What language constructions do you use for iterating over object properties and array items?
* Explain the difference between mutable and immutable objects.
  * What is an example of an immutable object in JavaScript?
  * What are the pros and cons of immutability?
  * How can you achieve immutability in your own code?
* Explain the difference between synchronous and asynchronous functions.
* What is event loop?
  * What is the difference between call stack and task queue?
* Explain the differences on the usage of `foo` between `function foo() {}` and `var foo = function() {}`

#### Testing Questions:

* What are some advantages/disadvantages to testing your code?
* What tools would you use to test your code's functionality?
* What is the difference between a unit test and a functional/integration test?
* What is the purpose of a code style linting tool?

#### Performance Questions:

* What tools would you use to find a performance bug in your code?
* What are some ways you may improve your website's scrolling performance?
* Explain the difference between layout, painting and compositing.

#### Network Questions:

* Traditionally, why has it been better to serve site assets from multiple domains?
* Do your best to describe the process from the time you type in a website's URL to it finishing loading on your screen.
* What are the differences between Long-Polling, Websockets and Server-Sent Events?
* Explain the following request and response headers:
  * Diff. between Expires, Date, Age and If-Modified-...
  * Do Not Track
  * Cache-Control
  * Transfer-Encoding
  * ETag
  * X-Frame-Options
* What are HTTP methods? List all HTTP methods that you know, and explain them.

#### Coding Questions:

*Question: What is the value of `foo`?*
```javascript
var foo = 10 + '20';
```

*Question: How would you make this work?*
```javascript
add(2, 5); // 7
add(2)(5); // 7
```

*Question: What value is returned from the following statement?*
```javascript
"i'm a lasagna hog".split("").reverse().join("");
```

*Question: What is the value of `window.foo`?*
```javascript
( window.foo || ( window.foo = "bar" ) );
```

*Question: What is the outcome of the two alerts below?*
```javascript
var foo = "Hello";
(function() {
  var bar = " World";
  alert(foo + bar);
})();
alert(foo + bar);
```

*Question: What is the value of `foo.length`?*
```javascript
var foo = [];
foo.push(1);
foo.push(2);
```

*Question: What is the value of `foo.x`?*
```javascript
var foo = {n: 1};
var bar = foo;
foo.x = foo = {n: 2};
```

*Question: What does the following code print?*
```javascript
console.log('one');
setTimeout(function() {
  console.log('two');
}, 0);
console.log('three');
```

#### Fun Questions:

* What's a cool project that you've recently worked on?
* What are some things you like about the developer tools you use?
* Who inspires you in the front-end community?
* Do you have any pet projects? What kind?
* What's your favorite feature of Internet Explorer?
* How do you like your coffee?


#### Contributors:

This document started in 2009 as a collaboration of [@paul_irish](https://twitter.com/paul_irish) [@bentruyman](https://twitter.com/bentruyman) [@cowboy](https://twitter.com/cowboy) [@ajpiano](https://twitter.com/ajpiano)  [@SlexAxton](https://twitter.com/slexaxton) [@boazsender](https://twitter.com/boazsender) [@miketaylr](https://twitter.com/miketaylr) [@vladikoff](https://twitter.com/vladikoff) [@gf3](https://twitter.com/gf3) [@jon_neal](https://twitter.com/jon_neal) [@sambreed](https://twitter.com/sambreed) and [@iansym](https://twitter.com/iansym).

It has since received contributions from over [100 developers](https://github.com/h5bp/Front-end-Developer-Interview-Questions/graphs/contributors).
