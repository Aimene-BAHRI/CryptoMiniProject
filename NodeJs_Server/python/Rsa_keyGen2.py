
#############
## Imports ##
#############
import sys
import random
import numpy as np
from fractions import gcd
from Crypto.PublicKey import RSA
    

##############
## Methodes ##
##############

## Generate random integer
def get_rand(min, max):
    return random.randrange(min, max)

## Is the number a prime number
def is_prime(n):
    dividers = np.array([])   
    v = False
    if n >= 2 :
        for i in range(n, 0, -1) :
            if n % i == 0 :
                dividers = np.append(dividers, i) 
        if np.size(dividers) == 2 :
            v = True
    return v

## Get all primes under n
def get_primes(n):
    arr = np.array([],dtype=int)
    for i in range(2, n+1 ) :
        if is_prime(i):
            arr = np.append(arr, i)
    return arr


# Coef pgcd(a,b)
def coef_gcd(a, b):
    if a < b :
        a, b = b, a
    q = np.array([], dtype=int)
    qq = int(a/b)
    r = a % b
    while a % b != 0 :
        a, b, q  = b, r, np.append(q, qq)
        qq, r = int(a/b), a % b
    return q


# Inverse modulo
def inverse(e, n):
    E, N, D = e, n, 0
    while E * D % N != 1 :
        D += 1
    return D


## Get public key
def get_privat_k(e, fi): 

    d = "err"
    que, x, y = np.array(coef_gcd(e, fi)), np.array([1, 0]), np.array([0,1])
    
    counter = 1 
    for i in range(np.size(que)) :
        x = np.append(x, x[counter - 1] - que[i] * x[counter] )
        y = np.append(y, y[counter - 1] - que[i] * y[counter] )
        counter +=1
    if e * x[np.size(x) - 1] + fi * y[np.size(y) - 1] == 1 :
        if y[np.size(y) - 1] > 0 :
            d = y[np.size(y) - 1]
        else :
            d = x[np.size(x) - 1]
    elif e * y[np.size(y) - 1] + fi * x[np.size(x) - 1] == 1 :
        if x[np.size(x) - 1] > 0 :
            d = x[np.size(x) - 1]
        else :
            d = y[np.size(y) - 1]
            
    return d


## Get public key
def get_public_k(fi): 

    e = 2
    while e < fi and gcd(e , fi) != 1 :
        e += 1
    if e > fi:
        return "err"
    else:
     return e 

## Get n, p, q, fi(n)
def get_NPQ_FI(num):
    
    # Primes array
    primes = np.array(get_primes(int(sys.argv[1])) ) 

    # P & Q are Random primes 
    p = primes[get_rand(0, np.size(primes))]
    q = primes[get_rand(0, np.size(primes))]
    while q == p : # Infiny loop If argumen given == 2
        q = primes[get_rand(0, np.size(primes))]    
    
    # N = P * Q
    n = p * q
    
    # fi(n) = (p-1) * (q-1)
    fi = (p-1) * (q-1)

    return (p, q, n, fi)
   

## Main methode
def main():
    
    # Generate p, q, n , fi(n)
    p, q, n, fi = get_NPQ_FI(int(sys.argv[1]))
    
    # Generate public key
    e, n = (RSA.key() (fi), n)
    if e == "err":
        return e
    
    # Generate privat key
    d, n = RSA.pubkey.inverse(e,fi), n
    if d == "err" :
        return d    
    
    print "(n: {0}, e: {1}, d: {2}, fi: {3})".format(n, e, d, fi)    

    

###################
## start process ##
###################

if __name__ == '__main__':
    code = main()
    while code == "err":
        main()
    key  = dir(RSA)
    #print key
    #m = 65
    #c  = pow(m,e) % p*q

    #print c
    #dc = pow(c,d) % p*q
    #print dc