# JavaFX typical algorithms
This is a simple project for my university. 
## Table of content
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [To Do](#to-do)

## General info
Inside in application are eight tabs where I implemented common algorithms.

1. Greatest common divisor (GCD). [wiki](https://en.wikipedia.org/wiki/Greatest_common_divisor)
2. All perfect numbers in range 3 to 10_000. [wiki](https://en.wikipedia.org/wiki/Perfect_number)
3. Correctness PESEL number. [wiki](https://en.wikipedia.org/wiki/PESEL)
4. Coloring height map. [wiki](https://en.wikipedia.org/wiki/Heightmap)
5. Bubble sort for list of numbers. [wiki](https://en.wikipedia.org/wiki/Bubble_sort)
6. Two way for Fibonacci numbers (recursive and iteration). [wiki](https://en.wikipedia.org/wiki/Fibonacci_number)
7. Reversing colors on the picture.
8. Four subtasks from projecteuler.net
    * Euler 1 - [Multiples of 3 and 5](https://projecteuler.net/problem=1)
    * Euler 4 - [Largest palindrome product](https://projecteuler.net/problem=4)
    * Euler 5 - [Smallest multiple](https://projecteuler.net/problem=5)
    * Euler 14 - [Longest Collatz sequence](https://projecteuler.net/problem=14)
    
Logger saves the file monthly in directory ../log/

## Technologies
* Java 11
* JavaFX 11
* Log4j 2.11.2
* Lombok 1.18.6
* Apache Maven

## Setup
To run this project, follow by instruction:

Use terminal:

```
git clone git@github.com:Skrzetuski/JavaFX-typical-algorithms.git
cd JavaFX-typical-algorithms
mvn install package
java -jar target/JavaFX-typical-algorithms-1.0.jar
```

## To Do
* Multithreading for GUI.
* Processing images in a multithreaded way.