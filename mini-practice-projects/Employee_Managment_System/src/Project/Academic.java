package Model;

import Model.Exceptions.CourseRateTooLowException;

public class Academic extends Employee {
    private float courseRate;

    public float getCourseRate() {
        return courseRate;
    }

    public void setCourseRate(float courseRate) throws CourseRateTooLowException {
        if(courseRate>1500){
        this.courseRate = courseRate;
    }else{
            throw new CourseRateTooLowException("Course Rate is Too low");
        }
    }
}
