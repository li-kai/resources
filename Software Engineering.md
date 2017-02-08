## Words of wisdom from Yang Shun

Yang Shun, [8 Feb 2017, 7:57 PM]: 
Take react and angular for example

Yang Shun, [8 Feb 2017, 7:57 PM]: 
They can easily swap out their renderers for more efficient implementations

Preact has the same API as react and is almost a drop-in replacement

There's a reason why FB engineers split up the original react into react core and react dom

Then came up with react art, react native, react vr

That's why I advise students to go research on existing game engines and physics engines and look at their API

Yang Shun, [8 Feb 2017, 8:00 PM (8/2/17, 8:00 PM)]: 
Because these third party libraries have already done the work for you by defining good abstraction layers through their many years of refining and rewriting

Yang Shun, [8 Feb 2017, 8:00 PM]: 
It's likely the sweet spot of abstraction where the user gets control yet doesn't need to do so much work

When the framework does too much magic, people complain there's too much magic. Don't understand what's going on underneath

Yang Shun, [8 Feb 2017, 8:02 PM]: 
When the framework does too little, people complain too much boilerplate, have to repeat a lot of code

Lol people are hard to please

Something you can bear in mind when writing open source libraries

Ideally is cater to the 90% use case but yet allow the 10% to further extend functionality for their custom use case

Yang Shun, [8 Feb 2017, 8:05 PM (8/2/17, 8:06 PM)]: 
You also don't want to bloat your users with too much code that most people won't need

Especially on the web lol