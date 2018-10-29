import java.util.Random;

public class Another {

	public static  boolean deadflg = true;
	static int i = 0;

	public static void main(String[] args) {

		//**味方チーム****************************
		Movable[] party = new Movable[3]; //Movable型に変更

		for(int k = 0; k < party.length; k++) {
			party[k] = new Machibito();
		}

		Yusya _yusya = new Yusya("勇者",300,40,60,false);
		Majyo _majyo = new Majyo("魔女",200,30,45,false);
		Monster _suraimu= new Monster("スライム",10,20,5,false);

		/*
		party[0].move(_yusya);
		party[1].move(_majyo);
		party[2].move(_suraimu);
		*/

		//自己紹介
		//勇者
		_yusya.introduce();
		//魔女
		_majyo.introduce();
		//スライム
		_suraimu.introduce();


		//**敵チーム****************************
		Movable[] enemy_party = new Movable[3];

		enemy_party[0] =  new Machibito();


		for(int k = 0; k < party.length; k++) {
			enemy_party[k] = new Machibito();
		}

		Boss1 _boss1 = new Boss1("小ボス",100,50,30,false);
		Boss2 _boss2 = new Boss2("中ボス",500,150,50,false);
		Boss3 _boss3 = new Boss3("大ボス",1000,400,100,false);

		/*
		enemy_party[0].move(_boss1);
		enemy_party[1].move(_boss2);
		enemy_party[2].move(_boss3);
		*/

		//どちらかのパーティーが絶滅するまで
		while(deadflg) {

			//敵、味方交代ずつ、攻撃する
			if(i%2 == 0) {

				if(_yusya.deadflg == true && _majyo.deadflg == true && _suraimu.deadflg == true) {
					System.out.println("勇者チームが全滅した！");
					deadflg = false;
					System.exit(0);
				}else if(_boss1.deadflg == true && _boss2.deadflg == true && _boss3.deadflg == true) {
					System.out.println("ボスチームが全滅した！");
					deadflg = false;
					System.exit(0);
				}

				//勇者チーム
				for(int j = 0; j < party.length; j++) {
					//3人チームなので
					int number = random_attack(3);

						//1だったら敵１に攻撃
						if(number == 0 && !_boss1.deadflg){
						//if(!enemy_party[number].deadflg)party[j].move(enemy_party[number]){
							//party[j].attack(_boss1);
							party[j].move(_boss1);
						//2だったら敵2に攻撃
 						}else if(number == 1 && !_boss2.deadflg){
							//party[j].attack(_boss2);
 							party[j].move(_boss2);
						//3だったら敵3に攻撃
						}else if(number == 2 && !_boss3.deadflg){
							//party[j].attack(_boss3);
							party[j].move(_boss3);
						}
					}

				}else {
					//敵チーム
					for(int k = 0; k < enemy_party.length; k++) {
						//3人チームなので
						int number = random_attack(3);
						//1だったら敵１に攻撃
						if(number == 0 && !_yusya.deadflg) {
							enemy_party[k].move(_yusya);
						//2だったら敵2に攻撃
						}else if(number == 1 && !_majyo.deadflg){
							enemy_party[k].move(_majyo);
						//3だったら敵3に攻撃
						}else if(number == 2 && !_suraimu.deadflg){
							enemy_party[k].move(_majyo);
						}
				}
			}

			i++;
		}

	}


	private static int random_attack(int j) {
		//ランダムメソッドで入力する。
		Random rnd = new Random();
		int randomNumber_2 = rnd.nextInt(j);
		return randomNumber_2;
	}
}
