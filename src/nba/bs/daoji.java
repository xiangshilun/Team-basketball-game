package nba.bs;

import javax.microedition.khronos.opengles.GL10;

import static nba.bs.changL.*;

public class daoji
{
	shiwan mv;
	Panel[] numbers=new Panel[10];
	
	public daoji(int texId,shiwan mv)
	{
		this.mv=mv;
		
		//����0-9ʮ�����ֵ��������
		for(int i=0;i<10;i++)
		{
			numbers[i]=new Panel
            (
            	SCORE_NUMBER_SPAN_X,
            	SCORE_NUMBER_SPAN_Y,
            	 texId,
            	 new float[]
		             {
		           	  0.1f*i,0, 0.1f*i,1, 0.1f*(i+1),0,
		           	  0.1f*(i+1),0, 0.1f*i,1,  0.1f*(i+1),1
		             }
             ); 
		}
	}
	
	public void drawSelf(GL10 gl)
	{		
		String scoreStr=deadtimes+"";
		for(int i=0;i<scoreStr.length();i++)
		{//���÷��е�ÿ�������ַ�����
			char c=scoreStr.charAt(i);
			gl.glPushMatrix();
			gl.glTranslatef(i*SCORE_NUMBER_SPAN_X, 0, 0);
			numbers[c-'0'].drawSelf(gl);
			gl.glPopMatrix();
		}
	}
}