package com.i.manual.excel.export;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.i.manual.crud.basic.CrudBasicDTO;
import com.i.manual.crud.basic.CrudBasicRepository;
import com.i.manual.util.UtilExportExcel;

@Service
public class ExcelExportService {
	
    private final CrudBasicRepository crudBasicRepository;
    public ExcelExportService(CrudBasicRepository crudBasicRepository) {this.crudBasicRepository = crudBasicRepository;}
	
    public byte[] DownExcel() throws IOException {
        List<CrudBasicDTO> list = crudBasicRepository.list(); //DB로 데이터 가져오기

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Data");

        // 헤더 생성
        Row headerRow = sheet.createRow(0);
        String[] columns = {"Column1", "Column2", "Column3","Column4", "Column5", "Column6"}; // CrudBasicDTO의 필드에 맞게 수정
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
        }

        // 데이터 채우기
        int rowNum = 1;
        for (CrudBasicDTO dto : list) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(dto.getIdx());
            row.createCell(1).setCellValue(dto.getTitle());
            row.createCell(2).setCellValue(dto.getContent());
            row.createCell(3).setCellValue(dto.getName());
            row.createCell(4).setCellValue(dto.getDatetime());
            row.createCell(5).setCellValue(dto.getHit());
        }

        // 엑셀 파일을 바이트 배열로 변환
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();

        return outputStream.toByteArray();
    }
    
    
    // 향상된 버전. 따로 모듈화한 코드를 이용함.
    // 모듈화한 코드는 위의 하드코딩식과는 달리 어떤 DB 자료를 가져와도 출력되게끔 구조를 설계.
    // DTO에 선언된 변수값들을 자동으로 넣어줌.
    public byte[] DownExcelEnhance() throws IOException {
        List<CrudBasicDTO> list = crudBasicRepository.list();
        
        UtilExportExcel utilExportExcel = new UtilExportExcel();

        return utilExportExcel.exportToExcel(list, "Data");
    }

}
