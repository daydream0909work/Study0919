
class Majyo extends Character3{


	public Majyo(String name, int hp, int mp, int hit, boolean deadcount, boolean deadflg) {
		super(name, hp, mp, hit, deadcount, deadflg);

	}

	//魔女のセリフ
	public void introduce() {
		System.out.println("私の名前" + name + "よ！！");

	}

	//特殊な呪文攻撃
	public void attack() {
		super.attack();
		System.out.println("「ピリカピリララ！！」");
	}

}
