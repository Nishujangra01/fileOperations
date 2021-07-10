import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;



public class Main {
	static {
		System.out.println("******* Welcome *******");

	}

	static String homePath = System.getProperty("user.home");

	public static void main(String[] args) {
		List<String> filesArray = new ArrayList<String>();
		Scanner scanner = new Scanner(System.in);
		homePath = homePath + "\\Downloads\\Nishu\\";
		// Make directory
		File file = new File(homePath);
		file.mkdir();

		int choice = 0;
		while (choice <= 3) {
			choice();
			choice = scanner.nextInt();
			if (choice == 1) {
				System.out.println("Enter File you want to add ...");
				String fileName = scanner.next();
				if (fileName != null || fileName != "") {
					addFile(fileName);
				} else {
					System.out.println("File Name is Empty");
				}

			} else if (choice == 2) {
				System.out.println("Enter txt file you want to delete in following files ...");
				File file2 = new File(homePath);
				List<String> filesList = Arrays.asList(file2.list());
				for (String string : filesList) {
					System.out.println(string);
				}
				String delFile = scanner.next();
				delFile(delFile);
			} else if (choice == 3) {
				System.out.println("Enter file name you want to search ...");
				String searchFile = scanner.next();
				searchFile(searchFile);
			}

			sortFiles();

		}

	}

	public static void addFile(String fileName) {
		// here file extension is hard coded as txt file

		File file = new File(homePath + fileName + ".txt");
		try {
			if (!file.exists()) {
				file.createNewFile();
				System.out.println("File " + fileName + ".txt Added ... ");
			} else {
				System.out.println("File Already exists ...");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void delFile(String fileName) {
		File file = new File(homePath + fileName + ".txt");
		if (file.delete()) {
			System.out.println("File has been deleted ...");
		} else {
			System.out.println("Invalid File ...");
		}
	}

	public static void searchFile(String fileName) {
		File file = new File(homePath + fileName + ".txt");
		if (file.exists()) {
			System.out.println("File found ...");
		} else {
			System.out.println("File not found ...");
		}
	}

	public static void sortFiles() {

		File file2 = new File(homePath);
		List<String> filesList = Arrays.asList(file2.list());
		Collections.sort(filesList);
		System.out.println("Files sorted ...");
	}

	public static void choice() {
		System.out.println("Enter below options to do operations :-");
		System.out.println("Add : 1");
		System.out.println("Delete : 2");
		System.out.println("Search : 3");
		System.out.println("Exit : 4");
	}

}
