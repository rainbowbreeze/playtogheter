package it.rainbowbreeze.playtog.data.provider.player;

import android.net.Uri;
import android.provider.BaseColumns;

import it.rainbowbreeze.playtog.data.provider.PlayerProvider;

/**
 * Columns for the {@code player} table.
 */
public class PlayerColumns implements BaseColumns {
    public static final String TABLE_NAME = "player";
    public static final Uri CONTENT_URI = Uri.parse(PlayerProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    public static final String _ID = new String(BaseColumns._ID);
    public static final String PHOTOURL = new String("photourl");
    public static final String NAME = new String("name");
    public static final String SOCIALID = new String("socialid");
    public static final String BACKENDID = new String("backendid");

    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;
    
    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            PHOTOURL,
            NAME,
            SOCIALID,
            BACKENDID
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c == _ID) return true;
            if (c == PHOTOURL) return true;
            if (c == NAME) return true;
            if (c == SOCIALID) return true;
            if (c == BACKENDID) return true;
        }
        return false;
    }

    public static String getQualifiedColumnName(String columnName) {
        if (columnName == _ID) return TABLE_NAME + "." + columnName + " AS " + _ID;
        if (columnName == PHOTOURL) return TABLE_NAME + "." + columnName + " AS " + TABLE_NAME + "__" + columnName;
        if (columnName == NAME) return TABLE_NAME + "." + columnName + " AS " + TABLE_NAME + "__" + columnName;
        if (columnName == SOCIALID) return TABLE_NAME + "." + columnName + " AS " + TABLE_NAME + "__" + columnName;
        if (columnName == BACKENDID) return TABLE_NAME + "." + columnName + " AS " + TABLE_NAME + "__" + columnName;
        return null;
    }

    public static String getAlias(String columnName) {
        if (columnName == PHOTOURL) return TABLE_NAME + "__" + columnName;
        if (columnName == NAME) return TABLE_NAME + "__" + columnName;
        if (columnName == SOCIALID) return TABLE_NAME + "__" + columnName;
        if (columnName == BACKENDID) return TABLE_NAME + "__" + columnName;
        return null;
    }
}