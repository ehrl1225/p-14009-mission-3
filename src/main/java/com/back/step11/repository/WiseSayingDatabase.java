package com.back.step11.repository;

import com.back.step11.WiseSaying;

public class WiseSayingDatabase {
    FileManager fileManager;
    WiseSayingList wiseSayingList;

    public WiseSayingDatabase() {
        wiseSayingList = new WiseSayingList();
        fileManager = new FileManager();
    }

    public void close(){
        int lastId = wiseSayingList.getLastId();
        fileManager.saveLastId(lastId);
    }

    public int insertWiseSaying(WiseSaying wiseSaying){
        wiseSayingList.add(wiseSaying);
        fileManager.saveWiseSayingAsJson(wiseSaying);
        return wiseSaying.getId();
    }

    public WiseSayingList getWiseSayingList(){
        return wiseSayingList;
    }

    public void deleteWiseSaying(int id){
        wiseSayingList.removeWiseSayingById(id);
        fileManager.deleteWiseSayingJson(id);
    }

    public void updateWiseSaying(WiseSaying wiseSaying){
        WiseSaying db_wise_saying = wiseSayingList.getWiseSayingById(wiseSaying.getId());
        db_wise_saying.setData(wiseSaying);
        fileManager.saveWiseSayingAsJson(db_wise_saying);
    }

    public void buildWiseSayingList(){
        fileManager.saveWiseSayingsAsOneJson(wiseSayingList.iterator());
    }

    public void loadWiseSayingList(){
        wiseSayingList.clear();
        fileManager.loadJsonsAsWiseSayings(wiseSayingList);
    }

    public WiseSaying getWiseSaying(int id){
        return wiseSayingList.getWiseSayingById(id);
    }

}
