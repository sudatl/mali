package org.wn.mario;

import java.awt.image.BufferedImage;

public class Obstruction implements Runnable{
	//坐标
	private int x;
	private int y;
	
	//控制旗子
	private Thread t = new Thread(this);
	
	//类型
	private int type;
	//初始类型
	private int starttype;
	//显示图片
	private BufferedImage showImage = null;
	
	//取得场景
	private BackGround bg;
	
	//构造方法
	public Obstruction(int x,int y,int type,BackGround bg){
		this.x = x;
		this.y = y;
		this.type = type;
		this.starttype = type;
		this.bg = bg;
		setImage();
		if(this.type == 11){
			t.start();
		}
	}
	//重置方法
	public void reset(){
		//修改类型为原来类型
		this.type = starttype;
		//改变图片
		this.setImage();
	}
	
	//根据状态改变显示图片
	public void setImage(){
		showImage = StaticValue.allObstructionImage.get(type);
	}
	
	public BufferedImage getShowImage() {
		return showImage;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			if(this.bg.isOver()){
				if(this.y < 420){
					this.y += 5;
				}else{
					this.bg.setDown(true);
				}
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
