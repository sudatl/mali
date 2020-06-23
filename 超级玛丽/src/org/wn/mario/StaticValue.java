package org.wn.mario;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class StaticValue {
	//�����ͼƬ
	public static List<BufferedImage> allMarioImage = new ArrayList<BufferedImage>();
	
	public static BufferedImage startImage = null;
	
	public static BufferedImage endImage = null;
	
	public static BufferedImage bgImage = null;
	//ʳ�˻���ͼƬ
	public static List<BufferedImage> allFlowerImage = new ArrayList<BufferedImage>();
	//Ģ��ͷ��ͼƬ
	public static List<BufferedImage> allTriangleImage = new ArrayList<BufferedImage>();
	//�ڹ��ͼƬ
	public static List<BufferedImage> allTurtleImage = new ArrayList<BufferedImage>();
	//�ϰ����ͼƬ
	public static List<BufferedImage> allObstructionImage = new ArrayList<BufferedImage>();
	
	public static BufferedImage mariDeadImage = null;
	//���ص�ǰ·��
	public static String ImagePath = System.getProperty("user.dir")+"/bin/";
	
	//��ͼƬ��ʼ��
	public static void init(){
		//������ͼƬ��ʼ�� 
		for(int i=1;i<=10;i++){
			try {
				allMarioImage.add(ImageIO.read(new File(ImagePath+i+".png")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//���뱳��ͼƬ
		try {
			startImage = ImageIO.read(new File(ImagePath+"start.jpg"));
			bgImage = ImageIO.read(new File(ImagePath+"firststage.jpg"));
			endImage = ImageIO.read(new File(ImagePath+"firststageend.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�������ͼƬ
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
		//�����ϰ���ͼƬ
		for(int i=1;i<=12;i++){
			try {
				allObstructionImage.add(ImageIO.read(new File(ImagePath+"ob"+i+".png")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//��������������ͼƬ
		try {
			mariDeadImage = ImageIO.read(new File(ImagePath+"over.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
