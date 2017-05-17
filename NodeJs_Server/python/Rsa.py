



#############
## Imports ##
#############

import sys
import Crypto
from Crypto.PublicKey import RSA
from Crypto import Random
import ast
import os


##############
## Methodes ##
##############

# Get N E and D
def getKey_pair():
    
    # Gen key
    random_generator = Random.new().read
    key = RSA.generate(1024, random_generator) #generate pub and priv key
    publickey = key.publickey()
    
    # encripte
    encripted = publickey.encrypt("a", 32) 
    print encripted
    print "\n\n\n"

    # export key
    exportKey = key.exportKey()
    
    
    # import key
    importKey = RSA.importKey(exportKey) 
    print importKey.decrypt(ast.literal_eval(str(encripted)))
    print "\n\n\n"


# Rsa Encript
def rsa_encript(message, k):
        
    encripted =""

    # import key
    key = RSA.importKey(k)
    publickey = key.publickey()

    encrypted = publickey.encrypt(message, 32)

    f = open ('./python/moi.txt', 'w') 
    f.write(str(encrypted)) #write ciphertext to file
    f.close()

    f = open ('./python/moi.txt', 'r') 
    print f.read() 
    f.close()
    os.remove('./python/moi.txt')


# Rsa Decript 
def rsa_decript(message, k):
        
    decripted =""

    # import key
    key = RSA.importKey(k)
    

    decrypted = key.decrypt(ast.literal_eval(str(message)))

    f = open ('./python/moi.txt', 'w') 
    f.write(str(decrypted))
    f.close()

    f = open ('./python/moi.txt', 'r') 
    print f.read() 
    f.close()
    os.remove('./python/moi.txt')


# Main methode
def main():
    try :
        if sys.argv[1] == "c" :
            rsa_encript(sys.argv[2], sys.argv[3])
        elif sys.argv[1] == "d":
            rsa_decript(sys.argv[2], sys.argv[3])
    except Exception as e:
        print "error"


###################
## start process ##
###################

if __name__ == '__main__':
    main()


