package com.deebeast.behaviorandstate;

/**
 * this class is not optimal due to lot of usage of primitive data types
 * (Primitive Obsession lol :D)
 * 
 * We have a Object Oriented Model ; 
 * To achieve rich domain model avoid primitives most of the times.
 * 
 */
public class Person {
    private final int age;
    private final String name;
    private final String title;

    private Person(int age, String name, String title) {
        this.age = age;
        this.name = name;
        this.title = title;
    }

    // Factory Method Style
    // public static Person of(int age, String name, String title) {
    // Preconditions.checkArgument(age > 0);
    // Preconditions.checkArgument(name != null && name.length() > 1);
    // Preconditions.checkArgument(title != null && title.length() > 1);
    // return new Person(age, name, title);
    // }

    // Builder Method Style

    public static class Builder {
        private int age;
        private String name;
        private String title;

        public Person build(int age, String name, String title) {
            Preconditions.checkArgument(age > 0);
            Preconditions.checkArgument(name != null && name.length() > 1);
            Preconditions.checkArgument(title != null && title.length() > 1);
            return new Person(age, name, title);
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

}