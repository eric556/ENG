package nowace.Graphics;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

/**
 * Created by enpie on 7/5/2017.
 */
public final class Texture {
    private Image image;

    public Texture(String filepath){
        image = new Image(filepath);
    }

    public Texture(Image image){
        this.image = image;
    }

    public Texture(Texture texture, int top, int left, int width, int height){
        this(texture.getImage());
        image = this.getTextureRect(top,left,width,height);
    }

    public Image getTextureRect(int top, int left, int width, int height){
        WritableImage writableImage = new WritableImage(width,height);
        PixelWriter writer = writableImage.getPixelWriter();
        PixelReader reader = image.getPixelReader();

        for(int y = top; y < height; y++){
            for(int x = left; x < width; x++){
                Color c = reader.getColor(x,y);
                writer.setColor(x,y,c);
            }
        }

        return writableImage;
    }

    public Image getImage(){
        return image;
    }
}
