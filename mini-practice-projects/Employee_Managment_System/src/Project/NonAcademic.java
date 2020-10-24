package Model;

import Model.Exceptions.CourseRateTooLowException;
import Model.Exceptions.HourlyrateTooLowException;

public class NonAcademic extends Employee {
    private float hourlyRate;

    public float getHourlyRate() {
        return hourlyRate;
    }


    public void setHourlyRate(float hourlyRate) throws HourlyrateTooLowException {
        if(hourlyRate>1500){
            this.hourlyRate = hourlyRate;
        }else{
            throw new HourlyrateTooLowException("Hourly Rate is Too low");
        }
    }
}
