
public class  Boss2 extends Character3 implements Movable {

	public Boss2(String name, int hp, int mp, int hit, boolean deadflg) {
		super(name, hp, mp, hit, deadflg);
		this.job = "中ボス";
		this.deadflg = false;
	}

	//中ボス
	public void introduce() {
		System.out.println("ボクの名前は"+name+ "です。" );

	}

	//特殊な呪文攻撃
	public void attack(Character3 charcter) {
		super.attack(charcter);
		System.out.println("「メラ！！」");
	}

	void attack() {
		System.out.println("「メラメラ！！」");
	}

	void move(Movable party){
		attack((Character3)party);
	}

}
