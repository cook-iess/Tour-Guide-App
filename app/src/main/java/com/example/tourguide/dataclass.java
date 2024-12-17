package com.example.tourguide;

import android.widget.ImageView;

public class dataclass {

    private String tourTitle, tourDescription, tourCost, tourDate, tourLocation, tourContact, tourReview, tourGenre, imageUri, key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public dataclass(String tourTitle, String tourDescription, String tourCost, String tourLocation, String tourDate, String tourContact, String tourReview, String tourGenre, String imageUri) {
        this.tourTitle = tourTitle;
        this.tourDescription = tourDescription;
        this.tourCost = tourCost;
        this.tourDate = tourDate;
        this.tourLocation = tourLocation;
        this.tourContact = tourContact;
        this.tourReview = tourReview;
        this.tourGenre = tourGenre;
        this.imageUri = imageUri;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public String getTourCost() {
        return tourCost;
    }

    public void setTourCost(String tourCost) {
        this.tourCost = tourCost;
    }

    public String getTourTitle() {
        return tourTitle;
    }

    public String getTourDescription() {
        return tourDescription;
    }

    public String getTourDate() {
        return tourDate;
    }

    public String getTourLocation() {
        return tourLocation;
    }

    public String getTourContact() {
        return tourContact;
    }

    public String getTourReview() {
        return tourReview;
    }

    public void setTourTitle(String tourTitle) {
        this.tourTitle = tourTitle;
    }

    public void setTourDescription(String tourDescription) {
        this.tourDescription = tourDescription;
    }

    public void setTourDate(String tourDate) {
        this.tourDate = tourDate;
    }

    public void setTourLocation(String tourLocation) {
        this.tourLocation = tourLocation;
    }

    public void setTourContact(String tourContact) {
        this.tourContact = tourContact;
    }

    public void setTourReview(String tourReview) {
        this.tourReview = tourReview;
    }

    public void setTourGenre(String tourGenre) {
        this.tourGenre = tourGenre;
    }

    public String getTourGenre() {
        return tourGenre;
    }

    public dataclass(){
    }

}
