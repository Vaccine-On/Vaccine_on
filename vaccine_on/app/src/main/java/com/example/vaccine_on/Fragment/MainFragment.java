package com.example.vaccine_on.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.vaccine_on.Adapter.HospInfoAdapter;
import com.example.vaccine_on.HospInfo;
import com.example.vaccine_on.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {

    EditText inputHosp;
    TextView hospName, hospAddr;
    ImageButton searchButton;
    HospInfo hospInfo; //이거 일단 한번도 안썼음, 객체(APITest에서는 item)
    ArrayList<HospInfo> itemArrayList = new ArrayList<HospInfo>();// 이거는 api받아온 데이터 아이템 하나하나 배열로 만들어 놓음
    ArrayList<HospInfo> itemViewArrayList = new ArrayList<HospInfo>();
    RecyclerView recyclerView;


    String key = "0GP9DsbCheBOEwNQR3fWFUfgU2xIhZN3AvV6Y6tjn87KZFeQ0T6m2JL9DvUdSjciSip%2FKkyhltgq9LTnqQytag%3D%3D"; //api신청 후 받은 key 값

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.fragment_main, container, false);

        //여기는 뭐하는지 모르겠고
        inputHosp = (EditText)rootview.findViewById(R.id.inputHosp);
        hospName = (TextView)rootview.findViewById(R.id.hospName);
        hospAddr = (TextView)rootview.findViewById(R.id.hospAddr);
        searchButton = (ImageButton)rootview.findViewById(R.id.searchButton);


        // 리사이클러뷰에 LinearLayoutManager 객체 지정.
        recyclerView = rootview.findViewById(R.id.hospList) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext())) ;

        HospInfoAdapter adapter = new HospInfoAdapter(itemArrayList);
        recyclerView.setAdapter(adapter);

        showList();

        return rootview;
    }

    void showList() {
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.searchButton: //button 클릭 시 (검색 버튼)
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                getXmlData(); //버튼 클릭시 파싱시작, 파싱내용 items에 객체 배열로 저장

                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {

                                        for(int i = 0; i<itemArrayList.size(); i++){
                                            Log.v("태그", i+" 번째 주소 : " + itemArrayList.get(i).hospitalAddr);
                                            Log.v("태그", i+" 번째 이름 : " + itemArrayList.get(i).hospitalName);
                                        }

                                        HospInfoAdapter adapter = new HospInfoAdapter(itemArrayList);
                                        recyclerView.setAdapter(adapter);

                                        for (int i=0; i<itemArrayList.size(); i++) {
                                            Log.v("??", "잘 되나?");
                                            itemViewArrayList.add(i, itemArrayList.get(i));
                                            Log.v("??", "잘 되나?");
                                            itemViewArrayList.add(i, hospInfo);

                                            itemViewArrayList.add(i, hospInfo);
                                        }
                                    }
                                });
                            }
                        }).start();
                        break;
                }
            }
        });
    }


    void getXmlData() {
        String hospitalName = null, hospitalAddr = null, hospitalXPos=null, hospitalYPos=null, hospitalPostNo=null,
                hospitalUrl=null, hospitalclCd=null, hospitalYkiho = null, hospitalTelNo = null, hospitalclCdNm = null, hospitalSidoCd = null,
                hospitalSdioCdNm = null, hospitalSgguCdNm = null;
        String str = inputHosp.getText().toString();

        String queryUrl = "http://apis.data.go.kr/B551182/hospInfoService/getHospBasisList?ServiceKey=" + key + "&emdongNm=" + str + "&pageNo=1";
        Log.v("태그", "url" + queryUrl);

        //파싱할때만 쓰이는 임시 items
        ArrayList<HospInfo> tmpItmes = new ArrayList<HospInfo>();
        try {
            URL url = new URL(queryUrl);
            InputStream is = url.openStream();

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new InputStreamReader(is, "UTF-8"));

            Log.v("태그", "api 전송후");

            xpp.next();
            int eventType = xpp.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tag;
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        break;
                    case XmlPullParser.START_TAG:

                        tag = xpp.getName();

                        if (tag.equals("item")) {
                            // 아이템 시작
                            hospitalName = null;
                            hospitalAddr = null;
                            hospitalXPos = null;
                            hospitalYPos = null;
                            hospitalPostNo = null;
                            hospitalUrl = null;
                            hospitalclCd = null;
                            hospitalYkiho = null;
                            hospitalTelNo = null;
                            hospitalclCdNm = null;
                            hospitalSidoCd = null;
                            hospitalSdioCdNm = null;
                            hospitalSgguCdNm = null;
                        }
                        else if (tag.equals("addr")) {
                            // 주소
                            xpp.next();
                            hospitalAddr = xpp.getText();
                            Log.v("태그", "주소 " + xpp.getText());
                        } else if (tag.equals("yadmNm")) {
                            // 병원명
                            xpp.next();
                            hospitalName = xpp.getText();
                        } else if (tag.equals("XPos")) {
                            // x좌표
                            xpp.next();
                            hospitalXPos = xpp.getText();
                        }
                        else if (tag.equals("YPos")) {
                            // y좌표
                            xpp.next();
                            hospitalYPos = xpp.getText();
                        }
                        else if (tag.equals("postNo")) {
                            // 우편번호
                            xpp.next();
                            hospitalPostNo = xpp.getText();
                        }
                        else if (tag.equals("hospUrl")) {
                            // 홈페이지
                            xpp.next();
                            hospitalUrl = xpp.getText();
                        }
                        else if (tag.equals("clCd")) {
                            // 종별코드
                            xpp.next();
                            hospitalclCd = xpp.getText();
                        }
                        else if (tag.equals("ykiho")) {
                            // 암호화된 요양기호
                            xpp.next();
                            hospitalYkiho = xpp.getText();
                        }
                        else if (tag.equals("telno")) {
                            // 전화번호
                            xpp.next();
                            hospitalTelNo = xpp.getText();
                        }
                        else if (tag.equals("clCdNm")) {
                            // 종별코드명
                            xpp.next();
                            hospitalclCdNm = xpp.getText();
                        }
                        else if (tag.equals("yadmNm")) {
                            // 병원명
                            xpp.next();
                            hospitalName = xpp.getText();
                        }
                        else if (tag.equals("sidoCd")) {
                            // 시도코드
                            xpp.next();
                            hospitalSidoCd = xpp.getText();
                        }
                        else if (tag.equals("sidoCdNm")) {
                            // 시도명
                            xpp.next();
                            hospitalSdioCdNm = xpp.getText();
                        }
                        else if (tag.equals("sgguCdNm")) {
                            // 시군구명
                            xpp.next();
                            hospitalSgguCdNm = xpp.getText();
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        tag = xpp.getName();
                        if (tag.equals("item")){
                            // 아이템 하나 끝
                            tmpItmes.add(new HospInfo(hospitalName, hospitalAddr, hospitalXPos, hospitalYPos,
                                    hospitalPostNo, hospitalUrl, hospitalclCd, hospitalYkiho, hospitalTelNo,
                                    hospitalclCdNm, hospitalSidoCd, hospitalSdioCdNm, hospitalSgguCdNm)); //api로 받아온 정보 객체로 저장. 이거를 itemArrayList에 저장.
                        }
                        break;
                }
                eventType = xpp.next();
            }

        } catch(Exception e){
            Log.v("태그", "e = " + e);
        }
        //임시 아이템을 items에게 넘겨줌
        itemArrayList = tmpItmes;
    }
}