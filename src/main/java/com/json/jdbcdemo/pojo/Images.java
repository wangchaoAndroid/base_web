package com.json.jdbcdemo.pojo;

public class Images {


    private String imageUrl;


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Images{" +
                "imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
