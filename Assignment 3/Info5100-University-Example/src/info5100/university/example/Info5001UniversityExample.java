/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseCatalog.CourseCatalog;
import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.CourseSchedule.SeatAssignment;
import info5100.university.example.Department.Department;
import info5100.university.example.Persona.Faculty.FacultyAssignment;
import info5100.university.example.Persona.Faculty.FacultyDirectory;
import info5100.university.example.Persona.Faculty.FacultyProfile;
import info5100.university.example.Persona.Person;
import info5100.university.example.Persona.PersonDirectory;
import info5100.university.example.Persona.StudentDirectory;
import info5100.university.example.Persona.StudentProfile;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author kal bugrara
 */
public class Info5001UniversityExample {  
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {       
        //Create Information Systems Department
        Department department = new Department("Information Systems");
        CourseCatalog coursecatalog = department.getCourseCatalog();
        StudentDirectory studentDirectory = department.getStudentDirectory();
        FacultyDirectory facultyDirectory = department.getFacultyDirectory();
        PersonDirectory personDirectory = department.getPersonDirectory();
        
        //Adding new courses in course catalog 
        //Information systems courses
        List<Course> courses = getCourses(coursecatalog);
        
        //Browse course catalog
        //Display all courses in information systems course catalog
        browseCourseCatalog(coursecatalog);
        
        //Display information systems course by course number
        browseCourseByCourseNumber(coursecatalog, "INFO 5100");
        
        //Add core and elective courses in information systems department
        addCoreAndElectives(coursecatalog, department, "INFO 5100");
                
        //Create course schedule for information systems for semester Fall 2024
        CourseSchedule courseSchedule = department.newCourseSchedule("Fall 2024");
        for(int i=0; i<courses.size()-1; i++) {
            CourseOffer courseOfferedByInfo = courseSchedule.newCourseOffer(courses.get(i).getCOurseNumber());
            if(courseOfferedByInfo == null) return;
            courseOfferedByInfo.generatSeats(30);
        }

        List<CourseOffer> courseOffers = courseSchedule.getCourseOffers();
           
        //Add faculties in information systems department
        addFacultyAndAssignCourses(personDirectory, facultyDirectory, courseOffers); 

        //Display course schedule
        //displayCourseSchedule(courseSchedule, facultyDirectory);
        
        //Add and register students in department
        //addAndRegisterStudentsToCourse(studentDirectory, personDirectory, courseOffers, courseSchedule);    

        //Display report for semester
        //printReport(studentDirectory, facultyDirectory, "Fall 2024");
    }

    private static List<Course> getCourses(CourseCatalog coursecatalog) {
        List<Course> courses = new ArrayList<Course>();
        courses.add(new Course("Application Enggineering and Development", "INFO 5100", 4));
        courses.add(new Course("Data Science Engineering Methods and Tools", "INFO 6105", 4));
        courses.add(new Course("Web Design and User Experience Engineering", "INFO 6150", 4));
        courses.add(new Course("Neural Modeling Methods and Tools", "INFO 6106", 4));
        courses.add(new Course("Program Structures and Alogrithms", "INFO 6205", 4));
        courses.add(new Course("Business Analysis and Information Engineering", "INFO 6215", 2));
        courses.add(new Course("Planning and Managing Information Systems Development", "INFO 6245", 4));
        courses.add(new Course("Software Quality Control and Management", "INFO 6255", 2));
        courses.add(new Course("Smartphones-Based Web Development", "INFO 6350", 4));  
        courses.add(new Course("Business Ethics and Intellectual Property for Engineers", "INFO 6660", 2));
        courses.add(new Course("High-Performance Coding for Fintech", "INFO 7110", 4));  
        for(Course course : courses) {
            coursecatalog.newCourse(course.getName(), course.getNumber(), course.getCredits());
        }
        return courses;
    }     

