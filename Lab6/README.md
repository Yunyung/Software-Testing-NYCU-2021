# Lab5 - Control Flow Graph

## Lab Requirements
- Gernerate the call graph and control flow graph for Lab_6.c using LLVM tool

## What you can learn
- Understand what's LLVM

- Learn how to generate call graph and control flow graph using LLVM

## Step by Step Command 

### Install 
```
# Evironment: Ubuntu 20.04.1 LTS

# LLVM
sudo apt install llvm
# graphviz tool to generate graph
sudo apt install graphviz

# Install LLVM C/C++ frontend (It's weird why it's needed, although we have installed llvm)
sudo apt install clang
```

### Generate
Frontend
```
# Generate Lab_6.ll file 
# Compile to LLVM IR
lang -S -emit-llvm ./Lab_6.c
```


Optimizer
```
# Generate call graph 
# This command will generate 'callgraph.dot'
opt -S -dot-callgraph Lab_6.ll

# Generate control flow graph 
# This command will generate '.A.dot', '.B.dot', '.C.dot', '.main.dot'
opt -S -dot-cfg Lab_6.ll
```
See [here](https://llvm.org/docs/Passes.html) for more LLVM optimizer Passes.

### Graphviz
```
# .dot file to .png
dot -Tpng {in_filename}.dot -o {out_filename}.png
```

<br/>

## Other command
Note: Following command not use in this lab but useful.

IR Interpreter
``` 
# Directly use Interprter to run IR code
# Just check for build successfully
lli Lab_6.ll
```

Backend
```
# IR to Assembly language
llc Lab_6.ll 
```





