package view;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.ManagementSystem;
import javazoom.jl.player.MP3Player;
import model.DAO;
import model.DTO;
import model.musicDTO;
import musiclist.MusicMain;
import oracle.jdbc.aq.AQNotificationEvent.AdditionalEventType;

public class Main {

	public static void main(String[] args) {
		DAO dao = new DAO();
		DTO dto = null;
		Scanner sc = new Scanner(System.in);
		MP3Player mp3 = new MP3Player();
		MusicMain mm = new MusicMain();

		musicDTO music = new musicDTO("메인화면", "MusicDoctor", ".\\music\\메인화면 - Rhythm Doctor Tutorial.mp3");

		if (mp3.isPlaying()) {
			mp3.stop();
		}

		String path = music.getPath();
		mp3.play(path);

		main();

		while (true) {

			// 메인화면 선택창
			System.out.println("                                                                                     ");
			System.out
					.println("                             MAIN                                         ");
			System.out.println("        [1]게임 시작하기 [2]게임 설명 [3]랭킹 확인 [4] 게임 종료                  ");
			System.out.println("―――――――――――――――――――――――――――――――――――――――                       ");
			System.out.print("번호 입력 : ");
			int num = sc.nextInt();

			// [1]게임 시작하기에서 로그인 창으로
			if (num == 1) {

				System.out.println("                [1]로그인 [2]회원가입 [3]회원탈퇴 [4]종료                    ");
				System.out.print("번호 입력 : ");
				// 로그인 메뉴
				int menu = sc.nextInt();

				if (menu == 1) {

					System.out.print("아이디 입력 >> ");
					String id = sc.next();
					System.out.print("비밀번호 입력 >> ");
					String pw = sc.next();

					boolean a = dao.login(id, pw);

					if (a) {

						mp3.stop();

						System.out.println("로그인 성공!");
						System.out.println(dao.getNick2() + "님 안녕하세요!");
						
						mm.game(dao.getNick2());

					} else {
						System.out.println("로그인 실패!");
					}

				} else if (menu == 2) {

					System.out.print("아이디 입력 >> ");
					String id = sc.next();
					System.out.print("비밀번호 입력 >> ");
					String pw = sc.next();
					System.out.print("닉네임 입력 >> ");
					String nick = sc.next();
					dto = new DTO(id, pw, nick);

					dao.insert(dto);

					dao.insertranknick(dto);

				} else if (menu == 3) {
					System.out.print("회원 ID : ");
					String id = sc.next();

					int cnt = dao.delete(id);

					if (cnt > 0) {
						System.out.println("탈퇴 성공");

					} else {
						System.out.println("탈퇴 실패");

					}

				}

			} else if (num == 2) {
				try {
					System.out.println();
					System.out.println("               짧은 시간동안 노래의 전주를 듣고 제목을 맞추는 게임!                  ");
					Thread.sleep(500);
					System.out.println("                 게임 도중 패스와 힌트를 사용할 수 있다.                      ");
					Thread.sleep(500);
					System.out.println("         단, 정답 입력시 영문은 소문자로 쓰고 띄어쓰기를 쓰지 않는다.               ");
					Thread.sleep(500);
					System.out.println("                   점수는 한 문제당 10점씩 총 14문제!                      ");
					Thread.sleep(500);
					System.out.println();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println();

			} else if (num == 3) {
				dao.selectAll();

			} else if (num == 4) {
				mp3.stop();
				System.out.println("프로그램 종료");
				break;

			}
		}
	}

	private static void main() {
		try {
			System.out.println("##    ## ##  ##  #### ##   ####     ####   ##   ######   #### ##  ## ##### #### ");
			Thread.sleep(300);
			System.out.println("###  ### ##  ## ##    ##  ##       ##      ##     ##    ##    ##  ## ##    ## ##");
			Thread.sleep(500);
			System.out.println("#### ### ##  ## ###   ## ##       ##      # ##    ##   ##     ##  ## ##    ## ## ");
			Thread.sleep(220);
			System.out.println("# ### ## ##  ##  ###  ## ##       ##      # ##    ##   ##     ###### ####  #### ");
			Thread.sleep(400);
			System.out.println("#  #  ## ##  ##   ### ## ##       ##     ######   ##   ##     ##  ## ##    ## ## ");
			Thread.sleep(200);
			System.out.println("#  #  ## ##  ##    ## ##  ##       ##    #   ##   ##    ##    ##  ## ##    ## ## ");
			Thread.sleep(400);
			System.out.println("#     ##  ####  ####  ##   ####     #### #   ##   ##     #### ##  ## ##### ##  ##");
			Thread.sleep(200);
			System.out.println("                                                                                     ");
			System.out.println("                                                                                     ");
			Thread.sleep(110);
			System.out.println("―――――――――――――――――――――――――――――――――――――――                ");
			Thread.sleep(200);
			System.out.println("                                 ♪                                          ");
			Thread.sleep(150);
			System.out.println("                      GAME                 TEAM                             ");
			Thread.sleep(300);
			System.out.println("                     뮤직캐쳐              Ctrl C+V                           ");
			Thread.sleep(300); 
			System.out.println("                                                                                     ");
			Thread.sleep(100);
			System.out.println("―――――――――――――――――――――――――――――――――――――――               ");
			Thread.sleep(100);
			System.out.println("                                                                                     ");
			Thread.sleep(100);

		} catch (Exception e) {
			System.out.println("메인화면 실행 실패");
		}
	}
}
