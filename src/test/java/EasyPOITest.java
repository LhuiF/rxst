//import lombok.Data;
//import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.IOUtils;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.jeecgframework.poi.excel.ExcelExportUtil;
//import org.jeecgframework.poi.excel.annotation.Excel;
//import org.jeecgframework.poi.excel.entity.ExportParams;
//import org.jeecgframework.poi.excel.entity.enmus.ExcelType;
//
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.ArrayList;
//
//public class EasyPOITest {
//    public static void main(String[] args) throws IOException {
//        ArrayList<User> list = new ArrayList<>();
//        for (int i = 0; i < 65536; i++) {
//            User user = new User();
//            user.setId(i + "");
//            user.setName("张三" + i);
//            user.setBirthday("生日" + i);
//            user.setPhone("phone" + i);
//            list.add(user);
//        }
//        ExportParams exportParams = new ExportParams("标题", "sheet1", ExcelType.XSSF);
//        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, User.class, list);
//        File file = new File("d:\\test.xlsx");
//        FileOutputStream outputStream = new FileOutputStream(file);
//        //ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        workbook.write(outputStream);
//
//    }
//
//    //@Data
//    public static class User {
//        @Excel(name="ID")
//        private String id;
//        @Excel(name="姓名")
//        private String name;
//        @Excel(name="生日")
//        private String birthday;
//        @Excel(name="电话")
//        private String phone;
//
//        public String getId() {
//            return id;
//        }
//
//        public void setId(String id) {
//            this.id = id;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public String getBirthday() {
//            return birthday;
//        }
//
//        public void setBirthday(String birthday) {
//            this.birthday = birthday;
//        }
//
//        public String getPhone() {
//            return phone;
//        }
//
//        public void setPhone(String phone) {
//            this.phone = phone;
//        }
//    }
//}
