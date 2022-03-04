package ui.objects;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class UserForm {

    private int ID;
    private String zip;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String title;
    private String mobile;
    private String dob;
    private String password;
    private String address;
    private String country;
    private String company;
    private String state;
    private String city;
    private String f = new File("users.xlsx").getAbsolutePath();
    private File file = new File(f.substring(0, f.length() - "users.xlsx".length()) + "src/test/resources/xlsx/users.xlsx");

    public UserForm(int ID) {
        this.ID = ID;
        parse(ID);
    }

    private void parse(int idRow) {
        FileInputStream inputStream = null;
        try {

            inputStream = new FileInputStream(file);

            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet firstSheet = workbook.getSheetAt(0);

            Row getRow = firstSheet.getRow(idRow);

            Iterator<Cell> cellIterator = getRow.cellIterator();

            int i = 0;

            while (cellIterator.hasNext()) {

                Cell cell = cellIterator.next();

                String c = "";
                switch (cell.getCellType()) {
                    case NUMERIC:
                        c = String.valueOf(cell.getNumericCellValue());
                        break;
                    case STRING:
                        c = cell.getStringCellValue();
                        break;
                }

                if (i != 0) {
                    switch (i) {
                        case 1:
                            title = c;
                            break;
                        case 2:
                            userName = c;
                            break;
                        case 3:
                            email = c;
                            break;
                        case 4:
                            password = c;
                            break;
                        case 5:
                            dob = c;
                            break;
                        case 6:
                            firstName = c;
                            break;
                        case 7:
                            lastName = c;
                            break;
                        case 8:
                            company = c;
                            break;
                        case 9:
                            address = c;
                            break;
                        case 10:
                            state = c;
                            break;
                        case 11:
                            city = c;
                            break;
                        case 12:
                            country = c;
                            break;
                        case 13:
                            zip = c;
                            break;
                        case 14:
                            mobile = c;
                            break;
                    }
                }
                i++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPassword() {
        return password;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getZip() {
        return zip;
    }

    public String getUserName() {
        return userName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getTitle() {
        return title;
    }

    public String getMobile() {
        return mobile;
    }

    public String getDob() {
        return dob;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
