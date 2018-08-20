package nba.bs;

import nba.bs.R;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import static nba.bs.changL.*;

public class zhuView extends SurfaceView implements SurfaceHolder.Callback
{
	LanqiuActivity activity;
	
	Paint paint;	
	Bitmap begin;
	Bitmap backgroud;
	Bitmap shut;
	Bitmap about1;
	Bitmap help;
	
	float left1=LEFT;
	float left2=LEFT;
	float left3=LEFT;
	float left4=LEFT;
	
	public zhuView(LanqiuActivity activity) {
		super(activity);
		this.activity=activity;
		this.getHolder().addCallback(this);//�����������ڻص��ӿڵ�ʵ����	
		
		//����
		paint = new Paint();
		paint.setAntiAlias(true);//�򿪿����
		
		initBitmap();//��ʼ��λͼ
	}
	
	public void onDraw(Canvas canvas)
	{
		if(canvas==null) return;
		super.onDraw(canvas);		
		canvas.drawBitmap(backgroud, 0, 0, paint);
		canvas.drawBitmap(begin, left1, 300, paint);
		canvas.drawBitmap(help, left2, 340, paint);
		canvas.drawBitmap(about1, left3, 380, paint);
		canvas.drawBitmap(shut, left4, 420, paint);
	}

	
	@Override
	public boolean onTouchEvent(MotionEvent e)
	{  
		float x=e.getX();
		float y=e.getY();
		
		switch(e.getAction())
		{
		case MotionEvent.ACTION_DOWN:
			if(x>=0&&x<=105&&y>=300&&y<=335)
			{
				left1=LEFT+20;
				left2=LEFT;
				left3=LEFT;
				left4=LEFT;
			}
			else if(x>=0&&x<=105&&y>=340&&y<=375)
			{
				left1=LEFT;
				left2=LEFT+20;
				left3=LEFT;
				left4=LEFT;
			}
			else if(x>=0&&x<=105&&y>=380&&y<=415)
			{
				left1=LEFT;
				left2=LEFT;
				left3=LEFT+20;
				left4=LEFT;
			}
			else if(x>=0&&x<=105&&y>=420&&y<=455)
			{
				left1=LEFT;
				left2=LEFT;
				left3=LEFT;
				left4=LEFT+20;
			}
            
			new zhuThread(this).start();
			
			break;
		case MotionEvent.ACTION_UP:
			if(x>=0&&x<=105&&y>=300&&y<=335)
			{
				activity.hd.sendEmptyMessage(GAME_LOAD);
			}
			else if(x>=0&&x<=105&&y>=340&&y<=375)
			{
				activity.hd.sendEmptyMessage(GAME_HELP);
			}
			else if(x>=0&&x<=105&&y>=380&&y<=415)
			{
				activity.hd.sendEmptyMessage(GAME_ABOUT);
			}
			else if(x>=0&&x<=105&&y>=420&&y<=455)
			{
				System.exit(0);
			}
		}		
		return true;
	}


	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {	
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		Canvas canvas=holder.lockCanvas();
		try
		{
			synchronized(holder)
			{
				onDraw(canvas);//����
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(canvas!=null)
			{
				holder.unlockCanvasAndPost(canvas);
			}
		}

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
	}
	
	public void initBitmap()
	{
		backgroud=BitmapFactory.decodeResource(activity.getResources(), R.drawable.background);	
		begin=BitmapFactory.decodeResource(activity.getResources(), R.drawable.begin);
		shut=BitmapFactory.decodeResource(activity.getResources(), R.drawable.shut);
		about1=BitmapFactory.decodeResource(activity.getResources(), R.drawable.about1);
		help=BitmapFactory.decodeResource(activity.getResources(), R.drawable.help1);
	}	
}