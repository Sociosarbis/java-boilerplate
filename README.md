## Description
This repo is for saving solutions of LeetCode questions implemented with Java and written by me.

## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

## Dependency Management

The `JAVA DEPENDENCIES` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-pack/blob/master/release-notes/v0.9.0.md#work-with-jar-files-directly).

## How to run a specific unit test from command line
```bash
rm src/[package name]/*.class
javac -cp "src;lib/junit-4.12.jar;lib/hamcrest-core-1.3.jar" src/[package name]/Solution.java src/[package name]/Tests.java
java -cp "src;lib/junit-4.12.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore [test class name]
```
