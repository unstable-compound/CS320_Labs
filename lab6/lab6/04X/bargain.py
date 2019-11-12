import sys
import os.path


def process_bargains(filename):
    file = open(filename, "r")
    n = int(file.readline())
    lookup = list()
    for i in range(0, n):
        line = file.readline()
        line_list = line.split(",")
        quantity = int(line_list[0])
        name = line_list[1]
        grade = line_list[2]
        color = line_list[3]
        price = float(line_list[4])

        data_tuple = (quantity, name, grade, color, price)
        lookup.append(data_tuple)
    # now data has been collected from the file
    file.close()
    return lookup


def quick_test_process(lookup):
    for tup in lookup:
        print(tup)


def find_bargains(lookup):
    # data is tuple of form (int(quantity), name, grade, color, float(price))
    sub_list = list()
    sum_cost = 0.0
    # check for blue or superior in data AND calculate sum of all cost
    for data in lookup:
        if data[3] == "blue" or data[2] == "superior":
            sub_list.append(data)
        # add cost to sum
        sum_cost += float(data[0]) * data[4]

    # calculate the average cost of all items in the file.
    n = len(lookup)
    average = sum_cost / n

    # check for items whose cost is less than or equal to average
    bargain_list = list()
    for data in sub_list:
        cost = float(data[0]) * data[4]
        if cost <= 1.5 * average:
            bargain_list.append(data[1])

    return bargain_list


def usage():
    print('usage: ./bargain.py [ file.input ]')
    exit(0)


def main():
    if len(sys.argv) < 2:
        f = "example4.input"
    else:
        f = sys.argv[1]
    gname, kind = os.path.splitext(f)
    if kind != ".input":
        usage()
    lookup = process_bargains(f)
    bargains = find_bargains(lookup)
    for bargain in bargains:
        print(bargain)


if __name__ == '__main__':
    main()
