package sample;

import sample.Exceptions.CourseRateTooLowException;

public class Lecturer extends Academic{
    private int NoOfPublications;

    public Lecturer(int id, String name, float courseRate, int p) {
        super(id, name, courseRate);
        this.NoOfPublications=p;
    }

    public Lecturer(Employee employee) {
        super();
    }

    public Lecturer(Lecturer lecturer) {
        this.setId(lecturer.getId());
        this.setName(lecturer.getName());
        try {
            this.setCourseRate(lecturer.getCourseRate());
        } catch (CourseRateTooLowException e) {
            e.printStackTrace();
        }
        this.setNoOfPublications(lecturer.getNoOfPublications());
    }

    public Lecturer() {

    }

    public int getNoOfPublications() {
        return NoOfPublications;
    }

    public void setNoOfPublications(int noOfPublications) {
        NoOfPublications = noOfPublications;
    }

    @Override
    public String toString() {
        return super.toString()+ "NoOfPublications=" + NoOfPublications ;

    }
}
