package sample;

public  class SecurityGuard extends NonAcademic {
    public SecurityGuard(int id, String name, float hourlyRate,String AreaA) {
        super(id, name, hourlyRate);
        this.AreaAssigned=AreaA;
    }

    public SecurityGuard() {
        super();
    }

    public SecurityGuard(Employee employee) {

    }

    @Override
    public String toString() {
        return super.toString()+
                " AreaAssigned='" + AreaAssigned;
    }

    private String AreaAssigned;

    public String getAreaAssigned() {
        return AreaAssigned;
    }

    public void setAreaAssigned(String areaAssigned) {
        AreaAssigned = areaAssigned;
    }


}
