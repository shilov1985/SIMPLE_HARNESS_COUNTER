import java.awt.Color;
import java.awt.Font;
import java.io.*;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Broiach {

	static File iniFile, statFileCount, statFile;
	static FileReader readIni, readStatCount, readStat;
	static BufferedReader bufReaderFile, bufReadStatCount, bufReadStat;
	static StringBuilder iniStrBuild;
	static int start, end, countRowStat, globalCounter;
	static String pathToStat, sampleStat, zaDobavqneDaljina, speedRead,
			sampleSt, globalSize, codingStatFile, isCloseFrameTrue,
			pathToIniFile;
	static String[] statArr;
	static JTextField field, fieldUser;
	static JFrame frame;
	static BufferedReader br, br1;
	static int x, y;

	public static void main(String[] args) throws InterruptedException {

		// Created by Miroslav Shilov for Kiril Ivanov.SEBN-BG
		JTextField indicator = new JTextField();
		frame = new JFrame("Брояч на комплекти SEBN-BG,Мездра");
		frame.setLayout(null);
		frame.setSize(180, 120);
		frame.setVisible(true);
		frame.setResizable(false);

		frame.setAlwaysOnTop(true);
		field = new JTextField();
		frame.add(field);
		field.setSize(110, 35);
		field.setBounds(0, 0, 180, 40);
		field.setEditable(false);
		field.setFont(new Font("SansSerif", Font.BOLD, 25));
		field.setBackground(Color.orange);
		fieldUser = new JTextField();
		frame.add(fieldUser);
		fieldUser.setSize(220, 64);
		fieldUser.setBounds(0, 40, 200, 40);
		fieldUser.setEditable(false);
		fieldUser.setFont(new Font("SansSerif", Font.BOLD, 27));
		fieldUser.setBackground(Color.cyan);
		fieldUser.add(indicator);

		indicator.setVisible(true);

		pathToIniFile = (new File("INI.txt").getAbsolutePath());
		System.out.println(pathToIniFile);
		while (true) {

			frame.setAlwaysOnTop(true);
			iniStrBuild = new StringBuilder();
			iniFile = new File(pathToIniFile);
			try {
				readIni = new FileReader(iniFile);
			} catch (FileNotFoundException e1) {
				field.setText("ini file not found");
				field.setFont(new Font("SansSerif", Font.BOLD, 12));
				e1.printStackTrace();
			}
			bufReaderFile = new BufferedReader(readIni);
			String tmpIni;

			try {
				while ((tmpIni = bufReaderFile.readLine()) != null) {
					iniStrBuild.append(tmpIni);
				}
			} catch (IOException e1) {
				field.setText("error reading ini file");
				field.setFont(new Font("SansSerif", Font.BOLD, 12));
				e1.printStackTrace();
			}
			int tmpStartStart = iniStrBuild.indexOf("<start>") + 7;
			int tmpStartEnd = iniStrBuild.indexOf("</start>");
			start = Integer.valueOf(iniStrBuild.substring(tmpStartStart,
					tmpStartEnd));
			int tmpEndStart = iniStrBuild.indexOf("<end>") + 5;
			int tmpEndEnd = iniStrBuild.indexOf("</end>");

			end = Integer.valueOf(iniStrBuild.substring(tmpEndStart, tmpEndEnd)
					.trim());

			int tmpStatStart = iniStrBuild.indexOf("<path>") + 6;
			int tmpStatEnd = iniStrBuild.indexOf("</path>");
			pathToStat = iniStrBuild.substring(tmpStatStart, tmpStatEnd);
			int readSpeedStart = iniStrBuild.indexOf("<speedScan>") + 11;
			int readSpeedEnd = iniStrBuild.indexOf("</speedScan>");

			speedRead = iniStrBuild.substring(readSpeedStart, readSpeedEnd)
					.trim();

			// System.out.println(speedRead);
			int sampleStart = iniStrBuild.indexOf("<sample>") + 8;
			int sampleEnd = iniStrBuild.indexOf("</sample>");

			sampleSt = (iniStrBuild.substring(sampleStart, sampleEnd).trim());

			int sizeStart = iniStrBuild.indexOf("<size>") + 6;
			int sizeEnd = iniStrBuild.indexOf("</size>");

			globalSize = (iniStrBuild.substring(sizeStart, sizeEnd).trim());

			int codingStart = iniStrBuild.indexOf("<coding>") + 8;
			int codingEnd = iniStrBuild.indexOf("</coding>");

			codingStatFile = (iniStrBuild.substring(codingStart, codingEnd)
					.trim());

			int progCloseStart = iniStrBuild.indexOf("<progClose>") + 11;
			int progCloseEnd = iniStrBuild.indexOf("</progClose>");

			isCloseFrameTrue = (iniStrBuild.substring(progCloseStart,
					progCloseEnd).trim());

			if (isCloseFrameTrue.equals("true")) {
				frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
			} else {
				frame.setDefaultCloseOperation(frame.DO_NOTHING_ON_CLOSE);
			}

			switch (Integer.valueOf(globalSize)) {

			case 1:
				frame.setSize(150, 80);
				fieldUser.setBounds(0, 20, 150, 30);
				fieldUser.setFont(new Font("SansSerif", Font.BOLD, 20));
				field.setBounds(0, 0, 150, 26);
				field.setFont(new Font("SansSerif", Font.BOLD, 20));
				indicator.setBounds(132, 20, 10, 10);
				break;

			case 2:
				frame.setSize(180, 95);
				fieldUser.setBounds(0, 35, 200, 35);
				fieldUser.setFont(new Font("SansSerif", Font.BOLD, 25));
				field.setBounds(0, 0, 200, 35);
				field.setFont(new Font("SansSerif", Font.BOLD, 25));
				indicator.setBounds(162, 20, 10, 10);
				break;

			case 3:
				frame.setSize(222, 110);
				fieldUser.setBounds(0, 45, 250, 40);
				fieldUser.setFont(new Font("SansSerif", Font.BOLD, 30));
				field.setBounds(0, 0, 250, 45);
				field.setFont(new Font("SansSerif", Font.BOLD, 30));
				indicator.setBounds(205, 25, 10, 10);
				break;

			case 4:
				frame.setSize(250, 130);
				fieldUser.setBounds(0, 50, 250, 50);
				fieldUser.setFont(new Font("SansSerif", Font.BOLD, 35));
				field.setBounds(0, 0, 250, 50);
				field.setFont(new Font("SansSerif", Font.BOLD, 35));
				indicator.setBounds(235, 40, 10, 10);
				break;

			case 5:
				frame.setSize(285, 130);
				fieldUser.setBounds(0, 50, 285, 52);
				fieldUser.setFont(new Font("SansSerif", Font.BOLD, 40));
				field.setBounds(0, 0, 285, 50);
				field.setFont(new Font("SansSerif", Font.BOLD, 40));
				indicator.setBounds(268, 40, 10, 10);
				break;

			case 6:
				frame.setSize(320, 140);
				fieldUser.setBounds(0, 55, 320, 58);
				fieldUser.setFont(new Font("SansSerif", Font.BOLD, 45));
				field.setBounds(0, 0, 320, 55);
				field.setFont(new Font("SansSerif", Font.BOLD, 45));
				indicator.setBounds(302, 45, 10, 10);
				break;

			case 7:
				frame.setSize(360, 145);
				fieldUser.setBounds(0, 52, 360, 70);
				fieldUser.setFont(new Font("SansSerif", Font.BOLD, 50));
				field.setBounds(0, 0, 360, 52);
				field.setFont(new Font("SansSerif", Font.BOLD, 50));
				indicator.setBounds(342, 52, 12, 12);
				break;

			case 8:
				frame.setSize(370, 160);
				fieldUser.setBounds(0, 60, 370, 80);
				fieldUser.setFont(new Font("SansSerif", Font.BOLD, 53));
				field.setBounds(0, 0, 370, 65);
				field.setFont(new Font("SansSerif", Font.BOLD, 53));
				indicator.setBounds(352, 59, 13, 13);
				break;

			case 9:
				frame.setSize(395, 180);
				fieldUser.setBounds(0, 65, 390, 100);
				fieldUser.setFont(new Font("SansSerif", Font.BOLD, 56));
				field.setBounds(0, 0, 400, 70);
				field.setFont(new Font("SansSerif", Font.BOLD, 56));
				indicator.setBounds(375, 72, 13, 13);
				break;

			case 10:
				frame.setSize(430, 200);
				fieldUser.setBounds(0, 85, 430, 85);
				fieldUser.setFont(new Font("SansSerif", Font.BOLD, 62));
				field.setBounds(0, 0, 430, 85);
				field.setFont(new Font("SansSerif", Font.BOLD, 60));
				indicator.setBounds(410, 70, 15, 15);
				break;
			}

			// Reading statistic file.
			FileInputStream fstream1 = null;
			try {
				fstream1 = new FileInputStream(pathToStat);
			} catch (FileNotFoundException e1) {
				field.setText("stat. file not found");
				field.setFont(new Font("SansSerif", Font.BOLD, 12));
				e1.printStackTrace();
			}

			DataInputStream in1 = new DataInputStream(fstream1);
			try {
				br1 = new BufferedReader(new InputStreamReader(in1,
						codingStatFile));
			} catch (UnsupportedEncodingException e1) {
				field.setText("error read stat. file");
				field.setFont(new Font("SansSerif", Font.BOLD, 12));
				e1.printStackTrace();
			}

			// Taking the length of statistic file.
			String tmpStatCount;

			try {
				while ((tmpStatCount = br1.readLine()) != null) {
					if (tmpStatCount.length() > 0) {
						countRowStat++;
					}
				}
			} catch (IOException e1) {
				field.setText("no line found in stat file");
				field.setFont(new Font("SansSerif", Font.BOLD, 12));
				e1.printStackTrace();
			}

			// inicializacia na strArr masiva za statistikata...........

			statArr = new String[countRowStat];

			FileInputStream fstream = null;
			try {
				fstream = new FileInputStream(pathToStat);
			} catch (FileNotFoundException e1) {
				field.setText("error read stat. file");
				field.setFont(new Font("SansSerif", Font.BOLD, 12));
				e1.printStackTrace();
			}
			DataInputStream in = new DataInputStream(fstream);
			try {
				br = new BufferedReader(new InputStreamReader(in,
						codingStatFile));
			} catch (UnsupportedEncodingException e1) {
				field.setText("error read stat. file");
				field.setFont(new Font("SansSerif", Font.BOLD, 12));
				e1.printStackTrace();
			}

			String tmpStat;
			y = 0;
			int a = 0;

			try {
				while ((tmpStat = br.readLine()) != null) {
					if (tmpStat.length() > 0) {
						int sta = tmpStat.indexOf(sampleSt) - start;
						int en = tmpStat.indexOf(sampleSt) - end;

						try {
							statArr[a] = tmpStat.substring(sta, en).trim();
						} catch (Exception e) {
							new Broiach();
						}

						a++;
					}
				}
			} catch (IOException e) {
				field.setText("no line found in stat file");
				field.setFont(new Font("SansSerif", Font.BOLD, 12));
				e.printStackTrace();
			}

			// Compare for equal element.
			sampleStat = statArr[countRowStat - 1];

			for (int x = statArr.length - 1; x >= 0; x--) {
				if (sampleStat.equals(statArr[x])) {
					globalCounter++;
				} else {
					new Broiach();
					break;
				}
			}
			fieldUser.setText("USER:" + sampleStat);
			field.setText(String.valueOf("БРОЙ КК=" + globalCounter));

			indicator.setBackground(Color.white);

			Thread.sleep(Integer.valueOf(speedRead) / 2);

			indicator.setBackground(Color.red);

			Thread.sleep(Integer.valueOf(speedRead) / 2);
			countRowStat = 0;
			globalCounter = 0;
			a = 0;

			try {
				in.close();
			} catch (IOException e) {
				field.setText("can't close stream");
				field.setFont(new Font("SansSerif", Font.BOLD, 12));
				e.printStackTrace();
			}
			try {
				br.close();
			} catch (IOException e) {
				field.setText("can't close stream");
				field.setFont(new Font("SansSerif", Font.BOLD, 12));
				e.printStackTrace();
			}

		}

	}

}
