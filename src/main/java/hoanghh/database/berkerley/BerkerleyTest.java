package hoanghh.database.berkerley;

public class BerkerleyTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BerkeleyDB db = new BerkeleyDB("data/database", "test");
        db.insertDB("id1", "hoang");
        db.insertDB("id2", "timg");
        if (!db.checkKey("id1")) {
            db.insertDB("id1", "so nao do");
        }
        
        System.out.println(db.getAllRecords().toString());
        db.close();
    }

}
