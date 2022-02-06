# DAT153 Assignment 1 - Quiz App (Android)

Group no. 8

Storage: Local database, SQLite

To start of with some data: 

- Copy and past the code below into the "onCreate" method in MainActivity class 

  StudentDao db = new StudentDao(MainActivity.this);
        Student magnus = new Student("Magnus", R.drawable.magnus);
        Student frede = new Student("Frede", R.drawable.frede);
        Student even = new Student("Even", R.drawable.even);
        db.addStudent(even);
        db.addStudent(magnus);
        db.addStudent(frede);

Then run the app. 

Authors: Even Sleire, Magnus Gjøsund, Frede Berdal
