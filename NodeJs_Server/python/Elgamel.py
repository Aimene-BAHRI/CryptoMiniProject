



#############
## Imports ##
#############

import sys
import Crypto
from Crypto.PublicKey import ElGamal
from Crypto import Random
import ast



##############
## Methodes ##
##############

# Get N E and D
def getKey_pair():
    
    # Gen key
    random_generator = Random.new().read
    key = ElGamal.generate(1024, random_generator) #generate pub and priv key

    # Export key
    exportKey = key.exportKey()
    
    f = open ('./python/moi.txt', 'w')
    f.write(exportKey)
    f.close()

    #decrypted code below

    f = open('./python/moi.txt', 'r')
    message = f.read()
    print message
    f.close()


# Main methode
def main():
    getKey_pair()


###################
## start process ##
###################

if __name__ == '__main__':
    main()


