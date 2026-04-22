public class Teacher extends Person {
    private int numCourses = 0;
    private String[] courses = new String[10];

    public Teacher(String name, String address) {
        super(name, address);
    }

    public boolean addCourse(String course) {
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].equals(course)) return false;
        }
        courses[numCourses] = course;
        numCourses++;
        return true;
    }

    public boolean removeCourse(String course) {
        int indexFound = -1;
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].equals(course)) {
                indexFound = i;
                break;
            }
        }
        
        if (indexFound == -1) return false;

        for (int i = indexFound; i < numCourses - 1; i++) {
            courses[i] = courses[i+1];
        }
        numCourses--;
        return true;
    }

    @Override
    public String toString() {
        return "Teacher: " + super.toString();
    }
}