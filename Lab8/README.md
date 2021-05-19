# Lab8 - Fuzz Testing

## Lab Requirements
Find the bug in bmp_lic.c cause crash when using fuzzing tool, AFLplusplus.

## What you can learn
- Understand what's fuzz testing
- Understand how to use fuzzing tool, AFLplusplus

## Step by Step 
We assume that the path to AFL++ is ~/AFLplusplus, change it in the commands if your installation path is different.
### Installation
Please follow installation instructions from office github: https://github.com/AFLplusplus/AFLplusplus#building-and-installing-afl

### Prepare to run fuzz testing
```bash=
################################
### Set environment variable ###
################################

cd ~/AFLplusplus
# alf C compiler
export CC=~/AFLplusplus/afl-clang-fast 
# alf C++ compiler
export CXX=~/AFLplusplus/afl-clang-fast++
# Use ASAN (Address SANitizer)
export AFL_USE_UBSAN=1 

make

# for efficiently using CPU
sudo ./afl-system-config 

# clone this homework
git clone <Lab8> 
cd Lab8
make
```
### Run fuzz testing
```bash=
~/AFLplusplus/afl-fuzz -i ./test_input -o ./out -m none -- ./bmpgrayscale @@ @@
```
- `-i <input dirctory>`. <input directory> contain test cases
- `-o <output directory>`. <output directory> contain fuzz result
- `-m none`. unlimited moemroy, or set memory limits (in MB) with e.g. -m 250. This config is for ASAN
- `-- <executed file> @@ @@`. @@ is represent a argv needed for <executed file>. So for this example, there are two argv for ./bmpgrayscale

### Find bug
When you run the fuzz testing in this cases, there are some crash input you can get in `./out/default/crash`. You can rerun this crash input to `./bmpgrayscale` and use `valgrind` to find the fault.

###
## References
- AFLplusplus
https://github.com/AFLplusplus/AFLplusplus
- AFLplusplus Tutorial
[https://aflplus.plus/docs/tutorials/libxml2_tutorial/](https://aflplus.plus/docs/tutorials/libxml2_tutorial/)
- Fuzzing libxml2 with AFL++ (Nice example)
    [https://aflplus.plus/docs/tutorials/libxml2_tutorial/](https://aflplus.plus/docs/tutorials/libxml2_tutorial/)
- [https://www.jianshu.com/p/b7936d29be28](https://www.jianshu.com/p/b7936d29be28)
- My quick note in notion
https://www.notion.so/Lab8-Fuzz-Testing-92bc174f10954296b9e199f499661cce