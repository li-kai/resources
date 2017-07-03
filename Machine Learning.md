# Machine Learning

## Supervised Learning

We already know what correct output is
f(x) => g(x)

[x0, x1, ... xn]
f: X1 x X2 X ... Xn -> Y

Goal is to minimize the errors based on the ideal case.

### Regression

Continuous values

### Classification

Discrete values


## Unsupervised learning

No idea what our results should look like
X -> ???

We give the model data -> tell it to make sense the data (e.g. clustering)
Unlabelled data, interesting associations

## Linear algebra

### Matrices and Vectors (in NumPy)

Vectors are a subset of matrices (e.g. a row)

Dot product `A.dot(B.transpose())`

Inverse `A_inv = np.linalg.pinv(A)`

Identity matrix `np.identity(A.shape(0))`

## Model Representation

### Cost function

Use is to measure the accuracy of the hypothesis function.
Deriving the cost function.

J(theta 0, theta 1) = 1/2m (avg regression between each) = 1/2m

> Mean square difference
> Just an absolute value

Linear regression

We should try to minimize the cost function.

### Gradient descent

Derivative of the cost function, and travel towards the derivative.
Size of step is determined by alpha, also called the learning rate.

Varying learning rate, has two benefits

1. Lets you jump out of a lcoal sub optimum
1. Lets you speed up the experiment

#### Smartly minimizing the cost

Parameters should be updated together (essentially the c and m of the function)

#### Intuition

It is very similar to the Newton-Raphson method, but instead of "jumping" there, Gradient Descent moves slowly towards that goal.

#### Feature scaling & Mean normalization

Input values should be ideally the same range, or every step will be taken in different proportions to the dimensions. (Intuition: noramlize the data space)

Feature scaling & Mean normalization are two different techniques to achieve the same result.

#### Learning rate

Alpha is too small: slow convergence
Alpha is too large: may not decrease on every iteration and may not converge

Ensure that gradient descent is working by ensuring that the gradient descend is decreasing (instead of increasing or bouncing between some range).

Automatic convergence test: Declare convergence if J(theta) decreases by less than E in one iteration, where E is some small value such as 10^-3. To ensure that gradient convergence.

#### Features and Polynomial Regression

We can improve our features and form hypothesis function via polynomial regression (aka fitting our plot by fitting in more dimensions).

Might overfit with training instead of generalisation.

#### Optimization with Normal Equation method

Formal equation formula
`np.linalg.pinv(X.transpose().dot(X)).dot(X.transpose()).dot(y)`

Normal Equation is O(n^3) complexity vs O(kn^2) of Gradient Descent!

> Matrix multiplication and transposing are O(n^3)

But Normal Equation doesn't need a learning rate ond doesn't need to iterate (meaning closed form solution).

Normal Equation can be used to check correctness.
