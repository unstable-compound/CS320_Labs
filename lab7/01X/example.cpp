#include <iostream>
#include <stdio.h>
using namespace std;


int determine_order(int first, int second)
{
  return first + second;
}
int main( int argc, const char* argv[] )
{
  int x = 1;
  int y = 0;
  int * z = &y;
  int value = determine_order(x+ *z, y=2);
  if(value == (1+2))
    cout << "left-to-right" << endl;
  else if(value == (3 + 2))
    cout << "right-to-left" << endl;
  else
    cout << "logic appears to be flawed" << endl;
}


