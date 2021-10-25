package com.example.sampleparcelable;

import android.os.Parcel;
import android.os.Parcelable;
//Parcelable 인터페이스 : 메모리에 있는 객체를 그대로 보낼때 사용
public class SimpleData implements Parcelable {
    int number;
    String message;

    public SimpleData(int number, String message) {
        this.number = number;
        this.message = message;
    }

    public SimpleData(Parcel p) {
        number = p.readInt();
        message = p.readString();
    }

    @Override
    //writeToParcel = 객체가 가지고 있는 데이터를 Parcel 객체로 만들어주는 역할
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(number);
        dest.writeString(message);
    }

    @Override
    //describeContents = 직렬화하려는 객체의 유형을 구분할때 사용
    public int describeContents() {
        return 0;
    }


    public static final Creator<SimpleData> CREATOR = new Creator<SimpleData>() {
        @Override
        //Parcelable 클래스의 새 인스턴스를 만들고 이전에 데이터를 작성한 Parcel에서 인스턴스화
        public SimpleData createFromParcel(Parcel in) {
            return new SimpleData(in);
        }

        //Parcelable 클래스의 새 배열을 만듬
        @Override
        public SimpleData[] newArray(int size) {
            return new SimpleData[size];
        }
    };
}
