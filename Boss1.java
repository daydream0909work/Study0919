
public class  Boss1 extends Character3 implements Movable{

	public Boss1(String name, int hp, int mp, int hit, boolean deadflg) {
		super(name, hp, mp, hit, deadflg);
		this.job = "小ボス";
	}

	//小ボス
	public void introduce() {
		System.out.println("ボクの名前は"+name+ "です。" );
	}

	//特殊な攻撃
	public void attack(Character3 charcter) {
		super.attack(charcter);
		System.out.println("「頭突き！！」");
	}

	public void move() {

	}
}
