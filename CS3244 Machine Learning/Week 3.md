## Naive Bayes

Given an algo for NB is basically iterating over all condition probabilities of all conditions. E.g. given an apple's image, select the classification that says it is an the most probable of X in h.

## k nearest neighbours

Find the nearest k number of neighbours in a space. Your distance function may vary.

## No Free Lunch Theorem

You cannot know anything for sure about `f` outside the data without making assumptions.

> We don't know what the thing will predict

### Population mean from sample mean

Pick a sample of N marbles independently

`u`: prob to pick red marble
`v`: fraction of red marbles in sample

In a large sample N, `v` is probably close to `u` within `ϵ` (error).

Formally,

`P[|v - u| > ϵ] <= e^(-Nϵ^2)`

Meaning, Probablity of distance is within some error bound, is less than the right side of the equation, known as Hoeffdling's Inequality.

Intuition: We would need quadratic amount of data to increase our tolerance by one magnitude (100 => 10000)

Statement that `u = v` is called "probably approximately correct"(PAC).

### Learning algorithms

1. Classifications y = +-1
2. Regression y ϵ R
3. Logistic regression y ϵ [0, 1]

#### Learning digits from images

Given 16x16 bitmap of a digit, 256 total pts. However, not all are useful such as bottom right section of whitespace. Therefore, we want features to obtain useful data.

We could reduce this to a 8*16 by folding the image in half, leaving us a 128 input pt.

#### Iterations of PLA

w <- w + yx

Intuition, as we continuously move our boundaries closer to aggregate more points correct, we are eventually going to get a good fit.

#### Pocket algorithm

Naming, we "pocket"(keep) the best seen so far.

At each step, keep the best Ein (and w) so far.


## Linear Regression

### Example: Credit Approval

We have age, gender, salary, debt, etc. Organize them into a vector.

h(x) = SUM(wixi) = (w^T)x

#### R-valued error measurement

How well does h(x) = (w^T)x approx f(x)?

We can use squared error: (h(x) - f(x))^2

> Why? Scalar that is +ve, and heavily penalizes large errors

```
Ein = 1/N SUM(( (w^t)xn - yn )^2)
    = 1/N || Xw - y ||^2
```

where X is all data, y is all solutions

#### Minimizing Ein analytically

`Ein(w) = 1/N || Xw - y ||^2`
`delta Ein(w) = 2/N (X^T) (Xw - y)` // basically differentiate top eqn

We want to minimize errors, hence we want `delta Ein(w)` to approach vector 0.

Leading to,

`delta Ein(w) = 2/N (X^T) (Xw - y) = 0`

`(X^T) Xw = (X^T) y`

`(X^TX)^-1 (X^T) Xw = (X^TX)^-1 X^T`

Pseudo inverse `X† = (X^T X)^-1 X^T`.

> `(X^T X)` gives us a d+1 * d+1 matrix.

1. Contruct matrix X and vector y.
2. Compute the pseduo inverse
3. Return `w = X†y`
4. Tadah, linear regression model generated
5. Appear a new `x` to `w` to get an approxiated answer


