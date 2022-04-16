package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Lesson;
import entities.Video;
import entities.Task;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Lesson> list = new ArrayList<>();

		System.out.print("Quantas aulas tem o curso? ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.printf("\nDados da %da aula: \n", i + 1);

			System.out.print("Conte�do ou tarefa (c/t)? ");
			char ch = sc.next().charAt(0);

			System.out.print("T�tulo: ");
			sc.nextLine();
			String title = sc.nextLine();

			if (ch == 'c') {
				System.out.print("URL do v�deo: ");
				String url = sc.next();
				System.out.print("Dura��o em segundos: ");
				int seconds = sc.nextInt();
				list.add(new Video(title, url, seconds));
			} else {
				System.out.print("Descri��o: ");
				String description = sc.nextLine();
				System.out.print("Quantidade de quest�es: ");
				int questionCount = sc.nextInt();
				list.add(new Task(title, description, questionCount));
			}
		}

		int sum = 0;
		for (Lesson les : list) {
			sum += les.duration();
		}

		System.out.printf("\nDURA��O TOTAL DO CURSO = %d segundos", sum);

		sc.close();

	}

}
