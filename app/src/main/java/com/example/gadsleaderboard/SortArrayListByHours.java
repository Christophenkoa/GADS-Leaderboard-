package com.example.gadsleaderboard;

import com.example.gadsleaderboard.models.LearnerHours;

import java.util.Collections;
import java.util.List;

import static java.lang.Integer.parseInt;

public class SortArrayListByHours {

    //Sort my list by hours
    public static List<LearnerHours> sortByHours(List<LearnerHours> list) {
        List<LearnerHours> tempList= Collections.emptyList();
        LearnerHours temp = new LearnerHours();
        int len = list.size();

        for(int j=0; j<len; j++) {
            for (int i = 0; i<list.size(); i++) {
                if(parseInt(list.get(i).getHours()) >= parseInt(temp.getHours())) {
                    temp = list.get(i);
                }
            }
            tempList.add(temp);
            list.remove(temp);
        }

        return tempList;
    }
}