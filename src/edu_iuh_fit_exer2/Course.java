/*

 * Classname Course.javaa   1.0 8/28/2024
 *
 * Copyright (c) 2024 IUH. All right reserved
 */

package edu_iuh_fit_exer2;

/*
 * @description HELLO
 * @author: Anh Tuan
 * @date: 8/28/2024
 * version:   1.0
 */
public class Course {
    private final String id;
    private final String title;
    private final int credit;
    private final String department;

    public Course(String id, String title, int credit, String department) {
        this.id = id;
        this.title = title;
        this.credit = credit;
        this.department = department;
    }

    public int getCredit() {
        return credit;
    }

    public String getDepartment() {
        return department;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("%-10s%-30s%2d  %-10s", id, title, credit,department);
    }
}

