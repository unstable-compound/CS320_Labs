#!/usr/bin/env python3
#
import pathlib
import sys
import os
import shutil


def copy(found, new_dir):
    found_names = list()
    for path in found:
        fixed_path = str()
        head, tail = os.path.split(path)
        if tail == "":
            return

        while head != "" and head != "C:\'\'" and head != "C:\\":
            fixed_path = "_" + tail + fixed_path
            head, tail = os.path.split(head)
        fixed_path = tail + fixed_path
        found_names.append(fixed_path)
    # now corrected path names are in found_names
    current_direct = os.getcwd()
    new_dir = os.path.join(current_direct, new_dir)
    os.mkdir(new_dir)
    # now directory has been created
    n = len(found)
    for i in range(0, n):
        dest = os.path.join(new_dir, found_names[i])
        shutil.copy(found[i], dest)


def find(root, filename):
    found_list = list()
    if not os.path.isdir(root):
        print("Invalid root directory or path name")
        return found_list

    pathname = root
    for dirName, subdirList, fileList in os.walk(root):
        pathname = os.path.join(pathname, dirName)
        for fname in fileList:
            if fname == filename:
                found_list.append(os.path.join(pathname, fname))

    return found_list


def usage():
    print('usage: ./find.py [--copy dirname] root file')
    exit(0)


def quicktest():
    filename = "C:/Users/Curtis/Dropbox/CS320/CS320_Labs_Sandbox/CS320_Labs/lab6"
    found = find(filename, "example1.input")
    for f in found:
        print(f)


def main():
    if len(sys.argv) < 2:
        usage()
    if sys.argv[1] == '--copy':
        if len(sys.argv) < 5: usage()
        new_dir = sys.argv[2]
        root = sys.argv[3]
        filename = sys.argv[4]
        found = find(root, filename)
        for f in found:
            print(f)
        copy(found, new_dir)
    else:
        if len(sys.argv) < 3: usage()
        root = sys.argv[1]
        filename = sys.argv[2]
        found = find(root, filename)
        for f in found:
            print(f)


if __name__ == '__main__':
    main()
