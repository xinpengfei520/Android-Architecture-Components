package com.example.android.persistence.db.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.android.persistence.db.converter.DateConverter;
import com.example.android.persistence.db.entity.CommentEntity;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CommentDao_Impl implements CommentDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfCommentEntity;

  public CommentDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCommentEntity = new EntityInsertionAdapter<CommentEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `comments`(`id`,`productId`,`text`,`postedAt`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CommentEntity value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getProductId());
        if (value.getText() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getText());
        }
        final Long _tmp;
        _tmp = DateConverter.toTimestamp(value.getPostedAt());
        if (_tmp == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, _tmp);
        }
      }
    };
  }

  @Override
  public void insertAll(final List<CommentEntity> comments) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCommentEntity.insert(comments);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<CommentEntity>> loadComments(final int productId) {
    final String _sql = "SELECT * FROM comments where productId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, productId);
    return __db.getInvalidationTracker().createLiveData(new String[]{"comments"}, false, new Callable<List<CommentEntity>>() {
      @Override
      public List<CommentEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfProductId = CursorUtil.getColumnIndexOrThrow(_cursor, "productId");
          final int _cursorIndexOfText = CursorUtil.getColumnIndexOrThrow(_cursor, "text");
          final int _cursorIndexOfPostedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "postedAt");
          final List<CommentEntity> _result = new ArrayList<CommentEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final CommentEntity _item;
            _item = new CommentEntity();
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            final int _tmpProductId;
            _tmpProductId = _cursor.getInt(_cursorIndexOfProductId);
            _item.setProductId(_tmpProductId);
            final String _tmpText;
            _tmpText = _cursor.getString(_cursorIndexOfText);
            _item.setText(_tmpText);
            final Date _tmpPostedAt;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfPostedAt)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfPostedAt);
            }
            _tmpPostedAt = DateConverter.toDate(_tmp);
            _item.setPostedAt(_tmpPostedAt);
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
  public List<CommentEntity> loadCommentsSync(final int productId) {
    final String _sql = "SELECT * FROM comments where productId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, productId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfProductId = CursorUtil.getColumnIndexOrThrow(_cursor, "productId");
      final int _cursorIndexOfText = CursorUtil.getColumnIndexOrThrow(_cursor, "text");
      final int _cursorIndexOfPostedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "postedAt");
      final List<CommentEntity> _result = new ArrayList<CommentEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final CommentEntity _item;
        _item = new CommentEntity();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final int _tmpProductId;
        _tmpProductId = _cursor.getInt(_cursorIndexOfProductId);
        _item.setProductId(_tmpProductId);
        final String _tmpText;
        _tmpText = _cursor.getString(_cursorIndexOfText);
        _item.setText(_tmpText);
        final Date _tmpPostedAt;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfPostedAt)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfPostedAt);
        }
        _tmpPostedAt = DateConverter.toDate(_tmp);
        _item.setPostedAt(_tmpPostedAt);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
