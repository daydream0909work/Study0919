
public class  Monster extends Character3{

	public Monster(String name, int hp, int mp, int hit, boolean deadcount, boolean deadflg) {
		super(name, hp, mp, hit, deadcount, deadflg);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	//モンスター(スライム)
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

}
