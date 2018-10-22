
class Majyo extends Character3 implements Movable {

	public Majyo(String name, int hp, int mp, int hit,boolean deadflg) {
		super(name, hp, mp, hit, deadflg);
		this.job ="勇者";
	}

	//魔女のセリフ
	public void introduce() {
		System.out.println("私の名前は" + name + "です。！！職業は" + job + "よ！");

	}

	//特殊な呪文攻撃
	public void attack(Character3 charcter) {
		super.attack(charcter);
		System.out.println("「ピリカピリララ！！」");
	}

	//オーバライド
	public void Move() {

	}

}
