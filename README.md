# Design Patterns

This repository contains explanations and implementations of common design patterns, serving as a practical guide and demonstration for understanding their principles and application.

## Table of Contents

- [Introduction](#introduction)
- [OO basics](#oo-basics)
- [Design Principles](#design-principles)
- [Design Patterns Implemented](#design-patterns-implemented)
  - [Abstract Factory Pattern](./AbstractFactoryPattern/AbstractFactory.md)
  - [Command Pattern](./CommandPattern/Command_pattern.md)
  - [Decorator Pattern](./DecoratorPattern/Decorator.md)
  - [Factory Pattern](./FactoryPattern/Factory.md)
  - [Observer Pattern](./ObserverPattern/Observer.md)
  - [Singleton Pattern](./SingletonPattern/Singleton.md)
  - [Strategy Pattern](./StrategyPattern/Strategy.md)

- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Running the Examples](#running-the-examples)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)

## Introduction

Design patterns are reusable solutions to common problems in software design. They represent best practices and provide a common vocabulary for developers to discuss architectural solutions. This repository aims to provide clear, executable examples of these patterns to aid in learning and comprehension.

## OO basics

1. Abstraction  
2. Encapsulation  
3. Polymorphism  
4. Inheritance

## Design principles

1. Identify parts of the application that vary and separate them from what stays the same  
   - Essentially, encapsulate them so that any alterations and modifications to these parts do not affect other parts of the code.  
   - This results in fewer unintended consequences and a more flexible system  
2. Program to an interface not in implementation.  
   - What I mean is program to a supertype, ie the declared type of the variables should be a supertype, generally an abstract class or an interface  
3. Favor composition over inheritance  
   - Composition allows you to encapsulate a family of algorithms, basically turning the behavior into a lego bricks that can be switched out on runtime  
4. Prefer loosely coupled designs between objects that interact.  
   - This allows for flexible designs that can handle change because they minimize the dependency between objects  
5. Open \- Closed Principle.  
   - Classes should be open for extension but closed for modification