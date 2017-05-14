#############
## Imports ##
#############

import sys

def main():
    print pow( int( sys.argv[1] ),int(sys.argv[2]) ) % int(sys.argv[3])
    

#start process
if __name__ == '__main__':
    main()