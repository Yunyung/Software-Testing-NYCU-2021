# Lab4 - CI/CD with Github Action

## Lab Requirements
- Part 1 - Write a simple rock-paper-scissors game (See src/main/Game.java and src/main/Main.java) using gradle build tool
- Part 2 - Test follwing test cases in Game.java

  - all win cases
  - all lose cases
  - all draw cases
  - valid/invalid input cases

- Part 3 - Use github action to compile, test, assemble jar
  
  - Run **Compile, Test, Assemble** three job sequentially as long as there are new commit submmited.
  - Storing workflow "*all test report directory*", "*assemble jar file*" as workflow artifacts
  - Add github action badge to README -> [![Java CI with Gradle](https://github.com/Yunyung/st_nycu_lab4_0856167/actions/workflows/gradle.yml/badge.svg)](https://github.com/Yunyung/st_nycu_lab4_0856167/actions/workflows/gradle.yml) 
 
- Part 4 - Use github action to *automate release jar file* when push is a *tag pushed events*

- Bonus - Use action/cache to cache your dependencies and speed up your build time.

## What you can learn
- Learn what is Github Action

- Practice how to write config file (in .github/workflow) to use Github Action service

- Run CI/CD with Java Gradle in Github Action service

- Using various tools in Github Action 
  - [actions/upload-artifacts](https://github.com/actions/upload-artifact)
  - [actions/download-artifact](https://github.com/actions/download-artifact)
  - [softprops/action-gh-release](https://github.com/softprops/action-gh-release)
  - [actions/cache](https://github.com/actions/cache)

- Learn to manipulate basic gradle build tool

See [My Github Action](https://github.com/Yunyung/st_nycu_lab4_0856167/actions) Page to know how it work.
