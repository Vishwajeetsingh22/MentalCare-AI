package com.aimentalcare.app.data;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class CheckInDao_Impl implements CheckInDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<CheckInEntity> __insertionAdapterOfCheckInEntity;

  private final EntityInsertionAdapter<StressResultEntity> __insertionAdapterOfStressResultEntity;

  private final EntityInsertionAdapter<LifestyleEntity> __insertionAdapterOfLifestyleEntity;

  private final EntityInsertionAdapter<TrustedContactEntity> __insertionAdapterOfTrustedContactEntity;

  public CheckInDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCheckInEntity = new EntityInsertionAdapter<CheckInEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `check_ins` (`id`,`timestamp`,`userText`,`stressLevel`,`statusDescription`,`stressScore`,`confidence`,`indicatorsCsv`,`isCrisis`,`recommendationsCsv`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final CheckInEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getTimestamp());
        statement.bindString(3, entity.getUserText());
        statement.bindString(4, entity.getStressLevel());
        statement.bindString(5, entity.getStatusDescription());
        statement.bindLong(6, entity.getStressScore());
        statement.bindDouble(7, entity.getConfidence());
        statement.bindString(8, entity.getIndicatorsCsv());
        final int _tmp = entity.isCrisis() ? 1 : 0;
        statement.bindLong(9, _tmp);
        statement.bindString(10, entity.getRecommendationsCsv());
      }
    };
    this.__insertionAdapterOfStressResultEntity = new EntityInsertionAdapter<StressResultEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `StressResults` (`resultId`,`userId`,`timestamp`,`stressLevel`,`stressScorePercent`,`confidenceScore`,`indicatorsCsv`,`recommendation`,`isBurnoutPattern`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final StressResultEntity entity) {
        statement.bindLong(1, entity.getResultId());
        statement.bindString(2, entity.getUserId());
        statement.bindLong(3, entity.getTimestamp());
        statement.bindString(4, entity.getStressLevel());
        statement.bindLong(5, entity.getStressScorePercent());
        statement.bindDouble(6, entity.getConfidenceScore());
        statement.bindString(7, entity.getIndicatorsCsv());
        statement.bindString(8, entity.getRecommendation());
        final int _tmp = entity.isBurnoutPattern() ? 1 : 0;
        statement.bindLong(9, _tmp);
      }
    };
    this.__insertionAdapterOfLifestyleEntity = new EntityInsertionAdapter<LifestyleEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `lifestyle_logs` (`id`,`timestamp`,`sleepHrs`,`workHrs`,`screenHrs`,`exerciseMins`,`energyLevel`,`moodEmoji`,`stressScore`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final LifestyleEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getTimestamp());
        statement.bindDouble(3, entity.getSleepHrs());
        statement.bindDouble(4, entity.getWorkHrs());
        statement.bindDouble(5, entity.getScreenHrs());
        statement.bindLong(6, entity.getExerciseMins());
        statement.bindString(7, entity.getEnergyLevel());
        statement.bindString(8, entity.getMoodEmoji());
        statement.bindLong(9, entity.getStressScore());
      }
    };
    this.__insertionAdapterOfTrustedContactEntity = new EntityInsertionAdapter<TrustedContactEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `TrustedContacts` (`contactId`,`userId`,`contactName`,`contactPhone`,`relationship`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final TrustedContactEntity entity) {
        statement.bindLong(1, entity.getContactId());
        statement.bindString(2, entity.getUserId());
        statement.bindString(3, entity.getContactName());
        statement.bindString(4, entity.getContactPhone());
        statement.bindString(5, entity.getRelationship());
      }
    };
  }

  @Override
  public Object insertCheckIn(final CheckInEntity checkIn,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfCheckInEntity.insertAndReturnId(checkIn);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertStressResult(final StressResultEntity result,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfStressResultEntity.insertAndReturnId(result);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertLifestyle(final LifestyleEntity log,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfLifestyleEntity.insertAndReturnId(log);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertTrustedContact(final TrustedContactEntity contact,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfTrustedContactEntity.insertAndReturnId(contact);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<List<CheckInEntity>> getAllCheckIns() {
    final String _sql = "SELECT * FROM check_ins ORDER BY timestamp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"check_ins"}, false, new Callable<List<CheckInEntity>>() {
      @Override
      @Nullable
      public List<CheckInEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfUserText = CursorUtil.getColumnIndexOrThrow(_cursor, "userText");
          final int _cursorIndexOfStressLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "stressLevel");
          final int _cursorIndexOfStatusDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "statusDescription");
          final int _cursorIndexOfStressScore = CursorUtil.getColumnIndexOrThrow(_cursor, "stressScore");
          final int _cursorIndexOfConfidence = CursorUtil.getColumnIndexOrThrow(_cursor, "confidence");
          final int _cursorIndexOfIndicatorsCsv = CursorUtil.getColumnIndexOrThrow(_cursor, "indicatorsCsv");
          final int _cursorIndexOfIsCrisis = CursorUtil.getColumnIndexOrThrow(_cursor, "isCrisis");
          final int _cursorIndexOfRecommendationsCsv = CursorUtil.getColumnIndexOrThrow(_cursor, "recommendationsCsv");
          final List<CheckInEntity> _result = new ArrayList<CheckInEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final CheckInEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final String _tmpUserText;
            _tmpUserText = _cursor.getString(_cursorIndexOfUserText);
            final String _tmpStressLevel;
            _tmpStressLevel = _cursor.getString(_cursorIndexOfStressLevel);
            final String _tmpStatusDescription;
            _tmpStatusDescription = _cursor.getString(_cursorIndexOfStatusDescription);
            final int _tmpStressScore;
            _tmpStressScore = _cursor.getInt(_cursorIndexOfStressScore);
            final double _tmpConfidence;
            _tmpConfidence = _cursor.getDouble(_cursorIndexOfConfidence);
            final String _tmpIndicatorsCsv;
            _tmpIndicatorsCsv = _cursor.getString(_cursorIndexOfIndicatorsCsv);
            final boolean _tmpIsCrisis;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsCrisis);
            _tmpIsCrisis = _tmp != 0;
            final String _tmpRecommendationsCsv;
            _tmpRecommendationsCsv = _cursor.getString(_cursorIndexOfRecommendationsCsv);
            _item = new CheckInEntity(_tmpId,_tmpTimestamp,_tmpUserText,_tmpStressLevel,_tmpStatusDescription,_tmpStressScore,_tmpConfidence,_tmpIndicatorsCsv,_tmpIsCrisis,_tmpRecommendationsCsv);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getRecentCheckIns(final Continuation<? super List<CheckInEntity>> $completion) {
    final String _sql = "SELECT * FROM check_ins ORDER BY timestamp DESC LIMIT 7";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<CheckInEntity>>() {
      @Override
      @NonNull
      public List<CheckInEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfUserText = CursorUtil.getColumnIndexOrThrow(_cursor, "userText");
          final int _cursorIndexOfStressLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "stressLevel");
          final int _cursorIndexOfStatusDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "statusDescription");
          final int _cursorIndexOfStressScore = CursorUtil.getColumnIndexOrThrow(_cursor, "stressScore");
          final int _cursorIndexOfConfidence = CursorUtil.getColumnIndexOrThrow(_cursor, "confidence");
          final int _cursorIndexOfIndicatorsCsv = CursorUtil.getColumnIndexOrThrow(_cursor, "indicatorsCsv");
          final int _cursorIndexOfIsCrisis = CursorUtil.getColumnIndexOrThrow(_cursor, "isCrisis");
          final int _cursorIndexOfRecommendationsCsv = CursorUtil.getColumnIndexOrThrow(_cursor, "recommendationsCsv");
          final List<CheckInEntity> _result = new ArrayList<CheckInEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final CheckInEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final String _tmpUserText;
            _tmpUserText = _cursor.getString(_cursorIndexOfUserText);
            final String _tmpStressLevel;
            _tmpStressLevel = _cursor.getString(_cursorIndexOfStressLevel);
            final String _tmpStatusDescription;
            _tmpStatusDescription = _cursor.getString(_cursorIndexOfStatusDescription);
            final int _tmpStressScore;
            _tmpStressScore = _cursor.getInt(_cursorIndexOfStressScore);
            final double _tmpConfidence;
            _tmpConfidence = _cursor.getDouble(_cursorIndexOfConfidence);
            final String _tmpIndicatorsCsv;
            _tmpIndicatorsCsv = _cursor.getString(_cursorIndexOfIndicatorsCsv);
            final boolean _tmpIsCrisis;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsCrisis);
            _tmpIsCrisis = _tmp != 0;
            final String _tmpRecommendationsCsv;
            _tmpRecommendationsCsv = _cursor.getString(_cursorIndexOfRecommendationsCsv);
            _item = new CheckInEntity(_tmpId,_tmpTimestamp,_tmpUserText,_tmpStressLevel,_tmpStatusDescription,_tmpStressScore,_tmpConfidence,_tmpIndicatorsCsv,_tmpIsCrisis,_tmpRecommendationsCsv);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<CheckInEntity> getLatestCheckIn() {
    final String _sql = "SELECT * FROM check_ins ORDER BY timestamp DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"check_ins"}, false, new Callable<CheckInEntity>() {
      @Override
      @Nullable
      public CheckInEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfUserText = CursorUtil.getColumnIndexOrThrow(_cursor, "userText");
          final int _cursorIndexOfStressLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "stressLevel");
          final int _cursorIndexOfStatusDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "statusDescription");
          final int _cursorIndexOfStressScore = CursorUtil.getColumnIndexOrThrow(_cursor, "stressScore");
          final int _cursorIndexOfConfidence = CursorUtil.getColumnIndexOrThrow(_cursor, "confidence");
          final int _cursorIndexOfIndicatorsCsv = CursorUtil.getColumnIndexOrThrow(_cursor, "indicatorsCsv");
          final int _cursorIndexOfIsCrisis = CursorUtil.getColumnIndexOrThrow(_cursor, "isCrisis");
          final int _cursorIndexOfRecommendationsCsv = CursorUtil.getColumnIndexOrThrow(_cursor, "recommendationsCsv");
          final CheckInEntity _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final String _tmpUserText;
            _tmpUserText = _cursor.getString(_cursorIndexOfUserText);
            final String _tmpStressLevel;
            _tmpStressLevel = _cursor.getString(_cursorIndexOfStressLevel);
            final String _tmpStatusDescription;
            _tmpStatusDescription = _cursor.getString(_cursorIndexOfStatusDescription);
            final int _tmpStressScore;
            _tmpStressScore = _cursor.getInt(_cursorIndexOfStressScore);
            final double _tmpConfidence;
            _tmpConfidence = _cursor.getDouble(_cursorIndexOfConfidence);
            final String _tmpIndicatorsCsv;
            _tmpIndicatorsCsv = _cursor.getString(_cursorIndexOfIndicatorsCsv);
            final boolean _tmpIsCrisis;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsCrisis);
            _tmpIsCrisis = _tmp != 0;
            final String _tmpRecommendationsCsv;
            _tmpRecommendationsCsv = _cursor.getString(_cursorIndexOfRecommendationsCsv);
            _result = new CheckInEntity(_tmpId,_tmpTimestamp,_tmpUserText,_tmpStressLevel,_tmpStatusDescription,_tmpStressScore,_tmpConfidence,_tmpIndicatorsCsv,_tmpIsCrisis,_tmpRecommendationsCsv);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<StressResultEntity>> getAllStressResults() {
    final String _sql = "SELECT * FROM StressResults ORDER BY timestamp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"StressResults"}, false, new Callable<List<StressResultEntity>>() {
      @Override
      @Nullable
      public List<StressResultEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfResultId = CursorUtil.getColumnIndexOrThrow(_cursor, "resultId");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfStressLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "stressLevel");
          final int _cursorIndexOfStressScorePercent = CursorUtil.getColumnIndexOrThrow(_cursor, "stressScorePercent");
          final int _cursorIndexOfConfidenceScore = CursorUtil.getColumnIndexOrThrow(_cursor, "confidenceScore");
          final int _cursorIndexOfIndicatorsCsv = CursorUtil.getColumnIndexOrThrow(_cursor, "indicatorsCsv");
          final int _cursorIndexOfRecommendation = CursorUtil.getColumnIndexOrThrow(_cursor, "recommendation");
          final int _cursorIndexOfIsBurnoutPattern = CursorUtil.getColumnIndexOrThrow(_cursor, "isBurnoutPattern");
          final List<StressResultEntity> _result = new ArrayList<StressResultEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final StressResultEntity _item;
            final long _tmpResultId;
            _tmpResultId = _cursor.getLong(_cursorIndexOfResultId);
            final String _tmpUserId;
            _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final String _tmpStressLevel;
            _tmpStressLevel = _cursor.getString(_cursorIndexOfStressLevel);
            final int _tmpStressScorePercent;
            _tmpStressScorePercent = _cursor.getInt(_cursorIndexOfStressScorePercent);
            final double _tmpConfidenceScore;
            _tmpConfidenceScore = _cursor.getDouble(_cursorIndexOfConfidenceScore);
            final String _tmpIndicatorsCsv;
            _tmpIndicatorsCsv = _cursor.getString(_cursorIndexOfIndicatorsCsv);
            final String _tmpRecommendation;
            _tmpRecommendation = _cursor.getString(_cursorIndexOfRecommendation);
            final boolean _tmpIsBurnoutPattern;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsBurnoutPattern);
            _tmpIsBurnoutPattern = _tmp != 0;
            _item = new StressResultEntity(_tmpResultId,_tmpUserId,_tmpTimestamp,_tmpStressLevel,_tmpStressScorePercent,_tmpConfidenceScore,_tmpIndicatorsCsv,_tmpRecommendation,_tmpIsBurnoutPattern);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<LifestyleEntity> getLatestLifestyle() {
    final String _sql = "SELECT * FROM lifestyle_logs ORDER BY timestamp DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"lifestyle_logs"}, false, new Callable<LifestyleEntity>() {
      @Override
      @Nullable
      public LifestyleEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfSleepHrs = CursorUtil.getColumnIndexOrThrow(_cursor, "sleepHrs");
          final int _cursorIndexOfWorkHrs = CursorUtil.getColumnIndexOrThrow(_cursor, "workHrs");
          final int _cursorIndexOfScreenHrs = CursorUtil.getColumnIndexOrThrow(_cursor, "screenHrs");
          final int _cursorIndexOfExerciseMins = CursorUtil.getColumnIndexOrThrow(_cursor, "exerciseMins");
          final int _cursorIndexOfEnergyLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "energyLevel");
          final int _cursorIndexOfMoodEmoji = CursorUtil.getColumnIndexOrThrow(_cursor, "moodEmoji");
          final int _cursorIndexOfStressScore = CursorUtil.getColumnIndexOrThrow(_cursor, "stressScore");
          final LifestyleEntity _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final float _tmpSleepHrs;
            _tmpSleepHrs = _cursor.getFloat(_cursorIndexOfSleepHrs);
            final float _tmpWorkHrs;
            _tmpWorkHrs = _cursor.getFloat(_cursorIndexOfWorkHrs);
            final float _tmpScreenHrs;
            _tmpScreenHrs = _cursor.getFloat(_cursorIndexOfScreenHrs);
            final int _tmpExerciseMins;
            _tmpExerciseMins = _cursor.getInt(_cursorIndexOfExerciseMins);
            final String _tmpEnergyLevel;
            _tmpEnergyLevel = _cursor.getString(_cursorIndexOfEnergyLevel);
            final String _tmpMoodEmoji;
            _tmpMoodEmoji = _cursor.getString(_cursorIndexOfMoodEmoji);
            final int _tmpStressScore;
            _tmpStressScore = _cursor.getInt(_cursorIndexOfStressScore);
            _result = new LifestyleEntity(_tmpId,_tmpTimestamp,_tmpSleepHrs,_tmpWorkHrs,_tmpScreenHrs,_tmpExerciseMins,_tmpEnergyLevel,_tmpMoodEmoji,_tmpStressScore);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<TrustedContactEntity> getTrustedContact() {
    final String _sql = "SELECT * FROM TrustedContacts LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"TrustedContacts"}, false, new Callable<TrustedContactEntity>() {
      @Override
      @Nullable
      public TrustedContactEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfContactId = CursorUtil.getColumnIndexOrThrow(_cursor, "contactId");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfContactName = CursorUtil.getColumnIndexOrThrow(_cursor, "contactName");
          final int _cursorIndexOfContactPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "contactPhone");
          final int _cursorIndexOfRelationship = CursorUtil.getColumnIndexOrThrow(_cursor, "relationship");
          final TrustedContactEntity _result;
          if (_cursor.moveToFirst()) {
            final long _tmpContactId;
            _tmpContactId = _cursor.getLong(_cursorIndexOfContactId);
            final String _tmpUserId;
            _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            final String _tmpContactName;
            _tmpContactName = _cursor.getString(_cursorIndexOfContactName);
            final String _tmpContactPhone;
            _tmpContactPhone = _cursor.getString(_cursorIndexOfContactPhone);
            final String _tmpRelationship;
            _tmpRelationship = _cursor.getString(_cursorIndexOfRelationship);
            _result = new TrustedContactEntity(_tmpContactId,_tmpUserId,_tmpContactName,_tmpContactPhone,_tmpRelationship);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
