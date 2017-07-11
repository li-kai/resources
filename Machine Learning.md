# Machine Learning: Week 1

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

# Machine Learning: Week 2

## Classification problems

Discrete values instead of continuous

### Hypothesis representation for classification

We squeeze values to range [0, 1] using the Sigmoid Function, also called the Logistic Function.

### Logistic Regression

Translate output of hypothesis function from 0.5 to 1 and < 0.5 to 0.

Apply sigmoid to hypothesis function to get new function.

### Cost function

We cannot use the same cost function for linear regression because the Logistic Function will not be a convex function.

If y = 1, Cost = - log(h(x))
If y = 0, Cost = - log(1 - h(x))

We can compress our cost function into
Cost(h(x)y) = -y log(h(x)) = (1-y) log(1-h(x))

### Gradient descend

Iteratively update the thetha function which is the cost multiplied by the derivative of the theta.

With new cost function: []

### Multiple classes

y = (0, 1 .... n). Simply divde our preblem into n+1 binary classification problems.

Intuition: Choose one class, and lump all others into a second class. Repeat.
We choose the label that returns the max probability for the prediction.

### Overfitting

Generalises instead of fitting too much to the training set. 
Similarly we want to avoid underfitting, where our selected features don't fit the curve.

Usually caused by complicated function with numerous unnecessary curves and angles unrelated to the data.

Deal with overfitting

1. Reduce the number of features
1. Regularization (preferred)
- Keep all the features, but reduce the magnitude of parameters (weights)
- Works well when we have a lot of slightly useful features

We can reduce the impact of the cost functions, by "dimming" their weights for certain parameters.

#### Generalization

New cost function = Original cost function + lambda(summation of every feature's theta)

lambda allows us to control extend of regularization.

> Not regularization theta 0 is because it only translates the function curve (not actual fitting)

#### Normal Equation

Theta = (transpose(X))*X + lambda*L)^-1 * transpose(X) * y

Where L is an identity matrix with a leading 0 to exclude the initial term

#### Hypothesis evaluation

Split data into train and test set. 80/20 rule, but arbitrary.
Test set will not have regularization.

Misclasssificaiton costs error 1.

#### Dev set

Even with test set, may not have a good hypothesis. Cross validation set (or dev set).
Dev set is for tuning the learning algorithm, BEFORE using it on the actual training set.

Random split. E.g. timing sensitive prediction. 2016 data? 2017 Jan will do worse than test because
you are already accounting for future information to predict. You should have Jan - Nov and Dec as test set.

As large of a dev set to detect small improvements.

#### Tuning size of training set

Learning curve is the error over number of training data, should decrease as you increase examples.

If variance varies too much, it is generally a sign of overfitting.


## Precision and Recall

Precision =  TP / (TP + FP)

Recall = TP / (TP + FN)

Accuracy = (TP + TN) / (TP + FP + FN +TN)

Evaluation metric: F1 score, which is (2 * Precision * Recall) / (Precision + Recall)

