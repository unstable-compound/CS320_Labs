#include <iostream>
#include <cmath>
using namespace std;

struct Item {
  bool b;
  float d;
};

struct Link {
  Item itm;
  Link *next;
  Link(Item argitm,Link *argnext) : itm(argitm), next(argnext) {}
};

float f(Link *list) {
  float sum = 0;
  while (list != NULL) {
    sum += list->itm.b ? list->itm.d : 0.0;
    list = list->next;
  }
  return sum;
}

int main(int argc, char **argv) {
  int n = stoi(argv[1]);
  Link *list = NULL;
  Item itm;
  for (int i = 1; i <= n; i++)  {
    itm.b = i%2; 
    itm.d = sqrt(i);
    list = new Link(itm,list);
  }
  float s = f(list);
  cout << "sum = " << s << endl;
}
  
