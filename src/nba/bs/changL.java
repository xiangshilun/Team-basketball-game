package nba.bs;

public class changL{
	//���ӵĳ�������
	public static float WIDTH=4.1f; 
	public static float HEIGHT=7f;
	public static float LENGTH=4f;
	//����и���������С
	public static final float BALL_ANGLESPAN=15f;
	public static final float BALL_SCALE=0.3f;
	//������������
	public static float[] HALL_TEXTURES=new float[]{
        	0,0,0,1.0f,1.0f,1.0f,
        	0,0,1.0f,1.0f,1.0f,0
        };
	//�������ٶ�
	public static float G=0.8f;
	
	public static float CAMERA_INI_X=0;
	public static float CAMERA_INI_Y=HEIGHT/2;
	public static float CAMERA_INI_Z=LENGTH+4.0f;
	
	public static final float DISTANCE=LENGTH;
	
	public static final float ENERGY_LOSS=0.4f;
	
	public static final float BALL_MAX_SPEED_X=0.6f;
	public static final float BALL_MAX_SPEED_Y=3.0f;
	public static final float BALL_MAX_SPEED_Z=-2.0f;
	
	public static final float BALL_NEAREST_Z=LENGTH/2-0.15f;//���������
	
	public static final float BALL_FLY_TIME_SPAN=0.1f;//����е�ʱ�䵥λ
	public static final float BALL_ROLL_SPEED=0.05f;//���ڵ����Ϲ������ٶ�
	public static final float BALL_ROLL_ANGLE=360*BALL_ROLL_SPEED/(2*(float)Math.PI*BALL_SCALE);//���ڵ����Ϲ����ĽǶ��ٶ�
	
	 
	public static final float BASKETBALL_STANDS_SPAN=0.08f;//����ܴ�С����ϵ����
	public static final float BASKETBALL_STANDS_X=0;//�����λ��x����
	public static final float BASKETBALL_STANDS_Y=5;//�����λ��y����
	public static final float BASKETBALL_STANDS_Z=-1.65f;//�����λ��z����
	
	//�Ǳ���е������ֵĴ�С
	public static final float SCORE_NUMBER_SPAN_X=0.1f;
	public static final float SCORE_NUMBER_SPAN_Y=0.12f;
	
	public static float[] ringCenter;//�������ĵ�����
	public static float ringR;//����뾶
	
	public static int score=0;//�÷�
	public static int deadtimes=60;//��Ϸ����ʱ
	
	//��Ӱ��С
	public static float SHADOW_X=1.0f;
	public static float SHADOW_Y=0.1f;
	public static float SHADOW_Z=0.6f;
	
	//�˵�����
	public static final int GAME_SOUND=1;
	public static final int GAME_MENU=2;
	public static final int GAME_LOAD=3;
	public static final int GAME_HELP=4;
	public static final int GAME_ABOUT=5;
	public static final int GAME_PLAY=6;
	public static final int GAME_OVER=7;
	public static final int RETRY=8;	
	
	
	public static float LEFT=-55f; //�˵�λ��
	
    //�̱߳�־λ
	public static boolean SOUND_FLAG=true;//����	���
	public static boolean SOUND_MEMORY=false;//���ڼ�¼������ҵ�ѡ��
	public static boolean DEADTIME_FLAG=false;//����ʱ�̱߳��
	public static boolean MENU_FLAG=false;//�˵���ť�����̱߳��
	public static boolean BALL_GO_FLAG=true;//���˶��̱߳��
}