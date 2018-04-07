package fung.util.excelhelper;

import java.io.*;
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

    public <T> void make(OutputStream out, List<T> data) {
        
    }

}
