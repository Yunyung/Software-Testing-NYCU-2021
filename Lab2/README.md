# Lab2 - Advanced Unit Testing

## Lab Requirements
- Download ***SoftwareTesting2021.java*** from [Github](https://github.com/iasthc/NYCU-Software-Testing-2021).
- Write tests for SoftwareTesting2021 class which satisfy the following case:
  - If a **fever** student **enter the class** on **Wednesday** , verify that hospital doesn’t do any treatment.
  - If a **fever** student **enter the class** on **Thursday**, assert the output correct.
  - In case 3 student go to hospital. Verify **patientLog** in **hospital** will record patient’s **studentid** with **spy** method. **Don’t stub getLog function**.
  - Use **stub** method to test **getScore** function to avoid connection to outer database.
  - Implement **paypalService** interface as a **fake** object to test donate function.
- Name your test function test_a to test_e which belong to each case.

## What you can learn 
- [Mockito](https://site.mockito.org/) framework for unit tests in Java
- How **Mock** and **Spy** benefit to Unit tests.
- Learn the concept of **Mock**, **Spy**, and **fake**
