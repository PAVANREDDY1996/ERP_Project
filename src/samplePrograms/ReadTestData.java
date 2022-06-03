package samplePrograms;

import java.io.IOException;

public class ReadTestData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ReadDataExcel rd = new ReadDataExcel();
		
		try {
			rd.ReadData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
