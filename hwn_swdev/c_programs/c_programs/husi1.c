#include <stdio.h>


int sayingHello(void){
  printf("%s", "Hello, world!");
  return 1;
}

int sizeOfDataTypes(void){
  printf("int \t\t\t\t %lu Bytes / %ld Bits\n", sizeof(int), (sizeof(int)*8));
  printf("float \t\t\t\t %lu Bytes / %ld Bits\n", sizeof(float), (sizeof(float)*8));
  printf("double \t\t\t\t %lu Bytes / %ld Bits\n", sizeof(double), (sizeof(double)*8));
  printf("char \t\t\t\t %lu Bytes / %ld Bits\n", sizeof(char), (sizeof(char)*8));
  printf("_Bool \t\t\t\t %lu Bytes / %ld Bits\n", sizeof(_Bool), (sizeof(_Bool)*8));
  printf("long int \t\t\t %lu Bytes / %ld Bits\n", sizeof(long int), (sizeof(long int)*8));
  return 1;
}

int shiftBits(void){
  printf("Expectation: %d\n", 0);
  char var = 1;
  int i;
  for (i=0; i < 8; i++){
    var = var<<1;
  }
  printf("Result: %c", var);
  return 1;
}

int doBitwiseAnd(void){
  printf("Input: a => 01100001\n");
  printf("Expectation: 01\n");
  char input = 'a';
  char mask = 3;
  printf("%c", input&mask);
  return 1;
}

int main(void){
  sayingHello();
  printf("\nsizes of data types:\n");
  sizeOfDataTypes();
  printf("\n\nsayingHello:\n");
  sayingHello();
  printf("\n\nshift bits:\n");
  shiftBits();
  printf("\n\nbitwise and:\n");
  doBitwiseAnd();

  return 1;
}
