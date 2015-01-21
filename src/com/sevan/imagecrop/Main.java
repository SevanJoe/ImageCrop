package com.sevan.imagecrop;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String sourcePath = "portrait.jpg";
        String descPath = "crop.jpg";
        ImageCropUtil.ImageCropCenterSquare(sourcePath, descPath);
    }
}
