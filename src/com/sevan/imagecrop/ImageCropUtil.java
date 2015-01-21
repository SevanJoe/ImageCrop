package com.sevan.imagecrop;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by jiao-9 on 1/21/2015.
 */
public class ImageCropUtil {

    /**
     * crop image with certain parameters
     *
     * @param sourcePath
     * @param descPath
     * @param cropX
     * @param cropY
     * @param width
     * @param height
     */
    public static void ImageCrop(String sourcePath, String descPath, int cropX, int cropY, int width, int height) {
        BufferedImage bufferedImage = readImageFile(sourcePath);
        bufferedImage = doCrop(bufferedImage, cropX, cropY, width, height);
        saveImageFile(bufferedImage, getImageSuffix(sourcePath), descPath);
    }

    /**
     * crop image center square
     *
     * @param sourcePath
     * @param descPath
     */
    public static void ImageCropCenterSquare(String sourcePath, String descPath) {
        BufferedImage bufferedImage = readImageFile(sourcePath);

        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        int scaleLength = Math.min(width, height);
        int cropX = 0;
        int cropY = 0;
        if (width > height) {
            cropX = (width - height) / 2;
        } else {
            cropY = (height - width) / 2;
        }

        bufferedImage = doCrop(bufferedImage, cropX, cropY, scaleLength, scaleLength);
        saveImageFile(bufferedImage, getImageSuffix(sourcePath), descPath);
    }

    private static BufferedImage readImageFile(String path) {
        File imageFile = new File(path);
        try {
            return ImageIO.read(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static BufferedImage doCrop(BufferedImage bufferedImage, int cropX, int cropY, int width, int height) {
        return bufferedImage.getSubimage(cropX, cropY, width, height);
    }

    private static String getImageSuffix(String path) {
        return path.substring(path.lastIndexOf(".") + 1);
    }

    private static void saveImageFile(BufferedImage bufferedImage, String suffix, String path) {
        File imageFile = new File(path);
        try {
            ImageIO.write(bufferedImage, suffix, imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
