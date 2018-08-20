package nba.bs;

import java.util.List;

import static nba.bs.changL.*;

public class Ball_Thread extends Thread
{
	List<yundongBall> albfc;
	
	public Ball_Thread(List<yundongBall> albfc)
	{	
		this.albfc=albfc;
	}
	
	public void run(){
		while(BALL_GO_FLAG)
		{
			for(yundongBall lb:albfc)
			{//循环控制每一个球
				lb.move();
			}
			
			try{
				sleep(50);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
}