package com.example.wudc;

public class Person {
    public int _id;
    public String name;
    public String picture;
    public String date;
    public String contents;
    public String impression;

    // set function
    public void setId(int _id){ this._id = _id; }
    public void setName(String name){ this.name = name; }
    public void setPicture(String picture){ this.picture = picture; }
    public void setDate(String date){ this.date = date; }
    public void setContents(String contents){ this.contents = contents; }
    public void setImpression(String impression){ this.impression = impression; }

    // get function
    public int getId(){ return this._id; }
    public String getName(){ return this.name; }
    public String getPicture(){ return this.picture; }
    public String getDate(){ return this.date; }
    public String getContents(){ return this.contents; }
    public String getImpression(){ return this.impression; }

}
