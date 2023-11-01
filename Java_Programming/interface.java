interface movable{
	public static final int UP = 1;
	public static final int DOWN = 2;
	public static final int LEFT = 3;
	public static final int RIGHT = 4;
	
	public void move(int dstX, int dstY);
}
interface attackable
{
	public void attack(myObject ob);
	
}
interface magicable
{
	public void magic(myObject ob);
	public void teleport(int x, int y);
}
abstract class myObject
{
	public static final int BUILDING = 0;
	public static final int HUMAN = 1;
	public static final int WARRIOR = 2;
	public static final int ARCHAR = 3;
	public static final int WIZARD = 4;
	
	protected int type;
	protected int x, y;
	protected int hp;
	
	myObject()
	{
		this.type = 0; this.x = 0; this.y = 0;
	}
	myObject(int x, int y, int type, int hp)
	{
		this.x = x; this.y = y; 
		this.type = type;
		this.hp = hp;
	}
	abstract void information();
	public static double distance(myObject ob1, myObject ob2)
	{
		double a = ob1.x - ob2.x;
		double b = ob1.y - ob2.y;
		double cSQ = a * a + b * b;
		return Math.sqrt(cSQ);
	}
}

class Building extends myObject
{
	Building(int x, int y, int hp)
	{
		super(x, y, myObject.BUILDING, hp);
	}
	@Override
	void information() {
		// TODO Auto-generated method stub
		System.out.println("type : Building" + " hp : " + hp + " pos : (" +x +","+ y +")");
	}



	
}

class Human extends myObject implements movable
{
	protected double mv;
	protected int range;
	Human(int x, int y)
	{
		super(x, y, myObject.HUMAN, 40);
		mv = 0.1;
		range = 0;
	}
	Human(int x, int y, int type, double mv, int range, int hp)
	{
		super(x, y, type, hp);
		this.mv = mv;
		this.range = range;
	}

	@Override
	public void information() {
		// TODO Auto-generated method stub
		System.out.println("type : human" + " hp : " + hp + " pos : (" +x +","+ y +")");
	}


	@Override
	public void move(int dstX, int dstY) {
		// TODO Auto-generated method stub
		double mx, my;
		double x=this.x, y=this.y;
		mx = my = mv;
		if (dstX < x)
			mx = -mx;
		for (; (int)(dstX*10) != (int)(x*10); x += mx); 

		if (dstY < y)
			my = -my;

		for (; (int)(dstY* 10) != (int)(y*10); y += my);
		
		this.x = (int)x;
		this.y = (int)y;
	}
}

class Archer extends Human implements attackable
{
	int arrow;
	Archer(int x, int y) {
		super(x, y, myObject.ARCHAR, 0.2, 5, 50);
		arrow = 5;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attack(myObject ob) {
		
		if(arrow > 0)
		{
			double dist = distance(this, ob);
			if (ob.hp > 0 && dist <= range)
			{
				ob.hp -= 40; //
				arrow -= 1;
				if(arrow < 0) arrow = 0;
			}
				
			else 
				System.out.println("범위 내 대상이 없습니다");
		}
		else
		{
			System.out.println("화살이 부족합니다");
		}		
	}
	void reload()
	{
		arrow += 2;
		if (arrow > 5) arrow = 5;
	}
	public void information() {
		// TODO Auto-generated method stub
		System.out.println("type : Archer" + " hp : " + 
		hp + " pos : (" +x +","+ y +")" + "arrow:" + arrow);
	}
}


class Wizard extends Human implements magicable
{
	int mp;
	Wizard(int x, int y) {
		super(x, y, myObject.WIZARD, 0.1, 3, 40);
		// TODO Auto-generated constructor stub
		mp = 100;
	}

	@Override
	public void magic(myObject ob) {
		// TODO Auto-generated method stub
		if(mp >= 30)
		{
			double dist = distance(this, ob);
			if (ob.hp > 0 && dist <= range)
			{
				ob.hp += 10; //
				mp -= 30;
				if (mp < 0) mp = 0;
			}		
			else 
				System.out.println("범위 내 대상이 없습니다");
		}
	}
	void charge()
	{
		mp += 10;
		if (mp > 100) mp = 100;
	}
	

	@Override
	public void teleport(int x, int y) {
		// TODO Auto-generated method stub
		this.x = x; this.y = y;
	}
	public void information() {
		// TODO Auto-generated method stub
		System.out.println("type : Wizard" + " hp : " + hp + " pos : (" +x +","+ y +")");
	}
}

class Warrior extends Human implements attackable
{
	Warrior(int x, int y) {
		super(x, y, myObject.WARRIOR, 0.5, 1, 100);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void information() {
		// TODO Auto-generated method stub
		System.out.println("type : Warrior" + " hp : " + hp + " pos : (" +x +","+ y +")");
	}

	@Override
	public void attack(myObject ob) {
		// TODO Auto-generated method stub
		double dist = distance(this, ob);
		if (ob.hp > 0 && dist <= range)
			ob.hp -= 10; //
		else 
			System.out.println("범위 내 대상이 없습니다");
	}
}




public class Quiz {

	public static void main(String[] args) {

		Human[] obj = new Human[3];
		obj[0] = new Human(0, 0);
		obj[1] = new Warrior(2, 0);
		obj[2] = new Archer(3, 0);		
		obj[1].move(1, 0);
		
		((Archer)obj[2]).attack(obj[0]);
		for(int i=0; i<3; i++)
		{
			obj[i].information();
		}
		
	}
}
