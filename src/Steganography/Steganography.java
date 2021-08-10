package Steganography;

import java.io.File;
import java.awt.Point;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.awt.image.DataBufferByte;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
public class Steganography
{

public Steganography()
{
}
        
		       public boolean encode(String path, String original, String stegan, String message)
		       {
		    	   String file_name       =path+"\\"+original;
		    	   System.out.println(file_name);
		    	   BufferedImage   image_orig      = getImage(file_name);
		    	   BufferedImage image = user_space(image_orig);
		    	   image = add_text(image,message);
		    	   return(setImage(image,new File(path+"\\"+stegan+".png"),"png"));
		       }
		       
		       
		   
       
        private BufferedImage getImage(String f)
        {
                BufferedImage   image   = null;
File            file    = new File(f);
                
                try
                {
                        image = ImageIO.read(file);
                }
                catch(Exception ex)
                {
                		ex.printStackTrace();
                }
                return image;
        }
         private boolean setImage(BufferedImage image, File file, String ext)
        {
                try
                {
                        ImageIO.write(image,ext,file);
                        return true;
                }
                catch(Exception e)
                {
                        e.printStackTrace();
                        return false;
                }
        }
private BufferedImage add_text(BufferedImage image, String text)
        {
                
                byte img[]  = get_byte_data(image);
                byte msg[] = text.getBytes();
                byte len[]   = bit_conversion(msg.length);
                try
                {
                        encode_text(img, len,  0); 
                        encode_text(img, msg, 32); 
                }
                
catch(Exception e)
                {
                        e.printStackTrace();
                }
                return image;
        }
         private BufferedImage user_space(BufferedImage image)
        {
                
                BufferedImage new_img  = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
                Graphics2D      graphics = new_img.createGraphics();
                graphics.drawRenderedImage(image, null);//applying a transform from image space into user space before drawing.
                graphics.dispose(); 
                return new_img;
        }
        private byte[] get_byte_data(BufferedImage image)
        {
                WritableRaster raster   = image.getRaster();
                DataBufferByte buffer = (DataBufferByte)raster.getDataBuffer();
                return buffer.getData();
        }
        private byte[] bit_conversion(int i)
        {
                byte byte3 = (byte)((i & 0xFF000000) >>> 24); //0
                byte byte2 = (byte)((i & 0x00FF0000) >>> 16); //0
                byte byte1 = (byte)((i & 0x0000FF00) >>> 8 ); //0
                byte byte0 = (byte)((i & 0x000000FF)       );

                return(new byte[]{byte3,byte2,byte1,byte0});
        }
        private byte[] encode_text(byte[] image, byte[] addition, int offset)
        {
                if(addition.length + offset > image.length)
                {
                        throw new IllegalArgumentException("File not long enough!");
                }
                for(int i=0; i<addition.length; ++i)
                {
                        int add = addition[i];
for(int bit=7; bit>=0; --bit, ++offset) 
                        {
                             int b = (add >>> bit) & 1;
                             image[offset] = (byte)((image[offset] & 0xFE) | b );
                        }
                }
                return image;
        }
        private byte[] decode_text(byte[] image)
        {
                int length = 0;
                int offset  = 32;
                for(int i=0; i<32; ++i) 
                {
                        length = (length << 1) | (image[i] & 1);
                }
                byte[] result = new byte[length];
                for(int b=0; b<result.length; ++b )
                {
                        for(int i=0; i<8; ++i, ++offset)
                        {
                                result[b] = (byte)((result[b] << 1) | (image[offset] & 1));
                        }
                }
                return result;
        }
        
        public String decode(String path)
	       {
         byte[] decode;
         try
         {
                 BufferedImage image  = user_space(getImage(path));
                 decode = decode_text(get_byte_data(image));
                 return(new String(decode));
         }
         catch(Exception e)
         {
                 
JOptionPane.showMessageDialog(null, 
                 "There is no hidden message in this image!","Error",
                 JOptionPane.ERROR_MESSAGE);
e.printStackTrace();
                 return "";
         }
 }
}

