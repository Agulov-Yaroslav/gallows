package gallows;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] arg) {

		boolean game = true;
		while (game) {
			System.out.print("Добро пожаловать в игру \"Виселица\"!\r\n"

					+ "У вас есть 6 попыток, чтобы угадать слово.\r\n");

			String[] aryString = arr();

			int wordIndex = (int) (Math.random() * aryString.length);

			String word = aryString[wordIndex].toLowerCase();

			char[] letters = word.toCharArray();
			game(letters);

			for (char letter : letters)
				System.out.print(letter);
			System.out.println();
			game = nextGame();
		}
		System.out.println("Спасибо за игру!");

		scanner.close();

	}

	public static String[] arr() {
		String[] aryString = new String[15];

		aryString[0] = "Дедовщина";
		aryString[1] = "Государственность";
		aryString[2] = "Депутат";
		aryString[3] = "Полемичный";
		aryString[4] = "Спекулянт";
		aryString[5] = "Рапира";
		aryString[6] = "Болванчик";
		aryString[7] = "Сырость";
		aryString[8] = "Рафинад";
		aryString[9] = "Шрам";
		aryString[10] = "Свечение";
		aryString[11] = "МОРАЛИСТ";
		aryString[12] = "СУШИЛЬНЯ";
		aryString[13] = "мост";
		aryString[14] = "функция";

		return aryString;
	}

	public static void game(char[] letters) {

		int attempts = 6;

		boolean loop = true;
		boolean mist = true;
		int arrLength = letters.length;
		char[] userTry = new char[arrLength];
		for (char a : userTry)
			a = '_';

		do {

			if (attempts == 0) {
				System.out.println("Ваши попыткы закончились! \nСлово: ");
				break;
			}

			for (char a : userTry)
				System.out.print(a);

			System.out.println();
			System.out.print("Введите букву: ");
			char user = valid();
			for (int i = 0; i < arrLength; i++) {
				if (letters[i] == user) {
					userTry[i] = user;
					mist = false;
				}

			}

			if (Arrays.equals(letters, userTry)) {
				System.out.println("Ты угадал слово!");
				loop = false;
			} else if (mist == true) {

				System.out.println("Этой буквы нет в слове."
						+ " Осталось попыток: " + attempts);
				 
				attempts--;
				drawGallows(6 - attempts);
			} else {
				mist = true;
			}
		} while (loop);

	}

	public static char valid() {
		char valid = '0';
		String userLetter;
		String fail = "Введите 1 букву: ";
		boolean loop = true;
		while (loop) {

			userLetter = scanner.next();
			if (userLetter.length() != 1)
				System.out.print(fail);
			else {
				valid = userLetter.charAt(0);
				if (Character.isLetter(valid)) {
					loop = false;
				} else {
					System.out.print(fail);
				}
			}

		}

		return valid;
	}
	public static void drawGallows(int mistakes) {
        String[] gallows = {
            "  ______\n" +
            "  |    |\n" +
            "       |\n" +
            "       |\n" +
            "       |\n" +
            "       |\n" +
            "       |\n" +
            "_______|",
            
            "  ______\n" +
            "  |    |\n" +
            "  O    |\n" +
            "       |\n" +
            "       |\n" +
            "       |\n" +
            "       |\n" +
            "_______|",
            
            "  ______\n" +
            "  |    |\n" +
            "  O    |\n" +
            "  |    |\n" +
            "       |\n" +
            "       |\n" +
            "       |\n" +
            "_______|",
            
            "  ______\n" +
            "  |    |\n" +
            "  O    |\n" +
            " /|    |\n" +
            "       |\n" +
            "       |\n" +
            "       |\n" +
            "_______|",
            
            "  ______\n" +
            "  |    |\n" +
            "  O    |\n" +
            " /|\\   |\n" +
            "       |\n" +
            "       |\n" +
            "       |\n" +
            "_______|",
            
            "  ______\n" +
            "  |    |\n" +
            "  O    |\n" +
            " /|\\   |\n" +
            " /     |\n" +
            "       |\n" +
            "       |\n" +
            "_______|",
            
            "  ______\n" +
            "  |    |\n" +
            "  O    |\n" +
            " /|\\   |\n" +
            " / \\   |\n" +
            "       |\n" +
            "       |\n" +
            "_______|"
        };
        
        System.out.println(gallows[mistakes]);
    }

	public static boolean nextGame() {
		boolean nextGame = true;
		String offer = "Хотите сыграть еще раз? (да/нет): ";
		System.out.println(offer);
		String answer;

		while (true) {
			answer = scanner.next();
			switch (answer) {
			case "да":
				return nextGame;
				
			case "нет":
				nextGame = false;
				return nextGame;
			default:
				System.out.println(offer);

			}

		}

	}

}
