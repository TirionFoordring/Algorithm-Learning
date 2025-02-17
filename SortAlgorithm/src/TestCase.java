import java.time.LocalDateTime;

// 此文件为测试用例的类定义文件
public class TestCase{
    LocalDateTime dateTime;
    Integer tableId;

    public TestCase(){
        this.dateTime = LocalDateTime.now();
        this.tableId = -1;
    }

    public TestCase(LocalDateTime dateTime, Integer tableId){
        this.dateTime = dateTime;
        this.tableId = tableId;
    }

    public LocalDateTime getDateTime(){
        return dateTime;
    }

    public Integer getTableId(){
        return tableId;
    }

    public String show(){
        return "dateTime: " + dateTime + ", tableId: " + tableId;
    }
}
