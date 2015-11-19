package de.helfenkannjeder.come2help.server.rest.dto;

import de.helfenkannjeder.come2help.server.domain.Address;
import de.helfenkannjeder.come2help.server.domain.Volunteer;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;

public class VolunteerDto {

    private Long id;

    @Email
    private String email;
    @NotNull
    private String givenName;
    @NotNull
    private String surname;
    private AddressDto address;
    private String phone;
    @AssertTrue
    private boolean adult;

    public VolunteerDto() {
    }

    public VolunteerDto(Long id, String email, String givenName, String surname, AddressDto address, String phone, boolean adult) {
        this.id = id;
        this.email = email;
        this.givenName = givenName;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.adult = adult;
    }

    public static VolunteerDto createFullDto(Volunteer volunteer) {
        AddressDto addressDto = AddressDto.createFullDto(volunteer.getAddress());
        return new VolunteerDto(volunteer.getId(), volunteer.getEmail(), volunteer.getGivenName(), volunteer.getSurname(), addressDto, volunteer.getPhone(), volunteer.isAdult());
    }

    public static Volunteer createVolunteer(VolunteerDto dto) {
        Address address = AddressDto.createAddress(dto.getAddress());
        return new Volunteer(dto.id, dto.email, dto.givenName, dto.surname, address, dto.phone, dto.adult);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean isAdult) {
        this.adult = isAdult;
    }

}
