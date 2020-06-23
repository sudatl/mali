package org.wn.mario;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class StaticValue {
	//马里奥图片
	public static List<BufferedImage> allMarioImage = new ArrayList<BufferedImage>();
	
	public static BufferedImage startImage = null;
	
	public static BufferedImage endImage = null;
	
	public static BufferedImage bgImage = null;
	//食人花的图片
	public static List<BufferedImage> allFlowerImage = new ArrayList<BufferedImage>();
	//蘑菇头的图片
	public static List<BufferedImage> allTriangleImage = new ArrayList<BufferedImage>();
	//乌龟的图片
	public static List<BufferedImage> allTurtleImage = new ArrayList<BufferedImage>();
	//障碍物的图片
	public static List<BufferedImage> allObstructionImage = new ArrayList<BufferedImage>();
	
	public static BufferedImage mariDeadImage = null;
	//返回当前路径
	public static String ImagePath = System.getProperty("user.dir")+"/bin/";
	
	//将图片初始化
	public static void init(){
		//玛丽奥图片初始化 
		for(int i=1;i<=10;i++){
			try {
				allMarioImage.add(ImageIO.read(new File(ImagePath+i+".png")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//导入背景图片
		try {
			startImage = ImageIO.read(new File(ImagePath+"start.jpg"));
			bgImage = ImageIO.read(new File(ImagePath+"firststage.jpg"));
			endImage = ImageIO.read(new File(ImagePath+"firststageend.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//导入敌人图片
		for(int i=1;i<=5;i++){
			try {
				if(i<=2){
					allFlowerImage.add(ImageIO.read(new File(ImagePath+"flower"+i+".png")));
				}
				if(i<=3){
					allTriangleImage.add(ImageIO.read(new File(ImagePath+"triangle"+i+".png")));
				}
				allTurtleImage.add(ImageIO.read(new File(ImagePath+"Turtle"+i+".png")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//导入障碍物图片
		for(int i=1;i<=12;i++){
			try {
				allObstructionImage.add(ImageIO.read(new File(ImagePath+"ob"+i+".png")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//导入玛丽奥死亡图片
		try {
			mariDeadImage = ImageIO.read(new File(ImagePath+"over.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
