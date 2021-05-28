# Lab9 - Symbolic Execution

## Lab Requirements
Apply symolic execution tools, Angr, to hack the password from a binary file, give_me_password.

## What you can learn
- Understand what's symblic execution
- Learn how to use Angr, a symolic exection tool, to crack the password or some useful infomation from a binary file 

## Step by Step 
### Installation
```Bash= 
# Recommand to use python virtual environment accroding to angr office docs
sudo apt-get install python3-dev libffi-dev build-essential virtualenvwrapper
# Build a virtual env and install angr
mkvirtualenv --python=$(which python3) angr && pip install angr 

# angr-utils bingraphvis for generating control flow graph. But if you want to generate CFG with basic block, you need to install this package using office install
pip install angr angr-utils bingraphvis

# Activate target virtual environment
workon <virtual env name> 
# deactivate current virtual environment
deactivate  
```

### Run Angr
Crack the password of binary file - give_me_password
```
# See solve.py to understand how to hack
workon angr
python solve.py
```




###
## References
- angr

    https://github.com/angr/angr
- Introduction to angr ☆

    [https://blog.notso.pro/2019-03-20-angr-introduction-part0/](https://blog.notso.pro/2019-03-20-angr-introduction-part0/)

    Chinese translation: [https://xz.aliyun.com/t/6557](https://xz.aliyun.com/t/6557)
- My quick chinese note in motion
    
    https://www.notion.so/Lab9-Symbolic-Execution-0af18d9beb3549d7ad4ca871bf89d3d7
