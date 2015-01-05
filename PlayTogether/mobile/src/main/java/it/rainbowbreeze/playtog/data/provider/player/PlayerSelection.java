package it.rainbowbreeze.playtog.data.provider.player;

import java.util.Date;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import it.rainbowbreeze.playtog.data.provider.base.AbstractSelection;

/**
 * Selection for the {@code player} table.
 */
public class PlayerSelection extends AbstractSelection<PlayerSelection> {
    @Override
    public Uri uri() {
        return PlayerColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @param sortOrder How to order the rows, formatted as an SQL ORDER BY clause (excluding the ORDER BY itself). Passing null will use the default sort
     *            order, which may be unordered.
     * @return A {@code PlayerCursor} object, which is positioned before the first entry, or null.
     */
    public PlayerCursor query(ContentResolver contentResolver, String[] projection, String sortOrder) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), sortOrder);
        if (cursor == null) return null;
        return new PlayerCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, projection, null}.
     */
    public PlayerCursor query(ContentResolver contentResolver, String[] projection) {
        return query(contentResolver, projection, null);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, projection, null, null}.
     */
    public PlayerCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null, null);
    }


    public PlayerSelection id(long... value) {
        addEquals("player." + PlayerColumns._ID, toObjectArray(value));
        return this;
    }


    public PlayerSelection photourl(String... value) {
        addEquals(PlayerColumns.PHOTOURL, value);
        return this;
    }

    public PlayerSelection photourlNot(String... value) {
        addNotEquals(PlayerColumns.PHOTOURL, value);
        return this;
    }

    public PlayerSelection photourlLike(String... value) {
        addLike(PlayerColumns.PHOTOURL, value);
        return this;
    }

    public PlayerSelection name(String... value) {
        addEquals(PlayerColumns.NAME, value);
        return this;
    }

    public PlayerSelection nameNot(String... value) {
        addNotEquals(PlayerColumns.NAME, value);
        return this;
    }

    public PlayerSelection nameLike(String... value) {
        addLike(PlayerColumns.NAME, value);
        return this;
    }

    public PlayerSelection socialid(String... value) {
        addEquals(PlayerColumns.SOCIALID, value);
        return this;
    }

    public PlayerSelection socialidNot(String... value) {
        addNotEquals(PlayerColumns.SOCIALID, value);
        return this;
    }

    public PlayerSelection socialidLike(String... value) {
        addLike(PlayerColumns.SOCIALID, value);
        return this;
    }

    public PlayerSelection backendid(String... value) {
        addEquals(PlayerColumns.BACKENDID, value);
        return this;
    }

    public PlayerSelection backendidNot(String... value) {
        addNotEquals(PlayerColumns.BACKENDID, value);
        return this;
    }

    public PlayerSelection backendidLike(String... value) {
        addLike(PlayerColumns.BACKENDID, value);
        return this;
    }
}