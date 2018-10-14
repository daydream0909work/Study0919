abstract public class Character3{

	protected String name;
	protected String job;
	protected int hp;
	protected int mp;
	protected int hit; //攻撃力
	protected boolean deadflg = false;

	//名前、HP,MP,攻撃力,死亡カウント、死亡フラグ
	public Character3(String name, int hp, int mp,int hit,boolean deadflg) {
		this.name = name;
		this.hp = hp;
		this.mp = mp;
		this.hit = hit;
		this.deadflg = deadflg;
	}

	//引数なしのコンストラクタを記載し、オーバーロードする
	public Character3(){
		this.name = "デフォルト名";
		this.job = "仕事";
		this.hp = 150;
		this.mp = 100;
		this.hit = 50;
		this.deadflg = false;
	}

	//自己紹介
	void introduce() {
		System.out.println("私の名前は" + name + "です。体力は" + hp +"で、魔力は" + mp + "です。");

	}

	//引数に攻撃力を受け取り、その分hpを減らそう
	protected void damage(int hit) {
		System.out.println(name + "は" + hit + "ポイントのダメージを受けた。");
		hp -= hit;
		if(deadflg != true) {
			 if(hp <= 0) {
				System.out.println(name + "の体力は0だ。");
				deadflg = true;
			  }else {
				System.out.println(name + "の体力は" + hp +"になった");
			  }
		}
	}

	void attack(Character3 charcter) {
		if(deadflg != true) {
			System.out.println(name +"の" + hit + "の攻撃！");
			charcter.damage(hit);
		}
	}

}



