package org.easypr.test;		
		
import org.easypr.core.CharsRecognise;		
import org.easypr.core.PlateDetect;		
		
import java.util.Vector;		
		
import static org.bytedeco.javacpp.opencv_core.*;		
import static org.bytedeco.javacpp.opencv_highgui.*;		
		
/*		
 * Created by fanwenjie		
 * @version 1.1		
 */		
		
public class Test {		
		
    public static void plateDetect(){		
        String imgPath = "res/image/baidu_image/test2.jpg";		
        System.out.println("Plate Detect Test");		
        Mat src = imread(imgPath);		
        PlateDetect plateDetect = new PlateDetect();		
        plateDetect.setPDLifemode(true);		
        Vector<Mat> matVector = new Vector<Mat>();		
        plateDetect.plateDetect(src, matVector);		
        if(0==plateDetect.plateDetect(src,matVector)){		
            long num = matVector.size();		
            for(int i=0;i<num;++i){		
                try {		
                    imshow("Plate Detect", matVector.get(i));		
                    System.in.read();		
                }catch (Exception ignore){}		
            }		
        }		
    }		
		
    public static String charsRecognise(){		
        String imgPath = "res/image/test_image/chars_recognise_huAGH092.jpg";		
        System.out.println("test_chars_recognise");		
        Mat src = imread(imgPath);		
        CharsRecognise cr = new CharsRecognise();		
        String result = cr.charsRecognise(src);		
        System.out.println("charsRecognise: "+result);		
		        return result;		
   }		
		
}