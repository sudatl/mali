package org.wn.mario;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class BackGround {
	//��ǰ����ͼƬ
	private BufferedImage bgImage = null;
	//����˳��
	private int sort;
	//�Ƿ�Ϊ���ĳ���
	private boolean flag;
	
	//��Ϸ�������
	private boolean isOver = false;
	//���彵�����
	private boolean isDown = false;
	
	//�ü��ϱ������
	private List<Enemy> allEnemy = new ArrayList<Enemy>();
	//�ü��ϱ����ϰ���
	private List<Obstruction> allObstruction = new ArrayList<Obstruction>();
	//������ĵ���
	private List<Enemy> removeEnemy = new ArrayList<Enemy>();
	//��������ϰ���
	private List<Obstruction> removeObstruction = new ArrayList<Obstruction>();
	
	//���˿�ʼ�ƶ�
	public void enemyStartMove(){
		for(int i=0;i<this.allEnemy.size();i++){
			this.allEnemy.get(i).startMove();
		}
	}
	
	
	//���췽��
	public BackGround(int sort,boolean flag){
		this.sort = sort;
		this.flag = flag;
		if(flag){
			bgImage = StaticValue.endImage;
		}else{
			bgImage = StaticValue.bgImage;
		}
		//��һ������
		if(sort==1){
			for(int i=0;i<15;i++){
				this.allObstruction.add(new Obstruction(i*60, 540, 9,this));
			}
			
			//����ש����ʺ�
			this.allObstruction.add(new Obstruction(120, 360, 4,this));
			this.allObstruction.add(new Obstruction(300, 360, 0,this));
			this.allObstruction.add(new Obstruction(360, 360, 4,this));
			this.allObstruction.add(new Obstruction(420, 360, 0,this));
			this.allObstruction.add(new Obstruction(480, 360, 4,this));
			this.allObstruction.add(new Obstruction(540, 360, 0,this));
			this.allObstruction.add(new Obstruction(420, 180, 4,this));
			
			//����ˮ��
			this.allObstruction.add(new Obstruction(660, 540, 6,this));
			this.allObstruction.add(new Obstruction(720, 540, 5,this));
			this.allObstruction.add(new Obstruction(660, 480, 8,this));
			this.allObstruction.add(new Obstruction(720, 480, 7,this));
			//����ש��
			this.allObstruction.add(new Obstruction(660, 300, 3, this));
			
			
			
			//���ƹ���
			this.allEnemy.add(new Enemy(600, 480, true, 1,this));
			this.allEnemy.add(new Enemy(690, 540, true, 2, 420, 540,this));
			
			
		}
		//�ڶ�������
		if(sort==2){
			for(int i=0;i<15;i++){
				if(i != 9 && i != 10 && i != 11 ){
					this.allObstruction.add(new Obstruction(i*60, 540, 9,this));
				}
			}
			//����ˮ��
			this.allObstruction.add(new Obstruction(60, 540, 6,this));
			this.allObstruction.add(new Obstruction(120, 540, 5,this));
			this.allObstruction.add(new Obstruction(60, 480, 6,this));
			this.allObstruction.add(new Obstruction(120, 480, 5,this));
			this.allObstruction.add(new Obstruction(60, 420, 8,this));
			this.allObstruction.add(new Obstruction(120, 420, 7,this));
			
			this.allObstruction.add(new Obstruction(300, 540, 6,this));
			this.allObstruction.add(new Obstruction(360, 540, 5,this));
			this.allObstruction.add(new Obstruction(300, 480, 6,this));
			this.allObstruction.add(new Obstruction(360, 480, 5,this));
			this.allObstruction.add(new Obstruction(300, 420, 6,this));
			this.allObstruction.add(new Obstruction(360, 420, 5,this));
			this.allObstruction.add(new Obstruction(300, 360, 8,this));
			this.allObstruction.add(new Obstruction(360, 360, 7,this));
			
			//���ƹ���
			this.allEnemy.add(new Enemy(330, 360, true, 2, 300, 420,this));
			
		}
		//����������
		if(sort==3){
			for(int i=0;i<15;i++){
				this.allObstruction.add(new Obstruction(i*60, 540, 9,this));
			}
			
			//����ש����ʺ�
			this.allObstruction.add(new Obstruction(180, 360, 4,this));
			this.allObstruction.add(new Obstruction(420, 360, 4,this));
			this.allObstruction.add(new Obstruction(660, 360, 4,this));
			this.allObstruction.add(new Obstruction(420, 180, 4,this));
		}
		//���ĸ�����
		if(sort==4){
			for(int i=0;i<15;i++){
				if(i<2||i>12){
					this.allObstruction.add(new Obstruction(i*60, 540, 9,this));
				}
			}
			this.allObstruction.add(new Obstruction(120, 360, 0,this));
			this.allObstruction.add(new Obstruction(180, 360, 0,this));
			this.allObstruction.add(new Obstruction(300, 180, 0,this));
			this.allObstruction.add(new Obstruction(360, 180, 0,this));
			this.allObstruction.add(new Obstruction(420, 180, 0,this));
			this.allObstruction.add(new Obstruction(480, 180, 0,this));
			this.allObstruction.add(new Obstruction(540, 180, 0,this));
			this.allObstruction.add(new Obstruction(660, 360, 0,this));
			this.allObstruction.add(new Obstruction(720, 360, 0,this));
		}
		//���������
		if(sort==5){
			int z = 2;
			for(int i=0;i<15;i++){
				if(i%2==0 && i<7){
					this.allObstruction.add(new Obstruction(i*60, 540-(i*60), 9,this));
					for(int x=i;x>0;x--){
						this.allObstruction.add(new Obstruction(i*60, 540-(x*60)+60, 10,this));
					}
				}
				if(i%2==0 && i>7){
					this.allObstruction.add(new Obstruction(i*60, 540-((i-z)*60), 9,this));
					for(int x=i-z;x>0;x--){
						this.allObstruction.add(new Obstruction(i*60, 540-(x*60)+60, 10,this));
					}
					z+=4;
				}
			}
		}
		//����������
		if(sort==6){
			for(int i=0;i<15;i++){
				this.allObstruction.add(new Obstruction(i*60, 540, 9,this));
			}
			this.allObstruction.add(new Obstruction(480, 480, 1,this));
			this.allObstruction.add(new Obstruction(480, 420, 1,this));
			this.allObstruction.add(new Obstruction(480, 360, 1,this));
			this.allObstruction.add(new Obstruction(480, 300, 1,this));
			this.allObstruction.add(new Obstruction(480, 240, 1,this));
			this.allObstruction.add(new Obstruction(480, 180, 1,this));
			this.allObstruction.add(new Obstruction(540, 240, 1,this));
			this.allObstruction.add(new Obstruction(540, 300, 1,this));
			this.allObstruction.add(new Obstruction(540, 360, 1,this));
			this.allObstruction.add(new Obstruction(540, 420, 1,this));
			this.allObstruction.add(new Obstruction(540, 480, 1,this));
			this.allObstruction.add(new Obstruction(600, 300, 1,this));
			this.allObstruction.add(new Obstruction(600, 360, 1,this));
			this.allObstruction.add(new Obstruction(600, 420, 1,this));
			this.allObstruction.add(new Obstruction(600, 480, 1,this));
			this.allObstruction.add(new Obstruction(660, 360, 1,this));
			this.allObstruction.add(new Obstruction(660, 420, 1,this));
			this.allObstruction.add(new Obstruction(660, 480, 1,this));
			this.allObstruction.add(new Obstruction(720, 420, 1,this));
			this.allObstruction.add(new Obstruction(720, 480, 1,this));
			this.allObstruction.add(new Obstruction(780, 480, 1,this));
			
			//ͨ��Ҫ�㣬����ש��
			this.allObstruction.add(new Obstruction(300, 360, 3,this));

		}
		//���߸�����
		if(sort==7){
			for(int i=0;i<15;i++){
				this.allObstruction.add(new Obstruction(i*60, 540, 9,this));
			}
			this.allObstruction.add(new Obstruction(490, 180, 11,this));
			this.allObstruction.add(new Obstruction(520, 480, 2,this));
			//�����ϰ���
			this.allObstruction.add(new Obstruction(240, 360, 1,this));
			this.allObstruction.add(new Obstruction(240, 420, 1,this));
			this.allObstruction.add(new Obstruction(240, 480, 1,this));
			this.allObstruction.add(new Obstruction(180, 420, 1,this));
			this.allObstruction.add(new Obstruction(180, 480, 1,this));
			this.allObstruction.add(new Obstruction(120, 480, 1,this));
		}
	}
	
	//���÷���,�����ϰ���͵���
	public void reset(){
		//���Ƴ����ϰ���͵��˻�ԭ
		this.allEnemy.addAll(this.removeEnemy);
		this.allObstruction.addAll(this.removeObstruction);
		//�����ϰ���͵��˵����÷���
		for(int i=0;i<this.allEnemy.size();i++){
			this.allEnemy.get(i).reset();
		}
		for(int i=0;i<this.allObstruction.size();i++){
			this.allObstruction.get(i).reset();
		}
	}

	public BufferedImage getBgImage() {
		return bgImage;
	}

	public List<Obstruction> getAllObstruction() {
		return allObstruction;
	}

	public List<Obstruction> getRemoveObstruction() {
		return removeObstruction;
	}

	public int getSort() {
		return sort;
	}

	public List<Enemy> getAllEnemy() {
		return allEnemy;
	}

	public List<Enemy> getRemoveEnemy() {
		return removeEnemy;
	}

	public boolean isFlag() {
		return flag;
	}

	public boolean isOver() {
		return isOver;
	}

	public void setOver(boolean isOver) {
		this.isOver = isOver;
	}

	public boolean isDown() {
		return isDown;
	}

	public void setDown(boolean isDown) {
		this.isDown = isDown;
	}
	
}
