# Margin

Better linear seperation
A larger margin handles more noise

## Support margin

Contributes weight to the boundary

## Finding w

Let x_n be the nearest data point to the plan (w^T)x = 0.

1. Normalize w:
    | (w^T)x_n | > 0. So insist | (w^T)x_n | = 1, where
    x_n is a point closest to the plane

1. Pull out w_0, name it b:
    Seperate w = (w1, ..., wd) apart from b
    The plane is now back to form (w^T)x - b = 0. So no x_n.?

1. Computing the distance
    w vector must be perpendicular to plane in the X space.

    > Proof
    Take any two point x' and x" on the plane that satisfy (w^T)x + b = 0.
    Aka. They are on the plane, and (w^T)(x' - x") = 0.

    Take any point x on the plane, where the projection of x_n - x on w:
    v = w / ||w||

    Distance = |v^T(x_n - x)|
             = (1 / ||w||) | w^Tx_n - w^Tx |
             = (1 / ||w||) | w^Tx_n + b - w^Tx + b |
             // Note (w^Tx_n + b) = 1, and (w^Tx + b) = 0
             = 1 / ||w||

1. Maximum 1 / ||w||
    Subject to min (| w^Tx_n + b |) = 1

    > | w^Tx_n + b | = y_n(w^Tx_n + b) where y_n is our actual data pt (cancel out)
    > We just need min y_n(w^Tx_n + b) >= 1, instead of = 1 (scale down later)

    Hence optimized to just min (y_n(w^Tx_n + b)) >= 1

### Lagrange Formulation

Minimize L(w, b, a) = 1/2 (w^T)w - SUM( alpha_n(y_n(w^Tx_n + b) - 1) )

> alpha_n is to represent how important a point is

w.r.t. w and b and maximize w.r.t. each alpha-n >= 0

delta_w L = w - SUM( alpha_n * y_n * x_n) = 0

differitate L w.r.t. b = - SUM( alpha_n * y_n )

### Substituting to find dual form

1) w = SUM( alpha_n * y_n * x_n) and 2) SUM( alpha_n * y_n ) = 0

In the Lagrangian

L(w, b, a) = 1/2 w^Tw - SUM( alpha_n(y_n(w^Tx_n + b) - 1) )

sub in them to get

L(a) = SUM( alpha_n ) + 0 - 1/2 SUMn( SUMm( y_n * y_m * alpha_n * alpha_m * x^T_n * x_m))


Where we simply have to maximize w.r.t. to alpha.


### Quadratic programming

min(1/2 alpha^T)[matrix of y_n * y_m * x^T_n * x_m](alpha) + (-1^T)alpha

Which is then min( 1/2 alpha^T * Q * alpha ) subject to y^T = 0; alpha >= 0.

Complexity is O(N ^ 2) where N is size of matrix.

### Meaning of alpha

QP Solution: alpha = alpha_1, ..., alpha_n

Solve for w = SUM( a_n * y_n * x_n)

Vector alpha = [alpha_1 ... alpha_n]

where each alpha signifies a weight to the contribution of the boundary.

i.e. the closer to 0 alpha is, the less weight it is, meaning we can ignore values where alpha = 0. (ignore non-support vectors)

### Error correction

Margin violation: y_n(w^T*x_n + b) >= 1

Minimize 1/2 w^T*w + C SUM(error_n)

Subject to y_n(w^T*x_n +b) >= 1 - error_n and error_n > 0


### Langrange Formulation

1. Check lecture notes

delta_w L = w - SUM(a_n * y_n * x_n) = 0

differentitate L w.r.t. b = - SUM( a_n * y_n ) = 0

differentitate L w.r.t. error_n = C - alpha_n - beta_n = 0

??? End with same result, except subject to 0 <= alpha_n <= C

### Types of support vector

Margin support vectors -> vectors that lie between margin

Non-margin support vectors -> vectors that go beyong margin but still influences the margin

Setting C sets the rejection of the error, the higher, the fewer violations. Intuition: high C enlarges the error_n

### z instead of x

L(alpha) - SUM(alpha_n) - 1/2 SUM_n(SUM_m( y_n * y_m * alpha_n * alpha_m * z_n^T * z_m ))

### Generalized inner product

Given two points x and x' inside X, we just need z^T*z'

Let z^Tz' = K(x, x') (the kernel, the "inner product" of x & x')

> Kernel is just an encapsulated function that does some calculation

Example (Meaning K can be 2nd order Polynomial Transform)

`x = <x1, x2>`

z = phi(x) = (1, x_1, x_2, sqrt(2) x_1 ^ 2, sqrt(2) x_2 ^ 2, sqrt(2) x_1 * x_2)

then K(x, x') = phi(x) * phi(x')


#### Ways of getting K(x, x')

1. Transform

Calculate phi(x)^T * phi(x')

Takes O(Q^2) time

1. Function

Compute K(x, x') = (1 + SUM_d(x_d * x'_d))^Q

Takes O(d) time


