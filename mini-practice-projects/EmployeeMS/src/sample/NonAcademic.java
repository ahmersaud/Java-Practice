package sample;

import sample.Exceptions.HourlyrateTooLowException;

public  class NonAcademic extends Employee  {
    public NonAcademic(int id, String name,float hourlyRate) {
        super(id, name);
        try {
            this.setHourlyRate(hourlyRate);
        } catch (HourlyrateTooLowException e) {
            e.printStackTrace();
        }
    }

    public NonAcademic() {

    }

    @Override
    public String toString() {
        return super.toString()+
                "hourlyRate=" + hourlyRate;
    }

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
