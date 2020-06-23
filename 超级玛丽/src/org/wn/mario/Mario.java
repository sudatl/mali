package org.wn.mario;

import java.awt.image.BufferedImage;
import java.io.Externalizable;

import javax.swing.JOptionPane;

public class Mario implements Runnable{
	//����
	private int x;
	private int y;
	//�������������ڳ���
	private BackGround bg;
	//�����߳�
	private Thread t = null;
	//�ƶ��ٶ�e
	private int xmove = 0;
	//��Ծ�ٶ�
	private int ymove = 0;
	//״̬
	private String status;
	//��ʾͼƬ
	private BufferedImage showImage;
	//�����ͷ���
	private int score;
	private int life;
	
	//��ǰ�ƶ��е�ͼƬ
	private int moving = 0;
	
	//��Ծʱ��
	private int upTime = 0;
	
	//����������Ƿ�����
	private boolean isDead = false;
	
	//�����Ϸ����Ϸ����
	private boolean isClear = false;
	
	//���췽��
	public Mario(int x,int y){
		this.x = x;
		this.y = y;
		//��ʼ��������ͼƬ
		this.showImage = StaticValue.allMarioImage.get(0);
		this.score = 0;
		this.life = 4;
		
		this.t = new Thread(this);
		t.start();
		
		this.status = "right-standing";
	}
	
	
	public void leftMove(){
		//�ƶ��ٶ�
		xmove = -5;
		//�ı�״̬
		//�����ǰ�Ѿ�����Ծ��Ӧ�ñ���ԭ��״̬�������ٸı�
		if(this.status.indexOf("jumping") != -1){
			this.status = "left-jumping";
		}else{
			this.status = "left-moving";
		}
	}
	
	public void rightMove(){
		xmove = 5;
		if(this.status.indexOf("jumping") != -1){
			this.status = "right-jumping";
		}else{
			this.status = "right-moving";
		}
	}
	
	public void leftStop(){
		this.xmove = 0;
		if(this.status.indexOf("jumping") != -1){
			this.status = "left-jumping";
		}else{
			this.status = "left-standing";
		}
	}
	
	public void rightStop(){
		this.xmove = 0;
		if(this.status.indexOf("jumping") != -1){
			this.status = "right-jumping";
		}else{
			this.status = "right-standing";
		}
	}
	
	public void jump(){
		if(this.status.indexOf("jumping") == -1){
			if(this.status.indexOf("left") != -1){
				this.status = "left-jumping";
			}else{
				this.status = "right-jumping";
			}
			ymove = -10;
			upTime = 18;
		}
	}
	
