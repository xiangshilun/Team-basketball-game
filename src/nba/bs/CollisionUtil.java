package nba.bs;

public class CollisionUtil
{
				//�����������ĵ��
				public static float dotProduct(float[] vec1,float[] vec2)//������x,y,z�������������, ��������һ��float�����С�
				{
					return
						vec1[0]*vec2[0]+
						vec1[1]*vec2[1]+
						vec1[2]*vec2[2];
					
				}   
				
				//��������ģ
				public static float mould(float[] vec)
				{
					return (float)Math.sqrt(vec[0]*vec[0]+vec[1]*vec[1]+vec[2]*vec[2]);
				}
				
				//�����������ļн�
				public static float angle(float[] vec1,float[] vec2)
				{
					//������
					float dp=dotProduct(vec1,vec2);
					//��������������ģ
					float m1=mould(vec1);
					float m2=mould(vec2);
					
					return (float)Math.acos(dp/(m1*m2));
				}
			
	
	
	
			//������ĳ������һ���ٶ�ײ����ķ����ٶȣ�������������ʧ
			public static float[] ballBreak
			(
				float[] vBefore, //ײ��ǰ���ٶ�
				float[] ballCenter, //ײ��ʱ������
				float[] point//ײ����
			)
			{
				//��������ָ��ײ���������
				float[] vecOtoB=
				{
				    point[0]-ballCenter[0],
				    point[1]-ballCenter[1],
				    point[2]-ballCenter[2],	
				};
				
				
				//����ײ��ǰ�ٶ���ײ��������(������ָ��ײ���������)�ļн�
				float alpha=angle(vecOtoB,vBefore);
				//��ײ��ǰ�ٶȵ�ģ
				float vMould=mould(vBefore);	
				//����ײ���������������ٶȷ�����ģ
				float vNormalMould=vMould*(float)Math.cos(alpha);
				//��ײ����������ģ
				float normalMould=mould(vecOtoB);	
				//����ײ�������������ϵ��ٶȷ���
				float[] vNormal=
				{
					vecOtoB[0]*vNormalMould/normalMould,
					vecOtoB[1]*vNormalMould/normalMould,
					vecOtoB[2]*vNormalMould/normalMould,
				};		
				
				//��ֱ��ײ�������������ϵ��ٶȷ���
				float[] vONormal=
				{
					vBefore[0]-vNormal[0],
					vBefore[1]-vNormal[1],
					vBefore[2]-vNormal[2]
				};
				
				//��ײ����ײ��������������ٶȷ�����ײ����÷����ϵ��ٶȷ������������÷���
				float[] vNormalAfter=
				{
					-vNormal[0],
					-vNormal[1],
					-vNormal[2]
				};
				
				//��ײ������ٶȣ����ٶ�Ϊ�÷���ײ��������������ٶȷ����봹ֱ��ײ�������������ϵ��ٶȷ����ĺ�������
				float[] vAfter=
				{
					vONormal[0]+vNormalAfter[0],
					vONormal[1]+vNormalAfter[1],
					vONormal[2]+vNormalAfter[2],
				};
				
				return vAfter;		
			}
	
	//��֪���λ�ã��뾶����Ȧ��λ�ã��뾶
	//��ײ����
	public static float[] breakPoint
	(
			float[] ballCenter, //����
			float ballR,//��뾶
			float[] ringCenter,//��Ȧ���ĵ�
			float ringR//��Ȧ�뾶
	)
	{
			//�����ж���Ȧ�ĸ߶ȷ�Χ�Ƿ�������߶ȷ�Χ�ڣ�����������ײ��Ȧ�Ŀ���
			if(ringCenter[1]<ballCenter[1]+ballR&&ringCenter[1]>ballCenter[1]-ballR)//ringCenter[1]Ϊ���ĸ߶ȣ�ballCenter[1]Ϊ���ĵĸ߶�
			{
				
				//������ײԲ�İ뾶
				float ballRForBreak=(float)Math.sqrt
				(
						ballR*ballR-
						(ringCenter[1]-ballCenter[1])*(ringCenter[1]-ballCenter[1])//ringCenter[1]-ballCenter[1]Ϊ�߶Ȳ�
				);
				
				//������ײԲԲ������ȦԲ�ĵľ���
				float distance=(float)Math.sqrt
				(
					(ballCenter[0]-ringCenter[0])*(ballCenter[0]-ringCenter[0])+
					(ballCenter[2]-ringCenter[2])*(ballCenter[2]-ringCenter[2])
				);
				
				//�ж�Բ�ľ����Ƿ�С����Բ�뾶�ĺ��Ҵ��������뾶�Ĳ��������������ײ
				if((distance<ballRForBreak+ringR)&&(distance>(ringR-ballRForBreak)))
				{
					//Բ�ĵ�Z��
					float zDiff=Math.abs(ringCenter[2]-ballCenter[2]);
					double jdAngle=Math.asin(zDiff/distance);
					
					float xAdjust=0;
					float zAdjust=0;
					
					if(ballCenter[0]>=ringCenter[0])
					{
						xAdjust=-1;
					}
					else
					{
						xAdjust=+1;
					}
					if(ballCenter[2]>=ringCenter[2])
					{
						zAdjust=-1;
					}
					else
					{
						zAdjust=1;
					}
					
					//����ײ��
					float[] point=
					{
						ballCenter[0]+xAdjust*ballRForBreak*(float)Math.cos(jdAngle),
						ringCenter[1],
						ballCenter[2]+zAdjust*ballRForBreak*(float)Math.sin(jdAngle),
					};					
					
					return point;
				}
				else
				{
					return null;
				}
				
			}

			return null;		
	}

	
	public static void main(String args[])
	{
		float[] vAfter=CollisionUtil.ballBreak
		(
			new float[]{2,-2,0}, //ײ��ǰ���ٶ�
			new float[]{4,4,0}, //ײ��ʱ������
			new float[]{6.828427f,1.1715729f,0}//ײ����			
		);
		
		System.out.println(vAfter[0]+", "+vAfter[1]+", "+vAfter[2]);
		
		
	}
}