package com.kpi.scineticle.model.subsystemOfDataBase;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.kpi.scineticle.model.User;

@Database(entities = {User.class}, version = 5)
public abstract class UserDatabase extends RoomDatabase {

    private static UserDatabase instance;

    public abstract UserDao userDao();

    public static synchronized UserDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),  UserDatabase.class, "user_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback()  {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private UserDao mUserDao;

        private PopulateDbAsyncTask(UserDatabase database) {
            mUserDao = database.userDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mUserDao.insert(new User("Name 1", "Mail 1", "Phone 1", "LastName 1", "test123"));
            mUserDao.insert(new User("Name 2", "Mail 2", "Phone 2", "LastName 1", "test123"));
            mUserDao.insert(new User("Name 3", "Mail 3", "Phone 3", "LastName 1", "test123"));
            return null;
        }
    }
}