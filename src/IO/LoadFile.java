package IO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

import InterFace.View;

public class LoadFile {

public static BufferedImage image;
	
	public static void loadfile()
	{
		String tmp;
		
		//*****�w�]�ɮ׶}�Ҧ�m*****//
		View.open.setCurrentDirectory(new java.io.File("D:\\Algorithm_Data\\Grouping Data"));
		
		//*****�ɮ׶}�ҵ���*****//
		View.open.setDialogTitle("����ɮ�"); //�]�wDialog Title�W��
		
		//*****�P�_�O�_���U�T�w*****//
		if(View.open.showDialog(View.outputimage, "�T�w") == JFileChooser.APPROVE_OPTION)
		{
			//*****���o����ɮ�*****//
			tmp = View.open.getSelectedFile().getPath();
			
			//*****�Ȧs�ɮ�*****//
			File file = new File(tmp);
			
			//*****�ɮ�Ū��*****//
			try
			{
				image = ImageIO.read(file);
			}
			catch (FileNotFoundException ex)
			{
				Logger.getLogger(LoadFile.class.getName()).log(Level.SEVERE, null , ex);
			}
			catch(IOException ex)
			{
				Logger.getLogger(LoadFile.class.getName()).log(Level.SEVERE, null , ex);
			}
			
			DrawImage.loadimage();
			View.check = true;
		}
				
	}
}
