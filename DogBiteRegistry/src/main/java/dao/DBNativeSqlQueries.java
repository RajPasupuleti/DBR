// DBNativeSqlQueries.java
package dao;

public class DBNativeSqlQueries {
    public static final String VICTIM_DELETE = "delete from victim_details where VictimAge=?";
    public static final String VICTIM_FETCH_BY_AGE = "select * from victim_details where VictimAge=?";
    public static final String VICTIM_FETCH_ALL = "select * from victim_details";
    public static final String VICTIM_FETCH_BY_DOG_BREED = "select * from victim_details where DogBreed=?";
    public static final String VICTIM_ADD = "insert into victim_details(VictimName, VictimAge, DogBreed, VaccinatedStatus, VictimAddress) values(?,?,?,?,?)";
    public static final String VICTIM_UPDATE = "update victim_details set VictimAddress=? where VictimAge=?";
	public static final String ADDRESS_FETCH_ALL = null;
}
