package com.kpi.scineticle.model.subsystemOfDataBase.user;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.kpi.scineticle.model.subsystemOfDataBase.UserDatabase;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class UserRepository {
    private UserDao mUserDao;
    private LiveData<List<User>> allUsers;

    public UserRepository(Application application) {
        UserDatabase database = UserDatabase.getInstance(application);
        mUserDao = database.userDao();
        allUsers = mUserDao.getAllUsers();
    }

    public void insert(User user) {
        new InsertUserAsyncTask(mUserDao).execute(user);
    }

    public void update(User user) {
        new UpdateUserAsyncTask(mUserDao).execute(user);
    }

    public void delete(User user) {
        new DeleteUserAsyncTask(mUserDao).execute(user);
    }

    public void deleteAllUsers() {
        new DeleteAllUserAsyncTask(mUserDao).execute();
    }

    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    public User getUser(String email, String password) {
        User user = new User();
        AsyncTask task = new GetUserAsyncTask(mUserDao, email, password).execute();
        try {
            user = (User)task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

        return user;
    }

    private static class InsertUserAsyncTask extends AsyncTask<User, Void, Void> {
        private UserDao mUserDao;

        private InsertUserAsyncTask(UserDao userDao) {
            mUserDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            mUserDao.insert(users[0]);
            return null;
        }
    }

    private static class UpdateUserAsyncTask extends AsyncTask<User, Void, Void> {
        private UserDao mUserDao;

        public UpdateUserAsyncTask(UserDao userDao) {
            mUserDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            mUserDao.update(users[0]);
            return null;
        }
    }

    private static class DeleteUserAsyncTask extends AsyncTask<User, Void, Void> {
        private UserDao mUserDao;

        public DeleteUserAsyncTask(UserDao userDao) {
            mUserDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            mUserDao.delete(users[0]);
            return null;
        }
    }

    private static class DeleteAllUserAsyncTask extends AsyncTask<Void, Void, Void> {
        private UserDao mUserDao;

        public DeleteAllUserAsyncTask(UserDao userDao) {
            mUserDao = userDao;
        }


        @Override
        protected Void doInBackground(Void... voids) {
            mUserDao.deleteAll();
            return null;
        }
    }

    private static class GetUserAsyncTask extends AsyncTask<Void, Void, User> {
        private UserDao mUserDao;
        private String email;
        private String password;


        public GetUserAsyncTask(UserDao userDao, String email, String password) {
            this.email = email;
            this.password = password;
            mUserDao = userDao;

        }

        @Override
        protected User doInBackground(Void... voids) {
            return mUserDao.getUser(email, password);
        }

        @Override
        protected void onPostExecute(User user) {
            super.onPostExecute(user);
        }
    }
}
