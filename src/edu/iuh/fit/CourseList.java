package edu.iuh.fit;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CourseList {
    private int count = 0;
    private List<Course> courses;

    public CourseList() {
        courses = new ArrayList<>();
    }

    public CourseList(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Length of the array must be greater than 0");
        }
        courses = new ArrayList<>(initialCapacity);
    }

    public boolean addCourse(Course course) {
        if (exists(course)) {
            System.out.println("Course with id " + course.getId() + " already exists.");
            return false;
        }
        courses.add(course);
        count++;
        return true;
    }

    public boolean exists(Course course) {
        return courses.stream().anyMatch(c -> c.getId().equals(course.getId()));
    }

    public Course[] getCourses() {
        return courses.toArray(new Course[0]);
    }

    public boolean removeCourse(String id) {
        for (Course course : courses) {
            if (course.getId().equals(id)) {
                courses.remove(course);
                count--;
                return true;
            }
        }
        System.out.println("Course with id " + id + " does not exist.");
        return false;
    }

    public Course searchCourseById(String id) {
        return courses.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    public Course[] searchCourseByTitle(String title) {
        List<Course> result = courses.stream().filter(c -> c.getTitle().contains(title)).collect(Collectors.toList());
        return result.isEmpty() ? null : result.toArray(new Course[0]);
    }

    public Course[] searchCourseByDepartment(String department) {
        List<Course> result = courses.stream().filter(c -> c.getDepartment().equals(department)).collect(Collectors.toList());
        return result.isEmpty() ? null : result.toArray(new Course[0]);
    }

    public Course[] sortCourses() {
        List<Course> sortedCourses = new ArrayList<>(courses);
        sortedCourses.sort(Comparator.comparing(Course::getTitle));
        return sortedCourses.toArray(new Course[0]);
    }

    public Course[] findMaxCreditCourse() {
        int maxCredit = courses.stream().max(Comparator.comparingInt(Course::getCredit)).get().getCredit();
        List<Course> result = courses.stream().filter(c -> c.getCredit() == maxCredit).collect(Collectors.toList());
        return result.toArray(new Course[0]);
    }

    public String findDepartmentWithMostCourses() {
        return courses.stream()
                .collect(Collectors.groupingBy(Course::getDepartment, Collectors.counting()))
                .entrySet().stream()
                .max(Comparator.comparingLong(e -> e.getValue()))
                .map(e -> e.getKey())
                .orElse(null);
    }
}