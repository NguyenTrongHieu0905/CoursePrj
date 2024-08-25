package edu.iuh.fit;

public class Course {
    private int credit;
    private String department;
    private String id;
    private String title;

    /**
     * Default constructor for Course.
     */
    public Course() {}

    /**
     * Constructor for Course.
     *
     * @param id        The course ID. ID must have at least 3 characters
     *                  and contain only letters or digits
     * @param title     The course title. Title must not be empty.
     * @param credit    The course credit. Credit must be greater than 0.
     * @param department The course department.
     */
    public Course(String id, String title, int credit, String department) {
        setId(id);
        setTitle(title);
        setCredit(credit);
        setDepartment(department);
    }

    /**
     * Gets the course credit.
     *
     * @return The course credit.
     */
    public int getCredit() {
        return credit;
    }

    /**
     * Sets the course credit.
     *
     * @param credit The course credit. Credit must be greater than 0.
     * @throws IllegalArgumentException If Credit must be greater than 0.
     */
    public void setCredit(int credit) {
        if (credit <= 0) {
            throw new IllegalArgumentException("Credit must be greater than 0");
        }
        this.credit = credit;
    }

    /**
     * Gets the course department.
     *
     * @return The course department.
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets the course department.
     *
     * @param department The course department.
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Gets the course ID.
     *
     * @return The course ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the course ID.
     *
     * @param id The course ID.  ID must have at least 3 characters
     *           and contain only letters or digits
     * @throws IllegalArgumentException If ID must have at least 3 characters
     *                                  or ID must contain only letters or digits.
     */
    public void setId(String id) {
        if (id == null || id.length() < 3) {
            throw new IllegalArgumentException("ID must have at least 3 characters");
        }
        if (!id.matches("[a-zA-Z0-9]+")) {
            throw new IllegalArgumentException("ID must contain only letters or digits");
        }
        this.id = id;
    }

    /**
     * Gets the course title.
     *
     * @return The course title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the course title.
     *
     * @param title The course title. Title must not be empty.
     * @throws IllegalArgumentException If Title must not be empty.
     */
    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title must not be empty");
        }
        this.title = title;
    }

    @Override
    public String toString() {
        return String.format( "%-10s%-25s%d  %-15s", id, title, department, credit );

    }
}