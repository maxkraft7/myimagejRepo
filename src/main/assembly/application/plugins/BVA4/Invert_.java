import ij.*;
import ij.plugin.filter.PlugInFilter;
import ij.process.*;

public class Invert_ implements PlugInFilter {  
 
	public int setup(String arg, ImagePlus imp) {
		if (arg.equals("about"))
			{showAbout(); return DONE;}
		return DOES_8G+DOES_STACKS+SUPPORTS_MASKING;
	} //setup
	
	public void run(ImageProcessor ip) {
		byte[] pixels = (byte[])ip.getPixels();
		int width = ip.getWidth();
		int height = ip.getHeight();
		          
        int[][] inDataArrInt = ImageJUtility.convertFrom1DByteArr(pixels, width, height);
        int[] invertTF = ImageTransformationFilter.getInversionTF(255);
        int[][] invertedImg = ImageTransformationFilter.getTransformedImage(inDataArrInt, width, height, invertTF);        
        
        ImageJUtility.showNewImage(invertedImg, width, height, "inverted image");
        
	}
	
}

