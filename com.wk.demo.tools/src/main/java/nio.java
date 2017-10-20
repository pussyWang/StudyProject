

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.util.List;
import java.util.WeakHashMap;

public class nio {
	private static final String TXT = "C:\\Users\\58\\Desktop\\个人\\txt\\small\\";
	private static final String TXTS = "C:\\Users\\58\\Desktop\\个人\\txts\\";
	private static final int LINE_CNT = 3 * 12;
	private static final int WORD_CNT = 32;
	private static final String PAD_STR = "	  ";
	private static final String LINE_SEPARATOR = System
			.getProperty("line.separator");
	private static FileWriter writer;
	private static int fileCnt = 1;

	private static void spiltFile(String fileName,int skip) throws Exception {
		clearDir();
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(fileName), "GB2312"));
		writer = new FileWriter(TXTS + fileCnt + ".txt");
		String line = "", lastLine = "";
		int lineCnt = 0;
		while ((line = reader.readLine()) != null) {
			if (line.length() < 16)
				continue;
			line = lastLine + line.replace(" ", "");
			while (line.length() > WORD_CNT) {
				lineCnt = changeFile(lineCnt);
				writer.write(lineCnt + ". " + line.substring(0, WORD_CNT)
						+ LINE_SEPARATOR);
				line = line.substring(WORD_CNT);
			}
			lastLine = line;
		}
		writer.write(lineCnt + ". " + lastLine);

		writer.flush();
		readFile(skip);
		reader.close();
		writer.close();
	}

	private static int changeFile(int lineCnt) throws Exception {
		if (lineCnt >= LINE_CNT) {
			writer.close();
			fileCnt++;
			writer = new FileWriter(TXTS + fileCnt + ".txt");
			return 1;
		}
		return (++lineCnt);
	}

	private static void readFile(int skip) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(TXTS
				+ "0.txt"));
		String line = reader.readLine();
		if (line == null) {
			line = "1";
		}
		writer = new FileWriter(TXTS + "0.txt");
		int x = Integer.parseInt(line) + skip;
		writer.write(String.valueOf(Integer.parseInt(line) + skip));
		writer.close();
		reader.close();
		System.err.print((x - 1) + "	");
		reader = new BufferedReader(new FileReader(TXTS + (x - 1) + ".txt"));
		while ((line = reader.readLine()) != null) {
			System.out.println(PAD_STR + line);
		}
		reader.close();
	}

	private static void clearDir() throws Exception {
		File[] fs = new File(TXTS).listFiles();
		for (File file : fs) {
			file.delete();
		}
		File f = new File(TXTS + "0.txt");
		if (!f.exists()) {
			f.createNewFile();
		}
	}

	public static void go(int skip) throws Exception {
		if (!isBranch()) {
			spiltFile(TXT + "最完美的女孩" + ".txt", skip);
		} else {
			readFile(skip);
		}
	}

	public static boolean isBranch() {
		List<String> args = ManagementFactory.getRuntimeMXBean()
				.getInputArguments();
		for (String arg : args) {
			if (arg.startsWith("-Xrunjdwp") || arg.startsWith("-agentlib:jdwp")) {
				return true;
			}
		}
		return false;
	}
}
