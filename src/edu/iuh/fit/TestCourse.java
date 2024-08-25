package edu.iuh.fit;

import java.util.Scanner;

public class TestCourse {

    private static void initData(CourseList courseList) {
        courseList.addCourse(new Course("CS101", "Introduction to Computer Science", 4, "Computer Science"));
        courseList.addCourse(new Course("CS102", "Data Structures", 3, "Computer Science"));
    }

    public static void main(String[] args) {
        CourseList courseList = new CourseList();
        initData(courseList);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add a course");
            System.out.println("2. Remove a course");
            System.out.println("3. Search for a course by ID");
            System.out.println("4. Search for courses by title");
            System.out.println("5. Search for courses by department");
            System.out.println("6. Sort courses by title");
            System.out.println("7. Find courses with maximum credits");
            System.out.println("8. Find department with most courses");
            System.out.println("9. Display all courses");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter course ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter course title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter course credits: ");
                        int credits = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        System.out.print("Enter course department: ");
                        String department = scanner.nextLine();
                        courseList.addCourse(new Course(id, title, credits, department));
                        break;
                    case 2:
                        System.out.print("Enter course ID to remove: ");
                        id = scanner.nextLine();
                        courseList.removeCourse(id);
                        break;
                    case 3:
                        System.out.print("Enter course ID to search: ");
                        id = scanner.nextLine();
                        Course course = courseList.searchCourseById(id);
                        System.out.println(course != null ? course : "Course not found.");
                        break;
                    case 4:
                        System.out.print("Enter course title to search: ");
                        title = scanner.nextLine();
                        Course[] coursesByTitle = courseList.searchCourseByTitle(title);
                        displayCourses(coursesByTitle);
                        break;
                    case 5:
                        System.out.print("Enter course department to search: ");
                        department = scanner.nextLine();
                        Course[] coursesByDepartment = courseList.searchCourseByDepartment(department);
                        displayCourses(coursesByDepartment);
                        break;
                    case 6:
                        Course[] sortedCourses = courseList.sortCourses();
                        displayCourses(sortedCourses);
                        break;
                    case 7:
                        Course[] maxCreditCourses = courseList.findMaxCreditCourse();
                        displayCourses(maxCreditCourses);
                        break;
                    case 8:
                        String deptWithMostCourses = courseList.findDepartmentWithMostCourses();
                        System.out.println(deptWithMostCourses != null ? deptWithMostCourses : "No courses found.");
                        break;
                    case 9:
                        displayCourses(courseList.getCourses());
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void displayCourses(Course[] courses) {
        if (courses == null || courses.length == 0) {
            System.out.println("No courses found.");
        } else {
            System.out.printf("%-10s %-30s %-10s %-20s\n", "ID", "Title", "Credits", "Department");
            for (Course course : courses) {
                System.out.printf("%-10s %-30s %-10d %-20s\n", course.getId(), course.getTitle(), course.getCredit(), course.getDepartment());
            }
        }
    }
}