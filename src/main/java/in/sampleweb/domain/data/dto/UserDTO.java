package in.sampleweb.domain.data.dto;

public class UserDTO {

    private Integer userId;
    private String uname;
    private String email;
    private Long phno;
    private Integer countryId;
    private Integer stateId;
    private Integer cityId;
    private String pwdReset;

    // Getters and setters

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhno() {
        return phno;
    }

    public void setPhno(Long phno) {
        this.phno = phno;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getPwdReset() {
        return pwdReset;
    }

    public void setPwdReset(String pwdReset) {
        this.pwdReset = pwdReset;
    }

    public String getPwdUpdated() {
	// TODO Auto-generated method stub
	return null;
    }
}

