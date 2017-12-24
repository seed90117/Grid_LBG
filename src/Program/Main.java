package Program;

import IO.DrawImage;
import IO.LoadFile;
import Value.data;
import Value.value;

public class Main {

	static double gridheight;
	static double gridwidth;
	static int[][] gridamount;
	static data[][] image;
	
	public static void main()
	{
		gridamount = new int[value.cb][value.cb];
		double[][] r = new double[value.cb][value.cb];
		double[][] g = new double[value.cb][value.cb];
		double[][] b = new double[value.cb][value.cb];
		image = new data[value.cb][value.cb];
		
		//*****計算每個網格的長寬*****//
		gridsize();
		
		for(int h=0;h<LoadFile.image.getHeight();h++)
		{
			for(int w=0;w<LoadFile.image.getWidth();w++)
			{
				int x =(int)(w/gridwidth);
				int y =(int)(h/gridwidth);
				gridamount[x][y] += 1;
				r[x][y] += rgbdistance("r", w, h);
				g[x][y] += rgbdistance("g", w, h);
				b[x][y] += rgbdistance("b", w, h);
			}
		}
		
		for(int x=0;x<value.cb;x++)
		{
			for(int y=0;y<value.cb;y++)
			{
				image[x][y] = new data();
				image[x][y].r = r[x][y]/gridamount[x][y];
				image[x][y].g = g[x][y]/gridamount[x][y];
				image[x][y].b = b[x][y]/gridamount[x][y];
			}
		}
		
		for(int h=0;h<LoadFile.image.getHeight();h++)
		{
			for(int w=0;w<LoadFile.image.getWidth();w++)
			{
				int x =(int)(w/gridwidth);
				int y =(int)(h/gridheight);
				DrawImage.drawcolor(w, h, (int)image[x][y].r, (int)image[x][y].g, (int)image[x][y].b);
			}
		}
		
	}
	
	//*****計算RBG*****//
	public static double rgbdistance(String type, int x, int y)
	{
		int rgb=0;
		if(type == "r")
		{
			rgb = (LoadFile.image.getRGB(x, y)& 0xFF0000) >> 16;
		}
		
		if(type == "g")
		{
			rgb = (LoadFile.image.getRGB(x, y)& 0xFF00) >> 8;
		}
		
		if(type == "b")
		{
			rgb = (LoadFile.image.getRGB(x, y)& 0xFF);
		}
		return rgb;
	}
	
	public static void gridsize()
	{
		gridwidth = LoadFile.image.getWidth()/value.cb;
		gridheight = LoadFile.image.getHeight()/value.cb;
	}
}
