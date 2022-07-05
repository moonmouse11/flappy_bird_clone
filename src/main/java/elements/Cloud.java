package elements;

import processing.core.PImage;

import java.awt.*;
import java.util.Random;

public class Cloud {
    private static float distance = 0;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private Random random = new Random();
    private float XPos;
    private final float YPos;

    private final String imageCloud;

    public Cloud() {
        XPos = random.nextFloat(screenSize.width ) + distance;
        YPos = random.nextFloat(screenSize.height / 2) + (screenSize.height / 4);
        imageCloud = imageSwitch();
        distance += 150.0f;
    }

    public void move() {
        XPos -= 1.5f;
    }


    public float getXPos() {
        return XPos;
    }

    public float getYPos() {
        return YPos;
    }

    public void setNewXPos() {
        this.XPos = screenSize.width;
    }

    private String imageSwitch() {
        String[] cloudPic = new String[]{"data/cloud3.png", "data/cloud4.png", "data/cloud5.png"};
        int index = new Random().nextInt(cloudPic.length);
        return cloudPic[index];
    }

    public String getImageCloud() {
        return imageCloud;
    }

}
