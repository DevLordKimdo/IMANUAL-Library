package com.i.manual.excel.inport;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ExcelInportService {
	
	public void upload(MultipartFile file) throws IOException {
		
		InputStream inputStream = file.getInputStream();
		Workbook workbook = WorkbookFactory.create(inputStream);
		
		//Sheet sheet = workbook.getSheetAt(0); // 첫 번째 시트를 가져오기
		Sheet sheet = workbook.getSheet("Sheet1"); // 시트 이름으로 가져오기
		
		   workbook.close();
		inputStream.close();
		
		// 각 셀의 내용을 출력
		for (Row row : sheet) {
			for (Cell cell : row) {
				if(cell.getCellType() == CellType.NUMERIC) {				// 셀의 값이 숫자일 경우
					System.out.print(cell.getNumericCellValue() + " ");		// 셀의 값을 숫자형으로 출력
				} else if(cell.getCellType() == CellType.STRING) {			// 셀의 값이 문자열일 경우
					System.out.print(cell.getStringCellValue() + " ");		// 셀의 값을 문자열로 출력
				} else {
					System.out.print(cell.toString() + " ");				// 셀의 값을 무조건 string 값으로 출력
				}
			}
			System.out.println("");
		}
		
		// 좌표값을 출력
		for (Row row : sheet) {
			for (Cell cell : row) {
				System.out.print("(" + cell.getRowIndex() + "," + cell.getColumnIndex() + ")");
			}
			System.out.println("");
		}
		
		// DTO 배열에 집어넣기
        List<ExcelInportDTO> excelInportDTOList = new ArrayList<>();
        
        // 칼럼을 매칭 안하고 순차적으로 집어넣기.
        // 장점 : 구현이 쉬움
        // 단점 : 엑셀 작성시 무조건 기본 틀에 맞춰서 작성해야하는 문제가 있음
        for (Row row : sheet) {
        	if(row.getRowNum() > 0) {	// 엑셀에서 첫번째 행을 생략
        		ExcelInportDTO TempDTO = new ExcelInportDTO();
                for (Cell cell : row) {
                	switch(cell.getColumnIndex()) {
                		case 0: TempDTO.setIndex(cell.toString());
                		case 1: TempDTO.setName (cell.toString());
                		case 2: TempDTO.setValue(cell.toString());
                	}
                }
                excelInportDTOList.add(TempDTO);
        	}
        }
        
        // DTO 순차적으로 출력 (확인용)
        /*
        for(ExcelInportDTO TempDTO : excelInportDTOList) {
        	System.out.println(TempDTO.getIndex() + " " + TempDTO.getName() + " " + TempDTO.getValue());
        }
        */
	}

}