    private static void printReport(StudentDirectory studentDirectory, FacultyDirectory facultyDirectory, String semester) {
        System.out.println("                           REPORT FOR SEMESTER " + semester + "                     ");
        System.out.println("==================================================================================");
    
        List<StudentProfile> students = studentDirectory.getStudentlist(); 

        Map<String, Double> gradeToGpa = getGradeToGpa();

        for (StudentProfile student : students) {
            System.out.println("----------------------------------------------------------");
            CourseLoad courseLoad = student.getCourseLoadBySemester(semester);
            double totalGpa = 0.0;
            int totalCourses = 0;
            int coursePrice = 0;
            String facultyName;
    
            if (courseLoad != null) {
                System.out.println("Student: " + student.getPerson().getPersonId());
    
                for (SeatAssignment seatAssignment : courseLoad.getSeatAssignments()) {
                    String courseNumber = seatAssignment.getSeat().getCourseOffer().getCourse().getCOurseNumber();
                    facultyName = getFacultyNameForCourse(courseNumber, facultyDirectory);
                    String courseName = seatAssignment.getSeat().getCourseOffer().getCourse().getName();
                    coursePrice = coursePrice + seatAssignment.getSeat().getCourseOffer().getCourse().getCoursePrice();
                    String grade = student.getGradeForCourse(courseNumber);
                    System.out.println(" - Registered Course: " + courseName + " (" + courseNumber + ") Grade: " + grade);
                    System.out.println(" - Faculty for Course: " + facultyName);

                    if (gradeToGpa.containsKey(grade)) {
                        totalGpa += gradeToGpa.get(grade);
                        totalCourses++;
                    }
                }
                if (totalCourses > 0) {
                    double averageGpa = totalGpa / totalCourses;
                    System.out.printf(" - Average GPA for Student %s: %.2f%n", student.getPerson().getPersonId(), averageGpa);
                    System.out.println(" - Tuition fee for the student  is: " + coursePrice);
                } else {
                    System.out.println("No grades available to calculate GPA.");
                }
            } else {
                System.out.println("Student: " + student.getPerson().getPersonId() + " has no registered courses in this semester.");
            }
        }
        System.out.println("==================================================================================");
        System.out.println("                                   END OF REPORT                                  ");
        System.out.println("==================================================================================");
    }

    private static String getFacultyNameForCourse(String courseNumber, FacultyDirectory facultyDirectory) {
        ArrayList<FacultyProfile> profiles = facultyDirectory.getTeacherlist();
        for (FacultyProfile facultyProfile : profiles) {
            ArrayList<FacultyAssignment> facultyAssignments = facultyProfile.getFacultyAssignments();
            for (FacultyAssignment facultyAssignment : facultyAssignments) {
                CourseOffer courseOffer = facultyAssignment.getCourseoffer();
                if(courseOffer.getCourseNumber().equals(courseNumber)) {
                    return facultyProfile.getPerson().getPersonId();
                }
            }
        }
        return null;
    }

    private static Map<String, Double> getGradeToGpa() {
        Map<String, Double> gradeToGpa = new HashMap<>();
        gradeToGpa.put("A", 4.0);
        gradeToGpa.put("A-", 3.7);
        gradeToGpa.put("B+", 3.3);
        gradeToGpa.put("B", 3.0);
        gradeToGpa.put("B-", 2.7);
        gradeToGpa.put("C+", 2.3);
        gradeToGpa.put("C", 2.0);
        gradeToGpa.put("C-", 1.7);
        gradeToGpa.put("D", 1.0);
        gradeToGpa.put("F", 0.0);
        return gradeToGpa;
    }

    private static void addAndRegisterStudentsToCourse(StudentDirectory studentDirectory, PersonDirectory personDirectory, List<CourseOffer> courseOffers, CourseSchedule courseSchedule) {
        System.out.println("                    ADDING STUDENTS AND REGISTERING FOR COURSES                   ");
        System.out.println("==================================================================================");
    
        CourseOffer info5100Offer = null;
        for (CourseOffer courseOffer : courseOffers) {
            if ("INFO 5100".equals(courseOffer.getCourse().getCOurseNumber())) {
                info5100Offer = courseOffer;
                info5100Offer.generatSeats(30); 
                break;
            }
        }
    
        if (info5100Offer == null) {
            System.out.println("INFO 5100 course not found.");
            return;
        }
    
        List<String> grades = Arrays.asList("A", "B", "C", "D", "F");
        Random random = new Random();
    
        for (int i = 1; i <= 30; i++) {
            System.out.println("---------------------------------------------------------------------");
            Person person = personDirectory.newPerson("StudentName" + i);
            StudentProfile studentProfile = studentDirectory.newStudentProfile(person);
            CourseLoad courseLoad = studentProfile.getCourseLoadBySemester("Fall 2024");
            if (courseLoad == null) {
                courseLoad = studentProfile.newCourseLoad("Fall 2024"); 
            }
    
            SeatAssignment infoSeatAssignment = info5100Offer.assignEmptySeat(courseLoad);
            if (infoSeatAssignment != null) {
                System.out.println("Student: " + person.getPersonId() + " registered to course INFO 5100");
    
                String info5100Grade = grades.get(random.nextInt(grades.size()));
                studentProfile.setGradeForCourse("INFO 5100", info5100Grade);
                System.out.println("Assigned grade " + info5100Grade + " to Student for INFO 5100");
                System.out.println("");
            } else {
                System.out.println("No available seats for INFO 5100.");
            }
    
            CourseOffer randomCourseOffer;
            SeatAssignment randomSeatAssignment;
            do {
                randomCourseOffer = courseOffers.get((int) (Math.random() * courseOffers.size()));
            } while (randomCourseOffer.equals(info5100Offer));
    
            if (randomCourseOffer.getSeatlist().isEmpty()) {
                randomCourseOffer.generatSeats(30);
            }
    
            randomSeatAssignment = randomCourseOffer.assignEmptySeat(courseLoad);
            if (randomSeatAssignment != null) {
                String randomCourseNumber = randomCourseOffer.getCourse().getCOurseNumber();
                System.out.println("Student: " + person.getPersonId() + " registered to course " + randomCourseNumber);
    
                String randomCourseGrade = grades.get(random.nextInt(grades.size()));
                studentProfile.setGradeForCourse(randomCourseNumber, randomCourseGrade);
                System.out.println("Assigned grade " + randomCourseGrade + " to Student for " + randomCourseNumber);
            } else {
                System.out.println("No available seats for course " + randomCourseOffer.getCourse().getCOurseNumber());
            }
        }
        System.out.println("==================================================================================");    
    }

