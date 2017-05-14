
#############
## Imports ##
#############
import sys
import random


##############
## Methodes ##
##############

## Generate random integer
def get_rand(min, max):
    return random.randrange(min, max)

## Is the number a prime number
def is_prime(n):
    dividers = []
    
    for i in range(1, n+1) :
        if n % i == 0 :
            dividers.append(i) 

    if len(dividers) >2 :
        return False
    else:
        return True

## Get all primes under n
def get_primes(n):
    arr = []
    for i in range(2, n+1 ) :
        if is_prime(i):
            arr.append(i)
    return arr


# Coef pgcd(a,b)
def coef_pgcd(a, b):
    if a < b :
        t = a
        a = b
        b = t

    q = []
    
    qq = int(a/b)
    r = a % b
    while a % b != 0 :
        a = b
        b = r
        q.append(qq)
        #print a, " = ", b, " * ", qq, " + ", r
        qq = int(a/b)
        r = a % b
    return q


# Eucleed etendue
def extended_eucleed (p, q):
    a = p
    b = q

    que = coef_pgcd(a,b)
    x = [1, 0]
    y = [0, 1]
    
    
    for i in range(len(que)) :
        x.append(x[i]-(que[i]*x[i+1]))
        y.append(y[i]-(que[i]*y[i+1]))

    if (p * x[len(x)-1] + q * y[len(y)-1]) == 1 :
        return y[len(y)-1]
    elif (p * y[len(y)-1])  + q * x[len(x)-1] == 1 :
           return x[len(x)-1]

## Main methode
def main():
    
    # Primes array
    primes = get_primes(int(sys.argv[1]))

    # P & Q are Random primes 
    p = primes[get_rand(0, len(primes))]
    q = primes[get_rand(0, len(primes))]
    while q == p : # Infiny loop If argumen given == 2
        q = primes[get_rand(0, len(primes))]    

    # N = P * Q
    n = p * q

    # fi = (P-1) * (Q-1)
    fi = (p-1) * (q-1)

    # E is part of public Key
    primeZ = get_primes(fi)
    e = primeZ[get_rand(0, len(primeZ))]
    
    # D is part of privat key 
    d = extended_eucleed(p, q)
    
    print "p = {0} , q = {1} \nn = {2} , fi = {3}\ne = {4} , d = {5}\npublic_k({4}, {2})\nprivate_k({5}, {2})".format(p, q, n, fi, e, d)

    import crypt.



###################
## start process ##
###################

if __name__ == '__main__':
    main()


