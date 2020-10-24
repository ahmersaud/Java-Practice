package sample;

import sample.Exceptions.CourseRateTooLowException;

public  class Academic extends Employee {
    public Academic(int id, String name,float courseRate) {
        super(id, name);
        try {
            this.setCourseRate(courseRate);
        } catch (CourseRateTooLowException e) {
            e.printStackTrace();
        }
    }

    public Academic() {
        super();
    }

    @Override
    public String toString() {
        return super.toString()+" courseRate=" + courseRate  ;
    }

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
