
public class  Boss3 extends Character3{

	public Boss3(String name, int hp, int mp, int hit, boolean deadflg) {
		super(name, hp, mp, hit, deadflg);
		this.job = "大ボス";
	}

	//大ボス
	public void introduce() {
		System.out.println("ボクの名前は"+name+ "です。" );

	}

	//特殊な呪文攻撃
	public void attack(Character3 charcter) {
		super.attack(charcter);
		System.out.println("「電光石火」");
	}

}
