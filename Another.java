import java.util.Random;

public class Another {

	public static  boolean deadflg = true;
	static int i = 0;

	public static void main(String[] args) {
		Machibito a = new Machibito();


		//**味方チーム****************************
		//Character3[] party = new Character3[3];

		//party[0]=  new Yusya("勇者",300,40,60,false);
		//party[1] = new Majyo("魔女",200,30,45,false);
		//party[2] = new Monster("スライム",10,20,5,false);

		Machibito[] party = new Machibito[3];
		Yusya _yusya = new Yusya("勇者",300,40,60,false);
		Majyo _majyo = new Majyo("魔女",200,30,45,false);
		Monster _suraimu= new Monster("スライム",10,20,5,false);

		//勇者
		_yusya.introduce();
		//_yusya.damage(10);


		//魔女
		_majyo.introduce();
		//_majyo.damage(10);

		//スライム
		_suraimu.introduce();
		//_suraimu.damage(20);


		//**敵チーム****************************
		//Character3[] enemy_party = new Character3[3];
		Machibito[] enemy_party2 = new Machibito[3];

		Boss1 _boss1 = new Boss1("小ボス",100,50,30,false);
		Boss2 _boss2 = new Boss2("中ボス",500,150,50,false);
		Boss3 _boss3 = new Boss3("大ボス",1000,400,100,false);

		//小ボス
		//_boss1.damage(5);

		//中ボス
		//_boss2.damage(10);

		//大ボス
		//_boss3.damage(15);

		//a.move(party[2]);
		//a.attack(party[0]);

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
						if(number == 0 && !_yusya.deadflg) {
							party[j].attack(_boss1);
						//2だったら敵2に攻撃
 						}else if(number == 1 && !_majyo.deadflg){
							party[j].attack(_boss2);
						//3だったら敵3に攻撃
						}else if(number == 2 && !_suraimu.deadflg){
							party[j].attack(_boss3);
						}
					}

			}else {
					//敵チーム
					for(int k = 0; k < enemy_party2.length; k++) {
						//3人チームなので
						int number = random_attack(3);
						//1だったら敵１に攻撃
						if(number == 0 && !_yusya.deadflg) {
							enemy_party2[k].attack(_yusya);
						//2だったら敵2に攻撃
						}else if(number == 1 && !_majyo.deadflg){
							enemy_party2[k].attack(_majyo);
						//3だったら敵3に攻撃
						}else if(number == 2 && !_suraimu.deadflg){
							enemy_party2[k].attack(_suraimu);
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
