package com.example.android.persistence.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.util.DBUtil;
import androidx.room.util.FtsTableInfo;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.example.android.persistence.db.dao.CommentDao;
import com.example.android.persistence.db.dao.CommentDao_Impl;
import com.example.android.persistence.db.dao.ProductDao;
import com.example.android.persistence.db.dao.ProductDao_Impl;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile ProductDao _productDao;

  private volatile CommentDao _commentDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `products` (`id` INTEGER NOT NULL, `name` TEXT, `description` TEXT, `price` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE VIRTUAL TABLE IF NOT EXISTS `productsFts` USING FTS4(`name` TEXT, `description` TEXT, content=`products`)");
        _db.execSQL("CREATE TRIGGER IF NOT EXISTS room_fts_content_sync_productsFts_BEFORE_UPDATE BEFORE UPDATE ON `products` BEGIN DELETE FROM `productsFts` WHERE `docid`=OLD.`rowid`; END");
        _db.execSQL("CREATE TRIGGER IF NOT EXISTS room_fts_content_sync_productsFts_BEFORE_DELETE BEFORE DELETE ON `products` BEGIN DELETE FROM `productsFts` WHERE `docid`=OLD.`rowid`; END");
        _db.execSQL("CREATE TRIGGER IF NOT EXISTS room_fts_content_sync_productsFts_AFTER_UPDATE AFTER UPDATE ON `products` BEGIN INSERT INTO `productsFts`(`docid`, `name`, `description`) VALUES (NEW.`rowid`, NEW.`name`, NEW.`description`); END");
        _db.execSQL("CREATE TRIGGER IF NOT EXISTS room_fts_content_sync_productsFts_AFTER_INSERT AFTER INSERT ON `products` BEGIN INSERT INTO `productsFts`(`docid`, `name`, `description`) VALUES (NEW.`rowid`, NEW.`name`, NEW.`description`); END");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `comments` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `productId` INTEGER NOT NULL, `text` TEXT, `postedAt` INTEGER, FOREIGN KEY(`productId`) REFERENCES `products`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE  INDEX `index_comments_productId` ON `comments` (`productId`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"3e1095fcd74edb0edc506f32734f3379\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `products`");
        _db.execSQL("DROP TABLE IF EXISTS `productsFts`");
        _db.execSQL("DROP TABLE IF EXISTS `comments`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        _db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TRIGGER IF NOT EXISTS room_fts_content_sync_productsFts_BEFORE_UPDATE BEFORE UPDATE ON `products` BEGIN DELETE FROM `productsFts` WHERE `docid`=OLD.`rowid`; END");
        _db.execSQL("CREATE TRIGGER IF NOT EXISTS room_fts_content_sync_productsFts_BEFORE_DELETE BEFORE DELETE ON `products` BEGIN DELETE FROM `productsFts` WHERE `docid`=OLD.`rowid`; END");
        _db.execSQL("CREATE TRIGGER IF NOT EXISTS room_fts_content_sync_productsFts_AFTER_UPDATE AFTER UPDATE ON `products` BEGIN INSERT INTO `productsFts`(`docid`, `name`, `description`) VALUES (NEW.`rowid`, NEW.`name`, NEW.`description`); END");
        _db.execSQL("CREATE TRIGGER IF NOT EXISTS room_fts_content_sync_productsFts_AFTER_INSERT AFTER INSERT ON `products` BEGIN INSERT INTO `productsFts`(`docid`, `name`, `description`) VALUES (NEW.`rowid`, NEW.`name`, NEW.`description`); END");
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsProducts = new HashMap<String, TableInfo.Column>(4);
        _columnsProducts.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsProducts.put("name", new TableInfo.Column("name", "TEXT", false, 0));
        _columnsProducts.put("description", new TableInfo.Column("description", "TEXT", false, 0));
        _columnsProducts.put("price", new TableInfo.Column("price", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysProducts = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesProducts = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoProducts = new TableInfo("products", _columnsProducts, _foreignKeysProducts, _indicesProducts);
        final TableInfo _existingProducts = TableInfo.read(_db, "products");
        if (! _infoProducts.equals(_existingProducts)) {
          throw new IllegalStateException("Migration didn't properly handle products(com.example.android.persistence.db.entity.ProductEntity).\n"
                  + " Expected:\n" + _infoProducts + "\n"
                  + " Found:\n" + _existingProducts);
        }
        final HashSet<String> _columnsProductsFts = new HashSet<String>(2);
        _columnsProductsFts.add("name");
        _columnsProductsFts.add("description");
        final FtsTableInfo _infoProductsFts = new FtsTableInfo("productsFts", _columnsProductsFts, "CREATE VIRTUAL TABLE IF NOT EXISTS `productsFts` USING FTS4(`name` TEXT, `description` TEXT, content=`products`)");
        final FtsTableInfo _existingProductsFts = FtsTableInfo.read(_db, "productsFts");
        if (!_infoProductsFts.equals(_existingProductsFts)) {
          throw new IllegalStateException("Migration didn't properly handle productsFts(com.example.android.persistence.db.entity.ProductFtsEntity).\n"
                  + " Expected:\n" + _infoProductsFts + "\n"
                  + " Found:\n" + _existingProductsFts);
        }
        final HashMap<String, TableInfo.Column> _columnsComments = new HashMap<String, TableInfo.Column>(4);
        _columnsComments.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsComments.put("productId", new TableInfo.Column("productId", "INTEGER", true, 0));
        _columnsComments.put("text", new TableInfo.Column("text", "TEXT", false, 0));
        _columnsComments.put("postedAt", new TableInfo.Column("postedAt", "INTEGER", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysComments = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysComments.add(new TableInfo.ForeignKey("products", "CASCADE", "NO ACTION",Arrays.asList("productId"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesComments = new HashSet<TableInfo.Index>(1);
        _indicesComments.add(new TableInfo.Index("index_comments_productId", false, Arrays.asList("productId")));
        final TableInfo _infoComments = new TableInfo("comments", _columnsComments, _foreignKeysComments, _indicesComments);
        final TableInfo _existingComments = TableInfo.read(_db, "comments");
        if (! _infoComments.equals(_existingComments)) {
          throw new IllegalStateException("Migration didn't properly handle comments(com.example.android.persistence.db.entity.CommentEntity).\n"
                  + " Expected:\n" + _infoComments + "\n"
                  + " Found:\n" + _existingComments);
        }
      }
    }, "3e1095fcd74edb0edc506f32734f3379", "51759d1d78cc7e57e77c16ff83f96075");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(1);
    _shadowTablesMap.put("productsFts", "products");
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "products","productsFts","comments");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `products`");
      _db.execSQL("DELETE FROM `productsFts`");
      _db.execSQL("DELETE FROM `comments`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public ProductDao productDao() {
    if (_productDao != null) {
      return _productDao;
    } else {
      synchronized(this) {
        if(_productDao == null) {
          _productDao = new ProductDao_Impl(this);
        }
        return _productDao;
      }
    }
  }

  @Override
  public CommentDao commentDao() {
    if (_commentDao != null) {
      return _commentDao;
    } else {
      synchronized(this) {
        if(_commentDao == null) {
          _commentDao = new CommentDao_Impl(this);
        }
        return _commentDao;
      }
    }
  }
}
