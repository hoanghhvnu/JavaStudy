package hoanghh.database.berkerley;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.LinkedHashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sleepycat.bind.tuple.IntegerBinding;
import com.sleepycat.bind.tuple.StringBinding;
import com.sleepycat.je.Cursor;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.LockMode;
import com.sleepycat.je.OperationStatus;

public class BerkeleyDB {
	static Logger logger = LoggerFactory.getLogger(BerkeleyDB.class);
	private Database myDatabase;
	private Environment myDbEnvironment;
	private Cursor cursor;

	public BerkeleyDB(String path, String nameDB) {
		// Open the environment, creating one if it does not exist
		EnvironmentConfig envConfig = new EnvironmentConfig();
		envConfig.setAllowCreate(true);
		String newPath = path + File.separator + nameDB;
		// String newPath = path + File.separator + nameDB + File.separator +
		// DateUtils.getTodayPath();
		File file = new File(newPath);
		file.mkdirs();
		// file.getParentFile().mkdirs();
		// Open and create the DB environment using config
		this.myDbEnvironment = new Environment(new File(newPath), envConfig);
		// Open the database, creating one if it does not exist
		DatabaseConfig dbConfig = new DatabaseConfig();
		dbConfig.setAllowCreate(true);
		this.myDatabase = this.myDbEnvironment.openDatabase(null, nameDB,
				dbConfig);
	}

	   /**
     * Insert data to database.
     * Override data if ket already exist
     * @param key
     * @param value
     */
	public void insertDB(int key, String value) {
		try {
			DatabaseEntry theKey = new DatabaseEntry();			
			IntegerBinding.intToEntry(key, theKey);
			DatabaseEntry theData = new DatabaseEntry(value.getBytes("UTF-8"));
			this.myDatabase.put(null, theKey, theData);
		} catch (Exception e) {
			logger.error("Exception: ", e);
		}
	}
	
	/**
	 * Insert data to database.
	 * Override data if ket already exist
	 * @param key
	 * @param value
	 */
	public void insertDB(String key, String value) {
		try {
			DatabaseEntry theKey = new DatabaseEntry();
			StringBinding.stringToEntry(key, theKey);
			DatabaseEntry theData = new DatabaseEntry(value.getBytes("UTF-8"));
			this.myDatabase.put(null, theKey, theData);
		} catch (Exception e) {
			logger.error("Exception: ", e);
		}
	}

	public void close() {
		try {
			if (this.myDatabase != null) {
				this.myDatabase.close();
			}
			if (this.myDbEnvironment != null) {
				this.myDbEnvironment.close();
			}
		} catch (DatabaseException dbe) {
			logger.error("Exception: ", dbe);
		}
	}

	   /**
     * Check key exist in db
     * @param key
     * @return True if exist
     */
	public boolean checkKey(int key) {
		try {
			DatabaseEntry theKey = new DatabaseEntry();
			IntegerBinding.intToEntry(key, theKey);
			DatabaseEntry theData = new DatabaseEntry();
			// Call get() to query the database
			if (this.myDatabase.get(null, theKey, theData, LockMode.DEFAULT) == OperationStatus.SUCCESS) {
				return true;
			}
		} catch (Exception e) {
			//
			logger.error("Exception: ", e);
		}
		return false;
	}
	
	/**
	 * Check key exist in db
	 * @param key
	 * @return True if exist
	 */
	public boolean checkKey(String key) {
		try {
			DatabaseEntry theKey = new DatabaseEntry();
			//IntegerBinding.intToEntry(key, theKey);
			StringBinding.stringToEntry(key, theKey);
			DatabaseEntry theData = new DatabaseEntry();
			// Call get() to query the database
			if (this.myDatabase.get(null, theKey, theData, LockMode.DEFAULT) == OperationStatus.SUCCESS) {
				return true;
			}
		} catch (Exception e) {
			//
			logger.error("Exception: ", e);
		}
		return false;
	}

	public Set<String> getAllRecords() {
		Set<String> result = new LinkedHashSet<>();
		this.cursor = null;
		try {
			// Open the cursor.
			this.cursor = this.myDatabase.openCursor(null, null);
			DatabaseEntry foundKey = new DatabaseEntry();
			DatabaseEntry foundData = new DatabaseEntry();
			// Iterate from the last record to the first in the database
			while (this.cursor.getPrev(foundKey, foundData, LockMode.DEFAULT) == OperationStatus.SUCCESS) {
				byte[] retData = foundData.getData();
				String url = new String(retData, "UTF-8");
				result.add(url);
			}
		} catch (DatabaseException | UnsupportedEncodingException de) {
			logger.error("Exception: ", de);
		} finally {
			this.cursor.close();
		}
		return result;
	}

	public void delete(int key){
		DatabaseEntry theKey = new DatabaseEntry();
		IntegerBinding.intToEntry(key, theKey);
		this.myDatabase.delete(null, theKey);	
	}
	
	public void delete(String key){
		DatabaseEntry theKey = new DatabaseEntry(key.getBytes());
		this.myDatabase.delete(null, theKey);	
	}
	
	public void deleteTop(int top){
		this.cursor = null;
		try {
			this.cursor = this.myDatabase.openCursor(null, null);
			DatabaseEntry foundKey = new DatabaseEntry();
			DatabaseEntry foundData = new DatabaseEntry();
			int index = 0;
			while (this.cursor.getNext(foundKey, foundData, LockMode.DEFAULT) == OperationStatus.SUCCESS) {
				this.myDatabase.delete(null, foundKey);
				index++;
				if(index == top){
					break;
				}
			}
		} catch (DatabaseException de) {
			logger.error("Exception: ", de);
		} finally {
			this.cursor.close();
		}
		
	}
	
	public Set<String> getAllRecords(int top) {
		Set<String> result = new LinkedHashSet<>();
		this.cursor = null;
		try {
			this.cursor = this.myDatabase.openCursor(null, null);
			DatabaseEntry foundKey = new DatabaseEntry();
			DatabaseEntry foundData = new DatabaseEntry();
			int index = 0;
			while (this.cursor.getPrev(foundKey, foundData, LockMode.DEFAULT) == OperationStatus.SUCCESS) {
				byte[] retData = foundData.getData();
				String url = new String(retData, "UTF-8");
				result.add(url);
				index++;
				if(index == top){
					break;
				}
			}
		} catch (DatabaseException | UnsupportedEncodingException de) {
			logger.error("Exception: ", de);
		} finally {
			this.cursor.close();
		}
		return result;
	}
}