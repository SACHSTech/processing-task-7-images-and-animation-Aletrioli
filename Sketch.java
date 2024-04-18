import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
	
	PImage imgLogo;
  PImage imgBackg;

  float fltLogoX = 150;
  float fltLogoY = 300;
  int intMoveX = 5;

  float fltSquareX = 150;
  float fltSquareY = 0;
  float fltSquareMoveX = 10;
  float fltSquareMoveY = (float)7.5;

  float fltCircleDistanceX;
  float fltCircleDistanceY;
  
  
  public void settings() {
    size(400, 400);
  }

  public void setup() {
    background(40, 70, 100);

    imgBackg = loadImage("/images/Radiance.jpg");
    imgLogo = loadImage("/images/Logo.png");
    imgLogo.resize(width / 4, height / 4);
    imgBackg.resize((int)(imgBackg.width/3.6), (int)(imgBackg.height/3.6));
  }

  public void draw() {

    // background
    image(imgBackg, -240, 0);

    // everything involving the logo
    image(imgLogo, fltLogoX, fltLogoY);

    fltLogoX += intMoveX;
    fltLogoY = 50 * (float)Math.sin(5 * (fltLogoX + 5)) + 120;

    if (fltLogoX < 0 + 75 || fltLogoX > width - imgLogo.width - 75) {
      intMoveX *= -1;
    }
    
    // shape 
    stroke(54, 54, 105);
    fill(93, 138, 168);
    rect(fltSquareX, fltSquareY, width/8, height/8);

    fltSquareX += fltSquareMoveX;
    fltSquareY += fltSquareMoveY;

    if (fltSquareX < 0 || fltSquareX > width - width/8) {
      fltSquareMoveX *= -1;
    }

    if (fltSquareY < 0 || fltSquareY > height - height/8) {
      fltSquareMoveY *= -1;
    }

    // shape collision (THIS TOOK SO MUCH PAIN AND SUFFERING)
    fltCircleDistanceX = abs(fltLogoX + 25 - fltSquareX);
    fltCircleDistanceY = abs(fltLogoY + 25 - fltSquareY);

    if (fltCircleDistanceX <= (width / 8 / 2 + width / 8) && fltCircleDistanceY <= (height / 8 / 2 + height / 8)) { 
      if (fltCircleDistanceX - 10.5 >= (width / 8 / 2 + width / 8) || fltCircleDistanceX + 10.5 >= (width / 8 / 2 + width / 8)){
        fltSquareMoveX *= -1; 
        fltSquareX += fltSquareMoveX;
      } else {
        fltSquareMoveY *= -1;
        fltSquareY += fltSquareMoveY;
      }
    }

  }

}