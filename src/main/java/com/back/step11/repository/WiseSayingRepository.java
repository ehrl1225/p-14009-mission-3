package com.back.step11.repository;

import com.back.step11.WiseSaying;

public class WiseSayingRepository {
    WiseSayingDatabase database;

    public WiseSayingRepository() {
        database = new WiseSayingDatabase();
        database.loadWiseSayingList();
    }

    public void close(){
        database.close();
    }

    public int insertWiseSaying(WiseSaying wiseSaying) {
        return database.insertWiseSaying(wiseSaying);
    }

    public WiseSayingList showWiseSaying() {
        return database.getWiseSayingList();
    }

    public void deleteWiseSaying(int id) {
        database.deleteWiseSaying(id);
    }

    public void updateWiseSaying(WiseSaying wiseSaying) {
        database.updateWiseSaying(wiseSaying);
    }

    public void buildWiseSayingList() {
        database.buildWiseSayingList();
    }

    public WiseSaying getWiseSaying(int id) {
        return database.getWiseSaying(id);
    }

    public boolean hasWiseSaying(int id) {
        return database.getWiseSaying(id) != null;
    }

}
