import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class parsing {
	public static void main(String[] args) throws Exception {
		File start = new File("/home/han/Documents/HanResults");

		String[] id = new String[30];
		String[][] corrTest = new String[7][30];
		String[][] corrTrain = new String[7][30];
		String[] algo = new String[7];
		int i = 0;

		for (File f : start.listFiles()) {
			if (!f.isDirectory())
				continue;

			algo[i] = f.getName();
			File dive = new File(f.toString() + "/results/Vis-Clas-Check");
			parse(dive.listFiles()[0], algo[i], corrTest[i], id, corrTrain[i]);
			i++;
		}

		FileWriter osTrain = new FileWriter(new File(start.toString() + "/train.csv"));
		FileWriter osTest = new FileWriter(new File(start.toString() + "/test.csv"));
		
		osTest.write("Data");
		osTrain.write("Data");

		for(int j = 0; j < 7; j++){
			osTrain.write("," + algo[j]);
			osTest.write("," + algo[j]);
		}
		
		osTrain.write("\n");
		osTest.write("\n");
		
		for(i = 0; i < 30; i++){
			osTrain.write(id[i]);
			osTest.write(id[i]);
			
			for(int j = 0; j < 7; j++){
				osTrain.write("," + corrTrain[j][i]);
				osTest.write("," + corrTest[j][i]);
			}
			
			osTrain.write("\n");
			osTest.write("\n");
		}
		
		osTest.close();
		osTrain.close();

		System.err.println("Done");
	}

	private static void parse(File file, String algo, String[] corrTest, String[] id, String[] corrTrain)
			throws Exception {
		boolean train = false;

		System.out.println(algo);
		System.out.println(Arrays.toString(file.listFiles()));
		int i = 0;

		for (File f : file.listFiles()) {
			Scanner sc = new Scanner(f);

			while (sc.hasNextLine()) {
				String line = sc.nextLine();

				if (line.startsWith("TRAIN")) {
					train = true;

				} else if (line.startsWith("TEST")) {
					train = false;
				} else if (line.startsWith("Classifier=")) {
					id[i] = line.substring("Classifier= ".length());
				} else if (line.startsWith("Correct")) {
					if (train) {
						corrTrain[i] = sc.nextLine();
					} else {
						corrTest[i] = sc.nextLine();
					}
				}
			}

			i++;
			sc.close();
		}
	}
}
