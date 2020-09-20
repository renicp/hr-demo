package hr.demo.vo;

public class EmployeeJobVo {
    private String fullName;
    private int emplJobId;
    private String emplJobDesc;

    public EmployeeJobVo(String firstName, String lastName, int jobId, String jobDesc){
        this.fullName = firstName+" "+lastName;
        this.emplJobId = jobId;
        this.emplJobDesc = jobDesc;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getEmplJobId() {
        return emplJobId;
    }

    public void setEmplJobId(int emplJobId) {
        this.emplJobId = emplJobId;
    }

    public String getEmplJobDesc() {
        return emplJobDesc;
    }

    public void setEmplJobDesc(String emplJobDesc) {
        this.emplJobDesc = emplJobDesc;
    }
}
