/*
 * Copyright 2015 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
   -+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+ */

package it.rainbowbreeze.playtog.data.provider.base;

import java.util.Date;
import java.util.IdentityHashMap;

import android.database.Cursor;
import android.database.CursorWrapper;
import android.provider.BaseColumns;

public abstract class AbstractCursor extends CursorWrapper {
    private IdentityHashMap<String, Integer> mColumnIndexes = new IdentityHashMap<String, Integer>();

    public AbstractCursor(Cursor cursor) {
        super(cursor);
    }

    public long getId() {
        return getLongOrNull(BaseColumns._ID);
    }

    protected int getCachedColumnIndexOrThrow(String colName) {
        Integer index = mColumnIndexes.get(colName);
        if (index == null) {
            index = getColumnIndexOrThrow(colName);
            mColumnIndexes.put(colName, index);
        }
        return index;
    }

    public Integer getIntegerOrNull(String colName) {
        Integer index = getCachedColumnIndexOrThrow(colName);
        if (isNull(index)) return null;
        return getInt(index);
    }

    public Long getLongOrNull(String colName) {
        Integer index = getCachedColumnIndexOrThrow(colName);
        if (isNull(index)) return null;
        return getLong(index);
    }

    public Float getFloatOrNull(String colName) {
        Integer index = getCachedColumnIndexOrThrow(colName);
        if (isNull(index)) return null;
        return getFloat(index);
    }

    public Double getDoubleOrNull(String colName) {
        Integer index = getCachedColumnIndexOrThrow(colName);
        if (isNull(index)) return null;
        return getDouble(index);
    }

    public Boolean getBoolean(String colName) {
        Integer index = getCachedColumnIndexOrThrow(colName);
        if (isNull(index)) return null;
        return getInt(index) != 0;
    }

    public Date getDate(String colName) {
        Integer index = getCachedColumnIndexOrThrow(colName);
        if (isNull(index)) return null;
        return new Date(getLong(index));
    }
}
