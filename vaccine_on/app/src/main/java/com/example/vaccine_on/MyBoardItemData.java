package com.example.vaccine_on;

import java.util.ArrayList;

public class MyBoardItemData {
    public String postDate;
    public String postTitle;
    public String postId;

    // 문자열 초기화
    public MyBoardItemData(String postDate, String postTitle, String postId) {
        this.postDate = postDate;
        this.postTitle = postTitle;
        this.postId = postId;
    }

    public static ArrayList<MyBoardItemData> createContactList(int numContacts) {
        ArrayList<MyBoardItemData> contacts = new ArrayList<MyBoardItemData>();

        for (int i = 1; i <= numContacts; i++) {
            // contacts.add(new MyBoardItemData("날짜", "게시불 제목",));
        }
        return contacts;
    }
}
