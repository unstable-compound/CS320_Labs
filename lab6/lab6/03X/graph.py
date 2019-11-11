#!/usr/bin/env python3

import sys
import os.path


# Fill in the missing routines, using the Java versions
# from lab4/08X and 10X as prototypes.
#
def read_integer_graph(gname):
    myDictGraph = dict()

    filename = gname + ".ig"
    file = open(filename, "r")
    file.readline()
    file.readline()

    line = file.readline()
    while line != "":
        line_list = line.split()
        v1 = int(line_list[0])
        v2 = int(line_list[1])

        # add to v1 edge list
        if v1 in myDictGraph:
            e1 = myDictGraph[v1]
        else:
            e1 = set()
        e1.add(v2)
        myDictGraph[v1] = e1

        # add to v2 edge list
        if v2 in myDictGraph:
            e2 = myDictGraph[v2]
        else:
            e2 = set()
        e2.add(v1)
        myDictGraph[v2] = e2

        line = file.readline()

    return myDictGraph


#
# read_string_graph()
#
def write_dot_graph(gname, graph):
    filename = gname + ".dot"
    file = open(filename, "w")
    file.write("graph " + gname + " [")

    visited = set()
    for vertex in graph:
        edgelist = graph[vertex]
        for edge in edgelist:
            if edge not in visited:
                file.write("\"" + str(vertex) + "\" -- \"" + str(edge) + "\"")
                file.write("\n")
        visited.add(vertex)
    file.write("]")
    file.close()


def usage():
    print('usage: ./graph.py [ file.ig | file.sg sep ]')
    exit(0)


def main():
    if len(sys.argv) < 2: usage()
    f = sys.argv[1]
    gname, kind = os.path.splitext(f)
    if kind == '.ig':
        if len(sys.argv) != 2: usage()
        g = read_integer_graph(gname)
    elif kind == '.sg':
        if len(sys.argv) != 3: usage()
        g = read_string_graph(gname, sys.argv[2])
    else:
        usage()
    write_dot_graph(gname, g)


if __name__ == '__main__':
    main()
