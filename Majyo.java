
class Majyo extends Character3{


	public Majyo(String name, int hp, int mp, int hit, boolean deadcount, boolean deadflg) {
		super(name, hp, mp, hit, deadcount, deadflg);

	}

	public void introduce() {
		System.out.println("私の名前" + name + "よ！！");

	}

}
