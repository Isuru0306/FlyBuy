package com.flybuy.model;

public class ItemData {

    String placeName;
    String rating;
    String price;
    Integer imageUrl;
    String about;
    String qty;

    public String getQty() {
        return qty;
    }

    public ItemData(String placeName, String rating, String price, Integer imageUrl, String about, String qty) {
        this.placeName = placeName;
        this.rating = rating;
        this.price = price;
        this.imageUrl = imageUrl;
        this.about = about;
        this.qty = qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }



    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
