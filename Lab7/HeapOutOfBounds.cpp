int main(int argc, char **argv) {
  int *array = new int[100];
  array[0] = 0;
  int res = array[argc + 200];  // BOOM
  delete [] array;
  return res;
}