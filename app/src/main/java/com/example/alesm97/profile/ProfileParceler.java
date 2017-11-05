package com.example.alesm97.profile;

import android.os.Parcel;
import android.os.Parcelable;

public class ProfileParceler implements Parcelable{

    int imgId;
    String name;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.imgId);
        dest.writeString(this.name);
    }

    protected ProfileParceler(Parcel in) {
        this.imgId = in.readInt();
        this.name = in.readString();
    }

    public static final Creator<ProfileParceler> CREATOR = new Creator<ProfileParceler>() {
        @Override
        public ProfileParceler createFromParcel(Parcel source) {
            return new ProfileParceler(source);
        }

        @Override
        public ProfileParceler[] newArray(int size) {
            return new ProfileParceler[size];
        }
    };
}
