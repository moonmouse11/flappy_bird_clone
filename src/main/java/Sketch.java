import elements.Cloud;
import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {

    float xPos = 200f;
    float yPos = 50f;
    float vy = 0f;
    float gravity = 0.98f;
    PImage bird;
    PImage pipe;
    Cloud[] clouds = new Cloud[]{new Cloud(), new Cloud(), new Cloud(), new Cloud()};


    public void settings() {
        fullScreen();
    }

    public void setup() {
        smooth();
        noStroke();
        bird = loadImage("data/pngegg.png");
        bird.resize(80, 80);
        pipe = loadImage("data/pipe.png");
        pipe.resize(100, 800);
    }

    public void draw() {
        background(200, 150, 255);
//        background(background);
//        Облака
        for (int i = 0; i < 4; i++) {
            drawCloud(i);
        }
//        Трубы
        drawPipes();
//        Птичка
        drawBird();
    }

    private void drawBird() {
        image(bird, xPos, yPos);
        vy += gravity;
        yPos += vy;
        if (yPos > height - 80) {
            yPos = height - 80;
        }
    }

//Движения птички
    public void keyPressed() {
        vy = -14.0f;
    }

    public void keyReleased() {
        vy = gravity;
    }


    void drawCloud(int number) {
        PImage pImage = loadImage(clouds[number].getImageCloud());
        pImage.resize(400, 300);
        image(pImage, clouds[number].getXPos(), clouds[number].getYPos());
        clouds[number].move();
        if (clouds[number].getXPos() < -400) {
            clouds[number].setNewXPos();
        }
    }

    void drawPipes() {
//        Вот сюда и писать все остальное
        image(pipe,0,400);
    }


}

