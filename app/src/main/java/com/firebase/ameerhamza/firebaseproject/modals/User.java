package com.firebase.ameerhamza.firebaseproject.modals;

/**
 * Created by Ameer Hamza on 12/12/2017.
 */

public class User {
    String first_name;
    String last_name;
    String blood_group;
    String city;
    String mobile_number;
    String profile_image;

    public User()
    {

    }

    public User(String first_name, String last_name, String blood_group, String city, String mobile_number, String profile_image) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.blood_group = blood_group;
        this.city = city;
        this.mobile_number = mobile_number;
        this.profile_image = profile_image;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    @Override
    public String toString() {
        return "User{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", blood_group='" + blood_group + '\'' +
                ", city='" + city + '\'' +
                ", mobile_number='" + mobile_number + '\'' +
                ", profile_image='" + profile_image + '\'' +
                '}';
    }
}
