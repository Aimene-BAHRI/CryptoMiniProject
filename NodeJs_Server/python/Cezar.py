
#############
## Imports ##
#############

import sys



##############
## Methodes ##
##############

# Key convertion if given (Letter)
def clean_key(k):
    
    if (k >= 'A'  and k <= 'Z') :
        return (ord(k) - 65 ) 
    elif (k >= 'a'  and k <= 'z') :
        return (ord(k) - 97 )
    return k


# Cezar encripting Message
def cezar_encript(m, key) :
    
        k = int(clean_key(key))
        c = ""
        for i in range(len(m)) :
            if (m[i] >= 'A'  and m[i] <= 'Z') or (m[i] >= 'a'  and m[i] <= 'z') :
                if m[i] >= 'A'  and m[i] <= 'Z' :
                    base = 65
                elif m[i] >= 'a'  and m[i] <= 'z' :
                    base = 97 
                buff = ( ord(m[i]) - base + k ) % 26 + base
                c += str(unichr(buff))
            else :
                c += m[i]
        return c


# Cezar decrypting message 
def cezar_decript(c,key) :
        
        k = int(clean_key(key))
        m = ""

        for i in range(len(c)) :
            if (c[i] >= 'A'  and c[i] <= 'Z') or (c[i] >= 'a'  and c[i] <= 'z') :
                if c[i] >= 'A'  and c[i] <= 'Z' :
                    base = 65
                elif c[i] >= 'a'  and c[i] <= 'z' :
                    base = 97 
                buff = ( ord(c[i]) - base - k ) % 26 + base
                m += str(unichr(buff))
            else :
                m += c[i]
        return m


# Main methode
def main():
    try :
        if sys.argv[1] == "c" :
            print cezar_encript(sys.argv[2], sys.argv[3])
        elif sys.argv[1] == "d":
            print cezar_decript(sys.argv[2], sys.argv[3])
    except Exception as e:
        print "error"



###################
## start process ##
###################

if __name__ == '__main__':
    main()


