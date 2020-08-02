package com.xiaopotian.Controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zouLu on 2017-12-14.
 */
@RestController
public class ExcelController {
    @RequestMapping(value = "/excel", method = RequestMethod.GET)
    public void excel(HttpServletResponse response) throws Exception {
        ExcelData data = new ExcelData();
        data.setName("okr");
        List<String> titles = new ArrayList();
        titles.add("目标");
        data.setTitles(titles);

        List<List<Object>> rows = new ArrayList();
        List<Object> row = new ArrayList();
        row.add("");
        row.add("负责人");
        row.add("起止日期");
        row.add("进度");
        rows.add(row);
        for (int i = 0; i < 3; i++) {
            List<Object> row2 = new ArrayList();
            row2.add("kr" + String.valueOf(i +1));
            row2.add("牛子健");
            row2.add("起止日期");
            row2.add("进度");
            rows.add(row2);
        }
        data.setRows(rows);


        //生成本地
        /*File f = new File("c:/test.xlsx");
        FileOutputStream out = new FileOutputStream(f);
        ExportExcelUtils.exportExcel(data, out);
        out.close();*/
        ExportExcelUtils.exportExcel(response,"hello.xlsx",data);
    }
}
