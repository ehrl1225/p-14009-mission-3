package com.back.step11;

import com.back.step11.repository.WiseSayingList;
import com.back.step11.repository.WiseSayingRepository;

public class WiseSayingService {
    WiseSayingRepository wiseSayingRepository;

    WiseSayingService() {
        this.wiseSayingRepository = new WiseSayingRepository();
    }

    public void close(){
        wiseSayingRepository.close();
    }

    public int insertWiseSaying(String content, String author) {
        WiseSaying wiseSaying = new WiseSaying(content, author);
        return wiseSayingRepository.insertWiseSaying(wiseSaying);
    }

    public WiseSayingList showWiseSayings(){
        return wiseSayingRepository.showWiseSaying();
    }

    public void deleteWiseSaying(int id) {
        wiseSayingRepository.deleteWiseSaying(id);
    }

    public void updateWiseSaying(int id, String content, String author) {
        WiseSaying wiseSaying = new WiseSaying(content, author);
        wiseSaying.setID(id);
        wiseSayingRepository.updateWiseSaying(wiseSaying);
    }

    public void buildWiseSayingList() {
        wiseSayingRepository.buildWiseSayingList();
    }

    public WiseSaying getWiseSaying(int id) {
        return wiseSayingRepository.getWiseSaying(id);
    }

    public boolean hasWiseSaying(int id) {
        return wiseSayingRepository.hasWiseSaying(id);
    }

}
