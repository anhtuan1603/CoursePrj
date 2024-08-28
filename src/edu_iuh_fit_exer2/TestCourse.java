/*

 * Classname TestCourse.javaa   1.0 8/28/2024    
 *
 * Copyright (c) 2024 IUH. All right reserved
 */
 
package edu_iuh_fit_exer2;

import java.util.List;
import java.util.Scanner;

/*
* @description HELLO
* @author: Anh Tuan
* @date: 8/28/2024
* version:   1.0
*/
public class TestCourse {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            CourseList courseList = new CourseList(10);

            iniData(courseList);

            int choice;
            do {
                System.out.println("1. Add a course");
                System.out.println("2. Display all courses");
                System.out.println("3. Remove a course");
                System.out.println("4. Find Department With Most Course:");
                System.out.println("5. Find Max Credit Course:");
                System.out.println("6. Search Course By Department");
                System.out.println("7. Search Course By ID:");
                System.out.println("8. Sort Course");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter course ID: ");
                        String id = sc.nextLine();
                        System.out.print("Enter course title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter course credits: ");
                        int credit = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter course department: ");
                        String department = sc.nextLine();
                        Course course = new Course(id, title, credit, department);
                        if (courseList.addCourse(course)) {
                            System.out.println("Course added successfully");
                        } else {
                            System.out.println("Course not added");
                        }
                    }
                    case 2 -> {
                        System.out.println("Course List");
                        System.out.println("-------------------------------------------------------------");
                        System.out.printf("%-10s%-30s%2s %-10s%n", "ID", "Title", "Credit", "Department");
                        System.out.println("-------------------------------------------------------------");
                        for (Course course : courseList.getCourses()) {
                            if (course != null)
                                System.out.println(course);
                        }
                        System.out.println("-------------------------------------------------------------");
                    }
                    case 3 -> {
                        System.out.println("Enter course ID to remove: ");
                        String id = sc.nextLine();
                        if(courseList.removeCourse(id)) {
                            System.out.println("Course removed successfully");
                        } else {
                            System.out.println("Course with ID " + id + " not found");
                        }
                    }
                    case 4 ->{
                        String department = courseList.findDepartmentWithMostCourses();
                        if (department != null) {
                            System.out.println("Department with most courses: " + department);
                        } else {
                            System.out.println("No courses available.");
                        }
                    }
                    case 5 -> {
                        Course maxCreditCourse = courseList.findMaxCreditCourse();
                        if (maxCreditCourse != null) {
                            System.out.println("Course with max credits: " + maxCreditCourse);
                        } else {
                            System.out.println("No courses has a unique maxium credit.");
                        }
                    }
                    case 6 -> {
                        System.out.print("Enter department to search: ");
                        String department = sc.nextLine();
                        List<Course> coursesByDepartment = courseList.searchCoursesByDepartment(department);
                        if (coursesByDepartment.isEmpty()) {
                            System.out.println("No courses found for department: " + department);
                        } else {
                            System.out.println("Courses in department " + department + ":");
                            for (Course course : coursesByDepartment) {
                                System.out.println(course);
                            }
                        }
                    }
                    case 7 -> {
                        System.out.println("Enter course ID to search: ");
                        String id = sc.nextLine();
                        Course course = courseList.searchCourseById(id);
                        if (course != null) {
                            System.out.println("Course with ID " + course + " found");
                        } else {
                            System.out.println("Course with ID " + id + " not found");
                        }
                    }
                    case 8 -> {
                        courseList.sortCoursesByID();
                        System.out.println("Course List sorted by ID");
                    }
                    default -> System.out.println("Invalid choice");
                }
            } while (choice != 0);
        }
        public static void iniData(CourseList courseList) {
            Course course1 = new Course("FIT101", "Java Programming", 3, "FI");
            Course course2 = new Course("FIT102", "Web Programming", 6, "FIT");
            Course course3 = new Course("FIT103", "Database Programming", 3, "FI");
            Course course4 = new Course("FIT104", "Mobile Programming", 3, "FIT");
            Course course5 = new Course("FIT105", "Software Engineering", 3, "FIT");


            courseList.addCourse(course1);
            courseList.addCourse(course2);
            courseList.addCourse(course3);
            courseList.addCourse(course4);
            courseList.addCourse(course5);

        }
    }



