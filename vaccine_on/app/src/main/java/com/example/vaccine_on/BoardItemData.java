package com.example.vaccine_on;

import java.util.ArrayList;

public class BoardItemData {
    public String postingDate;
    public String boardTitle;

    // 화면에 표시될 문자열 초기화
    public BoardItemData(String postingDate, String boardTitle) {
        this.postingDate = postingDate;
        this.boardTitle = boardTitle;
    }

    // 입력받은 숫자의 리스트생성
    public static ArrayList<BoardItemData> createContactsList(int numContacts) {
        ArrayList<BoardItemData> contacts = new ArrayList<BoardItemData>();

        for (int i = 1; i <= numContacts; i++) {
            contacts.add(new BoardItemData("2021-06-03", "아라동 근처 병원 추천해주세요!"));
        }

        return contacts;
    }
}
