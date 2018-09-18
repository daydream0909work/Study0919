import java.util.Random;


public class Character3{

	private String name;
	private int hp;
	private int mp;
	private int hit; //攻撃力
	private int deadcount;
	public static  boolean deadflg = false;
	public static  int i;



	//キャラクターメソッド生成
	//名前、HP,MP,攻撃力,死亡カウント、死亡フラグ
	public Character3(String name, int hp, int mp,int hit, int deadcount,boolean deadflg) {
		this.name = name;
		this.hp = hp;
		this.mp = mp;
		this.hit = hit;
		this.deadcount = deadcount;
		this.deadflg = deadflg;

	}



	public static void rpg(String[] args) {

		//**味方チーム****************************
		Character3[] party;
		party= new Character3[3];

		party[0] = new Character3("勇者",450,10,200,0,false);
		party[1] = new Character3("魔女",200,30,45,0,false);
		party[2] = new Character3("スライム",10,20,5,0,false);



		//**敵チーム****************************
		Character3[] enemy_party = new Character3[3];
		enemy_party[0] = new Character3("小ボス",100,50,30,0,false);
		enemy_party[1] = new Character3("中ボス",500,150,50,0,false);
		enemy_party[2] = new Character3("大ボス",1000,400,100,0,false);


		//どちらかのパーティーが絶滅するまで
		while(deadflg == false) {
			//敵、味方交代ずつ、攻撃する
			if(i%2 == 0) {

				if(party[0].deadcount == 1 && party[1].deadcount == 1 && party[2].deadcount == 1) {
					System.out.println("勇者チームが全滅した！");
					System.exit(0);
				}else if(enemy_party[0].deadcount == 1 && enemy_party[1].deadcount == 1 && enemy_party[2].deadcount == 1) {
					System.out.println("ボスチームが全滅した！");
					System.exit(0);
				}

				//勇者チーム
				for(int j = 0; j < party.length; j++) {
					//3人チームなので
					int num3 = random_attack(3);

						//1だったら敵１に攻撃
						if(num3 == 0 && enemy_party[0].deadcount == 0) {
							party[j].attack(enemy_party[0]);
						//2だったら敵2に攻撃
 						}else if(num3 == 1 && enemy_party[1].deadcount == 0){
							party[j].attack(enemy_party[1]);
						//3だったら敵3に攻撃
						}else if(num3 == 2 && enemy_party[2].deadcount  == 0){
							party[j].attack(enemy_party[2]);
						}
					}

			}else {
					//敵チーム
					for(int k = 0; k < enemy_party.length; k++) {
						//3人チームなので
						int num2 = random_attack(3);
						//1だったら敵１に攻撃
						if(num2 == 0 && party[0].deadcount  == 0) {
							enemy_party[k].attack(party[0]);
						//2だったら敵2に攻撃
						}else if(num2 == 1 && party[1].deadcount == 0){
							enemy_party[k].attack(party[1]);
						//3だったら敵3に攻撃
						}else if(num2 == 2 && party[2].deadcount  == 0){
							enemy_party[k].attack(party[2]);
					}
				}
			}

			i = i +1;

		}

	}

	//自己紹介
	void introduce() {
		System.out.println("私の名前は" + name + "です。体力は" + hp +"で、魔力は" + mp + "です。");

	}


	private static int random_attack(int j) {
		//ランダムメソッドで入力する。
		Random rnd_2 = new Random();
		int randomNumber_2 = rnd_2.nextInt(j);
		return randomNumber_2;
	}


	//引数に攻撃力を受け取り、その分hpを減らそう
	private void damage(int hit) {
	    System.out.println(name + "は" + hit + "ポイントのダメージを受けた。");
		hp = hp - hit;

		//deadcountが１以外だったら
		if(deadcount != 1) {
			 if(hp <= 0) {
				System.out.println(name + "の体力は0だ。");
				//System.exit(0);
				deadcount = 1;

			  }else {
				System.out.println(name + "の体力は" + hp +"になった");

			  }
		}


	}

	private void attack(Character3 charcter) {

		if(deadcount != 1) {
			System.out.println(name +"の" + hit + "の攻撃！");
			charcter.damage(hit);
		}

	}
}



