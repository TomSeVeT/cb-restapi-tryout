package pl.sevet.cbrestapi.dto;

public class UserAccessDto {
    private Long userId;
    private Long locationId;

    public UserAccessDto() {
    }

    public UserAccessDto(Long userId, Long locationId) {
        this.userId = userId;
        this.locationId = locationId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }
}
