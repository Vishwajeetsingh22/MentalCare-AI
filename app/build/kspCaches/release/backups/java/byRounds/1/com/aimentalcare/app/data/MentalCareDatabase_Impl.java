package com.aimentalcare.app.data;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class MentalCareDatabase_Impl extends MentalCareDatabase {
  private volatile CheckInDao _checkInDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `check_ins` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `timestamp` INTEGER NOT NULL, `userText` TEXT NOT NULL, `stressLevel` TEXT NOT NULL, `statusDescription` TEXT NOT NULL, `stressScore` INTEGER NOT NULL, `confidence` REAL NOT NULL, `indicatorsCsv` TEXT NOT NULL, `isCrisis` INTEGER NOT NULL, `recommendationsCsv` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `lifestyle_logs` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `timestamp` INTEGER NOT NULL, `sleepHrs` REAL NOT NULL, `workHrs` REAL NOT NULL, `screenHrs` REAL NOT NULL, `exerciseMins` INTEGER NOT NULL, `energyLevel` TEXT NOT NULL, `moodEmoji` TEXT NOT NULL, `stressScore` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `Users` (`userId` TEXT NOT NULL, `fullName` TEXT NOT NULL, `email` TEXT NOT NULL, `createdAt` INTEGER NOT NULL, PRIMARY KEY(`userId`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `StressResults` (`resultId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userId` TEXT NOT NULL, `timestamp` INTEGER NOT NULL, `stressLevel` TEXT NOT NULL, `stressScorePercent` INTEGER NOT NULL, `confidenceScore` REAL NOT NULL, `indicatorsCsv` TEXT NOT NULL, `recommendation` TEXT NOT NULL, `isBurnoutPattern` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `TrustedContacts` (`contactId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userId` TEXT NOT NULL, `contactName` TEXT NOT NULL, `contactPhone` TEXT NOT NULL, `relationship` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '6409ec0f489f92cfee202643966d70f1')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `check_ins`");
        db.execSQL("DROP TABLE IF EXISTS `lifestyle_logs`");
        db.execSQL("DROP TABLE IF EXISTS `Users`");
        db.execSQL("DROP TABLE IF EXISTS `StressResults`");
        db.execSQL("DROP TABLE IF EXISTS `TrustedContacts`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsCheckIns = new HashMap<String, TableInfo.Column>(10);
        _columnsCheckIns.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCheckIns.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCheckIns.put("userText", new TableInfo.Column("userText", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCheckIns.put("stressLevel", new TableInfo.Column("stressLevel", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCheckIns.put("statusDescription", new TableInfo.Column("statusDescription", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCheckIns.put("stressScore", new TableInfo.Column("stressScore", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCheckIns.put("confidence", new TableInfo.Column("confidence", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCheckIns.put("indicatorsCsv", new TableInfo.Column("indicatorsCsv", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCheckIns.put("isCrisis", new TableInfo.Column("isCrisis", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCheckIns.put("recommendationsCsv", new TableInfo.Column("recommendationsCsv", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCheckIns = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCheckIns = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCheckIns = new TableInfo("check_ins", _columnsCheckIns, _foreignKeysCheckIns, _indicesCheckIns);
        final TableInfo _existingCheckIns = TableInfo.read(db, "check_ins");
        if (!_infoCheckIns.equals(_existingCheckIns)) {
          return new RoomOpenHelper.ValidationResult(false, "check_ins(com.aimentalcare.app.data.CheckInEntity).\n"
                  + " Expected:\n" + _infoCheckIns + "\n"
                  + " Found:\n" + _existingCheckIns);
        }
        final HashMap<String, TableInfo.Column> _columnsLifestyleLogs = new HashMap<String, TableInfo.Column>(9);
        _columnsLifestyleLogs.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLifestyleLogs.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLifestyleLogs.put("sleepHrs", new TableInfo.Column("sleepHrs", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLifestyleLogs.put("workHrs", new TableInfo.Column("workHrs", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLifestyleLogs.put("screenHrs", new TableInfo.Column("screenHrs", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLifestyleLogs.put("exerciseMins", new TableInfo.Column("exerciseMins", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLifestyleLogs.put("energyLevel", new TableInfo.Column("energyLevel", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLifestyleLogs.put("moodEmoji", new TableInfo.Column("moodEmoji", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLifestyleLogs.put("stressScore", new TableInfo.Column("stressScore", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLifestyleLogs = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLifestyleLogs = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLifestyleLogs = new TableInfo("lifestyle_logs", _columnsLifestyleLogs, _foreignKeysLifestyleLogs, _indicesLifestyleLogs);
        final TableInfo _existingLifestyleLogs = TableInfo.read(db, "lifestyle_logs");
        if (!_infoLifestyleLogs.equals(_existingLifestyleLogs)) {
          return new RoomOpenHelper.ValidationResult(false, "lifestyle_logs(com.aimentalcare.app.data.LifestyleEntity).\n"
                  + " Expected:\n" + _infoLifestyleLogs + "\n"
                  + " Found:\n" + _existingLifestyleLogs);
        }
        final HashMap<String, TableInfo.Column> _columnsUsers = new HashMap<String, TableInfo.Column>(4);
        _columnsUsers.put("userId", new TableInfo.Column("userId", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("fullName", new TableInfo.Column("fullName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("email", new TableInfo.Column("email", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUsers = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUsers = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUsers = new TableInfo("Users", _columnsUsers, _foreignKeysUsers, _indicesUsers);
        final TableInfo _existingUsers = TableInfo.read(db, "Users");
        if (!_infoUsers.equals(_existingUsers)) {
          return new RoomOpenHelper.ValidationResult(false, "Users(com.aimentalcare.app.data.UserEntity).\n"
                  + " Expected:\n" + _infoUsers + "\n"
                  + " Found:\n" + _existingUsers);
        }
        final HashMap<String, TableInfo.Column> _columnsStressResults = new HashMap<String, TableInfo.Column>(9);
        _columnsStressResults.put("resultId", new TableInfo.Column("resultId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStressResults.put("userId", new TableInfo.Column("userId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStressResults.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStressResults.put("stressLevel", new TableInfo.Column("stressLevel", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStressResults.put("stressScorePercent", new TableInfo.Column("stressScorePercent", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStressResults.put("confidenceScore", new TableInfo.Column("confidenceScore", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStressResults.put("indicatorsCsv", new TableInfo.Column("indicatorsCsv", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStressResults.put("recommendation", new TableInfo.Column("recommendation", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStressResults.put("isBurnoutPattern", new TableInfo.Column("isBurnoutPattern", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysStressResults = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesStressResults = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoStressResults = new TableInfo("StressResults", _columnsStressResults, _foreignKeysStressResults, _indicesStressResults);
        final TableInfo _existingStressResults = TableInfo.read(db, "StressResults");
        if (!_infoStressResults.equals(_existingStressResults)) {
          return new RoomOpenHelper.ValidationResult(false, "StressResults(com.aimentalcare.app.data.StressResultEntity).\n"
                  + " Expected:\n" + _infoStressResults + "\n"
                  + " Found:\n" + _existingStressResults);
        }
        final HashMap<String, TableInfo.Column> _columnsTrustedContacts = new HashMap<String, TableInfo.Column>(5);
        _columnsTrustedContacts.put("contactId", new TableInfo.Column("contactId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTrustedContacts.put("userId", new TableInfo.Column("userId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTrustedContacts.put("contactName", new TableInfo.Column("contactName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTrustedContacts.put("contactPhone", new TableInfo.Column("contactPhone", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTrustedContacts.put("relationship", new TableInfo.Column("relationship", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTrustedContacts = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTrustedContacts = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTrustedContacts = new TableInfo("TrustedContacts", _columnsTrustedContacts, _foreignKeysTrustedContacts, _indicesTrustedContacts);
        final TableInfo _existingTrustedContacts = TableInfo.read(db, "TrustedContacts");
        if (!_infoTrustedContacts.equals(_existingTrustedContacts)) {
          return new RoomOpenHelper.ValidationResult(false, "TrustedContacts(com.aimentalcare.app.data.TrustedContactEntity).\n"
                  + " Expected:\n" + _infoTrustedContacts + "\n"
                  + " Found:\n" + _existingTrustedContacts);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "6409ec0f489f92cfee202643966d70f1", "aa839a5c7d6f14352884778c77c905b8");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "check_ins","lifestyle_logs","Users","StressResults","TrustedContacts");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `check_ins`");
      _db.execSQL("DELETE FROM `lifestyle_logs`");
      _db.execSQL("DELETE FROM `Users`");
      _db.execSQL("DELETE FROM `StressResults`");
      _db.execSQL("DELETE FROM `TrustedContacts`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(CheckInDao.class, CheckInDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public CheckInDao checkInDao() {
    if (_checkInDao != null) {
      return _checkInDao;
    } else {
      synchronized(this) {
        if(_checkInDao == null) {
          _checkInDao = new CheckInDao_Impl(this);
        }
        return _checkInDao;
      }
    }
  }
}
