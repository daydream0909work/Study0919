
public class  Monster extends Character3{

	public Monster(String name, int hp, int mp, int hit, boolean deadcount, boolean deadflg) {
		super(name, hp, mp, hit, deadcount, deadflg);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public void introduce() {
		System.out.println(name + "の名前は魔女でござる");

	}

}
