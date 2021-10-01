package com.example.fragmentslifecycle.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {
    private String name;
    private int clas;
    private int age;
    private float height;

    public Student(String name, int clas, int age, float height) {
        this.name = name;
        this.clas = clas;
        this.age = age;
        this.height = height;
    }

    protected Student(Parcel in) {
        name = in.readString();
        clas = in.readInt();
        age = in.readInt();
        height = in.readFloat();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    public String getName() {
        return name;
    }

    public int getClas() {
        return clas;
    }

    public int getAge() {
        return age;
    }

    public float getHeight() {
        return height;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(clas);
        parcel.writeInt(age);
        parcel.writeFloat(height);
    }
}
