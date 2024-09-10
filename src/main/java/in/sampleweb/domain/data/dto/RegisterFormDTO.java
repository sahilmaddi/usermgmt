package in.sampleweb.domain.data.dto;

public class RegisterFormDTO {
    private String name;
    private String email;
    private String phone;
    private String countryId;
    private String stateId;
    private String cityId;

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getCountryId() { return countryId; }
    public void setCountryId(String countryId) { this.countryId = countryId; }
    public String getStateId() { return stateId; }
    public void setStateId(String stateId) { this.stateId = stateId; }
    public String getCityId() { return cityId; }
    public void setCityId(String cityId) { this.cityId = cityId; }
}
