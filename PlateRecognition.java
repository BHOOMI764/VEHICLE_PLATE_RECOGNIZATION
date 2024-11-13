import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import java.io.File;

public class PlateRecognition {

    public static void main(String[] args) {

        String imagePath = "C:/Users/bhoom/OneDrive/Pictures/Screenshots/vehicle_img.png";  
        
        
        System.setProperty("TESSDATA_PREFIX", "C:/Program Files (x86)/Tesseract-OCR/");

      
        String plateText = extractTextFromPlate(imagePath);

        if (plateText != null && !plateText.isEmpty()) {
            System.out.println("Detected License Plate: " + plateText);
        } else {
            System.out.println("OCR failed to detect text.");
        }
    }

    public static String extractTextFromPlate(String imagePath) {

        ITesseract tesseract = new Tesseract();

        tesseract.setDatapath("C:/Program Files (x86)/Tesseract-OCR/tessdata");
        
        tesseract.setLanguage("eng");

        try {
           
            File imageFile = new File(imagePath);

            String result = tesseract.doOCR(imageFile);
            return result.trim();

        } catch (TesseractException e) {
            e.printStackTrace();
            return null;
        }
    }
}
