package pl.sevet.cbrestapi.dto;

public class UserDto {
    private Long id;
    private String name;
    private String surname;
    private boolean admin;

    public UserDto() {
    }

    public UserDto(Long id, String name, String surname, boolean admin) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.admin = admin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
