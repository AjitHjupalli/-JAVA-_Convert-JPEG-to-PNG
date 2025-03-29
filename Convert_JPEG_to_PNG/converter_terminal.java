import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageConverter {
    public static void main(String[] args) {
        try {
            // Open input image
            File inputFile = new File("input.jpeg");
            BufferedImage image = ImageIO.read(inputFile);
            
            // Save as output PNG
            File outputFile = new File("output.png");
            ImageIO.write(image, "png", outputFile);
            
            System.out.println("Conversion successful: output.png");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