	//���䷽��
	public void down(){
		if(this.status.indexOf("left") != -1){
			this.status = "left-jumping";
		}else{
			this.status = "right-jumping";
		}
		ymove = 10;
	}
	//��������
	public void dead(){
		this.life--;
		if(this.life == 0){
			this.isDead = true;
		}else{
			this.bg.reset();
			this.x = 0;
			this.y = 480;
		}
	}
	
	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}

	public BufferedImage getShowImage() {
		return showImage;
	}


	public void run() {
		while(true){
			//�ж��Ƿ����ϰ�����ײ
			//������
			if(this.bg.isFlag() && this.x >= 520){
				this.bg.setOver(true);
				if(this.bg.isDown()){
					//����������¿�ʼ��
					this.status = "right-moving";
					if(this.x < 580){
						//����
						this.x += 5;
					}else{
						if(this.y < 480){
							//����
							this.y += 5;
						}
						this.x += 5;
						if(this.x >= 780){
							//��Ϸ����
							this.setClear(true);
						}
					}
				}else{
					//���Ϊ���һ��������ͬ��Mario��x���굽��550����Ϸ����
					//�Զ�����������
					if(this.y < 420){
						this.y += 5;
					}
					if(this.y >= 420){
						this.y = 420;
						this.status = "right-standing";
					}
				}
			}else{
				boolean canLeft = true;
				boolean canRight = true;
				//�ܷ���Ծ���
				boolean onLand = false;
					for(int i=0;i<this.bg.getAllObstruction().size();i++){
					Obstruction ob = this.bg.getAllObstruction().get(i);
					//���������ƶ�
					if(ob.getX()==this.x+60 && (ob.getY()+50>this.y && ob.getY()-50<this.y)){
						if(ob.getType() != 3){
							canRight = false;
						}
					}
					//���������ƶ�
					if(ob.getX()==this.x-60 && (ob.getY()+50>this.y && ob.getY()-50<this.y)){
						if(ob.getType() != 3){
							canLeft = false;
						}
					}
					//�ж��ܷ���Ծ
					if(ob.getY()==this.y+60 && (ob.getX()+60>this.x && ob.getX()-60<this.x)){
						if(ob.getType() != 3){
								onLand = true;
							}
						}
						//�ж���������Ծʱ�Ƿ�ײ���ϰ���
						if(ob.getY()==this.y-60 && (ob.getX()+50>this.x && ob.getX()-50<this.x)){
							//�����ש��
							if(ob.getType()==0){
								//�Ƴ�ש��
								this.bg.getAllObstruction().remove(ob);
								//���浽�Ƴ����ϰ�����
								this.bg.getRemoveObstruction().add(ob);
							}
							//������ʺ�||���ص�ש��
							if((ob.getType()==4 || ob.getType()==3) && upTime > 0){
								//���ӷ���
								score += 10;
								ob.setType(2);
								ob.setImage();
							}
							upTime = 0;
						}
					}
				
				//�Ե��˵��ж�
				for(int i=0;i<this.bg.getAllEnemy().size();i++){
					Enemy e = this.bg.getAllEnemy().get(i);
					if((e.getX()+50>this.x && e.getX()-50<this.x) && (e.getY()+60>this.y && e.getY()-60<this.y)){
						//����������
						this.dead();
					}
					if(e.getY()==this.y+60 && (e.getX()+60>this.x && e.getX()-60<this.x)){
						if(e.getType() == 1){
							e.dead();
							this.upTime = 5;
							this.ymove = -10;
							//�������������ӷ���
							score += 10;
						}else if(e.getType() == 2){
							this.dead();
						}
					}
				}
				
				
				
				if(onLand && upTime == 0){
					if(this.status.indexOf("left") != -1){
						if(xmove != 0){
							this.status = "left-moving";
						}else{
							this.status = "left-standing";
						}
					}else{
						if(xmove != 0){
							this.status = "right-moving";
						}else{
							this.status = "right-standing";
						}
					}
				}else{
					//����״̬
					if(upTime != 0){
						upTime--;
					}else{
						this.down();
					}
					y += ymove;
				}
				
				if(this.y>600){
					this.dead();
				}
				
				
				if(canLeft && xmove<0 || canRight && xmove>0){
					x += xmove;
					if(x<0){
						x = 0;
					}
				}
			}
			
			//Ĭ������
			int temp = 0;
			//����״̬
			if(this.status.indexOf("left") != -1){
				temp += 5;
			} 
			
			//�ж��Ƿ��ƶ�
			if(this.status.indexOf("moving") != -1){
				temp += this.moving;
				moving++;
				if(moving==4){
					this.moving = 0;
				}
			}
			
			if(this.status.indexOf("jumping") != -1){
				temp += 4;
			}
			
			//�ı���ʾͼƬ
			this.showImage = StaticValue.allMarioImage.get(temp);
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void setBg(BackGround bg) {
		this.bg = bg;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isDead() {
		return isDead;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public int getLife() {
		return life;
	}


	public void setLife(int life) {
		this.life = life;
	}

	public boolean isClear() {
		return isClear;
	}

	public void setClear(boolean isClear) {
		this.isClear = isClear;
	}
	
}
