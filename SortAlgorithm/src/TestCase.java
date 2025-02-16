import java.time.LocalDateTime;

public class TestCase{
    LocalDateTime dateTime;
    Integer tableId;

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
