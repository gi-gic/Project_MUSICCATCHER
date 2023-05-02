package musiclist;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javazoom.jl.player.MP3Player;
import model.DAO;
import model.DTO;
import model.musicDTO;

public class MusicMain {

	public void game(String a) {
		DAO dao = new DAO();
		DTO dto = new DTO(null, null, null);

		Scanner sc = new Scanner(System.in);
		MP3Player musicDTO = new MP3Player();

		musicDTO music1 = new musicDTO("우산", "에픽하이", ".\\music\\에픽하이-우산 (Feat. 윤하)(2초).mp3");
		musicDTO music2 = new musicDTO("tomboy", "여자아이들", ".\\music\\여자아이들-TOMBOY(2초).mp3");
		musicDTO music3 = new musicDTO("antifragile", "르세라핌", ".\\music\\르세라핌-ANTIFRAGILE(2초).mp3");
		musicDTO music4 = new musicDTO("안녕이라고말하지마", "다비치", ".\\music\\다비치-안녕이라고 말하지마(2초).mp3");
		musicDTO music5 = new musicDTO("새삥", "지코", ".\\music\\지코-새삥(2초).mp3");
		musicDTO music6 = new musicDTO("반만", "진민호", ".\\music\\진민호-반만(2초).mp3");
		musicDTO music7 = new musicDTO("청혼", "노을", ".\\music\\청혼-노을(2초).mp3");
		musicDTO music8 = new musicDTO("응급실", "IZI", ".\\music\\IZI-응급실(2초).mp3");
		musicDTO music9 = new musicDTO("선물", "멜로망스", ".\\music\\멜로망스-선물(2초).mp3");
		musicDTO music10 = new musicDTO("모든날모든순간", "폴킴", ".\\music\\폴킴-모든 날, 모든 순간(2초).mp3");
		musicDTO music11 = new musicDTO("afterlike", "ive", ".\\music\\ive-afterlike(2초).mp3");
		musicDTO music12 = new musicDTO("그때그순간그대로", "wsg", ".\\music\\wsg-그때그순간그대로(2초).mp3");
		musicDTO music13 = new musicDTO("사건의지평선", "윤하", ".\\music\\윤하-사건의지평선(2초).mp3");
		musicDTO music14 = new musicDTO("소주한잔", "임창정", ".\\music\\임창정-소주한잔(2초).mp3");

		ArrayList<musicDTO> ml1 = new ArrayList<musicDTO>();

		ml1.add(music1);
		ml1.add(music2);
		ml1.add(music3);
		ml1.add(music4);
		ml1.add(music5);
		ml1.add(music6);
		ml1.add(music7);
		ml1.add(music8);
		ml1.add(music9);
		ml1.add(music10);
		ml1.add(music11);
		ml1.add(music12);
		ml1.add(music13);
		ml1.add(music14);

		String[] arr = { "우산", "tomboy", "antifragile", "안녕이라고말하지마", "새삥", "반만", "청혼", "응급실", "선물", "모든날모든순간",
				"afterlike", "그때그순간그대로", "사건의지평선", "소주한잔" };

		int sum = 0;
		int score = 10;
		int index = 0;

		Random rd = new Random();
		
		int aaa[] = new int[14];

		for (int i = 0; i < aaa.length; i++) {
			aaa[i] = rd.nextInt(14);
			for (int j = 0; j < i; j++) {
				if (aaa[i] == aaa[j]) {
					i--;
				}
			}
		}

		while (true) {
			

			musicDTO music = new musicDTO("메인화면", "MusicDoctor", ".\\music\\메인화면 - Rhythm Doctor Tutorial.mp3");

			System.out.println("                      [1]문제시작 [2]종료");
			System.out.print("번호 입력 : ");
			int menu = sc.nextInt();

			if (menu == 1) {

				for (int i = 0; i < arr.length; i++) {
					System.out.println();
					System.out.println("======================================= " + (i + 1)
							+ "번째 문제 ===================================");
					System.out.println();
					System.out.println("              [1]문제듣기 [2]정답쓰기 [3]힌트 [4]패스");

					String title = ml1.get(aaa[i]).getTitle();
					String singer = ml1.get(aaa[i]).getSinger();
					String path = ml1.get(aaa[i]).getPath();

					System.out.print("번호 입력 :");

					int menu2 = sc.nextInt();

					if (menu2 == 1) {

						title = ml1.get(aaa[i]).getTitle();
						singer = ml1.get(aaa[i]).getSinger();
						path = ml1.get(aaa[i]).getPath();

						musicDTO.play(path);
						i--;

					} else if (menu2 == 2) {

						System.out.print("정답 입력 : ");
						String answer = sc.next();

						if (title.equals(answer)) {

							sum += score;
							System.out.println("정답입니다! 현재 점수 : " + sum + "점!");
							path = ml1.get(aaa[i]).getPath();
							if (arr.length == i) {
								break;
							}
							index++;
						} else {
							System.out.println("땡!!");
							i--;
						}
					}

					else if (menu2 == 3) {

						singer = ml1.get(aaa[i]).getSinger();
						path = ml1.get(aaa[i]).getPath();

						System.out.println("이노래의 가수는 " + singer);
						i--;

					} else if (menu2 == 4) {

						if (i == 13) {
							System.out.println("마지막 문제입니다.");
							continue;
						}

						System.out.println("정답은 " + arr[aaa[i]] + " 였습니다ㅋ");
						index++;
						

						
					}
				}
				System.out.println("수고하셨습니다");
				System.out.println("점수는" + sum);

				dao.getRank(sum, a);

				// 여기에 mm.game에서 얻은 nick, menu, pw값이 적혀야함

			} else if (menu == 2) {
				System.out.println("뮤직캐쳐를 종료합니다.");
				break;

			} else {
				System.out.println("다시 입력해주세요.");

			}
		}
	}

}
