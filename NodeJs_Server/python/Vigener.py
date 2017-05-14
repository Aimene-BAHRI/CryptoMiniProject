
#############
## Imports ##
#############

import sys
from Cezar import clean_key, cezar_encript, cezar_decript


##############
## Methodes ##
##############

# Vigener encripting Message
def vigener_encript(m, key) :

        k = list(key) 
        for i in range(len(k)) :
            k[i] = clean_key(k[i])
        c = ""

        counter = 0 
        for i in range(len(m)) :  
                c += cezar_encript(m[i] , k[counter % len(k)])
                counter += 1
        return c


# Cezar decrypting message 
def vigener_decript(c,key) :
        
        k = list(key) 
        for i in range(len(k)) :
            k[i] = clean_key(k[i])
        m = ""

        counter = 0 
        for i in range(len(c)) :  
                m += cezar_decript(c[i] , k[counter % len(k)])
                counter += 1
        return m


# Main methode
def main():
    if sys.argv[1] == "c" :
        print vigener_encript(sys.argv[2], sys.argv[3])
    elif sys.argv[1] == "d":
        print vigener_decript(sys.argv[2], sys.argv[3])

    #try :
        
    #except Exception as e:
    #    print "error"



###################
## start process ##
###################

if __name__ == '__main__':
    main()


