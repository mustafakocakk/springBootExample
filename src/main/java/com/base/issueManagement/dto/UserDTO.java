package com.base.issueManagement.dto;

public class UserDTO {
    private Long id;
    private String nameSurname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", nameSurname='" + nameSurname + '\'' +
                '}';
    }
}
