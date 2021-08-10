package Steganography;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageFilter;
import java.io.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import Database.conn;

public class SplitImage {
	
	public static void main(String[] ar) throws IOException
	{
		SplitImage sp=new SplitImage();
		//sp.getSplit("D:\\UImage", "test.jpg",2);
	//	byte[] b= sp.combineImages("D:\\UImage\\test.jpg");
	//	System.out.println(b);
	}
	
public String getSplit(String path,String filename,int col,String hash,String message) throws IOException 
{
File file = new File(path+"\\"+filename); 
FileInputStream fis = new FileInputStream(file);
BufferedImage image = ImageIO.read(fis); 
int rows = 1; 
int cols = col;
int chunks = rows * cols;
int chunkWidth = image.getWidth() / cols; 
int chunkHeight = image.getHeight() / rows;
int count = 0;
BufferedImage imgs[] = new BufferedImage[chunks];
for (int x = 0; x < rows; x++) {
for (int y = 0; y < cols; y++) {
imgs[count] = new BufferedImage(chunkWidth, chunkHeight, image.getType());
Graphics2D gr = imgs[count++].createGraphics();
gr.drawImage(image, 0, 0, chunkWidth, chunkHeight, chunkWidth * y, chunkHeight * x, chunkWidth * y + chunkWidth, chunkHeight * x + chunkHeight, null);
gr.dispose();
} }
filename = filename.substring(0,(filename.length()-4));
conn con=new conn();
for (int i = 0; i < imgs.length; i++) 
{

	ImageIO.write(imgs[i], "jpg", new File(path+"\\"+filename + i + ".jpg"));
	addmessageinpatch(imgs,message);
	con.splitIm(hash, path+"\\"+filename+i+".jpg",i);
}
 return "SPLITTED";
}

public void addmessageinpatch(BufferedImage[] imgs, String message){
	BufferedImage image;
	for (int i = 0; i < imgs.length; i++) 
	{ try{
		image=(BufferedImage) message.subSequence(0, i);
		break;
	}
	catch(Exception e){
		e.printStackTrace();
	}
	}
}

public byte[] combineImages(String path,String fpath ,int col)
{
	try{
	int rows = 1;   //we assume the no. of rows and cols are known and each chunk has equal width and height
        int cols = col;
        int chunks = rows * cols;

        int chunkWidth, chunkHeight;
        int type;
        File[] imgFiles = new File[chunks];
        
for (int i = 0; i < chunks; i++) {
			//if(i==0){
            imgFiles[i] = new File(path+i+".jpg");
          /*  System.out.println(imgFiles);		
			System.out.println("Value of i..."+i);
			}
			if(i==1){
            imgFiles[i] = new File("D:\\UImage\\test1.jpg");
			System.out.println(imgFiles);
			System.out.println("Value of i..."+i);
			}*/
        }
        BufferedImage[] buffImages = new BufferedImage[chunks];
        for (int i = 0; i < chunks; i++) {
            buffImages[i] = ImageIO.read(imgFiles[i]);
        }
        type = buffImages[0].getType();
        chunkWidth = buffImages[0].getWidth();
        chunkHeight = buffImages[0].getHeight();

        //Initializing the final image
        BufferedImage finalImg = new BufferedImage(chunkWidth*cols, chunkHeight*rows, type);
        int num = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                finalImg.createGraphics().drawImage(buffImages[num], chunkWidth * j, chunkHeight * i, null);
                num++;
            }
        }

System.out.println("Image concatenated.....");
        ImageIO.write(finalImg, "png", new File(path));
		FileInputStream fin = new FileInputStream(path);
		byte b[] = new byte[fin.available()];
		fin.read(b);
		fin.close();
		return b;
	}

catch(Exception ex)
{
ex.printStackTrace();
System.out.println(ex);
	}
return null;
}

}
