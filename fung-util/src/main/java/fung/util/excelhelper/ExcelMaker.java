package fung.util.excelhelper;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class ExcelMaker {

    public <T> void make(File file, List<T> data) throws ExcelMakeException {
        try(OutputStream out = new FileOutputStream(file)) {
            make(out, data);
        } catch (FileNotFoundException e) {
            throw new ExcelMakeException("文件不存在：" + file.getName(), e);
        } catch (IOException e) {
            throw new ExcelMakeException("文件写入出错：" + file.getName(), e);
        }

    }

    public <T> void make(OutputStream out, List<T> data) throws IOException, ExcelMakeException {

        HSSFWorkbook workbook = new HSSFWorkbook();

        new ExcelMakerDelegate<>(workbook, data).make();

        workbook.write(out);
    }

}
