package nba.bs;

import static nba.bs.changL.*;

public class daojiThread extends Thread
{
	LanqiuActivity activity;
	
	public daojiThread(LanqiuActivity activity)
	{
		this.activity=activity;
	}
	
	public void run()
	{
		while(DEADTIME_FLAG)
		{
			if(deadtimes>0)
			{
				try {
					deadtimes-=1;
					if(deadtimes==0&&SOUND_FLAG==true)
					{
						activity.playSound(2, 0);
					}
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
			if(deadtimes==0)
			{
				SOUND_FLAG=false;//�ر�����
				DEADTIME_FLAG=false;//�رյ���ʱ�߳�
				activity.hd.sendEmptyMessage(GAME_OVER);
			}
		}				
	}
}