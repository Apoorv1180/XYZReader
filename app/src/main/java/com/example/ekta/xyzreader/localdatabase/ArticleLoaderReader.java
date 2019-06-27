package com.example.ekta.xyzreader.localdatabase;

import android.content.Context;
import android.content.CursorLoader;
import android.net.Uri;

public class ArticleLoaderReader extends CursorLoader {
    public static ArticleLoaderReader newAllArticlesInstance(Context context) {
        return new ArticleLoaderReader(context, ItemsContractField.Items.buildDirUri());
    }

    public static ArticleLoaderReader newInstanceForItemId(Context context, long itemId) {
        return new ArticleLoaderReader(context, ItemsContractField.Items.buildItemUri(itemId));
    }

    private ArticleLoaderReader(Context context, Uri uri) {
        super(context, uri, QueryforData.PROJECTION, null, null, ItemsContractField.Items.DEFAULT_SORT);
    }

    public interface QueryforData {
        String[] PROJECTION = {
                ItemsContractField.Items._ID,
                ItemsContractField.Items.TITLE,
                ItemsContractField.Items.PUBLISHED_DATE,
                ItemsContractField.Items.AUTHOR,
                ItemsContractField.Items.THUMB_URL,
                ItemsContractField.Items.PHOTO_URL,
                ItemsContractField.Items.ASPECT_RATIO,
                ItemsContractField.Items.BODY,
        };

        int _ID = 0;
        int TITLE = 1;
        int PUBLISHED_DATE = 2;
        int AUTHOR = 3;
        int THUMB_URL = 4;
        int PHOTO_URL = 5;
        int ASPECT_RATIO = 6;
        int BODY = 7;
    }
}