    private static void addFacultyAndAssignCourses(PersonDirectory personDirectory, FacultyDirectory facultyDirectory, List<CourseOffer> courseOffers) {
        System.out.println("                     ADDING FACULTY AND ASSIGNING COURSES                         ");
        System.out.println("==================================================================================");
        for (int i = 1; i <= 10; i++) {
            // Create a new person and add to the faculty directory
            Person person = personDirectory.newPerson("FacultyName" + i);
            FacultyProfile faculty = facultyDirectory.newFacultyProfile(person);
            CourseOffer courseOffer = courseOffers.get(i % courseOffers.size());
            faculty.AssignAsTeacher(courseOffer);
            System.out.println("Assigned course " + courseOffer.getCourseNumber() + " to faculty " + person.getPersonId());
        }
        System.out.println("==================================================================================");
    }
    
    private static void browseCourseByCourseNumber(CourseCatalog coursecatalog, String courseNumber) {
        System.out.println("==================================================================================");
        System.out.println("Course details for: " + courseNumber);
        Course course = coursecatalog.getCourseByNumber(courseNumber);
        if (course != null) {
            System.out.println(course.toString());
        } else {
            System.out.println("Course not found.");
        }   
        System.out.println("==================================================================================");     
    }
   
    private static void browseCourseCatalog(CourseCatalog courseCatalog) {
        System.out.println("==================================================================================");
        System.out.println("                                    COURSE CATALOG                                ");
        System.out.println("==================================================================================");
        for (Course course : courseCatalog.getCourseList()) {
            System.out.println(course.toString());
        }
    }
        
     private static void addCoreAndElectives(CourseCatalog coursecatalog, Department department, String core) {
        for(Course course : coursecatalog.getCourseList()) {
            if(course.getCOurseNumber().equals(core)) {
                department.addCoreCourse(course);
                System.out.println("Core course " + core + " added.");
                System.out.println("==================================================================================");
            } else {
                department.addElectiveCourse(course);
                System.out.println("Elective course " + course.getCOurseNumber() + " added.");               
            }
        }
        System.out.println("==================================================================================");
    }   

    private static void displayCourseSchedule(CourseSchedule courseSchedule, FacultyDirectory facultyDirectory) {
        System.out.println("                                COURSE SCHEDULE                                   ");
        System.out.println("==================================================================================");
        System.out.println("Semester: " + courseSchedule.getSemester());
        System.out.println("\nCourse Offers:");

        ArrayList<CourseOffer> courseOffers = courseSchedule.getCourseOffers();

        for (CourseOffer courseOffer : courseOffers) {
            Course course = courseOffer.getCourse();
            String courseName = course.getName();
            String courseNumber = course.getCOurseNumber();

            ArrayList<String> assignedFacultyNames = new ArrayList<>(); 

            for (FacultyProfile facultyProfile : facultyDirectory.getTeacherlist()) {
                for (FacultyAssignment facultyAssignment : facultyProfile.getFacultyAssignments()) {
                    if (facultyAssignment.getCourseoffer().equals(courseOffer)) {
                        Person facultyPerson = facultyProfile.getPerson();
                        assignedFacultyNames.add(facultyPerson.getPersonId());
                    }
                }
            }

            if (!assignedFacultyNames.isEmpty()) {
                System.out.print("Course: " + courseName + " | Number: " + courseNumber + " | Seats: 20 | Faculty: ");
                System.out.println(String.join(", ", assignedFacultyNames));
            } else {
                System.out.println("Course: " + courseName + " | Number: " + courseNumber + " | Seats: 20 | No faculty assigned");
            }
        }
        System.out.println("==================================================================================");
    }
}