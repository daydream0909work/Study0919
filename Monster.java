
public class  Monster extends Character3 implements Movable {

	public Monster(String name, int hp, int mp, int hit, boolean deadflg) {
		super(name, hp, mp, hit, deadflg);
		this.job = "モンスター";
	}

	//モンスター(スライム)
	public void introduce() {
		System.out.println("ボクの名前は"+name+ "です。" );

	}

	//特殊な呪文攻撃
	public void attack(Character3 charcter) {
		super.attack(charcter);
		System.out.println("「ファイアー！」");
	}

}
