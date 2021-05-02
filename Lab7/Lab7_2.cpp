int main(int argc, char **argv) {
  int *a = new int[8];
  int *b = new int[8];
  a[0] = 0;
  int res = a[argc + 100];  // BOOM
  delete[] a;
  delete[] b;
  return res;
}