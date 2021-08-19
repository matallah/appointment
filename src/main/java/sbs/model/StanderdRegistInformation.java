package sbs.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@MappedSuperclass
public class StanderdRegistInformation extends AbstractModel<Long> {

    @Transient
    public static final String GENDER_MALE = "MALE";
    @Transient
    public static final String GENDER_FEMALE = "FEMALE";
    @Column
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column
    private String firstName = "";
    @Basic(optional = false)
    @NotNull
    @Column
    private String secondName = "";
    @Basic(optional = false)
    @NotNull
    @Column
    private String lastName = "";
    @Column
    private String address;
    @Size(max = 15)
    @Column
    private String phoneNumber;
    @Size(max = 15)
    @Column
    private String mobileNumber;
    @Column
    private String personalId;
    @DateTimeFormat(pattern = DATE_FORMAT)
    @Column
    @Temporal(TemporalType.DATE)
    private Date endDatePersonalId;
    @Column
    private String gender;
    @DateTimeFormat(pattern = DATE_FORMAT)
    @Column
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Lob
    @Column
    private byte[] scannerPhoto;
    @Lob
    @Column
    private byte[] scannerPersonalId;
    @Lob
    @Column
    private byte[] scannerBirthDateId;
    @Lob
    @Column
    private byte[] scannerDocument1;
    @Lob
    @Column
    private byte[] scannerDocument2;

    public StanderdRegistInformation() {
    }

    public StanderdRegistInformation(Long id) {
        super(id);
    }

    public StanderdRegistInformation(String firstName, String secondName, String lastName) {
        super("", new Date(), 1L);
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
    }


    @Override
    public String getName() {
        return this.firstName + " " + this.secondName + " " + this.lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public Date getEndDatePersonalId() {
        return endDatePersonalId;
    }

    public void setEndDatePersonalId(Date endDatePersonalId) {
        this.endDatePersonalId = endDatePersonalId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public byte[] getScannerPhoto() {
        return scannerPhoto;
    }

    public void setScannerPhoto(byte[] scannerPhoto) {
        this.scannerPhoto = scannerPhoto;
    }

    public byte[] getScannerPersonalId() {
        return scannerPersonalId;
    }

    public void setScannerPersonalId(byte[] scannerPersonalId) {
        this.scannerPersonalId = scannerPersonalId;
    }

    public byte[] getScannerBirthDateId() {
        return scannerBirthDateId;
    }

    public void setScannerBirthDateId(byte[] scannerBirthDateId) {
        this.scannerBirthDateId = scannerBirthDateId;
    }

    public byte[] getScannerDocument1() {
        return scannerDocument1;
    }

    public void setScannerDocument1(byte[] scannerDocument1) {
        this.scannerDocument1 = scannerDocument1;
    }

    public byte[] getScannerDocument2() {
        return scannerDocument2;
    }

    public void setScannerDocument2(byte[] scannerDocument2) {
        this.scannerDocument2 = scannerDocument2;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
