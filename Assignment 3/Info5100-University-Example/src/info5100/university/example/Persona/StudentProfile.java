/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona;

import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.SeatAssignment;
import info5100.university.example.Persona.EmploymentHistory.EmploymentHistroy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author kal bugrara
 */
public class StudentProfile {

    Person person;
    Transcript transcript;
    EmploymentHistroy employmenthistory;
    private String studentEnrollmentId;
    private double tuitionPerCredit;
    String grade;
    private Map<String, String> courseGrades = new HashMap<>();

    public StudentProfile(Person p) {

        person = p;
        transcript = new Transcript(this);
        employmenthistory = new EmploymentHistroy();
    }

    public boolean isMatch(String id) {
        return person.getPersonId().equals(id);
    }

    public Transcript getTranscript() {
        return transcript;
    }

    public CourseLoad getCourseLoadBySemester(String semester) {

        return transcript.getCourseLoadBySemester(semester);
    }

    public CourseLoad getCurrentCourseLoad() {

        return transcript.getCurrentCourseLoad();
    }

    public CourseLoad newCourseLoad(String s) {

        return transcript.newCourseLoad(s);
    }

    public ArrayList<SeatAssignment> getCourseList() {

        return transcript.getCourseList();

    }
     public String getStudentId() {
        return studentEnrollmentId;
    }
     
    public void setStudentId(String studentId) {
        this.studentEnrollmentId = studentId;
    }

    public String getGrade() {
        if (grade != null) {
            return grade;
        } else {
            return "N/A"; // Return a default value if grade is not available
        }
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Person getPerson() {
        return person;
    }

    public String getGradeForCourse(String courseNumber) {
        return courseGrades.getOrDefault(courseNumber, "N/A");
    }

    public void setGradeForCourse(String courseNumber, String grade) {
        courseGrades.put(courseNumber, grade);
    }
}
