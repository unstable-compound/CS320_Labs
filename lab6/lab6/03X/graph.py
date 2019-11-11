#!/usr/bin/env python3

import sys
import os.path

# Fill in the missing routines, using the Java versions
# from lab4/08X and 10X as prototypes.
#
# read_integer_graph()
#
# read_string_graph()
#
# write_dot_graph()
#


def usage():
  print('usage: ./graph.py [ file.ig | file.sg sep ]')    
  exit(0)

def main():
  if len(sys.argv) < 2: usage()    
  f = sys.argv[1]
  gname,kind = os.path.splitext(f)
  if kind == '.ig':
    if len(sys.argv) != 2: usage()
    g = read_integer_graph(gname)
  elif kind == '.sg':
    if len(sys.argv) != 3: usage()
    g = read_string_graph(gname,sys.argv[2])
  else: usage()
  write_dot_graph(gname,g)
  
if __name__ == '__main__':
  main()
