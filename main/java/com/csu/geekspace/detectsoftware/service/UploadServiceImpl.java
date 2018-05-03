package com.csu.geekspace.detectsoftware.service;

import com.csu.geekspace.detectsoftware.Exception.MyException;
import com.csu.geekspace.detectsoftware.enums.OutcomeEnum;
import com.csu.geekspace.detectsoftware.mapper.PositionMapper;
import com.csu.geekspace.detectsoftware.pojo.Position;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author xuhang
 * @date 2018/4/17 18:52
 */
@Service
@Transactional
public class UploadServiceImpl implements UploadService{

    private final static Logger logger = LoggerFactory.getLogger(UploadServiceImpl.class);

    @Autowired
    private PositionMapper positionMapper;

    @Override
    public String importExcel(String filename,MultipartFile file){

        List<Position> positionList = new ArrayList<Position>();
        if(!filename.matches("^.+\\.(?i)(xls)$")&&!filename.matches("^.+\\.(?i)(xlsx)$"))
        {
            throw new MyException(OutcomeEnum.FILE_IS_NOT_EXCEL);
        }
        boolean isExcel2003 = true;
        if(filename.matches("^.+\\.(?i)(xlsx)$"))
        {
            isExcel2003 = false;
        }
        try {

            Workbook wb = null;
            if(isExcel2003)
            {
                wb = new HSSFWorkbook(file.getInputStream());
            }else
            {
                wb = new XSSFWorkbook(file.getInputStream());
            }
            Sheet sheet =wb.getSheet("sheet1");
            int rows = sheet.getLastRowNum();
            logger.info("【rows】{}",rows);
            if (rows==0){
                throw new MyException(OutcomeEnum.DATA_IS_NULL);
            }
            for (int i = 1;i<=rows+1;i++){
                Row row = sheet.getRow(i);

                if (row!=null){
                    Position position = new Position();
                    String area = row.getCell(0).getStringCellValue();
                    position.setArea(area);

                    Double line = row.getCell(1).getNumericCellValue();
                    int Line = line.intValue();
                    position.setLine(Line);

                    Double station = row.getCell(2).getNumericCellValue();
                    int Station = station.intValue();
                    position.setStation(Station);

                    Double Ax = row.getCell(3).getNumericCellValue();
                    BigDecimal ax = new BigDecimal(Ax);
                    position.setA_x(ax);

                    Double Ay = row.getCell(4).getNumericCellValue();
                    BigDecimal ay = new BigDecimal(Ay);
                    position.setA_y(ay);

                    Double Bx = row.getCell(5).getNumericCellValue();
                    BigDecimal bx = new BigDecimal(Bx);
                    position.setB_x(bx);

                    Double By = row.getCell(6).getNumericCellValue();
                    BigDecimal by = new BigDecimal(By);
                    position.setB_y(by);

                    Double Mx = row.getCell(7).getNumericCellValue();
                    BigDecimal mx = new BigDecimal(Mx);
                    position.setM_x(mx);

                    Double My = row.getCell(8).getNumericCellValue();
                    BigDecimal my = new BigDecimal(My);
                    position.setM_y(my);

                    Double Mz = row.getCell(9).getNumericCellValue();
                    BigDecimal mz = new BigDecimal(Mz);
                    position.setM_z(mz);

                    Double Nx = row.getCell(10).getNumericCellValue();
                    BigDecimal nx = new BigDecimal(Nx);
                    position.setN_x(nx);

                    Double Ny = row.getCell(11).getNumericCellValue();
                    BigDecimal ny = new BigDecimal(Ny);
                    position.setN_y(ny);

                    Double Nz = row.getCell(12).getNumericCellValue();
                    BigDecimal nz = new BigDecimal(Nz);
                    position.setN_z(nz);

                    positionList.add(position);
                }
            }
            for (Position position:positionList){

                Position positionQuery = positionMapper.selectByPrimaryKey(position);
                if (positionQuery==null){
                    positionMapper.insert(position);
                }else {
                    positionMapper.updateByPrimaryKey(position);
                }
            }return "导入成功";
        }catch (IOException e){
            return "导入出错！请检查数据格式！";
        }


    }
}
